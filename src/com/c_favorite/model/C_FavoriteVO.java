package com.c_favorite.model;

import java.io.Serializable;

public class C_FavoriteVO implements Serializable {
	private Integer mno;
	private Integer cno;

	public C_FavoriteVO() {
	}

	public C_FavoriteVO(Integer mno, Integer cno) {
		super();
		mno = mno;
		cno = cno;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		mno = mno;
	}

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		cno = cno;
	};

}
