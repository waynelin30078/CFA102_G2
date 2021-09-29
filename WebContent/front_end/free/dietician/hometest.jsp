<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="com.dietician.model.*"%>
<%@ page import="com.dietician.controller.*"%>

<% DieticianVO dietician2 = (DieticianVO)session.getAttribute("dieticianVO2"); 
DieticianService dietician1 =new DieticianService();
DieticianVO dietician=(DieticianVO)dietician1.findByPrimaryKey(dietician2.getDno());
%>    
	
<!DOCTYPE html>
<html>

<head>
<title>營材食教</title>

<!-- *************每一頁head裡面都要include這個css連結******************* -->
<%@ include file="/front_end_example/CSS_link.jsp"%>
<!-- *************每一頁head裡面都要include這個css連結******************* -->

</head>


<body>
	<!-- *************每一頁body最前面都要include這個header連結******************* -->
	<%@ include file="/front_end_example/header_link.jsp"%>
	<!-- *************每一頁body最前面都要include這個header連結******************* -->
	<div class="container this_page">
		<!-- 服務很好先做一個置中的div(開頭) -->








<div class="container">
		<div class="row">
					<div class="col-2">
					
					</div>
					<div class="col-4 r1c1">
						<br>
						<br>
						<br>
						<br>
						<br>
						<h3>營養師會員</h3>
						<p><a href="<%=request.getContextPath()%>/front_end/free/dietician/select_dietician.jsp">回首頁</a></p>
						<input type="hidden" name="dno" value="<%= dietician.getDno()%>">
						<input type="hidden" name="dstate" value="<%= dietician.getDstate()%>">
						<input type="hidden" name="totalScore" value="<%= dietician.getTotalScore()%>">
						<input type="hidden" name="totalReviewer" value="<%= dietician.getTotalReviewer()%>">
						<input type="hidden" name="donState" value="<%= dietician.getDonState()%>">
						<input type="hidden" name="offDay" value="<%= dietician.getOffDay()%>">
						<input type="hidden" name="optTime" value="<%= dietician.getOptTime()%>">
						
						<div id="pic">
  							<img  id="dieticianPic" src="<%=request.getContextPath()%><%= dietician.getDpic()%>">
  						</div>
  						
						<p>姓名:<%= dietician.getDname()%></p>
						<p>帳號:<%= dietician.getDaccount()%></p>
						<p>生日:<%= dietician.getDbirthDay()%></p>
						<p>電話:<%= dietician.getDphone()%></p>
						<p>地址:<%= dietician.getDaddress()%></p>
						<p>Email:<%= dietician.getDemail()%></p>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<p><input class="buttom bottom2" type="submit" value="修改會員資料"></p>
						
						
					</div>
					
					
					<div class="col-6 r1c2">
						<br>
						<br>
						<br>
						<br>
						<br>
						<h4>自我介紹:</h4> 
						<p><%= dietician.getIntro()%></p>
						<h4>學歷簡介:</h4> 
						<p><%= dietician.getEdu()%></p>
						<h4>經歷簡介:</h4> 
						<p><%= dietician.getExp()%></p>
						<h4>證照簡介:</h4>
						<p><%= dietician.getLic()%></p>
						<h4>專長簡介:</h4> 
						<p><%= dietician.getProf()%></p>
						<h4>諮詢價格：</h4>  
						<p><%= dietician.getClPrice()%>元/每次</p>
						<h4>專屬營養師月費：</h4>
						<p><%= dietician.getMprice()%>元/每月</p>
						<h4 style="color:red">權限狀態：</h4>
						<p>
						<c:if test="<%= dietician.getDstate()==0%>">
						未審核
						</c:if>
						<c:if test="<%= dietician.getDstate()==1%>">
						通過審核
						</c:if>
						<c:if test="<%= dietician.getDstate()==2%>">
						未通過審核
						</c:if>
						</p>
					
						<input type="hidden" name="action" value="update_dietician_page">
						
					</div>
					
					
		</div>













		<!-- 服務很好先做一個置中的div(結束) -->
	</div>
	<!-- *************每一頁body最後面都要include這個footer連結******************* -->
	<%@ include file="/front_end_example/footer_link.jsp"%>
	<!-- *************每一頁body最後面都要include這個footer連結******************* -->
	<!-- *************每一頁body最後面都要include這個js連結******************* -->
	<%@ include file="/front_end_example/js_link.jsp"%>
	<!-- *************每一頁body最後面都要include這個js連結******************* -->
</body>
</html>