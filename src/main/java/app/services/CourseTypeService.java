package app.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CourseDTO;
import app.dto.CourseTypeDTO;
import app.dto.CreateCourseTypeDTO;
import app.jpa.Course;
import app.jpa.CourseType;
import app.repository.CourseRepository;
import app.repository.CourseTypeRepository;
import app.services.interfaces.ICourseTypeService;

@Service
public class CourseTypeService implements ICourseTypeService {

	@Autowired
	CourseTypeRepository courseTypeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<CourseTypeDTO> getAllCourseTypes() {
		List<CourseType> courseTypes = this.courseTypeRepository.findAll();
		List<CourseTypeDTO> dtos = new ArrayList<CourseTypeDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(CourseType type : courseTypes) {
			dtos.add(this.modelMapper.map(type, CourseTypeDTO.class));
        }
		return dtos;
	}

	@Override
	public CourseTypeDTO findCourseTypeById(Integer id) {
		CourseType courseType = this.courseTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course type with that ID does not exist!"));
        return this.modelMapper.map(courseType, CourseTypeDTO.class);

	}

	@Override
	public CourseTypeDTO createCourseType(CreateCourseTypeDTO newCourseType) {
		CourseType courseType = new CourseType();
		courseType.setName(newCourseType.getName());
		courseType.setNumberOfClasses(newCourseType.getNumberOfClasses());
		courseType.setPrice(newCourseType.getPrice());
		
		courseType = this.courseTypeRepository.save(courseType);
		return this.modelMapper.map(courseType, CourseTypeDTO.class); 
	}

	@Override
	public CourseTypeDTO updateCourseType(CourseTypeDTO courseTypeToUpdate) {
		CourseType courseType = this.courseTypeRepository.findById(courseTypeToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Course type with that ID does not exist!"));
		courseType = this.modelMapper.map(courseTypeToUpdate, CourseType.class);

		courseType = this.courseTypeRepository.save(courseType);

        return this.modelMapper.map(courseTypeToUpdate, CourseTypeDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.courseTypeRepository.deleteById(id);		
	}

}
