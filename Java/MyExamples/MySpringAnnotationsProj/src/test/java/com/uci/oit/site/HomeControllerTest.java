package com.uci.oit.site;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;

public class HomeControllerTest {

	EmployeesDaoInterface mockEmployeesDao = mock(EmployeesDao.class);
	HomeController sut = new HomeController(mockEmployeesDao);
	
	@Test
	public void testObjectInitialization(){
		assertNotNull("Object had not been initialized!",sut);
	}
	
	
	@Test
	public void testHelloWorld() {
		Employee employee = mock(Employee.class);
		when(mockEmployeesDao.getEmployee(1)).thenReturn(employee);
		sut.helloWorld(1);
		verify(mockEmployeesDao).getEmployee(1);
	}


	@Test
	public void testSayName() {
		String str="Hi, this is Hello Controller!";
		assertEquals(sut.sayName(), str);
	}

	@Ignore
	@Test
	public void testGetEmployees() {
		fail("Not yet implemented");
	}

}
