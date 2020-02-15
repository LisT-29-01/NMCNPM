<%-- 
    Document   : product.jsp
    Created on : Nov 21, 2019, 10:45:04 PM
    Author     : dell
--%>

<%@page import="model.productDAOimpl"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
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
        <div class="col-sm-9 padding-right">
            <%
                ArrayList<Product> listHotProd = new productDAOimpl().getListHotProduct();
            %>
            <div class="features_items"><!--features_items-->
                <h2 class="title text-center">Hot Items</h2>
                <%
                    for (Product prod : listHotProd) {
                %>
                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">
                                <a href="viewDetail?product_id=<%=prod.getProduct_id()%>">
                                <img src="${initParam.imgProductPath}<%= prod.getThumb_image()%>" height="250" alt="" />
                                <h2><%= prod.getPrice()%>$</h2>
                                <p><%= prod.getName()%></p>
                                </a>
                                <a href="addItem?productId=<%=prod.getProduct_id()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                            </div>
                            <img src="images/home/hot.png" class="new" alt="" />    
                        </div>                     
                    </div>
                </div>
                <% } %>
            </div><!--features_items-->
            <div class="recommended_items"><!--recommended_items-->
                <h2 class="title text-center">recommended items</h2>
                <%              
                    ArrayList<Product> listSaleProd = new productDAOimpl().getListSaleProduct();
                %>
                <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="item active">
                            <%
                                for (int i = 0; i < 3; i++) {
                                    Product prod = listSaleProd.get(i);
                            %>
                            <div class="col-sm-4">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <a href="viewDetail?product_id=<%=prod.getProduct_id()%>">
                                            <img src="${initParam.imgProductPath}<%= prod.getThumb_image()%>" height="170" alt="" />
                                            <h2><%=prod.getPrice()%>$</h2>
                                            <p><%=prod.getName()%></p>
                                            </a>
                                            <a href="addItem?productId=<%=prod.getProduct_id()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>
                                        <img src="images/home/sale.png" class="new" alt="" />    
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </div>
                        <%  
                            int limit = 0;
                            if(listSaleProd.size() > 12)
                                limit = 12;
                            else
                                limit = listSaleProd.size();
                            for(int i = 0; i < (int)limit/3 - 1; i++){
                        %>
                        
                        <div class="item">
                            <%
                                for(int j = 3*i+3; j < 3*i+6; j++){
                                    Product prod = listSaleProd.get(j);                           
                            %>
                            <div class="col-sm-4">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <a href="viewDetail?product_id=<%=prod.getProduct_id()%>">
                                            <img src="${initParam.imgProductPath}<%=prod.getThumb_image()%>" height="170" alt="" />
                                            <h2><%=prod.getPrice()%>$</h2>
                                            <p><%=prod.getName()%></p>
                                            </a>                                           
                                            <a href="addItem?productId=<%=prod.getProduct_id()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>
                                        <img src="images/home/sale.png" class="new" alt="" /> 
                                    </div>
                                </div>
                            </div>
                            <%}%>                                                  
                        </div>
                    <%}%>
                    </div>
                    <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>			
                </div>
            </div><!--/recommended_items-->

        </div>
    </body>
</html>
