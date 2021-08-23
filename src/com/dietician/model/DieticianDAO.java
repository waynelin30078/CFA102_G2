package com.dietician.model;

import java.util.List;

import com.member.model.MemberVO;

public class DieticianDAO implements DieticianDAO_interface{

	
	
	
	
	@Override
	public void insert(DieticianVO dietician) {
		
		
	}

	@Override
	public void update(DieticianVO dietician) {
		
		
	}

	@Override
	public DieticianVO findByPrimaryKey(int dNo) {
		
		return null;
	}

	@Override
	public List<DieticianVO> getAll() {
		
		return null;
	}

	@Override
	public List<DieticianVO> findByScore(int totalScore, int totalReviewer) {
		
		return null;
	}

	@Override
	public List<DieticianVO> findBySubscibeFee(int maxPrice, int minPrice) {
		
		return null;
	}

	@Override
	public List<MemberVO> findAllClientsById(int dNo) {
	// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DieticianVO> findByDieticianState(int dState) {
		
		return null;
	}

	public static void main(String[] args) {
		

	}

}
