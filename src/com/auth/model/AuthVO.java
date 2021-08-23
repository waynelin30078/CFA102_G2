package com.auth.model;

import java.io.Serializable;

public class AuthVO implements Serializable {
	private Integer authNo;
	private String authName;
	private String authDescription;

	public Integer getAuthNo() {
		return authNo;
	}

	public void setAuthNo(Integer authNo) {
		this.authNo = authNo;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthDescription() {
		return authDescription;
	}

	public void setAuthDescription(String authDescription) {
		this.authDescription = authDescription;
	}

}
