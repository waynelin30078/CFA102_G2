package com.food_record.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class FoodRecordDAO implements FoodRecordDAO_interface{

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	private static final String insert_SQL = "INSERT INTO FoodRecord VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String update_SQL = "UPDATE FoodRecord diaryNo=?, fdNo=?, fdPortion=?, fdWt=?, singlelCal=?, singleCho=?, singlePro=?, singleFat=? WHERE diaryNo=?, fdNo=?;";
	private static final String delete_SQL = "DELETE FoodRecord WHERE diaryNo=? AND fdNo=?;";
	
	@Override
	public void insert(FoodRecordVO foodRecord) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);
			
			pstmt.setInt(1 ,foodRecord.getDiaryNo());
			pstmt.setInt(2 ,foodRecord.getFdNo());
			pstmt.setInt(3 ,foodRecord.getFdPortion());
			pstmt.setInt(4 ,foodRecord.getFdWt());
			pstmt.setDouble(5 ,foodRecord.getSinglelCal());
			pstmt.setDouble(6 ,foodRecord.getSingleCho());
			pstmt.setDouble(7 ,foodRecord.getSinglePro());
			pstmt.setDouble(8 ,foodRecord.getSingleFat());


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
	public void update(FoodRecordVO foodRecord) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(update_SQL);

			pstmt.setInt(1 ,foodRecord.getDiaryNo());
			pstmt.setInt(2 ,foodRecord.getFdNo());
			pstmt.setInt(3 ,foodRecord.getFdPortion());
			pstmt.setInt(4 ,foodRecord.getFdWt());
			pstmt.setDouble(5 ,foodRecord.getSinglelCal());
			pstmt.setDouble(6 ,foodRecord.getSingleCho());
			pstmt.setDouble(7 ,foodRecord.getSinglePro());
			pstmt.setDouble(8 ,foodRecord.getSingleFat());
			
			pstmt.setInt(9 ,foodRecord.getDiaryNo());
			pstmt.setInt(10 ,foodRecord.getFdNo());

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
	public void delete(FoodRecordVO foodRecord) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(delete_SQL);

			pstmt.setInt(1 ,foodRecord.getDiaryNo());
			pstmt.setInt(2 ,foodRecord.getFdNo());

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
