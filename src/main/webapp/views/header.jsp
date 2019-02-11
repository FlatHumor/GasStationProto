<%@ page import="by.flathumor.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 2/11/19
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String displayUsername = "Not logged";
    User user = (User) request.getSession().getAttribute("user");
    if (user != null)
        displayUsername = user.getUsername();
%>

<header class="header">

    <div class="pull-right">
        <i class="fa fa-user"></i>
        <a href="#"><% out.print(displayUsername); %></a>
    </div>
</header>
