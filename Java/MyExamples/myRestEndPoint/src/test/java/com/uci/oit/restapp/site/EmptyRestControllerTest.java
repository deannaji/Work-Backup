package com.uci.oit.restapp.site;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import javax.inject.Inject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.uci.oit.restapp.config.RestServletContextConfiguration;
import com.uci.oit.restapp.config.RootContextConfiguration;
import com.uci.oit.restapp.config.WebServletContextConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootContextConfiguration.class, RestServletContextConfiguration.class, WebServletContextConfiguration.class})
@WebAppConfiguration
public class EmptyRestControllerTest
{
    @Inject
    private WebApplicationContext context;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
        //this.mockMvc= MockMvcBuilders.standaloneSetup(new EmptyRestController()).build();
    }


    @Test
    public void testGreeting() throws Exception
    {
        mockMvc.perform(get("/empty/greeting")).andExpect(status().isOk());
    }

  
    @Test
    public void testTestAccount() throws Exception
    {
        mockMvc.perform(get("/empty/account").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.username").value("testUsername1"))
        .andExpect(jsonPath("$.email").value("testEmail1@domain.com"));
    }

}
