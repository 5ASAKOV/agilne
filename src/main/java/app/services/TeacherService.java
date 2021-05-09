package app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CreateTeacherDTO;
import app.dto.LevelDTO;
import app.dto.StudentDTO;
import app.dto.TeacherDTO;
import app.jpa.Level;
import app.jpa.Student;
import app.jpa.Teacher;
import app.repository.TeacherRepository;
import app.services.interfaces.ITeacherService;

@Service
public class TeacherService implements ITeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<TeacherDTO> getAllTeachers() {
		List<Teacher> teachers = this.teacherRepository.findAll();
		List<TeacherDTO> dtos = new ArrayList<TeacherDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Teacher teacher : teachers) {
			dtos.add(this.modelMapper.map(teacher, TeacherDTO.class));
        }
		return dtos;
	}

	@Override
	public TeacherDTO findTeacherById(Integer id) {
		Teacher teacher = this.teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Teacher with that ID does not exist!"));
        return this.modelMapper.map(teacher, TeacherDTO.class);
	}

	@Override
	public TeacherDTO createTeacher(CreateTeacherDTO newTeacher) {
		Teacher teacher = new Teacher();
		
		teacher.setName(newTeacher.getName());
		teacher.setSurname(newTeacher.getSurname());
		teacher.setAddress(newTeacher.getAddress());
		teacher.setDateOfBirth(newTeacher.getDateOfBirth());
		teacher.setNumber(newTeacher.getNumber());
		teacher.setEmail(newTeacher.getEmail());
		teacher.setGender(newTeacher.getGender());
		teacher.setActive(newTeacher.getActive());
		teacher.setDegree(newTeacher.getDegree());
		teacher.setJmbg(newTeacher.getJmbg());
		
		teacher = this.teacherRepository.save(teacher);
		return this.modelMapper.map(teacher, TeacherDTO.class); 
	}

	@Override
	public TeacherDTO updateTeacher(TeacherDTO teacherToUpdate) {
		Teacher teacher = this.teacherRepository.findById(teacherToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Teacher with that ID does not exist!"));
		teacher = this.modelMapper.map(teacherToUpdate, Teacher.class);

		teacher = this.teacherRepository.save(teacher);

        return this.modelMapper.map(teacherToUpdate, TeacherDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.teacherRepository.deleteById(id);				
		
	}

}
