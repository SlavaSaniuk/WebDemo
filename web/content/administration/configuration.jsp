<%@ page import="by.bsac.config.ConfigVariables" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.11.18
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%! private String context_path;%>
    <%
        this.context_path = pageContext.getServletContext().getContextPath();
        ConfigVariables.context_path = this.context_path;

    %>
    <title>Configuration</title>
</head>
<body>

</body>
</html>
