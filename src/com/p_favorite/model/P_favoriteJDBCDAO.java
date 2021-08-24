package com.p_favorite.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class P_favoriteJDBCDAO implements P_favoriteDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	// 新增收藏
	private static final String INSERT_STMT = "INSERT INTO p_favorite (mNo,pNo) VALUES (?, ?)";
	// 刪除收藏
	private static final String DELETE = "DELETE FROM p_favorite where mNo =? and pNo=?";
	// 查詢收藏(用會員編號)
	private static final String GET_FAVORITE_BY_MNO = "SELECT mNo,pNo FROM p_favorite where mNo =?";
	// 查詢所有收藏
	private static final String GET_ALL_STMT = "SELECT mNo,pNo FROM p_favorite order by mNo";

	@Override
	public void insert(P_favoriteVO p_favoriteVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, p_favoriteVO.getmNo());
			pstmt.setInt(2, p_favoriteVO.getpNo());

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
	public void delete(P_favoriteVO p_favoriteVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, p_favoriteVO.getmNo());
			pstmt.setInt(2, p_favoriteVO.getpNo());

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
	public List<P_favoriteVO> getAll_favorite(Integer mNo) {

		List<P_favoriteVO> list = new ArrayList<P_favoriteVO>();
		P_favoriteVO p_favoriteVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_FAVORITE_BY_MNO);
			pstmt.setInt(1, mNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				p_favoriteVO = new P_favoriteVO();
				p_favoriteVO.setmNo(rs.getInt("mNo"));
				p_favoriteVO.setpNo(rs.getInt("pNo"));

				list.add(p_favoriteVO); // Store the row in the list
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
	public List<P_favoriteVO> getAll() {

		List<P_favoriteVO> listAll = new ArrayList<P_favoriteVO>();
		P_favoriteVO p_favoriteVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				p_favoriteVO = new P_favoriteVO();
				p_favoriteVO.setmNo(rs.getInt("mNo"));
				p_favoriteVO.setpNo(rs.getInt("pNo"));

				listAll.add(p_favoriteVO); // Store the row in the list
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
		return listAll;
	}

	public static void main(String[] args) {

		P_favoriteJDBCDAO dao = new P_favoriteJDBCDAO();

		// INSERT_STMT
//		P_favoriteVO p_favoriteVO1 = new P_favoriteVO();
//		p_favoriteVO1.setmNo(1);
//		p_favoriteVO1.setpNo(400);
//		dao.insert(p_favoriteVO1);
//		p_favoriteVO1.setmNo(1);
//		p_favoriteVO1.setpNo(2);
//		dao.insert(p_favoriteVO1);
//		p_favoriteVO1.setmNo(1);
//		p_favoriteVO1.setpNo(78);
//		dao.insert(p_favoriteVO1);

		// DELETE
//		P_favoriteVO p_favoriteVO3 = new P_favoriteVO();
//		p_favoriteVO3.setmNo(1);
//		p_favoriteVO3.setpNo(1);
//		dao.delete(p_favoriteVO3);

		// GET_FAVORITE_STMT
		List<P_favoriteVO> list = dao.getAll_favorite(1);
		for (P_favoriteVO aP_favorite : list) {
			System.out.print(aP_favorite.getmNo() + ",");
			System.out.print(aP_favorite.getpNo());
			System.out.println();
		}
		System.out.println("--------------------------");
		// GET_ALL_STMT
		List<P_favoriteVO> listAll = dao.getAll();
		for (P_favoriteVO aP_favorite : listAll) {
			System.out.print(aP_favorite.getmNo() + ",");
			System.out.print(aP_favorite.getpNo());
			System.out.println();
		}		
	}

}
