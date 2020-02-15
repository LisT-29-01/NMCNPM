<%-- 
    Document   : product_details
    Created on : Nov 21, 2019, 11:19:28 PM
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
        <title>Single | Melody</title>
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
        <script>
            function changeImage(link) {
                document.getElementById("headImage").src = link
            }
        </script>
    </head>
    <body>
        <jsp:include page="banner.jsp"></jsp:include>
            <section>
                <div class="container">
                    <div class="row">
                    <jsp:include page="category.jsp"></jsp:include>
                    <%
                        Product prod = (Product) request.getAttribute("prod");
                        ArrayList<String> images = prod.getAllImages();
                    %>
                    <div class="col-sm-9 padding-right">
                        <div class="product-details"><!--product-details-->
                            <div class="col-sm-5">
                                <div class="view-product">
                                    <img id="headImage" src="${initParam.imgProductPath}<%=prod.getThumb_image()%>" height="400" width="300" alt="" />                               
                                </div>
                                <div id="similar-product" class="carousel slide" data-ride="carousel">                
                                    <!-- Wrapper for slides -->
                                    <div class="carousel-inner">
                                        <%
                                            int numberOfimage = 3;
                                            if(images.size() < 3){
                                                numberOfimage = images.size();
                                            }       
                                        %>
                                        <div class="item active">
                                            <% for (int i = 0; i < numberOfimage; i++) {
                                                    String image = images.get(i);%>
                                            <img onclick="changeImage('images/prod/<%=image%>')" src="${initParam.imgProductPath}<%=image%>" height="80" width="90" alt=""> 
                                            <% } %>
                                        </div>                                       
                                        <%if(images.size()>3){ %>
                                        <div class="item">
                                            <%
                                                for (int j = 3; j < images.size(); j++) {
                                                    String image = images.get(j);
                                            %>                  
                                            <img onclick="changeImage('images/prod/<%=image%>')" src="${initParam.imgProductPath}<%=image%>" height="90" width="90" alt="">
                                            <%}%>

                                        </div> 
                                        <%}%>
                                    </div>

                                    <!-- Controls -->
                                    <a class="left item-control" href="#similar-product" data-slide="prev">
                                        <i class="fa fa-angle-left"></i>
                                    </a>
                                    <a class="right item-control" href="#similar-product" data-slide="next">
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-7">
                                <div class="product-information"><!--/product-information-->
                                    <% if(prod.getStatus() != null){%>
                                    <img src="images/product-details/<%=prod.getStatus()%>.jpg" class="newarrival" alt="" />
                                    <%}%>
                                    <h2><%=prod.getName()%></h2>
                                    <p>Product ID: <%=prod.getProduct_id()%></p>

                                    <span>
                                        <span><%=prod.getPrice()%>$</span>           
                                        <a href="addItem?productId=<%=prod.getProduct_id()%>">
                                            <button type="button" class="btn btn-fefault cart">
                                                <i class="fa fa-shopping-cart"></i>
                                                Add to cart
                                            </button>
                                        </a>
                                    </span>
                                    <p><b>Quantity in Stock:</b> <%=prod.getQuantity()%></p>
                                    <%
                                        String sale = "No";
                                        if (prod.getStatus() != null) {
                                            if (prod.getStatus().matches("^sale.+")) {
                                                sale = prod.getStatus().substring(4, 6) + "%";
                                            }
                                        }
                                    %>
                                    <p><b>Sale:</b> <%=sale%></p>
                                    <p><b>Description:</b><br> <%=prod.getDescription()%></p>
                                    <p><b>Information:</b><br> <%=prod.getInformation()%></p>
                                    <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>                            

                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->

                        <div class="category-tab shop-details-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li><a href="#details" data-toggle="tab">Details</a></li>
                                    <li><a href="#companyprofile" data-toggle="tab">Company Profile</a></li>
                                    <li><a href="#tag" data-toggle="tab">Tag</a></li>
                                    <li class="active"><a href="#reviews" data-toggle="tab">Reviews (5)</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">                              

                                <div class="tab-pane fade" id="details" >
                                        <p><%=prod.getDescription_detail()%></p>
                                </div>                           
                                <div class="tab-pane fade active in" id="reviews" >
                                    <div class="col-sm-12">
                                        <ul>
                                            <li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
                                            <li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
                                            <li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
                                        </ul>
                                        <p><b>Write Your Review</b></p>

                                        <form action="#">
                                            <span>
                                                <input type="text" placeholder="Your Name"/>
                                                <input type="email" placeholder="Email Address"/>
                                            </span>
                                            <textarea name="" ></textarea>                                           
                                            <button type="button" class="btn btn-default pull-right">
                                                Submit
                                            </button>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div><!--/category-tab-->

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
                                                Product Reprod = listSaleProd.get(i);
                                        %>
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <a href="viewDetail?product_id=<%=Reprod.getProduct_id()%>">
                                                            <img src="${initParam.imgProductPath}<%= Reprod.getThumb_image()%>" height="170" alt="" />
                                                            <h2><%=Reprod.getPrice()%>$</h2>
                                                            <p><%=Reprod.getName()%></p>
                                                        </a>
                                                        <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                    </div>
                                                    <img src="images/home/sale.png" class="new" alt="" />    
                                                </div>
                                            </div>
                                        </div>
                                        <%}%>
                                    </div>
                                    <%
                                        int limit = 0;
                                        if (listSaleProd.size() > 12) {
                                            limit = 12;
                                        } else {
                                            limit = listSaleProd.size();
                                        }
                                        for (int i = 0; i < (int) limit / 3 - 1; i++) {
                                    %>

                                    <div class="item">
                                        <%
                                            for (int j = 3 * i + 3; j < 3 * i + 6; j++) {
                                                Product Reprod = listSaleProd.get(j);
                                        %>
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <a href="viewDetail?product_id=<%=Reprod.getProduct_id()%>">
                                                            <img src="${initParam.imgProductPath}<%=Reprod.getThumb_image()%>" height="170" alt="" />
                                                            <h2><%=Reprod.getPrice()%>$</h2>
                                                            <p><%=Reprod.getName()%></p>
                                                        </a>
                                                        <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
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
                </div>
            </div>
        </section>
    </body>
</html>
