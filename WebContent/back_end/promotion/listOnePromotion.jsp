<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.promotion.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  PromotionVO promotionVO = (PromotionVO) request.getAttribute("promotionVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<html>
<head>
<title>商品優惠活動 - listOnePromotion.jsp</title>

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
	width: 600px;
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

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>商品優惠活動 - ListOnePromotion.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/touch.png" width="50" height="50" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>優惠活動編號</th>
		<th>優惠活動名稱</th>
		<th>開始日期</th>
		<th>結束日期</th>
	</tr>
	<tr>
		<td><%=promotionVO.getPromNo()%></td>
		<td><%=promotionVO.getPromName()%></td>
		<td><%=promotionVO.getPromStartDate()%></td>
		<td><%=promotionVO.getPromEndDate()%></td>
	</tr>
</table>

</body>
</html>