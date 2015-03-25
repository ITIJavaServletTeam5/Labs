<%-- 
    Document   : Group
    Created on : Mar 17, 2015, 6:43:39 PM
    Author     : Marwa
--%>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <jsp:include page="/common/view/head.jsp" />
        <title>Group</title>
    </head>
    <body>
        <jsp:include page="/admin/view/common/top_and_navigation.jsp" />

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Groups</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Activated Group List
                        </div>

                        <c:choose>
                            <c:when test="${not empty requestScope.groups}">
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Groupname</th>
                                                    <th>Edit</th>
                                                    <th>Deactivate</th>
                                                    <th>Courses</th>
                                                    <th>List of group trainees</th>
                                                    <th>Add trainees to group</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.groups}" var="groups">
                                                    <tr>
                                                        <td>${groups.name}</td>

                                                        <td>
                                                            <form action="${pageContext.request.contextPath}/admin/group/edit" method="get">
                                                                <button type="submit" class="btn btn-outline btn-primary">Edit</button>
                                                            </form>
                                                        </td>
                                                        <td>
                                                            <form action="${pageContext.request.contextPath}/admin/group/deactive" method="post">
                                                                <button type="submit" class="btn btn-outline btn-primary">Deactivated</button>
                                                            </form>
                                                        </td>

                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/admin/course?id=${groups.id}">
                                                                <button type="submit" class="btn btn-outline btn-primary" id="${groups.id}">Course List
                                                                </button>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/admin/group/trainee?groupId=${groups.id}">
                                                                <button type="submit" class="btn btn-outline btn-primary" id="${groups.id}">List of trainees in group
                                                                </button>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/admin/group/trainee/add?groupId=${groups.id}">
                                                                <button type="submit" class="btn btn-outline btn-primary" id="${groups.id}">Add trainees to group
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
                                        <form action="${pageContext.request.contextPath}/admin/group/create" method="get">
                                            <button type="submit" class="btn btn-outline btn-primary">Create Group</button>
                                        </form>
                                    </div>
                                </div>
                                <!-- /.panel-body -->
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-info alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                      No Groups had been added yet
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
        <!-- /#wrapper -->
        <jsp:include page="/common/view/scripts.jsp" />
    </body>
</html>
