package com.dietician.controller;

import javax.servlet.http.*;

import com.dietician.model.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;

import java.io.*;
import java.util.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 10 * 1024 * 1024, maxRequestSize = 10 * 10 * 1024 * 1024)

public class DieticianServlet extends HttpServlet{

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("getAll_for_display".equals(action)) {
			
			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				DieticianService dieticianSvc = new DieticianService(); 
				List<DieticianVO> list = dieticianSvc.getAll();
				
				
				req.setAttribute("list", list);
				
				String url = "/front_end/free/dietician/select_dietician.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
				
			} catch (Exception e) {
				errorMsgs.add("資料查詢發生錯誤");
				String url = "/front_end/free/dietician/select_dietician.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
			}

		}
		
		if("findByScore".equals(action)) {
			
			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				Double avgScore = new Double(req.getParameter("avgScore"));
				DieticianService dieticianSvc = new DieticianService(); 
				List<DieticianVO> list = dieticianSvc.findByScore(avgScore);
				
				
				req.setAttribute("list", list);
				
				String url = "/front_end/free/dietician/select_dietician.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
				
			} catch (Exception e) {
				errorMsgs.add("資料查詢發生錯誤");
				String url = "/front_end/free/dietician/select_dietician.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
			}

		}
		if("findByPrice".equals(action)) {
	
			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
		
				Integer minPrice = new Integer(req.getParameter("minPrice"));
				Integer maxPrice = new Integer(req.getParameter("maxPrice"));
				DieticianService dieticianSvc = new DieticianService(); 
				List<DieticianVO> list = dieticianSvc.findBySubscribeFee(minPrice, maxPrice);
		
		
				req.setAttribute("list", list);
		
				String url = "/front_end/free/dietician/select_dietician.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		
		
			} catch (Exception e) {
				errorMsgs.add("資料查詢發生錯誤");
				String url = "/front_end/free/dietician/select_dietician.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
			}

		}
		
		
		if("one_dietician_page".equals(action)) {
			
			DieticianService dieticianSvc = new DieticianService(); 
			
			Integer dno = new Integer(req.getParameter("dno"));
			
			DieticianVO dietician = dieticianSvc.findByPrimaryKey(dno);
			
			req.setAttribute("dieticianVO", dietician);
			
			String url = "/front_end/free/dietician/one_dietician_page.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
		}
		
		if("update_dietician_page".equals(action)) {
			
			DieticianService dieticianSvc = new DieticianService(); 
			
			Integer dno = new Integer(req.getParameter("dno"));
			
			DieticianVO dietician = dieticianSvc.findByPrimaryKey(dno);
			
			req.setAttribute("dieticianVO", dietician);
			
			String url = "/front_end/free/dietician/update_dietician_page.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
		}
		
		if("update".equals(action)) {
			
			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			//=====================驗證資料格式=====================
			
			try {
				
				
				String dname = req.getParameter("dname");
				
				if(dname ==null || dname.trim().length()==0) {
					errorMsgs.add("請輸入姓名");
				}
				
				String daccount = req.getParameter("daccount");
				if(daccount ==null || daccount.trim().length()==0) {
					errorMsgs.add("請輸入帳號");
				}
				
				String dpasswordRegEx =  "^(?=.*[0-9])(?=.*[a-z]).{6,15}$";
				
				String dpassword = req.getParameter("dpassword");
				if(dpassword ==null || dpassword.trim().length()==0) {
					errorMsgs.add("請輸入密碼");
				} 
				else if(!dpassword.matches(dpasswordRegEx)) {
					errorMsgs.add("密碼請輸入混合英文及數字6-15碼");
				}
				
				java.sql.Date dbirthDay = null;
				try {
				dbirthDay = java.sql.Date.valueOf(req.getParameter("dbirthDay"));
					
				} catch(IllegalArgumentException e) {
					errorMsgs.add("請輸入生日");
				}
				
				String dphone = req.getParameter("dphone");
				if(dphone ==null || dphone.trim().length()==0) {
					errorMsgs.add("請輸入電話");
				}
				
				String daddress = req.getParameter("daddress");
				if(dphone ==null || dphone.trim().length()==0) {
					errorMsgs.add("請輸入地址");
				}
				
				String demail = req.getParameter("demail");
				
				
				String intro = req.getParameter("intro");
				if(intro ==null || intro.trim().length()==0) {
					intro="";
				}
				
				String edu = req.getParameter("edu");
				if(edu ==null || edu.trim().length()==0) {
					edu="";
				}
				String exp = req.getParameter("exp");
				if(exp ==null || exp.trim().length()==0) {
					exp="";
				}
				String lic = req.getParameter("lic");
				if(lic ==null || lic.trim().length()==0) {
					lic="";
				}
				String prof = req.getParameter("prof");
				if(prof ==null || prof.trim().length()==0) {
					prof="";
				}
				
				Integer clPrice = null;
				if(req.getParameter("clPrice").trim().length()==0) {
					clPrice = 0;
				}
				else {
					try {
						clPrice = new Integer(req.getParameter("clPrice").trim());
					}catch(NumberFormatException e) {
						errorMsgs.add("諮詢價格請輸入數字");
					}
				}
				
				
				
				if(intro ==null || intro.trim().length()==0) {
					intro="";
				}
				
				
				Integer mprice = null;
				if(req.getParameter("mprice").trim().length()==0) {
					mprice = 0;
				} else {
					try {
						mprice = new Integer(req.getParameter("mprice").trim());
					}catch(NumberFormatException e) {
						errorMsgs.add("營養師月費請輸入數字");
					}
				}
				
				

				String dpic= req.getParameter("dpic");   //舊圖片
				Part part = req.getPart("dpic_changed");   //新圖片
				
					if(part.getSize() != 0) {   //如果新圖片的大小不等於0, 代表有新圖片
							String directoryPath = getServletContext().getRealPath("/front_end/free/dietician/images") ;
				
							File fsaveDirectory = new File(directoryPath);
					if (!fsaveDirectory.exists()) {
					 fsaveDirectory.mkdirs();
					}
				
					String filename = daccount + "_" + getFileNameFromPart(part);
				
						
					if(filename != null && part.getContentType()!=null ) {
					
					dpic ="/front_end/free/dietician/images/" + filename;   //改寫舊圖片的路徑

					File f = new File(fsaveDirectory, filename);
					part.write(f.getPath());
					}
				}


				
				Integer dno = new Integer(req.getParameter("dno"));
				Integer dstate = new Integer(req.getParameter("dstate"));
				Integer totalScore = new Integer(req.getParameter("totalScore"));
				Integer totalReviewer = new Integer(req.getParameter("totalReviewer"));
				Integer donState = new Integer(req.getParameter("donState"));
				String offDay = req.getParameter("offDay");
				String optTime = req.getParameter("optTime");
				
				
				
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
				
				
				
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("dieticianVO", dietician);
				
				String url = "/front_end/free/dietician/update_dietician_page.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
				return;
			}
	
			//=====================格式驗證完成, 開始建立VO==================
			
			DieticianService dieticianSvc = new DieticianService();
			dietician = dieticianSvc.updateDietician(dno, dname, daccount, dpassword, dbirthDay, dpic, dphone, daddress, demail, edu, exp, lic, prof, clPrice, mprice, intro, dstate, totalScore, totalReviewer, donState, offDay, optTime);
			
			req.setAttribute("dieticianVO", dietician);
			
			String url ="/front_end/free/dietician/one_dietician_page.jsp";
				
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			

			} catch(Exception e) {
				e.printStackTrace();
				errorMsgs.add("新增資料發生錯誤");
				String url = "/front_end/free/dietician/update_dietician_page.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
				
			}
			
			

		}
	
		
		
		
		
		
		
		if("add_Dietician".equals(action)) {
			
			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			//=====================驗證資料格式=====================
			
			try {
	
				String dname = req.getParameter("dname");
				
				if(dname ==null || dname.trim().length()==0) {
					errorMsgs.add("請輸入姓名");
				}
				
				String daccount = req.getParameter("daccount");
				if(daccount ==null || daccount.trim().length()==0) {
					errorMsgs.add("請輸入帳號");
				}
				
				String dpasswordRegEx =  "^(?=.*[0-9])(?=.*[a-z]).{6,15}$";
				
				String dpassword = req.getParameter("dpassword");
				if(dpassword ==null || dpassword.trim().length()==0) {
					errorMsgs.add("請輸入密碼");
				} 
				else if(!dpassword.matches(dpasswordRegEx)) {
					errorMsgs.add("密碼請輸入混合英文及數字6-15碼");
				}
				
				java.sql.Date dbirthDay = null;
				try {
				dbirthDay = java.sql.Date.valueOf(req.getParameter("dbirthDay"));
					
				} catch(IllegalArgumentException e) {
					errorMsgs.add("請輸入生日");
				}
				
				String dphone = req.getParameter("dphone");
				if(dphone ==null || dphone.trim().length()==0) {
					errorMsgs.add("請輸入電話");
				}
				
				String daddress = req.getParameter("daddress");
				if(dphone ==null || dphone.trim().length()==0) {
					errorMsgs.add("請輸入地址");
				}
				
				String demail = req.getParameter("demail");
				
				
				String intro = req.getParameter("intro");
				if(intro ==null || intro.trim().length()==0) {
					intro="";
				}
				
				String edu = req.getParameter("edu");
				if(edu ==null || edu.trim().length()==0) {
					edu="";
				}
				String exp = req.getParameter("exp");
				if(exp ==null || exp.trim().length()==0) {
					exp="";
				}
				String lic = req.getParameter("lic");
				if(lic ==null || lic.trim().length()==0) {
					lic="";
				}
				String prof = req.getParameter("prof");
				if(prof ==null || prof.trim().length()==0) {
					prof="";
				}
				
				Integer clPrice = null;
				if(req.getParameter("clPrice").trim().length()==0) {
					clPrice = 0;
				}
				else {
					try {
						clPrice = new Integer(req.getParameter("clPrice").trim());
					}catch(NumberFormatException e) {
						errorMsgs.add("諮詢價格請輸入數字");
					}
				}
				
				
				
				if(intro ==null || intro.trim().length()==0) {
					intro="";
				}
				
				
				Integer mprice = null;
				if(req.getParameter("mprice").trim().length()==0) {
					mprice = 0;
				} else {
					try {
						mprice = new Integer(req.getParameter("mprice").trim());
					}catch(NumberFormatException e) {
						errorMsgs.add("營養師月費請輸入數字");
					}
				}
				

				String dpic= "";
				
				String directoryPath = getServletContext().getRealPath("/front_end/free/dietician/images") ;
				
				File fsaveDirectory = new File(directoryPath);
				if (!fsaveDirectory.exists()) {
					 fsaveDirectory.mkdirs();
				}
				
				Part part = req.getPart("dpic");
				String filename = daccount + "_" + getFileNameFromPart(part);
				
				
						
				if(filename != null && part.getContentType()!=null ) {
					
					dpic="/front_end/free/dietician/images/" + filename;
					File f = new File(fsaveDirectory, filename);
					part.write(f.getPath());
				}
				
				Integer dstate = 0;
				Integer totalScore = 0;
				Integer totalReviewer = 0;
				Integer donState = 0;
				String offDay = "";
				String optTime = "";
				
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
				
				
				
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("dieticianVO", dietician);
				
				String url = "/front_end/free/dietician/add_dietician_page.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
				return;
			}
	
			//=====================格式驗證完成, 開始建立VO==================
			
			DieticianService dieticianSvc = new DieticianService();
				
			dietician = dieticianSvc.addDietician(dname, daccount, dpassword, dbirthDay, dpic, dphone, daddress, demail, edu, exp, lic, prof, clPrice, mprice, intro, dstate, totalScore, totalReviewer, donState, offDay, optTime);
			
			String url ="/front_end/free/dietician/select_dietician.jsp";
				
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			

			} catch(Exception e) {
				e.printStackTrace();
				errorMsgs.add("新增資料發生錯誤");
				String url = "/front_end/free/dietician/add_dietician_page.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
				
			}
			
			

		}
	}
	
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();

		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
}
