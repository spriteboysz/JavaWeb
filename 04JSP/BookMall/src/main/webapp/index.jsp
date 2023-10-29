<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>书城后台管理-主页</title>
    <style type="text/css">
        body {
            padding: 0;
            margin: 0;
        }

        #container {
            width: 100%;
            height: 900px;
        }
    </style>
</head>
<body>
<table id="container" cellspacing="0">
    <tr height="120">
        <td colspan="2" width="220" style="background: deepskyblue">
            <label style="color: white;font-size: 25px">在线书城后台管理系统</label>
        </td>
    </tr>
    <tr>
        <td width="220" align="left" valign="top"
            style="padding-top: 20px;padding-left: 20px;border-right: 1px lightblue solid;">
            图书信息管理
            <ul style="list-style: none">
                <li><a href="book-add.jsp" target="mainFrame">添加图书</a></li>
                <li><a href="BookListServlet" target="mainFrame">图书列表</a></li>
            </ul>
            订单管理
            <ul style="list-style: none">
                <li><a href="">订单维护</a></li>
                <li><a href="">订单列表</a></li>
            </ul>
        </td>
        <td>
            <iframe name="mainFrame" width="100%" height="800" frameborder="0"></iframe>
        </td>
    </tr>

</table>
</body>
</html>