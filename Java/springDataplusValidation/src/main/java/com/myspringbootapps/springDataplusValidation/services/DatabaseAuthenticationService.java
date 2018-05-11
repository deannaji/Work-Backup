package com.myspringbootapps.springDataplusValidation.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myspringbootapps.springDataplusValidation.repositories.UsersRepository;

@Service
public class DatabaseAuthenticationService implements UserDetailsService
{
    
    @Autowired
    private UsersRepository usersRepository;
    
    static final PasswordEncoder BCencoder = new BCryptPasswordEncoder();
    static final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
       if(usersRepository.findByUsername(username)==null){
           throw new UsernameNotFoundException("User details not found with this username");
       }else{
           com.myspringbootapps.springDataplusValidation.model.User user1= usersRepository.findByUsername(username);
           
           //UserDetails user = User.withDefaultPasswordEncoder().username(user1.getUsername()).password(user1.getPassword()).roles("USER").build();
           UserDetails user = User.withUsername(user1.getUsername())
                   .password(encoder.encode(user1.getPassword()))
                   .roles("USER").build();
           return user;
       } 
         
    }
    

}
