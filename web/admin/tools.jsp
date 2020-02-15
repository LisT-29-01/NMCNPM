<%-- 
    Document   : footer
    Created on : Nov 27, 2019, 11:50:13 PM
    Author     : dell
--%>

<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   
    <body>
        <%Admin admin = (Admin) session.getAttribute("admin");      
        if(admin == null){
        %> 
        <jsp:forward page="login.jsp"></jsp:forward>
        <%}%>
        <nav class="navbar-default navbar-static-side" role="navigation">
            <!-- sidebar-collapse -->
            <div class="sidebar-collapse">
                <!-- side-menu -->
                <ul class="nav" id="side-menu">
                    <li>
                        <!-- user image section-->
                        <div class="user-section">
                            <div class="user-section-inner">
                                <a href="index.jsp"><img height="40" width="35" src="assets/img/<%=admin.getAvatar()%>" alt="wrong url"></a>
                            </div>
                            <div class="user-info">
                                <div><strong><%=admin.getName()%></strong></div>
                                <div class="user-text-online">
                                    <span class="user-circle-online btn btn-success btn-circle "></span>Online
                                </div>
                            </div>
                        </div>
                        <!--end user image section-->
                    </li>
                    <li class="sidebar-search">
                        <!-- search section-->
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!--end search section-->
                    </li>
                    <li class="">
                        <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i>Products Management<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="InsertProduct.jsp">Insert</a>
                            </li>
                            <li>
                                <a href="UpdateProduct.jsp">Update</a>
                            </li>
                        </ul>
                        <!-- second-level-items -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i>Customers Management<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">                  
                            <li>
                                <a href="UpdateCustomer.jsp">Update</a>
                            </li>
                        </ul>
                        <!-- second-level-items -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i>Orders Management<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="UpdateOrder.jsp">Update</a>
                            </li>
                        </ul>
                        <!-- second-level-items -->
                    </li>
              

                </ul>
                <!-- end side-menu -->
            </div>
            <!-- end sidebar-collapse -->
        </nav>      
        <!-- end navbar side -->       
    </body>
</html>
