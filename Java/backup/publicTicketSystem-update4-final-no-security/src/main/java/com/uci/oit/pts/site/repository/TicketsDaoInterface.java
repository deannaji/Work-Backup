package com.uci.oit.pts.site.repository;

import java.util.List;
import java.util.Map;

import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;

/**
 * Ticket Dao Interface is the contract specifying ticket persistence and manipulation
 * operations.  
 * @author najih
 *
 */
public interface TicketsDaoInterface {

	/**
	 * getTicket method brings one ticket by id from the DB.
	 * <b>Note: This method uses JPA api</b> 
	 * @param integer id. 
	 * @return Ticket instance.
	 */
	Map<String, Object> getTicket(int id);
	
	
	/**
	 * Gets a <b>List<Ticket></b> of all tickets.
	 * @param void
	 * @return List of all tickets
	 */
	List<Ticket> getAllTickets();

	
	/**
	 * This method creates a single ticket object, then store it in the DB.
	 * @param ticket
	 * @return boolean creation status
	 */
	boolean createTicket(Ticket ticket);
	
	
	/**
	 * This method updates a ticket values in the DB.
	 * @param id
	 * @param params
	 * @return boolean updating status
	 */
	boolean updateTicket(int id, Map<String,String> params);
	
	
	/**
	 * This method adds a note for a specific ticket (by ticket number) to the DB.
	 * @param note
	 * @return boolean add note status
	 */
	boolean addNote(TicketNote note);
	
	
	/**
	 * This method finds a ticket or a group of tickets and returns the result as a List. 
	 * @param assigned
	 * @return List<Ticket>
	 */
	List<Ticket> findTicket(String assigned);
	
	
	/**
	 * This method get a group of tickets by status.
	 * @param status
	 * @return List<Ticket>
	 */
	List<Ticket> getTicketsByStatus(String status);
}