package com.wttechnologies.spring.web.dao;

public class Offer {

	// Properties
	private String name, email, text;
	private int id;

	public Offer() {
		// TODO Auto-generated constructor stub
	}
	

	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Offer [name=" + name + ", email=" + email + ", text=" + text + ", id=" + id + "]";
	}

}
