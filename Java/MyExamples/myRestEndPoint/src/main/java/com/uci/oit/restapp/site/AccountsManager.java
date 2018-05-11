package com.uci.oit.restapp.site;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class AccountsManager implements AccountsManagerInterface
{

    @Inject
    DataGeneratorInterface database;
    
    @Override
    public List<EmailAccount> getAllAccounts()
    {
        return database.getDataBase();
    }

    @Override
    public boolean createAccount(EmailAccount accout)
    {
        if(database.addAccount(accout))
           return true;
        return false;
    }

    @Override
    public EmailAccount viewAccount(int id)
    {
        return database.getAccount(id);
    }

    @Override
    public boolean removeAccount(int id)
    {
        if(database.deleteAccount(id))
            return true;
        return false;    
    }

    @Override
    public boolean editAccount(EmailAccount updatedAccount)
    {
        if(database.updateAccount(updatedAccount))
            return true;
        return false;
    }

}
