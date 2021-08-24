package com.p_order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class P_orderJDBCDAO implements P_orderDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO p_order (pOrderNo, mNo, pOrderDate, pOrderTotal, pOrderName, pOrderPhone,pOrderAddress, "
			+ "pPayment, pCreditCard, pCreditCardCVV, pShipping, pOrderState) VALUES (null, ?, now(), ?, ?, ?, ?, ?, ?, ?, ?, default)";
	private static final String UPDATE = "UPDATE p_order set pOrderTotal=?, pOrderName=?, pOrderPhone=?, pOrderAddress=?, pPayment=?, pCreditCard=?"
			+ ", pCreditCardCVV=?, pShipping=? where pOrderNo =?";
	private static final String UPDATE_ORDERSTATE = "UPDATE p_order set pOrderState=? where pOrderNo =?";
	private static final String DELETE = "DELETE FROM p_order where pOrderNo =?";
	private static final String GET_ONE_STMT = "SELECT * FROM p_order where pOrderNo =?";
	private static final String GET_ALL_STMT = "SELECT * FROM p_order order by pOrderNo";

	@Override
	public void insert(P_orderVO p_orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, p_orderVO.getmNo());
			pstmt.setInt(2, p_orderVO.getpOrderTotal());
			pstmt.setString(3, p_orderVO.getpOrderName());
			pstmt.setString(4, p_orderVO.getpOrderPhone());
			pstmt.setString(5, p_orderVO.getpOrderAddress());
			pstmt.setInt(6, p_orderVO.getpPayment());
			pstmt.setString(7, p_orderVO.getpCreditCard());
			pstmt.setString(8, p_orderVO.getpCreditCardCVV());
			pstmt.setInt(9, p_orderVO.getpShipping());

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
	public void update(P_orderVO p_orderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, p_orderVO.getpOrderTotal());
			pstmt.setString(2, p_orderVO.getpOrderName());
			pstmt.setString(3, p_orderVO.getpOrderPhone());
			pstmt.setString(4, p_orderVO.getpOrderAddress());
			pstmt.setInt(5, p_orderVO.getpPayment());
			pstmt.setString(6, p_orderVO.getpCreditCard());
			pstmt.setString(7, p_orderVO.getpCreditCardCVV());
			pstmt.setInt(8, p_orderVO.getpShipping());
			pstmt.setInt(9, p_orderVO.getpOrderNo());

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
	public void update_orderState(P_orderVO p_orderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_ORDERSTATE);

			pstmt.setInt(1, p_orderVO.getpOrderState());
			pstmt.setInt(2, p_orderVO.getpOrderNo());

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
	public void delete(Integer pOrderNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, pOrderNo);

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
	public P_orderVO findByPrimaryKey(Integer pOrderNo) {

		P_orderVO p_orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, pOrderNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				p_orderVO = new P_orderVO();
				p_orderVO.setpOrderNo(rs.getInt("pOrderNo"));
				p_orderVO.setmNo(rs.getInt("mNo"));
				p_orderVO.setpOrderDate(rs.getTimestamp("pOrderDate"));
				p_orderVO.setpOrderTotal(rs.getInt("pOrderTotal"));
				p_orderVO.setpOrderName(rs.getString("pOrderName"));
				p_orderVO.setpOrderPhone(rs.getString("pOrderPhone"));
				p_orderVO.setpOrderAddress(rs.getString("pOrderAddress"));
				p_orderVO.setpPayment(rs.getInt("pPayment"));
				p_orderVO.setpCreditCard(rs.getString("pCreditCard"));
				p_orderVO.setpCreditCardCVV(rs.getString("pCreditCardCVV"));
				p_orderVO.setpShipping(rs.getInt("pShipping"));
				p_orderVO.setpOrderState(rs.getInt("pOrderState"));

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
		return p_orderVO;
	}

	@Override
	public List<P_orderVO> getAll() {

		List<P_orderVO> list = new ArrayList<P_orderVO>();
		P_orderVO p_orderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				p_orderVO = new P_orderVO();
				p_orderVO.setpOrderNo(rs.getInt("pOrderNo"));
				p_orderVO.setmNo(rs.getInt("mNo"));
				p_orderVO.setpOrderDate(rs.getTimestamp("pOrderDate"));
				p_orderVO.setpOrderTotal(rs.getInt("pOrderTotal"));
				p_orderVO.setpOrderName(rs.getString("pOrderName"));
				p_orderVO.setpOrderPhone(rs.getString("pOrderPhone"));
				p_orderVO.setpOrderAddress(rs.getString("pOrderAddress"));
				p_orderVO.setpPayment(rs.getInt("pPayment"));
				p_orderVO.setpCreditCard(rs.getString("pCreditCard"));
				p_orderVO.setpCreditCardCVV(rs.getString("pCreditCardCVV"));
				p_orderVO.setpShipping(rs.getInt("pShipping"));
				p_orderVO.setpOrderState(rs.getInt("pOrderState"));
				list.add(p_orderVO);
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

		P_orderJDBCDAO dao = new P_orderJDBCDAO();

		// INSERT_STMT
//		P_orderVO p_orderVO1 = new P_orderVO();
//		p_orderVO1.setmNo(11);
//		p_orderVO1.setpOrderTotal(8000);
//		p_orderVO1.setpOrderName("林零七");
//		p_orderVO1.setpOrderPhone("0913365605");
//		p_orderVO1.setpOrderAddress("桃園市桃園區中正路61號");
//		p_orderVO1.setpPayment(1);
//		p_orderVO1.setpCreditCard("3210963025807531");
//		p_orderVO1.setpCreditCardCVV("321");
//		p_orderVO1.setpShipping(1);
//		dao.insert(p_orderVO1);

		// UPDATE
//		P_orderVO p_orderVO2 = new P_orderVO();
//		p_orderVO2.setpOrderTotal(9500);
//		p_orderVO2.setpOrderName("林六");
//		p_orderVO2.setpOrderPhone("0913365605");
//		p_orderVO2.setpOrderAddress("桃園市桃園區中正路61號");
//		p_orderVO2.setpPayment(1);
//		p_orderVO2.setpCreditCard("3210963025807531");
//		p_orderVO2.setpCreditCardCVV("321");
//		p_orderVO2.setpShipping(1);
//		p_orderVO2.setpOrderNo(11);
//		dao.update(p_orderVO2);

		// UPDATE_ORDERSTATE
//		P_orderVO p_orderVO3 = new P_orderVO();
//		p_orderVO3.setpOrderState(4);
//		p_orderVO3.setpOrderNo(12);
//		dao.update_orderState(p_orderVO3);

		// DELETE
//		dao.delete(12);

		// GET_ONE_STMT
		P_orderVO p_orderVO4 = dao.findByPrimaryKey(1);
		System.out.print(p_orderVO4.getpOrderNo() + ",");
		System.out.print(p_orderVO4.getmNo() + ",");
		System.out.print(p_orderVO4.getpOrderDate() + ",");
		System.out.print(p_orderVO4.getpOrderTotal() + ",");
		System.out.print(p_orderVO4.getpOrderName() + ",");
		System.out.print(p_orderVO4.getpOrderPhone() + ",");
		System.out.print(p_orderVO4.getpOrderAddress() + ",");
		System.out.print(p_orderVO4.getpPayment() + ",");
		System.out.print(p_orderVO4.getpCreditCard() + ",");
		System.out.print(p_orderVO4.getpCreditCardCVV() + ",");
		System.out.print(p_orderVO4.getpShipping() + ",");
		System.out.println(p_orderVO4.getpOrderState());
		System.out.println("---------------------");

		// GET_ALL_STMT
		List<P_orderVO> list = dao.getAll();
		for (P_orderVO aP_order : list) {
			System.out.print(aP_order.getpOrderNo() + ",");
			System.out.print(aP_order.getmNo() + ",");
			System.out.print(aP_order.getpOrderDate() + ",");
			System.out.print(aP_order.getpOrderTotal() + ",");
			System.out.print(aP_order.getpOrderName() + ",");
			System.out.print(aP_order.getpOrderPhone() + ",");
			System.out.print(aP_order.getpOrderAddress() + ",");
			System.out.print(aP_order.getpPayment() + ",");
			System.out.print(aP_order.getpCreditCard() + ",");
			System.out.print(aP_order.getpCreditCardCVV() + ",");
			System.out.print(aP_order.getpShipping() + ",");
			System.out.println(aP_order.getpOrderState());
			System.out.println();
		}

	}

}
