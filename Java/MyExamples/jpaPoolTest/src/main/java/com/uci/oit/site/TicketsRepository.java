package com.uci.oit.site;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TicketsRepository {

	@PersistenceContext
	EntityManager manager;
	
	public Ticket getATicket(int id){
       	Ticket t1 = manager.find(Ticket.class, id);
       	return t1;
	}
}
