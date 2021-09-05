<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.course.model.*"%>
<%
	CourseService courseSvc = new CourseService();
	List<CourseVO> list = courseSvc.getAll();
	pageContext.setAttribute("list",list);
%>
<%
response.setHeader("Cache-Control","no-store"); //HTTP 1.1
response.setHeader("Pragma","no-cache");        //HTTP 1.0
response.setDateHeader ("Expires", 0);
%>
<jsp:useBean id="DieticianSvc" scope="page" class="com.dietician.model.DieticianService" />

<html>
<head>
<title>所有員工資料 - listAllCoure.jsp</title>
<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>


</head>
<body bgcolor='white'>
<table id="table-1">
	<tr><td>
		 <h3>所有課程資料 - listAllCourse.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/course/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>	
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}"</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<table>
	<tr>
		<th>課程編號</th>
		<th>營養師姓名</th>
		<th>課程名稱</th>
		<th>課程價格</th>
		<th>課程狀態</th>
		<th>上架時間</th>
		<th>課程主題</th>
		<th>購買人數</th>
		<th>課程評價總人數</th>
		<th>課程評價總分數</th>
		<th>課程圖片</th>
		<th>修改課程</th>
		<th>狀態修改</th>
	</tr>
<%-- 	<%@ include file="page1.file" %> --%>
<%-- 	<c:forEach var="courseVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
	<c:forEach var="courseVO" items="${list}">
		
		<tr>
			<td>${courseVO.cno}</td>
			<td>${DieticianSvc.findByPrimaryKey(courseVO.dno).dname}</td> <!-- ${DieticianSvc.findByPrimaryKey(courseVO.dno).dname}有取到但是顯示為空-->
			<td>${courseVO.cname}</td>
			<td>${courseVO.cprice}</td>
			<td>${courseVO.cstate}</td>
			<td> <fmt:formatDate value="${courseVO.cshelfDate}" pattern="yyyy-MM-dd"/></td>
			<td>${courseVO.ctype}</td> 
			<td>${courseVO.quantity}</td> 
			<td>${courseVO.ctotalPeople}</td> 
			<td>${courseVO.ctotalScore}</td>
			<td><img src="<%=request.getContextPath()%>/course/course.do?action=showpic&cpic=${courseVO.cno}"width ='150px' height='150px'/></td> 
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/course/course.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="cno"  value="${courseVO.cno}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/course/course.do" style="margin-bottom: 0px;">
			     <input type="submit" value="變更狀態">
			     <input type="hidden" name="cno"  value="${courseVO.cno}">
			     <input type="hidden" name="action" value="update_state"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%-- <%@ include file="page2.file" %> --%>

</body>
</html>
