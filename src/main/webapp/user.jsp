<%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 2/18/19
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="g" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="user" class="by.flathumor.entity.User" scope="session"/>

<g:genericpage>
    <jsp:attribute name="title">${user.username}</jsp:attribute>
    <jsp:attribute name="head">
        <jsp:include page="views/styles.html"/>
    </jsp:attribute>
    <jsp:attribute name="header">
        <jsp:include page="views/header.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="profile-wrapper">
            <div class="userpic">
                <img class="userpic-image" src="static/img/default-user.png"/>
            </div>
            <div class="profile-content">
                <h2>${user.person.fullName}</h2>
            </div>
        </div>
    </jsp:body>
</g:genericpage>
