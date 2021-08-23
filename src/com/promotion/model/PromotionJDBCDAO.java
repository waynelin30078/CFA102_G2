package com.promotion.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionJDBCDAO implements PromotionDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO promotion (promNo,promName,promStartTime,promEndTime) VALUES (null, ?, ?, ?)";
	private static final String UPDATE = "UPDATE promotion set promName=?, promStartTime=?, promEndTime=? where promNo =?";
	private static final String DELETE = "DELETE FROM promotion where promNo =?";
	private static final String GET_ONE_STMT = "SELECT promNo,promName,promStartTime,promEndTime FROM promotion where promNo =?";
	private static final String GET_ALL_STMT = "SELECT promNo,promName,promStartTime,promEndTime FROM promotion order by promNo";

	@Override
	public void insert(PromotionVO promotionVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, promotionVO.getPromName());
			pstmt.setTimestamp(2, promotionVO.getPromStartTime());
			pstmt.setTimestamp(3, promotionVO.getPromEndTime());

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
	public void update(PromotionVO promotionVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, promotionVO.getPromName());
			pstmt.setTimestamp(2, promotionVO.getPromStartTime());
			pstmt.setTimestamp(3, promotionVO.getPromEndTime());
			pstmt.setInt(4, promotionVO.getPromNo());

			pstmt.executeUpdate();

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
	public void delete(Integer promNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, promNo);

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
	public PromotionVO findByPrimaryKey(Integer promNo) {

		PromotionVO promotionVO = null;
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

				promotionVO = new PromotionVO();
				promotionVO.setPromNo(rs.getInt("promNo"));
				promotionVO.setPromName(rs.getString("promName"));
				promotionVO.setPromStartTime(rs.getTimestamp("promStartTime"));
				promotionVO.setPromEndTime(rs.getTimestamp("promEndTime"));

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
		return promotionVO;
	}

	@Override
	public List<PromotionVO> getAll() {

		List<PromotionVO> list = new ArrayList<PromotionVO>();
		PromotionVO promotionVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				promotionVO = new PromotionVO();
				promotionVO.setPromNo(rs.getInt("promNo"));
				promotionVO.setPromName(rs.getString("promName"));
				promotionVO.setPromStartTime(rs.getTimestamp("promStartTime"));
				promotionVO.setPromEndTime(rs.getTimestamp("promEndTime"));
				list.add(promotionVO);
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
		PromotionJDBCDAO dao = new PromotionJDBCDAO();
		// INSERT
//		PromotionVO promotionVO1 = new PromotionVO();
//		promotionVO1.setPromName("測試活動");
//		promotionVO1.setPromStartTime(java.sql.Timestamp.valueOf("2021-08-23 11:45:31"));
//		promotionVO1.setPromEndTime(java.sql.Timestamp.valueOf("2021-08-23 11:45:31"));
//		dao.insert(promotionVO1);

//		UPDATE
//		PromotionVO promotionVO2 = new PromotionVO();
//		promotionVO2.setPromName("測試活動3");
//		promotionVO2.setPromStartTime(java.sql.Timestamp.valueOf("2021-09-23 11:45:31"));
//		promotionVO2.setPromEndTime(java.sql.Timestamp.valueOf("2021-09-23 11:45:31"));
//		promotionVO2.setPromNo(4);
//		dao.update(promotionVO2);

		// DELETE
//		dao.delete(4);

		// GET_ONE_STMT
		PromotionVO promotionVO3 = dao.findByPrimaryKey(1);
		System.out.print(promotionVO3.getPromNo() + ",");
		System.out.print(promotionVO3.getPromName() + ",");
		System.out.print(promotionVO3.getPromStartTime() + ",");
		System.out.println(promotionVO3.getPromEndTime());
		System.out.println("----------------------------------------------------");

		// GET_ALL_STMT
		List<PromotionVO> list = dao.getAll();
		for (PromotionVO aPromotion : list) {
			System.out.print(aPromotion.getPromNo() + ",");
			System.out.print(aPromotion.getPromName() + ",");
			System.out.print(aPromotion.getPromStartTime() + ",");
			System.out.println(aPromotion.getPromEndTime());
			System.out.println();
		}
	}

}
