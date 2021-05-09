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

import app.services.MaterialService;
import app.dto.CreateMaterialDTO;
import app.dto.MaterialDTO;

@RestController
public class MaterialRestController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping("material")
	public ResponseEntity<List<MaterialDTO>> getMaterials() {
        return new ResponseEntity<List<MaterialDTO>> (materialService.getAllMaterials(), HttpStatus.OK);
	}
	
	
	@GetMapping("material/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<MaterialDTO> getMaterial(@PathVariable("id") Integer id) {
        return new ResponseEntity<MaterialDTO> (materialService.findMaterialById(id), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("material")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<MaterialDTO> insertMaterial(@RequestBody CreateMaterialDTO newMaterial){
        return new ResponseEntity<MaterialDTO>(materialService.createMaterial(newMaterial), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("material")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<MaterialDTO> upadateMaterial(@RequestBody MaterialDTO materialToUpdate){
        return new ResponseEntity<MaterialDTO> (materialService.updateMaterial(materialToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("material/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<MaterialDTO> deleteMaterial(@PathVariable ("id") Integer id){
        this.materialService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
