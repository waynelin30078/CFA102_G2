package com.admin.model;

import java.io.Serializable;

public class AdminVO implements Serializable {
	private Integer aNo;
	private String aName;
	private String aId;
	private String aPsw;

	public Integer getaNo() {
		return aNo;
	}

	public void setaNo(Integer aNo) {
		this.aNo = aNo;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaPsw() {
		return aPsw;
	}

	public void setaPsw(String aPsw) {
		this.aPsw = aPsw;
	}


}
