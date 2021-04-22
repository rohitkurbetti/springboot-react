package com.springrest.springrest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Users;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.UsersService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UsersService usersService;
	
	
	
	
	@GetMapping("/getData")
	public List<Course> getData() {
		List<Course> list = this.courseService.getCourses();
		return list;
	}
	
	@GetMapping("/house")
	public List<Course> getll() {
		List<Course> list = this.courseService.getCourses();
		return list;
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	//get course by specific id
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path="/courses", consumes="application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PostMapping(path="/regi", consumes="application/json")
	public Users addUser(@RequestBody Users user) {
		return this.usersService.addUsers(user);
	}
	
	@PostMapping(path="/login",consumes="application/json")
	public Users getUser(@RequestBody Users user) {
		return this.usersService.authUser(user);
	}
	
	@GetMapping(path="/user/{token}")
	public Users getUser(@PathVariable String token) {
		return this.usersService.validateUser(token);
	}
	
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);	
	}
	
	@GetMapping(path="/getUsers")
	public List<Users> getUsers(){
		return this.usersService.getUsers();
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}catch(Exception e) {	
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}