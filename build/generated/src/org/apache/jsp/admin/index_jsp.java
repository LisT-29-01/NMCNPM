package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.contactDAO;
import controller.CustomerDAOimpl;
import controller.OrderDAOimpl;
import controller.productDAOimpl;
import java.util.Vector;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Home</title>\n");
      out.write("        <!-- Core CSS - Include with every page -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <!-- Page-Level CSS -->\n");
      out.write("        <link href=\"assets/plugins/dataTables/dataTables.bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!--  wrapper -->\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "tools.jsp", out, false);
      out.write("\n");
      out.write("                <!--  page-wrapper -->\n");
      out.write("                <div id=\"page-wrapper\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <!--  page header -->\n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <h1 class=\"page-header\">Home</h1>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- end  page header -->\n");
      out.write("                    </div>           \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <p style=\"font-size: 24px\"><b>&nbsp;&nbsp;Statistic Product</b></p>\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                        ");
ArrayList<Vector> StatByCategory = new productDAOimpl().StatisticByCategory(); 
      out.write("\n");
      out.write("                        <!--   Kitchen Sink -->\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\" style=\"background-color: #5bc0de\">\n");
      out.write("                                <b>By Category</b>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped table-bordered table-hover\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th style=\"text-align: center\">Serial</th>\n");
      out.write("                                                <th>Category</th>\n");
      out.write("                                                <th style=\"text-align: center\">Number of products</th>                                             \n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                int cnt = 0;
                                                int total = 0;
                                                for (Vector cate : StatByCategory) {
                                                    cnt++;
                                                    total += Integer.parseInt(cate.get(1).toString());
                                            
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td style=\"text-align: center\">");
      out.print(cnt);
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(cate.get(0));
      out.write("</td>\n");
      out.write("                                                <td style=\"text-align: center\">");
      out.print(cate.get(1));
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <p><b>Total products in stock: <i style=\"color: #FC9A11\">");
      out.print(total);
      out.write("</i> items</b></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- End  Kitchen Sink -->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        ");
ArrayList<Vector> StatByStatus = new productDAOimpl().StatisticByStatus(); 
      out.write("\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\" style=\"background-color: #5bc0de\">\n");
      out.write("                                <b>By Status</b>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped table-bordered table-hover\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th style=\"text-align: center\">Serial</th>\n");
      out.write("                                                <th>Status</th>\n");
      out.write("                                                <th style=\"text-align: center\">Number of products</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                cnt = 0;
                                                for (Vector status : StatByStatus) {
                                                    cnt++;
                                            
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td style=\"text-align: center\">");
      out.print(cnt);
      out.write("</td>\n");
      out.write("                                                ");
if (status.get(0).toString().matches("^sale.+")) {
      out.write("\n");
      out.write("                                                <td>");
      out.print("Sale " + status.get(0).toString().substring(4, 6) + "%");
      out.write("</td>\n");
      out.write("                                                ");
} else {
      out.write("\n");
      out.write("                                                <td>");
      out.print(status.get(0));
      out.write("</td>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                                <td style=\"text-align: center\">");
      out.print(status.get(1));
      out.write("</td>\n");
      out.write("                                            </tr>    \n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- End  Basic Table  -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">            \n");
      out.write("                    <p style=\"font-size: 24px\"><b>&nbsp;&nbsp;Products sold in the last 3 months</b></p>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        ");
ArrayList<Vector> Soldlast3month = new OrderDAOimpl().StatisticBySoldlast3month();
      out.write("\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\" style=\"background-color: khaki\">\n");
      out.write("                                <b>Sold amount</b>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped table-bordered table-hover\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th style=\"text-align: center\">Serial</th>\n");
      out.write("                                                <th style=\"text-align: center\">Month</th>\n");
      out.write("                                                <th style=\"text-align: center\">Number of sold products</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                cnt = 0;
                                                total = 0;
                                                for (Vector sold : Soldlast3month) {
                                                    cnt++;
                                                    total += Integer.parseInt(sold.get(1).toString());
                                            
      out.write("\n");
      out.write("                                            <tr style=\"text-align: center\">\n");
      out.write("                                                <td>");
      out.print(cnt);
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(sold.get(0));
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(sold.get(1));
      out.write("</td>\n");
      out.write("                                            </tr>     \n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <p><b>Total sold products: <i style=\"color: #FC9A11\">");
      out.print(total);
      out.write("</i> items</b></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\" style=\"background-color: khaki\">\n");
      out.write("                                <b>Income</b>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped table-bordered table-hover\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th style=\"text-align: center\">Serial</th>\n");
      out.write("                                                <th style=\"text-align: center\">Month</th>\n");
      out.write("                                                <th style=\"text-align: center\">Income ($)</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                cnt = 0;
                                                float income = 0;
                                                for (Vector sold : Soldlast3month) {
                                                    cnt++;
                                                    income += Float.parseFloat(sold.get(2).toString());
                                            
      out.write("\n");
      out.write("                                            <tr style=\"text-align: center\">\n");
      out.write("                                                <td>");
      out.print(cnt);
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(sold.get(0));
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(sold.get(2));
      out.write("</td>\n");
      out.write("                                            </tr>     \n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <p><b>Total income in last 3 months:</b> <b style=\"color: #FC9A11\">");
      out.print(income);
      out.write("$</b></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">            \n");
      out.write("                    <p style=\"font-size: 24px\"><b>&nbsp;&nbsp;Statistic Members & Guests</b></p>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        ");
ArrayList<Vector> StatCustomer = new CustomerDAOimpl().StatisticByType();
      out.write("\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\" style=\"background-color: hotpink\">\n");
      out.write("                                <b>Customer</b>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped table-bordered table-hover\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th style=\"text-align: center\">Serial</th>\n");
      out.write("                                                <th style=\"text-align: center\">Type</th>\n");
      out.write("                                                <th style=\"text-align: center\">Number of customers</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                cnt = 0;
                                                total = 0;
                                                for (Vector type : StatCustomer) {
                                                    cnt++;
                                                    total += Integer.parseInt(type.get(1).toString());
                                            
      out.write("\n");
      out.write("                                            <tr style=\"text-align: center\">\n");
      out.write("                                                <td>");
      out.print(cnt);
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(type.get(0));
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(type.get(1));
      out.write("</td>\n");
      out.write("                                            </tr>     \n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <p><b>Total customers: <i style=\"color: #FC9A11\">");
      out.print(total);
      out.write("</i></b></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>     \n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        ");
ArrayList<Vector> Top3Loyal = new CustomerDAOimpl().Top3LoyalCus();
      out.write("\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\" style=\"background-color: hotpink\">\n");
      out.write("                                <b>Top 3 loyal customers this year</b>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped table-bordered table-hover\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th style=\"text-align: center\">Serial</th>\n");
      out.write("                                                <th style=\"text-align: center\">Customer ID</th>\n");
      out.write("                                                <th>Name</th>\n");
      out.write("                                                <th style=\"text-align: center\">Number of orders</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");

                                                cnt = 0;
                                                for (Vector cus : Top3Loyal) {
                                                    cnt++;
                                            
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td style=\"text-align: center\">");
      out.print(cnt);
      out.write("</td>\n");
      out.write("                                                <td style=\"text-align: center\">");
      out.print(cus.get(0));
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(cus.get(1));
      out.write("</td>\n");
      out.write("                                                <td style=\"text-align: center\">");
      out.print(cus.get(2));
      out.write("</td>\n");
      out.write("                                            </tr>     \n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>                             \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>          \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    ");
ArrayList<Vector> contactList = new contactDAO().contactList();
      out.write("\n");
      out.write("                    <!-- Advanced Tables -->\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <b>Contact</b>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"table-responsive\">\n");
      out.write("                                <table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Contact ID</th>\n");
      out.write("                                            <th>Email</th>\n");
      out.write("                                            <th>Sender's name</th>\n");
      out.write("                                            <th>Subject</th>\n");
      out.write("                                            <th>Action</th>                                           \n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        ");
for (Vector contact : contactList) {
      out.write("\n");
      out.write("                                        <tr class=\"gradeA\">\n");
      out.write("                                            <td>");
      out.print(contact.get(0));
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(contact.get(1));
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(contact.get(2));
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(contact.get(4));
      out.write("</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                ");
String reply= "reply";
                                                    if ((boolean) contact.get(6)) {
                                                        reply = "replied";
                                                    }
                                                
      out.write("\n");
      out.write("                                                <button class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#");
      out.print(contact.get(0));
      out.write("\">\n");
      out.write("                                                    ");
      out.print(reply);
      out.write("\n");
      out.write("                                                </button>\n");
      out.write("                                                <div class=\"modal fade\" id=\"");
      out.print(contact.get(0));
      out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                                    <div class=\"modal-dialog\">\n");
      out.write("                                                        <div class=\"modal-content\">\n");
      out.write("                                                            <div class=\"modal-header\">\n");
      out.write("                                                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                                                                <h4 class=\"modal-title\" id=\"myModalLabel\">Order ID: ");
      out.print(contact.get(0));
      out.write("</h4>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <form role=\"form\" method=\"get\">\n");
      out.write("                                                                <div class=\"modal-body\">\n");
      out.write("                                                                    <p>Message</p>\n");
      out.write("                                                                    <textarea rows=\"5\" class=\"form-control\">\n");
      out.write("                                                                        ");
      out.print(contact.get(5));
      out.write("\n");
      out.write("                                                                    </textarea>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"modal-footer\">\n");
      out.write("                                                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>                                                              \n");
      out.write("                                                                </div>\n");
      out.write("                                                            </form>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div> or   \n");
      out.write("                                                <button onclick=\"cfdelete(");
      out.print(contact.get(0));
      out.write(")\" type=\"button\" class=\"btn btn-primary btn-xs btn-danger\">Delete</button>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");
}
      out.write("                                    \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--End Advanced Tables -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- end page-wrapper -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- end wrapper -->\n");
      out.write("\n");
      out.write("        <!-- Core Scripts - Include with every page -->\n");
      out.write("        <script src=\"assets/plugins/jquery-1.10.2.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/bootstrap/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/pace/pace.js\"></script>\n");
      out.write("        <script src=\"assets/scripts/siminta.js\"></script>\n");
      out.write("        <!-- Page-Level Plugin Scripts-->\n");
      out.write("        <script src=\"assets/plugins/dataTables/jquery.dataTables.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/dataTables/dataTables.bootstrap.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                                                    $(document).ready(function () {\n");
      out.write("                                                        $('#dataTables-example').dataTable();\n");
      out.write("                                                    });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            function cfdelete(contact_id) {\n");
      out.write("                if (confirm(\"Continue delete message \"+contact_id+\"?\") == true) {\n");
      out.write("                    window.location(\"DeleteContact?id=\"+contact_id);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
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
