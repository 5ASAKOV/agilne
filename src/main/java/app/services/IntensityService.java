package app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CourseTypeDTO;
import app.dto.CreateIntensityDTO;
import app.dto.IntensityDTO;
import app.jpa.CourseType;
import app.jpa.Intensity;
import app.repository.CourseTypeRepository;
import app.repository.IntensityRepository;
import app.services.interfaces.IIntensityService;

@Service
public class IntensityService implements IIntensityService {

	@Autowired
	IntensityRepository intensityRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<IntensityDTO> getAllIntensities() {
		List<Intensity> intensities = this.intensityRepository.findAll();
		List<IntensityDTO> dtos = new ArrayList<IntensityDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Intensity intensity : intensities) {
			dtos.add(this.modelMapper.map(intensity, IntensityDTO.class));
        }
		return dtos;
	}

	@Override
	public IntensityDTO findIntensityById(Integer id) {
		Intensity intensity = this.intensityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Intensity with that ID does not exist!"));
        return this.modelMapper.map(intensity, IntensityDTO.class);
	}

	@Override
	public IntensityDTO createIntensity(CreateIntensityDTO newIntensity) {
		Intensity intensity = new Intensity();
		intensity.setName(newIntensity.getName());
		
		intensity = this.intensityRepository.save(intensity);
		return this.modelMapper.map(intensity, IntensityDTO.class); 
	}

	@Override
	public IntensityDTO updateIntensity(IntensityDTO intensityToUpdate) {
		Intensity intsity = this.intensityRepository.findById(intensityToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Intensity with that ID does not exist!"));
		intsity = this.modelMapper.map(intensityToUpdate, Intensity.class);

		intsity = this.intensityRepository.save(intsity);

        return this.modelMapper.map(intensityToUpdate, IntensityDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.intensityRepository.deleteById(id);				
	}

}
