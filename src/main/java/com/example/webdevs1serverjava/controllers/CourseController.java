package com.example.webdevs1serverjava.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Widget;
import com.example.webdevs1serverjava.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CourseController {
    @Autowired
    CourseRepository repository;

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return (List<Course>)repository.findAll();
    }
    @GetMapping("/api/courses/{CourseId}")
	public Course findWidgetById(@PathVariable("CourseId") Integer cid) {
		return  repository.findById(cid).get();
	}
    
	@PostMapping("/api/course")
	public Iterable<Course> createCourse(@RequestBody Course course) {
		repository.save(course);
		return findAllCourses();
	}
}