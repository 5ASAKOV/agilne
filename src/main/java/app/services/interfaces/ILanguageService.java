package app.services.interfaces;

import java.util.List;

import app.dto.CreateLanguageDTO;
import app.dto.LanguageDTO;

public interface ILanguageService {

	public List<LanguageDTO> getAllLanguages();
	public LanguageDTO findLanguageById(Integer id);
	public LanguageDTO createLanguage(CreateLanguageDTO newLanguage);
	public LanguageDTO updateLanguage(LanguageDTO languageToUpdate);
	public void delete(Integer id);
}
