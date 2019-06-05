package com.example.webdevs1serverjava.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.webdevs1serverjava.model.Widget;
import com.example.webdevs1serverjava.model.Type;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class WidgetController {
	static List<Widget> widgets = new ArrayList<Widget>();
	static {
		widgets.add(new Widget(123L, "Widget 1", Type.HEADING));
		widgets.add(new Widget(234L, "Widget 2", Type.LINK));
		widgets.add(new Widget(345L, "Widget 3", Type.LIST));
		widgets.add(new Widget(456L, "Widget 4", Type.PARAGRAPH));
		widgets.add(new Widget(567L, "Widget 5", Type.IMAGE));
	}

	@PostMapping("/api/widgets")
	public List<Widget> createWidget(@RequestBody Widget widget) {
		widgets.add(widget);
		return widgets;
	}

	@GetMapping("/api/widgets")
	public List<Widget> findAllWidgets() {
		return widgets;
	}

	@GetMapping("/api/widgets/{widgetId}")
	public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
		for (Widget w : widgets) {
			if (w.getId().equals(wid))
				return w;
		}
		return null;
	}

	@PutMapping("/api/widgets/{widgetId}")
	public List<Widget> updateWidget(@PathVariable("widgetId") long wid, @RequestBody Widget widget) {
		for (Widget w : widgets) {
			if (w.getId().equals(wid)) {
				w.setType(widget.getType());
			}
		}
		return widgets;
	}

	@DeleteMapping("/api/widgets/{widgetId}")
	public List<Widget> deleteWidget(@PathVariable("widgetId") long wid) {
		for (Widget w : widgets) {
			if (w.getId()==(wid)) {
				widgets.remove(w);
				break;
			}
		}
		return widgets;
	}
}