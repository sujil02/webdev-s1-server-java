package com.example.webdevs1serverjava.services;

import java.util.ArrayList;
import java.util.List;

import com.example.webdevs1serverjava.models.Type;
import com.example.webdevs1serverjava.models.Widget;

public class WidgetService {
//	public Widget(long id, String name, Type type, String text, Integer size, String title, String href, Integer choice, String items, String src) {
	static List<Widget> widgets = new ArrayList<Widget>();
	static {
		widgets.add(new Widget(123, "Widget 1", Type.HEADING, "Heading One", 1, "heading 1","",0,"","",0));
		widgets.add(new Widget(234, "Widget 1", Type.LINK, "Link to gaana.com", 0, "Link to gaana.com","https://gaana.com/",0,"","",1));
		widgets.add(new Widget(345, "Widget 1", Type.LIST, "List One", 0, "List","",0,"","",2));
		widgets.add(new Widget(456, "Widget 1", Type.PARAGRAPH, "Paragraph One", 0, "Paragraph","",0,"","",3));
		widgets.add(new Widget(567, "Widget 1", Type.IMAGE, "Image One", 0, "heading 1","",0,"","https://picsum.photos/300/200",100000));
	}

	public List<Widget> createWidget(Widget widget) {
		int maxOrderNow = 0;
		for(Widget w:widgets) {
			if(w.getWidgetOrder() != 100000 && w.getWidgetOrder()>maxOrderNow) {
				maxOrderNow = w.getWidgetOrder();			}
		}
		widgets.get(widgets.size()-1).setWidgetOrder(maxOrderNow+1);
		widget.setWidgetOrder(100000);
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
		widgets.get(widgets.size()-1).setWidgetOrder(100000);
		return widgets;
	}
}
