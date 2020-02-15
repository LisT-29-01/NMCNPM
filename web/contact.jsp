<%-- 
    Document   : contact
    Created on : Nov 22, 2019, 12:29:42 AM
    Author     : dell
--%>

<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact | MELODY</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head>
    <body>
            <div id="contact-page" class="container">
                <div class="bg">
                    <div class="row">    		
                        <div class="col-sm-12">    			   			
                            <h2 class="title text-center">Contact <strong>Us</strong></h2>    			    				    				
                            <div id="gmap" style="height: 500px;text-align: center" class="contact-map">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.63087390313!2d105.84039951455307!3d21.007428693882964!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab8a922653a9%3A0x6c2ec19683313eab!2zMSDEkOG6oWkgQ-G7kyBWaeG7h3QsIEPhuqd1IEThu4FuLCBIYWkgQsOgIFRyxrBuZywgSMOgIE7hu5lpLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1575894237916!5m2!1svi!2s" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>                            </div>
                        </div>			 		
                    </div> 
                    <%
//                        Customer customer = (Customer) session.getAttribute("customer");
                    %>
                    <div class="row">  	
                        <div class="col-sm-8">
                            <div class="contact-form">
                                <h2 class="title text-center">Get In Touch</h2>
                                <div class="status alert alert-success" style="display: none">Successful!</div>
                                <form action="contact" onsubmit="send()" class="contact-form row" name="contact-form" method="get">
                                    <%if(customer != null){%>
                                    <div class="form-group col-md-6">
                                        <input type="text" name="name" class="form-control" required="required" value="<%=customer.getName()%>" placeholder="Name">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <input type="email" name="email" class="form-control" required="required" value="<%=customer.getEmail()%>" placeholder="Email">
                                    </div>
                                    <%}else{%>
                                    <div class="form-group col-md-6">
                                        <input type="text" name="name" class="form-control" required="required" placeholder="Name">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <input type="email" name="email" class="form-control" required="required" placeholder="Email">
                                    </div>
                                    <%}%>
                                    <div class="form-group col-md-12">
                                        <input type="text" name="subject" class="form-control" required="required" placeholder="Subject">
                                    </div>
                                    <div class="form-group col-md-12">
                                        <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"></textarea>
                                    </div>                        
                                    <div class="form-group col-md-12">
                                        <input type="submit" class="btn btn-warning pull-right" value="Send">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="contact-info">
                                <h2 class="title text-center">Contact Info</h2>
                                <address>
                                    <p>Melody</p>
                                    <p>1 Dai Co Viet, Hai Ba Trung, Ha Noi</p>
                                    <p>Hanoi, Vietnam</p>
                                    <p>Mobile: +37 9696 690</p> 
                                    <p>Email: contact@melody.com</p>
                                </address>
                                <div class="social-networks">
                                    <h2 class="title text-center">Social Networking</h2>
                                    <ul>
                                        <li>
                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                        </li>
                                        <li>
                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                        </li>
                                        <li>
                                            <a href="#"><i class="fa fa-google-plus"></i></a>
                                        </li>
                                        <li>
                                            <a href="#"><i class="fa fa-youtube"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>    			
                    </div>  
                </div>	
            </div><!--/#contact-page-->
        <script>
            function send(){
                alert("Your message is successfully sended to us. \n\
                        We will reply as soon as possible, please check your email usually so as not to miss our response. \n\
                        Thank you for helping Melody!");
            }
        </script>
    </body>
</html>
