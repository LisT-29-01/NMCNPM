<%-- 
    Document   : cart
    Created on : Nov 21, 2019, 11:48:41 PM
    Author     : dell
--%>

<%@page import="model.orderItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart | MELODY</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script>
            function return_pre_page() {
                history.back();
            }
        </script>
    </head>
    <body>
            <section id="cart_items">
                <div class="container">
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
                        <%
//                            Order order = (Order) session.getAttribute("order");
                            if (order == null) {
                                order = new Order();
                                session.setAttribute("order", order);
                            }
                        %>
                        <tbody>
                            <%
                                for (orderItem Item : order.getItems()) {
                            %>
                            <tr>
                                <td class="cart_product">
                                    <a href="/viewProduct?product_id=<%=Item.getProduct().getProduct_id()%>"><img src="${initParam.imgProductPath}<%=Item.getProduct().getThumb_image()%>" height="50" width="50" alt=""></a>
                                </td>
                                <td class="cart_description">
                                    <h4><%=Item.getProduct().getName()%></a</h4>
                                    <%String sale = "No";
                                        if (Item.getProduct().getStatus() != null) {
                                            if (Item.getProduct().getStatus().matches("^sale.+")) {
                                                sale = Item.getProduct().getStatus().substring(4, 6) + "%";
                                            }
                                        }
                                    %>
                                    <p style="font-size: 12">ID: <%=Item.getProduct().getProduct_id()%> sale: <%=sale%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%=Item.getProduct().getPrice()%></p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <form action="/eMarket1/updateItem" method="get">
                                            <input class="cart_quantity_input" height="20" type="number" name="quantity" min="0" max="<%=Item.getProduct().getQuantity()%>" value="<%=Item.getQuantity()%>" autocomplete="off" size="2">
                                            <input type="submit" value="update">
                                            <input type="hidden" name="productId" value="<%=Item.getProduct().getProduct_id()%>">
                                        </form>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <%  int Sale = 0;
                                        if (Item.getProduct().getStatus() != null) {
                                            if (Item.getProduct().getStatus().matches("^sale.+")) {
                                                Sale = Integer.valueOf(Item.getProduct().getStatus().substring(4, 6));
                                            }
                                        }%>
                                    <p class="cart_total_price"><%=Item.getTotal(Sale)%>$</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" onclick="return cfdelete()" href="removeItem?productId=<%=Item.getProduct().getProduct_id()%>"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <div class="heading">
                    <h3>What would you like to do next?</h3>
                    <a onclick="return_pre_page()">&raquo;Continue Shopping&laquo;</a>                                      
                </div><br>
                <div class="row">                 
                    <div class="col-sm-6">
                        <h2 class="title text-center">Contact Info</h2>
                        <div class="chose_area">
                            <address style="text-align: left">
                                <b>
                                <p>Melody</p>
                                <p>1 Dai Co Viet, Hai Ba Trung, Ha Noi</p>
                                <p>Hanoi, Vietnam</p>
                                <p>Mobile: +37 9696 690</p> 
                                <p>Email: contact@melody.com</p>
                                </b>
                                <a href="contact.jsp">Contact us</a>
                            </address>
                            <!--                            <ul class="user_info">
                                                            <li class="single_field">
                                                                <label>Country:</label>
                                                                <select>
                                                                    <option>United States</option>
                                                                    <option>Bangladesh</option>
                                                                    <option>UK</option>
                                                                    <option>India</option>
                                                                    <option>Pakistan</option>
                                                                    <option>Ucrane</option>
                                                                    <option>Canada</option>
                                                                    <option>Dubai</option>
                                                                    <option>Vietnam</option>
                                                                </select>
                            
                                                            </li>
                                                            <li class="single_field">
                                                                <label>Region / State:</label>
                                                                <select>
                                                                    <option>Select</option>
                                                                    <option>Dhaka</option>
                                                                    <option>London</option>
                                                                    <option>Dillih</option>
                                                                    <option>Lahore</option>
                                                                    <option>Alaska</option>
                                                                    <option>Canada</option>
                                                                    <option>Dubai</option>
                                                                </select>
                            
                                                            </li>
                            
                                                        </ul>-->
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <h2 class="title text-center">Check out</h2>
                        <div class="total_area">
                            <ul>
                                <li>Cart Sub Total <span><%=order.getSubtotal()%>$</span></li>
                                <li>Eco Tax <span>2$</span></li>
                                <li>Shipping Cost <span>Free</span></li>
                                <li>Total <span><%=order.getTotal(2)%>$</span></li>
                            </ul> 
                            <% if (order.getItems().size() > 0) {%>
                            <a class="btn btn-default check_out" href="checkout.jsp">Check Out</a>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </section><!--/#do_action-->
        <script>
            function cfdelete(){
                if(confirm("Continue deleting item?") == true)
                    return true;
                else 
                    return false;
            }
        </script>
    </body>
</html>
