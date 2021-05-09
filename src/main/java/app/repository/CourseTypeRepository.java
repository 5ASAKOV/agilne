package app.repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface CourseTypeRepository extends JpaRepository<CourseType, Integer> {
	
	Collection<CourseType> findByNameContainingIgnoreCase(String name);
	Collection<CourseType> findByPrice(Double price);
	Collection<CourseType> findByNumberOfClasses(Integer number);

}