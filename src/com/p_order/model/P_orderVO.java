package com.p_order.model;

import java.sql.Timestamp;

public class P_orderVO implements java.io.Serializable {

	private Integer pOrderNo;
	private Integer mNo;
	private Timestamp pOrderDate;
	private Integer pOrderTotal;
	private String pOrderName;
	private String pOrderPhone;
	private String pOrderAddress;
	private Integer pPayment;
	private String pCreditCard;
	private String pCreditCardCVV;
	private Integer pShipping;
	private Integer pOrderState;

	public P_orderVO() {
		super();
	}

	public P_orderVO(Integer pOrderNo, Integer mNo, Timestamp pOrderDate, Integer pOrderTotal, String pOrderName,
			String pOrderPhone, String pOrderAddress, Integer pPayment, String pCreditCard, String pCreditCardCVV,
			Integer pShipping, Integer pOrderState) {
		super();
		this.pOrderNo = pOrderNo;
		this.mNo = mNo;
		this.pOrderDate = pOrderDate;
		this.pOrderTotal = pOrderTotal;
		this.pOrderName = pOrderName;
		this.pOrderPhone = pOrderPhone;
		this.pOrderAddress = pOrderAddress;
		this.pPayment = pPayment;
		this.pCreditCard = pCreditCard;
		this.pCreditCardCVV = pCreditCardCVV;
		this.pShipping = pShipping;
		this.pOrderState = pOrderState;
	}

	public Integer getpOrderNo() {
		return pOrderNo;
	}

	public void setpOrderNo(Integer pOrderNo) {
		this.pOrderNo = pOrderNo;
	}

	public Integer getmNo() {
		return mNo;
	}

	public void setmNo(Integer mNo) {
		this.mNo = mNo;
	}

	public Timestamp getpOrderDate() {
		return pOrderDate;
	}

	public void setpOrderDate(Timestamp pOrderDate) {
		this.pOrderDate = pOrderDate;
	}

	public Integer getpOrderTotal() {
		return pOrderTotal;
	}

	public void setpOrderTotal(Integer pOrderTotal) {
		this.pOrderTotal = pOrderTotal;
	}

	public String getpOrderName() {
		return pOrderName;
	}

	public void setpOrderName(String pOrderName) {
		this.pOrderName = pOrderName;
	}

	public String getpOrderPhone() {
		return pOrderPhone;
	}

	public void setpOrderPhone(String pOrderPhone) {
		this.pOrderPhone = pOrderPhone;
	}

	public String getpOrderAddress() {
		return pOrderAddress;
	}

	public void setpOrderAddress(String pOrderAddress) {
		this.pOrderAddress = pOrderAddress;
	}

	public Integer getpPayment() {
		return pPayment;
	}

	public void setpPayment(Integer pPayment) {
		this.pPayment = pPayment;
	}

	public String getpCreditCard() {
		return pCreditCard;
	}

	public void setpCreditCard(String pCreditCard) {
		this.pCreditCard = pCreditCard;
	}

	public String getpCreditCardCVV() {
		return pCreditCardCVV;
	}

	public void setpCreditCardCVV(String pCreditCardCVV) {
		this.pCreditCardCVV = pCreditCardCVV;
	}

	public Integer getpShipping() {
		return pShipping;
	}

	public void setpShipping(Integer pShipping) {
		this.pShipping = pShipping;
	}

	public Integer getpOrderState() {
		return pOrderState;
	}

	public void setpOrderState(Integer pOrderState) {
		this.pOrderState = pOrderState;
	}

}
