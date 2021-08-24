package com.dietician.model;

import java.io.Serializable;
import java.sql.Date;

public class DieticianVO implements Serializable {

	private Integer dNo;
	private String dName;
	private String dAccount;
	private String dPassword;
	private Date dBirthDay;
	private String dPic;
	private String dPhone;
	private String dAddress;
	private String dEmail;
	private String edu;
	private String exp;
	private String lic;
	private String prof;
	private Integer clPrice;
	private Integer mPrice;
	private String intro;
	private Integer dState;
	private Integer totalScore;
	private Integer totalReviewer;
	private Integer dOnState;
	private String offDay;
	private String optTime;

	public DieticianVO() {
		super();
	}

	public DieticianVO(String dName, String dAccount, String dPassword, Date dBirthDay, String dPic, String dPhone,
			String dAddress, String dEmail, String edu, String exp, String lic, String prof, Integer clPrice,
			Integer mPrice, String intro, Integer dState, Integer totalScore, Integer totalReviewer, Integer dOnState,
			String offDay, String optTime) {
		super();

		this.dName = dName;
		this.dAccount = dAccount;
		this.dPassword = dPassword;
		this.dBirthDay = dBirthDay;
		this.dPic = dPic;
		this.dPhone = dPhone;
		this.dAddress = dAddress;
		this.dEmail = dEmail;
		this.edu = edu;
		this.exp = exp;
		this.lic = lic;
		this.prof = prof;
		this.clPrice = clPrice;
		this.mPrice = mPrice;
		this.intro = intro;
		this.dState = dState;
		this.totalScore = totalScore;
		this.totalReviewer = totalReviewer;
		this.dOnState = dOnState;
		this.offDay = offDay;
		this.optTime = optTime;

	}

	public Integer getdNo() {
		return dNo;
	}

	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdAccount() {
		return dAccount;
	}

	public void setdAccount(String dAccount) {
		this.dAccount = dAccount;
	}

	public String getdPassword() {
		return dPassword;
	}

	public void setdPassword(String dPassword) {
		this.dPassword = dPassword;
	}

	public Date getdBirthDay() {
		return dBirthDay;
	}

	public void setdBirthDay(Date dBirthDay) {
		this.dBirthDay = dBirthDay;
	}

	public String getdPic() {
		return dPic;
	}

	public void setdPic(String dPic) {
		this.dPic = dPic;
	}

	public String getdPhone() {
		return dPhone;
	}

	public void setdPhone(String dPhone) {
		this.dPhone = dPhone;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getLic() {
		return lic;
	}

	public void setLic(String lic) {
		this.lic = lic;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public Integer getClPrice() {
		return clPrice;
	}

	public void setClPrice(Integer clPrice) {
		this.clPrice = clPrice;
	}

	public Integer getmPrice() {
		return mPrice;
	}

	public void setmPrice(Integer mPrice) {
		this.mPrice = mPrice;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getdState() {
		return dState;
	}

	public void setdState(Integer dState) {
		this.dState = dState;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getTotalReviewer() {
		return totalReviewer;
	}

	public void setTotalReviewer(Integer totalReviewer) {
		this.totalReviewer = totalReviewer;
	}

	public Integer getdOnState() {
		return dOnState;
	}

	public void setdOnState(Integer dOnState) {
		this.dOnState = dOnState;
	}

	public String getOffDay() {
		return offDay;
	}

	public void setOffDay(String offDay) {
		this.offDay = offDay;
	}

	public String getOptTime() {
		return optTime;
	}

	public void setOptTime(String optTime) {
		this.optTime = optTime;
	}

}