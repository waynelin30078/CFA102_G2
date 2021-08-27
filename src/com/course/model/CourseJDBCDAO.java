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
	private static final String INSERT = "INSERT INTO COURSE(dNo,cName,cPrice,cShelfDate,cIntroduction,cType,cPic,cDescription)VALUES(?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE COURSE SET cName=?,cPrice=?,cIntroduction=?,cPic=?,cDescription=?WHERE cNo=?";
	private static final String STATE = "UPDATE COURSE SET cState=? WHERE cNo=?";
	private static final String FIND_BY_CNO = "SELECT * FROM COURSE WHERE cNo=?";
	private static final String FIND_BY_DNO = "SELECT * FROM COURSE WHERE dNO=?";
	private static final String FIND_BY_CNAME = "SELECT * FROM COURSE WHERE cName LIKE ? ORDER BY cNO";
	private static final String FIND_BY_CTYPE = "SELECT * FROM COURSE WHERE cType=?";
//	private static final String FIND_BY_CTOTAL_SCORE="SELECT * FROM COURSE";
	private static final String GET_ALL = "SELECT * FROM COURSE";//v
	
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
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {		
				e.printStackTrace();
			}
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, courseVO.getDno());
			pstmt.setString(2, courseVO.getCname());
			pstmt.setInt(3, courseVO.getCprice());
			pstmt.setDate(4, courseVO.getCshelfDate());
			pstmt.setString(5, courseVO.getCintroduction());
			pstmt.setInt(6, courseVO.getCtype());
			pstmt.setBytes(7, courseVO.getCpic());
			pstmt.setString(8, courseVO.getCdescription());
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
			pstmt.setString(1, courseVO.getCname());
			pstmt.setInt(2, courseVO.getCprice());
			pstmt.setString(3, courseVO.getCintroduction());
			pstmt.setBytes(4, courseVO.getCpic());
			pstmt.setString(5, courseVO.getCdescription());
			pstmt.setInt(6, courseVO.getCno());
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
	public void cState(Integer cState, Integer cNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(STATE);
			pstmt.setInt(1, cState);
			pstmt.setInt(2, cNo);
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
				courseVO.setCno(cNo);
				courseVO.setDno(rs.getInt("dNo"));
				courseVO.setCname(rs.getString("cName"));
				courseVO.setCprice(rs.getInt("cPrice"));
				courseVO.setCstate(rs.getInt("cState"));
				courseVO.setCshelfDate(rs.getDate("cShelfDate"));
				courseVO.setCintroduction(rs.getString("cIntroduction"));
				courseVO.setCtype(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setCpic(rs.getBytes("cPic"));
				courseVO.setCdescription(rs.getString("cDescription"));
				courseVO.setCtotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setCtotalScore(rs.getInt("cTotalScore"));
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
				courseVO.setCno(rs.getInt("cNo"));
				courseVO.setDno(dNo);
				courseVO.setCname(rs.getString("cName"));
				courseVO.setCprice(rs.getInt("cPrice"));
				courseVO.setCstate(rs.getInt("cState"));
				courseVO.setCshelfDate(rs.getDate("cShelfDate"));
				courseVO.setCintroduction(rs.getString("cIntroduction"));
				courseVO.setCtype(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setCpic(rs.getBytes("cPic"));
				courseVO.setCdescription(rs.getString("cDescription"));
				courseVO.setCtotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setCtotalScore(rs.getInt("cTotalScore"));
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
			pstmt.setString(1, "%"+cName+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CourseVO courseVO = new CourseVO();
				courseVO.setCno(rs.getInt("cNo"));
				courseVO.setDno(rs.getInt("dNo"));
				courseVO.setCname(rs.getString("cName"));
				courseVO.setCprice(rs.getInt("cPrice"));
				courseVO.setCstate(rs.getInt("cState"));
				courseVO.setCshelfDate(rs.getDate("cShelfDate"));
				courseVO.setCintroduction(rs.getString("cIntroduction"));
				courseVO.setCtype(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setCpic(rs.getBytes("cPic"));
				courseVO.setCdescription(rs.getString("cDescription"));
				courseVO.setCtotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setCtotalScore(rs.getInt("cTotalScore"));
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
				courseVO.setCno(rs.getInt("cNo"));
				courseVO.setDno(rs.getInt("dNo"));
				courseVO.setCname(rs.getString("cName"));
				courseVO.setCprice(rs.getInt("cPrice"));
				courseVO.setCstate(rs.getInt("cState"));
				courseVO.setCshelfDate(rs.getDate("cShelfDate"));
				courseVO.setCintroduction(rs.getString("cIntroduction"));
				courseVO.setCtype(rs.getInt("cType"));
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setCpic(rs.getBytes("cPic"));
				courseVO.setCdescription(rs.getString("cDescription"));
				courseVO.setCtotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setCtotalScore(rs.getInt("cTotalScore"));
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
				courseVO.setCno(rs.getInt("cNo"));
				courseVO.setDno(rs.getInt("dNo"));
				courseVO.setCname(rs.getString("cName"));
				courseVO.setCprice(rs.getInt("cPrice"));
				courseVO.setCstate(rs.getInt("cState"));
				courseVO.setCshelfDate(rs.getDate("cShelfDate"));
				courseVO.setCintroduction(rs.getString("cIntroduction"));
				courseVO.setCtype(cType);
				courseVO.setQuantity(rs.getInt("quantity"));
				courseVO.setCpic(rs.getBytes("cPic"));
				courseVO.setCdescription(rs.getString("cDescription"));
				courseVO.setCtotalPeople(rs.getInt("cTotalPeople"));
				courseVO.setCtotalScore(rs.getInt("cTotalScore"));
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
