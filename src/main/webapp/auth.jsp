<%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 1/20/19
  Time: 1:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <jsp:include page="views/styles.html"/>
</head>
<body class="gradient-body">
<jsp:include page="views/header.jsp"/>
<div class="auth-form">
    <div class="auth-form-header">USER LOGIN</div>
    <form method="post" action="auth">
        <div class="auth-form-fields">
            <div class="auth-form-field">
                <i class="fa fa-user"></i>
                <input type="text" name="username" placeholder="username" class="auth-form-input"/>
            </div>
            <div class="auth-form-fields-separator"></div>
            <div class="auth-form-field">
                <i class="fa fa-unlock-alt"></i>
                <input type="password" name="password" placeholder="password" class="auth-form-input"/>
            </div>
        </div>
            <button type="submit" class="auth-form-button">Login</button>
            <a class="auth-form-help" href="help.jsp">
                <i class="fa fa-question"></i>
            </a>
    </form>
</div>
</body>
</html>
