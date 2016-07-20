package org.chereshka.recipes.backend.resources;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.chereshka.recipes.backend.model.Allergens;
import org.chereshka.recipes.backend.model.Category;
import org.chereshka.recipes.backend.model.Comments;
import org.chereshka.recipes.backend.model.Difficulty;
import org.chereshka.recipes.backend.model.Nutrient;
import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.model.RecipeUser;
import org.chereshka.recipes.backend.model.StarRating;
import org.chereshka.recipes.backend.model.Type;
import org.chereshka.recipes.backend.model.User;
import org.chereshka.recipes.backend.persistence.RecipeUserDao;
import org.chereshka.recipes.backend.persistence.RecipesDao;
import org.chereshka.recipes.backend.persistence.UserDao;

@Path("/test")
public class AddExampleResources {

	private List<Comments> comments() {
		List<Comments> comments = new LinkedList<Comments>();
		Comments comment = null;
		{
			comment = new Comments();
			comment.setComments("Vkusna supa");
			comment.setDate(new Date());
			comment.setStarRating(StarRating.FOUR_STAR);
			User pesho = new User();
			pesho.setName("Pesho");
			comment.setUser(pesho);
			comments.add(comment);
		}
		{
			comment = new Comments();
			comment.setComments("Vkusna mandja");
			comment.setDate(new Date());
			comment.setStarRating(StarRating.ONE_STAR);
			User doncho = new User();
			doncho.setName("Pesho");
			comment.setUser(doncho);
			comments.add(comment);
		}
		return comments;
	}

	private List<Allergens> allergens() {
		List<Allergens> allergens = new LinkedList<Allergens>();
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
		List<Nutrient> nutrients = new LinkedList<Nutrient>();
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
		Recipe recipe = new Recipe();
		recipe.setCategory(Category.MAIN);
		recipe.setDifficulty(Difficulty.INTERMEDIATE);
		recipe.setName("Musaka");
		recipe.setServings(21d);
		recipe.setTimeToCookMinutes(90d);
		recipe.setType(Type.VEGAN);
		recipe.setAllergens(allergens());
		RecipeUser recipeAuthorSlavi = new RecipeUser();
		recipeAuthorSlavi.setName("Slavi");
		recipe.setAuthor(recipeAuthorSlavi);
		recipe.setComments(comments());
		recipe.setDateAdded(new Date());
		recipe.setIngredients(nutrients());
		recipe.setInstructions("Ala bala");
		recipe.setStarRating(StarRating.TWO_STAR);
		return recipe;
	}

	List<Recipe> favorites() {
		List<Recipe> favorites = new LinkedList<Recipe>();
		favorites.add(recipe());
		return favorites;
	}

	private RecipeUser recipeUser() {
		RecipeUser recipeUser = new RecipeUser();
		recipeUser.setAge(15);
		recipeUser.setCategory(Category.DESSERT);
		recipeUser.setFavorites(favorites());
		recipeUser.setHashAuth("hashAuth");
		recipeUser.setHeight(150.50);
		recipeUser.setName("Gosho");
		recipeUser.setRecipes(favorites());
		return recipeUser;
	}

	private User user() {
		User user = new User();
		user.setAge(18);
		user.setHeight(19.35);
		user.setName("Vankata");
		user.setUserInfo("Az sum Ivan i sum moreplavatel");
		user.setDifficulty(Difficulty.INTERMEDIATE);
		user.setFavorites(favorites());
		user.setHashAuth("hashAuth");
		user.setRecipes(favorites());
		return user;
	}

	@GET
	public void createRecipe() {
		new RecipesDao().create(recipe());
	}

	@GET
	public void createUserRecipe() {
		new RecipeUserDao().create(recipeUser());
	}

	@GET
	public void createUser() {
		new UserDao().create(user());
	}

}
