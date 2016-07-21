package org.chereshka.recipes.backend.persistence;

import org.chereshka.recipes.backend.model.Person;

public class PersonDao extends BasicDao<Person> {

	public PersonDao() {
		super(EntityManagerProvider.getInstance(), Person.class);
	}

}
