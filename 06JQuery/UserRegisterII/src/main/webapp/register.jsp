<%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-11-01
  Time: 21:59
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script type="text/javascript" src="js/jquery-3.7.1.js"></script>
<html>
<head>
    <title>用户注册II(JQuery)</title>
</head>
<body>
<h3>新用户注册</h3>
<form action="" method="post">
    <label>用户名 <input type="text" id="userName"/><label id="tipsLabel"></label>
        <input type="button" value="检查" id="checkBtn"/>
    </label><br>
    <label>密码 <input type="password"> </label><br>
    <label>确认 <input type="password"> </label><br>
    <label>邮箱 <input type="email"> </label><br>
    <label><input type="submit" value="注册"> </label><br>
</form>
<script type="text/javascript">
    $("#checkBtn").click(function () {
        let userName = $("#userName").val()
        /* $.ajax({
            url: "CheckUserNameServlet?userName=" + userName,
            type: "get",
            success: function (res) {
                if (res.code === 1000) {
                    $("#tipsLabel").replaceWith("<label id=tipsLabel style='color:green'>用户名可用</label>");
                } else {
                    $("#tipsLabel").replaceWith("<label id=tipsLabel style='color:red'>用户名不可用</label>");
                }
            }
        });*/
        $.get("CheckUserNameServlet", {userName: userName}, function (res) {
            if (res.code === 1000) {
                $("#tipsLabel").replaceWith("<label id=tipsLabel style='color:green'>用户名可用</label>");
            } else {
                $("#tipsLabel").replaceWith("<label id=tipsLabel style='color:red'>用户名不可用</label>");
            }
        }, "json");
    });
</script>
</body>
</html>
