package com.uci.oit.pts.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController
{
    @RequestMapping(value="/testController", method=RequestMethod.GET)
        public String index() {
        return "Index";
    }
}
