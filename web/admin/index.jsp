<%@page import="model.contactDAO"%>
<%@page import="model.CustomerDAOimpl"%>
<%@page import="model.OrderDAOimpl"%>
<%@page import="model.productDAOimpl"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />

        <!-- Page-Level CSS -->
        <link href="assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

    </head>

    <body>
        <!--  wrapper -->
        <div id="wrapper">
            <jsp:include page="tools.jsp"></jsp:include>
                <!--  page-wrapper -->
                <div id="page-wrapper">
                    <div class="row">
                        <!--  page header -->
                        <div class="col-lg-12">
                            <h1 class="page-header">Home</h1>
                        </div>
                        <!-- end  page header -->
                    </div>           
                    <div class="row">
                        <p style="font-size: 24px"><b>&nbsp;&nbsp;Statistic Product</b></p>
                        <div class="col-lg-6">
                        <%ArrayList<Vector> StatByCategory = new productDAOimpl().StatisticByCategory(); %>
                        <!--   Kitchen Sink -->
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: #5bc0de">
                                <b>By Category</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Serial</th>
                                                <th>Category</th>
                                                <th style="text-align: center">Number of products</th>                                             
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                int cnt = 0;
                                                int total = 0;
                                                for (Vector cate : StatByCategory) {
                                                    cnt++;
                                                    total += Integer.parseInt(cate.get(1).toString());
                                            %>
                                            <tr>
                                                <td style="text-align: center"><%=cnt%></td>
                                                <td><%=cate.get(0)%></td>
                                                <td style="text-align: center"><%=cate.get(1)%></td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                                <p><b>Total products in stock: <i style="color: #FC9A11"><%=total%></i> items</b></p>
                            </div>
                        </div>
                        <!-- End  Kitchen Sink -->
                    </div>
                    <div class="col-lg-6">
                        <%ArrayList<Vector> StatByStatus = new productDAOimpl().StatisticByStatus(); %>
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: #5bc0de">
                                <b>By Status</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Serial</th>
                                                <th>Status</th>
                                                <th style="text-align: center">Number of products</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                cnt = 0;
                                                for (Vector status : StatByStatus) {
                                                    cnt++;
                                            %>
                                            <tr>
                                                <td style="text-align: center"><%=cnt%></td>
                                                <%if (status.get(0).toString().matches("^sale.+")) {%>
                                                <td><%="Sale " + status.get(0).toString().substring(4, 6) + "%"%></td>
                                                <%} else {%>
                                                <td><%=status.get(0)%></td>
                                                <%}%>
                                                <td style="text-align: center"><%=status.get(1)%></td>
                                            </tr>    
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- End  Basic Table  -->
                    </div>
                </div>
                <div class="row">            
                    <p style="font-size: 24px"><b>&nbsp;&nbsp;Products sold in the last 3 months</b></p>
                    <div class="col-lg-6">
                        <%ArrayList<Vector> Soldlast3month = new OrderDAOimpl().StatisticBySoldlast3month();%>
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: khaki">
                                <b>Sold amount</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Serial</th>
                                                <th style="text-align: center">Month</th>
                                                <th style="text-align: center">Number of sold products</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                cnt = 0;
                                                total = 0;
                                                for (Vector sold : Soldlast3month) {
                                                    cnt++;
                                                    total += Integer.parseInt(sold.get(1).toString());
                                            %>
                                            <tr style="text-align: center">
                                                <td><%=cnt%></td>
                                                <td><%=sold.get(0)%></td>
                                                <td><%=sold.get(1)%></td>
                                            </tr>     
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                                <p><b>Total sold products: <i style="color: #FC9A11"><%=total%></i> items</b></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: khaki">
                                <b>Income</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Serial</th>
                                                <th style="text-align: center">Month</th>
                                                <th style="text-align: center">Income ($)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                cnt = 0;
                                                float income = 0;
                                                for (Vector sold : Soldlast3month) {
                                                    cnt++;
                                                    income += Float.parseFloat(sold.get(2).toString());
                                            %>
                                            <tr style="text-align: center">
                                                <td><%=cnt%></td>
                                                <td><%=sold.get(0)%></td>
                                                <td><%=sold.get(2)%></td>
                                            </tr>     
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                                <p><b>Total income in last 3 months:</b> <b style="color: #FC9A11"><%=(float) Math.round(income*100)/100%>$</b></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">            
                    <p style="font-size: 24px"><b>&nbsp;&nbsp;Statistic Members & Guests</b></p>
                    <div class="col-lg-6">
                        <%ArrayList<Vector> StatCustomer = new CustomerDAOimpl().StatisticByType();%>
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: hotpink">
                                <b>Customer</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Serial</th>
                                                <th style="text-align: center">Type</th>
                                                <th style="text-align: center">Number of customers</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                cnt = 0;
                                                total = 0;
                                                for (Vector type : StatCustomer) {
                                                    cnt++;
                                                    total += Integer.parseInt(type.get(1).toString());
                                            %>
                                            <tr style="text-align: center">
                                                <td><%=cnt%></td>
                                                <td><%=type.get(0)%></td>
                                                <td><%=type.get(1)%></td>
                                            </tr>     
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                                <p><b>Total customers: <i style="color: #FC9A11"><%=total%></i></b></p>
                            </div>
                        </div>
                    </div>     
                    <div class="col-lg-6">
                        <%ArrayList<Vector> Top3Loyal = new CustomerDAOimpl().Top3LoyalCus();%>
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: hotpink">
                                <b>Top 3 loyal customers this year</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Serial</th>
                                                <th style="text-align: center">Customer ID</th>
                                                <th>Name</th>
                                                <th style="text-align: center">Number of orders</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                cnt = 0;
                                                for (Vector cus : Top3Loyal) {
                                                    cnt++;
                                            %>
                                            <tr>
                                                <td style="text-align: center"><%=cnt%></td>
                                                <td style="text-align: center"><%=cus.get(0)%></td>
                                                <td><%=cus.get(1)%></td>
                                                <td style="text-align: center"><%=cus.get(2)%></td>
                                            </tr>     
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>                             
                            </div>
                        </div>
                    </div>          
                </div>
                <div class="row">
                    <p style="font-size: 24px"><b>&nbsp;&nbsp;Contacts information</b></p>
                    <div class="col-lg-12">
                        <%ArrayList<Vector> contactList = new contactDAO().contactList();%>
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: greenyellow">
                                <b>Contact</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>Contact ID</th>
                                                <th>Email</th>
                                                <th>Sender's name</th>
                                                <th>Subject</th>
                                                <th>Action</th>                                           
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%  int unreply = 0;
                                                for (Vector contact : contactList) {
                                            %>
                                            <tr>
                                                <td><%=contact.get(0)%></td>
                                                <td><%=contact.get(1)%></td>
                                                <td><%=contact.get(2)%></td>
                                                <td><%=contact.get(4)%></td>
                                                <td>
                                                    <% 
                                                        String reply = "replied";
                                                        if (!Boolean.valueOf(contact.get(5).toString())) {
                                                            reply = "detail";
                                                            unreply++;
                                                        }
                                                    %>
                                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#<%=contact.get(0)%>">
                                                        <%=reply%>
                                                    </button>
                                                    <div class="modal fade" id="<%=contact.get(0)%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                    <h4 class="modal-title" id="myModalLabel">Contact ID: <%=contact.get(0)%></h4>
                                                                </div>
                                                                <form role="form" method="get">
                                                                    <div class="modal-body">
                                                                        <div class="form-group">
                                                                            <label>Message</label>
                                                                            <textarea class="form-control" cols="53" rows="3" disabled><%=contact.get(3)%></textarea>
                                                                        </div>
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>                                                              
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div> or   
                                                    <button onclick="cfdelete(<%=contact.get(0)%>)" type="button" class="btn btn-primary btn-xs btn-danger">Delete</button>
                                                </td>
                                            </tr>
                                            <%}%>                                    
                                        </tbody>
                                    </table>
                                </div>
                                <p><b>Unreplied message: <%=unreply%></b></p>
                            </div>
                        </div>
               
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
            function cfdelete(contact_id) {
                if (confirm("Continue delete message " + contact_id + "?") == true) {
                    window.location("DeleteContact?id=" + contact_id);
                }
            }
        </script>
    </body>

</html>
