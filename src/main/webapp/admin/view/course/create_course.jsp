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
        <title>Create Course</title>
    </head>
    <body>
        <jsp:include page="/admin/view/common/top_and_navigation.jsp" />

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-6">
                    <h1 class="page-header">Create Course</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

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
                            There's an Error , please check the selected group or course name
                        </div>
                    </c:when>
                </c:choose>
            </div>

            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">

                        <form role="form" method="post"  action="${pageContext.request.contextPath}/admin/course/create">

                            <div class="form-group">
                                <label>Group Name</label>
                                <select class="form-control" name="groupSelected">

                                    <c:forEach items="${requestScope.group}" var="group">
                                        <option>${group.name}</option>
                                    </c:forEach>

                                </select>
                            </div>

                            <div class="form-group">
                                <label>Course Name</label>
                                <input class="form-control"  name="coursename" placeholder="Course Name">
                            </div>
                            <div class="form-group">
                                <label>Course Description</label>
                                <textarea class="form-control" name="coursedecription" rows="3"></textarea>
                            </div>
                            <div class="form-group">

                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                            <button type="reset" class="btn btn-default">Reset</button>
                        </form>

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
