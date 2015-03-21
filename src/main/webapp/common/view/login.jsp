<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sharno
  Date: 3/17/15
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/common/view/head.jsp"/>

    <title>Login</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <c:choose>
                        <c:when test="${requestScope.errorLogin}">
                            <div class="row">
                                <div class="alert alert-danger alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert"
                                            aria-hidden="true">&times;</button>
                                    Your password is wrong or you don't exist on the system.
                                </div>
                            </div>
                        </c:when>
                    </c:choose>

                    <form role="form" method="post" action="${pageContext.request.contextPath}/login">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus required="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password"
                                       value="" required="">
                            </div>
                            <%--<div class="checkbox">--%>
                            <%--<label>--%>
                            <%--<input name="remember" type="checkbox" value="Remember Me">Remember Me--%>
                            <%--</label>--%>
                            <%--</div>--%>
                            <!-- Change this to a button or input when using this as a form -->
                            <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block">Login
                            </button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="scripts.jsp"/>
</body>
</html>
