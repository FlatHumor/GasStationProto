<%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 2/7/19
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Help</title>
    <jsp:include page="views/styles.html"/>
</head>
<body>
<jsp:include page="views/header.jsp"/>
    <div>
        Help page will be here.
    </div>
<jsp:useBean id="user" class="by.flathumor.entity.User"/>


<input value="${user.username}"/>
<input value="${user.password}"/>
</body>
</html>
