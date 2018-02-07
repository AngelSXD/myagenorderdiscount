var startTime ;//开始上传时间

var fileType;

function fileSelected() {
    var file = document.getElementById('fileToUpload').files[0];
    if (file) {
        var fileSize = 0;
        if(file.size > 2*1024*1024){
            alert("文件大小超过2M，请重新上传");
            $("#fileToUpload").val("");
            return false;
        }
        if(file.type.indexOf("image") < 0){
            alert("请上传图片作LOGO");
            $("#fileToUpload").val("")
            return false;
        }
        fileType = file.type;
        if (file.size > 1024 * 1024){
            if(file.size >1024 * 1024 * 1024)
                fileSize = (Math.round(file.size * 100 / (1024 * 1024 * 1024)) / 100).toString() + 'GB';
            else
                fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        }
        else{
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
        }
        document.getElementById('fileName').innerHTML = '上传文件: ' + file.name;
        document.getElementById('fileSize').innerHTML = '文件大小: ' + fileSize;
        document.getElementById('fileType').innerHTML = '文件类型: ' + ((file.type == "")?"未识别类型":file.type);
    }
}

function uploadFile() {
    var fd = new FormData();//获取上传文件
    var fileData = document.getElementById('fileToUpload').files[0];
    if(fileData == undefined){
        alert("请选择文件后再上传");
        return false;
    }
    fd.append("upfile", document.getElementById('fileToUpload').files[0]);
    fd.append("adminId",$(".adminId").text());

    startTime = new Date();//获取起始时间，也就是开始上传的时间
    var xhr = new XMLHttpRequest();
    xhr.upload.addEventListener("progress", uploadProgress, false);
    xhr.addEventListener("load", uploadComplete, false);
    xhr.addEventListener("error", uploadFailed, false);
    xhr.addEventListener("abort", uploadCanceled, false);
    xhr.open("POST", "file/uploadMaterial");
    xhr.send(fd);
}

function uploadProgress(evt) {
    if (evt.lengthComputable) {
        //evt.loaded  当前上传文件的大小
        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
        var currtTime = new Date();//当前时间
        var costTime = (currtTime - startTime)/1000+1;//消耗的时间
        var speed = evt.loaded/((currtTime - startTime)/1000)/1024;//上传速度  KB/S
        var sp = evt.loaded/((currtTime - startTime)/1000);//用于计算上传速度的变量
        var speed = sp/1024>1 ?
            (sp/1024/1024>1 ?
                (sp/1024/1024/1024>1 ?
                    (sp/1024/1024/1024).toFixed(2)+" GB/秒"
                    :(sp/1024/1024).toFixed(2)+" MB/秒")
                :(sp/1024).toFixed(2)+" KB/秒" )
            :sp.toFixed(2)+" B/秒";//文件上传速度   toFixed(2)截取保留小数点后2位，作用对象是number类型的
        var loaded = evt.loaded/1024>1 ?
            (evt.loaded/1024/1024>1 ?
                (evt.loaded/1024/1024/1024>1 ?
                    (evt.loaded/1024/1024/1024).toFixed(2)+" GB"
                    :(evt.loaded/1024/1024).toFixed(2)+" MB")
                :(evt.loaded/1024).toFixed(2)+" KB" )
            :evt.loaded.toFixed(2)+" B";//文件已上传大小
        $(".pro").html("上传大小："+loaded +"消耗时间："+costTime.toFixed(3)+"s 上传速度："+speed+"KB/S");
        $("div[role='progressbar']").width(percentComplete+"%");
        $("div[role='progressbar']").html(percentComplete+"%");

    }
    else {
        document.getElementById('progressNumber').innerHTML = 'unable to compute';
    }
}

function uploadComplete(evt) {//成功的回调函数
    var imgData = evt.target.responseText;
    if(imgData != "null" && imgData != "error"){
        $(".img-responsive").attr("src","data:"+fileType+";base64,"+imgData);
        $("#updateLogoModal").modal("hide");
    }else{
        alert("机构信息有误");
    }
}

function uploadFailed(evt) {//失败的回调函数
    alert("There was an error attempting to upload the file.");
}

function uploadCanceled(evt) {//用户或者浏览器关闭连接导致上传中断的上传
    alert("The upload has been canceled by the user or the browser dropped the connection.");
}
