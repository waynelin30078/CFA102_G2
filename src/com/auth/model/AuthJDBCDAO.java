package com.auth.model;

import java.sql.*;
import java.util.*;

import com.admin.model.AdminDAO_interface;

public class AuthJDBCDAO implements Auth_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String user = "David";
	String password = "123456";

	private static final String insert = "INSERT INTO AUTH (authName,authDescription)VALUES(?,?)";
	private static final String update = "UPDATE AUTH set authName=?, authDescription=? where authNo=?";
	private static final String delete = "delete from AUTH where authNo=?";
	private static final String findByPrimaryKey = "select * from AUTH where authNo=?";
	private static final String getAll = "SELECT * FROM AUTH order by authNo";

	@Override
	public void insert(AuthVO authVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, authVO.getAuthName());
			pstmt.setString(2, authVO.getAuthDescription());
			pstmt.executeUpdate();
			System.out.println("新增成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void update(AuthVO authVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, authVO.getAuthName());
			pstmt.setString(2, authVO.getAuthDescription());
			pstmt.setInt(3, authVO.getAuthNo());
			pstmt.executeUpdate();
			System.out.println("修改成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void delete(Integer authNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, authNo);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void findByPrimaryKey(Integer aNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(findByPrimaryKey);
	
			pstmt.setInt(1, aNo);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.print("aNo=" + rs.getInt("authNo") + "\t");
			System.out.print("aName=" + rs.getString("AuthName") + "\t");
			System.out.print("aId=" + rs.getString("AuthDescription") + "\t");
			
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	}

	@Override
	public List<AuthVO> getAll() {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
			
				List<AuthVO> list = new ArrayList<AuthVO>();
			
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, user, password);
					pstmt = con.prepareStatement(getAll);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						AuthVO authVO = new AuthVO();
						authVO.setAuthNo(rs.getInt("authNo"));
						authVO.setAuthName(rs.getString("authName"));
						authVO.setAuthDescription(rs.getString("authDescription"));
						list.add(authVO);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list; 
			}

	public static void main(String[] args) {
		AuthJDBCDAO dao = new AuthJDBCDAO();

//		AuthVO authVO1 = new AuthVO();
//		authVO1.setAuthName("efedddd");
//		authVO1.setAuthDescription("pppppp");
//		dao.insert(authVO1);

//		AuthVO authVO2 = new AuthVO();
//		authVO2.setAuthName("ggggg");
//		authVO2.setAuthDescription("hhhh");
//		authVO2.setAuthNo(4);
//		dao.update(authVO2);

//		AuthVO authVO3 = new AuthVO();
//		authVO3.setAuthNo(4);
//		dao.delete(authVO3.getAuthNo());
		
//		AuthVO authVO4 = new AuthVO();
//		authVO4.setAuthNo(1);
//		dao.findByPrimaryKey(authVO4.getAuthNo());
		
		List<AuthVO> list =new ArrayList<AuthVO>();
		list=dao.getAll();
		for (AuthVO str : list)
			System.out.println(str.getAuthNo()+","+str.getAuthName()+","+str.getAuthDescription());
		System.out.println();
		
		
	}

}

//@Override
//public void findByPrimaryKey(Integer aNo) {
//	Connection con = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	AdminVO adminVO = new AdminVO();
//	try {
//		Class.forName(driver);
//		con = DriverManager.getConnection(url, user, password);
//		pstmt = con.prepareStatement(findByPrimaryKey);
//
//		pstmt.setInt(1, aNo);
//		rs = pstmt.executeQuery();
//		rs.next();
//		System.out.print("aNo=" + rs.getInt("aNo") + "\t");
//		System.out.print("aName=" + rs.getString("aName") + "\t");
//		System.out.print("aId=" + rs.getString("aId") + "\t");
//		System.out.print("aPsw=" + rs.getString("aPsw") + "\t");
//
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch (SQLException e) {
//
//		e.printStackTrace();
//	} finally {
//		if (rs != null)
//			try {
//				rs.close();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		if (pstmt != null)
//			try {
//				pstmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		if (con != null)
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
//
//}
//
//@Override
//public List<AdminVO> getAll() {
//
//	Connection con = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//
//	List<AdminVO> list = new ArrayList<AdminVO>();
//
//	try {
//		Class.forName(driver);
//		con = DriverManager.getConnection(url, user, password);
//		pstmt = con.prepareStatement(getAll);
//		rs = pstmt.executeQuery();
//		
//		while (rs.next()) {
//			AdminVO adminVO = new AdminVO();
//			adminVO.setaNo(rs.getInt("aNo"));
//			adminVO.setaName(rs.getString("aName"));
//			adminVO.setaId(rs.getString("aId"));
//			adminVO.setaPsw(rs.getString("aPsw"));
//			list.add(adminVO);
//		}
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return list; 
//}
//
//public static void main(String[] args) {
//	AdminJDBCDAO dao = new AdminJDBCDAO();
//	// 新增
////	AdminVO adminVO1 = new AdminVO();
////	for (int i = 0; i < 10; i++) {
////		adminVO1.setaName("aadc" + i);
////		adminVO1.setaId("bacd" + i);
////		adminVO1.setaPsw("cadc" + i);
////		dao.insert(adminVO1);
////	}
//	// 修改
////	AdminVO adminVO2 = new AdminVO();
////	adminVO2.setaName("offfo");
////	adminVO2.setaId("ppffp");
////	adminVO2.setaPsw("lffll");
////	adminVO2.setaNo(2);
////	dao.update(adminVO2);
////	// 刪除
////	AdminVO adminVO3 = new AdminVO();
////	adminVO3.setaNo(3);
////	dao.delete(adminVO3.getaNo());
////	 依管理員編號查詢
////	AdminVO adminVO4 = new AdminVO();
////	adminVO4.setaNo(1);
////	dao.findByPrimaryKey(adminVO4.getaNo());
////	// 查全部
//	List<AdminVO> list =new ArrayList<AdminVO>();
//	list=dao.getAll();
//	for (AdminVO str : list)
//		System.out.println(str.getaNo()+","+str.getaName()+","+str.getaId()+","+str.getaPsw());
//	System.out.println();
//}
