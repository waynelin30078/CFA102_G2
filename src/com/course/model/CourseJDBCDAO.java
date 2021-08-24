package com.course.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class CourseJDBCDAO implements CourseDAO_interface {
	private static final String INSERT = "INSERT INTO COURSE(cNo,dNo,cName,cPrice,cShelfDate,cIntroduction,cType,cPic,cDescription)VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE COURSE SET cName=? cPrice=? cIntroduction=? cPic=? cDescription=?";
	private static final String STATE = "UPDATE COURSE SET cState=? WHERE cNo=?";
	private static final String FIND_BY_CNO = "SELECT * FROM COURSE WHERE cNo=?";
	private static final String FIND_BY_DNO = "SELECT * FROM COURSE WHERE dNO=?";
	private static final String FIND_BY_CNAME = "SELECT * FORM COURSE WHERE cName LIKE'%?%'";
	private static final String FIND_BY_CTYPE = "SELECT * FORM COURSE WHERE cType=?";
//	private static final String FIND_BY_CTOTAL_SCORE="SELECT * FROM COURSE";
	private static final String GET_ALL = "SELCET * FROM COURSE";
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
		System.out.println(5);
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, courseVO.getcNo());
			pstmt.setInt(2, courseVO.getdNo());
			pstmt.setString(3, courseVO.getcName());
			pstmt.setInt(4, courseVO.getcPrice());
			pstmt.setDate(5, courseVO.getcShelfDate());
			pstmt.setString(6, courseVO.getcIntroduction());
			pstmt.setInt(7, courseVO.getcType());
			pstmt.setBytes(8, courseVO.getcPic());
			pstmt.setString(9, courseVO.getcDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();//錯誤
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
			pstmt.setString(1, courseVO.getcName());
			pstmt.setInt(2, courseVO.getcPrice());
			pstmt.setString(3, courseVO.getcIntroduction());
			pstmt.setBytes(4, courseVO.getcPic());
			pstmt.setString(5, courseVO.getcDescription());
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
	public void state(Integer cState, Integer cNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(STATE);
			pstmt.setInt(1, cState);
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
	public CourseVO findBy_cNO(Integer cNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CourseVO courseVO = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_CNO);
			pstmt.setInt(1, cNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				courseVO = new CourseVO();
				courseVO.setcNo(cNo);
				courseVO.setdNo(rs.getInt("dNo"));
				courseVO.setcName(rs.getString("cName"));
				courseVO.setcPrice(rs.getInt("cPrice"));
				courseVO.setcState(rs.getInt("cState"));
				courseVO.setcShelfDate(rs.getDate("cShelfDate"));
				courseVO.setcIntroduction(rs.getString("cIntroduction"));
				courseVO.setcType(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setcPic(rs.getBytes("cPic"));
				courseVO.setcDescription(rs.getString("cDescription"));
				courseVO.setcTotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setcTotalScore(rs.getInt("cTotalScore"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			} // TODO Auto-generated method stub

		}
		return courseVO;
	}

	@Override
	public List<CourseVO> findBy_dNo(Integer dNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CourseVO> courseList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DNO);
			pstmt.setInt(1, dNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CourseVO courseVO = new CourseVO();
				courseVO.setcNo(rs.getInt("cNo"));
				courseVO.setdNo(dNo);
				courseVO.setcName(rs.getString("cName"));
				courseVO.setcPrice(rs.getInt("cPrice"));
				courseVO.setcState(rs.getInt("cState"));
				courseVO.setcShelfDate(rs.getDate("cShelfDate"));
				courseVO.setcIntroduction(rs.getString("cIntroduction"));
				courseVO.setcType(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setcPic(rs.getBytes("cPic"));
				courseVO.setcDescription(rs.getString("cDescription"));
				courseVO.setcTotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setcTotalScore(rs.getInt("cTotalScore"));
				courseList.add(courseVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			} // TODO Auto-generated method stub

		}

		return courseList;
	}

	@Override
	public List<CourseVO> findBy_cName(String cName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CourseVO> courseList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_CNAME);
			pstmt.setString(1, cName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CourseVO courseVO = new CourseVO();
				courseVO.setcNo(rs.getInt("cNo"));
				courseVO.setdNo(rs.getInt("dNo"));
				courseVO.setcName(rs.getString("cName"));
				courseVO.setcPrice(rs.getInt("cPrice"));
				courseVO.setcState(rs.getInt("cState"));
				courseVO.setcShelfDate(rs.getDate("cShelfDate"));
				courseVO.setcIntroduction(rs.getString("cIntroduction"));
				courseVO.setcType(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setcPic(rs.getBytes("cPic"));
				courseVO.setcDescription(rs.getString("cDescription"));
				courseVO.setcTotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setcTotalScore(rs.getInt("cTotalScore"));
				courseList.add(courseVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			} // TODO Auto-generated method stub

		}

		return courseList;
	}

	@Override
	public List<CourseVO> findBy_cTotalScore(int Score) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CourseVO> courseList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CourseVO courseVO = new CourseVO();
				courseVO.setcNo(rs.getInt("cNo"));
				courseVO.setdNo(rs.getInt("dNo"));
				courseVO.setcName(rs.getString("cName"));
				courseVO.setcPrice(rs.getInt("cPrice"));
				courseVO.setcState(rs.getInt("cState"));
				courseVO.setcShelfDate(rs.getDate("cShelfDate"));
				courseVO.setcIntroduction(rs.getString("cIntroduction"));
				courseVO.setcType(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setcPic(rs.getBytes("cPic"));
				courseVO.setcDescription(rs.getString("cDescription"));
				courseVO.setcTotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setcTotalScore(rs.getInt("cTotalScore"));
				courseList.add(courseVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			} // TODO Auto-generated method stub

		}

		return courseList;
	}

	@Override
	public List<CourseVO> findBy_cType(Integer cType) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CourseVO> courseList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_CTYPE);
			pstmt.setInt(1, cType);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CourseVO courseVO = new CourseVO();
				courseVO.setcNo(rs.getInt("cNo"));
				courseVO.setdNo(rs.getInt("dNo"));
				courseVO.setcName(rs.getString("cName"));
				courseVO.setcPrice(rs.getInt("cPrice"));
				courseVO.setcState(rs.getInt("cState"));
				courseVO.setcShelfDate(rs.getDate("cShelfDate"));
				courseVO.setcIntroduction(rs.getString("cIntroduction"));
				courseVO.setcType(cType);
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setcPic(rs.getBytes("cPic"));
				courseVO.setcDescription(rs.getString("cDescription"));
				courseVO.setcTotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setcTotalScore(rs.getInt("cTotalScore"));
				courseList.add(courseVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			} // TODO Auto-generated method stub

		}

		return courseList;
	}

}
