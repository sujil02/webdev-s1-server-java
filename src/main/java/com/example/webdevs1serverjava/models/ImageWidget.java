package com.example.webdevs1serverjava.models;

import javax.persistence.Entity;

@Entity
public class ImageWidget extends Widget{
	private String src;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	public ImageWidget() {
		
	}
	
	public ImageWidget(Widget w, String name, String type, String src) {
		super(w);
		this.src = src;
	}
}
