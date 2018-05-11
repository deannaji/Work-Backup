package com.uci.oit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;



@Configuration
@ComponentScan(basePackages="com.uci.oit.app.site", excludeFilters=@ComponentScan.Filter(Controller.class))
public class RootContextConfiguration {
    
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean()throws ClassNotFoundException
    {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(Class.forName("org.hibernate.validator.HibernateValidator"));
        return validator;
    }
    
}