<%-- 
    Document   : confirmation
    Created on : Nov 26, 2019, 12:38:10 AM
    Author     : dell
--%>

<%@page import="model.Customer"%>
<%@page import="model.orderItem"%>
<%@page import="model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation | MELODY</title>       
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
//            Order order = (Order) session.getAttribute("order");
            if(order == null || order.getItems().size() == 0){
        %>
        <jsp:forward page="error.jsp"></jsp:forward>
        <%}
//            Customer customer = (Customer) session.getAttribute("customer");
            if(customer.getType().equals("Guest")){
                session.removeAttribute("customer");
            }
            session.removeAttribute("order");
        %>
            <section>
                <div class="container">
                    <div class="row">
                    <jsp:include page="category.jsp"></jsp:include>
                        <div class="col-sm-9">
                            <div class="blog-post-area">
                                <h2 class="title text-center">CONFIRMATION</h2>
                                <div style="background-color: gainsboro">
                                    <br>
                                    <h4><b>Your order has been successful processed and will be deliver within 24hours.</b></h4>
                                    <br>
                                    <p>Please keep note of your confirmation number: <b style="font-size: 15px"><%=order.getConfirm_number()%></b> </p>
                                <p>If your have any query concerning your order feel free to <a href="contact.jsp">contact us</a></p> 
                                <p>Thank you to shopping at <b style="color: #FC9A11">Me</b><b style="color: gray">lody</b> ! See you soon!</p>
                                <br>
                            </div>
                        </div>
                        <br>
                        <div class="blog-post-area">
                            <h2 class="title text-center">ORDER DETAILS</h2>
                            <div class="col-sm-6">
                                <h4><b>Cart Details</b></h4>
                                <div style="background-color: gainsboro" class="table-responsive cart_info">
                                    <table class="table table-condensed">
                                        <thead>
                                            <tr class="cart_menu">
                                                <td class="description"><b>Description</b></td>
                                                <td class="price"><b>Price</b></td>
                                                <td class="quantity"><b>Quantity</b></td>
                                                <td class="total"><b>Total</b></td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (orderItem Items : order.getItems()) {%>
                                            <tr>
                                                <td class="cart_description">
                                                    <h5><%=Items.getProduct().getName()%></h5>
                                                    <h5>ID: <%=Items.getProduct().getProduct_id()%></h5>
                                                </td>
                                                <td class="cart_price">
                                                    <p>$<%=Items.getProduct().getPrice()%></p>
                                                </td>
                                                <td class="cart_quantity">
                                                    <p><%=Items.getQuantity()%><p>
                                                </td>
                                                <td class="cart_total">
                                                    <%  int Sale = 0;
                                                        if (Items.getProduct().getStatus() != null) {
                                                            if (Items.getProduct().getStatus().matches("^sale.+")) {
                                                                Sale = Integer.valueOf(Items.getProduct().getStatus().substring(4, 6));
                                                            }
                                                        }%>
                                                    <p class="cart_total_price">$<%=Items.getTotal(Sale)%></p>
                                                </td>
                                            </tr> 
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <h4><b>Customer Details</b></h4>
                                <div style="background-color: gainsboro">
                                    <p><b>Customer:</b> <%=customer.getName()%></p>
                                    <p><b>Address:</b> <%=order.getAddress()%></p>
                                    <p><b><%=customer.getRegion()%></b></p>
                                    <p>-----------------------------------------------------------------------------</p>
                                    <p><b>Email:</b> <%=customer.getEmail()%></p>
                                    <p><b>Phone number:</b> <%=customer.getPhone()%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
