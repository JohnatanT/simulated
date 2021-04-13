package br.com.johnatan.simulated.configs;

import javax.sql.DataSource;

import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

@Configuration
public class DbUnitConfiguration {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
	    DatabaseConfigBean bean = new DatabaseConfigBean();
	    bean.setDatatypeFactory(new PostgresqlDataTypeFactory());

	    DatabaseDataSourceConnectionFactoryBean dbConnectionFactory = new DatabaseDataSourceConnectionFactoryBean(dataSource);
	    dbConnectionFactory.setDatabaseConfig(bean);
	    return dbConnectionFactory;
	}
}
