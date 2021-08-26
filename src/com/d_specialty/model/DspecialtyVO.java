package com.d_specialty.model;

public class DspecialtyVO {
	private Integer specialtyNo;
	private Integer dNo;

	public DspecialtyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DspecialtyVO(Integer specialtyNo, Integer dNo) {
		super();
		this.specialtyNo = specialtyNo;
		this.dNo = dNo;
	}

	public Integer getSpecialtyNo() {
		return specialtyNo;
	}

	public void setSpecialtyNo(Integer specialtyNo) {
		this.specialtyNo = specialtyNo;
	}

	public Integer getdNo() {
		return dNo;
	}

	public void setdNo(Integer dNo) {
		this.dNo = dNo;
	}

}
