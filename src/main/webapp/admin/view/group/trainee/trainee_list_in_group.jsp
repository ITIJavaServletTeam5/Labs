<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/common/view/head.jsp" />
    <title>Trainees in group</title>
</head>
<body>
<jsp:include page="/admin/view/common/top_and_navigation.jsp" />

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Trainees</h1>
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
                    <c:when test="${not empty requestScope.trainees}">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="traineesTable">
                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Edit</th>
                                        <th>Deactivate</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.trainees}" var="trainee">
                                        <tr>
                                            <td>${trainee.username}</td>
                                            <td>${trainee.email}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/admin/trainee/edit?id=${trainee.id}">
                                                    <button type="submit" class="btn btn-primary" name=""
                                                            id="${trainee.id}">Edit
                                                    </button>
                                                </a>
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/admin/trainee/deactivate?id=${trainee.id}">
                                                    <button type="submit" class="btn btn-danger"
                                                            id="${trainee.id}">Deactivate
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
                                <form action="${pageContext.request.contextPath}/admin/trainee/create" method="get">
                                    <button type="submit" class="btn btn-success">Create Trainee</button>
                                </form>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </c:when>
                    <c:otherwise>
                        <div>There's no trainees to display</div>
                    </c:otherwise>
                </c:choose>
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!--/ .row-->
</div>



<jsp:include page="/common/view/scripts.jsp" />
<!-- data table script -->
<script>
    $(document).ready(function() {
        $('#traineesTable').DataTable({
            responsive: true
        });
    });
</script>
</body>
</html>
