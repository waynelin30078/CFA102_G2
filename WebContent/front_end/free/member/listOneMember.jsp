<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.member.model.*" %>
<%MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>會員資料</title>
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
<body bgcolor = "white" >
<table id = "table1">
	<tr><td>
	<h3>會員資料</h3>
	<h4><a href="<%=request.getContextPath()%>/front_end/free/member/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>會員姓名</th>
		<th>會員帳號</th>
		<th>會員密碼</th>
		<th>e-mail</th>
		<th>電話</th>
		<th>自介</th>
	</tr>
	<tr>
		<td><%=memberVO.getMno()%></td>
		<td><%=memberVO.getMname()%></td>
		<td><%=memberVO.getMid()%></td>
		<td><%=memberVO.getMpsw()%></td>
		<td><%=memberVO.getMmail()%></td>
		<td><%=memberVO.getMphone()%></td>
		<td><%=memberVO.getMintro()%></td>
	</tr>
</table>
</body>
</html>