package app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CreateStudentDTO;
import app.dto.LevelDTO;
import app.dto.MaterialDTO;
import app.dto.StudentDTO;
import app.jpa.Level;
import app.jpa.Material;
import app.jpa.Student;
import app.repository.LevelRepository;
import app.repository.StudentRepository;
import app.services.interfaces.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students = this.studentRepository.findAll();
		List<StudentDTO> dtos = new ArrayList<StudentDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Student student : students) {
			dtos.add(this.modelMapper.map(student, StudentDTO.class));
        }
		return dtos;
	}

	@Override
	public StudentDTO findStudentById(Integer id) {
		Student student = this.studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with that ID does not exist!"));
        return this.modelMapper.map(student, StudentDTO.class);
	}

	@Override
	public StudentDTO createStudent(CreateStudentDTO newStudent) {
		Student student = new Student();
		student.setName(newStudent.getName());
		student.setSurname(newStudent.getSurname());
		student.setAddress(newStudent.getAddress());
		student.setDateOfBirth(newStudent.getDateOfBirth());
		student.setNumber(newStudent.getNumber());
		student.setEmail(newStudent.getEmail());
		student.setGender(newStudent.getGender());
		student.setActive(newStudent.getActive());
		
		student = this.studentRepository.save(student);
		return this.modelMapper.map(student, StudentDTO.class); 
	}

	@Override
	public StudentDTO updateStudent(StudentDTO studentToUpdate) {
		Student student = this.studentRepository.findById(studentToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Student with that ID does not exist!"));
		student = this.modelMapper.map(studentToUpdate, Student.class);

		student = this.studentRepository.save(student);

        return this.modelMapper.map(studentToUpdate, StudentDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.studentRepository.deleteById(id);				
		
	}

}
