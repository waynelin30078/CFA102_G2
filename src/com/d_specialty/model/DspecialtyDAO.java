package com.d_specialty.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.specialty.model.SpecialtyVO;

public class DspecialtyDAO implements DspecialtyDAO_interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	private static final String insert_SQL = "INSERT INTO d_specialty (specialtyNo, dNo) VALUES(?, ?);";
	private static final String delete_SQL = "DELETE FROM d_specialty WHERE specialtyNo = ? AND dNo = ?;";
	private static final String getAll_SQL = "SELECT * FROM d_specialty;";
	private static final String findByDno_SQL = "SELECT * FROM d_specialty WHERE dNo = ?;";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insert(DspecialtyVO dSpecialty) {

		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);

			pstmt.setInt(1, dSpecialty.getSpecialtyNo());
			pstmt.setInt(2, dSpecialty.getdNo());

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

	public void delete(DspecialtyVO dSpecialty) {

		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(delete_SQL);

			pstmt.setInt(1, dSpecialty.getSpecialtyNo());
			pstmt.setInt(2, dSpecialty.getdNo());

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
	public List<DspecialtyVO> getAll() {

		Connection con = null;
		List<DspecialtyVO> dSpecialties = new ArrayList<DspecialtyVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(getAll_SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				DspecialtyVO dSpecialty = new DspecialtyVO();

				dSpecialty.setSpecialtyNo(rs.getInt("specialtyNo"));

				dSpecialty.setdNo(rs.getInt("dNo"));

				dSpecialties.add(dSpecialty);
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
		return dSpecialties;
	}

	@Override
	public List<DspecialtyVO> findByDno(int dNo) {

		Connection con = null;
		List<DspecialtyVO> dSpecialties = new ArrayList<DspecialtyVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByDno_SQL);
			pstmt.setInt(1, dNo);
			
			ResultSet rs = pstmt.executeQuery();

			

			while (rs.next()) {

				DspecialtyVO dSpecialty = new DspecialtyVO();

				dSpecialty.setSpecialtyNo(rs.getInt("specialtyNo"));

				dSpecialty.setdNo(rs.getInt("dNo"));

				dSpecialties.add(dSpecialty);
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
		return dSpecialties;
	}

	public static void main(String[] args) {

		DspecialtyDAO dao = new DspecialtyDAO();
		List<DspecialtyVO> dSpecialties = new ArrayList<DspecialtyVO>();
		
		dSpecialties= dao.findByDno(1);
		
		for(DspecialtyVO dSpecialty: dSpecialties) {
			
			System.out.println(dSpecialty.getSpecialtyNo());
		}
		
		DspecialtyVO Dspecialty1 = new DspecialtyVO(3, 5);
		dao.delete(Dspecialty1);
		
		
		
	}
}
