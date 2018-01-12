<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="../static/css/admin/ui-choose.css" rel="stylesheet" />
<link href="../static/css/login/animate.css" rel="stylesheet" />

<div class="row" >
    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="row text-center text-gold">
            <ul class="nav nav-tabs nav-justified">
                <li role="presentation">
                    <a class="adminA" data-toggle="modal" data-target="#adminModal">机构</a>
                    <input type="hidden" class="checkedAdminIds"/>
                </li>
                <li role="presentation">
                    <a class="productA" data-toggle="modal" data-target="#productModal">产品</a>
                    <input type="hidden" class="checkedProductIds">
                </li>
                <li role="presentation">
                    <a class="editA" data-toggle="modal" data-target="#editModal">录入</a>
                </li>
                <li role="presentation">
                    <a class="seachA">查询</a>
                </li>
            </ul>
        </div>
    </div>
</div>

    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="modal fade modalIndex" id="adminModal"  role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-warning">机构筛选</h4>
                    </div>
                    <div class="modal-body">
                        <select class="ui-choose" multiple="multiple" id="admins">

                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary adminClear">清除</button>
                        <button type="button" class="btn btn-primary adminSubmit">确认</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="modal fade modalIndex" id="productModal"  role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-warning">产品筛选</h4>
                    </div>
                    <div class="modal-body">
                        <select class="ui-choose" multiple="multiple" id="products">


                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary productClear">清除</button>
                        <button type="button" class="btn btn-primary productSubmit">确认</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="modal fade modalIndex" id="editModal"  role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-warning">产品折扣信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal"  method="post">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-danger">产品价格*</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="productPrice" placeholder="￥【必填】">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">折扣表达式</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="express" placeholder="折扣表达式" role="折扣表达式  仅留入口，后续开发可以编写处理规则">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">折扣率</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="priceDiscount" placeholder="0~1" role="折扣率 非必填项 若填写则可以直接计算出折扣价格">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-danger">折扣价格*</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="dicountPrice" placeholder="￥【必填】">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-warning editClear">清除</button>
                        <button type="button" class="btn btn-primary editSubmit">确认</button>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="modal fade modalIndex" id="detailModal"  role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-warning">机构-产品折扣信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal"  method="post">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-danger">机构名称*</label>
                                <div class="col-sm-9">
                                    <input type="hidden" name="discountId" class="expc">
                                    <input type="hidden" name="adminId" class="expc">
                                    <input type="text" class="form-control expc" name="adminName" placeholder="" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-danger">产品名称*</label>
                                <div class="col-sm-9">
                                    <input type="hidden" name="productId" class="expc">
                                    <input type="text" class="form-control expc" name="productName" placeholder="" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-danger">产品价格*</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="productPrice" placeholder="￥【必填】">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">折扣表达式</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="express" placeholder="折扣表达式" role="折扣表达式  仅留入口，后续开发可以编写处理规则">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">折扣率</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="priceDiscount" placeholder="0~1" role="折扣率 非必填项 若填写则可以直接计算出折扣价格">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label text-danger">折扣价格*</label>
                                <div class="col-sm-9">
                                    <input type="number" class="form-control" name="dicountPrice" placeholder="￥【必填】">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-warning updateClear">清除</button>
                        <button type="button" class="btn btn-danger updateDetele">删除</button>
                        <button type="button" class="btn btn-primary updateSubmit">确认</button>
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
        <%--<div class="row">--%>
            <%--<div class="alert alert-info">--%>
                <%--<div class="row">--%>
                    <%--<div class="col-lg-8 col-sm-12 col-md-12 col-xs-12 text-left">--%>
                        <%--<input type="hidden" name="adminId"/>--%>
                        <%--<u name="adminName">机构名称机构名称机构名称机构名称机构名称机构名称机构名称机构名称</u>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="row">--%>
                    <%--<div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">--%>
                        <%--<input type="hidden" name="productId"/>--%>
                        <%--<small name="productName">产品名称产品名称产品名称产品名称产品名称</small>--%>
                    <%--</div>--%>
                    <%--<div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">--%>
                        <%--<input type="hidden" name="detailed"/>--%>
                        <%--<small>￥<em>12.3</em>&nbsp;折扣价</small>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</div>

<script src="../static/js/admin/ui-choose.js"></script>
<script src="../static/js/admin/discountInfo.js"></script>
<script src="../static/js/admin/bootstrap-notify.min.js"></script>
