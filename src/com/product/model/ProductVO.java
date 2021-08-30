package com.product.model;

import java.sql.Date;

public class ProductVO implements java.io.Serializable {

	private Integer pno;
	private String categoryName;
	private String pname;
	private Integer pprice;
	private String pinfo;
	private Integer pquantity;
	private Date ponDate;
	private Date poffDate;
	private String pimage1;
	private String pimage2;
	private String pimage3;
	private Integer pratingsQuantity;
	private Integer ptotalRatings;
	private Integer pstate;

	public ProductVO() {
		super();
	}

	public ProductVO(Integer pno, String categoryName, String pname, Integer pprice, String pinfo, Integer pquantity,
			Date ponDate, Date poffDate, String pimage1, String pimage2, String pimage3,
			Integer pratingsQuantity, Integer ptotalRatings, Integer pstate) {
		super();
		this.pno = pno;
		this.categoryName = categoryName;
		this.pname = pname;
		this.pprice = pprice;
		this.pinfo = pinfo;
		this.pquantity = pquantity;
		this.ponDate = ponDate;
		this.poffDate = poffDate;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pimage3 = pimage3;
		this.pratingsQuantity = pratingsQuantity;
		this.ptotalRatings = ptotalRatings;
		this.pstate = pstate;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPprice() {
		return pprice;
	}

	public void setPprice(Integer pprice) {
		this.pprice = pprice;
	}

	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public Integer getPquantity() {
		return pquantity;
	}

	public void setPquantity(Integer pquantity) {
		this.pquantity = pquantity;
	}

	public Date getPonDate() {
		return ponDate;
	}

	public void setPonDate(Date ponDate) {
		this.ponDate = ponDate;
	}

	public Date getPoffDate() {
		return poffDate;
	}

	public void setPoffDate(Date poffDate) {
		this.poffDate = poffDate;
	}

	public String getPimage1() {
		return pimage1;
	}

	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

	public String getPimage3() {
		return pimage3;
	}

	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
	}

	public Integer getPratingsQuantity() {
		return pratingsQuantity;
	}

	public void setPratingsQuantity(Integer pratingsQuantity) {
		this.pratingsQuantity = pratingsQuantity;
	}

	public Integer getPtotalRatings() {
		return ptotalRatings;
	}

	public void setPtotalRatings(Integer ptotalRatings) {
		this.ptotalRatings = ptotalRatings;
	}

	public Integer getPstate() {
		return pstate;
	}

	public void setPstate(Integer pstate) {
		this.pstate = pstate;
	}

}
