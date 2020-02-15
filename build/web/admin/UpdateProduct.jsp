<%@page import="model.categoryDAOimpl"%>
<%@page import="model.Category"%>
<%@page import="model.productDAOimpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Management</title>
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <!-- Page-Level CSS -->
        <link href="assets/plugins/social-buttons/social-buttons.css" rel="stylesheet" />
        <link href="assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

    </head>

    <body>
        <!--  wrapper -->
        <div id="wrapper">
            <jsp:include page="tools.jsp"></jsp:include>
            <% ArrayList<Product> AllProduct = new productDAOimpl().getAllProducts(); %>
            <div id="page-wrapper">
                <div class="row">
                    <!--  page header -->
                    <div class="col-lg-12">
                        <h1 class="page-header">Products Management</h1>
                    </div>
                    <!-- end  page header -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <b>Products Details</b>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Product ID</th>
                                                <th>Name</th>
                                                <th>Price</th>
                                                <th>Description</th>
                                                <th>Quantity</th>
                                                <th>Update</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Product prod : AllProduct) {%>
                                            <tr class="gradeA">
                                                <td><%=prod.getProduct_id()%></td>
                                                <td><%=prod.getName()%></td>
                                                <td class="center">$<%=prod.getPrice()%></td>
                                                <td style="width: 350px"><%=prod.getDescription()%></td>
                                                <td class="center"><%=prod.getQuantity()%></td>
                                                <td>
                                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#<%=prod.getProduct_id()%>">
                                                        Edit
                                                    </button>
                                                    <div class="modal fade" id="<%=prod.getProduct_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                    <h4 class="modal-title" id="myModalLabel"><%=prod.getName()%></h4>
                                                                </div>
                                                                <form id="update<%=prod.getProduct_id()%>" onsubmit="return validate(<%=prod.getProduct_id()%>)" action="UpdateProduct" role="form" method="get">
                                                                    <div class="modal-body">
                                                                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../${initParam.imgProductPath}<%=prod.getThumb_image()%>" height="300" width="350" alt="Wrong url"/></p>
                                                                        <br><br>                                                  
                                                                        <div class="form-group">
                                                                            <label>Product ID:&nbsp;&nbsp;</label>
                                                                            <input size="50" class="form-control" disabled value="<%=prod.getProduct_id()%>">
                                                                            <input name="product_id" value="<%=prod.getProduct_id()%>" type="hidden">
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="name" size="50" type="text" class="form-control" value="<%=prod.getName()%>">
                                                                        </div>
                                                                        <br><br>
                                                                        <%ArrayList<Category> cateList = new categoryDAOimpl().getAllChildcate();%>
                                                                        <div class="form-group">
                                                                            <label>Category&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <select name="category" class="form-control">
                                                                                <%for (Category cate : cateList) {
                                                                                        if (prod.getCategory_id() == cate.getCategory_id()) {
                                                                                %>
                                                                                <option selected="selected"><%=cate.getCategory_id()%>. <%=cate.getName()%></option>
                                                                                <%} else {%>
                                                                                <option><%=cate.getCategory_id()%>. <%=cate.getName()%></option>
                                                                                <%}
                                                                                    }%>
                                                                            </select>
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="price" size="50" type="text" class="form-control" value="<%=prod.getPrice()%>">$
                                                                        </div> 
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="quantity" size="50" type="text" class="form-control" value="<%=prod.getQuantity()%>">
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Description:</label>
                                                                            <textarea name="description" class="form-control" cols="53" rows="3"><%=prod.getDescription()%></textarea>
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Detail:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <textarea name="description_detail" class="form-control" cols="53" rows="3"><%=prod.getDescription_detail()%></textarea>
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Information:</label>
                                                                            <input name="information" size="50" type="text" class="form-control" value="<%=prod.getInformation()%>">
                                                                        </div>
                                                                        <br><br>
                                                                        <div class="form-group">
                                                                            <label>Status:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                            <input name="status" size="50" type="text" class="form-control" value="<%=prod.getStatus()%>">
                                                                        </div>       
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                        <button type="reset" class="btn btn-warning">Reset</button>
                                                                        <input type="submit" class="btn btn-primary" value="Save changes">
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div> or   
                                                    <button onclick="cfdelete(<%=prod.getProduct_id()%>)" type="button" class="btn btn-primary btn-xs btn-danger">Delete</button>
                                                </td>
                                            </tr>
                                            <%}%>                                    
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>

            </div>
            <!-- end page-wrapper -->

        </div>
        <!-- end wrapper -->

        <!-- Core Scripts - Include with every page -->
        <script src="assets/plugins/jquery-1.10.2.js"></script>
        <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="assets/plugins/pace/pace.js"></script>
        <script src="assets/scripts/siminta.js"></script>
        <!-- Page-Level Plugin Scripts-->

        <script src="assets/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="assets/plugins/dataTables/dataTables.bootstrap.js"></script>
        <script>
                                                        $(document).ready(function () {
                                                            $('#dataTables-example').dataTable();
                                                        });
        </script>
        <script>
            function cfdelete(product_id) {
                if (confirm("Continue deleting item " + product_id + "?") == true) {
                    window.location("UpdateProduct?product_id=" + product_id);
                }
            }
        </script>
        <script type="text/javascript">
                                            function validate(id) {
                                                var define = "update"+id.toString();
                                                var name = document.getElementById(define).name.value;
                                                var price = document.getElementById(define).price.value;
                                                var quantity = document.getElementById(define).quantity.value;
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
                                                    if(confirm("Continue changing?") == true){   
                                                        alert("Successful!");
                                                        return true;
                                                    }
                                                }
                                                return false;
                                            }
        </script>
    </body>

</html>
