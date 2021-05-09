package app.repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface IntensityRepository extends JpaRepository<Intensity, Integer> {
	
	Collection<Intensity> findByNameContainingIgnoreCase(String name);

}