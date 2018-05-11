package com.mvcTest.site;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImp implements AccountsService
{

    private AccountsRepository Accounts;
    
    
    @Inject
    public AccountsServiceImp(AccountsRepository accounts)
    {
        Accounts = accounts;
    }

    
    
    @Override
    public void AddUser(UserAccount account)
    {
        Accounts.addAccount(account);
    }
    

    @Override
    public UserAccount displayUser(int id)
    {
        UserAccount result = Accounts.viewAccount(id);
        return result;
    }

    
    @Override
    public List<UserAccount> displayAll()
    {
        return Accounts.viewAllAccounts();
    }

}
