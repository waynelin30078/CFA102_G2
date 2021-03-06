package com.product.model;

import java.sql.Date;

public class ProductVO {
	private Integer pNo;
	private String categoryName;
	private String pName;
	private Integer pPrice;
	private String pInfo;
	private Integer pQuantity;
	private Date pOnDate;
	private Date pOffDate;
	private String pImage1;
	private String pImage2;
	private String pImage3;
	private Integer pRatingsQuantity;
	private Integer pTotalRatings;
	private Integer pState;
	
	
	public Integer getpNo() {
		return pNo;
	}
	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getpPrice() {
		return pPrice;
	}
	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	public Integer getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(Integer pQuantity) {
		this.pQuantity = pQuantity;
	}
	public Date getpOnDate() {
		return pOnDate;
	}
	public void setpOnDate(Date pOnDate) {
		this.pOnDate = pOnDate;
	}
	public Date getpOffDate() {
		return pOffDate;
	}
	public void setpOffDate(Date pOffDate) {
		this.pOffDate = pOffDate;
	}
	public String getpImage1() {
		return pImage1;
	}
	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}
	public String getpImage2() {
		return pImage2;
	}
	public void setpImage2(String pImage2) {
		this.pImage2 = pImage2;
	}
	public String getpImage3() {
		return pImage3;
	}
	public void setpImage3(String pImage3) {
		this.pImage3 = pImage3;
	}
	public Integer getpRatingsQuantity() {
		return pRatingsQuantity;
	}
	public void setpRatingsQuantity(Integer pRatingsQuantity) {
		this.pRatingsQuantity = pRatingsQuantity;
	}
	public Integer getpTotalRatings() {
		return pTotalRatings;
	}
	public void setpTotalRatings(Integer pTotalRatings) {
		this.pTotalRatings = pTotalRatings;
	}
	public Integer getpState() {
		return pState;
	}
	public void setpState(Integer pState) {
		this.pState = pState;
	}
	
}
