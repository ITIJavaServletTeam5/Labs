<%-- 
    Document   : Assignments_list
    Created on : Mar 20, 2015, 1:30:20 PM
    Author     : engy
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page contentType="text/html" pageEncoding="windows-1252"%>--%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <jsp:include page="/common/view/head.jsp" />
        <title>Assignment Tables</title>

    </head>

    <body>
        <jsp:include page="/admin/view/top_and_navigation.jsp" />
        <!--<div id="wrapper">-->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Assignment Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">

                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="dataTable_wrapper">
                                        <table class="table table-striped table-bordered table-hover" >
                                            <thead>
                                                <tr>
                                                    <th>Trainee's name</th>
                                                    <th>Assignment link</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <c:forEach items="${requestScope.Assignments}" var="assignment" varStatus="status">
                                                    <tr class="odd gradeX">
                                                        <td><c:out value="${status.count}"/></td>
                                                        <td><c:out value="${assignment.assignmentData}"/></td>
                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                

            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

        <!--</div>-->
        <!-- /#wrapper -->


        <jsp:include page="/common/view/scripts.jsp" />
    </body>

</html>

