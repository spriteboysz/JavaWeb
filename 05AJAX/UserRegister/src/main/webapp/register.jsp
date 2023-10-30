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
</head>
<body>
<h3>新用户注册</h3>
<form action="" method="post">
    <label>用户名 <input type="text" name="userName"/>
        <button>检查</button>
    </label><br>
    <label>密 码 <input type="password" name="userPassword"> </label><br>
    <label>确 认 <input type="password" name="userPasswordConfirm"> </label><br>
    <label>邮 箱 <input type="email" name="userMail"> </label><br>
    <label><input type="submit" name="注册"> </label><br>
</form>
</body>
</html>
