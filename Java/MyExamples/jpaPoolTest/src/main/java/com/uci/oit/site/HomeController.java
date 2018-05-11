package com.uci.oit.site;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  
	@Inject
	TicketsRepository tickets;
	
	
   @ResponseBody
   @RequestMapping("/ticket")
   public String getTicket(@RequestParam int id){
	   Ticket t1 = tickets.getATicket(id);
	   return "<b>Employee Name:</b> "+t1.getEmpName()+"<br>"+
			  "<b>Problem Title:</b> "+t1.getProbTitle()+"<br>"+
	          "<b>Problem Discreption:</b> "+t1.getProbDisc();
   }
}
