package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.orderItem;
import java.util.ArrayList;
import model.Order;
import model.Customer;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Check out | MELODY</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/price-range.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/animate.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n");
      out.write("        <script>\n");
      out.write("            function cancel() {\n");
      out.write("                if (confirm(\"Cancel Order?\") == true) {\n");
      out.write("                    window.location = \"cancel\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
Order order = (Order) session.getAttribute("order");
        if(order == null || order.getItems().size() == 0){
        
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
      out.write("\n");
      out.write("            <section id=\"cart_items\">\n");
      out.write("                <div class=\"container\">                 \n");
      out.write("                    <div class=\"step-one\">\n");
      out.write("                        <h2 class=\"heading\">Cancel Order?</h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"checkout-options\">\n");
      out.write("                        <h3>New User</h3>\n");
      out.write("                        <p>Checkout options</p>\n");
      out.write("                        <ul class=\"nav\">\n");
      out.write("                            <form>                              \n");
      out.write("                                <li>\n");
      out.write("                                    <a id=\"cancel\" onclick=\"cancel()\"><i class=\"fa fa-times\"></i>Cancel</a>\n");
      out.write("                                </li>\n");
      out.write("                            </form>\n");
      out.write("                        </ul>\n");
      out.write("                    </div><!--/checkout-options-->\n");
      out.write("                ");
 String email_err = "", password_err = "";
                    if (request.getAttribute("email_err") != null) {
                        email_err = (String) request.getAttribute("email_err");
                    }
                    if (request.getAttribute("password_err") != null) {
                        password_err = (String) request.getAttribute("password_err");
                    }
                    Customer customer = (Customer) session.getAttribute("customer");
                    String note;
                    if (customer == null) {
                        note = "Please use Register And Checkout to easily get access to your order history, or use Checkout as Guest";
                    } else {
                        note = "Fill check out form";
                    }
                
      out.write("\n");
      out.write("                <div class=\"register-req\">\n");
      out.write("                    <p>");
      out.print(note);
      out.write("</p>\n");
      out.write("                </div><!--/register-req-->\n");
      out.write("                <div class=\"shopper-informations\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        ");
if (customer == null) {
      out.write("\n");
      out.write("                        <div class=\"col-sm-3\">\n");
      out.write("                            <div class=\"shopper-info\">\n");
      out.write("                                <p>Login to check out</p>\n");
      out.write("                                <form action=\"/eMarket1/loginToCheckOut\" method=\"post\">\n");
      out.write("                                    <input type=\"text\" name=\"email\" placeholder=\"Email Account *\">\n");
      out.write("                                    <p style=\"font-size: 15px; color: red\">");
      out.print(email_err);
      out.write("</p>\n");
      out.write("                                    <input type=\"password\" name=\"password\" placeholder=\"Password *\">\n");
      out.write("                                    <p style=\"font-size: 15px; color: red\">");
      out.print(password_err);
      out.write("</p>\n");
      out.write("                                    <input type=\"submit\" value=\"Login\" class=\"btn btn-primary\">\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div> \n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        ");

                            String cfemail_err = "", cfname_err = "", cfphone_err = "", cfaddress_err = "";
                            if (request.getAttribute("cfemail_err") != null) {
                                cfemail_err = (String) request.getAttribute("cfemail_err");
                            }
                            if (request.getAttribute("cfname_err") != null) {
                                cfname_err = (String) request.getAttribute("cfname_err");
                            }
                            if (request.getAttribute("cfphone_err") != null) {
                                cfphone_err = (String) request.getAttribute("cfphone_err");
                            }
                            if (request.getAttribute("cfaddress_err") != null) {
                                cfaddress_err = (String) request.getAttribute("cfaddress_err");
                            }
                        
      out.write("\n");
      out.write("                        <div class=\"col-sm-5 clearfix\">\n");
      out.write("                            <div class=\"bill-to\">\n");
      out.write("                                ");
String checkOutForm;
                                    if (customer == null) {
                                        checkOutForm = "Check out as Guest";
                                    } else {
                                        checkOutForm = "Fill up below Form to Check out";
                                    }
                                
      out.write("\n");
      out.write("                                <p>");
      out.print(checkOutForm);
      out.write("</p>\n");
      out.write("                                <div class=\"form-one\">\n");
      out.write("                                    <form action=\"/eMarket1/confirmCheck\" method=\"post\">\n");
      out.write("                                        ");
if (customer != null) {
      out.write("\n");
      out.write("                                        <input type=\"Email\" name=\"Email\" value=\"");
      out.print(customer.getEmail());
      out.write("\" placeholder=\"Email Account*\">\n");
      out.write("                                        <p style=\"font-size: 12px; color: red\">");
      out.print(cfemail_err);
      out.write("</p>\n");
      out.write("                                        <input type=\"text\" name=\"Name\" value=\"");
      out.print(customer.getName());
      out.write("\" placeholder=\"Full Name *\">  \n");
      out.write("                                        <p style=\"font-size: 12px; color: red\">");
      out.print(cfname_err);
      out.write("</p>\n");
      out.write("                                        <input type=\"text\" name=\"Phone\" value=\"");
      out.print(customer.getPhone());
      out.write("\" placeholder=\"Phone number *\">  \n");
      out.write("                                        <p style=\"font-size: 12px; color: red\">");
      out.print(cfphone_err);
      out.write("</p>\n");
      out.write("                                        ");
} else {
      out.write("\n");
      out.write("                                        <input type=\"Email\" name=\"Email\" placeholder=\"Email Account*\">\n");
      out.write("                                        <p style=\"font-size: 12px; color: red\">");
      out.print(cfemail_err);
      out.write("</p>\n");
      out.write("                                        <input type=\"text\" name=\"Name\" placeholder=\"Full Name *\">\n");
      out.write("                                        <p style=\"font-size: 12px; color: red\">");
      out.print(cfname_err);
      out.write("</p>\n");
      out.write("                                        <input type=\"text\" name=\"Phone\" placeholder=\"Phone number *\">\n");
      out.write("                                        <p style=\"font-size: 12px; color: red\">");
      out.print(cfphone_err);
      out.write("</p>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        <input type=\"text\" name=\"Address\" placeholder=\"Receive Address *\">\n");
      out.write("                                        <p style=\"font-size: 12px; color: red\">");
      out.print(cfaddress_err);
      out.write("</p>\n");
      out.write("                                        <select  name=\"Region\">\n");
      out.write("                                            <option>Vietnam</option>\n");
      out.write("                                            <option>China</option>\n");
      out.write("                                            <option>UK</option>\n");
      out.write("                                            <option>India</option>\n");
      out.write("                                            <option>Pakistan</option>\n");
      out.write("                                            <option>Italia</option>\n");
      out.write("                                            <option>Canada</option>\n");
      out.write("                                            <option>Russia</option>\n");
      out.write("                                            <option>United States</option>\n");
      out.write("                                        </select>\n");
      out.write("                                        <p></p>\n");
      out.write("                                        <input type=\"submit\" value=\"Confirm\" class=\"btn btn-primary\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <div class=\"order-message\">\n");
      out.write("                                <p>Shipping Order</p>\n");
      out.write("                                <textarea name=\"message\"  placeholder=\"Notes about your order, Special Notes for Delivery\" rows=\"16\"></textarea>\n");
      out.write("                                <label><input type=\"checkbox\"> Shipping to bill address</label>\n");
      out.write("                            </div>\t\n");
      out.write("                        </div>\t\t\t\t\t\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"review-payment\">\n");
      out.write("                    <h2>Review & Payment</h2>\n");
      out.write("                </div>               \n");
      out.write("                <div class=\"table-responsive cart_info\">\n");
      out.write("                    <table class=\"table table-condensed\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr class=\"cart_menu\">\n");
      out.write("                                <td class=\"image\">Item</td>\n");
      out.write("                                <td class=\"description\"></td>\n");
      out.write("                                <td class=\"price\">Price</td>\n");
      out.write("                                <td class=\"quantity\">Quantity</td>\n");
      out.write("                                <td class=\"total\">Total</td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
for (orderItem Items : order.getItems()) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"cart_product\">\n");
      out.write("                                    <a href=\"\"><img src=\"images/prod/");
      out.print(Items.getProduct().getThumb_image());
      out.write("\" height=\"50\" width=\"50\" alt=\"\"></a>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_description\">\n");
      out.write("                                    <h4><a href=\"\">");
      out.print(Items.getProduct().getName());
      out.write("</a></h4>\n");
      out.write("                                    <p>ID: ");
      out.print(Items.getProduct().getProduct_id());
      out.write("</p>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_price\">\n");
      out.write("                                    <p>$");
      out.print(Items.getProduct().getPrice());
      out.write("</p>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_quantity\">\n");
      out.write("                                    <input class=\"cart_quantity_input\" type=\"text\" name=\"quantity\" value=\"");
      out.print(Items.getQuantity());
      out.write("\" autocomplete=\"off\" size=\"2\" disabled>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_total\">\n");
      out.write("                                    ");
  int Sale = 0;
                                        if (Items.getProduct().getStatus() != null) {
                                            if (Items.getProduct().getStatus().matches("^sale.+")) {
                                                Sale = Integer.valueOf(Items.getProduct().getStatus().substring(4, 6));
                                            }
                                        }
      out.write("\n");
      out.write("                                    <p class=\"cart_total_price\">$");
      out.print(Items.getTotal(Sale));
      out.write("</p>\n");
      out.write("                                </td>\n");
      out.write("                            </tr> \n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"4\">&nbsp;</td>\n");
      out.write("                                <td colspan=\"2\">\n");
      out.write("                                    <table class=\"table table-condensed total-result\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Cart Sub Total</td>\n");
      out.write("                                            <td>$");
      out.print(order.getSubtotal());
      out.write("</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Eco Tax</td>\n");
      out.write("                                            <td>$2</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr class=\"shipping-cost\">\n");
      out.write("                                            <td>Shipping Cost</td>\n");
      out.write("                                            <td>Free</td>\t\t\t\t\t\t\t\t\t\t\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Total</td>\n");
      out.write("                                            <td><span>$");
      out.print(order.getTotal(2));
      out.write("</span></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"payment-options\">\n");
      out.write("                    <span>\n");
      out.write("                        <label><input type=\"checkbox\"> Direct Bank Transfer</label>\n");
      out.write("                    </span>\n");
      out.write("                    <span>\n");
      out.write("                        <label><input type=\"checkbox\"> Check Payment</label>\n");
      out.write("                    </span>\n");
      out.write("                    <span>\n");
      out.write("                        <label><input type=\"checkbox\"> Paypal</label>\n");
      out.write("                    </span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section> <!--/#cart_items-->\n");
      out.write("        ");
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
