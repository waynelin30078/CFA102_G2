<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Member:home</title>
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
<body bgcolor = 'white'>
	<table id="table-1">
   <tr><td><h3>會員</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for MEMBER Home</p>

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
  <li><a href='listAllMember.jsp'>List</a> all Member  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member.do" >
        <b>輸入會員編號 (如1):</b>
        <input type="text" name="mno">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member.do" >
       <b>選擇員工編號:</b>
       <select size="1" name="mno">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.mno}">${memberVO.mno}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member.do" >
       <b>選擇員工姓名:</b>
       <select size="1" name="mno">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.mno}">${memberVO.mname}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/front_end/free/member/addMember.jsp'>Add</a> a new Member.</li>
</ul>
	

</body>
</html>