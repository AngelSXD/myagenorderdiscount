

$(document).ready(function(){

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
