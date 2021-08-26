package com.c_favorite.model;

import java.io.Serializable;

public class C_FavoriteVO implements Serializable {
	private Integer mNo;
	private Integer cNo;
	public C_FavoriteVO() {};
	public C_FavoriteVO(Integer mNo, Integer cNo) {
		super();
		this.mNo = mNo;
		this.cNo = cNo;
	}
	public Integer getmNo() {
		return mNo;
	}
	public void setmNo(Integer mNo) {
		this.mNo = mNo;
	}
	public Integer getcNo() {
		return cNo;
	}
	public void setcNo(Integer cNo) {
		this.cNo = cNo;
	}
	@Override
	public String toString() {
		return "C_FavoriteVO [mNo=" + mNo + ", cNo=" + cNo + "]";
	}
	
}
