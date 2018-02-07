
function get10Promocode(){


    var json = new Object();
    json.pageNumber = $("input[name='pageNumber']").val();
    json.pageSize = $("input[name='pageSize']").val();
    json.adminId = -1;

    $.ajax({
        url: "/promocode/getPromocode10",
        type: "post",
        traditional: true,
        async:false,
        data: json,
        success: function (data) {
            if(data != null && data != ""){
                var temp = "";
                //当前页
                if(data.content.length <10){
                    $("input[name='pageNumber']").val(data.number);
                    if(data.content.length == 0){
                        $(".moreDetail u").text("暂无数据");
                    }else{
                        $(".moreDetail u").text("人家也是有底线的");
                    }
                }else{
                    $("input[name='pageNumber']").val(parseInt(data.number)+1);
                    $(".moreDetail u").text("...加载更多...");
                }
                //当前页多少条
                $("input[name='pageSize']").val(data.size);
                //循环分页的content,就是一个List


                $.each(data.content,function(i,d){

                    temp += '<div class="row">'
                        +'<div class="alert alert-info">'
                        +'<div class="row">'
                        +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left beAfter">'
                        +' <input type="hidden" name="codeId" value="'+d.codeId+'"/>'
                        +' <input type="hidden" name="adminId" value="'+d.adminId+'"/>'
                        +' <u name="adminName">'+d.adminName+'</u>'
                        +' </div>'
                        +' </div>'
                        +'<div class="row">'
                        +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                        +' <u name="promocodeStr">'+d.promocodeStr+'</u>'
                        +' </div>'
                        +' </div>'
                        +'<div class="row">'
                        +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                        +' <small name="codeDate">'+new Date(d.codeDate).toLocaleString()+'</small>'
                        +' </div>'
                        +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                        +' <small>折扣率：<em>'+d.promoDiscount+'</em>&nbsp;</small>'
                        +' </div>'
                        +'</div>'
                        +'</div>'
                        +'</div>';
                });

                $('.detail .begon').children(".moreDetail").before(temp);

                //每条记录的可点击模态框
                var al = $('.detail .begon').children().not(".moreDetail").children(".alert");
                $(al).click(function(){

                    var codeId = $(this).find("input[name='codeId']").val();
                    var adminId = $(this).find("input[name='adminId']").val();
                    var adminName = $(this).find("u[name='adminName']").text();
                    var promocodeStr = $(this).find("u[name='promocodeStr']").text();
                    var codeDate = $(this).find("small[name='codeDate']").text();
                    var promoDiscount = $(this).find("small em").text();

                    $("#promocodeModal input[name='codeId']").val(codeId);
                    $("#promocodeModal input[name='adminId']").val(adminId);
                    $("#promocodeModal strong[class='adminName']").text(adminName);
                    $("#promocodeModal strong[class='promocodeStr']").text(promocodeStr);
                    $("#promocodeModal strong[class='codeDate']").text(codeDate);
                    $("#promocodeModal input[name='promoDiscount']").val(promoDiscount);

                    $('#promocodeModal').modal("show");

                });
            }else{
                $(".moreDetail u").text("暂无数据");
            }
            return false;
        }
    });



}



$(document).ready(function(){
    get10Promocode();

    //======================================加载更多=======================================
    $(".moreDetail,.moreDetail u").click(function(){
        var flag = $(".moreDetail u").text();
        if(flag != "暂无数据" && flag != "人家也是有底线的"){
            get10Promocode();
        }

    });

    /**
     * 更改优惠折扣率
     */
    $(".updateSubmit").click(function(){



            var codeId = $(this).parents().find("form").find("input[name='codeId']").val();
            var promoDiscount = $(this).parents().find("form").find("input[name='promoDiscount']").val();


            $.ajax({
                url: "/promocode/updatePromoStr",
                type: "post",
                traditional: true,
                async:false,
                data: {codeId:codeId,promoDiscount:promoDiscount},
                success: function (data) {
                    if(data == "success"){
                        notifyMsgSuccess("更新成功");
                    }else if(data == "fail"){
                        notifyMsgError("更新失败");
                    }else{
                        notifyMsgError("折扣率应该在0-1之间，更新失败");
                    }

                    $(".moreDetail u").text("...加载更多...");
                    $("input[name='pageNumber']").val("0");
                    $("input[name='pageSize']").val("10");
                    $('.detail .begon').children().not(".moreDetail").remove();
                    get10Promocode();

                }
            });

        $('#promocodeModal').modal("hide");

        return;

    });


});