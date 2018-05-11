package com.myspringbootapps.springDataplusValidation.webControllers;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspringbootapps.springDataplusValidation.model.Ticket;
import com.myspringbootapps.springDataplusValidation.model.TicketForm;
import com.myspringbootapps.springDataplusValidation.repositories.TicketsRepository;


@Controller
@RequestMapping("/")
public class HomeController
{
    private TicketsRepository repository;
    
    @Autowired 
    public HomeController(TicketsRepository repo)
    {
       this.repository = repo;
    }

    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(){
       
        return "login";
    }
    
    
    
    @RequestMapping("/")
    public String home(){
        return "home";
    }
    
    
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("ticketForm", new TicketForm());//important for form validation.
        return "add";
    }
    
    
    
    /**
     * Note: the name of the model attribute MUST be a camel-case version of the original class name.
     * Otherwise, the thymeleaf template will not find the error messages.
     * @param ticketForm
     * @param errors
     * @param model
     * @return a view name
     */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(@Valid TicketForm ticketForm, BindingResult errors, Model model){
        model.addAttribute("ticketForm", ticketForm);//important for form validation.
        if(errors.hasErrors()){
            return "add";
        }else{
            Ticket newTicket = new Ticket();
            newTicket.setEmpName(ticketForm.getEmpName());
            newTicket.setProbTitle(ticketForm.getProbTitle());
            newTicket.setProbDisc(ticketForm.getProbDisc());
            newTicket.setStatus("New");
            newTicket.setTicketDateTime(new Timestamp(System.currentTimeMillis()));
            repository.save(newTicket);
            return "display";
        }
    }
    
    
    
    @RequestMapping(value="/display", method=RequestMethod.GET)
    public String display(Model model){
        model.addAttribute("AllTickets",repository.findAll());
        return "display";
    }
}
