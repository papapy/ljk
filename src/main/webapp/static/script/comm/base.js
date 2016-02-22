/**
 * 基础脚本方法
 * Created by XKey on 2016/1/26.
 */


// jquery扩展
(function() {
    $.extend($.fn, {
        formSubmit: function() {
            var f = $(this).closest('form'), actionUrl = $(f).attr('action');
            $.ajax({
                url: ctx + actionUrl,
                data: $(f).serialize(),
                success: function(data) {
                    if(data.code == 200) {
                        $('#main').load(ctx + sessionStorage.mainUrl);
                    }
                }
            });
        },
        formInitData: function(formData) { // 表单数据回填（json格式）
            formData = JSON.parse(formData);
            var key, value, tagName, type, arr;
            for(x in formData) {
                key = x;
                value = formData[x];

                $(this).find("[name='"+key+"'],[name='"+key+"[]']").each(function(){
                    tagName = $(this)[0].tagName;
                    type = $(this).attr('type');
                    if(tagName=='INPUT'){
                        if(type=='radio'){
                            $(this).attr('checked',$(this).val()==value);
                        }else if(type=='checkbox'){
                            if(value && value != '') {
                                arr = value.toString().split(',');
                                for(var i =0;i<arr.length;i++){
                                    if($(this).val()==arr[i]){
                                        $(this).attr('checked',true);
                                        break;
                                    }
                                }
                            }
                        }else{
                            $(this).val(value);
                        }
                    }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
                        $(this).val(value);
                    }
                });
            }
        }
    })
})(jQuery);

//设置jQuery Ajax全局的参数
$.ajaxSetup({
    type : 'POST',
    error : function(jqXHR, textStatus, errorThrown) {
        switch (jqXHR.status) {
            /*case (500):
                alert("服务器系统内部错误");
                break;*/
            case (400):
                alert("数据格式或类型不匹配，请检查数据项");
                break;
            case (401):
                alert("未登录或登录超时，请重新登录。", function() { window.location.href = '${ctx}'; });
                break;
            case (403):
                alert("无权限执行此操作");
                break;
            case (408):
                alert("请求超时");
                break;
            case (900):
                alert("你没有权限访问该菜单，请联系管理员！");
                break;
            default:
                ;
        }
    }
});