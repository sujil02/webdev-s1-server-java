package com.example.webdevs1serverjava.models;
import javax.persistence.Entity;

@Entity
public class ListWidget extends Widget{
	private Integer choice;
	private String items;
	
	public Integer getChoice() {
		return choice;
	}
	public void setOption(Integer choice) {
		this.choice = choice;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}	
	
	public ListWidget(){
		
	}
	
	public ListWidget(Widget w, Integer choice, String items){
		super(w);
		this.choice = choice;
		this.items = items;
	}
}