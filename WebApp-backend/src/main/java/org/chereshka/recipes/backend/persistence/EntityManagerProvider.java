package org.chereshka.recipes.backend.persistence;

import javax.persistence.EntityManager;

public class EntityManagerProvider {

	private static final ThreadLocal<EntityManager> ENTITY_MANAGER = new ThreadLocal<>();
	private static EntityManagerProvider instance;

	public static synchronized EntityManagerProvider getInstance() {
		if (instance == null) {
			instance = new EntityManagerProvider();
		}
		return instance;
	}

	private EntityManagerProvider() {
	}

	public EntityManager get() {
		EntityManager em = ENTITY_MANAGER.get();
		if ((em == null) || !em.isOpen()) {
			em = EntityManagerFactoryProvider.getInstance().getEntityManagerFactory().createEntityManager();
			ENTITY_MANAGER.set(em);
		}
		return em;
	}

	public void closeEntityManager() {
		final EntityManager em = this.get();
		if (em != null) {
			em.close();
		}
		remove();
	}

	private static void remove() {
		ENTITY_MANAGER.remove();
	}
}