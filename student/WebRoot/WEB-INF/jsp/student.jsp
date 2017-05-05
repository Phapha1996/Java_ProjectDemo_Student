<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>学生信息添加页面</title>
	<script language="javascript" src="${pageContext.request.contextPath }/js/student.js"></script>
	
  </head>
  
  <body style="text-align:center;" onload="pageInit()">
  <br><br>
  <form action="${pageContext.request.contextPath }/servlet/AddStudentServlet" method="post" onsubmit="return check()" id="student">
  
  <table border="1" align="center" width="500" height="250">
  
  <tr>
  <td>学号：*</td>
  <td><input type="text" name="num"></td>
  </tr>
  
  <tr>
  <td>姓名：*</td>
  <td><input type="text" name="name"></td>
  </tr>
  
  <tr>
  <td>性别：*</td>
  <td>男<input type="radio" value="男" name="gender">女<input type="radio" value="女" name="gender"></td>
  </tr>
  
  <tr>
  <td>出生日期：</td>
  <td>
  	<select  id="year">
  		<option value="1980">1980</option>
  	</select>年
  	
  	<select  id="month">
  	<option value="1">01</option>
  	</select>月
  	
  	<select  id="day">
  	<option value="1">01</option>
  	</select>日
  </td>
  </tr> 
   
  <tr>
  <td>学院：</td>
  <td>信息学院<input type="radio" value="信息学院" name="college">
  	环境学院<input type="radio" value="环境学院" name="college">
  	土木学院<input type="radio" value="土木学院" name="college">
  	管理学院<input type="radio" value="管理学院" name="college">
  </td>
  </tr>

  <tr>
  <td>专业：</td>
  <td>
  <select name="major">
  <option value="软件工程">软件工程</option>
  <option value="计算机科学与技术">计算机科学与技术</option>
  <option value="人力资源">人力资源</option>
  <option value="土木工程">土木工程</option>
  <option value="测绘工程">测绘工程</option>
  <option value="环境科学">环境科学</option>
  </select>
  </td>
  </tr>
  
  <tr>
  <td>年级：</td>
  <td>
  大一<input type="radio" name="grade" value="大一">
  大二<input type="radio" name="grade" value="大二">
  大三<input type="radio" name="grade" value="大三">
  </td>
  </tr>
  </table>
  <br>
  <input type="submit" value="添加学生">
  </form>
  
  </body>
</html>
