$(document).ready(function(){

    /**
     * 侧边菜单栏
     * 基本信息
     */
    $(".baseInfo").click(function(){
        $.ajax({url:"admin/baseInfo",
            type:"post",
            traditional:true,
            success:function(data){
                $(".container-fluid").empty();
                $(".container-fluid").append(data);
            }
        });
    });


    /**
     * 侧边菜单栏
     * 折扣管理
     */
    $(".discountInfo").click(function(){
        $.ajax({url:"admin/discountInfo",
            type:"post",
            traditional:true,
            success:function(data){
                $(".container-fluid").empty();
                $(".container-fluid").append(data);
            }
        });
    });

    /**
     * 侧边菜单栏
     * 流水管理
     */
    $(".runningAccountInfo").click(function(){
        $.ajax({url:"admin/runningAccountInfo",
            type:"post",
            traditional:true,
            success:function(data){
                $(".container-fluid").empty();
                $(".container-fluid").append(data);
            }
        });
    });

    /**
     * 侧边菜单栏
     * 优惠券管理
     */
    $(".promocodeInfo").click(function(){
        $.ajax({url:"admin/promocodeInfo",
            type:"post",
            traditional:true,
            success:function(data){
                $(".container-fluid").empty();
                $(".container-fluid").append(data);
            }
        });
    });




});