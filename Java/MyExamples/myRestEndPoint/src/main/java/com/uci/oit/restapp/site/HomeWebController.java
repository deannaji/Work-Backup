package com.uci.oit.restapp.site;

import org.springframework.web.bind.annotation.RequestMapping;

import com.uci.oit.restapp.annotations.WebController;

//@RequestMapping("/")
@WebController
public class HomeWebController
{
    @RequestMapping("/")
    public String index(){
        return "resources/index.html";
    }
    
}
