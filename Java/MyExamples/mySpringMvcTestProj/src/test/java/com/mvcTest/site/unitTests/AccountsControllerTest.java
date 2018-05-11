package com.mvcTest.site.unitTests;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.mvcTest.config.RootContextConfiguration;
import com.mvcTest.config.ServletContextConfiguration;
import com.mvcTest.site.AccountsController;
import com.mvcTest.site.AccountsRepository;
import com.mvcTest.site.AccountsRepositoryImp;
import com.mvcTest.site.AccountsService;
import com.mvcTest.site.AccountsServiceImp;
import com.mvcTest.site.UserAccount;


/**
 * Unit test for Accounts Controller, along with routes testing.
 * @author najih
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootContextConfiguration.class, ServletContextConfiguration.class})
@WebAppConfiguration
public class AccountsControllerTest
{
    
    AccountsService mockAccountsManager = mock(AccountsServiceImp.class);
    MockMvc mockMvc;

    
    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        
        mockMvc= MockMvcBuilders.standaloneSetup(new AccountsController(mockAccountsManager)).setViewResolvers(viewResolver).build();        
    }
     
    
    @Test
    public void testAdd() throws Exception
    {
       mockMvc.perform(get("/accounts/add")).andExpect(status().isOk()).andExpect(view().name("add"));
    }

    
    @Test
    public void testAddUserAccountModel() throws Exception
    {
        mockMvc.perform(post("/accounts/add").param("id", "4").param("username", "user4").param("password", "pass4")).andExpect(model().attributeExists("accounts")).andExpect(status().isOk()).andExpect(view().name("display"));
        verify(mockAccountsManager).AddUser(any(UserAccount.class));
    }

    
    @Test
    public void testView() throws Exception
    {
        int id=1;
        UserAccount user1 = new UserAccount(1,"testuser1","testpass1");
        when(mockAccountsManager.displayUser(id)).thenReturn(user1);
        mockMvc.perform(get("/accounts/1")).andExpect(model().attributeExists("accounts")).andExpect(view().name("display"));
        verify(mockAccountsManager, times(2)).displayUser(id);//called twice: on when and on mockMvc.
    }

    
    
    @Test
    public void testViewAll() throws Exception
    {
        mockMvc.perform(get("/accounts/all")).andExpect(model().attributeExists("accounts")).andExpect(view().name("display"));
        verify(mockAccountsManager).displayAll();
    }

}
