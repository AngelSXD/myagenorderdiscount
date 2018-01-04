<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>MyAgenOrder - 登录</title>

    <link rel="icon" href="static/img/title_128X128.ico" type="image/x-icon"/>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/login/animate.css" rel="stylesheet">
    <link href="static/css/login/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div style="padding: 100px 0px;">
        <div>
            <h1 class="logo-name">AG</h1>
        </div>
        <h3>MyAgen-OrderDiscount</h3>
        <label style="display: none">${msg}</label>
        <br/>
        <h4 style="color: red;">仅管理帐号可以登录</h4>
        <form class="m-t" role="form" action="loginVer"  method="post">
            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="管理帐号" required="">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="管理密码" required="">
            </div>

            <button type="submit" class="btn  block full-width m-b" style="background-color: #494A5F;color: #ffffff">登 录</button>
            </p>
        </form>
    </div>




</div>
<script src="static/bootstrap/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        var msg = $("label").text();
        if(msg != 'success' && msg != ""){
            $(".loginscreen  h4").text(msg);
        }


    });
</script>

</body>

</html>
