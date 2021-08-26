package com.c_report.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class C_ReportVO implements Serializable{
	private Integer reportNo;
	private Integer mNo;
	private Integer cNo;
	private Integer cReportState;
	private String cReportContent;
	private Timestamp cReportTime;

	public C_ReportVO() {
	};

	public C_ReportVO(Integer reportNo, Integer mNo, Integer cNo, Integer cPeportState, String cReportContent,
			Timestamp cReportTime) {
		super();
		this.reportNo = reportNo;
		this.mNo = mNo;
		this.cNo = cNo;
		this.cReportState = cPeportState;
		this.cReportContent = cReportContent;
		this.cReportTime = cReportTime;
	}

	public Integer getReportNo() {
		return reportNo;
	}

	public void setReportNo(Integer reportNo) {
		this.reportNo = reportNo;
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

	public Integer getcReportState() {
		return cReportState;
	}

	public void setcReportState(Integer cPeportState) {
		this.cReportState = cPeportState;
	}

	public String getcReportContent() {
		return cReportContent;
	}

	public void setcReportContent(String cReportContent) {
		this.cReportContent = cReportContent;
	}

	public Timestamp getcReportTime() {
		return cReportTime;
	}

	public void setcReportTime(Timestamp cReportTime) {
		this.cReportTime = cReportTime;
	}

	@Override
	public String toString() {
		return "C_ReportVO [reportNo=" + reportNo + ", mNo=" + mNo + ", cNo=" + cNo + ", cPeportState=" + cReportState
				+ ", cReportContent=" + cReportContent + ", cReportTime=" + cReportTime + "]";
	}

}
