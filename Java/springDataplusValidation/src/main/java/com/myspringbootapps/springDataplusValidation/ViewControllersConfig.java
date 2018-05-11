package com.myspringbootapps.springDataplusValidation;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewControllersConfig implements WebMvcConfigurer
{
    public void addViewControllers(ViewControllerRegistry registry){
        //registry.addViewController("/login").setViewName("login"); //No need for it, added to the WebController class.
    }
}
