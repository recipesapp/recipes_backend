package org.chereshka.recipes.backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.chereshka.recipes.backend.persistence.JPAEntity;

@Entity
public class Recipe implements JPAEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private Double timeToCookMinutes;
	private Photo photo;
	private String instructions;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "recipe")
	private List<Nutrient> ingredients;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "recipe")
	private List<Comment> comments;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "recipe")
	private List<Allergens> allergens;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AUTHOR_ID")
	private Person author;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FAVORITED_PERSON_ID")
	private Person favoritedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;
	private Double servings;

	@Enumerated
	private Type type;
	@Enumerated
	private Category category;
	@Enumerated
	private Difficulty difficulty;
	private Double starRating;

	public String getInstructions() {
		return this.instructions;
	}

	public void setInstructions(final String instructions) {
		this.instructions = instructions;
	}

	public Photo getPhoto() {
		return this.photo;
	}

	public List<Allergens> getAllergens() {
		return this.allergens;
	}

	public void setAllergens(final List<Allergens> allergens) {
		this.allergens = allergens;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(final Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Double getStarRating() {
		return this.starRating;
	}

	public void setStarRating(final Double starRating) {
		this.starRating = starRating;
	}

	public void setComments(final List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public Photo isPhoto() {
		return this.photo;
	}

	public void setPhoto(final Photo photo) {
		this.photo = photo;
	}

	public Double getTimeToCookMinutes() {
		return this.timeToCookMinutes;
	}

	public void setTimeToCookMinutes(final Double timeToCookMinutes) {
		this.timeToCookMinutes = timeToCookMinutes;
	}

	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(final Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(final Type type) {
		this.type = type;
	}

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

	public Person getAuthor() {
		return this.author;
	}

	public void setAuthor(final Person author) {
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
