package com.food_record.model;

public interface FoodRecordDAO_interface {
	
	void insert(FoodRecordVO foodRecord);   //新增食物紀錄 會員前台
	void update(FoodRecordVO foodRecord);	//修改食物紀錄   會員前台   
	void delete(FoodRecordVO foodRecord);	//刪除食物紀錄   會員前台   
	
}
