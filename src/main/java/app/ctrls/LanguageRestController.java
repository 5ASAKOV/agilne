package app.ctrls;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;*/

import app.services.LanguageService;
import app.dto.CreateLanguageDTO;
import app.dto.LanguageDTO;

@RestController
public class LanguageRestController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("language")
	public ResponseEntity<List<LanguageDTO>> getLanguages() {
        return new ResponseEntity<List<LanguageDTO>> (languageService.getAllLanguages(), HttpStatus.OK);
	}
	
	
	@GetMapping("language/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<LanguageDTO> getLanguage(@PathVariable("id") Integer id) {
        return new ResponseEntity<LanguageDTO> (languageService.findLanguageById(id), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("language")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<LanguageDTO> insertLanguage(@RequestBody CreateLanguageDTO newLanguage){
        return new ResponseEntity<LanguageDTO>(languageService.createLanguage(newLanguage), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("language")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<LanguageDTO> upadateLanguage(@RequestBody LanguageDTO languageToUpdate){
        return new ResponseEntity<LanguageDTO> (languageService.updateLanguage(languageToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("language/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<LanguageDTO> deleteLanguage(@PathVariable ("id") Integer id){
        this.languageService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
