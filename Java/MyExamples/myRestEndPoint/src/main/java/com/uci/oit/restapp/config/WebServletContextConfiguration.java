package com.uci.oit.restapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.uci.oit.restapp.annotations.WebController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.uci.oit.restapp.site", useDefaultFilters=false, includeFilters=@ComponentScan.Filter(WebController.class))
public class WebServletContextConfiguration extends WebMvcConfigurerAdapter
{
  //resources folder for serving static content(/main/webapp/resources)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
            registry.addResourceHandler("/css/**").addResourceLocations("/css/");
            registry.addResourceHandler("/img/**").addResourceLocations("/img/**");
            registry.addResourceHandler("/js/**").addResourceLocations("/js/");
            registry.addResourceHandler("/sound/**").addResourceLocations("/sound/**");
            registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/**");
     }
}
