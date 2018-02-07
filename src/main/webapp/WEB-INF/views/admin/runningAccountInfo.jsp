<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="../static/css/admin/ui-choose.css" rel="stylesheet" />
<link href="../static/css/login/animate.css" rel="stylesheet" />

<div class="row" >
    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="row text-center text-gold">
            <ul class="nav nav-tabs nav-justified">
                <li role="presentation">
                    <a class="adminA" data-toggle="modal" data-target="#adminModal">流水账单管理</a>
                </li>
            </ul>
        </div>
    </div>
</div>


<div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
    <div class="modal fade modalIndex" id="runningAccountModal"  role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-warning">机构-产品折扣信息</h4>
                </div>
                <div class="modal-body">
                        <form class="form-horizontal"  method="post">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-success">流水单号</label>
                                <div class="col-sm-9">
                                    <input type="hidden" name="raId" >
                                    <strong class="raSn"></strong>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-success">资金数额</label>
                                <div class="col-sm-9">
                                    <strong class="raAccount"></strong>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-success">流水状态</label>
                                <div class="col-sm-9">
                                    <input type="hidden" name="accountStatus" >
                                    <strong class="raStatus"></strong>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-success">订单时间</label>
                                <div class="col-sm-9">
                                    <strong class="raDate"></strong>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-success">机构名称</label>
                                <div class="col-sm-9">
                                    <input type="hidden" name="adminId">
                                    <strong class="adminName"></strong>
                                </div>
                            </div>
                            <div class="link">

                            </div>
                        </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary updateSubmit">通过提现</button>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="row detail">
    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12 begon">

        <div class="row moreDetail">
            <div class="alert alert-info">
                <div class="row">
                    <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12 text-center">
                        <input type="hidden" name="pageNumber" value="0"/>
                        <input type="hidden" name="pageSize" value="10"/>
                        <u class="btn-block">...加载更多...</u>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../static/js/admin/bootstrap-notify.min.js"></script>
<script src="../static/js/admin/runningAccountInfo.js"></script>
