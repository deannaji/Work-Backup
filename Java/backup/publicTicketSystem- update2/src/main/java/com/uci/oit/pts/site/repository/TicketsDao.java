package com.uci.oit.pts.site.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;

/**
 * Tickets Data Access Object
 * @author Dean Naji (najih)
 *
 */
@Repository
public class TicketsDao implements TicketsDaoInterface {
	EntityManagerFactory factory;
	EntityManager manager;
	EntityTransaction transaction;
	
	//@PersistenceContext EntityManager manager;
	
	public TicketsDao(){
		this.factory = Persistence.createEntityManagerFactory("EntityMappings");
		this.manager = factory.createEntityManager();
	}
	
	
	/**
	 * @see com.uci.oit.pts.site.repository.TicketsDaoInterface#getTicket(int)
	 */	
	@Override
	public Map<String, Object> getTicket(int id){
		transaction = manager.getTransaction();
		transaction.begin();
	    Ticket ticket1= manager.find(Ticket.class, id);
	    List<TicketNote> ticketNotesList = manager.createQuery("Select n from TicketNote n WHERE n.ticket_id=:ticketId",TicketNote.class).setParameter("ticketId", id).getResultList();
		transaction.commit();
		
	    Map<String, Object> results = new HashMap<>();
	    results.put("ticket", ticket1);
	    results.put("ticketNotes", ticketNotesList);
		return results;
	}


	@Override
	public List<Ticket> getAllTickets(){
		transaction = manager.getTransaction();
		transaction.begin();
		List<Ticket> resultsList= manager.createQuery("Select t from Ticket t", Ticket.class).getResultList();
		transaction.commit();
		return resultsList;
	}
	
	@Override
	public boolean createTicket(Ticket ticket){
	   boolean result= false;
	   transaction= manager.getTransaction();
	   try{
	   transaction.begin();	   
	   manager.persist(ticket);
	   transaction.commit();
	   result=true;
	   }
	   catch(Exception e){
		  result=false; 
	   }
	   return result;	
	}
	
	@Override
	public boolean updateTicket(int id, Map<String, String> params){
		boolean result=false;
		transaction= manager.getTransaction();
		try{
		transaction.begin();
		Ticket ticket= manager.find(Ticket.class, id);
		if(params.get("Status") != "" || params.get("Status") != null){
		   ticket.setStatus(params.get("Status"));	
		}
		if(params.get("AssignedTo") != "" || params.get("AssignedTo") != null){
		   ticket.setAssigned_to(params.get("AssignedTo"));	
		}
		transaction.commit();
		result=true;
		}
		catch(Exception e){
			result=false;
		}
		return result;
	}
	
	@Override
	public boolean addNote(TicketNote note){
		boolean result=false;
		transaction= manager.getTransaction();
		try{
		transaction.begin();
		manager.persist(note);
		transaction.commit();
		result=true;
		}
		catch(Exception e){
			result=false;
		}
		return result;
	}
	
	
	/**
	 * Destructor 
	 */
	@Override
	public void finalize(){
		manager.close();
	}
	
	
}
