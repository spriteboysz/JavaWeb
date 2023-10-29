<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title></title>
</head>
<body>
<h3>图书信息列表</h3>
<table width="90%" align="center" border="1" cellspacing="0">
    <tr>
        <th>图书编号</th>
        <th>图书封面</th>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>图书价格</th>
        <th>图书库存</th>
        <th>图书描述</th>
        <th>图书类型</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td><img src="${book.bookCover}" alt="" height="50"></td>
            <td>${book.bookName}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.bookPrice}</td>
            <td>${book.bookStock}</td>
            <td>${book.bookDesc}</td>
            <td>
                <c:if test="${book.bookType==1}">原创</c:if>
                <c:if test="${book.bookType==2}">翻译</c:if>
            </td>
            <td>
                <a href="BookModifyServlet?bookId=${book.bookId}">修改</a>
                <a href="BookRemoveServlet?bookId=${book.bookId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
