<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查看同姓学生</title>
    

  </head>
  
  <body style="text-align:center"><br><br><br>
	<table align="center" border="1" width="700">
	<tr>
	<td>学号</td><td>姓名</td><td>性别</td><td>生日</td><td>学院</td><td>专业</td><td>年级</td>
	</tr>
	<c:forEach var="s" items="${list }">
	<tr>
	<td>${s.num }</td><td>${s.name }</td><td>${s.gender }</td><td>${s.birthday }</td><td>${s.college }</td><td>${s.major }</td><td>${s.grade }</td>
	</tr>
	</c:forEach>
	</table>  
  </body>
</html>
