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
