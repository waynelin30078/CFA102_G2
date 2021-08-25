package com.promotion_detail.model;

public class Promotion_detailVO implements java.io.Serializable {

	private Integer promNo;
	private Integer pNo;
	private Integer pPrice;

	public Promotion_detailVO() {
		super();
	}

	public Promotion_detailVO(Integer promNo, Integer pNo, Integer pPrice) {
		super();
		this.promNo = promNo;
		this.pNo = pNo;
		this.pPrice = pPrice;
	}

	public Integer getPromNo() {
		return promNo;
	}

	public void setPromNo(Integer promNo) {
		this.promNo = promNo;
	}

	public Integer getpNo() {
		return pNo;
	}

	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

}
