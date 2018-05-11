package com.mvcTest.site.unitTests;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mvcTest.site.AccountsRepository;
import com.mvcTest.site.AccountsRepositoryImp;
import com.mvcTest.site.UserAccount;


public class AccountsRepositoryImpTest
{
    AccountsRepository sut;
    
    @Before
    public void setup(){
        sut= new AccountsRepositoryImp();
    }

    @Test
    public void testAddAccount()
    {
        UserAccount user = new UserAccount(1,"testuser","testpass");
        assertTrue(sut.addAccount(user));
    }

    @Test
    public void testViewAccount()
    {
        UserAccount account = sut.viewAccount(1);
        assertEquals(account.getUsername(), "testuser1");
    }

    @Test
    public void testViewAllAccounts()
    {
        List<UserAccount> results = sut.viewAllAccounts();
        assertEquals(results.size(), 3);//initail size of that list is 3.
    }

}
