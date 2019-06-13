package com.example.webdevs1serverjava.models;

import javax.persistence.Entity;

@Entity
public class ParagraphWidget extends Widget{
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public ParagraphWidget() {
		
	}
	
	public ParagraphWidget(Widget w, String text) {
		super(w);
		this.text = text;
	}
	
}
