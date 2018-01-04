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
    <title>时代基因返利网</title>
    <link rel="icon" href="static/img/title_128X128.ico" type="image/x-icon"/>
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/css/index/htmleaf-demo.css">
    <link rel="stylesheet" href="static/css/index/jquery.mCustomScrollbar.min.css" />
    <link rel="stylesheet" href="static/css/index/daterangepicker.css" />
    <link rel="stylesheet" href="static/css/index/custom.css">
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
                    <img class="img-responsive img-rounded" src="static/img/user.jpg" alt="">
                </div>
                <div class="user-info">
                    <span style="display: none" class="adminId">${admin.id}</span>
                    <span class="user-name adminName">

                        <c:if test="${empty admin.name}">
                            机构获取失败
                        </c:if>
                        <c:if test="${not empty admin.name}">
                            ${admin.name}
                        </c:if>
                    </span>
                    <span class="user-name adminAddress">
                        中间人：
                        <c:if test="${empty admin.accessman}">
                            暂无
                        </c:if>
                        <c:if test="${not empty admin.accessman}">
                            ${admin.accessman}
                        </c:if>
                    </span>
                    <span class="user-role">Administrator</span>
                </div>
            </div><!-- sidebar-header  -->
            <div class="sidebar-search">
                <div>
                    <div class="input-group">
                        <input type="text" class="form-control search-menu dateInput"   data-toggle="tooltip" data-placement="top" title="搜索时间段中的流水信息">
                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    </div>
                </div>
            </div><!-- sidebar-search  -->
            <div class="sidebar-menu">
                <ul>

                    <li class="header-menu"><span>personality  menu</span></li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-diamond"></i><span>个人中心</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#" class="sub">基本信息</a></li>
                                <li><a href="#">提现历史</a></li>
                                <li><a href="#">订单历史</a></li>
                            </ul>
                        </div>
                    </li>

                </ul>
            </div><!-- sidebar-menu  -->
        </div><!-- sidebar-content  -->

        <div class="sidebar-footer">
            <a href="#"><i class="fa fa-home"></i></a>
            <a href="#"><i class="fa fa-power-off"></i></a>
        </div>
    </nav><!-- sidebar-wrapper  -->
    <main class="page-content">
        <div class="container-fluid">
            <header class="htmleaf-header">
                <h1>Myagen-admin's Wallet <span>reback form orderDiscount</span></h1>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-6  col-sm-6  col-md-6 in">
                            <div class="well">
                                <h3 class="text-success text-center">预估金额</h3>
                                <div class="row  text-center text-muted">
                                    <strong>￥
                                        <small>
                                            <em class="esAmount">123</em>
                                        </small>
                                    </strong>
                                </div>
                                <div class="row">
                                    <button class="btn btn-success col-md-4 col-md-offset-4 col-xs-12 col-sm-12" type="button"><span class="hidden-xs hidden-sm">查看</span>详情</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6 in">
                            <div class="well">
                                <h3 class="text-warning text-center">可提<span class="hidden-xs hidden-sm">现</span>金额</h3>
                                <div class="row  text-center text-muted">
                                    <strong>￥
                                        <small>
                                            <em class="avAmount">123</em>
                                        </small>
                                    </strong>
                                </div>
                                <div class="row">
                                    <button class="btn btn-warning col-md-4 col-md-offset-4 col-xs-12 col-sm-12" type="button"><span class="hidden-xs hidden-sm">流水/</span>提现</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>

            <h3 class="text-center">点击左上角的 <i class="fa fa-bars"></i> 按钮来查看流水账单</h3>


            <footer class="htmleaf-footer">
                <div class="row">
                    <h3 class="text-center">技术支持：@Angel<span class="hidden-xs hidden-sm">&nbsp;&nbsp;http://www.cnblogs.com/sxdcgaq8080</span></h3>
                </div>
            </footer>
        </div>
    </main><!-- page-content" -->
</div><!-- page-wrapper -->


<script src="static/bootstrap/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/js/index/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="static/js/index/custom.js"></script>
<script src="static/js/index/moment.min.js"></script>
<script src="static/js/index/daterangepicker.js"></script>
<script src="static/js/index/index.js"></script>
</body>
</html>
