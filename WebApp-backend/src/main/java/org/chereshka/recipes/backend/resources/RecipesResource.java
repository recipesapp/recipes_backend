package org.chereshka.recipes.backend.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.chereshka.recipes.backend.model.Category;
import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.model.StarRating;
import org.chereshka.recipes.backend.model.Type;
import org.chereshka.recipes.backend.persistence.RecipesDao;

@Path("/recipes")
public class RecipesResource {

	//v dao
	@GET
	@Path("/limit")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getAllRecipes20() {
		List<Recipe> limitingToTwenty = new RecipesDao().getAll();
		if (limitingToTwenty.size() > 20) {
			limitingToTwenty = limitingToTwenty.subList(
					limitingToTwenty.size() - 20, limitingToTwenty.size());
		}
		return limitingToTwenty;
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
		final Recipe managedRecipe = new RecipesDao().create(recipe);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("{recipecategory}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeByCategory(
			@PathParam("recipecategory") final Category category) {
		return new RecipesDao().getByCategory(category);
	}

	@GET
	@Path("{recipetype}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeByCategory(@PathParam("recipetype") final Type type) {
		return new RecipesDao().getByType(type);
	}

	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeByName(@PathParam("name") final String name) {
		return new RecipesDao().getByName(name);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeById(@PathParam("id") final Long id) {
		return new RecipesDao().getById(id);
	}

	@GET
	@Path("{time}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeByTime(@PathParam("time") final Integer time) {
		return new RecipesDao().getByTime(time);
	}

	@GET
	@Path("{hasphoto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeById(@PathParam("hasphoto") final boolean photo) {
		return new RecipesDao().getByPhoto(photo);
	}

	@GET
	@Path("{rating}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeById(@PathParam("rating") final StarRating starRating) {
		return new RecipesDao().getByStarRating(starRating);
	}

}
