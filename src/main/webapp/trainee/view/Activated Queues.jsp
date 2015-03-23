
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    
    
    
    
    

<head>
    <jsp:include page="/common/view/head.jsp" />
    <title>
        Activated Queues
    </title>

    
</head>

<body>
    <jsp:include page="/trainee/view/Navigation.jsp" />
    
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Queues</h1>
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
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Assistance Queue
                        </div>
                        <!-- /.panel-heading -->
                        <c:choose>
                    <c:when test="${not empty requestScope.AssistenceQueues}">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Order</th>
                                        <th>Name</th>
                                        
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.AssistenceQueues}" var="AssistenceQueues" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                             
                                            <td>${AssistenceQueues.userName}</td>
                                            <td>
                                                <form action="/RequestAssistance" method="get">
                                                   
                                                        <button type="button" class="btn btn-outline btn-primary">Request Assistance
                                                    </button>
                                                </form>
                                            </td>
                                            <td>
                                                <form action="/RequestDelivery" method="post">
                                                    <button type="button" class="btn btn-outline btn-primary">Request Delivery
                                                    </button>
                                                </form>
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
                        <div>There's no trainees to display</div>
                    </c:otherwise>
                </c:choose>
                        
                        <!-- /.panel-body -->
                  
					 <button type="button" class="btn btn-outline btn-primary">Request Assistance</button>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
				
                <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Delivery Queue
                        </div>
                        <!-- /.panel-heading -->
                        <c:choose>
                    <c:when test="${not empty requestScope.DeliveryQueues}">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Order</th>
                                        <th>Name</th>
                                        
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.AssistenceQueues}" var="AssistenceQueues" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${AssistenceQueues.userName}</td>
                                            <td>
                                                <form action="/RequestAssistance" method="Get">
                                                   
                                                        <button type="button" class="btn btn-outline btn-primary">Request Assistance
                                                    </button>
                                                </form>
                                            </td>
                                            <td>
                                                <form action="/RequestDelivery" method="Get">
                                                    <button type="button" class="btn btn-outline btn-primary">Request Delivery
                                                    </button>
                                                </form>
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
                        <div>There's no trainees to display</div>
                    </c:otherwise>
                </c:choose>
                        
                        <!-- /.panel-body -->
                  
					 <button type="button" class="btn btn-outline btn-primary">Request Delivery</button>
                    <!-- /.panel -->
                </div>
					
                   
                        <!-- /.panel-heading -->
                      
                               
                             
                        <!-- /.panel-body -->
                  
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
                
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
				
             </div>
        <!-- /#wrapper -->
        <jsp:include page="/common/view/scripts.jsp" />
            </div>
    </body>
</html>