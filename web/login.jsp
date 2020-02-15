<%-- 
    Document   : login
    Created on : Nov 21, 2019, 11:58:50 PM
    Author     : dell
--%>
<%@page import="model.RegionSupport"%>
<%@page import="java.util.ArrayList"%>
<!--https://www.regextester.com/1950-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login & Register | MELODY</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">   
    </head>
    <body>
        <%
            String email_err = "", password_err = "";
            if (request.getAttribute("email_err") != null) {
                email_err = (String) request.getAttribute("email_err");
            }
            if (request.getAttribute("password_err") != null) {
                password_err = (String) request.getAttribute("password_err");
            }
            String rsemail_err = "", rspassword_err = "", rsname_err = "", rsphone_err = "";
            if (request.getAttribute("rsname_err") != null) {
                rsname_err = (String) request.getAttribute("rsname_err");
            }
            if (request.getAttribute("rsemail_err") != null) {
                rsemail_err = (String) request.getAttribute("rsemail_err");
            }
            if (request.getAttribute("rspassword_err") != null) {
                rspassword_err = (String) request.getAttribute("rspassword_err");
            }
            if (request.getAttribute("rsphone_err") != null) {
                rsphone_err = (String) request.getAttribute("rsphone_err");
            }
        %>
            <section id="form"><!--form-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">
                            <div class="login-form"><!--login form-->
                                <h2><b>Login to your account</b></h2>
                                <form name="login" action="/eMarket1/login" onsubmit="return validateLogin()" method="post">
                                    <input type="Email" name="email" placeholder="Email*" />
                                    <p style="color: red"><%=email_err%></p>
                                <input type="password" name="password" placeholder="Password*" />
                                <p style="color: red"><%=password_err%></p>
                                <span>
                                    <input type="checkbox" class="checkbox"> 
                                    Keep me signed in
                                </span>
                                <button type="submit" class="btn btn-default">Login</button>

                            </form>
                        </div><!--/login form-->
                    </div>
                    <div class="col-sm-1">
                        <h2 class="or">OR</h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="signup-form"><!--sign up form-->
                            <h2><b>New User Signup</b></h2>
                            <form name="signup" onsubmit="return validate()" action="/eMarket1/register" method="post">
                                <input type="text" id="cus_name" name="cus_name" placeholder="Name*"/>
                                <p id="name_err" style="color: red"><%=rsname_err%></p>
                                <input type="email" id="cus_email" name="cus_email" placeholder="Email*" pattern="^[a-z][a-z0-9_\.]{3,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,3}$"/>
                                <p style="color: red"><%=rsemail_err%></p>
                                <input type="password" id="cus_pass" name="cus_pass" placeholder="Password*"/>
                                <p style="color: red"><%=rspassword_err%></p>
                                <input type="password" id="cf_pass" name="cf_pass" placeholder="Confirm password*"/>
                                <input type="text" id="cus_phone" name="cus_phone" placeholder="Phone number *"/>
                                <p style="color: red"><%=rsphone_err%></p>
                                <input type="text" id="cus_address" name="cus_address" placeholder="Address"/>
                                <%ArrayList<String> regionList = new RegionSupport().region();%>
                                <select name="cus_region">
                                    <%for(String region : regionList){%>
                                    <option><%=region%></option>
                                    <%}%>
                                </select>
                                <p></p>
                                <button type="submit" class="btn btn-default">Sign Up</button>
                            </form>
                        </div><!--/sign up form-->
                    </div>
                </div>
            </div>
        </section><!--/form-->
        <script type="text/javascript">
            function validate() {
                var name = document.signup.cus_name.value;
                var email = document.signup.cus_email.value;
                var pass = document.signup.cus_pass.value;
                var cfpass = document.signup.cf_pass.value;
                var phone = document.signup.cus_phone.value;
                if (name == "" || name == null)
                    alert("Please enter your name!");
                else if (email == "" || email == null)
                    alert("Please enter your email!");
                else if (phone == "" || phone == null)
                    alert("Please enter your phone number!");
                else if (isNaN(phone) || phone.length < 9)
                    alert("Phone number only contains numbers and at least 9 numbers!");
                else if (pass == "" || pass == null)
                    alert("Please enter your password!");
                else if (pass.length < 8)
                    alert("Password contains at least 8 charaters!");
                else if (cfpass == "" || cfpass == null)
                    alert("Please confirm password!");
                else if (pass != cfpass)
                    alert("Confirm password doesn't match!");
                else {
                        return true;
                }
                return false;
            }
        </script>
        <script>
            function validateLogin(){
                var email = document.login.email.value;
                var pass = document.login.password.value;
                if (email == "" || email == null)
                    alert("Please enter your email!");
                else if (pass == "" || pass == null)
                    alert("Please enter your password!");
                else {
                        return true;
                }
                return false;
            }
        </script>
    </body>
</html>
