<%@page contentType="text/html" pageEncoding="windows-1252" %>
<!DOCTYPE html>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">


<head>
    <jsp:include page="/common/view/head.jsp"/>
    <title>
        Trainee
    </title>


</head>

<body>
<jsp:include page="/trainee/view/Navigation.jsp"/>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Hello dude
                </div>
                <div class="panel-body">
                    <p>Hello in the most futuristic lab management system out there. On your left you'll find the list of labs available for you.</p>
                </div>
                <div class="panel-footer">
                    Enjoy your stay
                </div>
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- / .row -->
    <jsp:include page="/common/view/scripts.jsp"/>
</div>
</body>
</html>