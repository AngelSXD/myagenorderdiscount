function get10Disocount(flag){

    var json = new Object();
    json.pageNumber = $("input[name='pageNumber']").val();
    json.pageSize = $("input[name='pageSize']").val();
    if(flag == "query"){
        json.adminIds = $(".checkedAdminIds").val();
        json.productIds = $(".checkedProductIds").val();
    }

    $.ajax({url:"admin/queryDiscount",
        type:"post",
        traditional:true,
        data:json,
        success:function(data){
            if(data != null){
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
                        +' <div class="col-lg-8 col-sm-12 col-md-12 col-xs-12 text-left">'
                        +' <input type="hidden" name="adminId" value="'+d.adminId+'"/>'
                        +' <u name="adminName">'+d.adminName+'</u>'
                        +' </div>'
                        +' </div>'
                        +'<div class="row">'
                        +' <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">'
                        +' <input type="hidden" name="productId" value="'+d.productId+'"/>'
                        +' <small name="productName">'+d.productName+'</small>'
                        +' </div>'
                        +' <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">'
                        +' <input type="hidden" name="detailed" value="'+d.discountId+'~'+d.productPrice+'~'+d.priceDiscount+'~'+d.disCre1+'"/>'
                        +' <small>￥<em>'+d.dicountPrice+'</em>&nbsp;折扣价</small>'
                        +' </div>'
                        +'</div>'
                        +'</div>'
                        +'</div>';

                });

                $('.detail .begon').children(".moreDetail").before(temp);

                //================================每条信息点击js相关=======================================
                var al = $('.detail .begon').children().not(".moreDetail").children(".alert");
                $(al).click(function(){
                    var adminId = $(this).find("input[name='adminId']").val();
                    var adminName = $(this).find("u[name='adminName']").text();
                    var productId = $(this).find("input[name='productId']").val();
                    var productName = $(this).find("small[name='productName']").text();
                    var detail = $(this).find("input[name='detailed']").val();
                    var dicountPrice = $(this).find("small em").text();
                    var discountId = "";
                    var productPrice = "";
                    var priceDiscount = "";
                    var express = "";
                    var arr = new Array();
                    arr = detail.split("~");
                    for(var i = 0; i<arr.length ; i++){
                        if(i==0){
                            discountId = arr[i];
                        }
                        if(i == 1){
                            productPrice = arr[i];
                        }
                        if(i == 2){
                            priceDiscount = arr[i];
                        }
                        if(i == 3){
                            express = arr[i];
                        }
                    }

                    $("#detailModal input[name='discountId']").val(discountId);
                    $("#detailModal input[name='adminId']").val(adminId);
                    $("#detailModal input[name='adminName']").val(adminName);
                    $("#detailModal input[name='productId']").val(productId);
                    $("#detailModal input[name='productName']").val(productName);
                    $("#detailModal input[name='productPrice']").val(productPrice);
                    $("#detailModal input[name='express']").val(express);
                    $("#detailModal input[name='priceDiscount']").val(priceDiscount);
                    $("#detailModal input[name='dicountPrice']").val(dicountPrice);

                    $('#detailModal').modal("show");
                });

            }else{
                $(".moreDetail u").text("暂无数据");
            }
        }
    });
}

