package com.mvcTest.site;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface AccountsRepository
{
    public boolean addAccount(UserAccount account);
    public UserAccount viewAccount(int id);
    public List<UserAccount> viewAllAccounts();
}
