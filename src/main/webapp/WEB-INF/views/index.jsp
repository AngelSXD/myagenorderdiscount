<%--
  Created by IntelliJ IDEA.
  User: SXD
  Date: 2017/12/21
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="static/css/index/custom.css">
    <style>
        h1 {
            font-family: Lobster, Monospace;
        }
    </style>
</head>
<body>
<div class="page-wrapper">
    <nav id="sidebar" class="sidebar-wrapper">
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
                    <span style="display: none" class="adminId"></span>
                    <span class="user-name adminName"></span>
                    <span class="user-role">Administrator</span>
                </div>
            </div><!-- sidebar-header  -->
            <div class="sidebar-search">
                <div>
                    <div class="input-group">
                        <input type="text" class="form-control search-menu" placeholder="Search for...">
                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    </div>
                </div>
            </div><!-- sidebar-search  -->
            <div class="sidebar-menu">
                <ul>
                    <li class="header-menu"><span>Dropdown  menu</span></li>
                    <li class="sidebar-dropdown">
                        <a  href="#" ><i class="fa fa-tv"></i><span>Menu 1</span><span class="label label-danger">New</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1 <span class="label label-success">10</span></a> </li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-photo"></i><span>Menu 2</span><span class="badge">3</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1 <span class="badge">2</span></a></li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-bar-chart-o"></i><span>Menu 3</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1</a></li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-diamond"></i><span>Menu 4</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1</a></li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="header-menu"><span>Simple menu</span></li>
                    <li><a href="#"><i class="fa fa-tv"></i><span>Menu 1</span></a></li>
                    <li><a href="#"><i class="fa fa-photo"></i><span>Menu 2</span></a></li>
                    <li><a href="#"><i class="fa fa-bar-chart-o"></i><span>Menu 3</span></a></li>
                    <li><a href="#"><i class="fa fa-diamond"></i><span>Menu 4</span></a></li>
                </ul>
            </div><!-- sidebar-menu  -->
        </div><!-- sidebar-content  -->

        <div class="sidebar-footer">
            <a href="#"><i class="fa fa-bell"></i><span class="label label-warning notification">3</span></a>
            <a href="#"><i class="fa fa-envelope"></i><span class="label label-success notification">7</span></a>
            <a href="#"><i class="fa fa-gear"></i></a>
            <a href="#"><i class="fa fa-power-off"></i></a>
        </div>
    </nav><!-- sidebar-wrapper  -->
    <main class="page-content">
        <div class="container-fluid">
            <header class="htmleaf-header">
                <h1>Myagen-admin's Wallet <span>reback form orderDiscount</span></h1>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="well">
                                <h3 class="text-success text-center">预估金额</h3>
                                <div class="row  text-center text-muted">
                                    <strong>￥<em class="esAmount">123</em></strong>
                                </div>
                                <div class="row">
                                    <button class="btn btn-success col-sm-4 col-sm-offset-4 col-xs-12" type="button"><span class="hidden-xs">查看</span>详情</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="well">
                                <h3 class="text-warning text-center">可提现金额</h3>
                                <div class="row  text-center text-muted">
                                    <strong>￥<em class="avAmount">123</em></strong>
                                </div>
                                <div class="row">
                                    <button class="btn btn-warning col-sm-4 col-sm-offset-4 col-xs-12" type="button"><span class="hidden-xs">流水/</span>提现</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>

            <h3 style="text-align:center;">点击左上角的 <i class="fa fa-bars"></i> 按钮来查看流水账单</h3>

            <footer class="htmleaf-footer">
                <h3 class="text-center"><em>技术支持：http://www.cnblogs.com/sxdcgaq8080</em></h3>
            </footer>
        </div>
    </main><!-- page-content" -->
</div><!-- page-wrapper -->


<script src="static/bootstrap/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/js/index/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="static/js/index/custom.js"></script>
<script src="static/js/index/index.js"></script>
</body>
</html>
