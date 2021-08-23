package com.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

<<<<<<< HEAD
public class ProductDAO implements ProductDAO_interface {

	private static DataSource ds = null;

=======
public class ProductDAO  implements ProductDAO_interface{
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/David");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD

	private static final String INSERT_STMT = "INSERT INTO product (pNo, categoryName, pName, pPrice, pInfo, pQuantity, pOnDate, pOffDate, pImage1, pImage2, pImage3,"
			+ "pRatingsQuantity, pTotalRatings, pState) VALUES (null, ?, ?, ?, ?, ?, now(), default, ?, ?, ?, ?, ?, default)";
	private static final String UPDATE = "UPDATE product set categoryName=?, pName=?, pPrice=?, pInfo=?, pQuantity=?, pOnDate=?, pOffDate=?, pImage1=?, pImage2=?, pImage3=?,"
			+ " pState=? where pNo =?";
	private static final String DELETE = "DELETE FROM product where pNo =?";
	private static final String GET_ONE_STMT = "SELECT pNo, categoryName, pName, pPrice, pInfo, pQuantity, pOnDate, pOffDate, pImage1, pImage2, pImage3,"
			+ " pRatingsQuantity,pTotalRatings, pState FROM product where pNo =?";
	private static final String GET_ALL_STMT = "SELECT pNo, categoryName, pName, pPrice, pInfo, pQuantity, pOnDate, pOffDate, pImage1, pImage2, pImage3,"
			+ " pRatingsQuantity, pTotalRatings, pState FROM product order by pNo";

	@Override
	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

=======
	
	// 新增商品
	private static final String INSERT_STMT = "INSERT INTO product (pNo,categoryName,pName,pPrice,pInfo,pQuantity,pOnDate,pOffDate,pImage1,pImage2,pImage3,pRatingsQuantity,pTotalRatings,pState) VALUES (null, ?, ?, ?, ?, ?, now(), default, ?, ?, ?, ?, ?, default)";
	// 更新商品
	private static final String UPDATE = "UPDATE product set categoryName=?, pName=?, pPrice=?, pInfo=?, pQuantity=?, pOnDate=now(), pOffDate=?, pImage1=?, pImage2=?, pImage3=?, pRatingsQuantity=?, pTotalRatings=?, pState=? where pNo =?";
	// 刪除商品
	private static final String DELETE = "DELETE FROM product where pNo =?";
	// 查詢商品
	private static final String GET_ONE_STMT = "SELECT * FROM product where pNo =?";
	private static final String GET_ALL_STMT = "SELECT * FROM product order by pNo";
	

	@Override
	public void insert(ProductVO productVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, productVO.getCategoryName());
			pstmt.setString(2, productVO.getpName());
			pstmt.setInt(3, productVO.getpPrice());
			pstmt.setString(4, productVO.getpInfo());
			pstmt.setInt(5, productVO.getpQuantity());
			pstmt.setString(6, productVO.getpImage1());
			pstmt.setString(7, productVO.getpImage2());
			pstmt.setString(8, productVO.getpImage3());
			pstmt.setInt(9, productVO.getpRatingsQuantity());
<<<<<<< HEAD
			pstmt.setInt(10, productVO.getpTotalRatings());		
=======
			pstmt.setInt(10, productVO.getpTotalRatings());
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
<<<<<<< HEAD
			throw new RuntimeException("A database error occured. " + se.getMessage());
=======
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
<<<<<<< HEAD
		}

	}

=======
		}		
		
	}
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
	@Override
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, productVO.getCategoryName());
			pstmt.setString(2, productVO.getpName());
			pstmt.setInt(3, productVO.getpPrice());
			pstmt.setString(4, productVO.getpInfo());
			pstmt.setInt(5, productVO.getpQuantity());
<<<<<<< HEAD
			pstmt.setTimestamp(6, productVO.getpOnDate());
			pstmt.setTimestamp(7, productVO.getpOffDate());
			pstmt.setString(8, productVO.getpImage1());
			pstmt.setString(9, productVO.getpImage2());
			pstmt.setString(10, productVO.getpImage3());
			pstmt.setInt(11, productVO.getpState());
			pstmt.setInt(12, productVO.getpNo());
