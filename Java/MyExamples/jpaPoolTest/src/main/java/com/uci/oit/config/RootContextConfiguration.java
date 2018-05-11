package com.uci.oit.config;

import java.util.Hashtable;
import java.util.Map;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
@ComponentScan(basePackages="com.uci.oit.site", excludeFilters=@ComponentScan.Filter(Controller.class))
public class RootContextConfiguration {
	
	
	@Bean
	public DataSource springJpaDataSource(){
		JndiDataSourceLookup lookup = new JndiDataSourceLookup();
		return lookup.getDataSource("jdbc/SpringJpa");
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		Map<String, Object> properties = new Hashtable<>();
		properties.put("javax.persistence.schema-generation.database.action", "none");
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("org.hibernate.dialect.SQLServer2012Dialect");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setDataSource(this.springJpaDataSource());
		factory.setPackagesToScan("com.uci.oit.site");
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setValidationMode(ValidationMode.NONE);
		factory.setJpaPropertyMap(properties);
		return factory;
	}
	
	
	
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean()throws ClassNotFoundException
	{
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setProviderClass(Class.forName("org.hibernate.validator.HibernateValidator"));
		return validator;
	}
}
