package com.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminJDBCDAO implements AdminDAO_interface{

	 String driver="com.mysql.cj.jdbc.Driver";
	 String url="jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	 String user="David";
	 String password="123456";
	
	private static final String insert =
			"INSERT INTO ADMIN (aName,aId,aPsw)VALUES(?,?,?)";
	private static final String update =
			"UPDATE ADMIN set aName=?, aId=?, aPsw=? where aNo=?";
	
	
	@Override
	public void insert(AdminVO adminVO ) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			pstmt=con.prepareStatement(insert);
			
			pstmt.setString(1,adminVO.getaName());
			pstmt.setString(2,adminVO.getaId());
			pstmt.setString(3,adminVO.getaPsw());
			pstmt.executeUpdate();
			System.out.println("新增成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con !=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void update(AdminVO adminVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			pstmt=con.prepareStatement(update);
			
			pstmt.setString(1,adminVO.getaName());
			pstmt.setString(2,adminVO.getaId());
			pstmt.setString(3,adminVO.getaPsw());
			pstmt.setInt(4,adminVO.getaNo());
			pstmt.executeUpdate();
			System.out.println("修改成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con !=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void delete() {
		
	}

	@Override
	public AdminVO findByPrimaryKey() {
		return null;
	}

	@Override
	public List<AdminVO> getAll() {
		return null;
	}
	
 public static void main(String[] args) {
	 AdminJDBCDAO dao =new AdminJDBCDAO();
	 
//	 AdminVO adminVO1 =new AdminVO();
//	 adminVO1.setaName("eeefe");
//	 adminVO1.setaId("hgeehh");
//	 adminVO1.setaPsw("kkeekk");
//	 dao.insert(adminVO1);
	 
	 
	 AdminVO adminVO2=new AdminVO(); 
	 adminVO2.setaName("offfo");
	 adminVO2.setaId("ppffp");
	 adminVO2.setaPsw("lffll");
	 adminVO2.setaNo(2);
	 dao.update(adminVO2);
 }
}






/*package com.admin_info.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.authority.model.*;


public class AdmiDAO implements AdmiDAO_interface {
	
	private static final String INSERT =
			"INSERT INTO ADMIN_INFO ( ADM_NAME, ADM_ACCOUNT, ADM_PASSWORD )VALUES( ?, ?, ? )";
	private static final String UPDATE =
			"UPDATE ADMIN_INFO set ADM_NAME=?, ADM_ACCOUNT=?, ADM_PASSWORD=? where ADM_ID=?";
	private static final String DELETE =
			"UPDATE ADMIN_INFO set  ADM_ACCOUNT =null, ADM_PASSWORD =null, ADM_STATUS =FALSE where ADM_ID=?";
	private static final String BACK =
			"UPDATE ADMIN_INFO set ADM_STATUS=TRUE where ADM_ID=?";
	private static final String GET_ONE_BYID =
			"SELECT * FROM ADMIN_INFO where ADM_ID=?";
	private static final String GET_ONE_BYACCOUNT=
			"SELECT * FROM ADMIN_INFO where ADM_ACCOUNT=?";
	private static final String GET_ALL =
			"SELECT * FROM ADMIN_INFO order by ADM_ID";
	
	
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myproject");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	//新增管理員的同時也要一併新增權限(等同交易要全部成功否則就要rollback)
	public AdmiVO insert(AdmiVO admiVO,Integer[] funID) {
		
		Connection con=null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			con.setAutoCommit(false);//關閉autocommit讓第二個指令可以繼續
			
			//取得自增主鍵
			String[] cols= {"ADM_ID"};
			pstmt = con.prepareStatement(INSERT,cols);
			
			//第一個指令:新增管理員
			pstmt.setString(1,admiVO.getAdmName());
			pstmt.setString(2,admiVO.getAdmAccount());
			pstmt.setString(3,admiVO.getAdmPassword());
						
			pstmt.executeUpdate();
			
			//取得自增主鍵
			ResultSet rs = pstmt.getGeneratedKeys();
			Integer key = null;//宣告
			
			if(rs.next()) {
				key = new Integer(rs.getString(1));//取值 // 1:是因為每次只新增一個主鍵(?
			}
			
			//第二個指令:新增權限
			for(int i=0 ;i<funID.length ;i++) {
				
				AutDAO autDAO = new AutDAO();
				AutVO autVO = new AutVO();
				autVO.setAdmID(key);//使用
				autVO.setFunID(funID[i]);
				autDAO.insert(autVO,con);
				
			}
			
			con.commit();
			con.setAutoCommit(true);//改回autocommit
			
		}catch (SQLException se) {
			if (con != null) {
				try {
					con.rollback();//
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "+excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "+se.getMessage());
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
		return admiVO;
				
	}

	@Override
	public void update(AdmiVO admiVO ,Integer[] funID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, admiVO.getAdmName());
			pstmt.setString(2, admiVO.getAdmAccount());
			pstmt.setString(3, admiVO.getAdmPassword());
			pstmt.setInt(4, admiVO.getAdmID());
			pstmt.executeUpdate();
			
			
			AutDAO autDAO = new AutDAO();
			Integer admID = new Integer(admiVO.getAdmID());
			autDAO.delete(admID);
			
			for(int i=0 ;i<funID.length ;i++) {
			AutVO autVO = new AutVO();
				
			autVO.setAdmID(admID);
			autVO.setFunID(funID[i]);
			autDAO.insert(autVO,con);
			
				
			}
			con.commit();
			con.setAutoCommit(true);
			
		} catch (SQLException se) {
			if (con != null) {
				try {
					con.rollback();//
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "+excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "+se.getMessage());
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
	public void delete(Integer admID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, admID);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void back(Integer amdID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BACK);
			pstmt.setInt(1, amdID);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public AdmiVO findByPrimaryKey(Integer admID) {
		AdmiVO admiVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = ds.getConnection();
			pstmt =con.prepareStatement(GET_ONE_BYID);
			
			pstmt.setInt(1, admID);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				admiVO = new AdmiVO();
				admiVO.setAdmID(rs.getInt("ADM_ID"));
				admiVO.setAdmName(rs.getString("ADM_NAME"));
				admiVO.setAdmAccount(rs.getString("ADM_ACCOUNT"));
				admiVO.setAdmPassword(rs.getString("ADM_PASSWORD"));
				admiVO.setAdmStatus(rs.getBoolean("ADM_STATUS"));
				admiVO.setAdmTime(rs.getTimestamp("ADM_TIME"));
			}
			
			
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured."+se.getMessage());
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					// TODO Auto-generated catch block
					se.printStackTrace(System.err);
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}			
		}
		
		return admiVO;
	}

	@Override
	public List<AdmiVO> getAll() {
		List<AdmiVO> list =new ArrayList<AdmiVO>();
		AdmiVO admiVO =null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con =ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				admiVO =new AdmiVO();
				admiVO.setAdmID(rs.getInt("ADM_ID"));
				admiVO.setAdmName(rs.getString("ADM_NAME"));
				admiVO.setAdmAccount(rs.getString("ADM_ACCOUNT"));
				admiVO.setAdmPassword(rs.getString("ADM_PASSWORD"));
				admiVO.setAdmStatus(rs.getBoolean("ADM_STATUS"));
				admiVO.setAdmTime(rs.getTimestamp("ADM_TIME"));
				
				list.add(admiVO);
			}
			
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured."+se.getMessage());
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					// TODO Auto-generated catch block
					se.printStackTrace(System.err);
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}			
		}
		return list;
	}

	@Override
	public AdmiVO findByAccount(String admAccount) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdmiVO admiVO = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_BYACCOUNT);
			pstmt.setString(1, admAccount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admiVO = new AdmiVO();
				admiVO.setAdmID(rs.getInt("ADM_ID"));
				admiVO.setAdmName(rs.getString("ADM_name"));
				admiVO.setAdmAccount(rs.getString("ADM_ACCOUNT"));
				admiVO.setAdmPassword(rs.getString("ADM_PASSWORD"));
				admiVO.setAdmStatus(rs.getBoolean("ADM_STATUS"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return admiVO;
	}




}
*/