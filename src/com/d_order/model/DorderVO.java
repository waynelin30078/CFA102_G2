package com.d_order.model;

import java.sql.Date;

public class DorderVO {
	private Integer dOrderNo;
	private Integer dNo;
	private Integer mNo;
	private Date subStart;
	private Date subEnd;
	private Integer mthFee;
	private String dReview;
	private Integer dScore;

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

	public Date getSubStart() {
		return subStart;
	}

	public void setSubStart(Date subStart) {
		this.subStart = subStart;
	}

	public Date getSubEnd() {
		return subEnd;
	}

	public void setSubEnd(Date subEnd) {
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

}
