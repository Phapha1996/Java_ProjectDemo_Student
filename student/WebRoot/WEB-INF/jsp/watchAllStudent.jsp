<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'watchAllStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align: center;">
  <br>
  
  <c:choose>
  <c:when test="${!empty(page.list) }">
  <table align="center" border=1 width="800" height="300">
  	<tr>
  		<td>学号</td>
  		<td>姓名</td>
  		<td>性别</td>
  		<td>生日</td>
  		<td>学院</td>
  		<td>专业</td>
  		<td>年级</td>
  		<td>学生管理</td>
  	<tr>
  	<c:forEach items="${page.list }" var="c">
  		<tr>
  			<td>${c.num }</td>
  			<td>${c.name }</td>
  			<td>${c.gender }</td>
  			<td>${c.birthday }</td>
  			<td>${c.college }</td>
  			<td>${c.major }</td>
  			<td>${c.grade }</td>
  			<th>
  			<a href="${pageContext.request.contextPath }/servlet/DropStudentServlet?name=${c.name}">开除</a>
  			</th>
  		</tr>
  	</c:forEach>
  	
  </table>
  </c:when>
  <c:otherwise>
  <h1>对不起，页面还没有任何的数据</h1>
  </c:otherwise>
  </c:choose>
  <br><br>
  
  	当前[${page.pagenum }]页&nbsp;&nbsp;&nbsp;
  	<c:if test="${page.pagenum>1 }">
  	<a href="${pageContext.request.contextPath }/servlet/WatchAllStudent?pagenum=${page.pagenum-1}">上一页</a>&nbsp;
  	</c:if>
  	<c:forEach var="pagenum" begin="${page.startpage }" end="${page.endpage }">
  		[<a href="${pageContext.request.contextPath }/servlet/WatchAllStudent?pagenum=${pagenum}">${pagenum }</a>]
  	</c:forEach>
  	 &nbsp;
  	 <c:if test="${page.pagenum<page.totlepage }">
  	 <a href="${pageContext.request.contextPath }/servlet/WatchAllStudent?pagenum=${page.pagenum+1}">下一页</a>
  	 </c:if>
  	&nbsp;&nbsp;&nbsp;总共[${page.totlepage }]页，共[${page.totlerecord }]条记录
  	<table><form action="${pageContext.request.contextPath }/servlet/WatchAllStudent" method="post">
  	<input type="text" name="pagenum" style="width:25px">&nbsp;
  	<input type="submit" value=" go ">
  	</form>
  </body>
</html>
