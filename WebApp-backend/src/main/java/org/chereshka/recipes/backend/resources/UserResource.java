package org.chereshka.recipes.backend.resources;

import java.util.ArrayList;
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

import org.chereshka.recipes.backend.model.Person;
import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.persistence.PersonDao;
import org.chereshka.recipes.backend.persistence.UserDao;

@Path("/user")
public class UserResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getUserById(@PathParam("id") final Long id) {
		System.out.println(id);
		return new PersonDao().getById(id);
	}

	@GET
	@Path("{id}/favorites")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getFavoriteUserRecipes(@PathParam("id") final Long id){
		final Person person = new PersonDao().getById(id);
		return person.getFavorites();
	}

	@GET
	@PathParam("{id}/favorites/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getFavoriteUserRecipesByCategory(@PathParam("id") final Long id, @PathParam("category") final String category){
		final List<Recipe> recipesWithCategory = new ArrayList<>();
		final List<Recipe> favoriteUserRecipes = this.getFavoriteUserRecipes(id);
		for(final Recipe recipe : favoriteUserRecipes){
			if(recipe.getCategory().toString().equalsIgnoreCase(category)){
				recipesWithCategory.add(recipe);
			}
		}
		return recipesWithCategory;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(final Person user) {
		new UserDao().create(user);
		return Response.status(Status.CREATED).build();
	}
}
