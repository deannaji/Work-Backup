package com.uci.oit.pts.site.controllers;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.uci.oit.pts.site.controllers.HomeController;
import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.repository.TicketsDaoInterface;

import antlr.collections.List;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	@Mock
	TicketsDaoInterface ticketsDao;
	HomeController sut;
	
	@Before
	public void setup(){
	  sut= new HomeController(ticketsDao);
	}
	
	@Test
	public void testGreeting() {
		assertEquals(sut.greeting(),"Message from HomeController: Welcome to the Public Tickets System!");
	}


	@Test
	public void testGetTicket() {
		Model model = mock(Model.class);
		
		when(ticketsDao.getTicket(any(int.class))).thenReturn(new HashMap<String, Object>());
		//sut.getTicket(model, 1);
		
		verify(ticketsDao).getTicket(1);
	}


	@Test
	public void testGetAllTickets() {
		Model model= mock(Model.class);
		//List resultsList = mock(List.class);
		
		when(ticketsDao.getAllTickets()).thenReturn(new ArrayList<Ticket>());
		//sut.getAllTickets(model);
		
		verify(ticketsDao).getAllTickets();
	}


	@Test
	public void testEditTicketGet() {
		Model model = mock(Model.class);
		
		when(ticketsDao.getTicket(any(int.class))).thenReturn(new HashMap<String, Object>());
		//sut.editTicket(model, 1);
		
		verify(ticketsDao).getTicket(1);
	}

}
