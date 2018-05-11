package com.uci.oit.site;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDaoTest {

	EmployeeRowMapper rowMapper = mock(EmployeeRowMapper.class);
	JdbcTemplate mockJdbcTemplate = mock(JdbcTemplate.class);
	EmployeesDao sut = new EmployeesDao(mockJdbcTemplate);

	
	@Test
	public void testGetEmployeeName() {
		when(mockJdbcTemplate.queryForObject("Select firstname from MYCOMPANY.employees where id=1", String.class)).thenReturn("test string");
		sut.getEmployeeName();
		verify(mockJdbcTemplate).queryForObject("Select firstname from MYCOMPANY.employees where id=1", String.class);
	}

	@Test
	public void testGetEmployee() {
		String sql="Select id,firstname,lastname,salary from dean_employees where id=?";
		int id=1;
		when(mockJdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper)).thenReturn(Employee.class);
		sut.getEmployee(1);
		verify(mockJdbcTemplate).queryForObject(any(String.class), any(Integer[].class), any(EmployeeRowMapper.class));
	}

	
	@Test
	public void testGetAllEmployees() {
		String sql="select * from dean_employees";
		List<Employee> list = mock(List.class);
			
		when(mockJdbcTemplate.query(any(String.class), any(EmployeeRowMapper.class))).thenReturn(list);
		sut.getAllEmployees();
		verify(mockJdbcTemplate).query(any(String.class), any(EmployeeRowMapper.class));
	}

}
