package com.member.model;


import java.util.*;
public interface MemberDAO_interface {
	public void insert(MemberVO memberVO);
	public void update(MemberVO memberVO);
	public MemberVO findByPrimaryKey(Integer mNo);
	public List<MemberVO> getAll();
	public MemberVO isUser(String mid ,String mpsw);  //用帳號跟密碼找
	public MemberVO findByMid(String mid); //用帳號找

}
