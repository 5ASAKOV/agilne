package app.repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface LevelRepository extends JpaRepository<Level, Integer> {
	
	Collection<Level> findByLabelContainingIgnoreCase(String label);

}