package com.course.model;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;


public class CourseDAOtest {

	public static void main(String[] args) {

		Date date = new Date();
		int cNo = 1;
		int dNo = 1;
		String cName = "test";
		int cPrice = 100;
		Date cSheifDate = new java.sql.Date(date.getTime());
		String cIntroduction = "這是課程介紹";
		int cType = 1;
		byte[] cPic = new byte[1];
		String cDescription = "這是預覽說明";
		
		//單一查詢結果測試
//		CourseDAO_interface dao = new CourseJDBCDAO();
//		CourseVO course= dao.findBy_cNO(cNo);
//		System.out.println(course);
		//List查詢測試
//		CourseDAO_interface dao = new CourseJDBCDAO();
//		List<CourseVO> courseList = dao.getAll();
//		for(CourseVO c:courseList)
//			System.out.println(c);
	}

}
