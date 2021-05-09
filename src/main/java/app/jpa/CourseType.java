package app.jpa;

import javax.persistence.*;
import java.util.*;

@Entity
public class CourseType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Integer numberOfClasses;
	
	@ManyToOne
	private Level level;
	
	@ManyToOne
	private Intensity intensity;
	
	@ManyToOne
	private Language language;
	
	@OneToMany(mappedBy="courseType")
	private List<Course> course;
	
	
	//
	@ManyToMany
	private List<Material> materials;
	
	@ManyToMany
	private List<Teacher> teachers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(Integer numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Intensity getIntensity() {
		return intensity;
	}

	public void setIntensity(Intensity intensity) {
		this.intensity = intensity;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
}
