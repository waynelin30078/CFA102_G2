package com.meal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dietician.model.DieticianVO;

public class MealDAO implements MealDAO_interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102_G2?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	private static final String insert_SQL = "INSERT INTO meal VALUES(default, ?, ?, ?, ?, ?, ?);";
	private static final String update_SQL = "UPDATE meal SET diaryNo= ?, mealName= ?, mealCal= ?, mealCho= ?, mealPro= ?,	mealFat= ? WHERE mealNo = ?;";
	private static final String delete_SQL = "DELETE FROM meal WHERE mealNo = ?;";
	private static final String findByDiaryNo_SQL = "SELECT * FROM meal WHERE diaryNo = ?;";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(MealVO meal) {
		// TODO Auto-generated method stub

		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(insert_SQL);

			pstmt.setInt(1, meal.getDiaryNo());
			pstmt.setInt(2, meal.getMealName());
			pstmt.setDouble(3, meal.getMealCal());
			pstmt.setDouble(4, meal.getMealCho());
			pstmt.setDouble(5, meal.getMealPro());
			pstmt.setDouble(6, meal.getMealFat());

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
	public void update(MealVO meal) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(update_SQL);

			pstmt.setInt(1, meal.getDiaryNo());
			pstmt.setInt(2, meal.getMealName());
			pstmt.setDouble(3, meal.getMealCal());
			pstmt.setDouble(4, meal.getMealCho());
			pstmt.setDouble(5, meal.getMealPro());
			pstmt.setDouble(6, meal.getMealFat());
			pstmt.setInt(7, meal.getMealNo());

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
	public void delete(MealVO meal) {
		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(delete_SQL);

			pstmt.setInt(1, meal.getMealNo());

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
	public MealVO findByDiaryNo(int diaryNo) {

		Connection con = null;
		MealVO meal = new MealVO();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(findByDiaryNo_SQL);
			pstmt.setInt(1, diaryNo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				meal.setMealNo(rs.getInt("mealNo"));
				meal.setDiaryNo(diaryNo);
				meal.setMealName(rs.getInt("mealName"));
				meal.setMealCal(rs.getDouble("mealCal"));
				meal.setMealCho(rs.getDouble("mealCho"));
				meal.setMealPro(rs.getDouble("mealPro"));
				meal.setMealFat(rs.getDouble("mealFat"));

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

		return meal;
	}

	public static void main(String[] args) {
		
		MealDAO dao = new MealDAO();
		
		MealVO meal = new MealVO(2, 3, 	643.0 ,	444.0 ,	777.0 ,	111.0);
		
		System.out.println(meal.getMealPro());
		
		
		dao.insert(meal);

	}

}
