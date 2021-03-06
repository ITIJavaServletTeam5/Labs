<%-- 
    Document   : Group
    Created on : Mar 17, 2015, 6:43:39 PM
    Author     : Marwa
--%>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/common/view/head.jsp" />
        <title>Course</title>
    </head>
    <body>
        <jsp:include page="/admin/view/common/top_and_navigation.jsp" />

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Course</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <div class="row">
                <div class="col-lg-10">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Activated Course List

                        </div>

                        <c:choose>
                            <c:when test="${not empty requestScope.courses}">
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Coursename</th>
                                                    <th></th>
                                                    <th></th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.courses}" var="courses">
                                                    <tr>
                                                        <td>${courses.name}</td>

                                                        <td>
                                                            <form action="${pageContext.request.contextPath}/admin/course/edit" method="get">
                                                                <button type="submit" class="btn btn-outline btn-primary">Edit</button>
                                                            </form>
                                                        </td>
                                                        <td>
                                                            <form action="${pageContext.request.contextPath}/admin/course/deactive" method="post">
                                                                <button type="submit" class="btn btn-outline btn-primary">Deactivated</button>
                                                            </form>
                                                        </td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/admin/lab?id=${courses.id}">
                                                                <button type="submit" class="btn btn-outline btn-primary" id="${courses.id}">Lab List
                                                                </button>
                                                            </a>
                                                        </td>


                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                    <div class="col-lg-3 col-lg-offset-9">
                                        <form action="${pageContext.request.contextPath}/admin/course/create" method="get">
                                            <button type="submit" class="btn btn-outline btn-primary">Create Course</button>
                                        </form>
                                    </div>
                                </div>
                                <!-- /.panel-body -->
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-info alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                      No Course had been added yet
                                </div>
                            </c:otherwise>
                        </c:choose>

                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->


            </div>
            <!-- /#page-wrapper -->

        </div>
        <jsp:include page="/common/view/scripts.jsp" />
    </body>
</html>
