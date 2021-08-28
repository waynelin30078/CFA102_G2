package com.meal.model;

import java.util.List;


public interface MealDAO_interface {

	
	void insert(MealVO meal);   //新增餐次飲食  會員前台
	void update(MealVO meal);	 //修改餐次飲食內容   會員前台   營養師前台
	void delete(MealVO meal);
	MealVO findByDiaryNo(int diaryNo);   //會員編號找日記
	
	
	
}
