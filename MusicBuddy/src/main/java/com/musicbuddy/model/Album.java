package com.musicbuddy.model;

public class Album {
	// variables for Name and Title
	private String name;
	private String title;
	
	
	public Album(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
