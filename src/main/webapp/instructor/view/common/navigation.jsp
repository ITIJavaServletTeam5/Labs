<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="" draggable="false">Labs System</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
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
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <c:forEach items="${sessionScope.courses}" var="course">
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> <c:out value="${course.name}" /><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <c:forEach items="${course.labs}" var="lab">
                                    <!--                            <li>
                                                                    <a href="#">Course1 <span class="fa arrow"></span></a>
                                                                    <ul class="nav nav-third-level">-->
                                    <li draggable="true" id="${lab.id}"  ondrop="drop(event);alert(${lab.id});window.location = '${pageContext.request.contextPath}/instructor/view/transferqueues?labid=${lab.id}'" ondragover="allowDrop(event)">
                                        <a href="#"><c:out value="${lab.name}" /> <span class="fa arrow"></span></a>
                                        <ul class="nav nav-third-level">
                                            <li >
                                                <a href="${pageContext.request.contextPath}/instructor/view/Assignments">
                                                    <!--<input type="hidden" <c:set var="assignment" scope="session" value="${lab}"/> />-->
                                                    Assignments
                                                </a>
                                                <a href="${pageContext.request.contextPath}/instructor/view/QueuesList?labid=${lab.id}">
                                                    <!--<input type="hidden" <c:set var="lab" scope="session" value="${lab}"/> />-->
                                                    Queues
                                                </a>
                                            </li>

                                        </ul>
                                    </li>
                                </c:forEach>
                                <!--                                </ul>
                                                                 /.nav-third-level 
                                                            </li>-->
                                <!--
                                                            <li>
                                                                <a href="#">Course2 <span class="fa arrow"></span></a>
                                                                <ul class="nav nav-third-level">-->
                                <!--                                    <li>
                                                                        <a href="#">Lab <span class="fa arrow"></span></a>
                                                                        <ul class="nav nav-third-level">
                                                                            <li>
                                                                                <a href="Assignments.html">Assignments</a>
                                                                                <a href="Queue.html">Queues</a>
                                                                            </li>
                                
                                                                        </ul>
                                                                    </li>-->

                                <!--                                </ul>
                                                                 /.nav-third-level 
                                                            </li>-->
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </c:forEach>
                    <!--                                        <li>
                                                                <a href="#"><i class="fa fa-sitemap fa-fw"></i> Group2<span class="fa arrow"></span></a>
                                                                <ul class="nav nav-second-level">
                                        
                                                                    <li>
                                                                        <a href="#">Course1 <span class="fa arrow"></span></a>
                                                                        <ul class="nav nav-third-level">
                                                                            <li>
                                                                                <a href="#">Lab <span class="fa arrow"></span></a>
                                                                                <ul class="nav nav-third-level">
                                                                                    <li>
                                                                                        <a href="tables.html">Assignments</a>
                                                                                        <a href="Queue.html">Queues</a>
                                                                                    </li>
                                        
                                                                                </ul>
                                                                            </li>
                                        
                                                                        </ul>
                                                                         /.nav-third-level 
                                                                    </li>
                                        
                                                                    <li>
                                                                        <a href="#">Course2 <span class="fa arrow"></span></a>
                                                                        <ul class="nav nav-third-level">
                                                                            <li>
                                                                                <a href="#">Lab <span class="fa arrow"></span></a>
                                                                                <ul class="nav nav-third-level">
                                                                                    <li>
                                                                                        <a href="Assignments.html">Assignments</a>
                                                                                        <a href="Queue.html">Queues</a>
                                                                                    </li>
                                        
                                                                                </ul>
                                                                            </li>
                                        
                                                                        </ul>
                                                                         /.nav-third-level 
                                                                    </li>
                                                                </ul>
                                                                 /.nav-second-level 
                                                            </li>-->

                </ul>
            </div><br/>
            <div class="btn btn-outline btn-primary" ondragstart="drag(event)" draggable="true" id="dragable">Transfer queue</div>
            <div class="btn btn-outline btn-primary" onclick="window.location = '${pageContext.request.contextPath}/instructor/view/cancelqueues'" >Cancel Queues</div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>
</div>
<script>
    function allowDrop(ev) {
//        alert("drop allowed");
        ev.preventDefault();
    }

    function drag(ev) {
//        alert("drag started");
        ev.dataTransfer.setData("text", ev.target.id);
    }

    function drop(ev) {
        ev.preventDefault();
        var data = ev.dataTransfer.getData("text");
        alert("drop happenned  " + ev.target.id);
        
//        ev.target.appendChild(document.getElementById(data));
    }
</script>
