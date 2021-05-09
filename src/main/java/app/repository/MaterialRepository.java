package app.repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface MaterialRepository extends JpaRepository<Material, Integer> {
	
	Collection<Material> findByPublisherContainingIgnoreCase(String publisher);
	Collection<Material> findByAuthorNameContainingIgnoreCase(String authorName);
	Collection<Material> findByAuthorSurnameContainingIgnoreCase(String authorSurname);
	Collection<Material> findByPublisherCityContainingIgnoreCase(String publisherCity);
}