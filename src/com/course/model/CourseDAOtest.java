package com.course.model;

import java.util.Date;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;

public class CourseDAOtest {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/JDBCSample?" + "serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	public static void main(String[] args) {
		
		
		Date date = new Date();
		Integer cNo = 2;
		Integer dNo = 2;// 講師編號
		String cName = "sleep";// 課程名稱
		Integer cPrice = 100;
		Integer cState = 1;
		Date cShelfDate = new java.sql.Date(date.getTime());// 上架日期
		String cIntroduction = "這是一門睡覺課";// 課程介紹
		Integer cType = 1;
		Integer quantity = 1;// 購買人數
		byte[] cPic = null;
		try {
			cPic = getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\tJwGtpC.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 預覽圖
		String cDescription = "睡好睡滿精神好";// 預覽介紹
		Integer cTotalPeople = 0;
		Integer cTotalScore = 0;

		// 新增測試
		CourseVO course = new CourseVO(cNo, dNo, cName, cPrice, cState, cShelfDate, cIntroduction, cType, quantity,
				cPic, cDescription, cTotalPeople, cTotalScore);

		// 單一查詢結果測試
//		CourseDAO_interface dao = new CourseJDBCDAO();
//		CourseVO course= dao.findBy_cNO(cNo);
//		System.out.println(course);
		// List查詢測試
//		CourseDAO_interface dao = new CourseJDBCDAO();
//		List<CourseVO> courseList = dao.getAll();
//		for(CourseVO c:courseList)
//			System.out.println(c);
	}
public static byte[] getPictureByteArray(String path) throws IOException{
	FileInputStream fis =new FileInputStream(path);
	byte[] buffer = new byte[fis.available()];
	fis.read(buffer);
	fis.close();
	return buffer;
	
} 
}
