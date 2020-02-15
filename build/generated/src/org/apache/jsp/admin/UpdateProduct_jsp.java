package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.categoryDAOimpl;
import model.Category;
import controller.productDAOimpl;
import java.util.ArrayList;
import model.Product;

public final class UpdateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Product Management</title>\n");
      out.write("        <!-- Core CSS - Include with every page -->\n");
      out.write("        <link href=\"assets/plugins/bootstrap/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/plugins/pace/pace-theme-big-counter.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/style.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"assets/css/main-style.css\" rel=\"stylesheet\" />\n");
      out.write("        <!-- Page-Level CSS -->\n");
      out.write("        <link href=\"assets/plugins/social-buttons/social-buttons.css\" rel=\"stylesheet\" />\n");
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
      out.write("            ");
 ArrayList<Product> AllProduct = new productDAOimpl().getAllProducts(); 
      out.write("\n");
      out.write("            <div id=\"page-wrapper\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <!--  page header -->\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <h1 class=\"page-header\">Products Management</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end  page header -->\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <!-- Advanced Tables -->\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <b>Products Details</b>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Product ID</th>\n");
      out.write("                                                <th>Name</th>\n");
      out.write("                                                <th>Price</th>\n");
      out.write("                                                <th>Description</th>\n");
      out.write("                                                <th>Quantity</th>\n");
      out.write("                                                <th>Update</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");
