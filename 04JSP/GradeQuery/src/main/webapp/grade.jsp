<%@ page import="com.deean.dto.Grade" %><%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-10-27
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>学生成绩查询系统-主页面</title>
</head>
<body>
<%
    Grade grade = (Grade) request.getAttribute("grade");
%>
<table border='1' width='100%'>
    <tr>
        <td colspan='2' height="100"><label>学生成绩查询系统，欢迎你</label></td>
    </tr>
    <tr>
        <td width='200' height="600">2-1</td>
        <td align='center' valign='top'>
            <h3>查询结果</h3>
            <table width='200' border='1' cellspacing='0'>
                <tr>
                    <td>学号</td>
                    <td><%=grade.getsNum()%>
                    </td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><%=grade.getsName()%>
                    </td>
                </tr>
                <tr>
                    <td>课程</td>
                    <td><%=grade.getCid()%>
                    </td>
                </tr>
                <tr>
                    <td>课程</td>
                    <td><%=grade.getcName()%>
                    </td>
                </tr>
                <tr>
                    <td>成绩</td>
                    <td><%=grade.getScore()%>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
