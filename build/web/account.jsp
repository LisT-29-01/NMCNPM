<%-- 
    Document   : contact
    Created on : Nov 22, 2019, 12:29:42 AM
    Author     : dell
--%>

<%@page import="model.orderItem"%>
<%@page import="model.OrderDAOimpl"%>
<%@page import="model.Order"%>
<%@page import="model.RegionSupport"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account | MELODY</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head>
    <body>
        <%
//            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
        %>
        <jsp:forward page="error.jsp"></jsp:forward>
        <%}%>       
            <div class="container">
            <jsp:include page="category.jsp"></jsp:include>
                <div class="col-sm-9 padding-right">
                    <div class="row">    		
                        <div class="col-sm-12">    			   			
                            <h2 class="title text-center">My Account</h2>    			    				    				                           
                        </div>			 		
                        <div class="col-sm-6 padding-right">
                            <h3 style="color: #FC9A11">Information</h3><br>
                            <form name="update" action="UpdateAccount" onsubmit="return updateValidate()" method="post">
                                <div>
                                    <b>Name:</b> <input type="text" name="name" class="form-control" value="<%=customer.getName()%>" placeholder="Name *">
                                <input type="hidden" name="customer_id" value="<%=customer.getCustomer_id()%>">
                            </div>
                            <br>
                            <div>
                                <b>Email:</b> <input disabled class="form-control" value="<%=customer.getEmail()%>" placeholder="Email *">
                            </div>
                            <br>
                            <div>
                                <b>Phone number:</b> <input type="text" name="phone" class="form-control" value="<%=customer.getPhone()%>" placeholder="Phone number *">
                            </div>
                            <br>
                            <div>
                                <b>Address:</b> <textarea name="address" rows="3" class="form-control" placeholder="Address"><%=customer.getAddress()%></textarea>
                            </div>
                            <br> 
                            <%ArrayList<String> regionList = new RegionSupport().region();%>
                            <div>
                                <b>Region:</b>
                                <select name="region"  class="form-control">
                                    <%for (String region : regionList) {
                                            if (region.equals(customer.getRegion())) {
                                    %>
                                    <option selected="selected"><%=region%></option>
                                    <%} else {%>
                                    <option><%=region%></option>
                                    <%}
                                        }%>
                                </select>
                            </div>
                            <br>
                            <div>                              
                                <input type="submit" name="submit" class="btn btn-info" value="Save"> 
                                <input type="reset" class="btn btn-warning" value="Reset">
                            </div>

                        </form>
                    </div>
                    <div class="col-sm-6 padding-left">
                        <h3 style="color: #FC9A11">Change password</h3><br>
                        <form name="changePass" action="changePassword" onsubmit="return validatePass()" method="post">
                            <input type="hidden" name="customer_id" value="<%=customer.getCustomer_id()%>">
                            <div>
                                <b>Recent password:</b> <input type="password" name="recent" class="form-control">
                            </div>
                            <br>
                            <div>
                                <b>New password</b> <input type="password" name="newpass" class="form-control">
                            </div>
                            <br>
                            <div>
                                <b>Retype new password</b> <input type="password" name="retype" class="form-control">
                            </div>                           
                            <br>
                            <div class="pull-right">                              
                                <input type="submit" name="submit" class="btn btn-info" value="Save"> 
                                <input type="reset" class="btn btn-warning" value="Reset">
                            </div> 
                        </form>
                    </div>
                </div><br><br>
                <div class="row">    		
                    <div class="col-sm-12">    			   			
                        <h2 class="title text-center">Order History</h2>    			    				    				                           
                    </div>
                </div>
                <%
                    ArrayList<Order> orderList = new OrderDAOimpl().getOrderByCustomer(customer.getCustomer_id());

                %>                
                <div>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Date create</th> 
                                            <th>Bill ($)</th>
                                            <th>Quantity</th>
                                            <th>Detail</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Order orderItem : orderList) {%>
                                        <tr>
                                            <td><%=orderItem.getOrder_id()%></td>
                                            <td><%=orderItem.getDate_created()%></td>
                                            <td><%=orderItem.getTotal(2)%></td>
                                            <td><%=orderItem.getNumberOfItems()%></td>
                                            <td>
                                                <button class="btn btn-xs btn-info" data-toggle="modal" data-target="#<%=orderItem.getOrder_id()%>">
                                                    Detail
                                                </button>
                                                <div class="modal fade" id="<%=orderItem.getOrder_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                <h4 class="modal-title" id="myModalLabel">Order ID: <%=orderItem.getOrder_id()%></h4>
                                                            </div>

                                                            <div class="modal-body">
                                                                <p><b>Confirmation number: <%=orderItem.getConfirm_number()%></b></p>
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
                                                                                    <%for (orderItem item : orderItem.getItems()) {%>
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
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>    
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div><br>
            </div>
        </div>
            <script type="text/javascript">
                function updateValidate() {
                    var name = document.update.name.value;
                    var phone = document.update.phone.value;
                    if (name == "" || name == null)
                        alert("Please enter your name!");
                    else if (phone == "" || phone == null)
                        alert("Please enter your phone number!");
                    else if (isNaN(phone) || phone.length < 9)
                        alert("Phone number only contains numbers and at least 9 numbers!");
                    else {
                        if (confirm("Continue saving?") == true)
                            return true;
                    }
                    return false;
                }               
            </script>
            <script type="text/javascript">
                function validatePass() {
                    var userPass = "<%=customer.getPassword()%>";
                    var recent = document.changePass.recent.value;
                    var newpass = document.changePass.newpass.value;
                    var retype = document.changePass.retype.value;
                    if (recent == "" || recent == null)
                        alert("Please enter your recent password!");
                    else if (newpass == "" || newpass == null)
                        alert("Please enter your new password!");
                    else if (retype == "" || retype == null)
                        alert("Please retype new password!");
                    else if (newpass.length < 8)
                        alert("Password contains at least 8 characters!");
                    else if (newpass != retype)
                        alert("Retype password and new password do not match!");
                    else if (recent != userPass)
                        alert("Recent password is incorrect!");
                    else {
                        if (confirm("Continue saving?") == true){
                            alert("Successful!");
                            return true;
                        }
                    }
                    return false;
                }

        </script>
    </body>
</html>
