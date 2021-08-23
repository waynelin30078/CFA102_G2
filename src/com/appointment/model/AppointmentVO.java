package com.appointment.model;

import java.sql.Date;

public class AppointmentVO implements java.io.Serializable {
	private Integer aptNo;
	private Integer dNo;
	private Date rDate;
	private String rState;
	
	
	public AppointmentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAptNo() {
		return aptNo;
	}
	public void setAptNo(Integer aptNo) {
		this.aptNo = aptNo;
	}
	public Integer getdNo() {
		return dNo;
	}
	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public String getrState() {
		return rState;
	}
	public void setrState(String rState) {
		this.rState = rState;
	}
	

}
