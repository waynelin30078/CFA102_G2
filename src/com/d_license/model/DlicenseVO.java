package com.d_license.model;

public class DlicenseVO {

	private Integer dLicNo;
	private Integer dNo;
	private String licDesc;
	private String licFile;

	public DlicenseVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DlicenseVO(Integer dNo, String licDesc, String licFile) {
		super();
		this.dNo = dNo;
		this.licDesc = licDesc;
		this.licFile = licFile;
	}

	public Integer getdLicNo() {
		return dLicNo;
	}

	public void setdLicNo(Integer dLicNo) {
		this.dLicNo = dLicNo;
	}

	public Integer getdNo() {
		return dNo;
	}

	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}

	public String getLicDesc() {
		return licDesc;
	}

	public void setLicDesc(String licDesc) {
		this.licDesc = licDesc;
	}

	public String getLicFile() {
		return licFile;
	}

	public void setLicFile(String licFile) {
		this.licFile = licFile;
	}

}
