package com.uci.oit.pts.site.repository;

import static org.junit.Assert.*;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import org.junit.Ignore;
import org.junit.Test;

import com.uci.oit.pts.site.domain.Ticket;

public class TicketsDaoTest {
	
	//@PersistenceContext
	//EntityManager manager;
	
    //@Inject
	//UserTransaction transaction;

	
	@Ignore
	@Test
	public void testTicketsDao() {
		//Don't really want to test the constructor.
	}

	@Ignore
	@Test
	public void testGetTicket() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTickets() {
		//EntityManager mockManager = mock(EntityManager.class);
		//EntityTransaction mockTransaction = mock(EntityTransaction.class);
		
		TicketsDao sut = new TicketsDao();
		List<Ticket> resultsList= sut.getAllTickets();
		assertNotNull(resultsList);
	}

	@Ignore
	@Test
	public void testCreateTicket() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateTicket() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testAddNote() {
		fail("Not yet implemented");
	}

}
