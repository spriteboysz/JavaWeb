<%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-10-28
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>添加图书信息</h3>
<form action="" method="post">
    <label>图书编号 <input type="text" name=""/> </label><br>
    <label>图书名称 <input type="text" name=""/> </label><br>
    <label>图书作者 <input type="text" name=""/> </label><br>
    <label>图书价格 <input type="text" name=""/> </label><br>
    <label>图书封面 <input type="text" name=""/> </label><br>
    <label>图书描述 <input type="text" name=""/> </label><br>
    <label>图书库存 <input type="text" name=""/> </label><br>
    <label>图书类型<br> <input type="radio" name="bookType" value="1"/>原创
        <input type="radio" name="bookType" value="2"/>翻译 </label><br>
    <label><input type="submit" value="提交"></label>

</form>
</body>
</html>