package com.uci.oit.app.site;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EmailAccount
{
    private int id;
    
    @NaN(message="Name should not be a number!")
    @NotEmpty(message="Name should not be empty!")
    //@Length(min=1, message="Name must not be empty")
    private String name;
    
    //@Email
    @MyEmail
    private String email;
    
    
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
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

}
