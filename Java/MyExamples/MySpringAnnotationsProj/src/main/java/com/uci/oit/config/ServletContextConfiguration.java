package com.uci.oit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.uci.oit.site", useDefaultFilters= false, includeFilters= @ComponentScan.Filter(Controller.class))
public class ServletContextConfiguration extends WebMvcConfigurerAdapter{
	
	
	// Equivalents for <mvc:resources/> tags
	//for mapping resources location, for static content, JS, CSS, etc.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);*/
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

	
	
	@Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
