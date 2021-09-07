package com.diary.model;

import java.sql.Date;
import java.util.List;

public class DiaryService {

	private DiaryDAO_interface dao = new DiaryDAO();
	
	
	public DiaryVO addDiary(DiaryVO diary) {
		
		dao.insert(diary);
		
		return diary;
	}
	
	public DiaryVO updateDiary(Integer diaryNo, Integer mno, Integer dno, Date diaryDate, Integer ht, Integer wt, Double bodyFat,
			Integer wc, String bodyPic, Integer viewState, String reply, Double totalCal, Double totalCho,
			Double totalPro, Double totalFat, Double totalCalBurn) {
		
		DiaryVO diary = new DiaryVO();
		
		diary.setDiaryNo(diaryNo);
		diary.setMno(mno);
		diary.setDno(dno);
		diary.setDiaryDate(diaryDate);
		diary.setHt(ht);
		diary.setWt(wt);
		diary.setBodyFat(bodyFat);
		diary.setWc(wc);
		diary.setBodyPic(bodyPic);
		diary.setViewState(viewState);
		diary.setReply(reply);
		diary.setTotalCal(totalCal);
		diary.setTotalCho(totalCho);
		diary.setTotalPro(totalPro);
		diary.setTotalFat(totalFat);
		diary.setTotalCalBurn(totalCalBurn);
		
		dao.update(diary);
		
		return diary;
	}
	
	public void deleteDiary(Integer diaryNo) {
		
		DiaryVO diary = new DiaryVO();
		
		diary.setDiaryNo(diaryNo);
		
		dao.delete(diary);
	}
	
	public DiaryVO findByDate(int mno, Date diaryDate) {
		
		return dao.findByDate(mno, diaryDate);
		
	}
	
	
	public List<DiaryVO> findByMember(int mno) {
		return dao.findByMember(mno);
	}
	
	public List<DiaryVO> findByDieticianState(int dno, int viewState) {
		return dao.findByDieticianState(dno, viewState);
	}
	
}
