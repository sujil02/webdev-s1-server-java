package com.example.webdevs1serverjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevs1serverjava.models.Widget;

public interface TopicRepository extends CrudRepository<Widget, Long> {

}
