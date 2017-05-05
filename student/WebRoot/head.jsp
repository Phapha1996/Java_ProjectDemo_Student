<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center;">
       <h1>欢迎您，管理员</h1>
    <br>
    <a href="${pageContext.request.contextPath }/servlet/AddStudentUIServlet" target="body">学生注册</a>  &nbsp 
    <a href="${pageContext.request.contextPath }/servlet/DropStudentUIServlet" target="body">删除学生学籍</a> &nbsp
    <a href="${pageContext.request.contextPath }/servlet/WatchAllStudent" target="body">查看所有学生</a> &nbsp
    <a href="${pageContext.request.contextPath }/servlet/WatchFirstNameUIServlet" target="body">学生统一姓氏查询</a> &nbsp
    <a href="${pageContext.request.contextPath }/servlet/WatchStudentUIForName" target="body">姓名查询</a>&nbsp
    <a href="${pageContext.request.contextPath }/servlet/WatchStudentForNumUI" target="body">学号查询</a>
    
  </body>
</html>
