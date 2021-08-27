package com.dietician.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class DieticianDAO implements DieticianDAO_interface {
	
	

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	private static final String insert_SQL = "INSERT INTO dietician VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String update_SQL = "UPDATE dietician "
			+ " SET dname = ?, daccount = ?, dpassword = ?, dbirthDay = ?, dpic = ?, dphone = ?, daddress = ?, demail = ?, edu = ?, exp = ?, lic = ?, prof = ?, clPrice = ?, mprice = ?, intro = ?, dstate = ?, totalScore = ?, totalReviewer = ?, donState = ?, offDay = ?, optTime = ? "
			+ "WHERE dNo = ?";

	private static final String findByPrimaryKey_SQL = "SELECT * FROM dietician WHERE dno = ?";

	private static final String getAll_SQL = "SELECT * FROM dietician";

	private static final String findByScore_SQL = "SELECT * FROM dietician WHERE totalScore/totalReviewer >= ?";

	private static final String findBySubscibeFee_SQL = "SELECT * FROM dietician WHERE mprice >= ? AND mprice <= ?";

	private static final String findByDieticianState_SQL = "SELECT * FROM dietician WHERE dstate = ?";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(DieticianVO dietician) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);
			
			
			pstmt.setString(1, dietician.getDname());
			pstmt.setString(2, dietician.getDaccount());
			pstmt.setString(3, dietician.getDpassword());
			pstmt.setDate(4, dietician.getDbirthDay());
			pstmt.setString(5, dietician.getDpic());
			pstmt.setString(6, dietician.getDphone());
			pstmt.setString(7, dietician.getDaddress());
			pstmt.setString(8, dietician.getDemail());
			pstmt.setString(9, dietician.getEdu());
			pstmt.setString(10, dietician.getExp());
			pstmt.setString(11, dietician.getLic());
			pstmt.setString(12, dietician.getProf());
			pstmt.setInt(13, dietician.getClPrice());
			pstmt.setInt(14, dietician.getMprice());
			pstmt.setString(15, dietician.getIntro());
			pstmt.setInt(16, dietician.getDstate());
			pstmt.setInt(17, dietician.getTotalScore());
			pstmt.setInt(18, dietician.getTotalReviewer());
			pstmt.setInt(19, dietician.getDonState());
			pstmt.setString(20, dietician.getOffDay());
			pstmt.setString(21, dietician.getOptTime());
			
			pstmt.executeUpdate();
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con !=null) {
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
	public void update(DieticianVO dietician) {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(update_SQL);
			
			pstmt.setString(1, dietician.getDname());
			pstmt.setString(2, dietician.getDaccount());
			pstmt.setString(3, dietician.getDpassword());
			pstmt.setDate(4, dietician.getDbirthDay());
			pstmt.setString(5, dietician.getDpic());
			pstmt.setString(6, dietician.getDphone());
			pstmt.setString(7, dietician.getDaddress());
			pstmt.setString(8, dietician.getDemail());
			pstmt.setString(9, dietician.getEdu());
			pstmt.setString(10, dietician.getExp());
			pstmt.setString(11, dietician.getLic());
			pstmt.setString(12, dietician.getProf());
			pstmt.setInt(13, dietician.getClPrice());
			pstmt.setInt(14, dietician.getMprice());
			pstmt.setString(15, dietician.getIntro());
			pstmt.setInt(16, dietician.getDstate());
			pstmt.setInt(17, dietician.getTotalScore());
			pstmt.setInt(18, dietician.getTotalReviewer());
			pstmt.setInt(19, dietician.getDonState());
			pstmt.setString(20, dietician.getOffDay());
			pstmt.setString(21, dietician.getOptTime());
			pstmt.setInt(22, dietician.getDno());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con !=null) {
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
	public DieticianVO findByPrimaryKey(int dno) {
		Connection con = null;
		DieticianVO dietician = new DieticianVO();
		

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByPrimaryKey_SQL);
			pstmt.setInt(1, dno);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dietician.setDno(dno);
				dietician.setDname(rs.getString("dname"));
				dietician.setDaccount(rs.getString("daccount"));
				dietician.setDpassword(rs.getString("dpassword"));
				dietician.setDbirthDay(rs.getDate("dbirthDay"));
				dietician.setDpic(rs.getString("dpic"));
				dietician.setDphone(rs.getString("dphone"));
				dietician.setDaddress(rs.getString("daddress"));
				dietician.setDemail(rs.getString("demail"));
				dietician.setEdu(rs.getString("edu"));
				dietician.setExp(rs.getString("exp"));
				dietician.setLic(rs.getString("lic"));
				dietician.setProf(rs.getString("prof"));
				dietician.setClPrice(rs.getInt("clPrice"));
				dietician.setMprice(rs.getInt("mprice"));
				dietician.setIntro(rs.getString("intro"));
				dietician.setDstate(rs.getInt("dstate"));
				dietician.setTotalScore(rs.getInt("totalScore"));
				dietician.setTotalReviewer(rs.getInt("totalReviewer"));
				dietician.setDonState(rs.getInt("donState"));
				dietician.setOffDay(rs.getString("offDay"));
				dietician.setOptTime(rs.getString("optTime"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

		
		return dietician;
	}

	@Override
	public List<DieticianVO> getAll() {
		Connection con = null;
		List<DieticianVO> dieticians = new ArrayList<DieticianVO>();
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(getAll_SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DieticianVO dietician = new DieticianVO();
				dietician.setDno(rs.getInt("dno"));
				dietician.setDname(rs.getString("dname"));
				dietician.setDaccount(rs.getString("daccount"));
				dietician.setDpassword(rs.getString("dpassword"));
				dietician.setDbirthDay(rs.getDate("dbirthDay"));
				dietician.setDpic(rs.getString("dpic"));
				dietician.setDphone(rs.getString("dphone"));
				dietician.setDaddress(rs.getString("daddress"));
				dietician.setDemail(rs.getString("demail"));
				dietician.setEdu(rs.getString("edu"));
				dietician.setExp(rs.getString("exp"));
				dietician.setLic(rs.getString("lic"));
				dietician.setProf(rs.getString("prof"));
				dietician.setClPrice(rs.getInt("clPrice"));
				dietician.setMprice(rs.getInt("mprice"));
				dietician.setIntro(rs.getString("intro"));
				dietician.setDstate(rs.getInt("dstate"));
				dietician.setTotalScore(rs.getInt("totalScore"));
				dietician.setTotalReviewer(rs.getInt("totalReviewer"));
				dietician.setDonState(rs.getInt("donState"));
				dietician.setOffDay(rs.getString("offDay"));
				dietician.setOptTime(rs.getString("optTime"));
				
				dieticians.add(dietician);
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return dieticians;
	}

	@Override
	public List<DieticianVO> findByScore(double avgScore) {
		Connection con = null;
		List<DieticianVO> dieticians = new ArrayList<DieticianVO>();
		
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByScore_SQL);
			
			pstmt.setDouble(1, avgScore);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DieticianVO dietician = new DieticianVO();
				dietician.setDno(rs.getInt("dno"));
				dietician.setDname(rs.getString("dname"));
				dietician.setDaccount(rs.getString("daccount"));
				dietician.setDpassword(rs.getString("dpassword"));
				dietician.setDbirthDay(rs.getDate("dbirthDay"));
				dietician.setDpic(rs.getString("dpic"));
				dietician.setDphone(rs.getString("dphone"));
				dietician.setDaddress(rs.getString("daddress"));
				dietician.setDemail(rs.getString("demail"));
				dietician.setEdu(rs.getString("edu"));
				dietician.setExp(rs.getString("exp"));
				dietician.setLic(rs.getString("lic"));
				dietician.setProf(rs.getString("prof"));
				dietician.setClPrice(rs.getInt("clPrice"));
				dietician.setMprice(rs.getInt("mprice"));
				dietician.setIntro(rs.getString("intro"));
				dietician.setDstate(rs.getInt("dstate"));
				dietician.setTotalScore(rs.getInt("totalScore"));
				dietician.setTotalReviewer(rs.getInt("totalReviewer"));
				dietician.setDonState(rs.getInt("donState"));
				dietician.setOffDay(rs.getString("offDay"));
				dietician.setOptTime(rs.getString("optTime"));
				
				dieticians.add(dietician);
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return dieticians;
		

	}

	@Override
	public List<DieticianVO> findBySubscribeFee(int minPrice, int maxPrice) {
		Connection con = null;
		List<DieticianVO> dieticians = new ArrayList<DieticianVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findBySubscibeFee_SQL);
			
			pstmt.setInt(1, minPrice);
			pstmt.setInt(2, maxPrice);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DieticianVO dietician = new DieticianVO();
				dietician.setDno(rs.getInt("dno"));
				dietician.setDname(rs.getString("dname"));
				dietician.setDaccount(rs.getString("daccount"));
				dietician.setDpassword(rs.getString("dpassword"));
				dietician.setDbirthDay(rs.getDate("dbirthDay"));
				dietician.setDpic(rs.getString("dpic"));
				dietician.setDphone(rs.getString("dphone"));
				dietician.setDaddress(rs.getString("daddress"));
				dietician.setDemail(rs.getString("demail"));
				dietician.setEdu(rs.getString("edu"));
				dietician.setExp(rs.getString("exp"));
				dietician.setLic(rs.getString("lic"));
				dietician.setProf(rs.getString("prof"));
				dietician.setClPrice(rs.getInt("clPrice"));
				dietician.setMprice(rs.getInt("mprice"));
				dietician.setIntro(rs.getString("intro"));
				dietician.setDstate(rs.getInt("dstate"));
				dietician.setTotalScore(rs.getInt("totalScore"));
				dietician.setTotalReviewer(rs.getInt("totalReviewer"));
				dietician.setDonState(rs.getInt("donState"));
				dietician.setOffDay(rs.getString("offDay"));
				dietician.setOptTime(rs.getString("optTime"));
				
				dieticians.add(dietician);
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return dieticians;
	}

	@Override
	public List<DieticianVO> findByDieticianState(int dstate) {
		Connection con = null;
		List<DieticianVO> dieticians = new ArrayList<DieticianVO>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByDieticianState_SQL);
			
			pstmt.setInt(1, dstate);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DieticianVO dietician = new DieticianVO();
				dietician.setDno(rs.getInt("dno"));
				dietician.setDname(rs.getString("dname"));
				dietician.setDaccount(rs.getString("daccount"));
				dietician.setDpassword(rs.getString("dpassword"));
				dietician.setDbirthDay(rs.getDate("dbirthDay"));
				dietician.setDpic(rs.getString("dpic"));
				dietician.setDphone(rs.getString("dphone"));
				dietician.setDaddress(rs.getString("daddress"));
				dietician.setDemail(rs.getString("demail"));
				dietician.setEdu(rs.getString("edu"));
				dietician.setExp(rs.getString("exp"));
				dietician.setLic(rs.getString("lic"));
				dietician.setProf(rs.getString("prof"));
				dietician.setClPrice(rs.getInt("clPrice"));
				dietician.setMprice(rs.getInt("mprice"));
				dietician.setIntro(rs.getString("intro"));
				dietician.setDstate(rs.getInt("dstate"));
				dietician.setTotalScore(rs.getInt("totalScore"));
				dietician.setTotalReviewer(rs.getInt("totalReviewer"));
				dietician.setDonState(rs.getInt("donState"));
				dietician.setOffDay(rs.getString("offDay"));
				dietician.setOptTime(rs.getString("optTime"));
				
				dieticians.add(dietician);
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return dieticians;
		
	}

	public static void main(String[] args) {

		DieticianDAO dao = new DieticianDAO();
		List<DieticianVO> dieticians = dao.findByDieticianState(1);
		
		
		for(DieticianVO dietician : dieticians) {
			System.out.println(dietician.getDname());
		}
		
		
		
	}

}
