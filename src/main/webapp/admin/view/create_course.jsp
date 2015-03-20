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
        <jsp:include page="/admin/view/top_and_navigation.jsp" />

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-6">
                    <h1 class="page-header">Create Course</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">

                        <form role="form" method="post">
                            <div class="form-group">
                                <label>Course Name</label>
                                <input class="form-control" placeholder="Course Name">
                            </div>
                            <div class="form-group">
                                <label>Course Description</label>
                                <textarea class="form-control" rows="3"></textarea>
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
