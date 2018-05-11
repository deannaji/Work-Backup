package com.mvcTest.site.integrationTests;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mvcTest.config.RootContextConfiguration;
import com.mvcTest.config.ServletContextConfiguration;
import com.mvcTest.site.AccountsRepository;
import com.mvcTest.site.AccountsRepositoryImp;
import com.mvcTest.site.AccountsService;
import com.mvcTest.site.AccountsServiceImp;
import com.mvcTest.site.UserAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootContextConfiguration.class, ServletContextConfiguration.class})
@WebAppConfiguration
public class AccountsRepositoryImpIntgTest
{
    @Inject
    AccountsRepository repo;
    AccountsService sut;
    
    @Before
    public void setup(){
        this.repo = new AccountsRepositoryImp();
        this.sut = new AccountsServiceImp(repo);
    }

    @Test
    public void testAddAccount()
    {
        int id=4;
        UserAccount user = new UserAccount(id,"testuser4","testpass4");
        sut.AddUser(user);
        UserAccount persistedUser = repo.viewAccount(id);
        assertEquals(persistedUser.getUsername(), user.getUsername());
        assertEquals(persistedUser.getPassword(), user.getPassword());
    }

    @Test
    public void testViewAccount()
    {
        int id=3;
        UserAccount user = sut.displayUser(id);
        assertEquals(user.getUsername(), "testuser3");
    }

    @Test
    public void testViewAllAccounts()
    {
        List<UserAccount> results = sut.displayAll();
        assertEquals(results.size(), 3);
    }

}
