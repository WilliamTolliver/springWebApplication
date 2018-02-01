package com.wttechnologies.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.wttechnologies.spring.web.validation.ValidEmail;

public class Offer {

	// Properties
	@Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
	private String name;
	@NotNull
	@ValidEmail
	private String email;
	@Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
	private String text;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [name=" + name + ", email=" + email + ", text=" + text + ", id=" + id + "]";
	}

}
