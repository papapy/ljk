<%--
  Created by XKey - 2016/1/18 17:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/comm/taglib.jsp"%>

<h1 class="page-header">用户管理</h1>
<a href="${ctx}/admin/user/initEdit">新增</a>
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>排序</th>
                <th>上级</th>
                <th>名称</th>
                <th>描述</th>
                <th>目标地址</th>
                <th>操作</th>
            </tr>
        </thead>
        <c:forEach items="${records}" var="record">
            <tr>
                <td>${record.userId}</td>
                <td>${record.userAccount}</td>
            </tr>
        </c:forEach>
    </table>
</div>