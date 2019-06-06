package com.example.webdevs1serverjava.services;

import java.util.ArrayList;
import java.util.List;

import com.example.webdevs1serverjava.model.Type;
import com.example.webdevs1serverjava.model.Widget;

public class WidgetService {

	static List<Widget> widgets = new ArrayList<Widget>();
	static {
		widgets.add(new Widget(123L, "Widget 1", Type.HEADING, 0, "Heading One", "H1"));
		widgets.add(new Widget(234L, "Widget 2", Type.LINK, 5, "Link to gaana.com", "https://gaana.com/", ""));
		widgets.add(new Widget(345L, "Widget 3", Type.LIST, 100000, "This is list text", "This is list text", "UNORDERED"));
		widgets.add(new Widget(456L, "Widget 4", Type.PARAGRAPH, 3, "This is the paragraph text."));
		widgets.add(new Widget(567L, "Widget 5", Type.IMAGE, 7, "", "https://picsum.photos/300/200", ""));
	}

	public List<Widget> createWidget(Widget widget) {
		widgets.add(widget);
		return widgets;
	}

	public List<Widget> updateAllWidget(List<Widget> newWidgets) {
		widgets = newWidgets;
		return widgets;
	}

	public List<Widget> findAllWidgets() {
		return widgets;
	}

	public Widget findWidgetById(long wid) {
		for (Widget w : widgets) {
			if (w.getId()==(wid))
				return w;
		}
		return null;
	}

	public List<Widget> updateWidget(long wid, Widget widget) {
		for (Widget w : widgets) {
			if (w.getId()==(wid)) {
				w.setType(widget.getType());
			}
		}
		return widgets;
	}

	public List<Widget> deleteWidget(long wid) {
		for (Widget w : widgets) {
			if (w.getId() == (wid)) {
				widgets.remove(w);
				break;
			}
		}
		return widgets;
	}
}
