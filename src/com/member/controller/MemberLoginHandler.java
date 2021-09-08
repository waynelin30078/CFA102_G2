package com.member.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

import com.member.model.MemberService;
import com.member.model.MemberVO;

public class MemberLoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		String action = req.getParameter("action");
System.out.println("1");
		if ("signIn".equals(action))
			try {
System.out.println("2");
				Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
System.out.println("3");
				req.setAttribute("errorMsgs", errorMsgs);
System.out.println("4");
				String mid = req.getParameter("mem_id");
				String mpsw = req.getParameter("mem_pwd");
System.out.println("5");
				if (mid == null || (mid.trim().length() == 0)) {
System.out.println("6");
					errorMsgs.put("mem_id", "請輸入帳號");
					RequestDispatcher failureView = req.getRequestDispatcher("/front_end/free/member/memberLogin.jsp");
					failureView.forward(req, res);
					return;
				}
				if (mpsw == null || (mpsw.trim().length() == 0)) {
System.out.println("7");					
					errorMsgs.put("mem_pwd", "請輸入密碼");
					RequestDispatcher failureView = req.getRequestDispatcher("/front_end/free/member/memberLogin.jsp");
					failureView.forward(req, res);
					return;
				}
				MemberService memberSvc = new MemberService();
				MemberVO memberVO = new MemberVO();
				System.out.println("7.1");
				memberVO = memberSvc.getOneMemberByMid(mid);  //用帳號去找
				System.out.println("7.2");
//System.out.println(memberVO.getMno());
//System.out.println(memberVO.getMname());
			
			
				if (memberVO == null && mid.trim().length() != 0) {
System.out.println("8");
					errorMsgs.put("mem_id", "此帳號尚未註冊");
					RequestDispatcher failureView = req.getRequestDispatcher("/front_end/free/member/memberLogin.jsp");
					failureView.forward(req, res);
					return;
				}

//				memberVO.setMid(mid);

				MemberVO memberVO1 = memberSvc.isUser(mid, mpsw);
System.out.println("8.1");
//				System.out.println(memberVO1.getMno());
//				System.out.println(memberVO1.getMname());
				if (memberVO1 == null && memberVO != null) {
System.out.println("9");
					errorMsgs.put("mem_pws", "密碼錯誤");
					RequestDispatcher failureView = req.getRequestDispatcher("/front_end/free/member/memberLogin.jsp");
					failureView.forward(req, res);
					return;
				}

				if (!errorMsgs.isEmpty()) {
System.out.println("10");
					RequestDispatcher failureView = req.getRequestDispatcher("/front_end/free/member/memberLogin.jsp");
					failureView.forward(req, res);
					return;
				} else if (memberVO1 != null) {
					String mname =memberVO1.getMname();
					HttpSession session = req.getSession();
					session.setAttribute("account", mid); //*工作1: 才在session內做已經登入過的標識
					session.setAttribute("accountname", mname);
					try {
						String location = (String) session.getAttribute("location");
						if (location != null) {   //*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
							session.removeAttribute("location");
							res.sendRedirect(location);
							return;
						}
					} catch (Exception ignored) {

					}
				}
			} catch (Exception e) {

			}
		res.sendRedirect(req.getContextPath()+"/login_success.jsp");  //*工作3: (-->如無來源網頁:則重導至login_success.jsp)
	}
}


