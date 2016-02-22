<%--
  Created by XKey - 2016/1/7 16:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/comm/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${ctx}/admin/user/save" method="post">
    <input type="hidden" name="userId" value="${user.userId}">
    <input name="userAccount" value="${user.userAccount}">
    <input name="userPassword" value="${user.userPassword}">
    <button type="submit" value="提交"/>
    <%--<button type="button" value="返回" onclick="history.go(-1);"/>--%>
</form>

</body>
</html>
