package org.chereshka.recipes.backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.chereshka.recipes.backend.persistence.JPAEntity;

@Entity
public class Recipe implements JPAEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private List<Nutrient> ingredients;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTHOR_ID")
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;

	private Double servings;

	@Enumerated
	private Category category;

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Nutrient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(final List<Nutrient> ingredients) {
		this.ingredients = ingredients;
	}

	public User getAuthor() {
		return this.author;
	}

	public void setAuthor(final User author) {
		this.author = author;
	}

	public Double getServings() {
		return this.servings;
	}

	public void setServings(final Double servings) {
		this.servings = servings;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}
}
