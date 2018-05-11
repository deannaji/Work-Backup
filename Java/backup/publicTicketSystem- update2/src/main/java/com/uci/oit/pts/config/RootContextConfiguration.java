package com.uci.oit.pts.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.thymeleaf.spring4.SpringTemplateEngine;


@Configuration
@ComponentScan(basePackages="com.uci.oit.pts.site", excludeFilters=@ComponentScan.Filter(Controller.class))
public class RootContextConfiguration {
	@Bean
    public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://127.0.0.1:4433;DatabaseName=tds_netdb;");
        dataSource.setUsername("tds_app");
        dataSource.setPassword("!hXv-8U3_RsFu-1~y");     
        return dataSource;
    }
	
	@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
	
	
	
}
