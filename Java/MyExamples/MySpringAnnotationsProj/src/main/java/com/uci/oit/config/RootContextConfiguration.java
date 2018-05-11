package com.uci.oit.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages="com.uci.oit.site", excludeFilters=@ComponentScan.Filter(Controller.class))
public class RootContextConfiguration {
	
	@Bean
    public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://127.0.0.1:4433;DatabaseName=tds_netdb;");
        dataSource.setUsername("USERNAME");
        dataSource.setPassword("PASSWORD");     
        return dataSource;
    }
	
	@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
	
	//No need for that anymore since annotation based config allows component scan!
	/*@Bean 
    public UserDaoImp UserDao(){
        UserDaoImp userDao = new UserDaoImp();
        userDao.setJdbcTemplate(jdbcTemplate());
        return userDao;
    }*/
}
