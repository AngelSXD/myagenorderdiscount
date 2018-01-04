$("document").ready(function(){

    /**
     * 光标移出事件
     */
    $(document).on("blur","input[name='oldpassword']",function(){
        $.ajax({url:"admin/verPassword",
            type:"post",
            traditional:true,
            data:{"userId":$("input:hidden").val(),"oldpassword":$("input[name='oldpassword']").val()},
            success:function(data){
                if(data == "success"){
                    $("input[name='password']").attr("readonly",false);
                }else{
                    alert(data);
                }
            }
        });
    });

    /**
     * 修改管理员信息
     */
    $("button").click(function(){
        $.ajax({url:"admin/userEdit",
            type:"post",
            traditional:true,
            data:$("form").serialize(),
            success:function(data){
                alert(data);
            }
        });
    });
});