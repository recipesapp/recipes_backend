package org.chereshka.recipes.backend.model;

import java.util.Date;

import javax.persistence.Enumerated;

public class Comments {

	private Person user;
	private String comments;
	private Date date;

	@Enumerated
	private StarRating starRating;

	public StarRating getStarRating() {
		return starRating;
	}

	public void setStarRating(StarRating starRating) {
		this.starRating = starRating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

}
