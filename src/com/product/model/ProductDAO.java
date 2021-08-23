package com.product.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAO {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/David");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO product (pNo,categoryName,pName,pPrice,pInfo,pQuantity,pOnDate,pOffDate,pImage1,pImage2,pImage3,pRatingsQuantity,pTotalRatings,pState) "
												+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT pNo,categoryName,pName,pPrice,pOnDate,pOffDate,pState FROM product order by pNo";
	private static final String GET_ONE_STMT = "SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 where pNo = ?";
	private static final String DELETE = "DELETE FROM product where empno = ?";
	private static final String UPDATE = "UPDATE product set ename=?, job=?, hiredate=?, sal=?, comm=?, deptno=? where pNo = ?";

}
