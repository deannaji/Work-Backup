package com.uci.oit.restapp.site;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="account")
public class EmailAccountForm
{
    private int id;
    private String username;
    private String email;
    
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
