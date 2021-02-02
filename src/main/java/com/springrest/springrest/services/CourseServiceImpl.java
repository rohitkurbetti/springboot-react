package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list = null;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1,"Core java course","This course contains core java principles"));
//		list.add(new Course(2,"Advanced java course","This course contains advanced java principles"));
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
//		Course course = null;
//		for(Course obj : list) {
//			if(obj.getId() == courseId) {
//				course = obj;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}
	
	
	
	public Course updateCourse(Course course) {
//		for(Course itr : list) {
//			if(itr.getId() == course.getId()) {
//				//c.setId(course.getId());
//				itr.setTitle(course.getTitle());
//				itr.setDescription(course.getDescription());
//			}
//		}
		courseDao.save(course);
		return course;
	}
	
	public void deleteCourse(long courseId) {
		
//		for(Course itr : list) {
//			if(itr.getId() == courseId) {
//				c= itr;
//				list.remove(itr);
//				break;
//			}
//		}
//		list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
		Course course = courseDao.getOne(courseId);
		courseDao.delete(course);
	}
	
	
	
	
	
	
	
	
}
