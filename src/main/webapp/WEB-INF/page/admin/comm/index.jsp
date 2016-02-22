<%--
  Created by XKey - 2016/1/19 16:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/comm/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/css/dashboard.css">
    <%--<link rel="stylesheet" href="${ctx}/static/css/styles.css">--%>
</head>
<body>
    <header class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand">Project name</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Settings</a></li>
                </ul>
            </div>
        </div>
    </header>

    <%--=============================分割线==================================================================================================--%>

    <div class="container-fluid">
        <div class="row-fluid">
            <nav class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <c:forEach items="${menus}" var="item">
                        <li>
                            <a href="javascript:;" <c:if test="${empty item.menus}">onclick="refreshMain('${item.menuUrl}')"</c:if>>${item.menuName}</a>
                        </li>
                        <c:if test="${!empty item.menus}">
                            <ul>
                                <c:forEach items="${item.menus}" var="secondMenu">
                                    <li>
                                        <a href="javascript:;" onclick="refreshMain('${secondMenu.menuUrl}')">${secondMenu.menuName}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </c:forEach>
                </ul>
            </nav>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
                <%--<div class="btn-toolbar">
                    <button class="l_tab_btn l_tab_left">
                        <i class="glyphicon glyphicon-backward"></i>
                    </button>
                    <div class="l_tab_menu">
                        <button class="l_tab_btn">首页</button>
                    </div>
                    <button class="l_tab_btn l_tab_right">
                        <i class="glyphicon glyphicon-forward"></i>
                    </button>
                    <div class="btn-group">
                        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">关闭操作<span class="caret"></span></button>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li>
                                <a>定位当前选项卡</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a>关闭全部选项卡</a>
                            </li>
                            <li>
                                <a>关闭其他选项卡</a>
                            </li>
                        </ul>
                    </div>
                </div>--%>
                <div id="main">
                    <h2>
                        标题
                    </h2>
                </div>
            </div>
        </div>
    </div>

    <script src="${ctx}/static/js/jquery.min.js"></script>
    <script src="${ctx}/static/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/script/comm/base.js"></script>
<script>
function refreshMain(url) {
    sessionStorage.mainUrl = url;
    $('#main').load('${ctx}' + url);
}
</script>
</body>
</html>
