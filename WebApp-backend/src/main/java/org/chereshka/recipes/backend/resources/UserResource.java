package org.chereshka.recipes.backend.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.chereshka.recipes.backend.model.RecipeUser;
import org.chereshka.recipes.backend.model.User;
import org.chereshka.recipes.backend.persistence.RecipeUserDao;
import org.chereshka.recipes.backend.persistence.UserDao;

@Path("/user")
public class UserResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecipeUser getUserById(@PathParam("id") final Long id) {
		return new RecipeUserDao().getById(id);
	}

	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByName(@PathParam("name") final String name) {
		return new UserDao().getByName(name);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(final User user) {
		final User createUser = new UserDao().create(user);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByHashAuth(@PathParam("password") final String hashAuth) {
		return new UserDao().getByName(hashAuth);
	}

}
