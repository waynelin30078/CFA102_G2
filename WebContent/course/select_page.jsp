<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Insert title here</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>CFA102_G2 Course: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for CFA102_G2 Course: Home</p>

<h3>資料查詢:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllCourse.jsp'>List</a> all Course.  <br><br></li>
   
   
   <li>
    <FORM METHOD="post" ACTION="course.do" >
        <b>輸入課程編號 :</b>
        <input type="text" name="courseno">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>
  
 <jsp:useBean id="courseSvc" scope="page" class="com.course.model.CourseService"/>
  
  <li>
  	<FORM METHOD="post" ACTION="course.do">
  	<b>請選擇課程編號</b>
  	<select size="1" name="courseno">
  	<c:forEach var="courseVO" items="${courseSvc.all}">
  		<option value="${courseVO.cno}">${courseVO.cno}
  	</c:forEach>
  	</select>
  	 <input type="hidden" name="action" value="getOne_For_Display">
     <input type="submit" value="送出">
  	</FORM>
  </li>
  
    <li>
     <FORM METHOD="post" ACTION="course.do" >
       <b>選擇課程名稱</b>
       <select size="1" name="courseno">
         <c:forEach var="courseVO" items="${courseSvc.all}"> 
          <option value="${courseVO.cno}">${courseVO.cname}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>課程管理</h3>

<ul>
  <li><a href='addCourse.jsp'>Add</a> a new Course.</li>
</ul>
  
</body>
</html>