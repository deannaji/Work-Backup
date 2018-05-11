package com.uci.oit.pts.site.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import com.uci.oit.pts.site.domain.ProblemForm;
import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;
import com.uci.oit.pts.site.repository.TicketsDao;
import com.uci.oit.pts.site.repository.TicketsDaoInterface;
import com.uci.oit.pts.site.services.InputValidationServiceInterface;
import com.uci.oit.pts.site.services.StringSanitizationServiceInterface;
import com.uci.oit.pts.site.services.TicketsServiceInterface;
import com.uci.oit.pts.site.services.LoginServiceInterface;

/**
 * Home Controller
 * @author najih
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	//Services:
	TicketsServiceInterface TicketsService;
	LoginServiceInterface LoginService;
	InputValidationServiceInterface InputValidator;
	StringSanitizationServiceInterface StringSanitizor;
	//private static final Logger log = LogManager.getLogger();
	
	
	@Inject
	public HomeController(TicketsServiceInterface ticketsService, LoginServiceInterface LoginService, InputValidationServiceInterface inputValidator, StringSanitizationServiceInterface StringSanitizor){
		this.TicketsService= ticketsService;
		this.LoginService= LoginService;
		this.InputValidator= inputValidator;
		this.StringSanitizor= StringSanitizor;
	}
	
	
	/**
	 * Test method prints a hard coded message.
	 * @return String message
	 */
	@ResponseBody
	@RequestMapping(value="/greeting", method= RequestMethod.GET)
	public String greeting(){
		return "Message from HomeController: Welcome to the Public Tickets System!";
	}
	
	/**
	 * Index of the web app. Redirects to either login page or display page.
	 * @return String Redirect
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		//if no username found in session, then goto login page
		if (! LoginService.checkLoginStatus()){
			return "redirect:login";
		}else{
			return "redirect:display";
		}
	}
	
	
	/**
	 * Login method on a GET request has two routes. The first is using within-system login.
	 * The second is using UCI WebAuth login.
	 * @param Model model
	 * @param String ucinetid_auth
	 * @return String Redirect
	 * @throws IOException
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, @RequestParam(required=false) String ucinetid_auth) throws IOException{
		//if UCI WebAuth used for login:
		if(ucinetid_auth != null){
			String ucinetid = LoginService.authenticateUciWebAuth(ucinetid_auth);
			LoginService.logUserIn(ucinetid);
			return "redirect:display"; 
		}
		else//Then use website local login:
		{
		  return "Login";
		}
	}
	
	
	
	/**
	 * Login method with hard coded username and password.
	 * @param String username
	 * @param String password
	 * @return String Redirect
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password){
		if(username.equals("test") && password.equals("test")){
			LoginService.logUserIn(username);
			return "redirect:display";
		}else{
		return "redirect:login";
		}
	}
	
	
	/**
	 * Clears the session from user data and redirect to login page.
	 * @return String Redirect.
	 */
	@RequestMapping(value="/logout")
	public String logout(){
		LoginService.logUserOut();
		return "redirect:login";
	}
	
	
	/**
	 * getTicket method is responsible for getting one ticket from DB by ticket id.
	 * Ticket id needs to appear on the query string.
	 * @param model
	 * @param int id
	 * @return a view named Index.html
	 */
	@RequestMapping(value="/getTicket", method=RequestMethod.GET)
	public String getTicket(Model model, @RequestParam int id){
		//if no username found in session, then goto login page
		if(! LoginService.checkLoginStatus()){
			return "redirect:login";
		}
		Map<String, Object> ticketMap= TicketsService.getTicket(id);
		model.addAttribute("ticket1", ticketMap.get("ticket"));
		return "ListATicket";
	}
	
	
	/**
	 * This method redirects to display(Index) page. 
	 * @param Model model
	 * @return String Redirect
	 */
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String getAllTickets(Model model){
		//if no username found in session, then goto login page
		if(! LoginService.checkLoginStatus()){
			return "redirect:login";
		}
		
		List<Ticket> results= TicketsService.getAllTickets();
		model.addAttribute("AllTickets", results);
		model.addAttribute("pageName","index");
		return "Index";
	}
	
	
	/**
	 * This method works on a GET request and serves edit ticket page.
	 * @param Model model
	 * @param int id
	 * @return String Redirect
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editTicket(Model model, @RequestParam int id){
		//if no username found in session, then goto login page
		if(! LoginService.checkLoginStatus()){
			return "redirect:login";
		}
		
		//Ticket ticket= ticketsDao.getTicket(id);
		Map<String, Object> ticketMap= TicketsService.getTicket(id);
		model.addAttribute("ticket", ticketMap.get("ticket"));
		model.addAttribute("notes", ticketMap.get("ticketNotes"));
		return "Edit";
	}
	
	
	
	/**
	 * Editing an existing ticket.   
	 * @param int id
	 * @param String status
	 * @param String assignedTo
	 * @param String note (optional)
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editTicket(@RequestParam int id, @RequestParam(required=false) String status, @RequestParam(required=false) String assignedTo, 
			@RequestParam(required=false) String note){
		
		//if no username found in session, then goto login page
		if(! LoginService.checkLoginStatus()){
			return "redirect:login";
		}
		
		String response="";
		boolean resultNotesAdding=false;
		Map<String, String> params = new HashMap<>();
		params.put("Status", status);
		params.put("AssignedTo", assignedTo);
		if(params.size() > 0){
			boolean result= TicketsService.updateTicket(id, params); 
			if (result){
				response="Record updated successfully!";
			}else
			{
				response="Some error happend. Record has not been updated..";
			}
		}
		if(!note.isEmpty()){
			//Input sanitization on the domain class.  
			note = StringSanitizor.sanitizeWithHtmlEscape(note);
			
			TicketNote ticketNote = new TicketNote();
			ticketNote.setNote(note);
			ticketNote.setTicket_id(id);
			ticketNote.setTimestamp(new Timestamp(System.currentTimeMillis()));
			resultNotesAdding= TicketsService.addNote(ticketNote); 
		}
		return "redirect:edit?id="+id;
	}
	
	
	/**
	 * Add ticket GET request method, serves the add ticket form page.
	 * @param Model model
	 * @return String redirect
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addTicket(Model model){
		//if no username found in session, then goto login page
		if(! LoginService.checkLoginStatus()){
			return "redirect:login";
		}
		
		model.addAttribute("pageName","add");
		return "Add";
	}
	
	
	/**
	 * Add a new ticket to the DB.
	 * @param ProblemForm problem
	 * @param Model model
	 * @return redirects to Display page.
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addTicket(ProblemForm problem, Model model){
		//if no username found in session, then goto login page
		if(! LoginService.checkLoginStatus()){
			return "redirect:login";
		}
        
		//Validate user input:
		Set<ConstraintViolation<ProblemForm>> violations = InputValidator.validateProblemForm(problem);
		
		if(violations.size() > 0){
			model.addAttribute("Violations", violations);
			model.addAttribute("pageName", "add");
			return "Add";
		}
		else{
			Ticket ticket= new Ticket();
			ticket.setEmpName(problem.getEmpName());
			ticket.setProbTitle(problem.getProbTitle());
			ticket.setProbDisc(problem.getProbDisc());
			ticket.setStatus("New");
			ticket.setAssigned_to("");
			ticket.setTicketDateTime(new Timestamp(System.currentTimeMillis()));
			boolean res= TicketsService.createTicket(ticket);
			String response="";
			if (res){
				response="Record added successfully!";
			}else
			{
				response="Some error happend. Record has not been added..";
			}
			  	
			return "redirect:display";
		}
	}
    
    
	/**
	 * Searching for ticket(s) by assigned to employee name.
	 * @param Model model
	 * @param String searchItem
	 * @return List<Ticket>
	 */
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(Model model, @RequestParam String searchItem){
    	List<Ticket> results= TicketsService.findTicket(searchItem);
    	model.addAttribute("AllTickets", results);
		model.addAttribute("pageName","index");
    	return "Index";
    }
    
    
    /**
     * Gets a list of tickets according to the required tickets status. 
     * @param Model model
     * @param String sortItem
     * @return List<Ticket>
     */
    @RequestMapping(value="/sort", method=RequestMethod.POST)
    public String sort(Model model ,@RequestParam String sortItem){
    	if(sortItem.equals("all")){
    		return "redirect:display";
    	}
    	else{
    		List<Ticket> results= TicketsService.getTicketsByStatus(sortItem);
        	model.addAttribute("AllTickets", results);
    		model.addAttribute("pageName","index");
    		return "Index";
    	}
    }
	
}
