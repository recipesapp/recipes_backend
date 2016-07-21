package org.chereshka.recipes.backend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.chereshka.recipes.backend.persistence.JPAEntity;

@Entity
public class Comment implements JPAEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Person user;
	private String comments;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private Double starRating;

	@ManyToOne
	private Recipe recipe;

	public Double getStarRating() {
		return this.starRating;
	}

	public void setStarRating(final Double starRating) {
		this.starRating = starRating;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}

	public Person getUser() {
		return this.user;
	}

	public void setUser(final Person user) {
		this.user = user;
	}

	@Override
	public Long getId() {
		return this.id;
	}

}
