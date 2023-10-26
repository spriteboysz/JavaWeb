<%@ page import="com.deean.dto.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Deean
  Date: 2023-10-26
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>
<table border="1" align="center" cellspacing="0">
    <caption>图书列表</caption>
    <tr>
        <td>图书编号</td>
        <td>图书名称</td>
        <td>图书作者</td>
        <td>图书价格</td>
        <td>图书描述</td>
        <td>图书库存</td>
    </tr>
    <% for (Book book : books) {%>
    <tr>
        <td><%=book.getBookNum()%>
        </td>
        <td><%=book.getBookName()%>
        </td>
        <td><%=book.getBookAuthor()%>
        </td>
        <td><%=book.getBookPrice()%>
        </td>
        <td><%=book.getBookDesc()%>
        </td>
        <td><%=book.getBookStock()%>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
