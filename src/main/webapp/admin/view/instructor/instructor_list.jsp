<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/common/view/head.jsp"/>
    <title>Create Trainee</title>
</head>
<body>
<jsp:include page="/admin/view/common/top_and_navigation.jsp"/>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Instructors</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <%--<div class="panel-heading">--%>
                <%--Trainees--%>
                <%--</div>--%>
                <c:choose>
                    <c:when test="${not empty requestScope.instructors}">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="instructorsTable">
                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Edit</th>
                                        <th>Deactivate</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.instructors}" var="instructor">
                                        <tr>
                                            <td>${instructor.username}</td>
                                            <td>${instructor.email}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/admin/instructor/edit?id=${instructor.id}">
                                                    <button type="submit" class="btn btn-primary" name=""
                                                            id="${instructor.id}">Edit
                                                    </button>
                                                </a>
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/admin/instructor/deactivate?id=${instructor.id}">
                                                    <button type="submit" class="btn btn-danger"
                                                            id="${instructor.id}">Deactivate
                                                    </button>
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
                    </c:when>
                    <c:otherwise>
                        <div>There's no instructors to display</div>
                    </c:otherwise>
                </c:choose>
                <div class="col-lg-3 col-lg-offset-9">
                    <form action="${pageContext.request.contextPath}/admin/instructor/create" method="get">
                        <button type="submit" class="btn btn-success">Create Instructor</button>
                    </form>
                </div>
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!--/ .row-->
</div>


<jsp:include page="/common/view/scripts.jsp"/>
<!-- data table script -->
<script>
    $(document).ready(function () {
        $('#instructorsTable').DataTable({
            responsive: true
        });
    });
</script>
</body>
</html>
