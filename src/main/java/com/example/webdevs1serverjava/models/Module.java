package com.example.webdevs1serverjava.models;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@OneToMany(mappedBy="module", fetch = FetchType.EAGER, orphanRemoval = true)
	List<Lesson> lessons = new ArrayList<Lesson>();
	
	@ManyToOne()
	@JsonIgnore
	private Course parentCourse;
	
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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Module() {
		
	}
	
	public Module(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public Module(String string) {
		// TODO Auto-generated constructor stub
		this.title = string;
	}

	public void setParentCourse(Course course) {
		this.parentCourse = course;
		if(!course.getModules().contains(this)) {
			course.getModules().add(this);
		}
	}
	
	public Course getParentCourse() {
		return this.parentCourse;
	}
	
	
}
