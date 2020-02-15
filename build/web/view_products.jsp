<%-- 
    Document   : all_product
    Created on : Nov 22, 2019, 12:53:05 AM
    Author     : dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products | MELODY</title>
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
        <jsp:include page="banner.jsp"></jsp:include>
            <section>
                <div class="container">
                    <div class="row">
                    <jsp:include page="category.jsp"></jsp:include>
                        <div class="col-sm-9 padding-right">
                            <div class="features_items"><!--features_items-->
                                <h2 class="title text-center">Items</h2>
                            <c:if test="${productList.size() == 0}">
                                <p style="color: gray">No items match.</p>
                            </c:if>
                            <c:forEach var = "p" items = "${productList}">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a href="viewDetail?product_id=${p.product_id}">
                                                    <img src="${initParam.imgProductPath}${p.thumb_image}" height ="250" width="50" alt="" />                                       
                                                    <h2>${p.price}${"$"}</h2>
                                                    <p>${p.name}</p>
                                                </a>
                                                <a href="addItem?productId=${p.product_id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </div>
                                            <c:if test="${not empty p.status}">
                                                <img src="images/home/${p.status}.png" class="new" alt="" />
                                            </c:if>
                                        </div>                                    
                                    </div>
                                </div>
                            </c:forEach>
                        </div><!--features_items-->
                        <c:if test="${category_id ne null}">
                            <ul class="pagination">
                                <c:if test = "${currentPage != 1}">
                                    <li><a href="viewProduct?category_id=${category_id}&page=${currentPage-1}">&laquo;</a></li>
                                    </c:if>
                                <li class="active"><a href="viewProduct?category_id=${category_id}&page=${currentPage}">${currentPage}</a></li>
                                    <c:if test="${currentPage lt noOfPages}">
                                    <li><a href="viewProduct?category_id=${category_id}&page=${currentPage+1}">&raquo;</a></li>
                                    </c:if>              
                            </ul>
                        </c:if>
                        <c:if test="${search ne null}">
                            <ul class="pagination">
                                <c:if test = "${currentPage != 1}">
                                    <li><a href="searchProduct?search=${search}&page=${currentPage-1}">&laquo;</a></li>
                                    </c:if>
                                <li class="active"><a href="viewProduct?category_id=${category_id}&page=${currentPage}">${currentPage}</a></li>
                                    <c:if test="${currentPage lt noOfPages}">
                                    <li><a href="searchProduct?search=${search}&page=${currentPage+1}">&raquo;</a></li>
                                    </c:if>              
                            </ul>
                        </c:if>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
