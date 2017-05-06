<%--
  Created by IntelliJ IDEA.
  User: alexeypavlenko
  Date: 22/04/2017
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Users</title>
</head>
<body>

<form action="/admin/create" method="POST">
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="password"/>
    Role: <input type="text" name="role"/>
    <input type="submit" value="Submit">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

</body>
</html>
