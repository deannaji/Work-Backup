package com.uci.oit.restapp.site;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class DataGenerator implements DataGeneratorInterface
{
    private List<EmailAccount> database;
    
    public DataGenerator(){
        this.database = new ArrayList<>();
        EmailAccount a1 = new EmailAccount(1,"dean naji","najih@uci.edu");
        this.database.add(a1);
    }
    
    
    @Override
    public List<EmailAccount> getDataBase(){
        return this.database;
    }
    
   
    @Override
    public boolean addAccount(EmailAccount newAccount){
        try
        {
            for(EmailAccount account: database)
            {
                if(newAccount.getId() == account.getId())
                    return false;
            }
            this.database.add(newAccount);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    @Override
    public EmailAccount getAccount(int id)
    {
        for(EmailAccount account : this.database){
            if(account.getId() == id){
                return account;
            }
        }
        return null;
    }


    @Override
    public boolean deleteAccount(int id)
    {
        for(EmailAccount account: database){
            if(account.getId() == id){
                database.remove(account);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean updateAccount(EmailAccount updatedAccount)
    {
        for(EmailAccount account : database){
            if(account.getId() == updatedAccount.getId()){
                account.setUsername(updatedAccount.getUsername());
                account.setEmail(updatedAccount.getEmail());
                return true;
            }
         }
         return false;
    }
    
    
}
