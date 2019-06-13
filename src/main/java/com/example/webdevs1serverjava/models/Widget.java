package com.example.webdevs1serverjava.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Type type;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer widgetOrder;

	// Heading Widget & Para widget
	private String text;
	private Integer size;

	// Image Widget
	private String src;

	// Link Widget
	private String href;
	private String title;

	// ListWidget
	private Integer choice;
	private String items;

	@ManyToOne
	@JsonIgnore
	private Topic topic;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Widget() {

	}

	public Widget(long id, String name, Type type, String text, Integer size, String title, String href, Integer choice,
			String items, String src, int order) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.text = text;
		this.size = size;
		this.title = title;
		this.choice = choice;
		this.items = items;
		this.href = href;
		this.src = src;
		this.widgetOrder = order;
	}

	public Widget(Widget w) {
		this.id = w.getId();
		this.name = w.getName();
		this.type = w.getType();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getChoice() {
		return choice;
	}

	public void setChoice(Integer choice) {
		this.choice = choice;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	/**
	 * @return the widgetOrder
	 */
	public Integer getWidgetOrder() {
		return widgetOrder;
	}

	/**
	 * @param widgetOrder the widgetOrder to set
	 */
	public void setWidgetOrder(Integer widgetOrder) {
		this.widgetOrder = widgetOrder;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
