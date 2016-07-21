package org.chereshka.recipes.backend.resources;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.chereshka.recipes.backend.model.Allergens;
import org.chereshka.recipes.backend.model.Category;
import org.chereshka.recipes.backend.model.Comment;
import org.chereshka.recipes.backend.model.Difficulty;
import org.chereshka.recipes.backend.model.Nutrient;
import org.chereshka.recipes.backend.model.Person;
import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.model.Type;
import org.chereshka.recipes.backend.persistence.PersonDao;
import org.chereshka.recipes.backend.persistence.RecipesDao;
import org.chereshka.recipes.backend.persistence.UserDao;

@Path("/test")
public class AddExampleResources {

	private List<Comment> comments() {
		final List<Comment> comments = new LinkedList<Comment>();
		Comment comment = null;
		{
			comment = new Comment();
			comment.setComments("Vkusna supa");
			comment.setDate(new Date());
			comment.setStarRating(3.5);
			final Person pesho = new Person();
			pesho.setName("Pesho");
			comment.setUser(pesho);
			comments.add(comment);
		}
		{
			comment = new Comment();
			comment.setComments("Vkusna mandja");
			comment.setDate(new Date());
			comment.setStarRating(1.5);
			final Person doncho = new Person();
			doncho.setName("Pesho");
			comment.setUser(doncho);
			comments.add(comment);
		}
		return comments;
	}

	private List<Allergens> allergens() {
		final List<Allergens> allergens = new LinkedList<Allergens>();
		Allergens allergen = null;
		{
			allergen = new Allergens();
			allergen.setName("Kislorod");
			allergens.add(allergen);
		}
		{
			allergen = new Allergens();
			allergen.setName("Kopriva");
			allergens.add(allergen);
		}
		return allergens;
	}

	private List<Nutrient> nutrients() {
		final List<Nutrient> nutrients = new LinkedList<Nutrient>();
		Nutrient nutrient = new Nutrient();
		{
			nutrient = new Nutrient();
			nutrient.setName("Mashterka");
			nutrients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Sol");
			nutrients.add(nutrient);
		}
		return nutrients;
	}

	private Recipe recipe() {
		final Recipe recipe = new Recipe();
		recipe.setCategory(Category.MAIN);
		recipe.setDifficulty(Difficulty.INTERMEDIATE);
		recipe.setName("Musaka");
		recipe.setServings(21d);
		recipe.setTimeToCookMinutes(90d);
		recipe.setType(Type.VEGAN);
		recipe.setAllergens(this.allergens());
		final Person recipeAuthorSlavi = new Person();
		recipeAuthorSlavi.setName("Slavi");
		recipe.setAuthor(recipeAuthorSlavi);
		recipe.setComments(this.comments());
		recipe.setDateAdded(new Date());
		recipe.setIngredients(this.nutrients());
		recipe.setInstructions("Ala bala");
		recipe.setStarRating(2.5);
		return recipe;
	}

	List<Recipe> favorites() {
		final List<Recipe> favorites = new LinkedList<Recipe>();
		favorites.add(this.recipe());
		return favorites;
	}

	private Person Person() {
		final Person Person = new Person();
		Person.setAge(15);
		Person.setFavorites(this.favorites());
		Person.setHashAuth("hashAuth");
		Person.setHeight(150.50);
		Person.setName("Gosho");
		Person.setRecipes(this.favorites());
		return Person;
	}

	private Person user() {
		final Person user = new Person();
		user.setAge(18);
		user.setHeight(19.35);
		user.setName("Vankata");
		user.setUserInfo("Az sum Ivan i sum moreplavatel");
		user.setFavorites(this.favorites());
		user.setHashAuth("hashAuth");
		user.setRecipes(this.favorites());
		return user;
	}

	@GET
	@Path("/createRecipe")
	public void createRecipe() {
		new RecipesDao().create(this.recipe());
	}

	@GET
	@Path("{Person}")
	public void createUserRecipe() {
		new PersonDao().create(this.Person());
	}

	@GET
	@Path("/createUser")
	public void createUser() {
		new UserDao().create(this.user());
	}

}
