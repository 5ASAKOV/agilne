package app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CourseDTO;
import app.dto.CreateCourseDTO;
import app.jpa.Course;
import app.repository.CourseRepository;
import app.services.interfaces.ICourseService;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<CourseDTO> getAllCourses() {
		List<Course> courses = this.courseRepository.findAll();
		List<CourseDTO> dtos = new ArrayList<CourseDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Course course : courses) {
			dtos.add(this.modelMapper.map(course, CourseDTO.class));
        }
		return dtos;
	}

	@Override
	public CourseDTO findCourseById(Integer id) {
		Course course = this.courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course with that ID does not exist!"));
        return this.modelMapper.map(course, CourseDTO.class);
    }

	@Override
	public CourseDTO createCourse(CreateCourseDTO newCourse) {
		Course course = new Course();
		course.setCapacity(newCourse.getCapacity());
		course.setDateOfStart(newCourse.getDateOfStart());
		
		course = this.courseRepository.save(course);
		return this.modelMapper.map(course, CourseDTO.class); 
	}

	@Override
	public CourseDTO updateCourse(CourseDTO courseToUpdate) {
		Course course = this.courseRepository.findById(courseToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Course with that ID does not exist!"));
		course = this.modelMapper.map(courseToUpdate, Course.class);

		course = this.courseRepository.save(course);

        return this.modelMapper.map(course, CourseDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.courseRepository.deleteById(id);
	}

	@Override
	public List<CourseDTO> getCourseByCapacity(Integer capacity) {
		List<Course> courses = this.courseRepository.findByCapacity(capacity);
		List<CourseDTO> dtos = new ArrayList<CourseDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Course course : courses) {
			dtos.add(this.modelMapper.map(course, CourseDTO.class));
        }
		return dtos;
	}
	
	

}
