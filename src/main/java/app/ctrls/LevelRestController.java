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

import app.services.LevelService;
import app.dto.CreateLevelDTO;
import app.dto.LevelDTO;

@RestController
public class LevelRestController {
	
	@Autowired
	private LevelService levelService;
	
	@GetMapping("level")
	public ResponseEntity<List<LevelDTO>> getLevels() {
        return new ResponseEntity<List<LevelDTO>> (levelService.getAllLevels(), HttpStatus.OK);
	}
	
	
	@GetMapping("level/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<LevelDTO> getLevel(@PathVariable("id") Integer id) {
        return new ResponseEntity<LevelDTO> (levelService.findLevelById(id), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("level")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<LevelDTO> insertLevel(@RequestBody CreateLevelDTO newLevel){
        return new ResponseEntity<LevelDTO>(levelService.createLevel(newLevel), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("level")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<LevelDTO> upadateLevel(@RequestBody LevelDTO levelToUpdate){
        return new ResponseEntity<LevelDTO> (levelService.updateLevel(levelToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("level/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<LevelDTO> deleteLevel(@PathVariable ("id") Integer id){
        this.levelService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
