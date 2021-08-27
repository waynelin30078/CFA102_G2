package com.member.model;

import java.util.*;
import java.sql.*;

public class MemberJDBCDAO implements MemberDAO_interface{
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String userid = "David";
	public static final String passwd = "123456";
	
	private static final String INSERT_STMT = "INSERT INTO MEMBER (mName ,mId ,mPsw ,mMail ,mPhone ,mImg ,mBday ,mSex ,mIntro ,mState ,cardID ,cardDate ,cardNum ,dNo ,dailyCal ,dailyCho ,dailyPro ,dailyFat ,dietPlan) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT mNo ,mName ,mId ,mPsw ,mMail ,mPhone ,mImg ,mBday ,mSex ,mIntro ,mState ,cardID ,cardDate ,cardNum ,dNo ,dailyCal ,dailyCho ,dailyPro ,dailyFat ,dietPlan FROM MEMBER ORDER BY mNo";
	private static final String GET_ONE_STMT = "SELECT mNo ,mName ,mId ,mPsw ,mMail ,mPhone ,mImg ,mBday ,mSex ,mIntro ,mState ,cardID ,cardDate ,cardNum ,dNo ,dailyCal ,dailyCho ,dailyPro ,dailyFat ,dietPlan FROM MEMBER where mNo = ?";
	private static final String UPDATE = "UPDATE MEMBER set mName=? ,mId=? ,mPsw=? ,mMail=? ,mPhone=? ,mImg=? ,mBday=? ,mSex=? ,mIntro=? ,mState=? ,cardID=? ,cardDate=? ,cardNum=? ,dNo=? ,dailyCal=? ,dailyCho=? ,dailyPro=? ,dailyFat=? ,dietPlan=? WHERE mNo = ?";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void insert(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, memberVO.getMname());
			pstmt.setString(2, memberVO.getMid());
			pstmt.setString(3, memberVO.getMpsw());
			pstmt.setString(4, memberVO.getMmail());
			pstmt.setString(5, memberVO.getMphone());
			pstmt.setString(6, memberVO.getMimg());
			pstmt.setDate(7, memberVO.getMbday());
			pstmt.setByte(8, memberVO.getMsex());
			pstmt.setString(9, memberVO.getMintro());
			pstmt.setByte(10, memberVO.getMstate());
			pstmt.setInt(11, memberVO.getCardID());
			pstmt.setInt(12, memberVO.getCardDate());
			pstmt.setInt(13, memberVO.getCardNum());
			pstmt.setInt(14, memberVO.getDno());
			pstmt.setInt(15, memberVO.getDailyCal());
			pstmt.setInt(16, memberVO.getDailyCho());
			pstmt.setInt(17, memberVO.getDailyPro());
			pstmt.setInt(18, memberVO.getDailyFat());
			pstmt.setString(19, memberVO.getDietPlan());
			
