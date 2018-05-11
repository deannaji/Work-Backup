package com.uci.oit.restapp.site;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.uci.oit.restapp.config.RestServletContextConfiguration;
import com.uci.oit.restapp.config.RootContextConfiguration;
import com.uci.oit.restapp.config.WebServletContextConfiguration;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import javax.inject.Inject;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.RestAssuredMockMvc.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootContextConfiguration.class, RestServletContextConfiguration.class, WebServletContextConfiguration.class})
@WebAppConfiguration
public class HomeRestControllerTest
{

    @Inject
    private WebApplicationContext context;
    private MockMvc mockMvc;
    
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void testDiscover()
    {
        //fail("Not yet implemented");
    }

    @Test
    public void testAccount() throws Exception
    {
       mockMvc.perform(get("/account/{id}",1)
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.username").value("dean naji"));
    }

    
    
    @Test
    public void testAddEmailAccount() throws Exception
    { 
       mockMvc.perform(post("/add")
              .contentType(MediaType.APPLICATION_JSON)
              .content("{\"id\":2, \"username\":\"testuser\", \"email\": \"test@domain.com\"}"))
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isCreated());
    }

    
    @Test
    public void testUpdateEmailAccount() throws Exception
    {
       mockMvc.perform(put("/update")
              .contentType(MediaType.APPLICATION_JSON)
              .content("{\"id\":1, \"username\":\"testuser2\", \"email\": \"test2@domain.com\"}"))
              .andExpect(status().isNoContent());
    }

    
    @Test
    public void testAccounts()
    {
       
    }

    
    @Test
    public void testDeleteAccount() throws Exception
    {
        mockMvc.perform(get("/account/1")).andExpect(status().isOk());
        mockMvc.perform(delete("/delete/{id}", 1)).andExpect(status().isNoContent());
        mockMvc.perform(get("/account/1")).andExpect(status().isNotFound());
    }

}
