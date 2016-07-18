package org.chereshka.recipes.backend.persistence;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceProvider {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String DATA_SOURCE = "java:comp/env/jdbc/DefaultDB";

	private static DataSource dataSource = null;
	private static DataSourceProvider instance;

	public synchronized static DataSourceProvider getInstance() {
		if (instance == null) {
			instance = new DataSourceProvider();
		}
		return instance;
	}

	private DataSourceProvider() {
		try {
			final InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup(DATA_SOURCE);
		} catch (final NamingException e) {
			this.logger.error("Could not lookup the default datasource", e);
			throw new RuntimeException(e);
		}
	}

	public DataSource get() {
		return dataSource;
	}

}