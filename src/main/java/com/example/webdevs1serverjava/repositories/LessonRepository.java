package com.example.webdevs1serverjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevs1serverjava.models.Course;

public interface LessonRepository extends CrudRepository<Course, Integer> {

}
