package com.example.webdevs1serverjava.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.webdevs1serverjava.model.Widget;
import com.example.webdevs1serverjava.services.WidgetService;
import java.util.List;

@RestController
@CrossOrigin
public class WidgetController {
	private static WidgetService widgetService = new WidgetService();

	@PostMapping("/api/widgets")
	public List<Widget> createWidget(@RequestBody Widget widget) {
		return widgetService.createWidget(widget);
	}

	@PutMapping("/api/widgets")
	public List<Widget> updateAllWidget(@RequestBody List<Widget> newWidgets) {
		return widgetService.updateAllWidget(newWidgets);
	}

	@GetMapping("/api/widgets")
	public List<Widget> findAllWidgets() {
		return widgetService.findAllWidgets();
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