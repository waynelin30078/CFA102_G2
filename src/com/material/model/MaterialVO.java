package com.material.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MaterialVO implements Serializable {
	private Integer matNo;
	private Integer cNo;
	private String matFile;
	private Timestamp matUpdateTime;
	public MaterialVO() {};
	
	
	public Integer getMatNo() {
		return matNo;
	}
	public void setMatNo(Integer matNo) {
		this.matNo = matNo;
	}
	public Integer getcNo() {
		return cNo;
	}
	public void setcNo(Integer cNo) {
		this.cNo = cNo;
	}
	public String getMatFile() {
		return matFile;
	}
	public void setMatFile(String matFile) {
		this.matFile = matFile;
	}
	public Timestamp getMatUpdateTime() {
		return matUpdateTime;
	}
	public void setMatUpdateTime(Timestamp matUpdateTime) {
		this.matUpdateTime = matUpdateTime;
	}
	public MaterialVO(Integer matNo, Integer cNo, String matFile, Timestamp matUpdateTime) {
		super();
		this.matNo = matNo;
		this.cNo = cNo;
		this.matFile = matFile;
		this.matUpdateTime = matUpdateTime;
	}
	@Override
	public String toString() {
		return "MaterialVO [matNo=" + matNo + ", cNo=" + cNo + ", matFile=" + matFile + ", matUpdateTime="
				+ matUpdateTime + "]";
	}
}
