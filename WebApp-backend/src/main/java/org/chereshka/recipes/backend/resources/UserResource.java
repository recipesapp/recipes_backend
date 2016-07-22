package org.chereshka.recipes.backend.resources;

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
import org.chereshka.recipes.backend.persistence.PersonDao;

@Path("/user")
public class UserResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getUserById(@PathParam("id") final Long id) {
		System.out.println(id);
		return new PersonDao().getById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(final Person user) {
		new PersonDao().create(user);
		return Response.status(Status.CREATED).build();
	}
}
