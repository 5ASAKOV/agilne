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

import app.services.CourseTypeService;
import app.dto.CourseTypeDTO;
import app.dto.CreateCourseTypeDTO;

@RestController
public class CourseTypeRestController {
	
	@Autowired
	private CourseTypeService courseTypeService;
	
	@GetMapping("courseType")
	public ResponseEntity<List<CourseTypeDTO>> getCourseTypes() {
        return new ResponseEntity<List<CourseTypeDTO>> (courseTypeService.getAllCourseTypes(), HttpStatus.OK);
	}
	
	
	@GetMapping("courseType/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<CourseTypeDTO> getCourseType(@PathVariable("id") Integer id) {
        return new ResponseEntity<CourseTypeDTO> (courseTypeService.findCourseTypeById(id), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("courseType")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<CourseTypeDTO> insertCourseType(@RequestBody CreateCourseTypeDTO newCourseType){
        return new ResponseEntity<CourseTypeDTO>( courseTypeService.createCourseType(newCourseType), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("courseType")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<CourseTypeDTO> upadateCourseType(@RequestBody CourseTypeDTO courseTypeToUpdate){
        return new ResponseEntity<CourseTypeDTO> (courseTypeService.updateCourseType(courseTypeToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("courseType/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<CourseTypeDTO> deleteCourseType(@PathVariable ("id") Integer id){
        this.courseTypeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}