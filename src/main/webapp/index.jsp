<%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 2/7/19
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="g" tagdir="/WEB-INF/tags" %>

<g:genericpage>

    <jsp:attribute name="head">
        <jsp:include page="views/styles.html"/>
    </jsp:attribute>

    <jsp:attribute name="header">
        <jsp:include page="views/header.jsp"/>
    </jsp:attribute>

    <jsp:body>
        <h2>Index page</h2>
    </jsp:body>

</g:genericpage>