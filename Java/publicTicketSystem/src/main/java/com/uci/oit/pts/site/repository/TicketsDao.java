package com.uci.oit.pts.site.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;

/**
 * Tickets Data Access Object. 
 * Please refer to @see com.uci.oit.pts.site.repository.TicketsDaoInterface 
 * for methods details.
 * @author Dean Naji (najih)
 *
 */
@Repository
public class TicketsDao implements TicketsDaoInterface {
	//EntityManagerFactory factory;
	//EntityManager manager;
	//EntityTransaction transaction;
	
    //@PersistenceContext 
	protected EntityManager manager;
	
	
	/*@Inject
	EntityManager manager;*/
	
	
	public TicketsDao(){
		//this.factory = Persistence.createEntityManagerFactory("EntityMappings");
		//this.manager = factory.createEntityManager();
	}
	
	
	
	@Override
	public Map<String, Object> getTicket(int id){

	    Ticket ticket1= manager.find(Ticket.class, id);
	    List<TicketNote> ticketNotesList = manager.createQuery("Select n from TicketNote n WHERE n.ticket_id=:ticketId",TicketNote.class).setParameter("ticketId", id).getResultList();
		
	    Map<String, Object> results = new HashMap<>();
	    results.put("ticket", ticket1);
	    results.put("ticketNotes", ticketNotesList);
		return results;
	}


	@Override
	public List<Ticket> getAllTickets(){
		List<Ticket> resultsList= manager.createQuery("Select t from Ticket t", Ticket.class).getResultList();
		return resultsList;
	}
	
	@Override
	public boolean createTicket(Ticket ticket){
	   boolean result= false;
	   //transaction= manager.getTransaction();
	   try{
	   //transaction.begin();	   
	   manager.persist(ticket);
	   //transaction.commit();
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
	    //transaction= manager.getTransaction();
		try{
		//transaction.begin();
		Ticket ticket= manager.find(Ticket.class, id);
	    //updating values only if they changed:
		if(params.get("Status") != "" || params.get("Status") != null){
		   ticket.setStatus(params.get("Status"));	
		}
		if(params.get("AssignedTo") != "" || params.get("AssignedTo") != null){
		   ticket.setAssigned_to(params.get("AssignedTo"));	
		}
		//transaction.commit();
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
		//transaction= manager.getTransaction();
		try{
		//transaction.begin();
		manager.persist(note);
		//transaction.commit();
		result=true;
		}
		catch(Exception e){
			result=false;
		}
		return result;
	}
	
	
	/**
	 * Destructor 
	 *//*
	@Override
	public void finalize(){
		manager.close();
	}*/


	@Override
	public List<Ticket> findTicket(String assigned) {
		List<Ticket> results= manager.createQuery("Select t from Ticket t where t.assigned_to like :name", Ticket.class).setParameter("name", "%"+assigned+"%").getResultList();
		return results;
	}


	@Override
	public List<Ticket> getTicketsByStatus(String status) {
		List<Ticket> results = manager.createQuery("select t from Ticket t where t.status=:status", Ticket.class).setParameter("status", status).getResultList();
		return results;
	}
	
	
}
