package com.example.webdevs1serverjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Widget;
import com.example.webdevs1serverjava.repositories.CourseRepository;
import com.example.webdevs1serverjava.repositories.WidgetRepository;
import com.example.webdevs1serverjava.services.WidgetService;
import java.util.List;

@RestController
@CrossOrigin
public class WidgetController {
	private static WidgetService widgetService = new WidgetService();
	@Autowired
	WidgetRepository repository;

	@PostMapping("/api/widgets")
	public Iterable<Widget> createWidget(@RequestBody Widget widget) {
		repository.save(widget);
		return findAllWidgets();
	}

	@PutMapping("/api/widgets")
	public List<Widget> updateAllWidget(@RequestBody List<Widget> newWidgets) {
		return widgetService.updateAllWidget(newWidgets);
	}

	@GetMapping("/api/widgets")
	public Iterable<Widget> findAllWidgets() {
		// return widgetService.findAllWidgets();
		return repository.findAll();
	}

	@GetMapping("/api/widgets/{widgetId}")
	public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
		return widgetService.findWidgetById(wid);
	}

	@PutMapping("/api/widgets/{widgetId}")
	public List<Widget> updateWidget(@PathVariable("widgetId") long wid, @RequestBody Widget widget) {
		return widgetService.updateWidget(wid, widget);
	}

	@DeleteMapping("/api/widgets/{widgetId}")
	public List<Widget> deleteWidget(@PathVariable("widgetId") long wid) {
		return widgetService.deleteWidget(wid);
	}
}