package app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CreateLanguageDTO;
import app.dto.LanguageDTO;
import app.jpa.Language;
import app.repository.LanguageRepository;
import app.services.interfaces.ILanguageService;

@Service
public class LanguageService implements ILanguageService{
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<LanguageDTO> getAllLanguages() {
		List<Language> languages = this.languageRepository.findAll();
		List<LanguageDTO> dtos = new ArrayList<LanguageDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Language language : languages) {
			dtos.add(this.modelMapper.map(language, LanguageDTO.class));
        }
		return dtos;
	}

	@Override
	public LanguageDTO findLanguageById(Integer id) {
		Language language = this.languageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Language with that ID does not exist!"));
        return this.modelMapper.map(language, LanguageDTO.class);
	
	}

	@Override
	public LanguageDTO createLanguage(CreateLanguageDTO newLanguage) {
		Language language = new Language();
		language.setLanguage(newLanguage.getLanguage());
		
		language = this.languageRepository.save(language);
		return this.modelMapper.map(language, LanguageDTO.class); 
	}

	@Override
	public LanguageDTO updateLanguage(LanguageDTO languageToUpdate) {
		Language language = this.languageRepository.findById(languageToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Intensity with that ID does not exist!"));
		language = this.modelMapper.map(languageToUpdate, Language.class);

		language = this.languageRepository.save(language);

        return this.modelMapper.map(languageToUpdate, LanguageDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.languageRepository.deleteById(id);			
	}

}
