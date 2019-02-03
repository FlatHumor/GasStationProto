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
    <link type="text/css" href="static/styles/bootstrap.min.css" rel="stylesheet"/>
    <link type="text/css" href="static/styles/custom_auth.css" rel="stylesheet"/>
</head>
<body>
<div class="auth-form">
    <form method="post" action="auth">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp"
                   placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
