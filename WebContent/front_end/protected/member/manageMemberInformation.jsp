<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.member.model.*" %>
    <%@ page import ="java.util.*"%>
<%
	MemberVO memberVO = (MemberVO)session.getAttribute("memberVO1");
	
%>

<!DOCTYPE html>
<html>

<head>
<title>營材食教</title>

<!-- *************每一頁head裡面都要include這個css連結******************* -->
<%@ include file="/front_end_example/CSS_link.jsp" %>
<!-- *************每一頁head裡面都要include這個css連結******************* -->

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


<body>
<!-- *************每一頁body最前面都要include這個header連結******************* -->
<%@ include file="/front_end_example/header_link.jsp" %>
<!-- *************每一頁body最前面都要include這個header連結******************* -->
<div class="container this_page">
<!-- 服務很好先做一個置中的div(開頭) -->





${mno}
${accountname}

${memberVO}
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
這邊可以開始放自己的東西了














<!-- 服務很好先做一個置中的div(結束) -->
</div>
<!-- *************每一頁body最後面都要include這個footer連結******************* -->
<%@ include file="/front_end_example/footer_link.jsp" %>
<!-- *************每一頁body最後面都要include這個footer連結******************* -->
<!-- *************每一頁body最後面都要include這個js連結******************* -->
<%@ include file="/front_end_example/js_link.jsp" %>
<!-- *************每一頁body最後面都要include這個js連結******************* -->
</body>
</html>