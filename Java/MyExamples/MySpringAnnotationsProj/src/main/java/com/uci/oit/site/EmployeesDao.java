package com.uci.oit.site;

import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeesDao implements EmployeesDaoInterface{
	private BasicDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    
    @Autowired
    public EmployeesDao(JdbcTemplate jdbcTemplate){
    	this.jdbcTemplate = jdbcTemplate;
    }


	@Override
	public String getEmployeeName() {
    	String firstName = (String) jdbcTemplate.queryForObject("Select firstname from MYCOMPANY.employees where id=1", String.class);
    	String lastName = (String) jdbcTemplate.queryForObject("Select lastname from MYCOMPANY.employees where id=1", String.class);
		return firstName+" "+lastName;
	}
    
    
    /**
     * @param: int id as <i>employee id</i>
     * @return: <b>Employee</b> object
     */
    @Override
	public Employee getEmployee(int id){
    	//this.jdbcTemplate= new JdbcTemplate(dataSource);    	
    	String sql="Select id,firstname,lastname,salary from dean_employees where id=?";
    	
    	Employee employee = (Employee)jdbcTemplate.queryForObject(
    			sql, new Object[] { id }, new EmployeeRowMapper());
    	
    	return employee;
    }
 
  

	@Override
	public List<Employee> getAllEmployees() {
		String sql="select * from dean_employees";
		List<Employee> employees =jdbcTemplate.query(sql, new EmployeeRowMapper());
		return employees;
	}


}
