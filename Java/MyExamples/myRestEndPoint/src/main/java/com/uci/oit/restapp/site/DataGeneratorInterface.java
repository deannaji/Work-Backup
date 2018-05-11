package com.uci.oit.restapp.site;

import java.util.List;

public interface DataGeneratorInterface
{

    List<EmailAccount> getDataBase();

    boolean addAccount(EmailAccount accout);
    
    EmailAccount getAccount(int id);
    
    boolean updateAccount(EmailAccount accout);
    
    boolean deleteAccount(int id);

}
