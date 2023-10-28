<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>学生成绩查询系统-主页面</title>
</head>
<body>
<%
    String tips = (String) request.getAttribute("tips");
%>
<table border='1' width='100%'>
    <tr>
        <td headers="100" colspan='2'><label>学生成绩查询系统，欢迎你</label></td>
    </tr>
    <tr>
        <td width='200' height="600">2-1</td>
        <td align='center' valign='top'>
            <%if (tips != null) {%>
            <label style='color:red'><%=tips%>
            </label>
            <%}%>
            <form action='GradeQueryServlet' method='post'>
                <h3>查询课程成绩</h3>
                <label>学号 <input type='text' name='sNum' placeholder='学号'/></label><br>
                <label>课程 <input type='text' name='cid' placeholder='课程号'/></label><br>
                <label><input type='submit' value='查询'/></label>
            </form>
        </td>
    </tr>
</table>
</body>
</html>