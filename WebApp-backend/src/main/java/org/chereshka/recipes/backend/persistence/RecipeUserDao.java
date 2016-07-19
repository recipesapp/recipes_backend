package org.chereshka.recipes.backend.persistence;

import org.chereshka.recipes.backend.model.RecipeUser;

public class RecipeUserDao extends BasicDao<RecipeUser> {

	public RecipeUserDao() {
		super(EntityManagerProvider.getInstance(), RecipeUser.class);
	}

}
