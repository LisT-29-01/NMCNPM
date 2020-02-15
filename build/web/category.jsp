<%-- 
    Document   : category
    Created on : Nov 21, 2019, 9:58:24 PM
    Author     : dell
--%>

<%@page import="model.Category"%>
<%@page import="model.categoryDAOimpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <% categoryDAOimpl cateList = new categoryDAOimpl(); %>
        <div class="col-sm-3">
            <div class="left-sidebar">
                <h2>Category</h2>
                <div class="panel-group category-products" id="category"><!--category-productsr-->
                    <% 
                        for(Category parent : cateList.getParentcate()){ 
                    %> 
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <% if(parent.getParent_cate() == -1){ %>
                            <h4 class="panel-title"><a href="viewProduct?category_id=<%= parent.getCategory_id()%>&page=1"><%= parent.getName() %></a></h4>
                            <% }else{ %>
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#category" href="#<%= parent.getCategory_id() %>">
                                    <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                    <%= parent.getName() %>
                                </a>
                            </h4>
                            <% } %>
                        </div>
                        <div id= "<%= parent.getCategory_id()%>" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <% for(Category child : cateList.getChildrencate(parent.getCategory_id())){ %>
                                    <li><a href="viewProduct?category_id=<%= child.getCategory_id()%>&page=1"><%= child.getName() %> </a></li>
                                    <% } %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <% 
                        }
                    %>            
                </div><!--/category-products-->                 
                <div class="shipping text-center"><!--shipping-->
                    <img src="images/home/shipping.jpg" alt="" />
                </div><!--/shipping-->
            </div>
        </div>       
    </body>
</html>
