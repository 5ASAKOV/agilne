package app.dto;

import java.util.Date;

import app.jpa.CourseType;

public class CreateCourseDTO {
	
	private int capacity;
	private Date dateOfStart;
	private CourseType courseType;

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Date getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public CourseType getCourseType() {
		return courseType;
	}
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	

}
