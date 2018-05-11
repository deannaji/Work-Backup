package com.uci.oit.site;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public interface EmployeesDaoInterface {
    String getEmployeeName();
	Employee getEmployee(int id);
	/*void setdataSource(BasicDataSource dataSource);*/
	List<Employee> getAllEmployees();
}
