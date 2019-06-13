package com.example.webdevs1serverjava.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Widget;
import com.example.webdevs1serverjava.repositories.CourseRepository;
import com.example.webdevs1serverjava.repositories.LessonRepository;
import com.example.webdevs1serverjava.repositories.ModuleRepository;
import com.example.webdevs1serverjava.repositories.TopicRepository;
import com.example.webdevs1serverjava.repositories.UserRepository;

@RestController
@CrossOrigin("*")
public class CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	TopicRepository topicRepository;

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService = new UserService();

	public Iterable<Course> updateCourse(Integer cid, Course newCourse) {
		Course course = findById(cid);
		course.setTitle(newCourse.getTitle());
		courseRepository.save(course);
		return findAllCourses();
	}

	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll();
	}

	public Course findById(Integer cid) {
		return  courseRepository.findById(cid).get();
	}



	public Iterable<Course> deleteCourse(Integer cid) {
		
		 courseRepository.deleteById(cid);
		 return findAllCourses();
	}


}