package com.mvcTest.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController
{
    @ResponseBody
    @RequestMapping("/greeting")
    public String greetings(){
        return "Hello!... message from HomeController";
    }
    
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
}
