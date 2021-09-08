<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*" %>

<%
  MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>註冊新會員</title>
</head>
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
<body bgcolor='white'>
<table id="table-1">
	<tr><td>
		 <h3>會員資料新增 </h3></td><td>
		 <h4><a href="<%=request.getContextPath()%>/back_end/protected/member/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member.do" name="form1">
	<table>
	<tr>
		<td>會員姓名:</td>
		<td><input type="TEXT" name="mname" size="45" value="123"/></td>
	</tr>
	<tr>
		<td>會員帳號:</td>
		<td><input type="TEXT" name="mid" size="45" value="123"/></td>
	</tr>
	<tr>
		<td>會員密碼:</td>
		<td><input type="TEXT" name="mpsw" size="45" value="123"/></td>
	</tr>
	<tr>
		<td>會員信箱:</td>
		<td><input type="TEXT" name="mmail" size="45" value="123"/></td>
	</tr>
	<tr>
		<td>會員電話:</td>
		<td><input type="TEXT" name="mphone" size="45" value="123"/></td>
	</tr>
	<tr>
		<td>會員性別:</td>
		<td>
			<input type="radio" name="msex" id="male" value="1"/>
			  <label for="male">男</label>
			<input type="radio" name="msex" id="female" value="2"/>
			 <label for="female">女</label>
		</td>
	</tr>
	
	</table>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" value="新增會員"></form>
</body>
</html>