package com.p_order_detail.model;

public class P_order_detailVO implements java.io.Serializable {

	private Integer pOrderNo;
	private Integer pNo;
	private Integer pOrderQuantity;
	private Integer pPrice;
	private Integer pRatings;

	public P_order_detailVO() {
		super();
	}

	public P_order_detailVO(Integer pOrderNo, Integer pNo, Integer pOrderQuantity, Integer pPrice, Integer pRatings) {
		super();
		this.pOrderNo = pOrderNo;
		this.pNo = pNo;
		this.pOrderQuantity = pOrderQuantity;
		this.pPrice = pPrice;
		this.pRatings = pRatings;
	}

	public Integer getpOrderNo() {
		return pOrderNo;
	}

	public void setpOrderNo(Integer pOrderNo) {
		this.pOrderNo = pOrderNo;
	}

	public Integer getpNo() {
		return pNo;
	}

	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}

	public Integer getpOrderQuantity() {
		return pOrderQuantity;
	}

	public void setpOrderQuantity(Integer pOrderQuantity) {
		this.pOrderQuantity = pOrderQuantity;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

	public Integer getpRatings() {
		return pRatings;
	}

	public void setpRatings(Integer pRatings) {
		this.pRatings = pRatings;
	}

}
