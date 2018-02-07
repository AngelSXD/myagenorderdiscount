var time = false;

/**
 * 转化后台毫秒值 正常显示时间格式
 * @returns {string}
 */
Date.prototype.toLocaleString = function() {
    return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日  " + this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds();
};
/**
 * 设定标题特效
 * @param currentValue
 */
function currentValueDeal(currentValue){
    if("time" == currentValue){
        time = true;
        $(".currentValue").val("history");
    }
    var textVal = $("li[role='presentation']  a[class="+currentValue+"] ").text();
    $("li[role='presentation'] a[class="+currentValue+"] ").html('<strong class="text-warning">'+textVal+'</strong>');
    currentValue = $(".currentValue").val();
    return currentValue;
}


/**
 *
 * @param currentValue  当前状态标记
 * @param oldMark       原本状态标记
 */
function get10Account(currentValue,oldMark){
    var url = "";
    if("esDiscount" == currentValue){
        url = "/runAc/getEsAmount10";
    }
    if("avDiscount" == currentValue){
        url = "/runAc/getAvAmount10";
    }
    if("history" == currentValue){
        url = "/runAc/getRunningAccount10";
    }
    //如果 当前状态标记 和 原本状态标记 不一致的话 则初始化分页信息
    if(currentValue != oldMark){
        $("input[name='pageNumber']").val(0);
        $("input[name='pageSize']").val(10);

        $('.detail .begon').children().not(".moreDetail").remove();
        $(".moreDetail u").text("...加载更多...");
    }

    var json = new Object();
    json.pageNumber = $("input[name='pageNumber']").val();
    json.pageSize = $("input[name='pageSize']").val();
    json.adminId = $(".adminId").text();
    if(time == true){
        json.startTime = startDate;
        json.endTime = endDate;
        time = false;
    }

    $.ajax({
        url: url,
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

                if("esDiscount" == currentValue){
                    $.each(data.content,function(i,d){
                        temp += '<div class="row">'
                            +'<div class="alert '+(d.esAccount<0? 'alert-danger':'alert-info')+'">'
                            +'<div class="row">'
                            +' <div class="col-lg-8 col-sm-12 col-md-12 col-xs-12 text-left">'
                            +' <input type="hidden" name="Id" value="'+d.esId+'"/>'
                            +' <u name="orderSn">订单编号：'+d.orderSn+'</u>'
                            +' </div>'
                            +' </div>'
                            +'<div class="row">'
                            +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                            +' <u name="esOperater">'+d.esOperater+'</u>'
                            +' </div>'
                            +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                            +' <small><strong>'+d.esCre1+'</strong>&nbsp;</small>'
                            +' </div>'
                            +' </div>'
                            +'<div class="row">'
                            +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                            +' <small name="esDate">'+new Date(d.esDate).toLocaleString()+'</small>'
                            +' </div>'
                            +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                            +' <input type="hidden" name="detailed" value="'+d.orderId+'~'+d.adminId+'~'+d.productId+'~'+d.memberId+'~'+d.cybId+'~'+'"/>'
                            +' <small>￥<em>'+d.esAccount+'</em>&nbsp;</small>'
                            +' </div>'
                            +'</div>'
                            +'</div>'
                            +'</div>';
                    });
                }
                if("avDiscount" == currentValue){
                    $.each(data.content,function(i,d){
                        temp += '<div class="row">'
                            +'<div class="alert '+(d.avAccount<0? 'alert-danger':'alert-info')+'">'
                            +'<div class="row">'
                            +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left beAfter">'
                            +' <input type="hidden" name="Id" value="'+d.avId+'"/>'
                            +' <u name="orderSn">订单编号：'+d.orderSn+'</u>'
                            +' </div>'

                            +' </div>'
                            +'<div class="row">'
                            +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                            +' <u name="avOperater">'+d.avOperater+'</u>'
                            +' </div>'
                            +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                            +' <input type="hidden" name="amountStatus" value="'+d.amountStatus+'"/>'
                            +' <small><strong>'+getAvStatus(d.amountStatus)+'</strong>&nbsp;</small>'
                            +' </div>'
                            +' </div>'
                            +'<div class="row">'
                            +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                            +' <small name="avDate">'+new Date(d.avDate).toLocaleString()+'</small>'
                            +' </div>'
                            +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                            +' <input type="hidden" name="detailed" value="'+d.orderId+'~'+d.adminId+'~'+d.productId+'~'+d.memberId+'~'+d.cybId+'~'+'"/>'
                            +' <small>￥<em>'+d.avAccount+'</em>&nbsp;</small>'
                            +' </div>'
                            +'</div>'
                            +'</div>'
                            +'</div>';
                    });
                }
                if("history" == currentValue){
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
                }


                $('.detail .begon').children(".moreDetail").before(temp);


                //每条记录的可点击模态框
                var al = $('.detail .begon').children().not(".moreDetail").children(".alert");
                $(al).click(function(){
                    if("esDiscount" == currentValue){
                        var id = $(this).find("input[name='Id']").val();
                        var orderSn = $(this).find("u[name='orderSn']").text().substring(5);
                        var esOperater = $(this).find("u[name='esOperater']").text();
                        var esDate = $(this).find("small[name='esDate']").text();
                        var esAccount = $(this).find("small em").text();
                        var esStatus = $(this).find("small strong").text();
                        var detail = $(this).find("input[name='detailed']").val();

                        var orderId = "";
                        var adminId = "";
                        var adminName = "";
                        var productId = "";
                        var productName = "";
                        var memberId = "";
                        var memberName = "";
                        var cybId = "";
                        var cybbm = "";

                        var arr = new Array();
                        arr = detail.split("~");
                        for(var i = 0; i<arr.length ; i++){
                            if(i==0){
                                orderId = arr[i];
                            }
                            if(i == 1){
                                adminId = arr[i];
                            }
                            if(i == 2){
                                productId = arr[i];
                            }
                            if(i == 3){
                                memberId = arr[i];
                            }
                            if(i == 4){
                                cybId = arr[i];
                            }
                        }
                        adminName = getAdminName(adminId);
                        productName = getProductName(productId);
                        memberName = getMemberName(memberId);
                        cybbm = getCybbm(cybId);

                        $("#esdetailModal input[name='esId']").val(id);
                        $("#esdetailModal strong[class='esAccount']").text(esAccount);




                        $("#esdetailModal strong[class='esStatus']").text(esStatus);
                        $("#esdetailModal strong[class='esDate']").text(esDate);
                        $("#esdetailModal input[name='adminId']").val(adminId);
                        $("#esdetailModal strong[class='adminName']").text(adminName);
                        $("#esdetailModal input[name='productId']").val(productId);
                        $("#esdetailModal strong[class='productName']").text(productName);
                        $("#esdetailModal input[name='cybId']").val(cybId);
                        $("#esdetailModal strong[class='cybbm']").text(cybbm);
                        $("#esdetailModal input[name='orderId']").val(orderId);
                        $("#esdetailModal strong[class='orderSn']").text(orderSn);
                        $("#esdetailModal input[name='memberId']").val(memberId);
                        $("#esdetailModal strong[class='memberName']").text(memberName);
                        $("#esdetailModal strong[class='esOperater']").text(esOperater);

                        $('#esdetailModal').modal("show");
                    }
                    if("avDiscount" == currentValue){
                        var id = $(this).find("input[name='Id']").val();
                        var orderSn = $(this).find("u[name='orderSn']").text().substring(5);
                        var amountStatus = $(this).find("input[name='amountStatus']").val();
                        var avStatus = $(this).find("small strong").text();
                        var avOperater = $(this).find("u[name='avOperater']").text();
                        var avDate = $(this).find("small[name='avDate']").text();
                        var avAccount = $(this).find("small em").text();
                        var detail = $(this).find("input[name='detailed']").val();

                        var orderId = "";
                        var adminId = "";
                        var adminName = "";
                        var productId = "";
                        var productName = "";
                        var memberId = "";
                        var memberName = "";
                        var cybId = "";
                        var cybbm = "";

                        var arr = new Array();
                        arr = detail.split("~");
                        for(var i = 0; i<arr.length ; i++){
                            if(i==0){
                                orderId = arr[i];
                            }
                            if(i == 1){
                                adminId = arr[i];
                            }
                            if(i == 2){
                                productId = arr[i];
                            }
                            if(i == 3){
                                memberId = arr[i];
                            }
                            if(i == 4){
                                cybId = arr[i];
                            }
                        }
                        adminName = getAdminName(adminId);
                        productName = getProductName(productId);
                        memberName = getMemberName(memberId);
                        cybbm = getCybbm(cybId);

                        $("#avdetailModal input[name='avId']").val(id);
                        $("#avdetailModal strong[class='avAccount']").text(avAccount);
                        $("#avdetailModal input[name='amountStatus']").val(amountStatus);
                        $("#avdetailModal strong[class='avStatus']").text(avStatus);
                        $("#avdetailModal strong[class='avDate']").text(avDate);
                        $("#avdetailModal input[name='adminId']").val(adminId);
                        $("#avdetailModal strong[class='adminName']").text(adminName);
                        $("#avdetailModal input[name='productId']").val(productId);
                        $("#avdetailModal strong[class='productName']").text(productName);
                        $("#avdetailModal input[name='cybId']").val(cybId);
                        $("#avdetailModal strong[class='cybbm']").text(cybbm);
                        $("#avdetailModal input[name='orderId']").val(orderId);
                        $("#avdetailModal strong[class='orderSn']").text(orderSn);
                        $("#avdetailModal input[name='memberId']").val(memberId);
                        $("#avdetailModal strong[class='memberName']").text(memberName);
                        $("#avdetailModal strong[class='avOperater']").text(avOperater);

                        $('#avdetailModal').modal("show");
                    }
                    if("history" == currentValue){

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
                    }
                });
            }else{
                $(".moreDetail u").text("暂无数据");
            }
            return false;
        }
    });



}