			pstmt.executeUpdate();
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		
	
		
	}
	@Override
	public void update(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, memberVO.getMname());
			pstmt.setString(2, memberVO.getMid());
			pstmt.setString(3, memberVO.getMpsw());
			pstmt.setString(4, memberVO.getMmail());
			pstmt.setString(5, memberVO.getMphone());
			pstmt.setString(6, memberVO.getMimg());
			pstmt.setDate(7, memberVO.getMbday());
			pstmt.setByte(8, memberVO.getMsex());
			pstmt.setString(9, memberVO.getMintro());
			pstmt.setByte(10, memberVO.getMstate());
			pstmt.setInt(11, memberVO.getCardID());
			pstmt.setInt(12, memberVO.getCardDate());
			pstmt.setInt(13, memberVO.getCardNum());
			pstmt.setInt(14, memberVO.getDno());
			pstmt.setInt(15, memberVO.getDailyCal());
			pstmt.setInt(16, memberVO.getDailyCho());
			pstmt.setInt(17, memberVO.getDailyPro());
			pstmt.setInt(18, memberVO.getDailyFat());
			pstmt.setString(19, memberVO.getDietPlan());
			pstmt.setInt(20, memberVO.getMno());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	@Override
	public MemberVO findByPrimaryKey(Integer mNo) {
		
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, mNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMno(rs.getInt("mno"));
				memberVO.setMname(rs.getString("mname"));
				memberVO.setMid(rs.getString("mid"));
				memberVO.setMpsw(rs.getString("mPsw"));
				memberVO.setMmail(rs.getString("mMail"));
				memberVO.setMphone(rs.getString("mPhone"));
				memberVO.setMimg(rs.getString("mImg"));
				memberVO.setMbday(rs.getDate("mbday"));
				memberVO.setMsex(rs.getByte("msex"));
				memberVO.setMintro(rs.getString("mintro"));
				memberVO.setMstate(rs.getByte("mState"));
				memberVO.setCardID(rs.getInt("CardID"));
				memberVO.setCardDate(rs.getInt("CardDate"));
				memberVO.setCardNum(rs.getInt("CardNum"));
				memberVO.setDno(rs.getInt("dNo"));
				memberVO.setDailyCal(rs.getInt("DailyCal"));
				memberVO.setDailyCho(rs.getInt("DailyCho"));
				memberVO.setDailyPro(rs.getInt("DailyPro"));
				memberVO.setDailyFat(rs.getInt("DailyFat"));
				memberVO.setDietPlan(rs.getString("dietplan"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberVO;
	}
	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMno(rs.getInt("mno"));
				memberVO.setMname(rs.getString("mname"));
				memberVO.setMid(rs.getString("mid"));
				memberVO.setMpsw(rs.getString("mPsw"));
				memberVO.setMmail(rs.getString("mMail"));
				memberVO.setMphone(rs.getString("mPhone"));
				memberVO.setMimg(rs.getString("mImg"));
				memberVO.setMbday(rs.getDate("mbday"));
				memberVO.setMsex(rs.getByte("msex"));
				memberVO.setMintro(rs.getString("mintro"));
				memberVO.setMstate(rs.getByte("mState"));
				memberVO.setCardID(rs.getInt("CardID"));
				memberVO.setCardDate(rs.getInt("CardDate"));
				memberVO.setCardNum(rs.getInt("CardNum"));
				memberVO.setDno(rs.getInt("dNo"));
				memberVO.setDailyCal(rs.getInt("DailyCal"));
				memberVO.setDailyCho(rs.getInt("DailyCho"));
				memberVO.setDailyPro(rs.getInt("DailyPro"));
				memberVO.setDailyFat(rs.getInt("DailyFat"));
				memberVO.setDietPlan(rs.getString("dietplan"));
				list.add(memberVO);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		return list;
	}
	public static void main(String[] args) {
		MemberJDBCDAO dao = new MemberJDBCDAO();
		//新增
		MemberVO memberVO1 = new MemberVO();
		memberVO1.setMname("老闆娘女兒2");
		memberVO1.setMid("1233232");
		memberVO1.setMpsw("1232");
		memberVO1.setMmail("12343322");
		memberVO1.setMphone("12333422");
		memberVO1.setMimg("12342");
		memberVO1.setMbday(java.sql.Date.valueOf("2005-01-01"));
		memberVO1.setMsex((byte)1); //
		memberVO1.setMintro("213");
		memberVO1.setMstate((byte)1); //
		memberVO1.setCardID(123);
		memberVO1.setCardDate(123);
		memberVO1.setCardNum(123);
		memberVO1.setDno(123);
		memberVO1.setDailyCal(123);
		memberVO1.setDailyCho(213);
		memberVO1.setDailyPro(123);
		memberVO1.setDailyFat(2132);
		memberVO1.setDietPlan("ㄚㄚㄚㄚ");
		dao.insert(memberVO1);
//		
		
		
		//修改
//		MemberVO memberVO2 = new MemberVO();
//		memberVO2.setMname("皮皮皮老闆");
//		memberVO2.setMid("123");
//		memberVO2.setMpsw("123");
//		memberVO2.setMmail("1234");
//		memberVO2.setMphone("1234");
//		memberVO2.setMimg("1234");
//		memberVO2.setMbday(java.sql.Date.valueOf("2005-01-01"));
//		memberVO2.setMsex((byte)1); //
//		memberVO2.setMintro("213");
//		memberVO2.setMstate((byte)1); //
//		memberVO2.setCardID(123);
//		memberVO2.setCardDate(123);
//		memberVO2.setCardNum(123);
//		memberVO2.setDno(123);
//		memberVO2.setDailyCal(123);
//		memberVO2.setDailyCho(213);
//		memberVO2.setDailyPro(123);
//		memberVO2.setDailyFat(2132);
//		memberVO2.setDietPlan("喔喔喔喔");
//		memberVO2.setMno(1);
//		dao.update(memberVO2);
		
		//查詢
//		MemberVO memberVO3 = dao.findByPrimaryKey(1);
//		System.out.println(memberVO3.getMno());
//		System.out.println(memberVO3.getMname());
//		System.out.println("==============");
		//查詢all
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO memb : list ) {
//			System.out.print(memb.getMno()+",");
//			System.out.print(memb.getMname());
//			System.out.println();
//		}
		
		
		
		
	}
}
