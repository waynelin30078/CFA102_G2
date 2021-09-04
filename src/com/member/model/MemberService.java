package com.member.model;

import java.sql.Date;
import java.util.List;

public class MemberService {
	private MemberDAO_interface dao;
	
	public MemberService() {
		dao = new MemberJDBCDAO();
	}
	
	//新增基本的資料
	public MemberVO addMember(String mname, String mid, String mpsw, String mmail, String mphone, Integer msex ) {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMname(mname);
		memberVO.setMid(mid);
		memberVO.setMpsw(mpsw);
		memberVO.setMmail(mmail);
		memberVO.setMphone(mphone);
		memberVO.setMsex(msex);
		dao.insert(memberVO);
		
		return memberVO;
		
	}
	
	public MemberVO updateMember(String mname, String mpsw, String mmail, String mphone, byte[] mimg, Date mbday, Integer msex ,String mintro ,Integer mno) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMname(mname);
		memberVO.setMpsw(mpsw);
		memberVO.setMmail(mmail);
		memberVO.setMphone(mphone);
		memberVO.setMimg(mimg);
		memberVO.setMbday(mbday);
		memberVO.setMsex(msex);
		memberVO.setMintro(mintro);
		memberVO.setMno(mno);
		dao.update(memberVO);
		return memberVO;
	}
	public MemberVO getOneMember(Integer mno) {
		return dao.findByPrimaryKey(mno);
	}
	
	public List<MemberVO> getAll(){
		return dao.getAll();
	}
}
