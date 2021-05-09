package app.jpa;

import javax.persistence.*;
import java.util.*;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
    @Column (name = "capacity")
	private int capacity;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "date_of_start")
	private Date dateOfStart;
	
	@ManyToOne
	private CourseType courseType;
	
	
	//
	@ManyToMany
	private List<Student> students;
	
	@ManyToMany
	private List<Teacher> teachers;
	
	public int getId() {
		return this.id;
	}

	public int getCapacity() {
		return capacity;
	}

	public Date getDateOfStart() {
		return dateOfStart;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
