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
                            <h2 class="page-header">Change Password</h2>
                        </div>
                        <!--end page header -->
                    </div>
                    <div class="col-lg-12">
                        <!-- Form Elements -->
                        <div class="panel panel-default">

                            <div class="panel-body">

                                <div class="row">
                                    <div class="col-lg-6">
                                        <form role="form" name="changepass" onsubmit="return validate()" method="post" action="changePassword">
                                            <div class="form-group">
                                                <label>Recent password:</label>
                                                <input type="password" name="recent" size="20" class="form-control"> 
                                                <input name="admin_id" type="hidden" value="<%=admin.getAdmin_id()%>">
                                            </div>
                                            <div class="form-group">
                                                <label>New password:</label>
                                                <input type="password" name="newpass" size="20" class="form-control">
                                            </div>             

                                            <div class="form-group">
                                                <label>Retype new password:</label>
                                                <input type="password" name="retype" size="20" class="form-control">
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
                                                    var adminPass = "<%=admin.getPassword()%>";
                                                    var recent = document.changepass.recent.value;
                                                    var newpass = document.changepass.newpass.value;
                                                    var retype = document.changepass.retype.value;
                                                    if (recent == "" || recent == null)
                                                        alert("Please enter your recent password!");
                                                    else if (newpass == "" || newpass == null)
                                                        alert("Please enter your new password!");
                                                    else if (retype == "" || retype == null)
                                                        alert("Please retype new password!");
                                                    else if (newpass.length < 8)
                                                        alert("Password  at least 8 characters!");
                                                    else if (newpass != retype)
                                                        alert("Retype password and new password do not match!");
                                                    else if (recent != adminPass)
                                                        alert("Recent password is incorrect!");
                                                    else {
                                                        if (confirm("Continue saving?") == true) {
                                                            alert("Successful!");
                                                            return true;
                                                        }
                                                    }
                                                    return false;
                                                }

        </script>

    </body>
</html>
