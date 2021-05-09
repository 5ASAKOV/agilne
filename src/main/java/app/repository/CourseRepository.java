package app.repository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	List<Course> findByCapacity(Integer capacity);

}