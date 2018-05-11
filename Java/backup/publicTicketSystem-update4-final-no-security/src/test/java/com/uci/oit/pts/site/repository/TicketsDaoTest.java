package com.uci.oit.pts.site.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;

//A unit test is not possible for a JPA Repo. an integration test will do. 
public class TicketsDaoTest {	
	
	private TicketsDao sut;
	
	@Before
	public void setup(){
		sut = new TicketsDao();
	}
	
	
	@Ignore
	@Test
	public void testGetTicket() {
		
	}

	@Ignore
	@Test
	public void testGetAllTickets() {
		fail("Not yet implemented");
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

	@Ignore
	@Test
	public void testFindTicket() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetTicketsByStatus() {
		fail("Not yet implemented");
	}

}
