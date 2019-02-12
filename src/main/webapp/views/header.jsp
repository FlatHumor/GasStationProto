<%@ page import="by.flathumor.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 2/11/19
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="header">
    <jsp:useBean id="user" class="by.flathumor.entity.User" scope="session"/>
    <div class="left-side">
        <a href="/" class="header-logo"></a>
    </div>
    <div class="right-side">
        <div>
            <i class="fa fa-user"></i>
            <a href="/user/notimplemented">${user.username}</a>
        </div>
    </div>
</header>
