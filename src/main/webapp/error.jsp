<%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 2/7/19
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link type="text/css" href="static/styles/error.css" rel="stylesheet"/>
</head>
<body class="error-body">
    <div class="error-message-wrapper">
        <div class="error-message-title">
            <span><%= request.getAttribute("title") %></span>
        </div>
        <div class="error-message-separator"></div>
        <div class="error-message-body">
            <span><%= request.getAttribute("body") %></span>
        </div>
    </div>
</body>
</html>
