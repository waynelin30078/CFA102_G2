package com.course.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

public class CourseVO implements Serializable {
	private Integer cNo;// 課程編號
	private Integer dNo;// 講師編號
	private String cName;// 課程名稱
	private Integer cPrice;
	private Integer cState;
	private Date cShelfDate;// 上架日期
	private String cIntroduction;// 課程介紹
	private Integer cType;
	private Integer quantity;// 購買人數
	private byte[] cPic;// 預覽圖
	private String cDescription;// 預覽介紹
	private Integer cTotalPeople;
	private Integer cTotalScore;

	public CourseVO() {
		super();
	}

	public CourseVO(Integer cNo, Integer dNo, String cName, Integer cPrice, Integer cState, java.util.Date cShelfDate2,
			String cIntroduction, Integer cType, Integer quantity, byte[] cPic, String cDescription,
			Integer cTotalPeople, Integer cTotalScore) {
		super();
		this.cNo = cNo;
		this.dNo = dNo;
		this.cName = cName;
		this.cPrice = cPrice;
		this.cState = cState;
		this.cShelfDate = (Date) cShelfDate2;
		this.cIntroduction = cIntroduction;
		this.cType = cType;
		this.quantity = quantity;
		this.cPic = cPic;
		this.cDescription = cDescription;
		this.cTotalPeople = cTotalPeople;
		this.cTotalScore = cTotalScore;

	}

	public Integer getcNo() {
		return cNo;
	}

	public void setcNo(Integer cNo) {
		this.cNo = cNo;
	}

	public Integer getdNo() {
		return dNo;
	}

	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getcPrice() {
		return cPrice;
	}

	public void setcPrice(Integer cPrice) {
		this.cPrice = cPrice;
	}

	public Integer getcState() {
		return cState;
	}

	public void setcState(Integer cStatue) {
		this.cState = cStatue;
	}

	public Date getcShelfDate() {
		return cShelfDate;
	}

	public void setcShelfDate(Date cShelfDate) {
		this.cShelfDate = cShelfDate;
	}

	public String getcIntroduction() {
		return cIntroduction;
	}

	public void setcIntroduction(String cIntroduction) {
		this.cIntroduction = cIntroduction;
	}

	public Integer getcType() {
		return cType;
	}

	public void setcType(Integer cType) {
		this.cType = cType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public byte[] getcPic() {
		return cPic;
	}

	public void setcPic(byte[] cPic) {
		this.cPic = cPic;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public Integer getcTotalPeople() {
		return cTotalPeople;
	}

	public void setcTotalPeople(Integer cTotalPeople) {
		this.cTotalPeople = cTotalPeople;
	}

	public Integer getcTotalScore() {
		return cTotalScore;
	}

	public void setcTotalScore(Integer cTotalScore) {
		this.cTotalScore = cTotalScore;
	}

	@Override
	public String toString() {
		return "CourseVO [cNo=" + cNo + ", dNo=" + dNo + ", cName=" + cName + ", cPrice=" + cPrice + ", cState="
				+ cState + ", cShelfDate=" + cShelfDate + ", cIntroduction=" + cIntroduction + ", cType=" + cType
				+ ", quantity=" + quantity + ", cPic="  + ", cDescription=" + cDescription
				+ ", cTotalPeople=" + cTotalPeople + ", cTotalScore=" + cTotalScore + "]";
	}

}
