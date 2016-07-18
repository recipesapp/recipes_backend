package org.chereshka.recipes.backend.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.persistence.RecipesDao;

@Path("/recipes")
public class RecipesReadResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getAllRecipes(){
		return new RecipesDao().getAll();
	}
}
