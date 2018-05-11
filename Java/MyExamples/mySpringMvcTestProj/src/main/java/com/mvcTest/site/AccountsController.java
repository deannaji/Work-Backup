package com.mvcTest.site;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.ResourceAccessException;

import com.mvcTest.exceptions.ResourceNotFoundException;


@Controller
@RequestMapping("/accounts")
public class AccountsController
{
    
    private AccountsService AccountsManager;
    
    @Inject
    public AccountsController(AccountsService accountsService){
        this.AccountsManager = accountsService;
    }
    
    
    /**
     * Heartbeat monitor
     * @return: String
     */
    @ResponseBody
    @RequestMapping("/greeting")
    public String greeting(){
        return "Hello!.. A message from AccountsController!";
    }
    
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(){
        return "add";
    }
    
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(/*@RequestBody*/ UserAccount form, Model model){
        AccountsManager.AddUser(form);
        model.addAttribute("accounts", AccountsManager.displayAll());
        return "display";
    }
    
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String view(@PathVariable("id") int id, Model model) throws Exception{
        if(AccountsManager.displayUser(id) == null)
            throw new ResourceNotFoundException();
        
        List<UserAccount> results = new ArrayList<>();
        results.add(AccountsManager.displayUser(id));
        model.addAttribute("accounts", results);
        return "display";
    }
    
    
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public String viewAll(Model model){
       model.addAttribute("accounts", AccountsManager.displayAll()); 
       return "display";
    }
    
    
    @RequestMapping("/empty")
    public String emptyPage(){
        return "display";
    }
    
    
}
