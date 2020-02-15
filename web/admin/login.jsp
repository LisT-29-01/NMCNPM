<%-- 
    Document   : login
    Created on : Nov 27, 2019, 11:23:52 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bootsrtap Free Admin Template - SIMINTA | Admin Dashboad Template</title>
        <!-- Core CSS - Include with every page -->
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="assets/css/main-style.css" rel="stylesheet" />
        <script src="assets/plugins/jquery-1.10.2.js"></script>
        <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
    </head>
    <%
        String email_err = "", password_err = "";
        if (request.getAttribute("email_err") != null) {
            email_err = (String) request.getAttribute("email_err");
        }
        if (request.getAttribute("password_err") != null) {
            password_err = (String) request.getAttribute("password_err");
        }
    %>
    <body class="body-Login-back">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 text-center logo-margin ">
                    <img height="100" width="200" src="../images/home/melodyadmin.png" alt=""/>
                </div>
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">                  
                        <div class="panel-heading">
                            <h3 class="panel-title"><b>Sign In</b></h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="Login" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="E-mail" name="email" type="email">
                                        <p style="color: red; font-size: 13px"><%=email_err%></p>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" type="password">
                                        <p style="color: red; font-size: 13px"><%=password_err%></p>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <input type="submit" class="btn btn-lg btn-success btn-block" value="Login">
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
