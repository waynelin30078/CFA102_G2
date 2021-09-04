<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*" %>
<%
  MemberVO memberVO = (MemberVO) request.getAttribute("memberVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>會員資料修改</title>
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
<table id="table-1">
	<tr><td>
		 <h3>會員資料修改 - update_emp_input.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front_end/free/member/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
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
<FORM METHOD="post" ACTION="member.do" name="form1">
<table>
	<tr>
		<td>會員編號:<font color=red><b>*</b></font></td>
		<td><%=memberVO.getMno()%></td>
	</tr>
	<tr>
		<td>姓名:</td>
		<td><input type="TEXT" name="mname" size="45" value="<%=memberVO.getMname()%>" /></td>
	</tr>
	<tr>
		<td>帳號:</td>
		<td><input type="TEXT" name="mid" size="45"	value="<%=memberVO.getMid()%>" /></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input name="TEXT" name="mpsw" size="45" value="<%=memberVO.getMpsw() %>" ></td>
	</tr>
	<tr>
		<td>信箱:</td>
		<td><input type="TEXT" name="sal" size="45"	value="<%=memberVO.getMmail()%>" /></td>
	</tr>
	<tr>
		<td>電話:</td>
		<td><input type="TEXT" name="comm" size="45" value="<%=memberVO.getMphone()%>" /></td>
	</tr>



</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="mno" value="<%=memberVO.getMno()%>">
<input type="submit" value="送出修改"></FORM>
<body>

</body>
</html>