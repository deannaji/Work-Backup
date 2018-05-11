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
import java.util.TreeSet;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

import org.hibernate.exception.ConstraintViolationException;
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
	
	
	HomeController sut;

	@Before
	public void setup(){
		this.sut = new HomeController(TicketsService, LoginService);
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

	
	@Test
	public void testEditTicketGETReq() {
		Model model = mock(Model.class);
		Map<String, Object> map = new HashMap<>();
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.getTicket(any(int.class))).thenReturn(map);
		
		assertEquals("Edit", sut.editTicket(model, 1));
		
		verify(TicketsService).getTicket(1);
	}

	
	/**
	 * Testing editTicket POST request method.
	 * Four test methods are used below to represent the four scenarios of this method. 
	 */
	@Test
	public void testEditTicketPOSTReqParamsAndNote() {
		int id=1;
		Map<String, String> testParams = new HashMap<>();
		testParams.put("Status", "test status");
		testParams.put("AssignedTo", "test employee");
		String note="test note";
		
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.updateTicket(id, testParams)).thenReturn(true);
		when(TicketsService.addNote(note,id)).thenReturn(true);
		
		assertEquals("redirect:edit?id="+id,sut.editTicket(id, "test status", "test employee", note));
		
		verify(LoginService).checkLoginStatus();
		verify(TicketsService).updateTicket(id, testParams);
		verify(TicketsService).addNote(note, id);
	}
	@Test
	public void testEditTicketPOSTReqEmptyParams() {
		int id=1;
		Map<String, String> emptyTestParams = new HashMap<>();
		emptyTestParams.put("Status", "");
		emptyTestParams.put("AssignedTo", "");
		String note="test note";
		
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.updateTicket(id, emptyTestParams)).thenReturn(false);
		when(TicketsService.addNote(note,id)).thenReturn(true);
		
		assertEquals("redirect:edit?id="+id,sut.editTicket(id, emptyTestParams.get("Status"), emptyTestParams.get("AssignedTo"), note));
		
		
		verify(LoginService).checkLoginStatus();
		verify(TicketsService).updateTicket(id, emptyTestParams);
		verify(TicketsService).addNote(note, id);
	}
	@Test
	public void testEditTicketPOSTReqOneParam() {
		int id=1;
		Map<String, String> testParams = new HashMap<>();
		testParams.put("Status", "");
		testParams.put("AssignedTo", "test employee");
		String note="test note";
		
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.updateTicket(id, testParams)).thenReturn(true);
		when(TicketsService.addNote(note,id)).thenReturn(true);
		
		assertEquals("redirect:edit?id="+id,sut.editTicket(id, testParams.get("Status"), testParams.get("AssignedTo"), note));
		
		verify(LoginService).checkLoginStatus();
		verify(TicketsService).updateTicket(id, testParams);
		verify(TicketsService).addNote(note, id);
	}
	@Test
	public void testEditTicketPOSTReqParamsEmptyNote() {
		int id=1;
		Map<String, String> testParams = new HashMap<>();
		testParams.put("Status", "test status");
		testParams.put("AssignedTo", "test employee");
		String emptyNote="";
		
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.updateTicket(id, testParams)).thenReturn(true);
		when(TicketsService.addNote(emptyNote, id)).thenReturn(false);
		
		assertEquals("redirect:edit?id="+id,sut.editTicket(id, testParams.get("Status"), testParams.get("AssignedTo"), emptyNote));
		
		verify(LoginService).checkLoginStatus();
		verify(TicketsService).updateTicket(id, testParams);
	}
	//End of editTicket POST request method test.

	
	@Test
	public void testAddTicketGETReq() {
		Model model = mock(Model.class);
		when(LoginService.checkLoginStatus()).thenReturn(true);
		assertEquals("Add", sut.addTicket(model));
		verify(LoginService).checkLoginStatus();
	}

	@Test
	public void testAddPOSTReqHappyPath() {
		Model model = mock(Model.class);
		ProblemForm problem = new ProblemForm();
		Set<ConstraintViolation<ProblemForm>> res = new TreeSet<>();
		when(LoginService.checkLoginStatus()).thenReturn(true);
		when(TicketsService.createTicket(problem)).thenReturn(res);
		
		assertEquals("redirect:display", sut.addTicket(problem, model));
		
		verify(TicketsService).createTicket(problem);
	}
	@Test
	public void testAddPOSTReqNotHappyPath() {
		Model model = mock(Model.class);
		ProblemForm problem = new ProblemForm();
		Set<ConstraintViolation<ProblemForm>> res = new TreeSet<>();
		when(LoginService.checkLoginStatus()).thenReturn(true);
		res.add(new Violation());
		when(TicketsService.createTicket(problem)).thenReturn(res);
		assertEquals("Add", sut.addTicket(problem, model));
		
		verify(TicketsService).createTicket(problem);
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
	
	
	
	
	
	/**
	 * Empty concrete implementation for ConstraintViolation interface, serves as a mock user input violation.
	 * @author najih
	 *
	 */
	class Violation implements ConstraintViolation<ProblemForm>, Comparable{
		@Override
		public ConstraintDescriptor<?> getConstraintDescriptor() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object[] getExecutableParameters() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object getExecutableReturnValue() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object getInvalidValue() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object getLeafBean() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getMessageTemplate() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Path getPropertyPath() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ProblemForm getRootBean() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Class<ProblemForm> getRootBeanClass() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> U unwrap(Class<U> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}}

}
