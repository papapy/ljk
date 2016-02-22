<%--
  Created by XKey - 2016/1/26 16:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/comm/taglib.jsp"%>

<html>
<head>
    <title>Exception!</title>
</head>
<body>

<%
    Exception e = (Exception) request.getAttribute("exception");
    e.getMessage();
%>
<h2>${exception.message}<%=e.getMessage()%></h2>
<% e.printStackTrace(new java.io.PrintWriter(out)); %>
</body>
</html>
