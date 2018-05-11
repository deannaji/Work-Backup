package com.mvcTest.site.unitTests;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mvcTest.site.AccountsRepository;
import com.mvcTest.site.AccountsRepositoryImp;
import com.mvcTest.site.AccountsService;
import com.mvcTest.site.AccountsServiceImp;
import com.mvcTest.site.UserAccount;


public class AccountsServiceImpTest
{
    
    AccountsRepository mockAccountsRepo = mock(AccountsRepositoryImp.class);
    AccountsService sut;
    
    @Before
    public void setup(){
        this.sut = new AccountsServiceImp(mockAccountsRepo);
    }

    @Test
    public void testAddUser()
    {
        UserAccount account = new UserAccount(1,"testuser", "testpass");
        sut.AddUser(account);
        verify(mockAccountsRepo).addAccount(account);
    }

    @Test
    public void testDisplayUser()
    {
        UserAccount account = new UserAccount(1,"testuser", "testpass");
        when(mockAccountsRepo.viewAccount(any(Integer.class))).thenReturn(account);
        assertEquals(sut.displayUser(1), account);
        verify(mockAccountsRepo).viewAccount(1);
    }

    @Test
    public void testDisplayAll()
    {
       List<UserAccount> resultsList = new ArrayList<>();
       when(mockAccountsRepo.viewAllAccounts()).thenReturn(resultsList);
       assertEquals(sut.displayAll(), resultsList);
       verify(mockAccountsRepo).viewAllAccounts();
    }

}
