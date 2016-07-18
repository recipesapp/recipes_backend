package org.chereshka.recipes.backend.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
}
