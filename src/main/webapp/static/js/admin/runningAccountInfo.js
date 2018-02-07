
function get10Account(){


    var json = new Object();
    json.pageNumber = $("input[name='pageNumber']").val();
    json.pageSize = $("input[name='pageSize']").val();
    json.adminId = -1;

    $.ajax({
        url: "/runAc/getRunningAccount10",
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
                            +' <input type="hidden" name="raId" value="'+d.raId+'"/>'
                            +' <u name="raSn">流水单号：'+d.raSn+'</u>'
                            +' </div>'
                            +' </div>'
                            +'<div class="row">'
                            +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                            +' <u name="raOperater">'+d.raOperater+'</u>'
                            +' </div>'
                            +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                            +' <input type="hidden" name="accountStatus" value="'+d.accountStatus+'"/>'
                            +' <small><strong>'+getRaStatus(d.accountStatus)+'</strong>&nbsp;</small>'
                            +' </div>'
                            +' </div>'
                            +'<div class="row">'
                            +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                            +' <small name="raDate">'+new Date(d.raDate).toLocaleString()+'</small>'
                            +' </div>'
                            +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                            +'<textarea style="display: none" class="detailed">'+JSON.stringify(d.childAvamounts)+'</textarea>'
                            +' <small>￥<em>'+d.raAccount+'</em>&nbsp;</small>'
                            +' </div>'
                            +'</div>'
                            +'</div>'
                            +'</div>';
                    });

                $('.detail .begon').children(".moreDetail").before(temp);

                //每条记录的可点击模态框
                var al = $('.detail .begon').children().not(".moreDetail").children(".alert");
                $(al).click(function(){

                        $("#runningAccountModal   .link").empty();

                        var id = $(this).find("input[name='raId']").val();
                        var raSn = $(this).find("u[name='raSn']").text().substring(5);
                        var accountStatus = $(this).find("input[name='accountStatus']").val();
                        var raStatus = $(this).find("small strong").text();
                        var raOperater = $(this).find("u[name='raOperater']").text();
                        var raDate = $(this).find("small[name='raDate']").text();
                        var raAccount = $(this).find("small em").text();
                        var detail = $(this).find("textarea[class='detailed']").text();
                        var temp ="";

                        if(detail != "" && detail != undefined){

                            var childAvAmounts = JSON.parse(detail);
                            $.each(childAvAmounts,function(i,child){
                                temp +='<hr>'
                                    +'<div class="form-group">'
                                    +'<label  class="col-sm-3 control-label text-danger">订单编码</label>'
                                    +'<div class="col-sm-9">'
                                    +'<input type="hidden" name="orderId" value="'+child.orderId+'">'
                                    +'<strong class="orderSn">'+child.orderSn+'</strong>'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="form-group">'
                                    +'<label  class="col-sm-3 control-label text-danger">资金数额</label>'
                                    +'<div class="col-sm-9">'
                                    +'<input type="hidden" name="avId" value="'+child.avId+'" >'
                                    +'<strong class="avAccount">'+child.avAccount+'</strong>'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="form-group">'
                                    +'<label  class="col-sm-3 control-label text-danger">账单状态</label>'
                                    +'<div class="col-sm-9">'
                                    +'<input type="hidden" name="amountStatus" value="'+child.amountStatus+'" >'
                                    +'<strong class="avStatus">'+getAvStatus(child.amountStatus)+'</strong>'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="form-group">'
                                    +'<label  class="col-sm-3 control-label text-danger">产品名称</label>'
                                    +'<div class="col-sm-9">'
                                    +'<input type="hidden" name="productId" value="'+child.productId+'">'
                                    +'<strong class="productName">'+getProductName(child.productId)+'</strong>'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="form-group">'
                                    +'<label  class="col-sm-3 control-label text-danger">采样包编码</label>'
                                    +'<div class="col-sm-9">'
                                    +'<input type="hidden" name="cybId" value="'+child.cybId+'">'
                                    +'<strong class="cybbm">'+getCybbm(child.cybId)+'</strong>'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="form-group">'
                                    +'<label  class="col-sm-3 control-label text-danger">会员名称</label>'
                                    +'<div class="col-sm-9">'
                                    +'<input type="hidden" name="memberId" value="'+child.memberId+'">'
                                    +'<strong class="memberName">'+getMemberName(child.memberId)+'</strong>'
                                    +'</div>'
                                    +'</div>';;
                            });
                        }
                        $("#runningAccountModal input[name='raId']").val(id);
                        $("#runningAccountModal strong[class='raSn']").text(raSn);
                        $("#runningAccountModal strong[class='raAccount']").text(raAccount);
                        $("#runningAccountModal input[name='accountStatus']").val(accountStatus);
                        $("#runningAccountModal strong[class='raStatus']").text(raStatus);
                        $("#runningAccountModal strong[class='raDate']").text(raDate);
                        $("#runningAccountModal strong[class='adminName']").text(raOperater);

                        $("#runningAccountModal   .link").html(temp);
                        $('#runningAccountModal').modal("show");

                });
            }else{
                $(".moreDetail u").text("暂无数据");
            }
            return false;
        }
    });



}



$(document).ready(function(){
    get10Account();

    //======================================加载更多=======================================
    $(".moreDetail,.moreDetail u").click(function(){
        var flag = $(".moreDetail u").text();
        if(flag != "暂无数据" && flag != "人家也是有底线的"){
            get10Account();
        }

    });

    /**
     * 通过提现
     */
    $(".updateSubmit").click(function(){


        var accountStatus = $(this).parents().find("form").find("input[name='accountStatus']").val();
        if(accountStatus == 1){
            var raId = $(this).parents().find("form").find("input[name='raId']").val();
            var avIdarr = new Array();
            var avs = $(this).parents().find("form").find("input[name='avId']");
            $.each(avs,function(i,av){
                avIdarr.push($(av).val());
            });

            $.ajax({
                url: "/runAc/changeRa",
                type: "post",
                traditional: true,
                async:false,
                data: {raId:raId,avArr:avIdarr},
                success: function (data) {
                    if(data == "success"){
                        notifyMsgSuccess("本条提现申请已经通过");
                    }else{
                        notifyMsgError("本条提现申请通过失败,请检查本条流水帐中各个订单状态");
                    }

                    $(".moreDetail u").text("...加载更多...");
                    $("input[name='pageNumber']").val("0");
                    $("input[name='pageSize']").val("10");
                    $('.detail .begon').children().not(".moreDetail").remove();
                    get10Account();

                }
            });
        }else{
            notifyMsgWarning("本条提现申请不符合提现条件，无法通过提现");
        }

        $('#runningAccountModal').modal("hide");

    });


});