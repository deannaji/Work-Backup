package com.uci.oit.restapp.site;

import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AccountsManagerInterface
{
    List<EmailAccount> getAllAccounts();

    boolean createAccount(@Valid EmailAccount accout);
    
    EmailAccount viewAccount(int id);
    
    boolean editAccount(@Valid EmailAccount accout);
    
    boolean removeAccount(int id);
}