=======
			pstmt.setTimestamp(6, productVO.getpOffDate());
			pstmt.setString(7, productVO.getpImage1());
			pstmt.setString(8, productVO.getpImage2());
			pstmt.setString(9, productVO.getpImage3());
			pstmt.setInt(10, productVO.getpRatingsQuantity());
			pstmt.setInt(11, productVO.getpTotalRatings());
			pstmt.setInt(12, productVO.getpState());
			pstmt.setInt(13, productVO.getpNo());
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
<<<<<<< HEAD
			throw new RuntimeException("A database error occured. " + se.getMessage());
=======
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
<<<<<<< HEAD
		}
	}

=======
		}		
	}
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
	@Override
	public void delete(Integer pNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, pNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
<<<<<<< HEAD
			throw new RuntimeException("A database error occured. " + se.getMessage());
=======
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
<<<<<<< HEAD
		}
	}

	@Override
	public ProductVO findByPrimaryKey(Integer pNo) {

=======
		}		
	}
	@Override
	public ProductVO findByPrimaryKey(Integer pNo) {
		
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
<<<<<<< HEAD

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, pNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				productVO = new ProductVO();
				productVO.setpNo(rs.getInt("pNo"));
				productVO.setCategoryName(rs.getString("categoryName"));
				productVO.setpName(rs.getString("pName"));
				productVO.setpPrice(rs.getInt("pPrice"));
				productVO.setpInfo(rs.getString("pInfo"));
				productVO.setpQuantity(rs.getInt("pQuantity"));
				productVO.setpOnDate(rs.getTimestamp("pOnDate"));
				productVO.setpOffDate(rs.getTimestamp("pOffDate"));
				productVO.setpImage1(rs.getString("pImage1"));
				productVO.setpImage2(rs.getString("pImage2"));
				productVO.setpImage3(rs.getString("pImage3"));
				productVO.setpRatingsQuantity(rs.getInt("pRatingsQuantity"));
				productVO.setpTotalRatings(rs.getInt("pTotalRatings"));
				productVO.setpState(rs.getInt("pState"));

			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productVO;
	}

=======
		
		con = ds.getConnection();
		pstmt = con.prepareStatement(GET_ONE_STMT);

		pstmt.setInt(1, pNo);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			
			productVO = new ProductVO();
			productVO.setpNo(rs.getInt("pNo"));
			productVO.setCategoryName(rs.getString("categoryName"));
			productVO.setpName(rs.getString("pName"));
			productVO.setpPrice(rs.getInt("pPrice"));
			productVO.setpInfo(rs.getString("pInfo"));
			productVO.setpQuantity(rs.getInt("pQuantity"));
			productVO.setpOnDate(rs.getTimestamp("pOnDate"));
			productVO.setpOffDate(rs.getTimestamp("pOffDate"));
			productVO.setpImage1(rs.getString("pImage1"));
			productVO.setpImage2(rs.getString("pImage2"));
			productVO.setpImage3(rs.getString("pImage3"));
			productVO.setpRatingsQuantity(rs.getInt("pRatingsQuantity"));
			productVO.setpTotalRatings(rs.getInt("pTotalRatings"));
			productVO.setpState(rs.getInt("pState"));			

		}

		// Handle any driver errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. "
				+ se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	return productVO;
	}
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
	@Override
	public List<ProductVO> getAll() {

		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
<<<<<<< HEAD

=======
				
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
				productVO = new ProductVO();
				productVO.setpNo(rs.getInt("pNo"));
				productVO.setCategoryName(rs.getString("categoryName"));
				productVO.setpName(rs.getString("pName"));
				productVO.setpPrice(rs.getInt("pPrice"));
				productVO.setpInfo(rs.getString("pInfo"));
				productVO.setpQuantity(rs.getInt("pQuantity"));
				productVO.setpOnDate(rs.getTimestamp("pOnDate"));
				productVO.setpOffDate(rs.getTimestamp("pOffDate"));
				productVO.setpImage1(rs.getString("pImage1"));
				productVO.setpImage2(rs.getString("pImage2"));
				productVO.setpImage3(rs.getString("pImage3"));
				productVO.setpRatingsQuantity(rs.getInt("pRatingsQuantity"));
				productVO.setpTotalRatings(rs.getInt("pTotalRatings"));
<<<<<<< HEAD
				productVO.setpState(rs.getInt("pState"));
=======
				productVO.setpState(rs.getInt("pState"));	
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
<<<<<<< HEAD
			throw new RuntimeException("A database error occured. " + se.getMessage());
=======
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}
