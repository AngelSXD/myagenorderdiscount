<%--
  Created by IntelliJ IDEA.
  User: SXD
  Date: 2017/12/21
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>返利后台管理</title>
    <link rel="icon" href="../static/img/title_128X128.ico" type="image/x-icon"/>
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
    <link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../static/css/index/htmleaf-demo.css">
    <link rel="stylesheet" href="../static/css/index/jquery.mCustomScrollbar.min.css" />
    <link rel="stylesheet" href="../static/css/index/daterangepicker.css" />
    <link rel="stylesheet" href="../static/css/index/custom.css">

    <link rel="stylesheet" type="text/css" href="../static/css/admin/vicons-font.css" />
    <link rel="stylesheet" type="text/css" href="../static/css/admin/buttons.css" />

    <style>
        h1 {
            font-family: Lobster, Monospace;
        }
        .in{
            z-index: -1;
        }
        .ove{
            z-index: 1000;
        }
        .modalIndex{
            z-index: 999;
        }
        u,small,li{

            overflow: hidden;

            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 1;
            -webkit-box-orient:vertical;
        }
    </style>
</head>
<body>
<div class="page-wrapper">
    <nav id="sidebar" class="sidebar-wrapper ove">
        <div class="sidebar-content">
            <a href="#" id="toggle-sidebar"><i class="fa fa-bars"></i></a>
            <div class="sidebar-brand">
                <a href="#">MyAgen</a>
            </div>
            <div class="sidebar-header">
                <div class="user-pic">
                    <img class="img-responsive img-rounded" src="../static/img/user.jpg" alt="">
                </div>
                <div class="user-info">
                    <span class="user-name adminName">
                        超级管理员
                    </span>

                    <span class="user-role">Administrator</span>
                </div>
            </div><!-- sidebar-header  -->
            <div class="sidebar-menu">
                <ul>

                    <li class="header-menu"><span>personality  menu</span></li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-diamond"></i><span>管理中心</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#" class="baseInfo">基本信息</a></li>
                                <li><a href="#" class="discountInfo">折扣管理</a></li>
                                <li><a href="#" class="runningAccountInfo">流水管理</a></li>
                                <li><a href="#" class="promocodeInfo">优惠券管理</a></li>
                            </ul>
                        </div>
                    </li>

                </ul>
            </div><!-- sidebar-menu  -->
        </div><!-- sidebar-content  -->
        <div class="sidebar-footer">
            <a href="adminHome"><i class="fa fa-home"></i></a>
            <a href="admin/reback"><i class="fa fa-power-off"></i></a>
        </div>
    </nav><!-- sidebar-wrapper  -->
    <main class="page-content">
        <div class="container-fluid">
            <header class="htmleaf-header">
                <h1>Myagen-Super's DicountManage <span>Administrator-specific Features</span></h1>
                <div class="container-fluid" >
                    <div class="row" >
                        <div class="col-lg-4 col-lg-offset-4 col-sm-12 col-md-12 col-xs-12">
                            <button class="button button-warning button--pipaluk btn-block discountInfo">折扣管理</button>
                            <button class="button button-warning button--pipaluk btn-block runningAccountInfo">流水管理</button>
                        </div>
                    </div>
                </div>
            </header>

            <h3 class="text-center">点击左上角的 <i class="fa fa-bars"></i> 按钮更多功能操作</h3>

            <footer class="htmleaf-footer">
                <div class="row">
                    <h3 class="text-center">技术支持：@Angel<span class="hidden-xs hidden-sm">&nbsp;&nbsp;http://www.cnblogs.com/sxdcgaq8080</span></h3>
                </div>
            </footer>
        </div>
    </main><!-- page-content" -->
</div><!-- page-wrapper -->


<script src="../static/bootstrap/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="../static/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/js/index/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="../static/js/index/custom.js"></script>
<script src="../static/js/index/moment.min.js"></script>
<script src="../static/js/notify.js"></script>
<script src="../static/js/publicFunction.js"></script>
<script src="../static/js/admin/admin.js"></script>
</body>
</html>
