package com.promotion_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Promotion_detailJDBCDAO implements Promotion_detailDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	// 新增優惠活動明細
	private static final String INSERT_STMT = "INSERT INTO promotion_detail (promNo, pNo, pPrice) VALUES (?, ?, ?)";
	// 更新優惠活動明細
	private static final String UPDATE = "UPDATE promotion_detail SET pPrice=? WHERE promNo =? AND pNo=?";
	// 刪除優惠活動明細
	private static final String DELETE = "DELETE FROM promotion_detail WHERE promNo =? AND pNo=?";
	// 查詢優惠活動明細(用優惠活動編號)
	private static final String GET_ONE_STMT = "SELECT * FROM promotion_detail WHERE promNo =?";
	// 查詢所有優惠活動明細
	private static final String GET_ALL_STMT = "SELECT * FROM promotion_detail ORDER BY promNo AND pNo";

	@Override
	public void insert(Promotion_detailVO promotion_detailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, promotion_detailVO.getPromNo());
			pstmt.setInt(2, promotion_detailVO.getpNo());
			pstmt.setInt(3, promotion_detailVO.getpPrice());

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
	public void update(Promotion_detailVO promotion_detailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, promotion_detailVO.getpPrice());
			pstmt.setInt(2, promotion_detailVO.getPromNo());
			pstmt.setInt(3, promotion_detailVO.getpNo());

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
	public void delete(Integer promNo, Integer pNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, promNo);
			pstmt.setInt(2, pNo);

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
	public List<Promotion_detailVO> findByPrimaryKey(Integer promNo) {

		List<Promotion_detailVO> list = new ArrayList<Promotion_detailVO>();
		Promotion_detailVO promotion_detailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, promNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				promotion_detailVO = new Promotion_detailVO();
				promotion_detailVO.setPromNo(rs.getInt("promNo"));
				promotion_detailVO.setpNo(rs.getInt("pNo"));
				promotion_detailVO.setpPrice(rs.getInt("pPrice"));

				list.add(promotion_detailVO); // Store the row in the list
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

	@Override
	public List<Promotion_detailVO> getAll() {

		List<Promotion_detailVO> list = new ArrayList<Promotion_detailVO>();
		Promotion_detailVO promotion_detailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				promotion_detailVO = new Promotion_detailVO();
				promotion_detailVO.setPromNo(rs.getInt("promNo"));
				promotion_detailVO.setpNo(rs.getInt("pNo"));
				promotion_detailVO.setpPrice(rs.getInt("pPrice"));

				list.add(promotion_detailVO); // Store the row in the list
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

		Promotion_detailJDBCDAO dao = new Promotion_detailJDBCDAO();

		// INSERT_STMT
//		Promotion_detailVO promotion_detailVO1 = new Promotion_detailVO();		
//		promotion_detailVO1.setPromNo(4);
//		promotion_detailVO1.setpNo(1);
//		promotion_detailVO1.setpPrice(600);
//		dao.insert(promotion_detailVO1);

		// UPDATE
//		Promotion_detailVO promotion_detailVO2 = new Promotion_detailVO();
//		promotion_detailVO2.setpPrice(600);
//		promotion_detailVO2.setPromNo(4);
//		promotion_detailVO2.setpNo(1);		
//		dao.update(promotion_detailVO2);

		// DELETE
//		dao.delete(4,1);

		// GET_ONE_STMT
		List<Promotion_detailVO> list = dao.findByPrimaryKey(1);
		for (Promotion_detailVO aPromotion_detail3 : list) {
			System.out.print(aPromotion_detail3.getPromNo() + ",");
			System.out.print(aPromotion_detail3.getpNo() + ",");
			System.out.println(aPromotion_detail3.getpPrice());
			System.out.println();
		}

		System.out.println("--------------------------------------------------------");

		// GET_ALL_STMT
		List<Promotion_detailVO> list1 = dao.getAll();
		for (Promotion_detailVO aPromotion_detail4 : list1) {
			System.out.print(aPromotion_detail4.getPromNo() + ",");
			System.out.print(aPromotion_detail4.getpNo() + ",");
			System.out.println(aPromotion_detail4.getpPrice());
			System.out.println();
		}

	}

}
