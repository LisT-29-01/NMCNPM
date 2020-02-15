package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.RegionSupport;
import java.util.ArrayList;
import model.Customer;

public final class account_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Contact | MELODY</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/price-range.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/animate.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
        
      out.write("\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("error.jsp");
        return;
      }
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("         \n");
      out.write("            <div class=\"container\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "category.jsp", out, false);
      out.write("\n");
      out.write("                <div class=\"col-sm-9 padding-right\">\n");
      out.write("                    <div class=\"row\">    \t\t\n");
      out.write("                        <div class=\"col-sm-12\">    \t\t\t   \t\t\t\n");
      out.write("                            <h2 class=\"title text-center\">My Account</h2>    \t\t\t    \t\t\t\t    \t\t\t\t                           \n");
      out.write("                        </div>\t\t\t \t\t\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-6 padding-right\" style=\"width: 400px\">\n");
      out.write("                            <h3 style=\"color: #FC9A11\">Details</h3><br>\n");
      out.write("                            <form id=\"main-contact-form\" method=\"post\">\n");
      out.write("                                <div>\n");
      out.write("                                    <b>Name:</b> <input type=\"text\" name=\"name\" class=\"form-control\" value=\"");
      out.print(customer.getName());
      out.write("\">\n");
      out.write("                                <input type=\"hidden\" name=\"cus_id\" value=\"");
      out.print(customer.getCustomer_id());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>\n");
      out.write("                                <b>Email:</b> <input disabled class=\"form-control\" value=\"");
      out.print(customer.getEmail());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>\n");
      out.write("                                <b>Phone number:</b> <input type=\"text\" name=\"phone\" class=\"form-control\" value=\"");
      out.print(customer.getPhone());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>\n");
      out.write("                                <b>Address:</b> <textarea name=\"address\" rows=\"3\" class=\"form-control\">");
      out.print(customer.getAddress());
      out.write("</textarea>\n");
      out.write("                            </div>\n");
      out.write("                            <br> \n");
      out.write("                            ");
ArrayList<String> regionList = new RegionSupport().region();
      out.write("\n");
      out.write("                            <div>\n");
      out.write("                                <b>Region:</b>\n");
      out.write("                                <select name=\"region\">\n");
      out.write("                                    ");
for (String region : regionList) {
                                            if (region.equals(customer.getRegion())) {
                                    
      out.write("\n");
      out.write("                                    <option selected=\"selected\">");
      out.print(region);
      out.write("</option>\n");
      out.write("                                    ");
} else {
      out.write("\n");
      out.write("                                    <option>");
      out.print(region);
      out.write("</option>\n");
      out.write("                                    ");
}
                                        }
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>                              \n");
      out.write("                                <input type=\"submit\" name=\"submit\" class=\"btn btn-info\" value=\"Save\"> \n");
      out.write("                                <input type=\"reset\" class=\"btn btn-warning\" value=\"Reset\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6 padding-left\" style=\"width: 400px\">\n");
      out.write("                        <h3 style=\"color: #FC9A11\">Change password</h3><br>\n");
      out.write("                        <form id=\"main-contact-form\" method=\"post\">\n");
      out.write("                            <div>\n");
      out.write("                                <b>Recent password:</b> <input type=\"password\" name=\"name\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>\n");
      out.write("                                <b>New password</b> <input type=\"password\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>\n");
      out.write("                                <b>Retype new password</b> <input type=\"password\" class=\"form-control\">\n");
      out.write("                            </div>                           \n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"pull-right\">                              \n");
      out.write("                                <input type=\"submit\" name=\"submit\" class=\"btn btn-info\" value=\"Save\"> \n");
      out.write("                                <input type=\"reset\" class=\"btn btn-warning\" value=\"Reset\">\n");
      out.write("                            </div>                          \n");
      out.write("                    </div>\n");
      out.write("                </div>  \n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-9 padding-right\">\n");
      out.write("                <div class=\"row\">    \t\t\n");
      out.write("                    <div class=\"col-sm-12\">    \t\t\t   \t\t\t\n");
      out.write("                        <h2 class=\"title text-center\">Order History</h2>    \t\t\t    \t\t\t\t    \t\t\t\t                           \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div><!--/#contact-page-->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
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
