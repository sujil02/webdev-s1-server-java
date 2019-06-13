package com.example.webdevs1serverjava.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.example.webdevs1serverjava.models.Lesson;
import com.example.webdevs1serverjava.models.Module;
import com.example.webdevs1serverjava.models.Topic;
import com.example.webdevs1serverjava.models.User;
import com.example.webdevs1serverjava.repositories.CourseRepository;
import com.example.webdevs1serverjava.repositories.LessonRepository;
import com.example.webdevs1serverjava.repositories.ModuleRepository;
import com.example.webdevs1serverjava.repositories.TopicRepository;
import com.example.webdevs1serverjava.repositories.UserRepository;

@CrossOrigin(allowCredentials = "true")
@RestController
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

	@PostMapping("/api/courses")
	public Course createCourse(@RequestBody Course newCourse) {
		if (newCourse.getTitle().equals("")) {
			newCourse.setTitle("New Course");
		}
		Course course = courseRepository.save(newCourse);

		return course;

	}

}