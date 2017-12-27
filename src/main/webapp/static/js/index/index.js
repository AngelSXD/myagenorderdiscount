

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

    //机构信息
    $.ajax({url:"../admin/getAdmin",
        type:"post",
        dataType:'json',
        traditional:true,
        success:function(data){
            if(data != null && data != ""){
                $(".adminId").text(data.id);
                $(".adminName").text(data.name);
            }
        }
    });


    //预估金额
    $.ajax({url:"../wallet/esAmount",
        type:"post",
        dataType:'json',
        traditional:true,
        success:function(data){
            $(".esAmount").text(data);
        }
    });

    //可提现金额
    $.ajax({url:"../wallet/avAmount",
        type:"post",
        dataType:'json',
        traditional:true,
        success:function(data){
            $(".avAmount").text(data);
        }
    });



});
