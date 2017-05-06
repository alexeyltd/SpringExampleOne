<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/static/css/dashboard.css" rel="stylesheet">
    <link href="/static/css/mod.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style id="holderjs-style" type="text/css"></style><style></style></head>

<body style="">

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Logout</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <%--<ul class="nav nav-sidebar">--%>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="/admin">Admin</a></li>
                <li><a href="/user">User</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">Admin Panel</h2>
            <div class="table-responsive">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#userTable" data-toggle="tab">User table</a></li>
                    <li><a href="#newUser" data-toggle="tab">New User</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="userTable">
                        <div class="panel panel-default">
                            <div class="panel-heading">All users</div>
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Role</th>
                                    <th>Login</th>
                                    <th>Password</th>
                                    <th>Edit</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${list}">
                                        <tr>
                                            <td><c:out value="${user.id}" /></td>

                                            <div class="modal fade" id="${user.id}" tabindex="${user.id}" role="dialog" aria-labelledby="myModalLabel">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                            <h4 class="modal-title" id="title${user.id}">Edit user ${user.login} ${user.password}</h4>
                                                        </div>
                                                        <div class="modal-body ">
                                                            <form id="form${user.id}" action="/admin/update" method="POST">
                                                                ID:
                                                                <br>
                                                                <input type="text" name="idUser" value="${user.id}"/>
                                                                <br>
                                                                Login:
                                                                <br>
                                                                <input type="text" name="login" value="${user.login}"/>
                                                                <br>
                                                                Password:
                                                                <br>
                                                                <input type="password" name="password" value="${user.password}"/>
                                                                <br>
                                                                Role:
                                                                <br>
                                                                <input type="text" name="role" value="USER"/>
                                                            </form>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                                                            <button form="form${user.id}" type="submit" class="btn btn-primary">Edit user</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <td><c:out value="${user.roles}" /></td>
                                            <td><c:out value="${user.login}" /></td>
                                            <td><c:out value="${user.password}" /></td>
                                            <td><button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#${user.id}">Edit</button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane" id="newUser">
                        <div class="panel panel-default">
                            <div class="panel-heading">All users</div>
                            <form id="addNewUser" action="/admin/create" method="POST">
                                Login:
                                <br>
                                <input type="text" name="login"/>
                                <br>
                                Password:
                                <br>
                                <input type="password" name="password"/>
                                <br>
                                Role:
                                <br>
                                <input type="text" name="role"/>
                            </form>

                            <button form="addNewUser" type="submit" class="btn btn-success">Add new user</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/docs.min.js"></script>

</body></html>
