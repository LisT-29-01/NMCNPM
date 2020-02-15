<%-- 
    Document   : header
    Created on : Nov 21, 2019, 9:20:23 PM
    Author     : dell
--%>

<%@page import="model.Order"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="contact.jsp"><i class="fa fa-phone"></i> +37 9696 690</a></li>
                                    <li><a href="contact.jsp"><i class="fa fa-envelope"></i> contact@melody.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->
            <% Customer customer = (Customer) session.getAttribute("customer");
                String login = "Login | Signup";
                if (customer != null) {
                    login = "Logout";
                }%>
            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="index.jsp"><img height="75" width="150" src="images/home/melody.png" alt="" /></a>
                            </div>                           
                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right"><br>
                                <ul class="nav navbar-nav">
                                    <%if (customer != null) {%>
                                    <li><a href="account.jsp"><i class="fa fa-user"></i><%=customer.getName()%></a></li>
                                            <%}%>
                                            <%Order order = (Order) session.getAttribute("order");
                                                if (order != null)
                                                    if (order.getItems().size() > 0) {
                                            %>
                                    <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                        <%}%>
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                                        <% if (login.equals("Login | Signup")) {%>
                                    <li><a href="login.jsp"><i class="fa fa-lock"></i><%=login%></a></li> 
                                            <% } else {%>
                                    <li><a href="logout"><i class="fa fa-lock"></i><%=login%></a></li>
                                            <% } %>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="index.jsp" class="active">Home</a></li>
                                    <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <%
                                                if (order != null)
                                                    if (order.getItems().size() > 0) {
                                            %>
                                            <li><a href="checkout.jsp">Checkout</a></li> 
                                                <%}%>
                                            <li><a href="cart.jsp">Cart</a></li> 
                                        </ul>
                                    </li>                              

                                    <li><a href="contact.jsp">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="search_box pull-right">
                                <input id="searchbox" type="text" placeholder="Search">
                                <script>
                                    document.getElementById("searchbox").onkeypress = function () {
                                        searchFunction()
                                    };

                                    function searchFunction() {
                                        if (event.keyCode === 13) {
                                            if(document.getElementById("searchbox").value == "")
                                                alert("Enter search value!");
                                            else
                                                window.location = "searchProduct?search=" + document.getElementById("searchbox").value + "&page=1";
                                        }
                                    }
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->
    </body>
</html>
