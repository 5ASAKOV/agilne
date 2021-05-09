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

import app.services.IntensityService;
import app.dto.CreateIntensityDTO;
import app.dto.IntensityDTO;

@RestController
public class IntensityRestController {
	
	@Autowired
	private IntensityService intensityService;
	
	@GetMapping("intensity")
	public ResponseEntity<List<IntensityDTO>> getIntensities() {
        return new ResponseEntity<List<IntensityDTO>> (intensityService.getAllIntensities(), HttpStatus.OK);
	}
	
	
	@GetMapping("intensity/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<IntensityDTO> getIntensity(@PathVariable("id") Integer id) {
        return new ResponseEntity<IntensityDTO> (intensityService.findIntensityById(id), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("intensity")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<IntensityDTO> insertIntensity(@RequestBody CreateIntensityDTO newIntensity){
        return new ResponseEntity<IntensityDTO>(intensityService.createIntensity(newIntensity), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("intensity")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<IntensityDTO> upadateIntensity(@RequestBody IntensityDTO intensityToUpdate){
        return new ResponseEntity<IntensityDTO> (intensityService.updateIntensity(intensityToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("intensity/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<IntensityDTO> deleteIntensity(@PathVariable ("id") Integer id){
        this.intensityService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
