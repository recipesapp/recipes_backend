package org.chereshka.recipes.backend.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.persistence.RecipesDao;

@Path("/recipes")
public class RecipesReadResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getAllRecipes(){
		return new RecipesDao().getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(final Recipe recipe){
		final Recipe managedRecipe = new RecipesDao().create(recipe);
		return Response.status(Status.CREATED).build();
	}
}
