<%@ tag description="Generic page" pageEncoding="UTF-8" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="title" fragment="true" %>

<html>
<head>
    <title>
        <jsp:invoke fragment="title"/>
    </title>
    <jsp:invoke fragment="head"/>
</head>
<body>
    <jsp:invoke fragment="header"/>
<div class="content">
    <jsp:doBody/>
</div>
<footer>
    <jsp:invoke fragment="footer"/>
</footer>
</body>
</html>
