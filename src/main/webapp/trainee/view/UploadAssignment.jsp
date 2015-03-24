 


<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <jsp:include page="/common/view/head.jsp" />



        <title>Upload Assignments</title>



    </head>

    <body>
        <jsp:include page="/trainee/view/Navigation.jsp" />



        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Upload Assignment</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">

                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <form method="post" action="${pageContext.request.contextPath}/trainee/controller/UploadAssignment" enctype="multipart/form-data">
                Select file to upload: <input type="file" name="file" size="60" class="btn btn-outline btn-primary"/><br />
                <button type="submit" class="btn btn-outline btn-primary">Submit</button>

                <button type="button" class="btn btn-outline btn-primary">Cancel</button>
                <input type="hidden" name="LabId" value="${requestScope.labId}">
            </form>
            

        </div>



        <jsp:include page="/common/view/scripts.jsp" />
    </body>

</html>

