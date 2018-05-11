package com.uci.oit.restapp.site;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.uci.oit.restapp.annotations.RestEndpoint;
import com.uci.oit.restapp.annotations.RestEndpointAdvice;

@RequestMapping("/empty")
@RestEndpoint
public class EmptyRestController
{
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/greeting")
    public String greeting(){
        return "Hello There, I'm just an empty controller for testing purposes!";
    }
    
    
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/account", method= RequestMethod.GET)
    public EmailAccount testAccount(){
       EmailAccount account = new EmailAccount(1,"testUsername1","testEmail1@domain.com");
       return account;
    }
    
}
