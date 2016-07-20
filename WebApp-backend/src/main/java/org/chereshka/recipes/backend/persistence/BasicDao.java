package org.chereshka.recipes.backend.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.chereshka.recipes.backend.model.Category;
import org.chereshka.recipes.backend.model.Difficulty;
import org.chereshka.recipes.backend.model.StarRating;
import org.chereshka.recipes.backend.model.Type;

public class BasicDao<T extends JPAEntity> {

	protected EntityManagerProvider emProvider;

	private final Class<T> clazz;

	public BasicDao(final EntityManagerProvider emProvider, final Class<T> clazz) {
		this.emProvider = emProvider;
		this.clazz = clazz;
	}

	public List<T> getAll() {
		final EntityManager em = this.emProvider.get();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<T> cq = cb.createQuery(this.clazz);
		cq.select(cq.from(this.clazz));
		final TypedQuery<T> query = em.createQuery(cq);
		return query.getResultList();
	}

	public T update(final T entity) {
		final EntityManager em = this.emProvider.get();
		em.getTransaction().begin();

		final T merge = em.merge(entity);

		em.getTransaction().commit();
		return merge;
	}

	public T create(final T entity) {
		final EntityManager em = this.emProvider.get();
		em.getTransaction().begin();
		em.persist(entity);

		em.getTransaction().commit();
		return entity;
	}

	public void delete(final T entity) {
		final EntityManager em = this.emProvider.get();
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	public void deleteAll() {
		final List<T> all = this.getAll();
		final EntityManager em = this.emProvider.get();
		em.getTransaction().begin();

		for (final T t : all) {
			final T managedObject = this.getById(t.getId(), em);
			em.remove(managedObject);
		}
		em.getTransaction().commit();
	}

	public T getById(final long id) {
		final EntityManager em = this.emProvider.get();
		return this.getById(id, em);
	}

	private T getById(final long id, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, id);
		} catch (final IllegalArgumentException e) {
			return null;
		}

		return found;
	}

	// Loren
	public T getByType(final Type type) {
		final EntityManager em = this.emProvider.get();
		return this.getByType(type, em);
	}

	private T getByType(final Type type, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, type);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	public T getByName(final String name) {
		final EntityManager em = this.emProvider.get();
		return this.getByName(name, em);
	}

	private T getByName(final String name, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, name);
		} catch (final IllegalArgumentException e) {
			return null;
		}

		return found;
	}

	public T getByCategory(final Category category) {
		final EntityManager em = this.emProvider.get();
		return this.getByCategory(category, em);
	}

	private T getByCategory(final Category category, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, category);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	public T getByFavorites(final List list) {
		final EntityManager em = this.emProvider.get();
		return this.getByFavorites(list, em);
	}

	private T getByFavorites(final List list, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, list);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	public T getByTime(final Integer time) {
		final EntityManager em = this.emProvider.get();
		return this.getByTime(time, em);
	}

	private T getByTime(final Integer time, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, time);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	public T getByPhoto(final boolean photo) {
		final EntityManager em = this.emProvider.get();
		return this.getByPhoto(photo, em);
	}

	private T getByPhoto(final boolean photo, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, photo);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	public T getByDifficulty(final Difficulty difficulty) {
		final EntityManager em = this.emProvider.get();
		return this.getByDifficulty(difficulty, em);
	}

	private T getByDifficulty(final Difficulty difficulty,
			final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, difficulty);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	public T getByStarRating(final StarRating starRating) {
		final EntityManager em = this.emProvider.get();
		return this.getByStarRating(starRating, em);
	}

	private T getByStarRating(final StarRating starRating,
			final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, starRating);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	public T getByHashAuth(final String hashAuth) {
		final EntityManager em = this.emProvider.get();
		return this.getByHashAuth(hashAuth, em);
	}

	private T getByHashAuth(final String hashAuth, final EntityManager em) {
		T found = null;
		try {
			found = em.find(this.clazz, hashAuth);
		} catch (final IllegalArgumentException e) {
			return null;
		}
		return found;
	}

	// end
}