package com.example.webdevs1serverjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevs1serverjava.models.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {
}