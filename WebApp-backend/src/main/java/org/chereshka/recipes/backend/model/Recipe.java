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

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Nutrient> ingredients;
	private List<Comments> comments;
	private List<Allergens> allergens;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AUTHOR_ID")
	private RecipeUser author;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;
	private Double servings;

	@Enumerated
	private Type type;
	private Category category;
	private Difficulty difficulty;
	private StarRating starRating;

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Photo getPhoto() {
		return photo;
	}

	public List<Allergens> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<Allergens> allergens) {
		this.allergens = allergens;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public StarRating getStarRating() {
		return starRating;
	}

	public void setStarRating(StarRating starRating) {
		this.starRating = starRating;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public Photo isPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Double getTimeToCookMinutes() {
		return timeToCookMinutes;
	}

	public void setTimeToCookMinutes(Double timeToCookMinutes) {
		this.timeToCookMinutes = timeToCookMinutes;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
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

	public RecipeUser getAuthor() {
		return this.author;
	}

	public void setAuthor(final RecipeUser author) {
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
