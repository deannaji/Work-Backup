package com.uci.oit.pts.site.controllers;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.uci.oit.pts.site.domain.ProblemForm;
import com.uci.oit.pts.site.domain.Ticket;
import com.uci.oit.pts.site.services.InputValidationServiceInterface;
import com.uci.oit.pts.site.services.StringSanitizationServiceInterface;
import com.uci.oit.pts.site.services.TicketsServiceInterface;
import com.uci.oit.pts.site.services.LoginServiceInterface;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	
	@Mock
	TicketsServiceInterface TicketsService;
	@Mock
	LoginServiceInterface LoginService;
	@Mock
	InputValidationServiceInterface InputValidator;
	@Mock
	StringSanitizationServiceInterface StringSanitizor;
	
	HomeController sut;

	@Before
	public void setup(){
		this.sut = new HomeController(TicketsService, LoginService, InputValidator, StringSanitizor);
	}

	
	@Test
	public void testGreeting() {
		assertEquals("Message from HomeController: Welcome to the Public Tickets System!", sut.greeting());
	}


	@Test
	public void testIndex() throws Exception{
		boolean result = true;
		when(LoginService.checkLoginStatus()).thenReturn(result);
		assertEquals("redirect:display", sut.index());
		verify(LoginService).checkLoginStatus();
	}

	
	@Ignore
	@Test
	public void testLoginModelString() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testLoginStringString() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testLogout() {
		//doNothing().when(LoginService.logUserOut());
	}

	@Test
	public void testGetTicket() {
		Model model = mock(Model.class);
		Map<String, Object> map;
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.getTicket(1)).thenReturn(new HashMap<>());
		
		assertEquals("ListATicket", sut.getTicket(model, 1));
		verify(LoginService).checkLoginStatus();
		verify(TicketsService).getTicket(1);
	}

	@Test
	public void testGetAllTickets(){
		Model model = mock(Model.class);
		List<Ticket> tickets = new ArrayList<>();
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.getAllTickets()).thenReturn(tickets);
		
		assertEquals("Index", sut.getAllTickets(model));
		verify(LoginService).checkLoginStatus();
		verify(TicketsService).getAllTickets();
	}

	@Ignore
	@Test
	public void testEditTicketModelInt() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testEditTicketIntStringStringString() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testAddTicketGETReq() {
		Model model = mock(Model.class);
		when(LoginService.checkLoginStatus()).thenReturn(true);
		assertEquals("Add", sut.addTicket(model));
		verify(LoginService).checkLoginStatus();
	}

	@Test
	public void testAddPOSTReq() {
		/*Model model = mock(Model.class);
		Set<ConstraintViolation<ProblemForm>> violations = new
		
		when(LoginService.checkLoginStatus()).thenReturn(true);*/
		
	}

	
	@Test
	public void testSearch(){
		Model model = mock(Model.class);
		List<Ticket> resultsList = new ArrayList<>();
		when(TicketsService.findTicket(any(String.class))).thenReturn(resultsList);
		assertEquals("Index", sut.search(model, "test string"));
		verify(TicketsService).findTicket("test string");
	}
	
	
	@Test
	public void testSort() {
		Model model = mock(Model.class);
		List<Ticket> results = new ArrayList<>();
	    String sortItem="active";
	    //String sortItem="all";
	    when(TicketsService.getTicketsByStatus(sortItem)).thenReturn(results);
	    assertEquals("Index", sut.sort(model, sortItem));
	    //assertEquals("redirect:display", sut.sort(model, sortItem));
	    verify(TicketsService).getTicketsByStatus(sortItem);
	}

}
