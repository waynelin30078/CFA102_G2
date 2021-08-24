package com.d_order.model;

import java.sql.Date;
import java.util.List;

public interface DorderDAO_interface {

	void insert(DorderVO dOrder);   //新增訂單
	void update(DorderVO dOrder);	 //修改訂單
	DorderVO findByPrimaryKey(int dOrderNo);  //訂單編號找訂單
	List<DorderVO> getAll();   //找全部訂單
	boolean isActive(); //判斷是否訂閱是否進行中 
	List<DorderVO> findExpired(Date endDay); 
	
	
	
	
}
