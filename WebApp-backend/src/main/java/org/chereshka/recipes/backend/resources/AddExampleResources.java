package org.chereshka.recipes.backend.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.chereshka.recipes.backend.model.Category;
import org.chereshka.recipes.backend.model.Difficulty;
import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.model.RecipeUser;
import org.chereshka.recipes.backend.model.Type;
import org.chereshka.recipes.backend.model.User;
import org.chereshka.recipes.backend.persistence.RecipeUserDao;
import org.chereshka.recipes.backend.persistence.RecipesDao;
import org.chereshka.recipes.backend.persistence.UserDao;

public class AddExampleResources {

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRecipe() {
		final Recipe recipe = new Recipe();
		recipe.setCategory(Category.MAIN);
		recipe.setDifficulty(Difficulty.INTERMEDIATE);
		recipe.setName("Musaka");
		recipe.setServings(21d);
		recipe.setTimeToCookMinutes(90);
		recipe.setType(Type.VEGAN);
		new RecipesDao().create(recipe);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser() {
		final User user = new User();
		user.setAge(18);
		user.setHeight(19.35);
		user.setName("Vankata");
		user.setUserInfo("Az sum Ivan i sum moreplavatel");
		new UserDao().create(user);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRecipeUser() {
		final RecipeUser recipeUser = new RecipeUser();
		recipeUser.setAge(15);
		recipeUser.setCategory(Category.DESSERT);
		recipeUser.setHeight(150.50);
		recipeUser.setName("Gosho");
		new RecipeUserDao().create(recipeUser);
		return Response.status(Status.CREATED).build();
	}

}
