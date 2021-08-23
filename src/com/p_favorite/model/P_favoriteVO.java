package com.p_favorite.model;

public class P_favoriteVO implements java.io.Serializable {

	private Integer mNo;
	private Integer pNo;

	public P_favoriteVO() {
		super();
	}

	public P_favoriteVO(Integer mNo, Integer pNo) {
		super();
		this.mNo = mNo;
		this.pNo = pNo;
	}

	public Integer getmNo() {
		return mNo;
	}

	public void setmNo(Integer mNo) {
		this.mNo = mNo;
	}

	public Integer getpNo() {
		return pNo;
	}

	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}
}
