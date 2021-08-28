package com.c_order_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import util.Util;

public class C_Order_DetailJDBCDAO implements C_Order_DetailDAO_interface {
	private static final String INSERT="INSERT INTO C_ORDER_DETAIL (cOrderNo,cNo,cPrice,cProgress) VALUES(?,?,?,default)";
	private static final String UPDATE= "UPDATE C_ORDER_DETAIL SET cEvaluation=? cReviews=? cProgress=? WHERE cOrderNo=? AND cNo=?";
	private static final String DELETE="DELECT FROM C_ORDER_DETAIL WHERE cOrderNo=? AND cNo=?";
	private static final String GETONE="SELECT * FROM C_ORDER_DETAIL WHERE cOrderNo=? AND cNo=?";
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	@Override
	public void insert(C_Order_DetailVO cOrderDetail) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, cOrderDetail.getCorderno());
			pstmt.setInt(2, cOrderDetail.getCno());
			pstmt.setInt(3, cOrderDetail.getCprice());
			
			pstmt.executeUpdate();
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
	public void update(C_Order_DetailVO cOrderDetail) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, cOrderDetail.getCorderno());
			pstmt.setInt(2, cOrderDetail.getCno());
			pstmt.setInt(3, cOrderDetail.getCprice());
			
			pstmt.executeUpdate();
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
	public void delete(C_Order_DetailVO cOrderDetail) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, cOrderDetail.getCorderno());
			pstmt.setInt(2, cOrderDetail.getCno());
			
			
			pstmt.executeUpdate();
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

	private Integer cprice;
	private Integer cevaluation;
	private String creviews;
	private Integer cprogress;

	@Override
	public C_Order_DetailVO getOne(Integer corderno,Integer cno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		C_Order_DetailVO codVO= null;
		
		try {
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GETONE);
			pstmt.setInt(1, corderno);
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				codVO = new C_Order_DetailVO();
				codVO.setCorderno(corderno);
				codVO.setCno(rs.getInt(cno));
				codVO.setCprice(rs.getInt("cPrice"));
				codVO.setCevaluation(rs.getInt("cEvaluation"));
				codVO.setCreviews(rs.getString("cReviews"));
				codVO.setCprogress(rs.getInt("cProgress"));
				
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

		return codVO;
	}

	@Override
	public List<C_Order_DetailVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
