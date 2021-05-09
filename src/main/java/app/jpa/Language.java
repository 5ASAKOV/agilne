package app.jpa;

import javax.persistence.*;
import java.util.*;

@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String language;
	
	@OneToMany(mappedBy="language")
	private List<CourseType> courseType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
}
