package com.dietician.model;

import com.member.model.MemberVO;
import java.util.List;

public interface DieticianDAO_interface {

	
	void insert(DieticianVO dietician);   //新增會員
	void update(DieticianVO dietician);	 //修改資料
	DieticianVO findByPrimaryKey(int dNo);  //用dNo找一個營養師
	List<DieticianVO> getAll();   //找全部營養師
	List<DieticianVO> findByScore(int totalScore, int totalReviewer);   //找平均幾分以上的營養師
	List<DieticianVO> findBySubscibeFee(int maxPrice, int minPrice);   //找訂閱價格區間的營養師
	List<MemberVO> findAllClientsById(int dNo); //用營養師id找訂閱者
	List<DieticianVO> findByDieticianState(int dState); //依審核狀態找營養師
	
	
}
