<%-- 
    Document   : banner
    Created on : Nov 21, 2019, 9:52:40 PM
    Author     : dell
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.productDAOimpl"%>
<%@page import="model.Product"%>
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
        <section id="slider"><!--slider-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                                <li data-target="#slider-carousel" data-slide-to="1"></li>
                                <li data-target="#slider-carousel" data-slide-to="2"></li>
                            </ol>
                            <%
                                ArrayList<Product> SaleList = new productDAOimpl().getListSaleProduct();                                    
                            %>
                            <div class="carousel-inner">
                                <%
                                   Product prod = SaleList.get(0);                                    
                                %>
                                <div class="item active">
                                    <div class="col-sm-6">
                                        <h1><span>ME</span>LODY</h1>
                                        <h2>Best Gifts and Souvenirs shop in Vietnam</h2>
                                        <p>Welcome to our fascinating and miracle world! </p>
                                        <a href="viewDetail?product_id=<%=prod.getProduct_id()%>"><button type="button" class="btn btn-default get">Get it now</button></a>
                                    </div>
                                    <div class="col-sm-6">
                                        <img style="height: 360px" src="images/prod/<%= prod.getThumb_image()%>" class="girl img-responsive" alt="" />
                                        <img src="images/home/<%= prod.getStatus()%>b.png"  class="pricing" alt="" />
                                    </div>
                                </div>
                                <% 
                                    for(int i = 1; i < 3; i++){
                                        prod = SaleList.get(i);
                                %> 
                                <div class="item">
                                    <div class="col-sm-6">
                                        <h1><span>ME</span>LODY</h1>
                                        <h2>Best Gifts and Souvenirs shop in Vietnam</h2>
                                        <p>Welcome to our fascinating and miracle world! </p>
                                        <a href="viewDetail?product_id=<%=prod.getProduct_id()%>"><button type="button" class="btn btn-default get">Get it now</button></a>
                                    </div>
                                    <div class="col-sm-6">
                                        <img style="height: 360px" src="images/prod/<%= prod.getThumb_image()%>" class="girl img-responsive" alt="" />
                                        <img src="images/home/<%= prod.getStatus()%>b.png"  class="pricing" alt="" />
                                    </div>
                                </div>
                                <% } %>
                            </div>

                            <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                                <i class="fa fa-angle-left"></i>
                            </a>
                            <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </div>

                    </div>
                </div>
            </div>
        </section><!--/slider-->
    </body>
</html>
