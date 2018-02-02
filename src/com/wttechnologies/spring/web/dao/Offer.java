package com.wttechnologies.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.wttechnologies.spring.web.validation.ValidEmail;

public class Offer {

	// Properties
	@Size(min = 5, max = 255, message = "Name must be between 5 and 100 characters")
	private String text;
	private int id;

	private User user;

	public Offer() {
		// TODO Auto-generated constructor stub
		this.user = new User();
	}

	public Offer(@Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters") String text, int id,
			User user) {
		this.text = text;
		this.id = id;
		this.user = user;
	}

	public Offer(User user, String text) {
		this.user = user;
		this.text = text;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		
		return this.user.getUsername();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [text=" + text + ", id=" + id + ", user=" + user + "]";
	}

}
