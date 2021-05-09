package app.dto;

import javax.persistence.ManyToOne;

import app.jpa.Intensity;
import app.jpa.Language;
import app.jpa.Level;

public class CourseTypeDTO {
	
	private Integer id;
	private String name;
	private Double price;
	private Integer numberOfClasses;
	private Level level;
	private Intensity intensity;
	private Language language;
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
