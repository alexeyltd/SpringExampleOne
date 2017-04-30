<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>


<html>
<head>
    <title>Users</title>
</head>
<body>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>LOGIN</th>
            <th>PASSWORD</th>
            <th>ROLE</th>
            <th>UPDATE</th>
            <th>DELETE</th>
        </tr>
        <%--<c:forEach var="user" items="${listUsers.rows}">--%>
        <c:forEach var="user" items="${list}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.login}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.role}" /></td>
                <td><form action="/admin/update"><input type="submit" value="update"></form></td>
                <td><form action="/admin/delete?id=${user.id}" method="POST"><input type="submit" name="id" value="delete"></form></td>
            </tr>
        </c:forEach>
    </table>
</div>

<br>

<div align="center">
    <a href="/admin/create" target="blank">
        <button>CREATE</button>
    </a>
</div>
</body>
</html>
