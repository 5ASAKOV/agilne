package app.services.interfaces;

import java.util.List;
import app.dto.CreateStudentDTO;
import app.dto.StudentDTO;

public interface IStudentService {

	public List<StudentDTO> getAllStudents();
	public StudentDTO findStudentById(Integer id);
	public StudentDTO createStudent(CreateStudentDTO newStudent);
	public StudentDTO updateStudent(StudentDTO studentToUpdate);
	public void delete(Integer id);
}
