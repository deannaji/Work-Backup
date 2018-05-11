package com.uci.oit.site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private EmployeesDaoInterface EmployeesDao;
	
    @Autowired
    public HomeController(EmployeesDaoInterface EmployeesDao){
    	this.EmployeesDao = EmployeesDao;
    }
    
    
    @ResponseBody
    @RequestMapping("/")
    public String helloWorld(@RequestParam int id){
    	//EmployeesDao.getEmployeeName();
   
    	Employee employee = EmployeesDao.getEmployee(id);
    	String employeeRow= employee.getId()+", "+employee.getFirstName()+" "+employee.getLastName()+", $"+employee.getSalary();
    	return employeeRow;
    }
    
    @ResponseBody
    @RequestMapping("/greeting")
    public String sayName(){
    	return "Hi, this is Hello Controller!";
    }
    
    //@ResponseBody
    @RequestMapping("/employees")
    public String getEmployees(ModelMap model){
    	List<Employee> employees = EmployeesDao.getAllEmployees();
    	Employee employee =employees.get(0);
    	Employee employee2 =employees.get(1);
    	//String employee1Row= employee.getId()+", "+employee.getFirstName()+" "+employee.getLastName()+", $"+employee.getSalary();
    	//String employee2Row= employee2.getId()+", "+employee2.getFirstName()+" "+employee2.getLastName()+", $"+employee2.getSalary();
    	
    	model.addAttribute("employeesList",employees);
    	//model.addAttribute(employee2);
    	//return employee1Row +"<br />"+employee2Row;
    	return "employees";
    }

}