$("document").ready(function(){

    //======================================ajax初始化页面要做的事情========================================
    get10Disocount();
    //======================================加载更多=======================================
    $(".moreDetail,.moreDetail u").click(function(){
        var flag = $(".moreDetail u").text();
        if(flag != "暂无数据" && flag != "人家也是有底线的"){
            get10Disocount("query");
        }

    });

    //==============================机构按钮相关js========================================

    /**
     * 打开机构筛选modal，并且初始化ui-choose
     */
    $(".adminA").click(function(){
        $.ajax({url:"admin/allAdmins",
            type:"post",
            traditional:true,
            async:false,
            success:function(data){
            var temp = ""
                $.each(data,function(i,d){
                    temp+= '<option value="'+d.id+'">'+d.name+'</option>';
                });
                $('#adminModal .modal-body #admins').append(temp);

                var admins = $('#admins').ui_choose();
                admins.click = function(value, item) {
                    console.log('click', value);
                };
            }
        });

    });

    /**
     * 机构筛选modal中勾选项的提交
     */
    $(".adminSubmit").click(function(){
        var adminIds = new Array();
        //勾选的admin
        var admins = $("#admins").next().children(".selected");
        $(admins).each(function(i,a){
            adminIds.push($(a).attr("data-value"));
        });
        $('#adminModal').modal('hide');
        $(".checkedAdminIds").val(adminIds);
    });

    /**
     * 机构筛选modal中清除勾选项
     */
    $(".adminClear").click(function(){
        $("#admins").next().children(".selected").removeClass("selected");
        $(".checkedAdminIds").val("");
    });



    //=====================================产品按钮相关js==============================

    /**
     * 打开产品modal，并且初始化ui-choose
     */
    $(".productA").click(function(){

        $.ajax({url:"admin/allProducts",
            type:"post",
            traditional:true,
            async:false,
            success:function(data){
                var temp = ""
                $.each(data,function(i,p){
                    temp+= '<option value="'+p.id+'">'+p.name+'</option>';
                });
                $('#productModal .modal-body #products').append(temp);

                var products = $('#products').ui_choose();
                products.click = function(value, item) {
                    console.log('click', value);
                };
            }
        });

    });


    /**
     * 产品筛选modal中勾选项的提交
     */
    $(".productSubmit").click(function(){
        var productIds = new Array();
        //勾选的admin
        var products = $("#products").next().children(".selected");
        $(products).each(function(i,a){
            productIds.push($(a).attr("data-value"));
        });
        $('#productModal').modal('hide');
        $(".checkedProductIds").val(productIds);
    });

    /**
     * 产品筛选modal中清除勾选项
     */
    $(".productClear").click(function(){
        $("#products").next().children(".selected").removeClass("selected");
        //并且清除hidden中的id
        $(".checkedProductIds").val("");
    });

    //==================================录入按钮 相关js==============================================

    /**
     * 填写了 折扣率的话 可以直接计算 本机构+本产品的折扣价格
     */
    $("input[name='priceDiscount']").blur(function(){

        //产品价格
        var productPrice = $(this).parents("form").find("input[name='productPrice']").val();
        if(productPrice == ""){
            $(this).val("");
            alert("产品价格未填写，无法计算折扣率");
            return false;
        }else{
            var priceDiscount = $(this).parents("form").find("input[name='priceDiscount']").val();
            if(parseFloat(priceDiscount)>1 || parseFloat(priceDiscount)<0){
                $(this).val("");
                alert("产品折扣率范围0~1之间，超出范围");
                return false;
            }else{
                var dicountPrice = parseFloat(priceDiscount)*parseFloat(productPrice);
                $(this).parents("form").find("input[name='dicountPrice']").val(dicountPrice.toFixed(4));
            }
        }
    });


    /**
     * 产品折扣清除按钮
     */
    $(".editClear").click(function(){
        $("form input").val("");
    });

    /**
     * 产品折扣 确认提交按钮
     */
    $(".editSubmit").click(function(){
        //机构IDs
        var adminIds = $(".checkedAdminIds").val();
        //产品IDs
        var productIds = $(".checkedProductIds").val();
        if(adminIds == "" || productIds == ""){
            alert("未勾选机构或产品");
            return false;
        }else{
            if(adminIds.split(",").length >10){
                alert("勾选机构不能超过10个");
                return false;
            }
            if(productIds.split(",").length > 20){
                alert("勾选产品不能超过20个");
                return false;
            }

            //产品价格
            var productPrice = $("input[name='productPrice']").val();
            //折扣价格
            var dicountPrice = $("input[name='dicountPrice']").val();
            if(productPrice == "" || dicountPrice == ""){
                alert("请完善必填项后提交");
                return false;
            }else{
                //折扣率
                var priceDiscount = $("input[name='priceDiscount']").val();
                //表达式
                var express = $("input[name='express']").val();

                $.ajax({url:"admin/editDiscount",
                    type:"post",
                    traditional:true,
                    async:true,
                    data:{adminIds:adminIds,productIds:productIds,productPrice:productPrice,dicountPrice:dicountPrice,priceDiscount:priceDiscount,express:express},
                    success:function(data){


                        if(data != null){
                            var temp = "";
                            var temp2 = "";
                            $.each(data,function(i,d){
                                if(d.disCre2 == "exist"){//代表discount已经存在，无法插入
                                    temp2 +=  d.adminId+"+"+d.productId+"-";
                                }else if(d.disCre2 == "error"){//代表discount插入失败
                                    temp += d.adminId+"+"+d.productId+"-";
                                }

                            });

                            if(temp2 != ""){
                                var msg = "";
                                var array = new Array();
                                array = temp2.split("-");
                                for(var i = 0;i<array.length-1;i++){
                                    var arr = array[i].split("+");
                                    msg = "【机构："+$("#adminModal ul li[data-value='"+arr[0]+"']").attr("title")
                                        +"】>>【"
                                        + "产品："+$("#productModal ul li[data-value='"+arr[1]+"']").attr("title")
                                        +"】产品折扣已经存在，存入失败";
                                    notifyMsgWarning(msg);
                                }
                            }
                            if(temp != ""){
                                var msg = "";
                                var array = new Array();
                                array = temp.split("-");
                                for(var i = 0;i<array.length-1;i++){
                                    var arr = array[i].split("+");
                                    msg = "【机构："+$("#adminModal ul li[data-value='"+arr[0]+"']").attr("title")
                                        +"】>>【"
                                        + "产品："+$("#productModal ul li[data-value='"+arr[1]+"']").attr("title")
                                        +"】保存错误，存入失败";
                                    notifyMsgError(msg);
                                }
                            }
                            $('.detail .begon').children().not(".moreDetail").remove();
                            //并且加载最近10条
                            get10Disocount();
                            //隐藏modal框
                            $('#editModal').modal('hide');

                        }else{
                            alert("机构或产品未勾选，不能操作折扣管理");
                        }

                    }
                });

            }
        }
    });

//================================每条详细信息 modal js相关=======================================
    /**
     * 机构-产品 折扣清除按钮
     */
    $(".updateClear").click(function(){
        $("form input:not(.expc)").val("");
    });

    /**
     *机构-产品 删除按钮
     */
    $(".updateDetele").click(function(){
        var discountId = $('#detailModal').find("input[name='discountId']").val();
        $.ajax({url:"admin/deleteDiscount",
            type:"post",
            traditional:true,
            async:false,
            data:{discountId:discountId},
            success:function(data){
                $('#detailModal').modal('hide');
                if(data.indexOf("失败")>0){
                    notifyMsgError(data);
                }
                if(data.indexOf("成功")>0){
                    notifyMsgSuccess(data);
                    $('.detail .begon').children().not(".moreDetail").remove();
                    get10Disocount("query");
                }

                return;
            }
        });
    });

    /**
     * 机构-产品 更新 确认提交按钮
     */
    $(".updateSubmit").click(function(){
        var formDatas = $("#detailModal form").serialize();
        $.ajax({url:"admin/updateDiscount",
            type:"post",
            traditional:true,
            async:false,
            data:formDatas,
            success:function(data){
                $('#detailModal').modal('hide');
                if(data.indexOf("失败")>0){
                    notifyMsgError(data);
                }
                if(data.indexOf("成功")>0){
                    notifyMsgSuccess(data);
                    $('.detail .begon').children().not(".moreDetail").remove();
                    get10Disocount("query");
                }
                return;
            }
        });
    });


//================================查询按钮js相关=======================================

    $(".seachA").click(function(){
        $('.detail .begon').children().not(".moreDetail").remove();
        $(".moreDetail u").text("...加载更多...");
        $("input[name='pageNumber']").val("0");
        $("input[name='pageSize']").val("10");
        get10Disocount("query");
    });





//===============================调用函数=============================================

    /**
     * bootstrap 通知提醒 使用 警告框
     * @param msg
     * @returns {*}
     */
    function notifyMsgWarning(msg){
       var notify =  $.notify({
            // options
            icon: 'glyphicon glyphicon-warning-sign',
            title: '警告',
            message: msg,
            target: '_blank'
        },{
            // settings
            element: 'body',
            position: null,
            type: "warning",
            allow_dismiss: true,
            newest_on_top: true,
            showProgressbar: false,
            placement: {
                from: "bottom",
                align: "center"
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,
            delay: 5000,
            timer: 1000,
            url_target: '_blank'
        });

       return notify;
    }


    /**
     * bootstrap 通知提醒 使用 错误框
     * @param msg
     * @returns {*}
     */
    function notifyMsgError(msg){
        var notify =  $.notify({
            // options
            icon: 'glyphicon glyphicon-remove-sign',
            title: '',
            message: msg,
            target: '_blank'
        },{
            // settings
            element: 'body',
            position: null,
            type: "danger",
            allow_dismiss: true,
            newest_on_top: true,
            showProgressbar: false,
            placement: {
                from: "bottom",
                align: "center"
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,
            delay: 5000,
            timer: 1000,
            url_target: '_blank'
        });

        return notify;
    }


    /**
     * bootstrap 通知提醒 使用 成功框
     * @param msg
     * @returns {*}
     */
    function notifyMsgSuccess(msg){
        var notify =  $.notify({
            // options
            icon: 'glyphicon glyphicon-ok-sign',
            title: '',
            message: msg,
            target: '_blank'
        },{
            // settings
            element: 'body',
            position: null,
            type: "success",
            allow_dismiss: true,
            newest_on_top: true,
            showProgressbar: false,
            placement: {
                from: "bottom",
                align: "center"
            },
            offset: 20,
            spacing: 10,
            z_index: 1031,
            delay: 5000,
            timer: 1000,
            url_target: '_blank'
        });

        return notify;
    }

});



