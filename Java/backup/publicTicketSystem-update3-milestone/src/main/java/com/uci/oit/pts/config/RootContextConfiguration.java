package com.uci.oit.pts.config;

import java.util.Hashtable;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.thymeleaf.spring4.SpringTemplateEngine;


@Configuration
@ComponentScan(basePackages="com.uci.oit.pts.site", excludeFilters=@ComponentScan.Filter(Controller.class))
//@Import({SecurityConfig.class})
public class RootContextConfiguration {
	/*@Bean
    public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://127.0.0.1:4433;DatabaseName=tds_netdb;");
        dataSource.setUsername("tds_app");
        dataSource.setPassword("!hXv-8U3_RsFu-1~y");     
        return dataSource;
    }*/
	
	/*@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }*/
	
	/*@Bean
	public DataSource springJpaDataSource(){
		JndiDataSourceLookup lookup = new JndiDataSourceLookup();
		return lookup.getDataSource("jdbc/SpringJpa");
	}*/
	
	
	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		Map<String, Object> properties = new Hashtable<>();
		properties.put("javax.persistence.schema-generation.database.action",
		"none");
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("org.hibernate.dialect.SQLServer2012Dialect");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setDataSource(this.springJpaDataSource());
		factory.setPackagesToScan("com.uci.oit.pts.site.domain");
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setValidationMode(ValidationMode.NONE);
		factory.setJpaPropertyMap(properties);
		return factory;
	}*/
	
	
	@Bean
	public EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EntityMappings");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean()throws ClassNotFoundException
	{
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setProviderClass(Class.forName("org.hibernate.validator.HibernateValidator"));
		return validator;
	}
}
