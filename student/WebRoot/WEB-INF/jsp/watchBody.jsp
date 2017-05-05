<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'watchName.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center">
  <table align="center" width="700" border="1">
  <tr>
  <td>学号</td><td>姓名</td><td>性别</td><td>生日</td><td>学院</td><td>专业</td><td>年级</td>
  </tr>
  <tr>
  <td>${student.num }</td><td>${student.name }</td><td>${student.gender }</td><td>${student.birthday }</td><td>${student.college }</td><td>${student.major }</td><td>${student.grade }</td>
  </tr>
  </table>
  </body>
</html>
