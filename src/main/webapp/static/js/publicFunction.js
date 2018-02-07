/**
 * 获取机构Name
 * @param adminId
 */
function getAdminName(adminId){
    var adminName = "";
    $.ajax({
        url: "/admin/getAdminName",
        type: "post",
        traditional: true,
        async: false,
        data: {adminId:adminId},
        success: function (data) {
            adminName = data;
        }
    });

    return adminName;
}

/**
 * 获取产品Name
 */
function getProductName(productId){
    var productName = "";

    $.ajax({
        url: "/admin/getProductName",
        type: "post",
        traditional: true,
        async: false,
        data: {productId:productId},
        success: function (data) {
            productName = data;
        }
    });

    return productName;
}

/**
 * 获取会员姓名
 */
function getMemberName(memberId){
    var memberName = "";

    $.ajax({
        url: "/admin/getMemberName",
        type: "post",
        traditional: true,
        async: false,
        data: {memberId:memberId},
        success: function (data) {
            memberName = data;
        }
    });

    return memberName;
}

/**
 * 获取cybbm
 */
function getCybbm(cybId){
    var cybbm = "";

    $.ajax({
        url: "/admin/getCybbm",
        type: "post",
        traditional: true,
        async: false,
        data: {cybId:cybId},
        success: function (data) {
            cybbm = data;
        }
    });

    return cybbm;
}

/**
 * 处理 可提现订单 状态
 * @param status
 * @returns {string}
 */
function getAvStatus(status){
    var avStatus = "";
    switch (status){
        case 1:avStatus="可提现";break;
        case 2:avStatus="请求提现，正在等待处理";break;
        case 3:avStatus="通过提现请求，等待到账";break;
        case 4:avStatus="已经到账，提现成功";break;
        case 5:avStatus="拒绝提现请求，不满足提现条件";break;
    }

    return avStatus;
}

/**
 * 处理 流水账单 状态
 * @param status
 * @returns {string}
 */
function getRaStatus(status){
    var raStatus = "";
    switch (status){
        case 1:raStatus="请求提现";break;
        case 2:raStatus="通过提现请求，提现成功";break;
        case 3:raStatus="拒绝提现请求，提现失败";break;
        case 4:raStatus="通过部分提现请求中的订单，拒绝部分提现请求中的订单";break;
    }

    return raStatus;
}