package com.example.webdevs1serverjava.models;

import javax.persistence.*;

@Entity
public class HeadingWidget extends Widget {
	private String text;
	private int size;
	
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
	
	public HeadingWidget() {
		
	}
	
	public HeadingWidget(Widget w, String text, Integer size) {
		super(w);
		this.text = text;
		this.size = size;
	}
	
	
}
