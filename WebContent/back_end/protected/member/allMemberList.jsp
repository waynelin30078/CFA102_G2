<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="java.util.*"%>
<%@ page import ="com.member.model.*"%>
<%
	MemberService memberSvc = new MemberService();
	List<MemberVO> list = memberSvc.getAll();
	pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>後台管理</title>


	<!-- 此include包含了，head的設定與css的連結 -->
	<%@ include file="/back_end_example/head_include.jsp"%>
	<!-- ----------------------------------------------------------- -->
	
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

<body id="page-top">

	<!-- 此include包含了，側邊欄位、登入登出，連結從這邊填寫 -->
	<%@ include file="/back_end_example/body_include.jsp"%>
	<!-- --------------------------------------------------- -->







	<!-- Begin Page Content 中間填寫部分-->

	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-4 text-gray-800">中間要填寫的部分</h1>
		
		<table id = "table1">
	<tr><td>
	<h3>全部會員資料</h3>
	<h4><a href="<%=request.getContextPath()%>/back_end/protected/member/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>會員編號</th>
		<th>會員姓名</th>
		<th>帳號</th>
		<th>密碼</th>
		<th>郵件</th>
		<th>手機</th>
		<th>生日</th>
		<th>自介</th>	
		<th>照片</th>
	</tr>
	<%@ include file="pages/page1.file" %> 
	<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
	<tr>
	
		
		<td>${memberVO.mno}</td>
		<td>${memberVO.mname}</td>
		<td>${memberVO.mid}</td>
		<td>${memberVO.mpsw}</td>
		<td>${memberVO.mmail}</td>
		<td>${memberVO.mphone}</td>
		<td>${memberVO.mbday}</td>
		<td>${memberVO.mintro}</td>
		<td>
		<c:if test="${memberVO.mimg != null }">
		<img src="<%=request.getContextPath()%>/member.do?action=showPhoto&photo=${memberVO.mno}" width="150" height="150">
		</c:if>
		<c:if test="${memberVO.mimg == null} ">
			<p>查無圖片</p>
		</c:if>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="mno"  value="${memberVO.mno}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="mno"  value="${memberVO.mno}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
	</tr>
	</c:forEach>
</table>
<%@ include file="pages/page2.file" %>

	</div>
	<!-- /.container-fluid -->








	<!-- 此include包含了foot、登出的確定畫面、Bootstrap core JavaScript、Core plugin JavaScript、 Custom scripts for all pages的連結-->
	<%@ include file="/back_end_example/foot_include.jsp"%>
	<!-- --------------------------------------------------- -->



</body>

</html>