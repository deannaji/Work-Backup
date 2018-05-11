package com.uci.oit.restapp.site;

import com.uci.oit.restapp.site.validation.Email;
import com.uci.oit.restapp.site.validation.NonNumeric;
import com.uci.oit.restapp.site.validation.NotEmpty;

public class EmailAccount
{
    private int id;
    
    @NotEmpty(message="Username cannot be empty")
    @NonNumeric(message="Username must start with a letter")
    private String username;
    
    @Email 
    @NotEmpty(message="Email cannot be empty")
    private String email;
    
    
    public EmailAccount(int id, String username, String email){
        this.id = id;
        this.username = username;
        this.email = email;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    
}
