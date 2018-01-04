<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-lg-4 col-lg-offset-4 col-sm-12 col-md-12 col-xs-12">
    <form class="form-horizontal"  method="post">
        <div class="form-group">
            <label  class="col-sm-3 control-label">管理帐号</label>
            <div class="col-sm-9">
                <input type="hidden" name="userId" value="${user.userId}">
                <input type="text" class="form-control" name="userName" placeholder="username" value="${user.userName}">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-3 control-label">原始密码</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" name="oldpassword" placeholder="password">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-3 control-label">更新密码</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" name="password" placeholder="newPassword" readonly>
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-3 control-label">帐号说明</label>
            <div class="col-sm-9">
                <textarea class="form-control" rows="3" name="userCre" placeholder="account Description">${user.userCre}</textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <button type="button" class="btn btn-lg btn-default btn-block btn-primary">提交修改</button>
            </div>
        </div>
    </form>
</div>

<script src="../static/js/admin/baseInfo.js"></script>