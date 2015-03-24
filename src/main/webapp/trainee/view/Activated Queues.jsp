<%@page contentType="text/html" pageEncoding="windows-1252" %>
<!DOCTYPE html>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">


<head>
    <jsp:include page="/common/view/head.jsp"/>
    <title>
        Activated Queues
    </title>


</head>

<body>
<jsp:include page="/trainee/view/Navigation.jsp"/>
<input hidden="hidden" id="labId" value="${requestScope.labId}" />

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Queues</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">

            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Assistance Queue
                </div>
                <!-- /.panel-heading -->
                <c:choose>
                    <c:when test="${not empty requestScope.AssistenceQueues}">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Order</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                    </tr>
                                    </thead>
                                    <tbody id="assistance">
                                    <c:forEach items="${requestScope.AssistenceQueues}" var="AssistenceQueue"
                                               varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${AssistenceQueue.trainee.username}</td>
                                            <td>${AssistenceQueue.trainee.email}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->

                        </div>
                        <!-- /.panel-body -->
                    </c:when>
                    <c:otherwise>
                        <div>There's no trainees to display</div>
                    </c:otherwise>
                </c:choose>

                <!-- /.panel-body -->
                <form method="post" action="${pageContext.request.contextPath}/trainee/view/RequestAssistance">
                    <input hidden="hidden" type="text" name="labId" value="${requestScope.labId}">
                    <button type="submit" onsubmit="change()" value="Request Assistance" class="btn btn-outline btn-primary" id="myButton1">Request Assistance</button>
                </form>
                <!-- /.panel -->
                
                <script>
                    
    function change() 
{
    var elem = document.getElementById("myButton1");
    if (elem.value=="Request Assistance") elem.value = "Cancel Request Assistance";
    else elem.value = "Cancel Request Assistance";
}
                </script>
            </div>
        </div>
        <!-- /.col-lg-6 -->
</div>
        <%--<div class="row">--%>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Delivery Queue
                </div>
                            </div>
                        </div>
</div>
    </body>
    <!-- /.panel-body -->
</html>
