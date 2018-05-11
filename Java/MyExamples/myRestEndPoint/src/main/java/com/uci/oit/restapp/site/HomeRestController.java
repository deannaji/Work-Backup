package com.uci.oit.restapp.site;

import java.util.List;

import javax.inject.Inject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.uci.oit.restapp.annotations.RestEndpoint;
import com.uci.oit.restapp.site.exceptions.DuplicateResourceEntryException;
import com.uci.oit.restapp.site.exceptions.ResourceNotFoundException;

//@RequestMapping("/services/Rest")
@RestEndpoint
public class HomeRestController
{

    @Inject
    AccountsManagerInterface AccountsManager;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(){
        return "Hello World!";
    }
    
    
    @RequestMapping(value = "/options", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> discover()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "OPTIONS,HEAD,GET,POST");
        return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
    }

    
    
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public EmailAccount account(@PathVariable("id") int id)
    {
        EmailAccount account = AccountsManager.viewAccount(id);
        if (AccountsManager.viewAccount(id) == null)
            throw new ResourceNotFoundException();
        return account;
    }
    
    

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmailAccount> addEmailAccount(@RequestBody EmailAccountForm form)
    {

        EmailAccount newAccount = new EmailAccount(form.getId(), form.getUsername(), form.getEmail());
        if (AccountsManager.createAccount(newAccount))
        {
            String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/account/{id}")
                    .buildAndExpand(newAccount.getId()).toString();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", uri);
            return new ResponseEntity<>(newAccount, headers, HttpStatus.CREATED);
        }
        else
            throw new DuplicateResourceEntryException("Duplicate resource entry exception");
    }

    
    
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmailAccount(@RequestBody EmailAccountForm form)
    {
        EmailAccount updatedAccount = new EmailAccount(form.getId(), form.getUsername(), form.getEmail());

        if (!AccountsManager.editAccount(updatedAccount))
            throw new ResourceNotFoundException();
       
    }
    

    
    
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<EmailAccount> accounts()
    {
        return AccountsManager.getAllAccounts();
    }

    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmailAccount> deleteAccount(@PathVariable("id") int id)
    {
        if (AccountsManager.removeAccount(id))
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            throw new ResourceNotFoundException();
        }

    }

}
