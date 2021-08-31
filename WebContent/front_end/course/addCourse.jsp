<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.course.model.*"%>

<%
	CourseVO courseVO = (CourseVO) request.getAttribute("courseVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
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
		 <h3>���u��Ʒs�W - addCourse.jsp</h3></td><td>
		 <h4><a href="select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="course.do" name="form1">
<table>
	<tr>
		<td>�ҵ{�s��:</td>
		<td><input type="TEXT" name="cno" size="45" 
			 value="<%= (courseVO==null)? "1" : courseVO.getCno()%>" /></td>
	</tr>
	<tr>
		<td>�ҵ{�W��:</td>
		<td><input type="TEXT" name="cname" size="45"
 			 value="<%= (courseVO==null)? "�п�J�ҵ{�W��" : courseVO.getCname()%>" /></td>	
 	</tr>
 	<tr>
		<td>�ҵ{����:</td>
		<td><input type="text"  name="cintroduction" size="45"
			value="<%= (courseVO==null)? "�п�J�ҵ{����" : courseVO.getCintroduction()%>"/></td>										
	</tr>
	<tr>
		<td>�ҵ{�w������:</td>
		<td><input type="text"  name="cdescription" size="45"
			value="<%= (courseVO==null)? "�п�J�ҵ{�w������" :courseVO.getCdescription()%>"/></td>											
	</tr>
	
	<tr>
		<td>�ҵ{����:</td>
		<td><input type="TEXT" name="cprice" size="45"
			 value="<%= (courseVO==null)? "�п�J�ҵ{����" : courseVO.getCprice()%>" /></td>
	</tr>
	<jsp:useBean id="courseSvc" scope="page" class="com.course.model.CourseService" />
	<tr>
		<td>�ҵ{����:<font color=red><b>*</b></font></td>
		<td><select size="1" name="ctype">
			<c:forEach var="courseVO" items="${courseSvc.all}">
				<option value="${courseVO.ctype}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname}
			</c:forEach>
		</select></td>
	</tr>

	</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>
</body>
</html>