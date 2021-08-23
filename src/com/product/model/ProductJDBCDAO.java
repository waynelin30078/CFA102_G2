package com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBCDAO implements ProductDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

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

=======
	// ·s¼W°Ó«~
	private static final String INSERT_STMT = "INSERT INTO product (pNo,categoryName,pName,pPrice,pInfo,pQuantity,pOnDate,pOffDate,pImage1,pImage2,pImage3,pRatingsQuantity,pTotalRatings,pState) VALUES (null, ?, ?, ?, ?, ?, now(), default, ?, ?, ?, ?, ?, default)";
	// §ó·s°Ó«~
	private static final String UPDATE = "UPDATE product set categoryName=?, pName=?, pPrice=?, pInfo=?, pQuantity=?, pOnDate=now(), pOffDate=?, pImage1=?, pImage2=?, pImage3=?, pRatingsQuantity=?, pTotalRatings=?, pState=? where pNo =?";
	// §R°£°Ó«~
	private static final String DELETE = "DELETE FROM product where pNo =?";
	// ¬d¸ß°Ó«~
	private static final String GET_ONE_STMT = "SELECT * FROM product where pNo =?";
	private static final String GET_ALL_STMT = "SELECT * FROM product order by pNo";

	@Override
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
			pstmt.setInt(10, productVO.getpTotalRatings());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		}
	}

	@Override
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
<<<<<<< HEAD

=======
			
			
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
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
			pstmt.setInt(11, productVO.getpRatingsQuantity());
			pstmt.setInt(12, productVO.getpTotalRatings());
			pstmt.setInt(13, productVO.getpState());
			pstmt.setInt(14, productVO.getpNo());
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		}

	}

	@Override
	public void delete(Integer pNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, pNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		}

	}

	@Override
	public ProductVO findByPrimaryKey(Integer pNo) {

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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

	@Override
	public List<ProductVO> getAll() {

		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
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
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
		return list;
	}

	public static void main(String[] args) {

		ProductJDBCDAO dao = new ProductJDBCDAO();
<<<<<<< HEAD

		// INSERT_STMT
		ProductVO productVO1 = new ProductVO();
		productVO1.setCategoryName("é­šæ²¹/DHA");
		productVO1.setpName("æ¾³ä½³å¯¶Blackmoresç„¡è…¥å‘³æ¿ƒç¸®æ·±æµ·é­šæ²¹");
		productVO1.setpPrice(1980);
		productVO1.setpInfo("Info");
		productVO1.setpQuantity(250);
		productVO1.setpImage1("images/4.jpg");
		productVO1.setpImage2("images/5.jpg");
		productVO1.setpImage3("images/6.jpg");
		productVO1.setpRatingsQuantity(8);
		productVO1.setpTotalRatings(32);
		dao.insert(productVO1);

		// UPDATE
//		ProductVO productVO2 = new ProductVO();
//		
//		productVO2.setCategoryName("é­šæ²¹/DHA");
//		productVO2.setpName("æ¾³ä½³å¯¶Blackmoresç„¡è…¥å‘³æ¿ƒç¸®æ·±æµ·é­šæ²¹");
//		productVO2.setpPrice(550);
//		productVO2.setpInfo("æ¾³ä½³å¯¶Blackmoresç„¡è…¥å‘³æ¿ƒç¸®æ·±æµ·é­šæ²¹");
//		productVO2.setpQuantity(100);
//		productVO2.setpOnDate(java.sql.Timestamp.valueOf("2021-08-22 11:45:31"));
=======
		
		// ·s¼W
//		ProductVO productVO1 = new ProductVO();
//		productVO1.setCategoryName("³½ªo/DHA");
//		productVO1.setpName("¿Dºñ±d­¿ºëºé²`®ü³½ªo½¦Ån­¹«~");
//		productVO1.setpPrice(1980);
//		productVO1.setpInfo("Info");
//		productVO1.setpQuantity(250);
//		productVO1.setpImage1("images/4.jpg");
//		productVO1.setpImage2("images/5.jpg");
//		productVO1.setpImage3("images/6.jpg");
//		productVO1.setpRatingsQuantity(8);
//		productVO1.setpTotalRatings(32);
//		dao.insert(productVO1);		
		
		
		// ­×§ï
//		ProductVO productVO2 = new ProductVO();
//		productVO2.setCategoryName("³½ªo/DHA");
//		productVO2.setpName("¿D¨ÎÄ_BlackmoresµL¸{¨ý¿@ÁY²`®ü³½ªo");
//		productVO2.setpPrice(550);
//		productVO2.setpInfo("¿D¨ÎÄ_BlackmoresµL¸{¨ý¿@ÁY²`®ü³½ªo");
//		productVO2.setpQuantity(100);
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
//		productVO2.setpOffDate(java.sql.Timestamp.valueOf("9999-12-31 23:59:59"));
//		productVO2.setpImage1("images/1.jpg");
//		productVO2.setpImage2("images/2.jpg");
//		productVO2.setpImage3("images/3.jpg");
//		productVO2.setpRatingsQuantity(3);
//		productVO2.setpTotalRatings(12);
//		productVO2.setpState(1);
//		productVO2.setpNo(1);
//		dao.update(productVO2);
<<<<<<< HEAD

		// DELETE
//		dao.delete(2);

		// GET_ONE_STMT
=======
		
		
		// §R°£
//		dao.delete(2);
		
		
		// ¬d¸ß(PK)
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
		ProductVO productVO3 = dao.findByPrimaryKey(1);
		System.out.print(productVO3.getpNo() + ",");
		System.out.print(productVO3.getCategoryName() + ",");
		System.out.print(productVO3.getpName() + ",");
		System.out.print(productVO3.getpPrice() + ",");
		System.out.print(productVO3.getpInfo() + ",");
		System.out.print(productVO3.getpQuantity() + ",");
		System.out.print(productVO3.getpOnDate() + ",");
		System.out.print(productVO3.getpOffDate() + ",");
		System.out.print(productVO3.getpImage1() + ",");
		System.out.print(productVO3.getpImage2() + ",");
		System.out.print(productVO3.getpImage3() + ",");
		System.out.print(productVO3.getpRatingsQuantity() + ",");
		System.out.print(productVO3.getpTotalRatings() + ",");
		System.out.println(productVO3.getpState());
		System.out.println("---------------------");
<<<<<<< HEAD

		// GET_ALL_STMT
=======
		
		
		// ¬d¸ß(ALL)
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
		List<ProductVO> list = dao.getAll();
		for (ProductVO aProduct : list) {
			System.out.print(aProduct.getpNo() + ",");
			System.out.print(aProduct.getCategoryName() + ",");
			System.out.print(aProduct.getpName() + ",");
			System.out.print(aProduct.getpPrice() + ",");
			System.out.print(aProduct.getpInfo() + ",");
			System.out.print(aProduct.getpQuantity() + ",");
			System.out.print(aProduct.getpOnDate() + ",");
			System.out.print(aProduct.getpOffDate() + ",");
			System.out.print(aProduct.getpImage1() + ",");
			System.out.print(aProduct.getpImage2() + ",");
			System.out.print(aProduct.getpImage3() + ",");
			System.out.print(aProduct.getpRatingsQuantity() + ",");
			System.out.print(aProduct.getpTotalRatings() + ",");
<<<<<<< HEAD
			System.out.println(aProduct.getpState());
			System.out.println();
		}
=======
			System.out.println(aProduct.getpState());			
			System.out.println();
		}		
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b

	}

}
