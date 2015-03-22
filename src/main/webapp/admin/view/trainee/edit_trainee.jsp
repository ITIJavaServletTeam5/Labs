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
        <c:choose>
            <c:when test="${requestScope.created}">
                <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    Trainee has been created successfully.
                </div>
            </c:when>

            <c:when test="${requestScope.emailError}">
                <div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    There's already a trainee with that email
                </div>
            </c:when>
        </c:choose>
    </div>

    <!-- /.row -->

    <div class="row">
        <div class="col-lg-12">
            <form role="form" method="post" action="${pageContext.request.contextPath}/admin/trainee/edit">
                <div class="form-group">
                    <label>Username</label>
                    <input name="username" value="${requestScope.trainee.username}" class="form-control" placeholder="Username" required="">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input name="email" type="email" value="${requestScope.trainee.email}" class="form-control" placeholder="Email" required="" disabled>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input name="password" type="text" value="123456" class="form-control" placeholder="Password"
                           required="">

                    <p class="help-block">this is not the real trainee's password, editing this trainee will have you change his password</p>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
                <button type="reset" class="btn btn-default">Reset</button>
            </form>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!--/ .row-->
</div>

<jsp:include page="/common/view/scripts.jsp"/>
</body>
</html>
