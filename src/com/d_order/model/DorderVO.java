package com.d_order.model;

import java.sql.Date;
import java.sql.Timestamp;

public class DorderVO {

	private Integer dOrderNo;
	private Integer dNo;
	private Integer mNo;
	private Timestamp subStart;
	private Timestamp subEnd;
	private Integer mthFee;
	private String dReview;
	private Integer dScore;
	private Integer autoSubs;

	public DorderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DorderVO(Integer dNo, Integer mNo, Timestamp subStart, Timestamp subEnd, Integer mthFee,
			String dReview, Integer dScore, Integer autoSubs) {
		super();
		
		this.dNo = dNo;
		this.mNo = mNo;
		this.subStart = subStart;
		this.subEnd = subEnd;
		this.mthFee = mthFee;
		this.dReview = dReview;
		this.dScore = dScore;
		this.autoSubs = autoSubs;
	}

	public Integer getdOrderNo() {
		return dOrderNo;
	}

	public void setdOrderNo(Integer dOrderNo) {
		this.dOrderNo = dOrderNo;
	}

	public Integer getdNo() {
		return dNo;
	}

	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}

	public Integer getmNo() {
		return mNo;
	}

	public void setmNo(Integer mNo) {
		this.mNo = mNo;
	}

	public Timestamp getSubStart() {
		return subStart;
	}
 
	public void setSubStart(Timestamp subStart) {
		this.subStart = subStart;
	}

	public Timestamp getSubEnd() {
		return subEnd;
	}

	public void setSubEnd(Timestamp subEnd) {
		this.subEnd = subEnd;
	}

	public Integer getMthFee() {
		return mthFee;
	}

	public void setMthFee(Integer mthFee) {
		this.mthFee = mthFee;
	}

	public String getdReview() {
		return dReview;
	}

	public void setdReview(String dReview) {
		this.dReview = dReview;
	}

	public Integer getdScore() {
		return dScore;
	}

	public void setdScore(Integer dScore) {
		this.dScore = dScore;
	}

	public Integer getAutoSubs() {
		return autoSubs;
	}

	public void setAutoSubs(Integer autoSubs) {
		this.autoSubs = autoSubs;
	}

}
