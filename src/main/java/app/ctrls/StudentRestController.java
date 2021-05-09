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

import app.services.StudentService;
import app.dto.CreateStudentDTO;
import app.dto.StudentDTO;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("student")
	public ResponseEntity<List<StudentDTO>> getStudents() {
        return new ResponseEntity<List<StudentDTO>> (studentService.getAllStudents(), HttpStatus.OK);
	}
	
	
	@GetMapping("student/{id}")
	//@ApiOperation(value = "Vraæa departman odrednjenog ID-a iz baze podataka")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Integer id) {
        return new ResponseEntity<StudentDTO> (studentService.findStudentById(id), HttpStatus.OK);
	}
	
	//ADD
	@PostMapping("student")
	//@ApiOperation(value = "Dodaje departman u bazu podataka")
	public ResponseEntity<StudentDTO> insertStudent(@RequestBody CreateStudentDTO newStudent){
        return new ResponseEntity<StudentDTO>(studentService.createStudent(newStudent), HttpStatus.CREATED);
	}
	
	//UPDATEE
	@PutMapping("student")
	//@ApiOperation(value = "Modifikacija")
	public ResponseEntity<StudentDTO> upadateStudent(@RequestBody StudentDTO studentToUpdate){
        return new ResponseEntity<StudentDTO> (studentService.updateStudent(studentToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping("student/{id}")
	//@ApiOperation(value = "Brisanje departmana iz baze podataka")
	public ResponseEntity<StudentDTO> deleteStudent(@PathVariable ("id") Integer id){
        this.studentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
