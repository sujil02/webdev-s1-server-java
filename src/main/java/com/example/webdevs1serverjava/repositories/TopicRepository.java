package com.example.webdevs1serverjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevs1serverjava.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
