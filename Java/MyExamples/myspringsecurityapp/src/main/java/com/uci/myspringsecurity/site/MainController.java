package com.uci.myspringsecurity.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class MainController
{
    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "Hollo, this is the Main Controller!";
    }
    
    @ResponseBody
    @RequestMapping("/login")
    public String login(){
        return "Hi, this is a login page served by Main Controller and redirected due to the use of Spring Security!";
    }
}
