package com.mvcTest.site.integrationTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.mvcTest.config.RootContextConfiguration;
import com.mvcTest.config.ServletContextConfiguration;
import com.mvcTest.site.AccountsController;
import com.mvcTest.site.AccountsService;
import com.mvcTest.site.AccountsServiceImp;
import com.mvcTest.site.UserAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootContextConfiguration.class, ServletContextConfiguration.class})
@WebAppConfiguration
public class AccountsControllerIntgTest
{

    @Inject
    private WebApplicationContext context;
    @Inject
    AccountsService accountsManager;
    MockMvc mockMvc;
    
    
    /**
     * Setting up Spring mockMvc using the actual context configuration, typical integration test.
     */
    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    
    
    /**
     * The original method only returns a view, so the test checks that the method is returning that view.
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception
    {
       mockMvc.perform(get("/accounts/add")).andExpect(status().isOk()).andExpect(view().name("add"));
    }
    
    
    /**
     * The original method accepts a form object along with post, so the first line shows how to mimic a form object using mockMvc.
     * Second line brings the submitted object from the DB.
     * Third is asserting that the record from the DB is the same one been submitted in step 1.
     * @throws Exception
     */
    @Test
    public void testAddUserAccountModel() throws Exception
    {   
        mockMvc.perform(post("/accounts/add").param("id", "4").param("username", "user4").param("password", "pass4")).andExpect(model().attributeExists("accounts")).andExpect(status().isOk()).andExpect(view().name("display"));
        UserAccount savedUser = accountsManager.displayUser(4);
        assertEquals(savedUser.getUsername(), "user4");
    }
    
    
   
    @Test
    public void testView() throws Exception
    {
        mockMvc.perform(get("/accounts/{id}", 1)).andExpect(model().attributeExists("accounts")).andExpect(status().isOk()).andExpect(view().name("display"));
    }

    
    
   
    @Test
    public void testViewAll() throws Exception
    {
        mockMvc.perform(get("/accounts/all")).andExpect(model().attributeExists("accounts")).andExpect(view().name("display"));
    }

}
