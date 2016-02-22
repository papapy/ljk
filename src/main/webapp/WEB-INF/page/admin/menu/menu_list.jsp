<%--
  Created by XKey - 2016/1/18 17:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/comm/taglib.jsp"%>

<h1 class="page-header">菜单管理</h1>
<a href="javascript: void(0);" onclick="$('#main').load('${ctx}/admin/menu/initEdit')">新增</a>
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
        <tbody>
            <c:forEach items="${records}" var="item">
                <tr>
                    <td>${item.menuSort}</td>
                    <td>${item.menu.menuName}</td>
                    <td>${item.menuName}</td>
                    <td>${item.menuDepcit}</td>
                    <td>${item.menuUrl}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
