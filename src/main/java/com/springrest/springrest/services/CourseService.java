package com.springrest.springrest.services;

import java.util.List;
import java.util.Map;

import com.springrest.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long courseId);

	public List<Course> getCourses1(String searchStr);

}
