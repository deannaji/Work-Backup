package com.uci.oit.pts.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.uci.oit.pts.site", useDefaultFilters=false, includeFilters=@ComponentScan.Filter(Controller.class))
public class ServletContextConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;

	 
	public void setApplicationContext(ApplicationContext applicationContext) {
	    this.applicationContext = applicationContext;
	}
	 
	 
	//start Thymeleaf specific configuration
	@Bean
    public SpringResourceTemplateResolver templateResolver(){
    
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/resources/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        //SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        //templateEngine.setTemplateResolver(templateResolver());
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
	//end Thymeleaf specific configuration

    
    //resources folder for serving static content(/main/webapp/resources)
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	        registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
	        registry.addResourceHandler("/img/**").addResourceLocations("/img/**");
	        registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
	        registry.addResourceHandler("/sound/**").addResourceLocations("/sound/**");
	        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/**");
	 }
	
}
