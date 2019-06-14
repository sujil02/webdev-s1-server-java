package com.example.webdevs1serverjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Topic;
import com.example.webdevs1serverjava.models.Widget;
import com.example.webdevs1serverjava.repositories.TopicRepository;
import com.example.webdevs1serverjava.repositories.WidgetRepository;
import com.example.webdevs1serverjava.services.WidgetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class WidgetTopicController {
	@Autowired
	TopicRepository repository;
	@Autowired
	WidgetRepository widgetRepository;

	@PostMapping("/api/topic/{tid}/widgets")
	public Iterable<Widget> createWidget(@PathVariable("tid") Integer topicId,@RequestBody Widget widget) {
		
		Topic topic = repository.findById(topicId).get();
		if(topic!=null) {
			widget.setTopic(topic);
			widgetRepository.save(widget);
			repository.save(topic);
			return findAllWidgets(topicId);
		}
		return null;
	}


	@GetMapping("/api/topic/{tid}/widgets")
	public Iterable<Widget> findAllWidgets(@PathVariable("tid") Integer topicId) {
		return repository.findById(topicId).get().getWidgets();
	}
	@PutMapping("/api/topic/{tid}/widgets")
	public Iterable<Widget> updateAllWidget(@PathVariable("tid") Integer topicId,@RequestBody List<Widget> newWidgets) {
		Topic topic = repository.findById(topicId).get();
		for(Widget w : newWidgets) {
			w.setTopic(topic);
		}
		return widgetRepository.saveAll(newWidgets);
	}
}