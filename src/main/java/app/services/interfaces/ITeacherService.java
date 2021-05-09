package app.services.interfaces;

import java.util.List;
import app.dto.CreateTeacherDTO;
import app.dto.TeacherDTO;

public interface ITeacherService {

	public List<TeacherDTO> getAllTeachers();
	public TeacherDTO findTeacherById(Integer id);
	public TeacherDTO createTeacher(CreateTeacherDTO newTeacher);
	public TeacherDTO updateTeacher(TeacherDTO teacherToUpdate);
	public void delete(Integer id);
}
