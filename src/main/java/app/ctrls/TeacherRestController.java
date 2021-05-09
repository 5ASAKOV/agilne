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

import app.services.TeacherService;
import app.dto.CreateTeacherDTO;
import app.dto.TeacherDTO;

@RestController
public class TeacherRestController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("teacher")
	public ResponseEntity<List<TeacherDTO>> getTeachers() {
        return new ResponseEntity<List<TeacherDTO>> (teacherService.getAllTeachers(), HttpStatus.OK);
	}
	
	
	@GetMapping("teacher/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<TeacherDTO> getTeacher(@PathVariable("id") Integer id) {
        return new ResponseEntity<TeacherDTO> (teacherService.findTeacherById(id), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("teacher")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<TeacherDTO> insertTeacher(@RequestBody CreateTeacherDTO newTeacher){
        return new ResponseEntity<TeacherDTO>(teacherService.createTeacher(newTeacher), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("teacher")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<TeacherDTO> upadateTeacher(@RequestBody TeacherDTO teacherToUpdate){
        return new ResponseEntity<TeacherDTO> (teacherService.updateTeacher(teacherToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("teacher/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<TeacherDTO> deleteTeacher(@PathVariable ("id") Integer id){
        this.teacherService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
