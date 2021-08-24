package com.course.model;

import java.util.List;

public interface CourseDAO_interface {
	void insert(CourseVO courseVO);//新增 營養師 v
	void update(CourseVO courseVO);//更新 營養師
	void cState(Integer cState, Integer cNo);//變更狀態 營養師 後台
	CourseVO findBy_cNO(Integer cNo); //依照課程編號查詢 後台 v
	List<CourseVO> findBy_dNo(Integer dNo); //依照講師編號查詢 會員 訪客  v
	List<CourseVO> findBy_cName(String cName); //依照課程名稱查詢	  會員 訪客		x							
	List<CourseVO> findBy_cType(Integer cType);//依照類別 訪客 會員 v
	List<CourseVO> findBy_cTotalScore(int Score);//依照評價  會員 訪客	
	List<CourseVO> getAll();//
}