function  initData(mark,oldMark) {
    $('.detail .begon').children().not(".moreDetail").remove();
    $("input[name='pageNumber']").val(0);
    $("input[name='pageSize']").val(10);
    get10Account(mark,oldMark);
}


$(document).ready(function(){

    //设定标题特效
    var currentValue = $(".currentValue").val();
    currentValue = currentValueDeal(currentValue);
    //页面初始化数据
    get10Account(currentValue,currentValue);

    /**
     *页面头部按钮列表 监听事件
     */
    $("li[role='presentation'] a").click(function(){
        var mark = $(this).attr("class");
        var oldText = $("li[role='presentation'] a strong").text();
        var oldMark = $("li[role='presentation'] a strong").parent().attr("class");
        if(mark!="withdraw"){
            //取消 原本的标题特效
            $("li[role='presentation'] a[class="+oldMark+"] ").html(oldText);
            //设定新的标题特效
            $(".currentValue").val(mark);
            currentValueDeal(mark);
        }else{
            //否则 是提现按钮
            if(oldMark == "avDiscount"){

                var allChecks = $(".beDel").find("input[name='Id']");
                var asIdArr = new Array();
                $.each(allChecks,function(i,checkA){
                    asIdArr.push($(checkA).val());
                });
                if(asIdArr.length > 0){
                    mark = oldMark;
                    $.ajax({
                        url: "/runAc/withdraw",
                        type: "post",
                        traditional: true,
                        async: false,
                        data: {asAccountIds:asIdArr},
                        success: function (data) {
                            if(data != null){
                                for(var key in data){
                                    if(data[key] == "success"){
                                        notifyMsgSuccess("订单编号："+key+"提现成功，请在【历史提现记录】查看");
                                    }else{
                                        notifyMsgError("订单编号："+key+"提现失败，请确认后重新提交");
                                    }
                                }
                            }
                        }
                    });
                }else{
                    notifyMsgWarning("暂无订单挂载提现");
                    return false;
                }
            }else{
                notifyMsgWarning("请在可提现订单页面挂载提现后操作");
                return false;
            }
        }

        //重复点击 需要重新初始化整个页面
        initData(mark,oldMark);
    });

    //======================================加载更多=======================================
    $(".moreDetail,.moreDetail u").click(function(){
        var flag = $(".moreDetail u").text();
        if(flag != "暂无数据" && flag != "人家也是有底线的"){
            var mark = $(".currentValue").val();
            get10Account(mark,mark);
        }

    });

    //======================================挂载提现=======================================
    $(".canDiscount").click(function(){

        var asId = $("#avdetailModal").find("input[name='avId']").val();
        var orderSn = $("#avdetailModal").find(".orderSn").text();
        var amountStatus = $("#avdetailModal").find("input[name='amountStatus']").val();
        if(amountStatus != 1){
            notifyMsgError("订单编号："+orderSn+"不可提现")
        }else{
            var temp = ' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right beDel">'
                +' <input type="hidden" name="Id" value="'+asId+'"/>'
                +'<span class="glyphicon glyphicon-check" aria-hidden="true"></span>'
                +' </div>';

            var aa = $(".beAfter input[value='"+asId+"']").parent().siblings(".beDel");
            if($(aa)[0] == undefined){
                $(".beAfter input[value='"+asId+"']").parent().after(temp);
                $('#avdetailModal').modal('hide');
                notifyMsgSuccess("订单编号："+orderSn+"挂载成功，请点击右上角-提现-进行提现操作");
            }else{
                notifyMsgError("订单编号："+orderSn+"不能重复挂载");
            }
        }

    });
    //======================================确认到账=======================================
    $(".confirm").click(function () {
        var asId = $("#avdetailModal").find("input[name='avId']").val();
        var orderSn = $("#avdetailModal").find(".orderSn").text();
        var amountStatus = $("#avdetailModal").find("input[name='amountStatus']").val();
        if(amountStatus == 3){
            $.ajax({
                url: "/runAc/confirm",
                type: "post",
                traditional: true,
                async: false,
                data: {asId:asId},
                success: function (data) {
                    if(data == "success"){
                        notifyMsgSuccess("订单编号："+orderSn+"确认到账，操作成功");
                    }else{
                        notifyMsgError("订单编号："+orderSn+"确认到账，操作失败");
                    }
                    initData("avDiscount","avDiscount");
                    $('#avdetailModal').modal('hide');

                    return false;

                }
            });
        }else{
            notifyMsgWarning("操作无效,请确认当前状态是否可确认到账");
        }
    });

    //======================================取消挂载=======================================
    $(".cancelDiscount").click(function(){
        var asId = $("#avdetailModal").find("input[name='avId']").val();
        var orderSn = $("#avdetailModal").find(".orderSn").text();
        var beUnit = $(".beAfter input[value='"+asId+"']").parent().siblings(".beDel");
        if(beUnit[0] == undefined){
            notifyMsgWarning("操作无效");
        }else{
            $(beUnit).remove();
            notifyMsgWarning("订单编号："+orderSn+"取消挂载");
        }
        $('#avdetailModal').modal('hide');
        return false;
    });





});