package com.mvcTest.site;

import java.util.List;

import org.springframework.stereotype.Service;


public interface AccountsService
{
    public void AddUser(UserAccount account);
    public UserAccount displayUser(int id);
    public List<UserAccount> displayAll();
}
