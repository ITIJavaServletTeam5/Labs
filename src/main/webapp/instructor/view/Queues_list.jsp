<%-- 
    Document   : Assistance_Queues_list
    Created on : Mar 20, 2015, 4:28:57 PM
    Author     : engy
--%>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <!DOCTYPE html>
    <html lang="en">

        <head>

            <jsp:include page="/common/view/head.jsp" />
            <title>Queues List</title>

        </head>

        <body>
            <jsp:include page="/instructor/view/common/navigation.jsp" />
            <div id="wrapper">

                <!-- Navigation -->

                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Queues</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->

                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Assistance queue
                                    <!--<button type="button" class="btn btn-success">Transfer queue</button>-->
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="button" class="btn btn-outline btn-primary">Transfer queue</button>
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Trainee's name</th>
                                                    <th>action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <!--                                                <tr>
                                                                                                    <td>1</td>
                                                                                                    <td>Mark</td>
                                                                                                    <td><button type="button" class="btn btn-outline btn-primary">Dequeue</button></td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td>2</td>
                                                                                                    <td>Jacob</td>
                                                                                                    <td><button type="button" class="btn btn-outline btn-primary">Dequeue</button></td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td>3</td>
                                                                                                    <td>Larry</td>
                                                                                                    <td><button type="button" class="btn btn-outline btn-primary">Dequeue</button></td>
                                                                                                </tr>-->
                                                <c:forEach items="${sessionScope.lab.assistancequeues}" var="labVar" varStatus="status">
                                                    <tr class="odd gradeX">
                                                        <td><c:out value="${status.count}"/></td>
                                                        <td><c:out value="${labVar.trainee.username}"/></td>
                                                        <td>
                                                                <button type="button" class="btn btn-outline btn-primary" onclick="window.location='${pageContext.request.contextPath}/instructor/view/assistancedequeue?traineeid=${labVar.trainee.id}&labid=${labVar.lab.id}'">Dequeue</button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-6 -->
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Delivery queue
                                    <!--<button type="button" class="btn btn-success">Transfer queue</button>-->
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="button" class="btn btn-outline btn-primary">Transfer queue</button>
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Trainee's name</th>
                                                    <th>action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${sessionScope.lab.deliveryqueues}" var="labVar" varStatus="status">
                                                    <tr class="odd gradeX">
                                                        <td><c:out value="${status.count}"/></td>
                                                        <td><c:out value="${labVar.trainee.username}"/></td>
                                                        <td>
                                                                <button type="button" class="btn btn-outline btn-primary" onclick="window.location='${pageContext.request.contextPath}/instructor/view/deliverydequeue?traineeid=${labVar.trainee.id}&labid=${labVar.lab.id}'">Dequeue</button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-6 -->
                    </div>
                    <!-- /.row the end of queues-->

                    <!-- /.row -->
                </div>
                <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- jQuery -->

            <jsp:include page="/common/view/scripts.jsp" />
            <script>

            </script>
        </body>

    </html>

</html>
