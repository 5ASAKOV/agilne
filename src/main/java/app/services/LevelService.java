package app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CreateLevelDTO;
import app.dto.LevelDTO;
import app.jpa.Level;
import app.repository.LevelRepository;
import app.services.interfaces.ILevelService;

@Service
public class LevelService implements ILevelService {
	
	@Autowired
	LevelRepository levelRepository;
	
	@Autowired
	ModelMapper modelMapper;


	@Override
	public List<LevelDTO> getAllLevels() {
		List<Level> levels = this.levelRepository.findAll();
		List<LevelDTO> dtos = new ArrayList<LevelDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Level level : levels) {
			dtos.add(this.modelMapper.map(level, LevelDTO.class));
        }
		return dtos;
	}

	@Override
	public LevelDTO findLevelById(Integer id) {
		Level level = this.levelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Level with that ID does not exist!"));
        return this.modelMapper.map(level, LevelDTO.class);
	}

	@Override
	public LevelDTO createLevel(CreateLevelDTO newLevel) {
		Level level = new Level();
		level.setLabel(newLevel.getLabel());
		level.setDescription(newLevel.getDescription());
		
		level = this.levelRepository.save(level);
		return this.modelMapper.map(level, LevelDTO.class); 
	}

	@Override
	public LevelDTO updateLevel(LevelDTO levelToUpdate) {
		Level level = this.levelRepository.findById(levelToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Level with that ID does not exist!"));
		level = this.modelMapper.map(levelToUpdate, Level.class);

		level = this.levelRepository.save(level);

        return this.modelMapper.map(levelToUpdate, LevelDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.levelRepository.deleteById(id);				
		
	}

}
