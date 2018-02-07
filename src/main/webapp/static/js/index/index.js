var startDate;
var endDate;

function getAdminLogo(adminId){
    $.ajax({url:"/file/getAdminLogoData",
        type:"post",
        traditional:true,
        data:{adminId:adminId},
        success:function(data){
            if(data != "null"){
                $(".img-responsive").attr("src","data:image/png;base64,"+data);
            }

            return false;
        }
    });
}


function view2Running(currentValue) {
    $.ajax({url:"/runAc/checkDiscount",
        type:"post",
        traditional:true,
        data:{currentValue:currentValue},
        success:function(data){
            $(".container-fluid").empty();
            $(".container-fluid").append(data);
        }
    });
}


$(document).ready(function(){


    var adminId = $(".adminId").text();
    getAdminLogo(adminId);

    //测试  填充主体部分
    $(".sub").click(function(){
        $.ajax({url:"../sub1",
            type:"post",
            traditional:true,
            success:function(data){
                $(".container-fluid").empty();
                $(".container-fluid").append(data);
            }
        });
    });

    //时间搜索框--鼠标悬浮事件
    $(".dateInput").tooltip();

    //时间搜索框--赋予时间插件
    $(".dateInput").daterangepicker({

        "showDropdowns": true,
        "showWeekNumbers": true,
        "showISOWeekNumbers": true,
        "autoApply": true

    }, function(start, end, label) {
        startDate = new Date(start.format('YYYY-MM-DD')).getTime();
        endDate = new Date(end.format('YYYY-MM-DD')).getTime();
        console.log("选定时间段: " + start.format('YYYY-MM-DD') + " to " + end.format('YYYY-MM-DD') +" (predefined range: " + label + ")");
    });

    /**
     * 搜索时间段内 流水信息
     */
    $(".fa-search").click(function(){
        if(startDate == undefined || endDate == undefined){
            alert("未正确选取起止时间，无法查询");
        }else{
            view2Running("time");
        }

    });



    //钱包信息
    $.ajax({url:"../wallet/getWallet",
        type:"post",
        dataType:'json',
        traditional:true,
        data:{adminId:$(".adminId").text()},
        success:function(data){
            if(data != null){
                $(".esAmount").text(data.esAmount);
                $(".avAmount").text(data.avAmount);
            }
            return ;
        }
    });



    /**
     * 查看预估订单和可提现订单
     *
     */
    $(".checkEs,.checkAv").click(function(){
        var currentValue = $(this).val();
        view2Running(currentValue);
    });

    /**
     * 查看订单历史和提现历史
     *
     */
    $(".esDiscount,.history").click(function(){
        var currentValue = $(this).attr("class");
        view2Running(currentValue);
    });


    /**
     * 点击头像 上传logo
     */
    $(".user-pic").click(function(){
        $("#updateLogoModal").modal("show");
    });

    $(".getPromo").click(function(){
        location.href = "/file/downloadQR_Code?adminId="+adminId;
    });





});
