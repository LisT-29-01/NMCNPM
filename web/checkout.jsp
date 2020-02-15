<%-- 
    Document   : checkout
    Created on : Nov 22, 2019, 12:03:00 AM
    Author     : dell
--%>

<%@page import="model.RegionSupport"%>
<%@page import="model.orderItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Order"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out | MELODY</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script>
            function cancel() {
                if (confirm("Cancel Order?") == true) {
                    window.location = "cancel";
                }
            }
        </script>
    </head>
    <body>
        <%
//            Order order = (Order) session.getAttribute("order");
            if (order == null || order.getItems().size() == 0) {
        %>
        <jsp:forward page="error.jsp"></jsp:forward>
        <%}%>
            <section id="cart_items">
                <div class="container">                 
                    <div class="step-one">
                        <h2 class="heading">Cancel Order?</h2>
                    </div>
                    <div class="checkout-options">
                        <ul class="nav">
                            <form>                              
                                <li>
                                    <a id="cancel" onclick="cancel()"><i class="fa fa-times"></i>Cancel</a>
                                </li>
                            </form>
                        </ul>
                    </div><!--/checkout-options-->
                <% String email_err = "", password_err = "";
                    if (request.getAttribute("email_err") != null) {
                        email_err = (String) request.getAttribute("email_err");
                    }
                    if (request.getAttribute("password_err") != null) {
                        password_err = (String) request.getAttribute("password_err");
                    }
//                    Customer customer = (Customer) session.getAttribute("customer");
                    String note;
                    if (customer == null) {
                        note = "Please use Register And Checkout to easily get access to your order history, or use Checkout as Guest";
                    } else {
                        note = "Fill check out form";
                    }
                %>
                <div class="register-req">
                    <p><%=note%></p>
                </div><!--/register-req-->
                <div class="shopper-informations">
                    <div class="row">
                        <%if (customer == null) {%>
                        <div class="col-sm-3">
                            <div class="shopper-info">
                                <p>Login to check out</p>
                                <form action="/eMarket1/loginToCheckOut" method="post">
                                    <input type="text" name="email" placeholder="Email Account *">
                                    <p style="font-size: 15px; color: red"><%=email_err%></p>
                                    <input type="password" name="password" placeholder="Password *">
                                    <p style="font-size: 15px; color: red"><%=password_err%></p>
                                    <input type="submit" value="Login" class="btn btn-primary">
                                </form>
                            </div>
                        </div> 
                        <%}%>
                        <%
                            String cfemail_err = "", cfname_err = "", cfphone_err = "", cfaddress_err = "";
                            if (request.getAttribute("cfemail_err") != null) {
                                cfemail_err = (String) request.getAttribute("cfemail_err");
                            }
                            if (request.getAttribute("cfname_err") != null) {
                                cfname_err = (String) request.getAttribute("cfname_err");
                            }
                            if (request.getAttribute("cfphone_err") != null) {
                                cfphone_err = (String) request.getAttribute("cfphone_err");
                            }
                            if (request.getAttribute("cfaddress_err") != null) {
                                cfaddress_err = (String) request.getAttribute("cfaddress_err");
                            }
                        %>
                        <div class="col-sm-5 clearfix">
                            <div class="bill-to">
                                <%String checkOutForm;
                                    if (customer == null) {
                                        checkOutForm = "Check out as Guest";
                                    } else {
                                        checkOutForm = "Fill up below Form to Check out";
                                    }
                                %>
                                <p><%=checkOutForm%></p>
                                <div class="form-one">
                                    <form action="/eMarket1/confirmCheck" method="post">
                                        <%if (customer != null) {%>
                                        <input type="Email" name="Email" value="<%=customer.getEmail()%>" placeholder="Email Account*">
                                        <p style="font-size: 12px; color: red"><%=cfemail_err%></p>
                                        <input type="text" name="Name" value="<%=customer.getName()%>" placeholder="Full Name *">  
                                        <p style="font-size: 12px; color: red"><%=cfname_err%></p>
                                        <input type="text" name="Phone" value="<%=customer.getPhone()%>" placeholder="Phone number *">  
                                        <p style="font-size: 12px; color: red"><%=cfphone_err%></p>
                                        <%} else {%>
                                        <input type="Email" name="Email" placeholder="Email Account*">
                                        <p style="font-size: 12px; color: red"><%=cfemail_err%></p>
                                        <input type="text" name="Name" placeholder="Full Name *">
                                        <p style="font-size: 12px; color: red"><%=cfname_err%></p>
                                        <input type="text" name="Phone" placeholder="Phone number *">
                                        <p style="font-size: 12px; color: red"><%=cfphone_err%></p>
                                        <%}%>
                                        <input type="text" name="Address" placeholder="Receive Address *">
                                        <p style="font-size: 12px; color: red"><%=cfaddress_err%></p>
                                        <%ArrayList<String> regionList = new RegionSupport().region();%>
                                        <select  name="Region">
                                            <%for (String region : regionList) {%>
                                            <option><%=region%></option>
                                            <%}%>
                                        </select>
                                        <p></p>
                                        <input type="submit" value="Confirm" class="btn btn-primary">
                                    </form>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="order-message">
                                <p>Shipping Order</p>
                                <textarea name="message"  placeholder="Notes about your order, Special Notes for Delivery" rows="16"></textarea>                             
                            </div>	
                        </div>					
                    </div>
                </div>
                <div class="review-payment">
                    <h2>Review & Payment</h2>
                </div>               
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Item</td>
                                <td class="description"></td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (orderItem Items : order.getItems()) {%>
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="images/prod/<%=Items.getProduct().getThumb_image()%>" height="50" width="50" alt=""></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href=""><%=Items.getProduct().getName()%></a></h4>
                                    <p>ID: <%=Items.getProduct().getProduct_id()%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%=Items.getProduct().getPrice()%>$</p>
                                </td>
                                <td class="cart_quantity">
                                    <input class="cart_quantity_input" type="text" name="quantity" value="<%=Items.getQuantity()%>" autocomplete="off" size="2" disabled>
                                </td>
                                <td class="cart_total">
                                    <%  int Sale = 0;
                                        if (Items.getProduct().getStatus() != null) {
                                            if (Items.getProduct().getStatus().matches("^sale.+")) {
                                                Sale = Integer.valueOf(Items.getProduct().getStatus().substring(4, 6));
                                            }
                                        }%>
                                    <p class="cart_total_price"><%=Items.getTotal(Sale)%>$</p>
                                </td>
                            </tr> 
                            <%}%>
                            <tr>
                                <td colspan="4">&nbsp;</td>
                                <td colspan="2">
                                    <table class="table table-condensed total-result">
                                        <tr>
                                            <td>Cart Sub Total</td>
                                            <td><%=order.getSubtotal()%>$</td>
                                        </tr>
                                        <tr>
                                            <td>Eco Tax</td>
                                            <td>2$</td>
                                        </tr>
                                        <tr class="shipping-cost">
                                            <td>Shipping Cost</td>
                                            <td>Free</td>										
                                        </tr>
                                        <tr>
                                            <td>Total</td>
                                            <td><span><%=order.getTotal(2)%>$</span></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
<!--                <div class="payment-options">
                    <span>
                        <label><input type="checkbox"> Direct Bank Transfer</label>
                    </span>
                    <span>
                        <label><input type="checkbox"> Check Payment</label>
                    </span>
                    <span>
                        <label><input type="checkbox"> Paypal</label>
                    </span>
                </div>-->
            </div>
        </section> <!--/#cart_items-->
    </body>
</html>
