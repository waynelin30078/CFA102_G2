package com.c_order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.video.model.VideoVO;

import util.Util;

public class C_OrderJDBCDAO implements C_OrderDAO_interface {
	private static final String INSERT = "INSERT INTO C_ORDER(mNo,orderDate,total,paymentMethod,paymentInfo) VALUES(?,NOW(),?,?,?)";
	private static final String UPDATE_ORDERSTATE = "UPDATE C_ORDER SET orderState=? WHERE cOrderNo=?";
	private static final String UPDATE_PAYMENT = "UPDATE C_ORDER SET paymentMethod=?,paymentInfo=? WHERE cOrderNo=?";
	private static final String GETONE = "SELECT * FROM C_ORDER WHERE cOrderNo=?";
	private static final String GETALL = "SELECT * FROM C_ORDER";
	private static final String GETALL_BYMNO = "SELECT * FROM C_ORDER WHERE mNO=?";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(C_OrderVO c_order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// paymentMethod,paymentInfo
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, c_order.getMno());
			pstmt.setInt(2, c_order.getTotal());
			pstmt.setInt(3, c_order.getPaymentMethod());
			pstmt.setString(4, c_order.getPaymentInfo());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void updateOrderState(C_OrderVO c_order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// paymentMethod,paymentInfo
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_ORDERSTATE);
			pstmt.setInt(1, c_order.getOrderState());
			pstmt.setInt(2, c_order.getCorderno());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void updatePayment(C_OrderVO c_order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// paymentMethod,paymentInfo
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_PAYMENT);

			pstmt.setInt(1, c_order.getPaymentMethod());
			pstmt.setString(2, c_order.getPaymentInfo());
			pstmt.setInt(3, c_order.getCorderno());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public C_OrderVO getOne(Integer cOrderno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		C_OrderVO cOrderVO = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GETONE);
			pstmt.setInt(1, cOrderno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cOrderVO = new C_OrderVO();
				cOrderVO.setCorderno(cOrderno);
				cOrderVO.setMno(rs.getInt("mNo"));
				cOrderVO.setOrderDate(rs.getTimestamp("orderDate"));
				;
				cOrderVO.setTotal(rs.getInt("total"));
				cOrderVO.setOrderState(rs.getInt("orderState"));

				cOrderVO.setPaymentMethod(rs.getInt("paymentMethod"));
				cOrderVO.setPaymentInfo(rs.getString("paymentInfo"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cOrderVO;
	}

	@Override
	public List<C_OrderVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<C_OrderVO> cOrderList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GETALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				C_OrderVO cOrderVO = new C_OrderVO();
				cOrderVO.setCorderno(rs.getInt("cOrderNo"));
				cOrderVO.setMno(rs.getInt("mNo"));
				cOrderVO.setOrderDate(rs.getTimestamp("orderDate"));
				;
				cOrderVO.setTotal(rs.getInt("total"));
				cOrderVO.setOrderState(rs.getInt("orderState"));
				cOrderVO.setPaymentMethod(rs.getInt("paymentMethod"));
				cOrderVO.setPaymentInfo(rs.getString("paymentInfo"));
				cOrderList.add(cOrderVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cOrderList;
	}

	@Override
	public List<C_OrderVO> getAll(Integer mNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<C_OrderVO> cOrderList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GETALL_BYMNO);
			pstmt.setInt(1, mNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				C_OrderVO cOrderVO = new C_OrderVO();
				cOrderVO.setCorderno(rs.getInt("cOrderNo"));
				cOrderVO.setMno(rs.getInt(mNo));
				cOrderVO.setOrderDate(rs.getTimestamp("orderDate"));
				cOrderVO.setTotal(rs.getInt("total"));
				cOrderVO.setOrderState(rs.getInt("orderState"));
				cOrderVO.setPaymentMethod(rs.getInt("paymentMethod"));
				cOrderVO.setPaymentInfo(rs.getString("paymentInfo"));
				cOrderList.add(cOrderVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cOrderList;
	}

//	public static void main(String[] args) {
//		C_OrderDAO_interface dao = new C_OrderJDBCDAO();
//		C_OrderVO VO = new C_OrderVO();
//
//		VO.setCorderno(2);
//		VO.setMno(1);
//		VO.setOrderDate((java.sql.Timestamp.valueOf("9999-12-31 23:59:59")));
//		VO.setTotal(1000);
//		VO.setOrderState(3);
//		VO.setPaymentMethod(2);
//		VO.setPaymentInfo("1221-1111-1111");

//		dao.insert(VO);
//		dao.updateOrderState(VO);
//		dao.updatePayment(VO);
//		dao.getOne(1);
//		List<C_OrderVO> vList =dao.getAll(1);
//		for(C_OrderVO v:vList)
//			System.out.println(v);
//
//		System.out.println(dao);
		
//	}

}