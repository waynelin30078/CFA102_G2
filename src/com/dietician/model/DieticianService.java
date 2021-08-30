package com.dietician.model;

import java.sql.Date;
import java.util.List;

public class DieticianService {

	private DieticianDAO_interface dao = new DieticianDAO();

	public DieticianVO addDietician(String dname, String daccount, String dpassword, Date dbirthDay, String dpic,
			String dphone, String daddress, String demail, String edu, String exp, String lic, String prof,
			Integer clPrice, Integer mprice, String intro, Integer dstate, Integer totalScore, Integer totalReviewer,
			Integer donState, String offDay, String optTime) {

		DieticianVO dietician = new DieticianVO();

		dietician.setDname(dname);
		dietician.setDaccount(daccount);
		dietician.setDpassword(dpassword);
		dietician.setDbirthDay(dbirthDay);
		dietician.setDpic(dpic);
		dietician.setDphone(dphone);
		dietician.setDaddress(daddress);
		dietician.setDemail(demail);
		dietician.setEdu(edu);
		dietician.setExp(exp);
		dietician.setLic(lic);
		dietician.setProf(prof);
		dietician.setClPrice(clPrice);
		dietician.setMprice(mprice);
		dietician.setIntro(intro);
		dietician.setDstate(dstate);
		dietician.setTotalScore(totalScore);
		dietician.setTotalReviewer(totalReviewer);
		dietician.setDonState(donState);
		dietician.setOffDay(offDay);
		dietician.setOptTime(optTime);

		dao.insert(dietician);

		return dietician;
	}

	public DieticianVO updateDietician(Integer dno, String dname, String daccount, String dpassword, Date dbirthDay, String dpic,
			String dphone, String daddress, String demail, String edu, String exp, String lic, String prof,
			Integer clPrice, Integer mprice, String intro, Integer dstate, Integer totalScore, Integer totalReviewer,
			Integer donState, String offDay, String optTime) {

		DieticianVO dietician = new DieticianVO();

		dietician.setDno(dno);
		dietician.setDname(dname);
		dietician.setDaccount(daccount);
		dietician.setDpassword(dpassword);
		dietician.setDbirthDay(dbirthDay);
		dietician.setDpic(dpic);
		dietician.setDphone(dphone);
		dietician.setDaddress(daddress);
		dietician.setDemail(demail);
		dietician.setEdu(edu);
		dietician.setExp(exp);
		dietician.setLic(lic);
		dietician.setProf(prof);
		dietician.setClPrice(clPrice);
		dietician.setMprice(mprice);
		dietician.setIntro(intro);
		dietician.setDstate(dstate);
		dietician.setTotalScore(totalScore);
		dietician.setTotalReviewer(totalReviewer);
		dietician.setDonState(donState);
		dietician.setOffDay(offDay);
		dietician.setOptTime(optTime);

		dao.update(dietician);

		return dietician;
	}

	public DieticianVO findByPrimaryKey(int dno) {
		return dao.findByPrimaryKey(dno);
	}

	public List<DieticianVO> getAll() {

		return dao.getAll();
	}

	public List<DieticianVO> findByScore(double avgScore) {
		return dao.findByScore(avgScore);
	}

	public List<DieticianVO> findBySubscribeFee(int minPrice, int maxPrice) {
		return dao.findBySubscribeFee(minPrice, maxPrice);
	}

	public List<DieticianVO> findByDieticianState(int dstate) {
		return dao.findByDieticianState(dstate);
	}
}
