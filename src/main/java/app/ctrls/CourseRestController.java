package app.ctrls;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;*/

import app.repository.*;
import app.services.CourseService;
import app.dto.CourseDTO;
import app.dto.CreateCourseDTO;
import app.jpa.*;

@RestController
@CrossOrigin
//@Api(tags = {"Course CRUD operations"})

public class CourseRestController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("course")
	public ResponseEntity<List<CourseDTO>> getCourses() {
        return new ResponseEntity<List<CourseDTO>> (courseService.getAllCourses(), HttpStatus.OK);
	}
	
	
	@GetMapping("course/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("id") Integer id) {
        return new ResponseEntity<CourseDTO> (courseService.findCourseById(id), HttpStatus.OK);
	}
	
	@GetMapping("courseCapacity/{capacity}")
	//@ApiOperation(value = "Vraæa departman koji sadrzi prosledjeni string iz baze podataka")
	public ResponseEntity<List<CourseDTO>>  getCourseByCapacity(@PathVariable("capacity") Integer capacity) {
        return new ResponseEntity<List<CourseDTO>> (courseService.getCourseByCapacity(capacity), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("course")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<CourseDTO> insertCourse(@RequestBody CreateCourseDTO newCourse){
        return new ResponseEntity<CourseDTO>( courseService.createCourse(newCourse), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("course")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<CourseDTO> upadateCourse(@RequestBody CourseDTO courseToUpdate){
        return new ResponseEntity<CourseDTO> (courseService.updateCourse(courseToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("course/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<CourseDTO> deleteCourse(@PathVariable ("id") Integer id){
        this.courseService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
