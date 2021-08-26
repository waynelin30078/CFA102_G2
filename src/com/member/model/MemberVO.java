package com.member.model;

import java.sql.Date;

public class MemberVO implements java.io.Serializable{
	private Integer mNo;
	private String mName;
	private String mId;
	private String mPsw;
	private String mMail;
	private String mPhone;
	private String mImg;
	private Date mBday;
	private Byte mSex;  //tinyint ??
	private String mIntro;
	private Byte mState;
	private Integer cardID;
	private Integer cardDate;
	private Integer cardNum;
	private Integer dNo;
	private Integer dailyCal;
	private Integer dailyCho;
	private Integer dailyPro;
	private Integer dailyFat;
	private String dietPlan;
	
	public Integer getmNo() {
		return mNo;
	}
	public void setmNo(Integer mNo) {
		this.mNo = mNo;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPsw() {
		return mPsw;
	}
	public void setmPsw(String mPsw) {
		this.mPsw = mPsw;
	}
	public String getmMail() {
		return mMail;
	}
	public void setmMail(String mMail) {
		this.mMail = mMail;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmImg() {
		return mImg;
	}
	public void setmImg(String mImg) {
		this.mImg = mImg;
	}
	public Date getmBday() {
		return mBday;
	}
	public void setmBday(Date mBday) {
		this.mBday = mBday;
	}
	public Byte getmSex() {
		return mSex;
	}
	public void setmSex(Byte mSex) {
		this.mSex = mSex;
	}
	public String getmIntro() {
		return mIntro;
	}
	public void setmIntro(String mIntro) {
		this.mIntro = mIntro;
	}
	public Byte getmState() {
		return mState;
	}
	public void setmState(Byte mState) {
		this.mState = mState;
	}
	public Integer getCardID() {
		return cardID;
	}
	public void setCardID(Integer cardID) {
		this.cardID = cardID;
	}
	public Integer getCardDate() {
		return cardDate;
	}
	public void setCardDate(Integer cardDate) {
		this.cardDate = cardDate;
	}
	public Integer getCardNum() {
		return cardNum;
	}
	public void setCardNum(Integer cardNum) {
		this.cardNum = cardNum;
	}
	public Integer getdNo() {
		return dNo;
	}
	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}
	public Integer getDailyCal() {
		return dailyCal;
	}
	public void setDailyCal(Integer dailyCal) {
		this.dailyCal = dailyCal;
	}
	public Integer getDailyCho() {
		return dailyCho;
	}
	public void setDailyCho(Integer dailyCho) {
		this.dailyCho = dailyCho;
	}
	public Integer getDailyPro() {
		return dailyPro;
	}
	public void setDailyPro(Integer dailyPro) {
		this.dailyPro = dailyPro;
	}
	public Integer getDailyFat() {
		return dailyFat;
	}
	public void setDailyFat(Integer dailyFat) {
		this.dailyFat = dailyFat;
	}
	public String getDietPlan() {
		return dietPlan;
	}
	public void setDietPlan(String dietPlan) {
		this.dietPlan = dietPlan;
	}
	
	
	
}
