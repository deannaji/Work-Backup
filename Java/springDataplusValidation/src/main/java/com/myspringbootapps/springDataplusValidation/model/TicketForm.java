package com.myspringbootapps.springDataplusValidation.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;

public class TicketForm
{
    @NotEmpty(message="Employee Name must not be empty")
    //@SafeHtml
    @NotNull
    @Length(min=3, message="Employee Name must have a minimum of 3 chars")
    @Size(min=3, message="Employee Name must have a minimum of 3 chars")
    @Column(name="empName")
    private String empName;
    
    @NotEmpty(message="Problem title must not be empty")
    @Length(min=3, message="Problem title must have a minimum of 3 chars")
    @Size(min=3, message="Problem title must have a minimum of 3 chars")
    //@SafeHtml
    private String probTitle;
    
    //@SafeHtml
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
