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

            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/view/datePicker/jquery.datetimepicker.css"/>
            <style type="text/css">

                .custom-date-style {
                    background-color: red !important;
                }

            </style>

            <jsp:include page="/common/view/head.jsp" />
            <title>Queues List</title>

        </head>

        <body>
            <jsp:include page="/instructor/view/common/navigation.jsp" />
            <input hidden="hidden" id="labId" value="${sessionScope.ilab.id}">
            <!--<input hidden="hidden" id="traineeId" value="${sessionScope.ilab.id}">-->
            <div id="wrapper">

                <!-- Navigation -->

                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Queues ${sessionScope.ilab.name}</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->

                    <!-- /.row -->
                    <div class="row" draggable="true">
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading" >
                                    Assistance queue
                                    <!--<button type="button" class="btn btn-success">Transfer queue</button>-->
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <!--<button type="button" class="btn btn-outline btn-primary" >Transfer queue</button>-->
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
                                            <tbody  id="assistance">
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
                                                <c:forEach items="${sessionScope.ilab.assistancequeuesList}" var="labVar" varStatus="status">
                                                    <tr class="odd gradeX">
                                                        <td><c:out value="${status.count}"/></td>
                                                        <td><c:out value="${labVar.trainee.username}" /></td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/instructor/view/assistancedequeue?traineeid=${labVar.trainee.id}&labid=${labVar.lab.id}">
                                                                <button type="button" class="btn btn-outline btn-primary">Dequeue</button>
                                                            </a>
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

                            <form role="form" method="post" action="${pageContext.request.contextPath}/instructor/view/QueuesList?labid=${sessionScope.ilab.id}">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <div class="form-group">
                                    <label>Start Time</label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                    <input type="text" name="dateStart" value="" id="datetimepicker_mask"/><br>
                                </div>

                                <div class="form-group">
                                    <label>End Time</label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="text" name="dateEnd" value="" id="datetimepicker_mask_two"/><br>
                                </div>
                                <button type="submit" class="btn btn-outline btn-primary">Open UpLoad Assignment</button>
                            </form>

                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                            <div class="row">
                                <c:choose>
                                    <c:when test="${requestScope.created}">
                                        <div class="alert alert-success alert-dismissable">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            Course has been created successfully.
                                        </div>
                                    </c:when>

                                    <c:when test="${requestScope.nameError}">
                                        <div class="alert alert-danger alert-dismissable">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            There's an Error , the lab name must not be duplicated in the same course
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>

                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-6 -->
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading" >
                                    Delivery queue
                                    <!--<button type="button" class="btn btn-success">Transfer queue</button>-->
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <!--<button type="button" class="btn btn-outline btn-primary" >Transfer queue</button>-->
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive" >
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Trainee's name</th>
                                                    <th>action</th>
                                                </tr>
                                            </thead>
                                            <tbody id="delivery">
                                                <c:forEach items="${sessionScope.ilab.deliveryqueuesList}" var="labVar" varStatus="status">
                                                    <tr class="odd gradeX">
                                                        <td><c:out value="${status.count}"/></td>
                                                        <td><c:out value="${labVar.trainee.username}"/></td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/instructor/view/deliverydequeue?traineeid=${labVar.trainee.id}&labid=${labVar.lab.id}">
                                                                <button type="button" class="btn btn-outline btn-primary" >Dequeue</button>
                                                            </a>
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
        </body>
        <script src="${pageContext.request.contextPath}/common/view/datePicker/jquery.datetimepicker.js"></script>
        <script>
            $('#datetimepicker_mask').datetimepicker({
                mask: '9999/19/39 29:59'
            });
            $('#datetimepicker_mask_two').datetimepicker({
                mask: '9999/19/39 29:59'
            });
        </script>

        <script src="requestQueues.js"></script>
    </html>

</html>
