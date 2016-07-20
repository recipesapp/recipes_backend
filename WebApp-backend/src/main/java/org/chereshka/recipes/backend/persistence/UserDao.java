package org.chereshka.recipes.backend.persistence;

import org.chereshka.recipes.backend.model.Person;

public class UserDao extends BasicDao<Person> {

	public UserDao() {
		super(EntityManagerProvider.getInstance(), Person.class);
	}

}
