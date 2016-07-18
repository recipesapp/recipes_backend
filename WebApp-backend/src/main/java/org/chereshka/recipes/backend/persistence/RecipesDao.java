package org.chereshka.recipes.backend.persistence;

import org.chereshka.recipes.backend.model.Recipe;

public class RecipesDao extends BasicDao<Recipe>{

	public RecipesDao() {
		super(EntityManagerProvider.getInstance(), Recipe.class);
	}

}
