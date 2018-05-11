package com.uci.oit.pts.site.repository;

import java.util.List;
import java.util.Map;

import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;

public interface TicketsDaoInterface {

	/**
	 * getTicket method brings one ticket by id from the DB.
	 * <b>Note: This method uses JPA api</b> 
	 * @param integer id. 
	 * @return Ticket instance.
	 */
	Map<String, Object> getTicket(int id);
	
	/**
	 * @param N/A
	 * @return List of all tickets
	 */
	List<Ticket> getAllTickets();

	
	boolean createTicket(Ticket ticket);
	
	
	boolean updateTicket(int id, Map<String,String> params);
	
	boolean addNote(TicketNote note);
}