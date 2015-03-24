<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252" %>
<!DOCTYPE html>

<%--loads active labs of trainee--%>
<jsp:include page="/trainee/view/navigation"/>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Labs System</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <c:forEach items="${requestScope.activeLabs}" var="lab">
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> ${lab.course.myGroup.name}<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">

                                <li>
                                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> ${lab.course.name}<span
                                            class="fa arrow"></span></a>

                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> ${lab.name}<span
                                                    class="fa arrow"></span></a>
                                            <ul class="nav nav-Fourth-level">
                                                <li><a href="${pageContext.request.contextPath}/trainee/view/ActivatedQueus?labId=${lab.id}"><i class="fa fa-sign-out fa-fw"></i>
                                                    Activated Queues</a>
                                                <li><a href="${pageContext.request.contextPath}/trainee/controller/UploadAssignment?labId=${lab.id}"><i class="fa fa-sign-out fa-fw"></i>
                                                    Upload Assignment</a>
                                            </ul>

                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </c:forEach>
                </ul>
                <!-- /.nav-second-level -->
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>
</div>
