package com.d_order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dietician.model.DieticianVO;
import com.member.model.MemberVO;

public class DorderDAO implements DorderDAO_interface {

	Connection con;

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	private static final String insert_SQL = "INSERT INTO D_order(dNo, mNo, subStart, subEnd, mthFee, dReview, dScore, autoSubs) VALUES(?, ?, ?, ?, ?, ?, ?, ? );";
	private static final String update_SQL = "UPDATE d_order SET dNo = ?, mNo = ?, "
			+ "subStart = ?, subEnd = ?, mthFee = ?, dReview = ?, dScore = ?, autoSubs = ? WHERE dOrderNo = ?";
	private static final String findByPrimaryKey_SQL = "SELECT * FROM d_Order WHERE dOrderNo = ?";
	private static final String getAll_SQL = "SELECT * FROM d_order;";
	private static final String getActiveOrder_SQL = "SELECT * FROM d_Order WHERE subEnd > current_timestamp;";
	private static final String getActiveOrderByDNo_SQL = "SELECT * FROM d_order WHERE dNo = ? AND subEnd > current_timestamp;";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(DorderVO dOrder) {

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);

			pstmt.setInt(1, dOrder.getdNo());
			pstmt.setInt(2, dOrder.getmNo());
			pstmt.setTimestamp(3, dOrder.getSubStart());
			pstmt.setTimestamp(4, dOrder.getSubEnd());
			pstmt.setInt(5, dOrder.getMthFee());
			pstmt.setString(6, dOrder.getdReview());
			pstmt.setInt(7, dOrder.getdScore());
			pstmt.setInt(8, dOrder.getAutoSubs());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public void update(DorderVO dOrder) {

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(update_SQL);

			pstmt.setInt(1, dOrder.getdNo());
			pstmt.setInt(2, dOrder.getmNo());
			pstmt.setTimestamp(3, dOrder.getSubStart());
			pstmt.setTimestamp(4, dOrder.getSubEnd());
			pstmt.setInt(5, dOrder.getMthFee());
			pstmt.setString(6, dOrder.getdReview());
			pstmt.setInt(7, dOrder.getdScore());
			pstmt.setInt(8, dOrder.getAutoSubs());
			pstmt.setInt(9, dOrder.getdOrderNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public DorderVO findByPrimaryKey(int dOrderNo) {

		DorderVO dOrder = new DorderVO();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByPrimaryKey_SQL);
			pstmt.setInt(1, dOrderNo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				dOrder.setdOrderNo(rs.getInt("dOrderNo"));
				dOrder.setdNo(rs.getInt("dNo"));
				dOrder.setmNo(rs.getInt("mNo"));
				dOrder.setSubStart(rs.getTimestamp("subStart"));
				dOrder.setSubEnd(rs.getTimestamp("subEnd"));
				dOrder.setMthFee(rs.getInt("mthFee"));
				dOrder.setdReview(rs.getString("dReview"));
				dOrder.setdScore(rs.getInt("dScore"));
				dOrder.setAutoSubs(rs.getInt("autoSubs"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return dOrder;
	}

	@Override
	public List<DorderVO> getAll() {

		List<DorderVO> dOrders = new ArrayList<DorderVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(getAll_SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				DorderVO dOrder = new DorderVO();
				dOrder.setdOrderNo(rs.getInt("dOrderNo"));
				dOrder.setdNo(rs.getInt("dNo"));
				dOrder.setmNo(rs.getInt("mNo"));
				dOrder.setSubStart(rs.getTimestamp("subStart"));
				dOrder.setSubEnd(rs.getTimestamp("subEnd"));
				dOrder.setMthFee(rs.getInt("mthFee"));
				dOrder.setdReview(rs.getString("dReview"));
				dOrder.setdScore(rs.getInt("dScore"));
				dOrder.setAutoSubs(rs.getInt("autoSubs"));

				dOrders.add(dOrder);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return dOrders;
	}

	@Override
	public List<DorderVO> getActiveOrder() {

		List<DorderVO> dOrders = new ArrayList<DorderVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(getActiveOrder_SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				DorderVO dOrder = new DorderVO();
				dOrder.setdOrderNo(rs.getInt("dOrderNo"));
				dOrder.setdNo(rs.getInt("dNo"));
				dOrder.setmNo(rs.getInt("mNo"));
				dOrder.setSubStart(rs.getTimestamp("subStart"));
				dOrder.setSubEnd(rs.getTimestamp("subEnd"));
				dOrder.setMthFee(rs.getInt("mthFee"));
				dOrder.setdReview(rs.getString("dReview"));
				dOrder.setdScore(rs.getInt("dScore"));
				dOrder.setAutoSubs(rs.getInt("autoSubs"));

				dOrders.add(dOrder);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return dOrders;

	}

	@Override
	public List<DorderVO> getActiveOrderByDNo(int dNo) {
		
		List<DorderVO> dOrders = new ArrayList<DorderVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(getActiveOrderByDNo_SQL);
			pstmt.setInt(1, dNo);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				DorderVO dOrder = new DorderVO();
				dOrder.setdOrderNo(rs.getInt("dOrderNo"));
				dOrder.setdNo(rs.getInt("dNo"));
				dOrder.setmNo(rs.getInt("mNo"));
				dOrder.setSubStart(rs.getTimestamp("subStart"));
				dOrder.setSubEnd(rs.getTimestamp("subEnd"));
				dOrder.setMthFee(rs.getInt("mthFee"));
				dOrder.setdReview(rs.getString("dReview"));
				dOrder.setdScore(rs.getInt("dScore"));
				dOrder.setAutoSubs(rs.getInt("autoSubs"));

				dOrders.add(dOrder);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return dOrders;

	}

	public static void main(String[] args) {

		DorderDAO dao = new DorderDAO();

		List<DorderVO> dOrders = dao.getActiveOrderByDNo(3);

		for (DorderVO dOrder : dOrders) {
			System.out.println(dOrder.getdReview());
		}

//		DorderVO order = dao.findByPrimaryKey(2);
//		System.out.println(order.getSubStart());
//		System.out.println(order.getSubEnd());
//		
//		long subStart = order.getSubStart().getTime(); //sql.TimeStamp to long
//		long subEnd = order.getSubEnd().getTime();
//		System.out.println((subEnd-subStart)/(1000*60*60*24));

	}

}