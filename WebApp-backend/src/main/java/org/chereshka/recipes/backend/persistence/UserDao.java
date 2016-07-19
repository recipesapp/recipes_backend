package org.chereshka.recipes.backend.persistence;

import org.chereshka.recipes.backend.model.RecipeUser;

public class UserDao extends BasicDao<RecipeUser> {

	public UserDao() {
		super(EntityManagerProvider.getInstance(), RecipeUser.class);
	}
}
