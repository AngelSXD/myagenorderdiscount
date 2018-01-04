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



});