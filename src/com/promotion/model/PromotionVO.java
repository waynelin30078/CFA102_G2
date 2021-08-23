package com.promotion.model;

import java.sql.Timestamp;

public class PromotionVO implements java.io.Serializable {

	private Integer promNo;
	private String promName;
	private Timestamp promStartTime;
	private Timestamp promEndTime;

	public PromotionVO() {
		super();
	}

	public PromotionVO(Integer promNo, String promName, Timestamp promStartTime, Timestamp promEndTime) {
		super();
		this.promNo = promNo;
		this.promName = promName;
		this.promStartTime = promStartTime;
		this.promEndTime = promEndTime;
	}

	public Integer getPromNo() {
		return promNo;
	}

	public void setPromNo(Integer promNo) {
		this.promNo = promNo;
	}

	public String getPromName() {
		return promName;
	}

	public void setPromName(String promName) {
		this.promName = promName;
	}

	public Timestamp getPromStartTime() {
		return promStartTime;
	}

	public void setPromStartTime(Timestamp promStartTime) {
		this.promStartTime = promStartTime;
	}

	public Timestamp getPromEndTime() {
		return promEndTime;
	}

	public void setPromEndTime(Timestamp promEndTime) {
		this.promEndTime = promEndTime;
	}

}
