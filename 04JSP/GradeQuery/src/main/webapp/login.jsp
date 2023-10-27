<%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-10-27
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>学生成绩查询系统-登录</title>
</head>
<body>
<%
    String tips = request.getParameter("tips");
    if (tips != null) {
%>
<label style='color:red'><%=tips%>
</label>
<%}%>
<form action='CheckServlet' method='post'>
    <h3>学生成绩查询系统-学生登录</h3>
    <label>学号 <input type='text' name='sNum' placeholder='学号'/></label><br>
    <label>密码 <input type='password' name='sPassword' placeholder='密码'/></label><br>
    <label><input type='submit' value='登录'/></label>
</form>
</body>
</html>
