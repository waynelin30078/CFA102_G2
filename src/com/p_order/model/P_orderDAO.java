package com.p_order.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.promotion.model.PromotionVO;

public class P_orderDAO implements P_orderDAO_interface {

	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/David");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT = "INSERT INTO p_order (pOrderNo, mNo, pOrderDate, pOrderTotal, pOrderName, pOrderPhone,pOrderAddress, "
			+ "pPayment, pCreditCard, pCreditCardCVV, pShipping, pOrderState) VALUES (null, ?, now(), ?, ?, ?, ?, ?, ?, ?, ?, default)";
	private static final String UPDATE = "UPDATE p_order set pOrderTotal=?, pOrderName=?, pOrderPhone=?, pOrderAddress=?, pPayment=?, pCreditCard=?"
			+ ", pCreditCardCVV=?, pShipping=? where pOrderNo =?";
	private static final String UPDATE_ORDERSTATE = "UPDATE pOrderState=? where pOrderNo =?";
	private static final String DELETE = "DELETE FROM p_order where pOrderNo =?";
	private static final String GET_ONE_STMT = "SELECT * FROM p_order where pOrderNo =?";
	private static final String GET_ALL_STMT = "SELECT * FROM p_order order by pOrderNo";

	@Override
	public void insert(P_orderVO p_orderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
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

			con = ds.getConnection();
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_ORDERSTATE);

			pstmt.setInt(1, p_orderVO.getpOrderState());
			pstmt.setInt(2, p_orderVO.getpOrderNo());

			pstmt.executeUpdate();

			// Handle any driver errors
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, pOrderNo);

			pstmt.executeUpdate();

			// Handle any driver errors
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

			con = ds.getConnection();
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

			con = ds.getConnection();
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

}
