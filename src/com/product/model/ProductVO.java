package com.product.model;

<<<<<<< HEAD
import java.sql.Date;

public class ProductVO implements java.io.Serializable {

	private Integer pno;
	private String categoryName;
	private String pname;
	private Integer pprice;
	private String pinfo;
	private Integer pquantity;
	private Date ponDate;
	private Date poffDate;
	private String pimage1;
	private String pimage2;
	private String pimage3;
	private Integer pratingsQuantity;
	private Integer ptotalRatings;
	private Integer pstate;
=======
<<<<<<< HEAD
import java.sql.Timestamp;

public class ProductVO implements java.io.Serializable {

=======
import java.sql.Date;

public class ProductVO {
>>>>>>> COURSE
	private Integer pNo;
	private String categoryName;
	private String pName;
	private Integer pPrice;
	private String pInfo;
	private Integer pQuantity;
<<<<<<< HEAD
	private Timestamp pOnDate;
	private Timestamp pOffDate;
=======
	private Date pOnDate;
	private Date pOffDate;
>>>>>>> COURSE
	private String pImage1;
	private String pImage2;
	private String pImage3;
	private Integer pRatingsQuantity;
	private Integer pTotalRatings;
	private Integer pState;
<<<<<<< HEAD
>>>>>>> b3e96434a81eb35f1fb805868db868b0991731e4

	public ProductVO() {
		super();
	}

	public ProductVO(Integer pno, String categoryName, String pname, Integer pprice, String pinfo, Integer pquantity,
			Date ponDate, Date poffDate, String pimage1, String pimage2, String pimage3,
			Integer pratingsQuantity, Integer ptotalRatings, Integer pstate) {
		super();
		this.pno = pno;
		this.categoryName = categoryName;
		this.pname = pname;
		this.pprice = pprice;
		this.pinfo = pinfo;
		this.pquantity = pquantity;
		this.ponDate = ponDate;
		this.poffDate = poffDate;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pimage3 = pimage3;
		this.pratingsQuantity = pratingsQuantity;
		this.ptotalRatings = ptotalRatings;
		this.pstate = pstate;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPprice() {
		return pprice;
	}

	public void setPprice(Integer pprice) {
		this.pprice = pprice;
	}

	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public Integer getPquantity() {
		return pquantity;
	}

	public void setPquantity(Integer pquantity) {
		this.pquantity = pquantity;
	}

	public Date getPonDate() {
		return ponDate;
	}

	public void setPonDate(Date ponDate) {
		this.ponDate = ponDate;
	}

	public Date getPoffDate() {
		return poffDate;
	}

	public void setPoffDate(Date poffDate) {
		this.poffDate = poffDate;
	}

	public String getPimage1() {
		return pimage1;
	}

	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

	public String getPimage3() {
		return pimage3;
	}

	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
	}

	public Integer getPratingsQuantity() {
		return pratingsQuantity;
	}

	public void setPratingsQuantity(Integer pratingsQuantity) {
		this.pratingsQuantity = pratingsQuantity;
	}

	public Integer getPtotalRatings() {
		return ptotalRatings;
	}

	public void setPtotalRatings(Integer ptotalRatings) {
		this.ptotalRatings = ptotalRatings;
	}

	public Integer getPstate() {
		return pstate;
	}

	public void setPstate(Integer pstate) {
		this.pstate = pstate;
	}

=======
	
	
	public Integer getpNo() {
		return pNo;
	}
	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getpPrice() {
		return pPrice;
	}
	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	public Integer getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(Integer pQuantity) {
		this.pQuantity = pQuantity;
	}
	public Date getpOnDate() {
		return pOnDate;
	}
	public void setpOnDate(Date pOnDate) {
		this.pOnDate = pOnDate;
	}
	public Date getpOffDate() {
		return pOffDate;
	}
	public void setpOffDate(Date pOffDate) {
		this.pOffDate = pOffDate;
	}
	public String getpImage1() {
		return pImage1;
	}
	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}
	public String getpImage2() {
		return pImage2;
	}
	public void setpImage2(String pImage2) {
		this.pImage2 = pImage2;
	}
	public String getpImage3() {
		return pImage3;
	}
	public void setpImage3(String pImage3) {
		this.pImage3 = pImage3;
	}
	public Integer getpRatingsQuantity() {
		return pRatingsQuantity;
	}
	public void setpRatingsQuantity(Integer pRatingsQuantity) {
		this.pRatingsQuantity = pRatingsQuantity;
	}
	public Integer getpTotalRatings() {
		return pTotalRatings;
	}
	public void setpTotalRatings(Integer pTotalRatings) {
		this.pTotalRatings = pTotalRatings;
	}
	public Integer getpState() {
		return pState;
	}
	public void setpState(Integer pState) {
		this.pState = pState;
	}
	
>>>>>>> COURSE
}
