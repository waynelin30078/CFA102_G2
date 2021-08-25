package com.material;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.video.model.VideoVO;

import util.Util;

public class MaterialJDBCDAO implements MaterialDAO_interface {
	private static final String INSERT = "INSERT INTO MATERIAL(matNo,cNo,matFile,matUpdateTime)VALUES(null,?,?,Now())";
	private static final String UPDATE_MATERIAL="UPDATE MATERAL SET matFile=?, matUpdateTime=Now WHERE matNO=?";
	private static final String DELETE_MATERIAL = "UPDATE MATERAL SET matFile='', matUpDateTime=Now()WHERE matNo=?";
	private static final String GET_ONE_BY_MATNO = "SELECT * FROM MATERIAL WHERE matNO=?";
	private static final String GET_ALL = "SELECT * FROM MATERIAL";
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	@Override
	public void insert(MaterialVO mat) {
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
			pstmt.setInt(1, mat.getcNo());
			pstmt.setString(2, mat.getMatFile());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();// 錯誤
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
	public void update(MaterialVO mat) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_MATERIAL);

			pstmt.setString(1, mat.getMatFile());
			pstmt.setInt(2, mat.getcNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
	public void delete(Integer matNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			try {
				Class.forName(Util.DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_MATERIAL);
			pstmt.setInt(1, matNo);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public MaterialVO getOne(Integer matNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MaterialVO matVO = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_BY_MATNO);
			pstmt.setInt(1, matNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				matVO = new MaterialVO();
				matVO.setMatNo(matNo);
				matVO.setcNo(rs.getInt("cNo"));
				matVO.setMatFile(rs.getString("matFile"));
				matVO.setMatUpdateTime(rs.getTimestamp("matUpdateTime"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return matVO;
	}

	@Override
	public List<MaterialVO> gelAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MaterialVO> matList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MaterialVO matVO = new MaterialVO();
				matVO.setMatNo(rs.getInt("vNo"));
				matVO.setcNo(rs.getInt("cNo"));
				matVO.setMatFile(rs.getString("vFile"));
				matVO.setMatUpdateTime(rs.getTimestamp("vUpdateTime"));
	
				matList.add(matVO);
			}

		} catch (SQLException e) {
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

		return matList;
	}
}
