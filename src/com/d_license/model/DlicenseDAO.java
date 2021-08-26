package com.d_license.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dietician.model.DieticianVO;


public class DlicenseDAO implements DlicenseDAO_interface {

	

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	private static final String insert_SQL = "INSERT INTO d_license (dNo, licDesc, licFile) VALUES(?, ?, ?);";
	private static final String update_SQL = "UPDATE d_license SET  dNo = ?, licDesc = ?, licFile = ? WHERE dLicNo = ?";
	private static final String getAll_SQL = "SELECT * FROM d_license;";
	private static final String findByDno_SQL = "SELECT * FROM d_license WHERE dNo = ?";

	
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(DlicenseVO dLicense) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);

			pstmt.setInt(1, dLicense.getdNo());
			pstmt.setString(2, dLicense.getLicDesc());
			pstmt.setString(3, dLicense.getLicFile());

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
	public void update(DlicenseVO dLicense) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(update_SQL);

			pstmt.setInt(1, dLicense.getdNo());
			pstmt.setString(2, dLicense.getLicDesc());
			pstmt.setString(3, dLicense.getLicFile());
			pstmt.setInt(4, dLicense.getdLicNo());

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
	public List<DlicenseVO> getAll() {
		Connection con = null;
		List<DlicenseVO> dLicenses = new ArrayList<DlicenseVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(getAll_SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				DlicenseVO dLicense = new DlicenseVO();

				dLicense.setdLicNo(rs.getInt("dLicNo"));
				dLicense.setdNo(rs.getInt("dNo"));
				dLicense.setLicDesc(rs.getString("licDesc"));
				dLicense.setLicFile(rs.getString("licFile"));

				dLicenses.add(dLicense);

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

		return dLicenses;

	}

	@Override
	public List<DlicenseVO> findByDno(int dNo) {
		Connection con = null;
		List<DlicenseVO> dLicenses = new ArrayList<DlicenseVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByDno_SQL);

			pstmt.setInt(1, dNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				DlicenseVO dLicense = new DlicenseVO();

				dLicense.setdLicNo(rs.getInt("dLicNo"));
				dLicense.setdNo(rs.getInt("dNo"));
				dLicense.setLicDesc(rs.getString("licDesc"));
				dLicense.setLicFile(rs.getString("licFile"));

				dLicenses.add(dLicense);

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

		return dLicenses;

	}


	
	
	public static void main(String[] args) {

		DlicenseDAO dao = new DlicenseDAO();
//		
//		List<DlicenseVO> licenses = dao.getAll();
//		
//		for (DlicenseVO license : licenses) {
//
//			System.out.println(license.getdLicNo());
//			System.out.println(license.getdNo());
//			System.out.println(license.getLicDesc());
//			System.out.println(license.getLicFile());
//			
//		}

		

//		
//		List<DlicenseVO> licenses = dao.findByDno(3);
//		
//		for (DlicenseVO license : licenses) {
//
//			System.out.println(license.getdLicNo());
//			System.out.println(license.getdNo());
//			System.out.println(license.getLicDesc());
//			System.out.println(license.getLicFile());
//			
//		}
		
		DlicenseVO dLicense = new DlicenseVO();
		
		dLicense.setdLicNo(4);
		dLicense.setdNo(5);
		dLicense.setLicDesc("腎臟專科");
		dLicense.setLicFile("/images/Dlicense/ccc.jpg");
		
//		dao.insert(dLicense);

		dLicense.setLicDesc("肝臟專科");
		
		dao.update(dLicense);
		
		
		
	}

}
