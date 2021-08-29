package com.diary.model;

import java.sql.Date;
import java.util.List;


public interface DiaryDAO_interface {

	void insert(DiaryVO diary);   //新增飲食日記  會員前台
	void update(DiaryVO diary);	 //修改飲食日記內容   會員前台   營養師前台
	void delete(DiaryVO diary);
	DiaryVO findByDate(int mNo, Date diaryDate);  //找某會員某天日記
	List<DiaryVO> findByMember(int mno);   //會員編號找日記
	List<DiaryVO> findByDieticianState(int dno, int viewState);   //營養師找日記狀態

}
