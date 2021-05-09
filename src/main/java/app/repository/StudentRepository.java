package app.repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Collection<Student> findByNameContainingIgnoreCase(String name);
	Collection<Student> findBySurnameContainingIgnoreCase(String surname);
	Collection<Student> findByGenderContainingIgnoreCase(String gender);
	Collection<Student> findByAddressContainingIgnoreCase(String address);
}