for (Product prod : AllProduct) {
      out.write("\n");
      out.write("                                            <tr class=\"gradeA\">\n");
      out.write("                                                <td>");
      out.print(prod.getProduct_id());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(prod.getName());
      out.write("</td>\n");
      out.write("                                                <td class=\"center\">$");
      out.print(prod.getPrice());
      out.write("</td>\n");
      out.write("                                                <td style=\"width: 350px\">");
      out.print(prod.getDescription());
      out.write("</td>\n");
      out.write("                                                <td class=\"center\">");
      out.print(prod.getQuantity());
      out.write("</td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <button class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#");
      out.print(prod.getProduct_id());
      out.write("\">\n");
      out.write("                                                        Edit\n");
      out.write("                                                    </button>\n");
      out.write("                                                    <div class=\"modal fade\" id=\"");
      out.print(prod.getProduct_id());
      out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                                        <div class=\"modal-dialog\">\n");
      out.write("                                                            <div class=\"modal-content\">\n");
      out.write("                                                                <div class=\"modal-header\">\n");
      out.write("                                                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                                                                    <h4 class=\"modal-title\" id=\"myModalLabel\">");
      out.print(prod.getName());
      out.write("</h4>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <form name=\"update\" onsubmit=\"return validate()\" action=\"UpdateProduct\" role=\"form\" method=\"get\">\n");
      out.write("                                                                    <div class=\"modal-body\">\n");
      out.write("                                                                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"../images/prod/");
      out.print(prod.getThumb_image());
      out.write("\" height=\"300\" width=\"350\" alt=\"Wrong url\"/></p>\n");
      out.write("                                                                        <br><br>                                                  \n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Product ID:&nbsp;&nbsp;</label>\n");
      out.write("                                                                            <input size=\"50\" class=\"form-control\" disabled value=\"");
      out.print(prod.getProduct_id());
      out.write("\">\n");
      out.write("                                                                            <input name=\"product_id\" value=\"");
      out.print(prod.getProduct_id());
      out.write("\" type=\"hidden\">\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <br><br>\n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>\n");
      out.write("                                                                            <input name=\"name\" size=\"50\" type=\"text\" class=\"form-control\" value=\"");
      out.print(prod.getName());
      out.write("\">\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <br><br>\n");
      out.write("                                                                        ");
ArrayList<Category> cateList = new categoryDAOimpl().getAllChildcate();
      out.write("\n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Category&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>\n");
      out.write("                                                                            <select name=\"category\" class=\"form-control\">\n");
      out.write("                                                                                ");
for (Category cate : cateList) {
                                                                                        if (prod.getCategory_id() == cate.getCategory_id()) {
                                                                                
      out.write("\n");
      out.write("                                                                                <option selected=\"selected\">");
      out.print(cate.getCategory_id());
      out.write('.');
      out.write(' ');
      out.print(cate.getName());
      out.write("</option>\n");
      out.write("                                                                                ");
} else {
      out.write("\n");
      out.write("                                                                                <option>");
      out.print(cate.getCategory_id());
      out.write('.');
      out.write(' ');
      out.print(cate.getName());
      out.write("</option>\n");
      out.write("                                                                                ");
}
                                                                                    }
      out.write("\n");
      out.write("                                                                            </select>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <br><br>\n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>\n");
      out.write("                                                                            <input name=\"price\" size=\"50\" type=\"text\" class=\"form-control\" value=\"");
      out.print(prod.getPrice());
      out.write("\">$\n");
      out.write("                                                                        </div> \n");
      out.write("                                                                        <br><br>\n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>\n");
      out.write("                                                                            <input name=\"quantity\" size=\"50\" type=\"text\" class=\"form-control\" value=\"");
      out.print(prod.getQuantity());
      out.write("\">\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <br><br>\n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Description:</label>\n");
      out.write("                                                                            <textarea name=\"description_detail\" class=\"form-control\" cols=\"53\" rows=\"3\">");
      out.print(prod.getDescription_detail());
      out.write("</textarea>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <br><br>\n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Information:</label>\n");
      out.write("                                                                            <input name=\"information\" size=\"50\" type=\"text\" class=\"form-control\" value=\"");
      out.print(prod.getInformation());
      out.write("\">\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <br><br>\n");
      out.write("                                                                        <div class=\"form-group\">\n");
      out.write("                                                                            <label>Status:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>\n");
      out.write("                                                                            <input name=\"status\" size=\"50\" type=\"text\" class=\"form-control\" value=\"");
      out.print(prod.getStatus());
      out.write("\">\n");
      out.write("                                                                        </div>       \n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div class=\"modal-footer\">\n");
      out.write("                                                                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                                                        <input type=\"submit\" class=\"btn btn-primary\" value=\"Save changes\">\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </form>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div> or   \n");
      out.write("                                                    <button onclick=\"cfdelete(");
      out.print(prod.getProduct_id());
      out.write(")\" type=\"button\" class=\"btn btn-primary btn-xs btn-danger\">Delete</button>\n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            ");
}
      out.write("                                    \n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!--End Advanced Tables -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("        <script src=\"assets/plugins/dataTables/jquery.dataTables.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/dataTables/dataTables.bootstrap.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                                                        $(document).ready(function () {\n");
      out.write("                                                            $('#dataTables-example').dataTable();\n");
      out.write("                                                        });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            function cfdelete(product_id) {\n");
      out.write("                if (confirm(\"Continue deleting item \" + product_id + \"?\") == true) {\n");
      out.write("                    window.location(\"UpdateProduct?product_id=\" + product_id);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                                            function validate() {\n");
      out.write("                                                var name = document.update.name.value;\n");
      out.write("                                                var price = document.update.price.value;\n");
      out.write("                                                var quantity = document.update.quantity.value;\n");
      out.write("                                                if (name == \"\" || name == null)\n");
      out.write("                                                    alert(\"Please enter product's name!\");\n");
      out.write("                                                else if (price == \"\" || price == null)\n");
      out.write("                                                    alert(\"Please enter product's price!\");\n");
      out.write("                                                else if (isNaN(price))\n");
      out.write("                                                    alert(\"Price only contain number!\");\n");
      out.write("                                                else if (quantity == \"\" || quantity == null)\n");
      out.write("                                                    alert(\"Please enter product's quantity!\");\n");
      out.write("                                                else if (isNaN(quantity))\n");
      out.write("                                                    alert(\"Quantity only contain number!\");\n");
      out.write("                                                else {\n");
      out.write("                                                    if(confirm(\"Continue changing?\") == true)\n");
      out.write("                                                        return true;\n");
      out.write("                                                }\n");
      out.write("                                                return false;\n");
      out.write("                                            }\n");
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
