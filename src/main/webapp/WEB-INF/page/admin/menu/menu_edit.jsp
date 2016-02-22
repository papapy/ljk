<%--
  Created by XKey - 2016/1/18 20:03
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/comm/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="${ctx}/static/assets/plugin/switch/css/bootstrap3/bootstrap-switch.min.css">
<link rel="stylesheet" href="${ctx}/static/assets/plugin/chosen/css/chosen.min.css">
<div>
    <form action="${ctx}/admin/menu/moa" method="post" class="form-horizontal">
        <input type="hidden" name="menuId" value="${record.menuId}">
        <div class="form-group">
            <label class="col-sm-2 control-label">上级</label>
            <div class="col-sm-8">
                <select name="menuParent" class="form-control">
                    <option value="">请选择</option>
                    <c:forEach items="${topMenus}" var="item">
                        <option value="${item.menuId}" <c:if test="${item.menuId eq record.menuParent}">selected</c:if>>${item.menuName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">状态</label>
            <div class="col-sm-8 switch" style="height: 26px;">
                <input type="checkbox" name="menuIsDel" value="0" data-size="small" <c:if test="${record.menuIsDel ne 1}">checked</c:if>>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">名称</label>
            <div class="col-sm-8">
                <input name="menuName" value="${record.menuName}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">地址</label>
            <div class="col-sm-8">
                <input name="menuUrl" value="${record.menuUrl}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <button type="button" class="btn btn-primary" onclick="$(this).formSubmit()">保存</button>
                <button type="button" class="btn btn-white">取消</button>
            </div>
        </div>
    </form>
</div>

<script src="${ctx}/static/assets/plugin/switch/js/bootstrap-switch.min.js"></script>
<script src="${ctx}/static/assets/plugin/chosen/js/chosen.jquery.min.js"></script>
<script>
$(function() {
    $('[name="menuParent"]').chosen({width : '174px', disable_search_threshold : 5, search_contains : true});
    $('[name="menuIsDel"]').bootstrapSwitch();
});
</script>