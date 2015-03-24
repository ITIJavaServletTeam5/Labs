
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">






    <head>
        <jsp:include page="/common/view/head.jsp" />
        <title>
            Activated Queues
        </title>


    </head>

    <body>
        <jsp:include page="/trainee/view/Navigation.jsp" />

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

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.AssistenceQueues}" var="AssistenceQueues" varStatus="status">
                                                    <tr>
                                                        <td>${status.count}</td>

                                                        <td>${AssistenceQueues.userName}</td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->

                                </div>
                            </div>



                            <form action="/RequestAssistance" method="post" >

                                <button type="button" onclick="change()" id="myButton1" class="btn btn-outline btn-primary">Request Assistance
                                </button>
                            </form>


                            <script>
                                function change() {
                                    var elem = document.getElementById("myButton1");
                                    if (elem.value == "Request Assistance")
                                        elem.value = "Cancel Request Assistance";
                                    else
                                        elem.value = "Request Assistance";
                                }
                            </script>


                            <!-- /.panel-body -->
                        </c:when>
                        <c:otherwise>
                            <div>There's no trainees to display</div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- /.col-lg-6 -->

                <div class="row">
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

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.DeliveryQueues}" var="DeliveryQueues" varStatus="status">
                                                        <tr>
                                                            <td>${status.count}</td>
                                                            <td>${DeliveryQueues.userName}</td>

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
                        </div>

                        <!-- /.panel-body -->

                        <form action="/RequestDelivery" method="post" >
                            <input type="submit" value = "Request Delivery"  onclick="changeD()" id="myButton2" class="btn btn-outline btn-primary"/>
                            
                        </form>

                        <script>
                            function changeD() {
                                var elem = document.getElementById("myButton2");
                                if (elem.value == "Request Delivery")
                                    elem.value = "Cancel Request Delivery";
                                else
                                    elem.value = "Request Delivery";
                            }
                        </script>

                    </div>


                    <!-- /.panel-heading -->



                    <!-- /.panel-body -->

                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->


                <div class="col-lg-6">

                    <!-- /.panel-heading -->



                    <!-- /.panel-body -->

                    <!-- /.panel -->
                </div>

                <!-- /.panel -->
            </div>
            <!-- /.col-lg-6 -->

        </div>

        <!-- /#wrapper -->
        <jsp:include page="/common/view/scripts.jsp" />

    </body>
</html>