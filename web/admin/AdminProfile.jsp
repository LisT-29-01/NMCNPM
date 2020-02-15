<%-- 
    Document   : AdminProfile
    Created on : Dec 2, 2019, 12:33:12 PM
    Author     : dell
--%>

<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        

    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="tools.jsp"></jsp:include>
            <%Admin admin = (Admin) session.getAttribute("admin");%>
            <div id="page-wrapper">
                <div class="row">
                    <div class="row">
                        <!-- page header -->
                        <div class="col-lg-12">
                            <h1 class="page-header">My Account</h1>
                        </div>
                        <!--end page header -->
                    </div>
                    <div class="col-lg-12">
                        <!-- Form Elements -->
                        <div class="panel panel-default">
<!--                            <div class="panel-heading">
                                <b>Your Account</b>
                            </div>-->
                            <div class="panel-body">

                                <div class="row">
                                    <div class="col-lg-6">
                                        <form role="form" name="adminForm" onsubmit="return validate()" method="post" action="UpdateAdmin">
                                            <input name="admin_id" id="admin_id" type="hidden" value="<%=admin.getAdmin_id()%>"> 
                                            <div class="form-group">
                                                <label>Name:</label>
                                                <input name="name" id="name" class="form-control" value="<%=admin.getName()%>">                                               
                                            </div>
                                            <div class="form-group">
                                                <label>Date of birth:</label>
                                                <input name="dob" id="dob"  class="form-control" type="date" value="<%=admin.getDOB()%>">                                               
                                            </div>
                                            <div class="form-group">
                                                <label>Phone number:</label>
                                                <input name="phone" id="phone"  class="form-control" value="<%=admin.getPhone()%>">                                               
                                            </div>
                                            <div class="form-group">
                                                <label>Email:</label>
                                                <input disabled class="form-control" value="<%=admin.getEmail()%>">                                               
                                            </div>                           
                                            <input type="submit" class="btn btn-primary" value="Save">                                      
                                            <button type="reset" class="btn btn-success">Reset</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
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
                var name = document.adminForm.name.value;
                var phone = document.adminForm.phone.value;
                var dob = document.adminForm.dob.value;
                if (name == "" || name == null)
                    alert("Please enter your name!");
                else if (phone == "" || phone == null)
                    alert("Please enter your phone number!");
                else if (isNaN(phone) || phone.length < 9)
                    alert("Phone number only contains numbers and at least 9 numbers!");
                else if (dob == "" || dob == null)
                    alert("Please enter your date of birth!");
                else {
                    if (confirm("Continue saving?") == true)
                        return true;
                }
                return false;
            }
        </script>

    </body>
</html>
