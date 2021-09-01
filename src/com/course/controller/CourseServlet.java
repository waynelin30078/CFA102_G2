package com.course.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.course.model.*;


@MultipartConfig
public class CourseServlet extends HttpServlet {
	
  
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("cno");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入課程編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/course/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				Integer cno = null;
				try {
					cno = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("課程編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/course/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				CourseService courseSvc = new CourseService();
				CourseVO courseVO = courseSvc.getOne(cno);
				if (courseVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/course/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("courseVO", courseVO); // 資料庫取出的courseVO物件,存入req
				String url = "/course/listOneCourse.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneCourse.jsp
				successView.forward(req, res);
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/course/select_page.jsp");
				failureView.forward(req, res);
			}
		}
//以上OKOK
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer cno = new Integer(req.getParameter("cno"));
				
				/***************************2.開始查詢資料****************************************/
				CourseService empSvc = new CourseService();
				CourseVO courseVO = empSvc.getOne(cno);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("courseVO", courseVO);         // 資料庫取出的empVO物件,存入req
				String url = "/emp/update_course_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_course_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/emp/listAllCourse.jsp");
				failureView.forward(req, res);
			}
		}
//	-----	
	if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer cno = new Integer(req.getParameter("cno").trim());
				
				String cname = req.getParameter("cname");
				String cnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,50}$";
				if (cname == null || cname.trim().length() == 0) {
					errorMsgs.add("課程名稱: 請勿空白");
				} else if(!cname.trim().matches(cnameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("課程名稱: 只能是中、英文字母、數字和_ , 且長度必需在3到50之間");
	            }
				
				Integer cprice = new Integer(req.getParameter("cprice"));
				if (cprice<1) {
					errorMsgs.add("你是要做功德嗎?");
				}	
				String cintroduction = req.getParameter("cintroduction").trim();
				if (cintroduction == null || cintroduction.trim().length() == 0) {
					errorMsgs.add("課程介紹請勿空白");
				}	
				String cdescription = req.getParameter("cdescription").trim();
				if (cdescription == null || cdescription.trim().length() == 0) {
					errorMsgs.add("課程預覽說明請勿空白");
				}	
				Part pic = req.getPart("cpic");//圖片處理
				InputStream in = pic.getInputStream();
				byte[] cpic = new byte[in.available()];
				in.read(cpic);
				in.close();



				CourseVO courseVO = new CourseVO();
				courseVO.setCno(cno);
				courseVO.setCname(cname);
				courseVO.setCprice(cprice);
				courseVO.setCintroduction(cintroduction);
				courseVO.setCdescription(cdescription);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("courseVO", courseVO); // 含有輸入格式錯誤的courseVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/update_course_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				CourseService courseSvc = new CourseService();
				courseVO = courseSvc.updateCourse(cno, cname, cprice, cintroduction, cpic, cdescription);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("courseVO", courseVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/course/listOneCourse.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/course/update_course_input.jsp");
				failureView.forward(req, res);
			}
		}

	}
}