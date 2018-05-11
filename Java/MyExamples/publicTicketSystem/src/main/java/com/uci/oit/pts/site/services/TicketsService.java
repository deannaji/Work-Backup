package com.uci.oit.pts.site.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uci.oit.pts.site.domain.ProblemForm;
import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;
import com.uci.oit.pts.site.repository.TicketsDaoInterface;

@Service
public class TicketsService implements TicketsServiceInterface{

	private TicketsDaoInterface ticketsDao;
	private InputValidationServiceInterface InputValidator;
	private StringSanitizationServiceInterface StringSanitizor;
	
	@Inject
	public TicketsService(TicketsDaoInterface ticketsDao, InputValidationServiceInterface InputValidator, StringSanitizationServiceInterface StringSanitizor){
		this.ticketsDao = ticketsDao;
		this.InputValidator= InputValidator;
		this.StringSanitizor= StringSanitizor;
	}
	
	
	@Override
	public Map<String, Object> getTicket(int id) {
		Map<String, Object> ticketMap= ticketsDao.getTicket(id);
		return ticketMap;
	}

	
	@Override
	public List<Ticket> getAllTickets() {
		List<Ticket> allTickets= ticketsDao.getAllTickets();
		return allTickets;
	}

	
	@Override
	@Transactional
	public Set<ConstraintViolation<ProblemForm>> createTicket(ProblemForm problem) {
		
		//Validate user input:
		Set<ConstraintViolation<ProblemForm>> violations = InputValidator.validateProblemForm(problem);
		//if the user entry is valid, then create a new ticket and persist it.
		if(violations.size() <= 0){
			Ticket ticket= new Ticket();
			ticket.setEmpName(problem.getEmpName());
			ticket.setProbTitle(problem.getProbTitle());
			ticket.setProbDisc(problem.getProbDisc());
			ticket.setStatus("New");
			ticket.setAssigned_to("");
			ticket.setTicketDateTime(new Timestamp(System.currentTimeMillis()));
			
			boolean result= ticketsDao.createTicket(ticket);
		}
		return violations;
	}

	
	@Override
	@Transactional
	public boolean updateTicket(int id, Map<String, String> params) {
		boolean result= ticketsDao.updateTicket(id, params);
		return result;
	}

	
	@Override
	@Transactional
	public boolean addNote(String note, int id) {
		//Input sanitization on the domain class.  
		note = StringSanitizor.sanitizeWithHtmlEscape(note);
		
		TicketNote ticketNote = new TicketNote();
		ticketNote.setNote(note);
		ticketNote.setTicket_id(id);
		ticketNote.setTimestamp(new Timestamp(System.currentTimeMillis()));
		boolean result= ticketsDao.addNote(ticketNote);
		return result;
	}

	
	@Override
	public List<Ticket> findTicket(String assigned) {
    	List<Ticket> results= ticketsDao.findTicket(assigned);
		return results;
	}

	
	@Override
	public List<Ticket> getTicketsByStatus(String status) {
		List<Ticket> results= ticketsDao.getTicketsByStatus(status);
		return results;
	}

}
