package app.jpa;

import javax.persistence.*;
import java.util.*;

@Entity
public class Intensity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;
	
	@OneToMany(mappedBy="intensity")
	private List<CourseType> courseType;

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

}
