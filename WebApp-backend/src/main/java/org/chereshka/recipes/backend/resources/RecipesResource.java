package org.chereshka.recipes.backend.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.persistence.PersonDao;
import org.chereshka.recipes.backend.persistence.RecipesDao;

@Path("/recipes")
public class RecipesResource {

	//v dao
	@GET
	@Path("/limit/{limit}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getAllRecipes20(@PathParam("limit") final Integer limit) {
		return new RecipesDao().getWithLimit(limit);
	}

	@GET
	@Path("/allrecipes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getAllRecipes() {
		return new RecipesDao().getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(final Recipe recipe) {
		new RecipesDao().create(recipe);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("/favorites")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getFavoriteRecipesWithCategory(@QueryParam("userId") final Long userId, @QueryParam("category") final String category){
		final List<Recipe> recipesWithCategory = new ArrayList<>();
		final List<Recipe> favoriteUserRecipes = new PersonDao().getById(userId).getFavorites();
		if(category == null){
			return favoriteUserRecipes;
		}
		for (final Recipe recipe : favoriteUserRecipes) {
			if (recipe.getCategory().toString().equalsIgnoreCase(category)) {
				System.out.println(recipe.getCategory().toString());
				recipesWithCategory.add(recipe);
			}
		}
		return recipesWithCategory;
	}
}
