<jsp:useBean id="book" scope="request" type="com.deean.dto.Book"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-10-28
  Time: 22:16
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>修改图书信息</h3>
<form action="BookModifyServlet" method="post" enctype="multipart/form-data">
    <label>图书编号 ${book.bookId} <input type="hidden" name="bookId" value="${book.bookId}"/> </label><br>
    <label>图书名称 <input type="text" name="bookName" value="${book.bookName}"/> </label><br>
    <label>图书作者 <input type="text" name="bookAuthor" value="${book.bookAuthor}"/> </label><br>
    <label>图书价格 <input type="text" name="bookPrice" value="${book.bookPrice}"/> </label><br>
    <label>图书封面 <img src="${book.bookCover}" height="100" alt="" onchange="">
        <input type="file" name="bookImg" value="${book.bookCover}"/> </label><br>
    <label>图书描述 <input type="text" name="bookDesc" value="${book.bookDesc}"/> </label><br>
    <label>图书库存 <input type="text" name="bookStock" value="${book.bookStock}"/> </label><br>
    <label>图书类型<br>
        <c:if test="${book.bookType==1}">
            <input type="radio" name="bookType" value="1" checked/>原创
            <input type="radio" name="bookType" value="2"/>翻译<br>
        </c:if>
        <c:if test="${book.bookType==2}">
            <input type="radio" name="bookType" value="1"/>原创
            <input type="radio" name="bookType" value="2" checked/>翻译<br>
        </c:if>
    </label>
    <label><input type="submit" value="提交"></label>
</form>
<script type="text/javascript">
    const img = document.getElementById("coverImg");
    img.onclick = function () {
        img.src = "BookModifyServlet?m=" + Math.random();
    }
</script>
</body>
</html>
