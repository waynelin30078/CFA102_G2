package com.product.model;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> COURSE
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

<<<<<<< HEAD
public class ProductDAO implements ProductDAO_interface {

	private static DataSource ds = null;

=======
public class ProductDAO {

	// �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
	private static DataSource ds = null;
>>>>>>> COURSE
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/David");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

<<<<<<< HEAD
	// 新增商品
	private static final String INSERT_STMT = "INSERT INTO product (pNo, categoryName, pName, pPrice, pInfo, pQuantity, pOnDate, pOffDate, pImage1, pImage2, pImage3,"
			+ "pRatingsQuantity, pTotalRatings, pState) VALUES (null, ?, ?, ?, ?, ?, now(), default, ?, ?, ?, ?, ?, default)";
	// 更新商品資訊
	private static final String UPDATE = "UPDATE product SET categoryName=?, pName=?, pPrice=?, pInfo=?, pQuantity=?, pOnDate=?, pOffDate=?, pImage1=?, pImage2=?, pImage3=?,"
			+ " pState=? WHERE pNo =?";
	// 刪除商品
	private static final String DELETE = "DELETE FROM product WHERE pNo =?";
	// 查詢商品(用商品編號)
	private static final String GET_ONE_STMT = "SELECT pNo, categoryName, pName, pPrice, pInfo, pQuantity, pOnDate, pOffDate, pImage1, pImage2, pImage3,"
			+ " pRatingsQuantity, pTotalRatings, pState FROM product WHERE pNo =?";
	// 查詢商品(用商品名稱)
	private static final String GET_ALL_BY_PNAME = "SELECT * FROM product WHERE pName LIKE ? ORDER BY pNo";
	// 查詢商品(用商品類別)
	private static final String GET_ALL_BY_CATEGORYNAME = "SELECT * FROM promotion WHERE categoryName LIKE ? ORDER BY pNo";
	// 查詢所有商品
	private static final String GET_ALL_STMT = "SELECT pNo, categoryName, pName, pPrice, pInfo, pQuantity, pOnDate, pOffDate, pImage1, pImage2, pImage3,"
			+ " pRatingsQuantity, pTotalRatings, pState FROM product ORDER BY pNo";	

