package org.chereshka.recipes.backend.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import org.chereshka.recipes.backend.model.Recipe;

public class RecipesDao extends BasicDao<Recipe>{

	public RecipesDao() {
		super(EntityManagerProvider.getInstance(), Recipe.class);
	}

	public List<Recipe> getWithLimit(final Integer limit){
		final TypedQuery<Recipe> query = this.emProvider.get().createQuery("SELECT r FROM Recipe r", Recipe.class).setMaxResults(limit);
		return query.getResultList();
	}
}
