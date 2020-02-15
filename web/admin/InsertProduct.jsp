<%-- 
    Document   : dashboard
    Created on : Nov 28, 2019, 12:19:06 PM
    Author     : dell
--%>

<%@page import="model.categoryDAOimpl"%>
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.productDAOimpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Product</title>
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />

    </head>
    <body>
        <div id="wrapper">

            <jsp:include page="tools.jsp"></jsp:include>
                <div id="page-wrapper">
                    <div class="row">
                        <!-- page header -->
                        <div class="col-lg-12">
                            <h1 class="page-header">New Product</h1>
                        </div>
                        <!--end page header -->
                    </div>
                <%int product_id = new productDAOimpl().getNewProductID();%>
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Form Elements -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                New Product Information
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <form role="form" name="insertProduct" onsubmit="return validate()" action="InsertProduct" method="get">
                                            <div class="form-group">
                                                <label>Product ID</label>
                                                <input class="form-control" value="<%=product_id%>" disabled>    
                                                <input name="product_id" value="<%=product_id%>" type="hidden">
                                            </div>
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input name="name" class="form-control" placeholder="Product name">
                                            </div>
                                            <%ArrayList<Category> cateList = new categoryDAOimpl().getAllChildcate();%>
                                            <div class="form-group">
                                                <label>Category</label>
                                                <select name="category" class="form-control">
                                                    <%for (Category cate : cateList) {%>
                                                    <option><%=cate.getCategory_id()%>. <%=cate.getName()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Price</label>
                                                <input name="price" class="form-control" placeholder="Price $">
                                            </div>
                                            <div class="form-group">
                                                <label>Quantity</label>
                                                <input name="quantity" class="form-control" placeholder="Quantity">
                                            </div>
                                            <div class="form-group">
                                                <label>Description</label>
                                                <input name="description" class="form-control" placeholder="Description">
                                            </div>
                                            <div class="form-group">
                                                <label>Status</label>
                                                <input name="status" class="form-control" placeholder="Status">
                                            </div>
                                            <div class="form-group">
                                                <label>Image</label><br>
                                                <i>image1:</i> <input name="image1" type="file">
                                                <i>image2:</i> <input name="image2" type="file">
                                                <i>image3:</i> <input name="image3" type="file">
                                                <i>image4:</i> <input name="image4" type="file">
                                                <i>image5:</i> <input name="image5" type="file">
                                            </div>
                                            <div class="form-group">
                                                <label>Information</label>
                                                <textarea name="information" placeholder="Write information of new product..." class="form-control" rows="3"></textarea>
                                            </div>
                                            <div class="form-group">
                                                <label>Description detail</label>
                                                <textarea name="description_detail" placeholder="Write description..." class="form-control" rows="3"></textarea>
                                            </div>
                                            <button type="submit" class="btn btn-primary">Add</button>
                                            <button type="reset" class="btn btn-warning">Reset</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Form Elements -->
                    </div>
                </div>
            </div>
        </div>
        <!-- Core Scripts - Include with every page -->
        <script src="assets/plugins/jquery-1.10.2.js"></script>
        <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="assets/plugins/pace/pace.js"></script>
        <script src="assets/scripts/siminta.js"></script>
        <script type="text/javascript">
                                            function validate() {
                                                var name = document.insertProduct.name.value;
                                                var price = document.insertProduct.price.value;
                                                var quantity = document.insertProduct.quantity.value;
                                                if (name == "" || name == null)
                                                    alert("Please enter product's name!");
                                                else if (price == "" || price == null)
                                                    alert("Please enter product's price!");
                                                else if (isNaN(price))
                                                    alert("Price only contain number!");
                                                else if (quantity == "" || quantity == null)
                                                    alert("Please enter product's quantity!");
                                                else if (isNaN(quantity))
                                                    alert("Quantity only contain number!");
                                                else {
                                                    alert("Insert new product successfully!")
                                                    return true;
                                                }
                                                return false;
                                            }
        </script>
    </body>
</html>