	@Override
	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, productVO.getCategoryName());
			pstmt.setString(2, productVO.getpName());
			pstmt.setInt(3, productVO.getpPrice());
			pstmt.setString(4, productVO.getpInfo());
			pstmt.setInt(5, productVO.getpQuantity());
			pstmt.setString(6, productVO.getpImage1());
			pstmt.setString(7, productVO.getpImage2());
			pstmt.setString(8, productVO.getpImage3());
			pstmt.setInt(9, productVO.getpRatingsQuantity());
			pstmt.setInt(10, productVO.getpTotalRatings());		

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, productVO.getCategoryName());
			pstmt.setString(2, productVO.getpName());
			pstmt.setInt(3, productVO.getpPrice());
			pstmt.setString(4, productVO.getpInfo());
			pstmt.setInt(5, productVO.getpQuantity());
			pstmt.setTimestamp(6, productVO.getpOnDate());
			pstmt.setTimestamp(7, productVO.getpOffDate());
			pstmt.setString(8, productVO.getpImage1());
			pstmt.setString(9, productVO.getpImage2());
			pstmt.setString(10, productVO.getpImage3());
			pstmt.setInt(11, productVO.getpState());
			pstmt.setInt(12, productVO.getpNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
	public void delete(Integer pNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, pNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
	public ProductVO findByPrimaryKey(Integer pNo) {

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, pNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				productVO = new ProductVO();
				productVO.setpNo(rs.getInt("pNo"));
				productVO.setCategoryName(rs.getString("categoryName"));
				productVO.setpName(rs.getString("pName"));
				productVO.setpPrice(rs.getInt("pPrice"));
				productVO.setpInfo(rs.getString("pInfo"));
				productVO.setpQuantity(rs.getInt("pQuantity"));
				productVO.setpOnDate(rs.getTimestamp("pOnDate"));
				productVO.setpOffDate(rs.getTimestamp("pOffDate"));
				productVO.setpImage1(rs.getString("pImage1"));
				productVO.setpImage2(rs.getString("pImage2"));
				productVO.setpImage3(rs.getString("pImage3"));
				productVO.setpRatingsQuantity(rs.getInt("pRatingsQuantity"));
				productVO.setpTotalRatings(rs.getInt("pTotalRatings"));
				productVO.setpState(rs.getInt("pState"));

			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
		return productVO;
	}

	@Override
	public List<ProductVO> getAll_bypName(String pName) {

		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_BY_PNAME);
			pstmt.setString(1, "%" + pName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				productVO = new ProductVO();
				productVO.setpNo(rs.getInt("pNo"));
				productVO.setCategoryName(rs.getString("categoryName"));
				productVO.setpName(rs.getString("pName"));
				productVO.setpPrice(rs.getInt("pPrice"));
				productVO.setpInfo(rs.getString("pInfo"));
				productVO.setpQuantity(rs.getInt("pQuantity"));
				productVO.setpOnDate(rs.getTimestamp("pOnDate"));
				productVO.setpOffDate(rs.getTimestamp("pOffDate"));
				productVO.setpImage1(rs.getString("pImage1"));
				productVO.setpImage2(rs.getString("pImage2"));
				productVO.setpImage3(rs.getString("pImage3"));
				productVO.setpRatingsQuantity(rs.getInt("pRatingsQuantity"));
				productVO.setpTotalRatings(rs.getInt("pTotalRatings"));
				productVO.setpState(rs.getInt("pState"));
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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

	@Override
	public List<ProductVO> getAll_byCategoryName(String categoryName) {

		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_BY_CATEGORYNAME);
			pstmt.setString(1, "%" + categoryName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				productVO = new ProductVO();
				productVO.setpNo(rs.getInt("pNo"));
				productVO.setCategoryName(rs.getString("categoryName"));
				productVO.setpName(rs.getString("pName"));
				productVO.setpPrice(rs.getInt("pPrice"));
				productVO.setpInfo(rs.getString("pInfo"));
				productVO.setpQuantity(rs.getInt("pQuantity"));
				productVO.setpOnDate(rs.getTimestamp("pOnDate"));
				productVO.setpOffDate(rs.getTimestamp("pOffDate"));
				productVO.setpImage1(rs.getString("pImage1"));
				productVO.setpImage2(rs.getString("pImage2"));
				productVO.setpImage3(rs.getString("pImage3"));
				productVO.setpRatingsQuantity(rs.getInt("pRatingsQuantity"));
				productVO.setpTotalRatings(rs.getInt("pTotalRatings"));
				productVO.setpState(rs.getInt("pState"));
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
	
	@Override
	public List<ProductVO> getAll() {

		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				productVO = new ProductVO();
				productVO.setpNo(rs.getInt("pNo"));
				productVO.setCategoryName(rs.getString("categoryName"));
				productVO.setpName(rs.getString("pName"));
				productVO.setpPrice(rs.getInt("pPrice"));
				productVO.setpInfo(rs.getString("pInfo"));
				productVO.setpQuantity(rs.getInt("pQuantity"));
				productVO.setpOnDate(rs.getTimestamp("pOnDate"));
				productVO.setpOffDate(rs.getTimestamp("pOffDate"));
				productVO.setpImage1(rs.getString("pImage1"));
				productVO.setpImage2(rs.getString("pImage2"));
				productVO.setpImage3(rs.getString("pImage3"));
				productVO.setpRatingsQuantity(rs.getInt("pRatingsQuantity"));
				productVO.setpTotalRatings(rs.getInt("pTotalRatings"));
				productVO.setpState(rs.getInt("pState"));
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
=======
	private static final String INSERT_STMT = "INSERT INTO product (pNo,categoryName,pName,pPrice,pInfo,pQuantity,pOnDate,pOffDate,pImage1,pImage2,pImage3,pRatingsQuantity,pTotalRatings,pState) "
												+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT pNo,categoryName,pName,pPrice,pOnDate,pOffDate,pState FROM product order by pNo";
	private static final String GET_ONE_STMT = "SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 where pNo = ?";
	private static final String DELETE = "DELETE FROM product where empno = ?";
	private static final String UPDATE = "UPDATE product set ename=?, job=?, hiredate=?, sal=?, comm=?, deptno=? where pNo = ?";

>>>>>>> COURSE
}
