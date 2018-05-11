package com.myspringbootapps.springDataplusValidation;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
//@EnableJpaRepositories(basePackageClasses= UsersRepository.class)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
      
    @Autowired
    private UserDetailsService userDetailsService;
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //auth.userDetailsService(userDetailsService);
       
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /*http.authorizeRequests().antMatchers("/login")
        .permitAll()
        .anyRequest().authenticated().and()
        .formLogin().loginPage("/login").permitAll().and()
        .logout().permitAll();*/
        
        http.authorizeRequests().antMatchers("/login")
        .permitAll()
        .anyRequest().authenticated().and()
        .formLogin().loginPage("/login").permitAll().and()
        .logout().permitAll();
    }
    
    
    /*//Uncomment for in-memory (hard-coded) username and password. 
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/
    
}
