package com.activity_record.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityRecordDAO implements ActivityRecordDAO_interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	private static final String insert_SQL = "INSERT INTO act_record VALUES(?, ?, ?, ?, ?)";
	private static final String delete_SQL = "DELETE act_record WHERE diaryNo=? AND actNo=?;";
	private static final String findByPrimaryKey_SQL = "SELECT * FROM act_record WHERE diaryNo=? AND actNo = ?;";
	private static final String findByDiaryNo_SQL = "SELECT * FROM act_record WHERE diaryNo=?;";

	@Override
	public void insert(ActivityRecordVO actRecord) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);

			pstmt.setInt(1, actRecord.getDiaryNo());
			pstmt.setInt(2, actRecord.getActNo());
			pstmt.setDouble(3, actRecord.getActHr());
			pstmt.setInt(4, actRecord.getWt());
			pstmt.setDouble(5, actRecord.getCalBurn());

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
	public void delete(ActivityRecordVO actRecord) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(delete_SQL);

			pstmt.setInt(1, actRecord.getDiaryNo());
			pstmt.setInt(2, actRecord.getActNo());

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
	public ActivityRecordVO findByPrimaryKey(int diaryNo, int actNo) {

		Connection con = null;
		ActivityRecordVO actRecord = new ActivityRecordVO();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByPrimaryKey_SQL);

			pstmt.setInt(1, diaryNo);
			pstmt.setInt(1, actNo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				actRecord.setDiaryNo(rs.getInt("diaryNo"));
				actRecord.setActNo(rs.getInt("actNo"));
				actRecord.setActHr(rs.getDouble("actHr"));
				actRecord.setWt(rs.getInt("wt"));
				actRecord.setCalBurn(rs.getDouble("calBurn"));

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

		return actRecord;
	}

	@Override
	public List<ActivityRecordVO> findByDiaryNo(int diaryNo) {

		Connection con = null;
		List<ActivityRecordVO> actRecords = new ArrayList<ActivityRecordVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByDiaryNo_SQL);

			pstmt.setInt(1, diaryNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ActivityRecordVO actRecord = new ActivityRecordVO();

				actRecord.setDiaryNo(rs.getInt("diaryNo"));
				actRecord.setActNo(rs.getInt("actNo"));
				actRecord.setActHr(rs.getDouble("actHr"));
				actRecord.setWt(rs.getInt("wt"));
				actRecord.setCalBurn(rs.getDouble("calBurn"));

				actRecords.add(actRecord);

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

		return actRecords;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
