<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/common/view/head.jsp"/>
    <title>Admin</title>
</head>
<body>
<jsp:include page="/admin/view/common/top_and_navigation.jsp"/>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Create Trainee</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <form role="form" method="post" action="${pageContext.request.contextPath}/admin/trainee/create">
                <div class="form-group">
                    <label>Username</label>
                    <input name="username" class="form-control" placeholder="Username" required="">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input name="email" type="email" class="form-control" placeholder="Email" required="">
                </div>
                <div class="form-group">
                    <label>Default Password</label>
                    <input name="password" type="text" value="123456" class="form-control" placeholder="Password" disabled required="">
                    <p class="help-block">All trainees will have to change their password upon first login</p>
                </div>
                <button type="submit" class="btn btn-default">Submit Button</button>
                <button type="reset" class="btn btn-default">Reset Button</button>
            </form>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!--/ .row-->
</div>

<jsp:include page="/common/view/scripts.jsp"/>
</body>
</html>
