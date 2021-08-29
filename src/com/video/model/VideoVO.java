package com.video.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

public class VideoVO implements Serializable {
	private Integer vno;
	private Integer cno;
	private String vfile;
	private Timestamp vupdateTime;
	private java.sql.Time vlength;
	public VideoVO() {}
	
	public VideoVO(Integer vno, Integer cno, String vfile, Timestamp vupdateTime, Time vlength) {
		super();
		this.vno = vno;
		this.cno = cno;
		this.vfile = vfile;
		this.vupdateTime = vupdateTime;
		this.vlength = vlength;
	}

	public Integer getVno() {
		return vno;
	}
	public void setVno(Integer vno) {
		this.vno = vno;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getVfile() {
		return vfile;
	}
	public void setVfile(String vfile) {
		this.vfile = vfile;
	}
	public Timestamp getVupdateTime() {
		return vupdateTime;
	}
	public void setVupdateTime(Timestamp vupdateTime) {
		this.vupdateTime = vupdateTime;
	}
	public java.sql.Time getVlength() {
		return vlength;
	}
	public void setVlength(java.sql.Time vlength) {
		this.vlength = vlength;
	};
	
}
