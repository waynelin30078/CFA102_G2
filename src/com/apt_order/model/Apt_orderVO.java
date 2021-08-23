package com.apt_order.model;

import java.sql.Timestamp;

public class Apt_orderVO implements java.io.Serializable{
	private Integer aptOrderNo;
	private Integer mNo;
	private Integer dNo;
	private Timestamp orderTime;
	private Timestamp orderDate;
	private Integer clPrice;
	private Integer clState;
	private String aptReviews;
	
	public Apt_orderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAptOrderNo() {
		return aptOrderNo;
	}
	public void setAptOrderNo(Integer aptOrderNo) {
		this.aptOrderNo = aptOrderNo;
	}
	public Integer getmNo() {
		return mNo;
	}
	public void setmNo(Integer mNo) {
		this.mNo = mNo;
	}
	public Integer getdNo() {
		return dNo;
	}
	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getClPrice() {
		return clPrice;
	}
	public void setClPrice(Integer clPrice) {
		this.clPrice = clPrice;
	}
	public Integer getClState() {
		return clState;
	}
	public void setClState(Integer clState) {
		this.clState = clState;
	}
	public String getAptReviews() {
		return aptReviews;
	}
	public void setAptReviews(String aptReviews) {
		this.aptReviews = aptReviews;
	}

}
