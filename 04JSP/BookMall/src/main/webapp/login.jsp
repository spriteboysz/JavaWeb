<%--@elvariable id="tips" type="com"--%>
<%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-10-28
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书城后台管理-登录</title>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
        }

        #login_header {
            width: 100%;
            height: 150px;
        }

        #login_content {
            height: 600px;
            background-color: deepskyblue;
            position: relative;
        }

        #login_div {
            position: absolute;
            right: 400px;
            top: 100px;
        }

        #login_table {
            width: 400px;
            height: 400px;
            background: white;
            border: 1px lightgray solid;
            border-radius: 5px;
            box-shadow: rgb(128, 128, 128) 3px 3px 4px;
        }

        .inputStyle {
            width: 310px;
            height: 35px;
            border: 1px lightgray solid;
            border-radius: 3px;
        }

        .btnStyle {
            width: 300px;
            height: 40px;
            border: 1px lightgray solid;
            border-radius: 3px;
            background: orangered;

        }

        .btnStyle:hover {
            background: orange;
        }
    </style>
</head>
<body>
<div id=login_header>
    <h3>在线书城后台管理系统，欢迎登录</h3>
</div>
<div id="login_content">
    <div id="login_div">
        <form action="LoginCheckServlet" method="post">
            <table id="login_table" cellspacing="0">
                <tr height="80">
                    <td align="center"><h3>管理员登录</h3></td>
                </tr>
                <tr height="40">
                    <td align="center">${tips}</td>
                </tr>
                <tr>
                    <td align="center">
                        <label>
                            <input type="text" name="userName" placeholder="管理员账号" class="inputStyle"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <label>
                            <input type="password" name="userPassword" placeholder="管理员密码" class="inputStyle">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <label>
                            <input type="text" name="userCode" placeholder="验证码">
                            <img src="" alt="" width="100" height="30"></label>
                    </td>
                </tr>
                <tr height="120">
                    <td align="center"><input type="submit" value="登录" class="btnStyle"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div id="login_footer">

</div>


</body>
</html>
