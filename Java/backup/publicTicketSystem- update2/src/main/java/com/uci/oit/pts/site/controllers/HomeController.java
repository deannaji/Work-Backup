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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/")
public class HomeController {
	TicketsDaoInterface ticketsDao;
	//final static Logger log= Logger.getLogger(HomeController.class);
	
	@Autowired
	private HttpSession session; //getting a handle on HttpSession by simply only injecting it.
	
	@Autowired
	public HomeController(TicketsDaoInterface ticketsDao){
		this.ticketsDao= ticketsDao;
	}
	
	
	private final boolean checkLoginStatus(){
		if(session.getAttribute("username") != null){
			return true;	
		}else{
			return false;
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/greeting", method= RequestMethod.GET)
	public String greeting(){
		return "Message from HomeController: Welcome to the Public Tickets System!";
		
	}
	
	/**
	 * Index of the web app.
	 * @return Redirect
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		//if no username found in session, then goto login page
		if (! checkLoginStatus()){
			return "redirect:login";
		}else{
			return "redirect:display";
		}
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpServletResponse response ,Model model, @RequestParam(required=false) String ucinetid_auth) throws IOException{
		//if UCI WebAuth used for login:
		if(ucinetid_auth != null){
			//creating a get request to get UCINetId:
			URL urlObj = new URL("https://login.uci.edu/ucinetid/webauth_check?ucinetid_auth="+ucinetid_auth);
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();	
			
			//Parsing the response using buffered reader:
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer responseBuffer = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				responseBuffer.append(inputLine+" ");
			}
			in.close();	
			
			String responseStr = responseBuffer.toString();
			//Now using Apache Commons String Utils lib (maven dependency) to parse the response string and get UCINetId.
			String ucinetid= StringUtils.substringBetween(responseStr, "ucinetid=","auth");
			session.setAttribute("username", ucinetid);
			return "redirect:display"; 
		}
		else//Then use website local login:
		{
		  return "Login";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password){
		if(username.equals("test") && password.equals("test")){
			session.setAttribute("username", username);
			return "redirect:display";
		}else{
		return "redirect:login";
		}
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
		if(! checkLoginStatus()){
			return "redirect:login";
		}
		Map<String, Object> ticketMap= ticketsDao.getTicket(id);
		model.addAttribute("ticket1", ticketMap.get("ticket"));
		return "ListATicket";
	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String getAllTickets(Model model){
		//if no username found in session, then goto login page
		if(! checkLoginStatus()){
			return "redirect:login";
		}
		
		List<Ticket> results= ticketsDao.getAllTickets();
		model.addAttribute("AllTickets", results);
		model.addAttribute("pageName","index");
		return "Index";
	}
	
	
	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editTicket(Model model, @RequestParam int id){
		//if no username found in session, then goto login page
		if(! checkLoginStatus()){
			return "redirect:login";
		}
		
		//Ticket ticket= ticketsDao.getTicket(id);
		Map<String, Object> ticketMap= ticketsDao.getTicket(id);
		model.addAttribute("ticket", ticketMap.get("ticket"));
		model.addAttribute("notes", ticketMap.get("ticketNotes"));
		return "Edit";
	}
	
	@ResponseBody
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editTicket(@RequestParam int id, @RequestParam(required=false) String status, @RequestParam(required=false) String assignedTo, 
			@RequestParam(required=false) String note, @RequestBody String postPayload, @RequestParam(value = "_csrf", required = false) String csrf){
		
		//if no username found in session, then goto login page
		if(! checkLoginStatus()){
			return "redirect:login";
		}
		
		/*String response="";
		boolean resultNotesAdding=false;
		Map<String, String> params = new HashMap<>();
		params.put("Status", status);
		params.put("AssignedTo", assignedTo);
		if(params.size() > 0){
			boolean result= ticketsDao.updateTicket(id, params); 
			if (result){
				response="Record updated successfully!";
			}else
			{
				response="Some error happend. Record has not been updated..";
			}
		}
		if(!note.isEmpty()){
			note = HtmlUtils.htmlEscape(note);
			TicketNote ticketNote = new TicketNote();
			ticketNote.setNote(note);
			ticketNote.setTicket_id(id);
			ticketNote.setTimestamp(new Timestamp(System.currentTimeMillis()));
			resultNotesAdding= ticketsDao.addNote(ticketNote); 
		}
		return "redirect:edit?id="+id; */
		
		return postPayload;
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addTicket(Model model){
		//if no username found in session, then goto login page
		if(! checkLoginStatus()){
			return "redirect:login";
		}
		
		model.addAttribute("pageName","add");
		return "Add";
	}
	
    @ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addTicket(ProblemForm problem, Model model, @RequestBody String postPayload){
		//if no username found in session, then goto login page
		if(! checkLoginStatus()){
			return "redirect:login";
		}
		/*Logger logger = LoggerFactory.getLogger(getClass());
		logger.info("Hello test!");
		logger.info((String) session.getAttribute("_csrf"));*/
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<ProblemForm>> violations = validator.validate(problem);
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
			boolean res= ticketsDao.createTicket(ticket);
			String response="";
			if (res){
				response="Record added successfully!";
			}else
			{
				response="Some error happend. Record has not been added..";
			}
			  	
			return "redirect:display";
		}*/
		return postPayload;
	}
	
}
