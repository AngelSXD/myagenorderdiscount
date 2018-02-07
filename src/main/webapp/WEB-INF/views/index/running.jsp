<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="../static/css/admin/ui-choose.css" rel="stylesheet" />
<link href="../static/css/login/animate.css" rel="stylesheet" />

<div class="row" >
    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="row text-center text-gold">
            <input type="hidden" class="currentValue" value="${currentValue}">
            <ul class="nav nav-tabs nav-justified">
                <li role="presentation">
                    <a class="esDiscount">预估账单</a>
                </li>
                <li role="presentation">
                    <a class="avDiscount">可提现账单</a>
                </li>
                <li role="presentation">
                    <a class="history">历史提现记录</a>
                </li>
                <li role="presentation">
                    <a class="withdraw">提现</a>
                </li>
            </ul>
        </div>
    </div>
</div>


<div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
    <div class="modal fade modalIndex" id="esdetailModal"  role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-warning">预估订单信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal"  method="post">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">资金数额</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="esId" >
                                <strong class="esAccount"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">账单状态</label>
                            <div class="col-sm-9">
                                <strong class="esStatus"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">账单时间</label>
                            <div class="col-sm-9">
                                <strong class="esDate"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">机构名称</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="adminId">
                                <strong class="adminName"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">产品名称</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="productId">
                                <strong class="productName"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">采样包编码</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="cybId">
                                <strong class="cybbm"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">订单编码</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="orderId">
                                <strong class="orderSn"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">会员名称</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="memberId">
                                <strong class="memberName"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">操作来源</label>
                            <div class="col-sm-9">
                                <strong class="esOperater"></strong>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
    <div class="modal fade modalIndex" id="avdetailModal"  role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-warning">可提现订单信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal"  method="post">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">资金数额</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="avId" >
                                <strong class="avAccount"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">账单状态</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="amountStatus" >
                                <strong class="avStatus"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">机构名称</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="adminId">
                                <strong class="adminName"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">产品名称</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="productId">
                                <strong class="productName"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">采样包编码</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="cybId">
                                <strong class="cybbm"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">订单编码</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="orderId">
                                <strong class="orderSn"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">会员名称</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="memberId">
                                <strong class="memberName"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-danger">操作来源</label>
                            <div class="col-sm-9">
                                <strong class="avOperater"></strong>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-danger cancelDiscount">取消挂载</button>
                    <button type="button" class="btn btn-primary canDiscount">挂载提现</button>
                    <button type="button" class="btn btn-success confirm">确认到账</button>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
    <div class="modal fade modalIndex" id="runningAccountModal"  role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-warning">流水详情</h4>
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

<script src="../static/js/admin/ui-choose.js"></script>
<script src="../static/js/index/running.js"></script>
<script src="../static/js/admin/bootstrap-notify.min.js"></script>
