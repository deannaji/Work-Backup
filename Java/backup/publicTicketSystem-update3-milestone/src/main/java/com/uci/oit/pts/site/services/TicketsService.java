package com.uci.oit.pts.site.services;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;
import com.uci.oit.pts.site.repository.TicketsDaoInterface;

@Service
public class TicketsService implements TicketsServiceInterface{

	private TicketsDaoInterface ticketsDao;
	
	@Inject
	public TicketsService(TicketsDaoInterface ticketsDao){
		this.ticketsDao = ticketsDao;
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
	public boolean createTicket(Ticket ticket) {
		boolean result= ticketsDao.createTicket(ticket);
		return result;
	}

	@Override
	public boolean updateTicket(int id, Map<String, String> params) {
		boolean result= ticketsDao.updateTicket(id, params);
		return result;
	}

	@Override
	public boolean addNote(TicketNote note) {
		boolean result= ticketsDao.addNote(note);
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
