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
	//修改會員資料
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
	//用mno取得單一會員
	public MemberVO getOneMember(Integer mno) {
		return dao.findByPrimaryKey(mno);
	}
	//取得所有會員
	public List<MemberVO> getAll(){
		return dao.getAll();
	}
	
	//用會員id跟pwd來驗證登入
	public  MemberVO isUser(String mid,String mpsw ) {
		return dao.isUser(mid, mpsw);
	}
	public MemberVO getOneMemberByMid(String mid){
		return dao.findByMid(mid);
	}
	
}
