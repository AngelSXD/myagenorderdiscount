

$(document).ready(function(){




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
        console.log("选定时间段: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
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
        $.ajax({url:"/runAc/checkDiscount",
            type:"post",
            traditional:true,
            data:{currentValue:currentValue},
            success:function(data){
                $(".container-fluid").empty();
                $(".container-fluid").append(data);
            }
        });
    });

    /**
     * 查看订单历史和提现历史
     *
     */
    $(".esDiscount,.history").click(function(){
        var currentValue = $(this).attr("class");
        $.ajax({url:"/runAc/checkDiscount",
            type:"post",
            traditional:true,
            data:{currentValue:currentValue},
            success:function(data){
                $(".container-fluid").empty();
                $(".container-fluid").append(data);
            }
        });
    });



});
