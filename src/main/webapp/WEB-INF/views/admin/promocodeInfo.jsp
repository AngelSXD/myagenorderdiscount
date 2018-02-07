<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="../static/css/admin/ui-choose.css" rel="stylesheet" />
<link href="../static/css/login/animate.css" rel="stylesheet" />

<div class="row" >
    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="row text-center text-gold">
            <ul class="nav nav-tabs nav-justified">
                <li role="presentation">
                    <a class="adminA">优惠券管理</a>
                </li>
            </ul>
        </div>
    </div>
</div>


<div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
    <div class="modal fade modalIndex" id="promocodeModal"  role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-warning">机构-优惠券折扣信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal"  method="post">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-success">机构名称</label>
                            <div class="col-sm-9">
                                <input type="hidden" name="codeId" >
                                <input type="hidden" name="adminId" >
                                <strong class="adminName"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-success">优惠券编码</label>
                            <div class="col-sm-9">
                                <strong class="promocodeStr"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-success">申请时间</label>
                            <div class="col-sm-9">
                                <strong class="codeDate"></strong>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label text-success">优惠折扣率</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" name="promoDiscount" placeholder="折扣率" >
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary updateSubmit">提交折扣率</button>
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
<script src="../static/js/admin/promocodeInfo.js"></script>
