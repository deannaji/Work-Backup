package com.uci.oit.pts.site.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;

public class ProblemForm {
	@NotEmpty
	@SafeHtml
	private String empName;
	
	@NotEmpty
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
