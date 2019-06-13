package com.example.webdevs1serverjava.models;
import javax.persistence.Entity;

@Entity
public class LinkWidget extends Widget{
	private String href;
	private String title;
	
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
	
	public LinkWidget() {
		
	}
	
	public LinkWidget(Widget w, String href, String title) {
		super(w);
		this.href = href;
		this.title = title;
	}
}
