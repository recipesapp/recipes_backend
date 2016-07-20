package org.chereshka.recipes.backend.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.chereshka.recipes.backend.model.Category;
import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.model.RecipeUser;
import org.chereshka.recipes.backend.model.Type;
import org.chereshka.recipes.backend.persistence.RecipeUserDao;

public class UserRecipeReadResource {

	@GET
	@Path("{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecipeUser getRecipeByCategory(
			@PathParam("category") final Category category) {
		return new RecipeUserDao().getByCategory(category);
	}

	@GET
	@Path("{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecipeUser getRecipeByType(@PathParam("type") final Type type) {
		return new RecipeUserDao().getByType(type);
	}

	@GET
	@Path("{favorites}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecipeUser getRecipeByFavourites(
			@PathParam("favorites") final List<Recipe> list) {
		return new RecipeUserDao().getByFavorites(list);
	}

}
