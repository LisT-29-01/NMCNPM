<%@page import="model.CustomerDAOimpl"%>
<%@page import="model.Customer"%>
<%@page import="model.productDAOimpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Manangement</title>
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
            <% ArrayList<Customer> AllCustomer = new CustomerDAOimpl().SearchAllCustomer(); %>
            <div id="page-wrapper">
                <div class="row">
                    <!--  page header -->
                    <div class="col-lg-12">
                        <h1 class="page-header">Customers Management</h1>
                    </div>
                    <!-- end  page header -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <b>Customer Details</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Customer ID</th>
                                                <th>Name</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                                <th>Address</th>
                                                <th>Region</th>
                                                <th>Type</th>
                                                <th>Update</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Customer cus : AllCustomer) {%>
                                            <tr class="gradeA">
                                                <td><%=cus.getCustomer_id()%></td>
                                                <td><%=cus.getName()%></td>
                                                <td class="center"><%=cus.getPhone()%></td>
                                                <td><%=cus.getEmail()%></td>
                                                <td style="width: 160px"><%=cus.getAddress()%></td>
                                                <td><%=cus.getRegion()%></td>
                                                <td><%=cus.getType()%></td>
                                                <td>
                                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#<%=cus.getCustomer_id()%>">
                                                        Detail
                                                    </button>
                                                    <div class="modal fade" id="<%=cus.getCustomer_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                    <h4 class="modal-title" id="myModalLabel"><%=cus.getName()%></h4>
                                                                </div>
                                                                <form role="form">
                                                                    <div class="modal-body">           
                                                                        <div class="form-group">
                                                                            <label>Customer ID:&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input size="50" class="form-control" disabled value="<%=cus.getCustomer_id()%>">
                                                                            <input name="customer_id" value="<%=cus.getCustomer_id()%>" type="hidden">
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="name" size="50" type="text" class="form-control" disabled value="<%=cus.getName()%>">
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Phone number:</label>
                                                                            <input name="phone" size="50" type="text" class="form-control" disabled value="<%=cus.getPhone()%>">
                                                                        </div> 
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input size="50" type="text" disabled class="form-control" value="<%=cus.getEmail()%>">                 
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="address" size="50" disabled type="text" class="form-control" value="<%=cus.getAddress()%>">
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Region:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="region" size="50" disabled type="text" class="form-control" value="<%=cus.getRegion()%>">
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Type:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="type" size="50" disabled type="text" class="form-control" value="<%=cus.getType()%>">
                                                                        </div>       
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div> or   
                                                    <button onclick="cfdelete(<%=cus.getCustomer_id()%>)" type="button" class="btn btn-primary btn-xs btn-danger">Delete</button>

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
            function cfdelete(cus_id) {
                if (confirm("Continue deleting customer "+cus_id+"?") == true) {
                    alert("Successful!");
                    window.location("UpdateCustomer?customer_id="+cus_id);
                }
            }
        </script>
    </body>

</html>
