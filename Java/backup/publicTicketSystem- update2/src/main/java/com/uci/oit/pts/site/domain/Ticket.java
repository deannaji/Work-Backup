package com.uci.oit.pts.site.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dean_public_tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String empName;
	
	private String probTitle;
	
	private String probDisc;
	
	private String status;
	
	private String assigned_to;
	
	private Timestamp ticketDateTime;
	
	
	public Ticket(){
		//Required by JPA.
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getProbTitle() {
		return probTitle;
	}
	public void setProbTitle(String probTitle) {
		this.probTitle = probTitle;
	}
	public String getProbDisc() {
		return probDisc;
	}
	public void setProbDisc(String probDisc) {
		this.probDisc = probDisc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getTicketDateTime() {
		return ticketDateTime;
	}
	public void setTicketDateTime(Timestamp ticketDateTime) {
		this.ticketDateTime = ticketDateTime;
	}

	public String getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}
	
	
}
