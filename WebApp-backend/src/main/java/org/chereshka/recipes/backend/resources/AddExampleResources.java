package org.chereshka.recipes.backend.resources;

import java.util.Date;
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

	private List<Comments> comments = null;
	private Comments comment = null;

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

	private List<Allergens> allergens = null;
	private Allergens allergen = null;

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

	private List<Nutrient> nutrients = null;
	private Nutrient nutrient = null;

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

	private Recipe recipe = new Recipe();
	{
		recipe.setCategory(Category.MAIN);
		recipe.setDifficulty(Difficulty.INTERMEDIATE);
		recipe.setName("Musaka");
		recipe.setServings(21d);
		recipe.setTimeToCookMinutes(90d);
		recipe.setType(Type.VEGAN);
		recipe.setAllergens(allergens);
		RecipeUser recipeAuthorSlavi = new RecipeUser();
		recipeAuthorSlavi.setName("Slavi");
		recipe.setAuthor(recipeAuthorSlavi);
		recipe.setComments(comments);
		recipe.setDateAdded(new Date());
		recipe.setIngredients(nutrients);
		recipe.setInstructions("Ala bala");
		recipe.setStarRating(StarRating.TWO_STAR);
	}

	List<Recipe> favorites = null;
	{
		favorites.add(recipe);
	}

	private RecipeUser recipeUser = new RecipeUser();
	{
		recipeUser.setAge(15);
		recipeUser.setCategory(Category.DESSERT);
		recipeUser.setFavorites(favorites);
		recipeUser.setHashAuth("hashAuth");
		recipeUser.setHeight(150.50);
		recipeUser.setName("Gosho");
		recipeUser.setRecipes(favorites);
	}

	private User user = new User();
	{
		user.setAge(18);
		user.setHeight(19.35);
		user.setName("Vankata");
		user.setUserInfo("Az sum Ivan i sum moreplavatel");
		user.setDifficulty(Difficulty.INTERMEDIATE);
		user.setFavorites(favorites);
		user.setHashAuth("hashAuth");
		user.setRecipes(favorites);
	}

	@GET
	public void createRecipe() {
		new RecipesDao().create(recipe);
	}

	@GET
	public void createUserRecipe() {
		new RecipeUserDao().create(recipeUser);
	}

	@GET
	public void createUser() {
		new UserDao().create(user);
	}

}
