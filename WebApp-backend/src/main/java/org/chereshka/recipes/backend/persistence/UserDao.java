package org.chereshka.recipes.backend.persistence;

import org.chereshka.recipes.backend.model.User;

public class UserDao extends BasicDao<User> {

	public UserDao() {
		super(EntityManagerProvider.getInstance(), User.class);
	}

}
