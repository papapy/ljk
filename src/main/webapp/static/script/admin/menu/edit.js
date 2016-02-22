/**
 * 菜单编辑
 * Created by XKey on 2016/1/26.
 */

$(function() {
    $('button').click(function(e) {
        $.ajax({
            url: ctx + '/admin/menu/moa',
            data: $(e.target).closest('form').serialize(),
            success: function(data) {
                if(data.code == 200) {
                    $('#main').load(ctx + sessionStorage.mainUrl);
                }
            }
        });
    });
});