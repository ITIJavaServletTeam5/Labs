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
<input hidden="hidden" id="labId" value="${requestScope.labId}"/>
<input hidden="hidden" id="traineeId" value="${sessionScope.user.id}"/>

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
                                        <c:if test="${AssistenceQueue.trainee.id == sessionScope.user.id}">
                                            <c:set var="inAssistance" value="true"/>
                                        </c:if>
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
                    <button type="submit" class="btn btn-outline btn-primary" id="assistanceButton">
                        <c:choose>
                            <c:when test="${inAssistance}">
                                Cancel Assistance Request
                            </c:when>
                            <c:otherwise>
                                Request Assistance
                            </c:otherwise>
                        </c:choose>
                    </button>
                </form>
                <!-- /.panel -->
            </div>
        </div>
        <!-- /.col-lg-6 -->

        <%--<div class="row">--%>
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Delivery Queue
                </div>
                <!-- /.panel-heading -->
                <c:choose>
                    <c:when test="${not empty requestScope.DeliveryQueues}">
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
                                    <tbody id="delivery">
                                    <c:forEach items="${requestScope.DeliveryQueues}" var="DeliveryQueue"
                                               varStatus="status">
                                        <c:if test="${DeliveryQueue.trainee.id == sessionScope.user.id}">
                                            <c:set var="inDelivery" value="true"/>
                                        </c:if>
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${DeliveryQueue.trainee.username}</td>
                                            <td>${DeliveryQueue.trainee.email}</td>
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
                <form method="post" action="${pageContext.request.contextPath}/trainee/view/RequestDelivery">
                    <input hidden="hidden" type="text" name="labId" value="${requestScope.labId}">
                    <button type="submit" class="btn btn-outline btn-primary" id="deliveryButton">
                        <c:choose>
                            <c:when test="${inDelivery}">
                                Cancel Delivery Request
                            </c:when>
                            <c:otherwise>
                                Request Delivery
                            </c:otherwise>
                        </c:choose>
                    </button>
                </form>
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /row -->
    <div class="row">
        <div class="col-lg-6">
            <div class="panel-body">
                <div class="alert alert-success" id="assistanceServed">

                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="panel-body">
                <div class="alert alert-success" id="deliveryServed">

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel-body">
                <div class="alert alert-success" hidden="hidden" id="notification">
                    Queues has changed.
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/common/view/scripts.jsp"/>
    <script src="requestQueues.js"></script>
</div>
</body>
</html>