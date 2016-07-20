package org.chereshka.recipes.backend.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RecipesApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		final Set<Object> resources = new HashSet<>();
		resources.add(new JacksonJsonProvider());
		resources.add(new RecipesResource());
		resources.add(new UserRecipeReadResource());
		resources.add(new UserResource());
		resources.add(new AddExampleResources().createRecipe());
		resources.add(new AddExampleResources().createRecipeUser());
		resources.add(new AddExampleResources().createUser());
		return resources;
	}
}
