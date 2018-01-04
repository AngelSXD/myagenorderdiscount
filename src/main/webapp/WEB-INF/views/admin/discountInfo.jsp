<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <li role="presentation"><a href="#">录入</a></li>
                <li role="presentation"><a href="#">查询</a></li>
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
                        机构信息

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary">确认</button>
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
                        机构信息

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary">确认</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

<div class="row detail">
    <div class="col-lg-8 col-lg-offset-2 col-sm-12 col-md-12 col-xs-12">
        <div class="row">
            <div class="alert alert-info">
                <div class="row">
                    <div class="col-lg-8 col-sm-12 col-md-12 col-xs-12 text-left">
                        <input type="hidden" name="adminId"/>
                        <u name="adminName">机构名称机构名称机构名称机构名称机构名称机构名称机构名称机构名称</u>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">
                        <input type="hidden" name="productId"/>
                        <small name="productName">产品名称产品名称产品名称产品名称产品名称</small>
                    </div>
                    <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">
                        <small>￥<em>12.3</em>&nbsp;折扣价</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="alert alert-warning">
                <div class="row">
                    <div class="col-lg-8 col-sm-12 col-md-12 col-xs-12 text-left">
                        <input type="hidden" name="adminId"/>
                        <u name="adminName">机构名称机构名称机构名称机构名称机构名称机构名称机构名称机构名称</u>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 text-left">
                        <input type="hidden" name="productId"/>
                        <small name="productName">产品名称产品名称产品名称产品名称产品名称</small>
                    </div>
                    <div class="col-lg-6  col-sm-6  col-md-6  col-xs-6 text-right">
                        <small>￥<em>12.3</em>&nbsp;折扣价</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="../static/js/admin/discountInfo.js"></script>