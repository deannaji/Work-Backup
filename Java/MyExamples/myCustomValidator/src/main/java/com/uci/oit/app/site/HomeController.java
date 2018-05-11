package com.uci.oit.app.site;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController
{
    
    private Validator validator;
    
    @Inject
    public HomeController(Validator validator){
        this.validator = validator;
    }
    
    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "Hollo, this is the Main Controller!";
    }
    
    @ResponseBody
    @RequestMapping("/add")
    public String addEmail(@RequestParam String email, @RequestParam String name){
        EmailAccount account = new EmailAccount();
        account.setId(1);
        account.setName(name);
        account.setEmail(email);
        
        Set<ConstraintViolation<EmailAccount>> violations = validator.validate(account);
        if(violations.size() > 0){
            String errorMsg="";
            for(ConstraintViolation violation : violations){
                errorMsg+=violation.getMessage()+"<br>";
            }
            return errorMsg;
        }else{
            return "Id: "+account.getId()+"<br>"+
                    "Name: "+account.getName()+"<br>"+
                    "Email: "+account.getEmail()+"<br>";
        }
        
    }
    

}
