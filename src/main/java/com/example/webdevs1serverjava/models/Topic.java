package com.example.webdevs1serverjava.models;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ManyToOne
	@JsonIgnore
	private Lesson lesson;
	
	@OneToMany(mappedBy="topic", orphanRemoval = true)
	private List<Widget> widgets = new ArrayList<Widget>(); 
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}
	
	public Lesson getLesson() {
		return this.lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
		if(!lesson.getTopics().contains(this)) {
			lesson.getTopics().add(this);
		}
	}
	
	public Topic() {
		
	}
	
	public Topic(Integer id, String title) {
		
		super();
		this.id = id;
		this.title = title;
	}
	
	public Topic(String string) {
		this.title = string;
	}

	public void widget(Widget w) {
		this.widgets.add(w);
		if(w.getTopic()!=this) {
			w.setTopic(this);
		}
	}
}
