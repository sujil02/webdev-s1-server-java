package com.example.webdevs1serverjava.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Widget;
import com.example.webdevs1serverjava.repositories.CourseRepository;
import com.example.webdevs1serverjava.services.CourseService;


@RestController
@CrossOrigin("*")
public class CourseController {
    @Autowired
    CourseRepository repository;
    @Autowired
	private CourseService courseService;

    @GetMapping("/api/courses")
    public Iterable<Course> findAllCourses() {
    	return courseService.findAllCourses();
        
    }
    @GetMapping("/api/courses/{CourseId}")
	public Course findWidgetById(@PathVariable("CourseId") Integer cid) {
    	return courseService.findCourseById(cid);
		
	}
    
	@PostMapping("/api/courses")
	public Iterable<Course> createCourse(@RequestBody Course course) {
		repository.save(course);
		return findAllCourses();
	}
	
	@PutMapping("/api/courses/{courseId}")
	public Iterable<Course> updateCourse(@PathVariable("courseId") Integer cid, @RequestBody Course course) {
		courseService.updateCourse(cid, course);
		return findAllCourses();
	}
	
	@DeleteMapping("/api/courses/{courseId}")
	public Iterable<Course> deleteCourse(@PathVariable("courseId") Integer cid) {
		return courseService.deleteCourse(cid);
	}
}