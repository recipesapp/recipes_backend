package org.chereshka.recipes.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.chereshka.recipes.backend.persistence.JPAEntity;

@Entity
public class Person implements JPAEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String hashAuth;
	private String name;
	private Integer age;
	private Double height;
	private String userInfo;

	private Photo photo;

	@OneToMany(mappedBy = "favoritedBy")
	private List<Recipe> favorites;

	@OneToMany(mappedBy = "author")
	private List<Recipe> recipes;

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;


	public Photo getPhoto() {
		return this.photo;
	}

	public String getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(final String userInfo) {
		this.userInfo = userInfo;
	}

	public Photo isPhoto() {
		return this.photo;
	}

	public void setPhoto(final Photo photo) {
		this.photo = photo;
	}

	public List<Recipe> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(final List<Recipe> favorites) {
		this.favorites = favorites;
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
