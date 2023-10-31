<%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-10-30
  Time: 23:49
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="js/checkName.js"></script>
</head>
<body>
<h3>新用户注册</h3>
<form action="" method="post">
    <label>用户名 <input type="text" id="userName"/><label id="tipsLabel"></label>
        <input type="button" value="检查" onclick="checkUserName()"/>
    </label><br>
    <label>密码 <input type="password"> </label><br>
    <label>确认 <input type="password"> </label><br>
    <label>邮箱 <input type="email"> </label><br>
    <label><input type="submit" value="注册"> </label><br>
</form>
</body>
</html>
