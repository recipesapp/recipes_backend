package org.chereshka.recipes.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.chereshka.recipes.backend.persistence.JPAEntity;

@Entity
public class RecipeUser implements JPAEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String hashAuth;
	private String name;
	private Integer age;
	private Double height;

	// mappedBy ??
	@OneToMany
	private List<Recipe> favorites;

	@OneToMany(mappedBy = "author")
	private List<Recipe> recipes;

	@Enumerated
	private Category category;

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public List<Recipe> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Recipe> favorites) {
		this.favorites = favorites;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(final Double height) {
		this.height = height;
	}

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(final List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public String getHashAuth() {
		return this.hashAuth;
	}

	public void setHashAuth(final String hashAuth) {
		this.hashAuth = hashAuth;
	}
}
