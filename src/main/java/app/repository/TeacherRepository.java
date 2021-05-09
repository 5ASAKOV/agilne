package app.repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	Collection<Teacher> findByNameContainingIgnoreCase(String name);
	Collection<Teacher> findBySurnameContainingIgnoreCase(String surname);
	Collection<Teacher> findByGenderContainingIgnoreCase(String gender);
	Collection<Teacher> findByAddressContainingIgnoreCase(String address);
	Collection<Teacher> findByDegreeContainingIgnoreCase(String degree);
}
