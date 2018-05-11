package com.uci.myspringsecurity.config;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.uci.myspringsecurity.site", useDefaultFilters=false, includeFilters=@ComponentScan.Filter(Controller.class))
public class ServletContextConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware{
    
    private ApplicationContext applicationContext;

     
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
     
    
    
}