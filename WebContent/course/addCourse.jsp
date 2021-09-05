<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.course.model.*"%>

<%
	CourseVO courseVO = (CourseVO) request.getAttribute("courseVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Insert title here</title>
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
		 <h3>新增課程 - addCourse.jsp</h3></td><td>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/course/course.do" name="form1"  enctype="multipart/form-data">
<table>
	<jsp:useBean id="courseSvc" class="com.course.model.CourseService" />
	<tr>
		<td>營養師編號:</td>
		<td><input type="TEXT" name="dno" size="45" 
			 value="<%= (courseVO==null)? "1" : courseVO.getDno()%>" /></td>
	</tr>
	
	<tr>
		<td>課程名稱:</td>
		<td><input type="TEXT" name="cname" size="45"
 			 value="<%= (courseVO==null)? "請輸入課程名稱" : courseVO.getCname()%>" /></td>	
 	</tr>
 	<tr>
		<td>課程介紹:</td>
		<td><input type="text"  name="cintroduction" size="45"
			value="<%= (courseVO==null)? "請輸入課程介紹" : courseVO.getCintroduction()%>"/></td>										
	</tr>
	<tr>
		<td>課程價格:</td>
		<td><input type="text" name="cprice" size="45" required
			 value="<%= (courseVO==null)? "0" : courseVO.getCprice()%>" /></td>
	</tr>
	<tr>
		<td>課程預覽說明:</td>
		<td><input type="text"  name="cdescription" size="45"
			value="<%= (courseVO==null)? "請輸入課程預覽說明" :courseVO.getCdescription()%>"/></td>											
	</tr>
	
	

	
	<tr>
		<td>課程類型:<font color=red><b>*</b></font></td>
		<td><select size="1" name="ctype">
				<option value="1">飲食知識</option>
				<option value="2">健身</option>
				<option value="3">餐點製作</option>
		</select></td>
	</tr>
	<tr>
		<td>課程預覽圖:</td>
		<td><input type="file" name="cpic" enctype="multipart/form-data" 
			 value="<%= (courseVO==null)? "" : courseVO.getCpic()%>"
			 onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"
	 /> <img id="blah" alt="your image" width="100" height="100" />
	 </td>
	</tr>

	</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>