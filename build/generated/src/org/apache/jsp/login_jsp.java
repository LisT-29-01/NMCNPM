package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.RegionSupport;
import java.util.ArrayList;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--https://www.regextester.com/1950-->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login & Register | MELODY</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/price-range.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/animate.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/responsive.css\" rel=\"stylesheet\">   \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <section id=\"form\"><!--form-->\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-4 col-sm-offset-1\">\n");
      out.write("                            <div class=\"login-form\"><!--login form-->\n");
      out.write("                                <h2><b>Login to your account</b></h2>\n");
      out.write("                                <form action=\"/eMarket1/login\" method=\"post\">\n");
      out.write("                                    <input type=\"Email\" name=\"email\" placeholder=\"Email*\" />\n");
      out.write("                                    <p style=\"color: red\">");
      out.print(email_err);
      out.write("</p>\n");
      out.write("                                <input type=\"password\" name=\"password\" placeholder=\"Password*\" />\n");
      out.write("                                <p style=\"color: red\">");
      out.print(password_err);
      out.write("</p>\n");
      out.write("                                <span>\n");
      out.write("                                    <input type=\"checkbox\" class=\"checkbox\"> \n");
      out.write("                                    Keep me signed in\n");
      out.write("                                </span>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-default\">Login</button>\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div><!--/login form-->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-1\">\n");
      out.write("                        <h2 class=\"or\">OR</h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <div class=\"signup-form\"><!--sign up form-->\n");
      out.write("                            <h2><b>New User Signup</b></h2>\n");
      out.write("                            <form name=\"signup\" onsubmit=\"return validate()\" action=\"/eMarket1/register\" method=\"post\">\n");
      out.write("                                <input type=\"text\" id=\"cus_name\" name=\"cus_name\" placeholder=\"Name*\"/>\n");
      out.write("                                <p id=\"name_err\" style=\"color: red\">");
      out.print(rsname_err);
      out.write("</p>\n");
      out.write("                                <input type=\"email\" id=\"cus_email\" name=\"cus_email\" placeholder=\"Email*\" pattern=\"^[a-z][a-z0-9_\\.]{3,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,3}$\"/>\n");
      out.write("                                <p style=\"color: red\">");
      out.print(rsemail_err);
      out.write("</p>\n");
      out.write("                                <input type=\"password\" id=\"cus_pass\" name=\"cus_pass\" placeholder=\"Password*\"/>\n");
      out.write("                                <p style=\"color: red\">");
      out.print(rspassword_err);
      out.write("</p>\n");
      out.write("                                <input type=\"text\" id=\"cus_phone\" name=\"cus_phone\" placeholder=\"Phone number *\"/>\n");
      out.write("                                <p style=\"color: red\">");
      out.print(rsphone_err);
      out.write("</p>\n");
      out.write("                                <input type=\"text\" id=\"cus_address\" name=\"cus_address\" placeholder=\"Address\"/>\n");
      out.write("                                ");
ArrayList<String> regionList = new RegionSupport().region();
      out.write("\n");
      out.write("                                <select name=\"cus_region\">\n");
      out.write("                                    ");
for(String region : regionList){
      out.write("\n");
      out.write("                                    <option>");
      out.print(region);
      out.write("</option>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <p></p>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-default\">Sign Up</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div><!--/sign up form-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section><!--/form-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validate() {\n");
      out.write("                var name = document.signup.cus_name.value;\n");
      out.write("                var email = document.signup.cus_email.value;\n");
      out.write("                var pass = document.signup.cus_pass.value;\n");
      out.write("                var phone = document.signup.cus_phone.value;\n");
      out.write("                if (name == \"\" || name == null)\n");
      out.write("                    document.getElementById(\"name_err\").value = \"Please enter your email!\";\n");
      out.write("//                    alert(\"Please enter your name!\");\n");
      out.write("                else if (email == \"\" || email == null)\n");
      out.write("                    alert(\"Please enter your email!\");\n");
      out.write("                else if (phone == \"\" || phone == null)\n");
      out.write("                    alert(\"Please enter your phone number!\");\n");
      out.write("                else if (isNaN(phone) || phone.length < 9)\n");
      out.write("                    alert(\"Phone number only contains numbers and at least 9 numbers.\");\n");
      out.write("                else if (pass == \"\" || pass == null)\n");
      out.write("                    alert(\"Please enter your password!\");\n");
      out.write("                else if (pass.length < 8)\n");
      out.write("                    alert(\"Password contains at least 8 charaters.\");\n");
      out.write("                else {\n");
      out.write("                        return true;\n");
      out.write("                }\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
