package com.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AdminJDBCDAO implements AdminDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String user = "David";
	String password = "123456";

	private static final String insert = "INSERT INTO ADMIN (aName,aId,aPsw)VALUES(?,?,?)";
	private static final String update = "UPDATE ADMIN set aName=?, aId=?, aPsw=? where aNo=?";
	private static final String delete = "delete from ADMIN where aNo=?";
	private static final String findByPrimaryKey = "select * from ADMIN where aNo=?";
	private static final String getAll = "SELECT * FROM ADMIN order by aNo";

	@Override
	public void insert(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(insert);

			pstmt.setString(1, adminVO.getaName());
			pstmt.setString(2, adminVO.getaId());
			pstmt.setString(3, adminVO.getaPsw());
			pstmt.executeUpdate();
			System.out.println("新增成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void update(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);

			pstmt.setString(1, adminVO.getaName());
			pstmt.setString(2, adminVO.getaId());
			pstmt.setString(3, adminVO.getaPsw());
			pstmt.setInt(4, adminVO.getaNo());
			pstmt.executeUpdate();
			System.out.println("修改成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void delete(Integer aNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(delete);

			pstmt.setInt(1, aNo);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	@Override
	public void findByPrimaryKey(Integer aNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminVO adminVO = new AdminVO();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(findByPrimaryKey);

			pstmt.setInt(1, aNo);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.print("aNo=" + rs.getInt("aNo") + "\t");
			System.out.print("aName=" + rs.getString("aName") + "\t");
			System.out.print("aId=" + rs.getString("aId") + "\t");
			System.out.print("aPsw=" + rs.getString("aPsw") + "\t");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	@Override
	public List<AdminVO> getAll() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<AdminVO> list = new ArrayList<AdminVO>();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(getAll);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AdminVO adminVO = new AdminVO();
				adminVO.setaNo(rs.getInt("aNo"));
				adminVO.setaName(rs.getString("aName"));
				adminVO.setaId(rs.getString("aId"));
				adminVO.setaPsw(rs.getString("aPsw"));
				list.add(adminVO);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}

	public static void main(String[] args) {
		AdminJDBCDAO dao = new AdminJDBCDAO();
		// 新增
//		AdminVO adminVO1 = new AdminVO();
//		for (int i = 0; i < 10; i++) {
//			adminVO1.setaName("aadc" + i);
//			adminVO1.setaId("bacd" + i);
//			adminVO1.setaPsw("cadc" + i);
//			dao.insert(adminVO1);
//		}
		// 修改
//		AdminVO adminVO2 = new AdminVO();
//		adminVO2.setaName("offfo");
//		adminVO2.setaId("ppffp");
//		adminVO2.setaPsw("lffll");
//		adminVO2.setaNo(2);
//		dao.update(adminVO2);
		// 刪除
//		AdminVO adminVO3 = new AdminVO();
//		adminVO3.setaNo(3);
//		dao.delete(adminVO3.getaNo());
//		 依管理員編號查詢
//		AdminVO adminVO4 = new AdminVO();
//		adminVO4.setaNo(1);
//		dao.findByPrimaryKey(adminVO4.getaNo());
		// 查全部
		List<AdminVO> list =new ArrayList<AdminVO>();
		list=dao.getAll();
		for (AdminVO str : list)
			System.out.println(str.getaNo()+","+str.getaName()+","+str.getaId()+","+str.getaPsw());
		System.out.println();
	}
}
