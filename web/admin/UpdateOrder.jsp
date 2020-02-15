<%@page import="model.CustomerDAOimpl"%>
<%@page import="model.Customer"%>
<%@page import="model.orderItem"%>
<%@page import="model.OrderDAOimpl"%>
<%@page import="model.Order"%>
<%@page import="model.productDAOimpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Orders Management</title>
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <!-- Page-Level CSS -->
        <link href="assets/plugins/social-buttons/social-buttons.css" rel="stylesheet" />
        <link href="assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />


    </head>

    <body>
        <!--  wrapper -->
        <div id="wrapper">
            <jsp:include page="tools.jsp"></jsp:include>
            <% ArrayList<Order> AllOrder = new OrderDAOimpl().getAllOrder(); %>
            <div id="page-wrapper">
                <div class="row">
                    <!--  page header -->
                    <div class="col-lg-12">
                        <h1 class="page-header">Orders Management</h1>
                    </div>
                    <!-- end  page header -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <b>Orders Details</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Amount</th>
                                                <th>Confirmation number</th>
                                                <th>Address</th>
                                                <th>Date created</th>
                                                <th>Bill ($)</th>
                                                <th>Update</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Order order : AllOrder) {%>
                                            <tr class="gradeA">
                                                <td><%=order.getOrder_id()%></td>
                                                <td class="center"><%=order.getNumberOfItems()%></td>
                                                <td class="center"><%=order.getConfirm_number()%></td>
                                                <td style="width: 250px"><%=order.getAddress()%></td>
                                                <td style="width: 100px"><%=order.getDate_created()%></td>
                                                <td class="center"><%=order.getTotal(2)%></td>
                                                <td>
                                                    <%String complete = "completed";
                                                        if (!order.isComplete()) {
                                                            complete = "check";
                                                        }
                                                    %>
                                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#<%=order.getOrder_id()%>">
                                                        <%=complete%>
                                                    </button>
                                                    <div class="modal fade" id="<%=order.getOrder_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                    <h4 class="modal-title" id="myModalLabel">Order ID: <%=order.getOrder_id()%></h4>
                                                                </div>
                                                                <form role="form" method="get">
                                                                    <div class="modal-body">
                                                                        <% Customer cus = new CustomerDAOimpl().SearchCustomerByID(order.getCustomer_id());%>
                                                                        <div class="panel panel-primary">
                                                                            <div class="panel-heading">
                                                                                <b>Customer Detail</b>
                                                                            </div>
                                                                            <div class="panel-body">
                                                                                <p>Customer ID: <%=cus.getCustomer_id()%></p>
                                                                                <p>Name: <%=cus.getName()%></p>
                                                                                <p>Email: <%=cus.getEmail()%></p>
                                                                                <p>Phone number: <%=cus.getPhone()%></p>
                                                                                <p>Type: <%=cus.getType()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="panel panel-default">
                                                                            <div class="panel-heading">
                                                                                <b>Items of order</b>
                                                                            </div>
                                                                            <div class="panel-body">
                                                                                <div class="table-responsive">
                                                                                    <table class="table table-striped table-bordered table-hover">
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th>Product ID</th>
                                                                                                <th>Name</th>
                                                                                                <th>Quantity</th>
                                                                                            </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                            <%for (orderItem item : order.getItems()) {%>
                                                                                            <tr>
                                                                                                <td><%=item.getProduct().getProduct_id()%></td>
                                                                                                <td><%=item.getProduct().getName()%></td>
                                                                                                <td><%=item.getQuantity()%></td>
                                                                                            </tr>
                                                                                            <%}%>
                                                                                        </tbody>
                                                                                    </table>
                                                                                </div>
                                                                            </div>
                                                                        </div>


                                                                   
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                        <%if (order.isComplete()) {%>
                                                                        <button class="btn btn-primary" disabled>Completed</button>
                                                                        <%} else {%>
                                                                        <button type="button" onclick="completeorder(<%=order.getOrder_id()%>)" class="btn btn-primary">Check</button>                                  
                                                                        <%}%>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div> or   
                                                    <button onclick="cfdelete(<%=order.getOrder_id()%>)" type="button" class="btn btn-primary btn-xs btn-danger">Delete</button>
                                                </td>
                                            </tr>
                                            <%}%>                                    
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>

            </div>
            <!-- end page-wrapper -->

        </div>
        <!-- end wrapper -->

        <!-- Core Scripts - Include with every page -->
        <script src="assets/plugins/jquery-1.10.2.js"></script>
        <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="assets/plugins/pace/pace.js"></script>
        <script src="assets/scripts/siminta.js"></script>
        <!-- Page-Level Plugin Scripts-->
        <script src="assets/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="assets/plugins/dataTables/dataTables.bootstrap.js"></script>
        <script>
                                                        $(document).ready(function () {
                                                            $('#dataTables-example').dataTable();
                                                        });
        </script> 
        <script>
            function completeorder(order_id) {
                if (confirm("Continue completing order " + order_id + "?") == true) {
                    alert("Successful!");
                    window.location("UpdateOrder?command=check&order_id=" + order_id);
                }
            }
        </script>
        <script>
            function cfdelete(order_id) {
                if (confirm("Continue delete order "+order_id+"?") == true) {
                    window.location("UpdateOrder?command=delete&order_id="+order_id);
                }
            }
        </script>
    </body>

</html>
