package com.d_order.model;

import java.sql.Date;
import java.util.List;

import com.member.model.MemberVO;

public interface DorderDAO_interface {

	void insert(DorderVO dOrder);   //新增訂單
	void update(DorderVO dOrder);	 //修改訂單
	DorderVO findByPrimaryKey(int dOrderNo);  //訂單編號找訂單
	List<DorderVO> getAll();   //找全部訂單
	List<DorderVO> getActiveOrder();  //找現有訂單
	List<MemberVO> findClientsByDNo(int dNo); //營養師編號找現有客戶 
	
	
	
	
}
