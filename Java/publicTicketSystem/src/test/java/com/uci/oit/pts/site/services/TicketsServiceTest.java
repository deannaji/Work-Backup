package com.uci.oit.pts.site.services;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.uci.oit.pts.site.domain.ProblemForm;
import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.domain.TicketNote;
import com.uci.oit.pts.site.repository.TicketsDao;

@RunWith(MockitoJUnitRunner.class)
public class TicketsServiceTest {
    
	@Mock
    TicketsDao ticketsDao;
    @Mock
    InputValidator inputValidator;
    @Mock
    StringSanitizor stringSanitizor;
    TicketsService sut;
   
    
    @Before
    public void setup(){
    	sut = new TicketsService(ticketsDao, inputValidator, stringSanitizor);	
    }
	
	
	@Test
	public void testInti(){
		assertNotNull(sut);
	}
	
	@Test
	public void testGetTicket() {
		when(ticketsDao.getTicket(any(int.class))).thenReturn(new HashMap<String,Object>());
		sut.getTicket(1);
		verify(ticketsDao).getTicket(1);
	}

	
	@Test
	public void testGetAllTickets() {
		List<Ticket> list = new ArrayList<>();
		when(ticketsDao.getAllTickets()).thenReturn(list);
		sut.getAllTickets();
		verify(ticketsDao).getAllTickets();
	}
	

	@Test
	public void testCreateTicket() {
		ProblemForm input = new ProblemForm();
		Ticket ticket = new Ticket();
		Set<ConstraintViolation<ProblemForm>> violations = mock(Set.class);
		when(inputValidator.validateProblemForm(input)).thenReturn(violations);
		when(violations.size()).thenReturn(0);
		when(ticketsDao.createTicket(ticket)).thenReturn(true);
		
		assertEquals(violations, sut.createTicket(input));
		verify(violations).size();
		verify(ticketsDao).createTicket(ticket);
	}

	
	@Test
	public void testUpdateTicket() {
		int id=1;
		Map<String, String> params = new HashMap<>();
		when(ticketsDao.updateTicket(id, params)).thenReturn(true);
		assertTrue(sut.updateTicket(id, params));
		verify(ticketsDao).updateTicket(id, params);
	}


	@Test
	public void testAddNote() {
		String note="test note";
		TicketNote ticketNote = new TicketNote();
		when(stringSanitizor.sanitizeWithHtmlEscape(note)).thenReturn(note);
		when(ticketsDao.addNote(any(TicketNote.class))).thenReturn(true);
		assertTrue(sut.addNote(note, 1));
		verify(stringSanitizor).sanitizeWithHtmlEscape(note);
		//verify(ticketsDao).addNote(ticketNote);
	}

	
	@Test
	public void testFindTicket() {
		when(ticketsDao.findTicket(any(String.class))).thenReturn(new ArrayList<Ticket>());
		assertEquals(new ArrayList<Ticket>(), sut.findTicket("test employee"));
		verify(ticketsDao).findTicket("test employee");
	}

	
	@Test
	public void testGetTicketsByStatus() {
		when(ticketsDao.getTicketsByStatus(any(String.class))).thenReturn(new ArrayList<Ticket>());
		assertEquals( new ArrayList<Ticket>(), sut.getTicketsByStatus("test status"));
		verify(ticketsDao).getTicketsByStatus("test status");
	}

}
