package com.diary.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dietician.model.DieticianVO;

public class DiaryDAO implements DiaryDAO_interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	private static final String insert_SQL = "INSERT INTO diary VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String update_SQL = "UPDATE diary SET mno= ?, dno= ?, diaryDate= ?, ht=?, wt=?, bodyFat=?, wc=?, bodyPic=?, viewState=?, reply=?, totalCal=?, totalCho=?, totalPro=?, totalFat=?, totalCalBurn=? WHERE diaryNO = ?;";
	private static final String delete_SQL = "DELETE FROM diary WHERE diaryNo = ?;";
	private static final String findByMnoDate_SQL = "SELECT * FROM diary WHERE mno = ? AND diaryDate = ?;";
	private static final String findByMember_SQL = "SELECT * FROM diary WHERE mno = ?;";
	private static final String findByDieticianState_SQL = "SELECT * FROM diary WHERE dno = ? AND viewState= ?;";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(DiaryVO diary) {

		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);

			pstmt.setInt(1, diary.getMno());
			pstmt.setInt(2, diary.getDno());
			pstmt.setDate(3, diary.getDiaryDate());
			pstmt.setInt(4, diary.getHt());
			pstmt.setInt(5, diary.getWt());
			pstmt.setDouble(6, diary.getBodyFat());
			pstmt.setInt(7, diary.getWc());
			pstmt.setString(8, diary.getBodyPic());
			pstmt.setInt(9, diary.getViewState());
			pstmt.setString(10, diary.getReply());
			pstmt.setDouble(11, diary.getTotalCal());
			pstmt.setDouble(12, diary.getTotalCho());
			pstmt.setDouble(13, diary.getTotalPro());
			pstmt.setDouble(14, diary.getTotalFat());
			pstmt.setDouble(15, diary.getTotalCalBurn());

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
	public void update(DiaryVO diary) {

		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(update_SQL);
			
			pstmt.setInt(1, diary.getMno());
			pstmt.setInt(2, diary.getDno());
			pstmt.setDate(3, diary.getDiaryDate());
			pstmt.setInt(4, diary.getHt());
			pstmt.setInt(5, diary.getWt());
			pstmt.setDouble(6, diary.getBodyFat());
			pstmt.setInt(7, diary.getWc());
			pstmt.setString(8, diary.getBodyPic());
			pstmt.setInt(9, diary.getViewState());
			pstmt.setString(10, diary.getReply());
			pstmt.setDouble(11, diary.getTotalCal());
			pstmt.setDouble(12, diary.getTotalCho());
			pstmt.setDouble(13, diary.getTotalPro());
			pstmt.setDouble(14, diary.getTotalFat());
			pstmt.setDouble(15, diary.getTotalCalBurn());
			
			
			pstmt.setInt(16, diary.getDiaryNo());

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
	public void delete(DiaryVO diary) {
		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(delete_SQL);

			pstmt.setInt(1, diary.getDiaryNo());

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
	public DiaryVO findByDate(int mno, Date diaryDate) {

		Connection con = null;
		DiaryVO diary = new DiaryVO();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByMnoDate_SQL);
			pstmt.setInt(1, mno);
			pstmt.setDate(2, diaryDate);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				diary.setDiaryNo(rs.getInt("diaryNo"));
				diary.setMno(rs.getInt(mno));
				diary.setDno(rs.getInt("dno"));
				diary.setDiaryDate(rs.getDate(4)); // 用date還要轉成String
				diary.setHt(rs.getInt("ht"));
				diary.setWt(rs.getInt("wt"));
				diary.setBodyFat(rs.getDouble("bodyFat"));
				diary.setWc(rs.getInt("wc"));
				diary.setBodyPic(rs.getString("bodyPic"));
				diary.setViewState(rs.getInt("viewState"));
				diary.setReply(rs.getString("reply"));
				diary.setTotalCal(rs.getDouble("totalCal"));
				diary.setTotalCho(rs.getDouble("totalCho"));
				diary.setTotalPro(rs.getDouble("totalPro"));
				diary.setTotalFat(rs.getDouble("totalFat"));
				diary.setTotalCalBurn(rs.getDouble("totalCalBurn"));
;

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
		return diary;
	}

	@Override
	public List<DiaryVO> findByMember(int mno) {

		Connection con = null;
		List<DiaryVO> diaries = new ArrayList<DiaryVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByMember_SQL);
			pstmt.setInt(1, mno);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				DiaryVO diary = new DiaryVO();

				diary.setDiaryNo(rs.getInt("diaryNo"));
				diary.setMno(rs.getInt("mno"));
				diary.setDno(rs.getInt("dno"));
				diary.setDiaryDate(rs.getDate("diaryDate"));
				diary.setHt(rs.getInt("ht"));
				diary.setWt(rs.getInt("wt"));
				diary.setBodyFat(rs.getDouble("bodyFat"));
				diary.setWc(rs.getInt("wc"));
				diary.setBodyPic(rs.getString("bodyPic"));
				diary.setViewState(rs.getInt("viewState"));
				diary.setReply(rs.getString("reply"));
				diary.setTotalCal(rs.getDouble("totalCal"));
				diary.setTotalCho(rs.getDouble("totalCho"));
				diary.setTotalPro(rs.getDouble("totalPro"));
				diary.setTotalFat(rs.getDouble("totalFat"));
				diary.setTotalCalBurn(rs.getDouble("totalCalBurn"));
				
				diaries.add(diary);
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

		return diaries;

	}

	@Override
	public List<DiaryVO> findByDieticianState(int dno, int viewState) {

		Connection con = null;
		List<DiaryVO> diaries = new ArrayList<DiaryVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByDieticianState_SQL);
			pstmt.setInt(1, dno);
			pstmt.setInt(2, viewState);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				DiaryVO diary = new DiaryVO();

				diary.setDiaryNo(rs.getInt("diaryNo"));
				diary.setMno(rs.getInt("mno"));
				diary.setDno(rs.getInt("dno"));
				diary.setDiaryDate(rs.getDate("diaryDate"));
				diary.setHt(rs.getInt("ht"));
				diary.setWt(rs.getInt("wt"));
				diary.setBodyFat(rs.getDouble("bodyFat"));
				diary.setWc(rs.getInt("wc"));
				diary.setBodyPic(rs.getString("bodyPic"));
				diary.setViewState(rs.getInt("viewState"));
				diary.setReply(rs.getString("reply"));
				diary.setTotalCal(rs.getDouble("totalCal"));
				diary.setTotalCho(rs.getDouble("totalCho"));
				diary.setTotalPro(rs.getDouble("totalPro"));
				diary.setTotalFat(rs.getDouble("totalFat"));

				diaries.add(diary);
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

		return diaries;

	}

	public static void main(String[] args) {
		DiaryDAO dao = new DiaryDAO();
		
		String str="2021-02-04";
		Date day = Date.valueOf(str);
		
		DiaryVO diary1 = dao.findByDate(2, day);
		
		diary1.setTotalCalBurn(300.5);
		dao.update(diary1);
		
		System.out.println(diary1.getTotalCalBurn());
		
//		List<DiaryVO> diaries = dao.findByDieticianState(1, 1);
//		
//		
//		for(DiaryVO diary : diaries) {
//			System.out.println(diary.getReply());
//		}
		

		
		
		

	}

}
