package com.course.model;

import java.util.List;

public interface CourseDAO_interface {
	void insert(CourseVO courseVO);//新增
	void update(CourseVO courseVO);//更新
	void state(int cState, int cNo);//變更狀態
	CourseVO findBy_cNO(int cNo); //依照課程編號查詢
	CourseVO findBy_dNo(int dNo); //依照講師編號查詢
	CourseVO findBy_cName(String cName); //依照課程名稱查詢										
	CourseVO findBy_cTotalScore(int Score);//依照評價		
	List<CourseVO> getAll();//
}
