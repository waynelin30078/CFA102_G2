package com.video.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

public class VideoVO implements Serializable {
	private Integer vNo;
	private Integer cNo;
	private String vFile;
	private Timestamp vUpdateTime;
	private java.sql.Time vLength;
	public VideoVO() {};
	public VideoVO(Integer vNo, Integer cNo, String vFile, Timestamp vUpdateTime, Time vLength) {
		super();
		this.vNo = vNo;
		this.cNo = cNo;
		this.vFile = vFile;
		this.vUpdateTime = vUpdateTime;
		this.vLength = vLength;
	}
	public Integer getvNo() {
		return vNo;
	}
	public void setvNo(Integer vNo) {
		this.vNo = vNo;
	}
	public Integer getcNo() {
		return cNo;
	}
	public void setcNo(Integer cNo) {
		this.cNo = cNo;
	}
	public String getvFile() {
		return vFile;
	}
	public void setvFile(String vFile) {
		this.vFile = vFile;
	}
	public Timestamp getvUpdateTime() {
		return vUpdateTime;
	}
	public void setvUpdateTime(Timestamp vUpdateTime) {
		this.vUpdateTime = vUpdateTime;
	}
	public java.sql.Time getvLength() {
		return vLength;
	}
	public void setvLength(java.sql.Time vLength) {
		this.vLength = vLength;
	}
	public void setvLength(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setvLength(String string) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "VideoVO [vNo=" + vNo + ", cNo=" + cNo + ", vFile=" + vFile + ", vUpdateTime=" + vUpdateTime
				+ ", vLength=" + vLength + "]";
	}
	
}
