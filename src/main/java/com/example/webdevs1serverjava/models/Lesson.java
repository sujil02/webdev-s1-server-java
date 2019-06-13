package com.example.webdevs1serverjava.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lesson {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ManyToOne
	@JsonIgnore
	private Module module;
	
	@OneToMany(mappedBy="lesson", orphanRemoval = true)
	List<Topic> topics = new ArrayList<Topic>();
	
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

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}


	


	public Module getModule() {
		return this.module;
	}
	
	
	
}
