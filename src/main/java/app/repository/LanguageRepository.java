package app.repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import app.jpa.*;


public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	Collection<Language> findByLanguageContainingIgnoreCase(String language);

}