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
    <link type="text/css" href="static/styles/bootstrap.min.css" rel="stylesheet"/>
    <link type="text/css" href="static/styles/custom_auth.css" rel="stylesheet"/>
    <link type="text/css" href="static/styles/font-awesome.css" rel="stylesheet"/>
</head>
<body class="gradient-body">
<%
    String uid = (String) request.getSession().getAttribute("username");
    String uidLink = "";
    if (uid != null) {
        uidLink = uid;
    }
%>
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
            <a class="auth-form-help" href="help">
                <i class="fa fa-question"></i>
            </a>
    </form>
</div>
</body>
</html>
