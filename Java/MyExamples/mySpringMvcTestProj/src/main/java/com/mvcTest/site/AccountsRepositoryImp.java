package com.mvcTest.site;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AccountsRepositoryImp implements AccountsRepository
{
    private List<UserAccount> database= new ArrayList<>();

   
    public AccountsRepositoryImp()
    {
       UserAccount u1 = new UserAccount(1,"testuser1","testpass1");
       UserAccount u2 = new UserAccount(2,"testuser2","testpass2");
       UserAccount u3 = new UserAccount(3,"testuser3","testpass3");
       this.database.add(u1);
       this.database.add(u2);
       this.database.add(u3);
    }
    
    @Override
    public boolean addAccount(UserAccount account)
    {
        if(this.database.add(account)){
            return true;
        }else{
            return false;
        }
    }

    
    @Override
    public UserAccount viewAccount(int id)
    {
        for(UserAccount account: this.database){
            if(account.getId() == id){
                return account;
            }
        }
        return null;
    }

    
    @Override
    public List<UserAccount> viewAllAccounts()
    {
        return this.database;
    }

}
