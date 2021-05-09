package app.services.interfaces;

import java.util.List;
import app.dto.CourseTypeDTO;
import app.dto.CreateCourseTypeDTO;

public interface ICourseTypeService {
	
	public List<CourseTypeDTO> getAllCourseTypes();
	public CourseTypeDTO findCourseTypeById(Integer id);
	public CourseTypeDTO createCourseType(CreateCourseTypeDTO newCourseType);
	public CourseTypeDTO updateCourseType(CourseTypeDTO courseTypeToUpdate);
	public void delete(Integer id);
	
}
