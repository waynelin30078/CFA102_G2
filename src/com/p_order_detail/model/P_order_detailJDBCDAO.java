package com.p_order_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class P_order_detailJDBCDAO implements P_order_detailDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	// 商品訂單明細
	private static final String INSERT_STMT = "INSERT INTO p_order_detail (pOrderNo, pNo, pOrderQuantity, pPrice, pRatings) VALUES (?, ?, ?, ?, ?)";
	// 更新商品訂單明細
	private static final String UPDATE = "UPDATE p_order_detail SET pOrderQuantity=?, pPrice=?, pRatings=? WHERE pOrderNo =? AND pNo =?";
	// 更新商品訂單明細(訂購數量)
	private static final String UPDATE_QUANTITY = "UPDATE p_order_detail SET pOrderQuantity=? WHERE pOrderNo =? AND pNo =?";
	// 更新商品訂單明細(商品單價)
	private static final String UPDATE_PRICE = "UPDATE p_order_detail SET pPrice=? WHERE pOrderNo =? AND pNo =?";
	// 更新商品訂單明細(商品評價)
	private static final String UPDATE_RATINGS = "UPDATE p_order_detail SET pRatings=? WHERE pOrderNo =? AND pNo =?";
	// 刪除商品訂單明細
	private static final String DELETE = "DELETE FROM p_order_detail WHERE pOrderNo =? AND pNo =?";
	// 查詢商品訂單明細(用商品訂單編號)
	private static final String GET_ALL_BY_ORDERNO = "SELECT * FROM p_order_detail WHERE pOrderNo =? ORDER BY pOrderNo";
	// 查詢所有商品訂單
	private static final String GET_ALL_STMT = "SELECT * FROM p_order_detail ORDER BY pOrderNo";

	@Override
	public void insert(P_order_detailVO p_order_detailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, p_order_detailVO.getpOrderNo());
			pstmt.setInt(2, p_order_detailVO.getpNo());
			pstmt.setInt(3, p_order_detailVO.getpOrderQuantity());
			pstmt.setInt(4, p_order_detailVO.getpPrice());
			pstmt.setInt(5, p_order_detailVO.getpRatings());

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
	public void update(P_order_detailVO p_order_detailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, p_order_detailVO.getpOrderQuantity());
			pstmt.setInt(2, p_order_detailVO.getpPrice());
			pstmt.setInt(3, p_order_detailVO.getpRatings());
			pstmt.setInt(4, p_order_detailVO.getpOrderNo());
			pstmt.setInt(5, p_order_detailVO.getpNo());

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
	public void updateQuantity(P_order_detailVO p_order_detailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_QUANTITY);

			pstmt.setInt(1, p_order_detailVO.getpOrderQuantity());
			pstmt.setInt(2, p_order_detailVO.getpOrderNo());
			pstmt.setInt(3, p_order_detailVO.getpNo());

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
	public void updatePrice(P_order_detailVO p_order_detailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_PRICE);

			pstmt.setInt(1, p_order_detailVO.getpPrice());
			pstmt.setInt(2, p_order_detailVO.getpOrderNo());
			pstmt.setInt(3, p_order_detailVO.getpNo());

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
	public void updateRatings(P_order_detailVO p_order_detailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_RATINGS);

			pstmt.setInt(1, p_order_detailVO.getpRatings());
			pstmt.setInt(2, p_order_detailVO.getpOrderNo());
			pstmt.setInt(3, p_order_detailVO.getpNo());

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
	public void delete(Integer pOrderNo, Integer pNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, pOrderNo);
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
	public List<P_order_detailVO> getAll_byOrderNo(Integer pOrderNo) {

		List<P_order_detailVO> list = new ArrayList<P_order_detailVO>();
		P_order_detailVO p_order_detailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_BY_ORDERNO);
			pstmt.setInt(1, pOrderNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				p_order_detailVO = new P_order_detailVO();
				p_order_detailVO.setpOrderNo(rs.getInt("pOrderNo"));
				p_order_detailVO.setpNo(rs.getInt("pNo"));
				p_order_detailVO.setpOrderQuantity(rs.getInt("pOrderQuantity"));
				p_order_detailVO.setpPrice(rs.getInt("pPrice"));
				p_order_detailVO.setpRatings(rs.getInt("pRatings"));

				list.add(p_order_detailVO); // Store the row in the list
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
	public List<P_order_detailVO> getAll() {

		List<P_order_detailVO> list = new ArrayList<P_order_detailVO>();
		P_order_detailVO p_order_detailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				p_order_detailVO = new P_order_detailVO();
				p_order_detailVO.setpOrderNo(rs.getInt("pOrderNo"));
				p_order_detailVO.setpNo(rs.getInt("pNo"));
				p_order_detailVO.setpOrderQuantity(rs.getInt("pOrderQuantity"));
				p_order_detailVO.setpPrice(rs.getInt("pPrice"));
				p_order_detailVO.setpRatings(rs.getInt("pRatings"));

				list.add(p_order_detailVO); // Store the row in the list
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

		P_order_detailJDBCDAO dao = new P_order_detailJDBCDAO();

		// INSERT_STMT
//		P_order_detailVO p_order_detailVO1 = new P_order_detailVO();
//		p_order_detailVO1.setpOrderNo(7);
//		p_order_detailVO1.setpNo(1);
//		p_order_detailVO1.setpOrderQuantity(10);
//		p_order_detailVO1.setpPrice(300);
//		p_order_detailVO1.setpRatings(4);
//		dao.insert(p_order_detailVO1);

		// UPDATE
//		P_order_detailVO p_order_detailVO2 = new P_order_detailVO();
//		p_order_detailVO2.setpOrderQuantity(100);
//		p_order_detailVO2.setpPrice(500);
//		p_order_detailVO2.setpRatings(3);
//		p_order_detailVO2.setpOrderNo(7);
//		p_order_detailVO2.setpNo(1);		
//		dao.update(p_order_detailVO2);

		// UPDATE_QUANTITY
//		P_order_detailVO p_order_detailVO3 = new P_order_detailVO();
//		p_order_detailVO3.setpOrderNo(7);
//		p_order_detailVO3.setpNo(1);
//		p_order_detailVO3.setpOrderQuantity(1);
//		dao.updateQuantity(p_order_detailVO3);	

		// UPDATE_PRICE
//		P_order_detailVO p_order_detailVO4 = new P_order_detailVO();
//		p_order_detailVO4.setpOrderNo(7);
//		p_order_detailVO4.setpNo(1);
//		p_order_detailVO4.setpPrice(3000);
//		dao.updatePrice(p_order_detailVO4);

		// UPDATE_RATINGS
//		P_order_detailVO p_order_detailVO5 = new P_order_detailVO();
//		p_order_detailVO5.setpOrderNo(7);
//		p_order_detailVO5.setpNo(1);
//		p_order_detailVO5.setpRatings(4);
//		dao.updateRatings(p_order_detailVO5);

		// DELETE
//		dao.delete(7,1);

		// GET_ALL_BY_ORDERNO
		List<P_order_detailVO> list = dao.getAll_byOrderNo(7);
		for (P_order_detailVO aP_order_detail : list) {
			System.out.print(aP_order_detail.getpOrderNo() + ",");
			System.out.print(aP_order_detail.getpNo() + ",");
			System.out.print(aP_order_detail.getpOrderQuantity() + ",");
			System.out.print(aP_order_detail.getpPrice() + ",");
			System.out.print(aP_order_detail.getpRatings());
			System.out.println();
		}
		System.out.println("--------------------------");
		// GET_ALL_STMT
		List<P_order_detailVO> list1 = dao.getAll();
		for (P_order_detailVO aP_order_detail : list1) {
			System.out.print(aP_order_detail.getpOrderNo() + ",");
			System.out.print(aP_order_detail.getpNo() + ",");
			System.out.print(aP_order_detail.getpOrderQuantity() + ",");
			System.out.print(aP_order_detail.getpPrice() + ",");
			System.out.print(aP_order_detail.getpRatings());
			System.out.println();
		}

	}

}
