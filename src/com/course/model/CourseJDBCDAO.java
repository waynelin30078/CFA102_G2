package com.course.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import util.Util;

public class CourseJDBCDAO implements CourseDAO_interface {
	private static final String INSERT = "INSERT INTO COURSE(cNo,dNo,cName,cPrice,cShelfDate,cIntroduction,cType,cPic,cDescription)"
			+ "values(?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE COURSE SET cName=? cPrice=? cIntroduction=? cPic=? cDescription=?";
	private static final String STATE = "UPDATE COURSE SET cState=? WHERE cNo=?";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, courseVO.getcNo());
			pstmt.setInt(2, courseVO.getdNo());
			pstmt.setString(3, courseVO.getcName());
			pstmt.setInt(4, courseVO.getcPrice());
			pstmt.setTimestamp(5, courseVO.getcShelfDate());
			pstmt.setString(6, courseVO.getcIntroduction());
			pstmt.setInt(7, courseVO.getcType());
			pstmt.setBytes(8, courseVO.getcPic());
			pstmt.setString(9, courseVO.getcDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
	public void update(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1,courseVO.getcName());
			pstmt.setInt(2, courseVO.getcPrice());
			pstmt.setString(3,courseVO.getcIntroduction());
			pstmt.setBytes(4,courseVO.getcPic());
			pstmt.setString(5,courseVO.getcDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
	public void state(int cState,int cNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(STATE);
			pstmt.setInt(1,cState);
			pstmt.setInt(2, cNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
	public CourseVO findBy_cNO(int cNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseVO findBy_dNo(int dNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseVO findBy_cName(String cName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CourseVO findBy_cTotalScore(int Score) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
