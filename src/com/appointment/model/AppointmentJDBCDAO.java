package com.appointment.model;

import java.util.*;
import java.sql.*;

public class AppointmentJDBCDAO implements AppointmentDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO APPOINTMENT (DNO,RDATE,RSTATE) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT APTNO,DNO,RDATE,RSTATE FROM APPOINTMENT ORDER BY APTNO";
	private static final String GET_ONE_STMT = "SELECT APTNO,DNO,RDATE,RSTATE FROM APPOINTMENT where aptno = ?";
	private static final String DELETE = "DELETE FROM APPOINTMENT where APTNO = ?";
	private static final String UPDATE = "UPDATE APPOINTMENT set DNO=?, RDATE=?, RSTATE=? WHERE APTNO = ?";
	
	@Override
	public void insert(AppointmentVO appointmentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, appointmentVO.getdNo());
			pstmt.setDate(2, appointmentVO.getrDate());
			pstmt.setString(3, appointmentVO.getrState());

			pstmt.executeUpdate();
		}catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch (SQLException se) {
			System.out.println(se.getMessage());
		}finally {
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
	public void update(AppointmentVO appointmentVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);
				
				pstmt.setInt(1, appointmentVO.getdNo());
				pstmt.setDate(2, appointmentVO.getrDate());
				pstmt.setString(3, appointmentVO.getrState());
				pstmt.setInt(4, appointmentVO.getAptNo());
				
				pstmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
	public void delete(Integer aptNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, aptNo);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public AppointmentVO findByPrimaryKey(Integer aptNo) {
		
		AppointmentVO appointmentVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, aptNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				appointmentVO = new AppointmentVO();
				appointmentVO.setAptNo(rs.getInt("aptNo"));
				appointmentVO.setdNo(rs.getInt("dNo"));
				appointmentVO.setrDate(rs.getDate("rDate"));
				appointmentVO.setrState(rs.getString("rState"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		
		return appointmentVO;
	}

	@Override
	public List<AppointmentVO> getAll() {
		List<AppointmentVO> list = new ArrayList<AppointmentVO>();
		AppointmentVO appointmentVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				appointmentVO = new AppointmentVO();
				appointmentVO.setAptNo(rs.getInt("aptNo"));
				appointmentVO.setdNo(rs.getInt("dNo"));
				appointmentVO.setrDate(rs.getDate("rDate"));
				appointmentVO.setrState(rs.getString("rState"));
				list.add(appointmentVO);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		AppointmentJDBCDAO dao = new AppointmentJDBCDAO();
		//新增
		AppointmentVO appointMent1 = new AppointmentVO();
		appointMent1.setdNo(7);;
		appointMent1.setrDate(java.sql.Date.valueOf("2005-01-01"));
		appointMent1.setrState("11111222223333333");
		dao.insert(appointMent1);
//		
		//修改
//		AppointmentVO appointMent2 = new AppointmentVO();
//		appointMent2.setAptNo(1);
//		appointMent2.setdNo(2);;
//		appointMent2.setrDate(java.sql.Date.valueOf("2022-01-01"));
//		appointMent2.setrState("222222222222");
//		dao.update(appointMent2);
		//刪除
//		dao.delete(2);
		//查詢一個
//		AppointmentVO appointMent3 = dao.findByPrimaryKey(1);
//		System.out.print(appointMent3.getAptNo() + ",");
//		System.out.print(appointMent3.getdNo() + ",");
//		System.out.print(appointMent3.getrDate() + ",");
//		System.out.println(appointMent3.getrState() + ",");
//		System.out.println("------------------");
		//查詢全部
		List<AppointmentVO> list = dao.getAll();
		for (AppointmentVO aapp : list) {
			System.out.print(aapp.getAptNo() + ",");
			System.out.print(aapp.getdNo() + ",");
			System.out.print(aapp.getrDate() + ",");
			System.out.println(aapp.getrState() + ",");
		}
		
	}



}
