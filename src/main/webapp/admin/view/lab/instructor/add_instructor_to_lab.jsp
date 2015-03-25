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
            <h1 class="page-header">Choose instructors to add to that lab</h1>
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
                        <form action="${pageContext.request.contextPath}/admin/group/course/lab/instructor/add" method="post">
                            <input hidden="hidden" name="labId" value="${requestScope.labId}">

                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="traineesTable">
                                        <thead>
                                        <tr>
                                            <th>Add</th>
                                            <th>Username</th>
                                            <th>Email</th>
                                                <%--<th>Edit</th>--%>
                                                <%--<th>Deactivate</th>--%>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${requestScope.instructors}" var="instructor">
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <input type="checkbox" value="${instructor.id}" name="instructors"
                                                                   id="${instructor.id}">
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>${instructor.username}</td>
                                                <td>${instructor.email}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                                <div class="col-lg-3 col-lg-offset-9">

                                    <button type="submit" class="btn btn-success">Add instructors to lab</button>

                                </div>
                            </div>
                        </form>
                        <!-- /.panel-body -->
                    </c:when>
                    <c:otherwise>
                        <div>There's no instructors to display</div>
                    </c:otherwise>
                </c:choose>
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
        $('#traineesTable').DataTable({
            responsive: true
        });
    });
</script>
</body>
</html>
