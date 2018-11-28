<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.11.18
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!-- JSP variables -->
    <%!
        private String context_path; //Contain path to context
    %>

    <!-- Initialization of JSP variables -->
    <%
        context_path = pageContext.getServletContext().getContextPath(); //Get context path
    %>

    <!-- Import styles -->
    <link rel="stylesheet" href="<%=context_path%>/styles/template.css"> <!-- Content style -->
    <link rel="stylesheet" href="<%=context_path%>/styles/site_header.css"> <!-- Header style -->


    <title> Account settings </title>
</head>
<body>

    <!-- Include header to current JSP -->
    <%@include file="/content/content_page_elements/site_header.jsp"%>

</body>
</html>
