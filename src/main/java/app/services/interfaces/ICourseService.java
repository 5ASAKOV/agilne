package app.services.interfaces;

import java.util.List;

import app.dto.CourseDTO;
import app.dto.CreateCourseDTO;
import app.jpa.Course;

public interface ICourseService {
	
	public List<CourseDTO> getAllCourses();
	public CourseDTO findCourseById(Integer id);
	public List<CourseDTO> getCourseByCapacity(Integer capacity);
	public CourseDTO createCourse(CreateCourseDTO newCourse);
	public CourseDTO updateCourse(CourseDTO courseToUpdate);
	public void delete(Integer id);
	
	

}
