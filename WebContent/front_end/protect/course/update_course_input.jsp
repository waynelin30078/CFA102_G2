<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.course.model.*"%>

<%
  CourseVO courseVO = (CourseVO) request.getAttribute("courseVO"); //EmpServlet.java (Concroller) 存入req的courseVO物件 (包括幫忙取出的courseVO, 也包括輸入資料錯誤時的courseVO物件)
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料修改 - update_emp_input.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>課程資料修改 - update_course_input.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/course/course.do" name="form1" enctype="multipart/form-data">
<table>
	<tr>
		<td>課程編號:<font color=red><b>*</b></font></td>
		<td><input type="text" name="cno" size="45" value="<%=courseVO.getCno()%>"></td>
	</tr>
	<tr>
		<td>營養師編號:<font color=red><b>*</b></font></td>
		<td><input type="text" name="dno" size="45" value="<%=courseVO.getCno()%>"></td>
	</tr>
	<tr>
		<td>課程名稱:<font color=red><b>*</b></font></td>
		<td><input type="text" name="cname" size="45" value="<%=courseVO.getCname()%>"></td>
	<tr>
		<td>課程介紹:</td>
		<td><input type="text"  name="cintroduction" size="45"
			value="<%= (courseVO==null)? "請輸入課程介紹" : courseVO.getCintroduction()%>"/></td>										
	</tr>
	<tr>
		<td>課程價格:</td>
		<td><input type="text" name="cprice" size="45"	value="<%=courseVO.getCprice()%>" /></td>
	</tr>
	<tr>
		<td>課程預覽說明:</td>
		<td><input type="text"  name="cdescription" size="45"
			value="<%= (courseVO==null)? "請輸入課程預覽說明" :courseVO.getCdescription()%>"/></td>											
	</tr>
	
	<tr>
		<td>課程預覽圖:</td>
		<td><input type="file"  name="cpic" value="<%= courseVO.getCpic()%>"
	 onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"
	 /> <img id="blah" alt="your image" width="100" height="100" /></td>
	</tr>
</table>

<br>
<input type="hidden" name="action" value="update">
<input type="submit" value="送出更新"></FORM>

</body>
</html>