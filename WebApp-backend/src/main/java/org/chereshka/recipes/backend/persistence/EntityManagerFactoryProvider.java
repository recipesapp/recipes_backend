package org.chereshka.recipes.backend.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class EntityManagerFactoryProvider {

	private static final String PERSISTENCE_UNIT = "org.chereshka.recipes.backend";

	private static EntityManagerFactoryProvider instance = null;

	private EntityManagerFactory factory = null;

	private EntityManagerFactoryProvider() {
	}

	public static synchronized EntityManagerFactoryProvider getInstance() {
		if (instance == null) {
			instance = new EntityManagerFactoryProvider();
		}

		return instance;
	}

	public synchronized EntityManagerFactory getEntityManagerFactory() {
		if (this.factory == null) {
			this.factory = this.createEntityManagerFactory(DataSourceProvider.getInstance().get());
		}
		return this.factory;
	}

	private EntityManagerFactory createEntityManagerFactory(final DataSource dataSource) {
		final Map<Object, Object> properties = new HashMap<>();
		properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, dataSource);
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
	}

	public synchronized void close() {
		if (this.factory != null) {
			this.factory.close();
			this.factory = null;
		}
	}

}