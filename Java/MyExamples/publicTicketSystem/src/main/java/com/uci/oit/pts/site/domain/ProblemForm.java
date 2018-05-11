package com.uci.oit.pts.site.domain;

import javax.persistence.Column;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;


/**
 * ProblemForm domain class.
 * Submitted by user, then mapped into Ticket entity class.
 * @author najih
 *
 */
public class ProblemForm {
	//@NotEmpty
	@SafeHtml
	@Length(min=1, message="Employee Name must not be empty")
	@Column(name="empName")
	private String empName;
	
	//@NotEmpty
	@Length(min=1, message="Problem title must not be empty")
	@SafeHtml
	private String probTitle;
	
	@SafeHtml
	private String probDisc;
	
	
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
	
}
