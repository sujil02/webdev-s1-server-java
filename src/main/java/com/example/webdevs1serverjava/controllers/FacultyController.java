package com.example.webdevs1serverjava.controllers;
import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Faculty;
import com.example.webdevs1serverjava.repositories.CourseRepository;
import com.example.webdevs1serverjava.repositories.FacultyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    FacultyRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/faculty")
    public List<Faculty> findAllFaculty() {
        return (List<Faculty>)repository.findAll();
    }

    @PutMapping("/api/faculty/{fid}/authored/{cid}")
    public void authoredCourse(
            @PathVariable("fid") Long facultyId,
            @PathVariable("cid") Integer courseId) {
//        Faculty faculty = repository.findById(facultyId).get();
//        Course course = courseRepository.findById(courseId).get();
//        course.setAuthor(faculty);
//        courseRepository.save(course);
    }
}