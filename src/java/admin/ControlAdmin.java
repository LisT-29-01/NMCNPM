/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import model.CustomerDAOimpl;
import model.OrderDAOimpl;
import model.adminDAO;
import model.contactDAO;
import model.productDAOimpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Product;

/**
 *
 * @author dell
 */
@WebServlet(name = "ControlAdmin", urlPatterns = {"/ControlAdmin", "/admin/UpdateProduct", "/admin/UpdateCustomer",
    "/admin/InsertProduct", "/admin/Login", "/admin/Logout", "/admin/UpdateOrder", "/admin/UpdateAdmin", "/admin/changePassword", "/admin/DeleteContact"})
public class ControlAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/admin/UpdateProduct")) {
            int product_id = Integer.parseInt(request.getParameter("product_id"));
            String name = request.getParameter("name");
            if (name != null) {
                int category = Integer.parseInt(request.getParameter("category").substring(0, request.getParameter("category").lastIndexOf('.')));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                String status = request.getParameter("status");
                float price = Float.parseFloat(request.getParameter("price"));
                String description = request.getParameter("description");
                String description_detail = request.getParameter("description_detail");
                String information = request.getParameter("information");
                long date = System.currentTimeMillis();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String last_update = df.format(date);
                new productDAOimpl().Update(product_id, name, category, price, quantity, description_detail, information, status, last_update, description);
            } else {
                new productDAOimpl().Delete(product_id);
            }
            url = "/admin/UpdateProduct.jsp";
        } else if (url.equals("/admin/UpdateCustomer")) {
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            new CustomerDAOimpl().Delete(customer_id);
            url = "/admin/UpdateCustomer.jsp";
        } else if (url.equals("/admin/InsertProduct")) {
            int product_id = Integer.parseInt(request.getParameter("product_id"));
            String name = request.getParameter("name");
            int category = Integer.parseInt(request.getParameter("category").substring(0, request.getParameter("category").lastIndexOf('.')));
            float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String description = request.getParameter("description");
            String status = request.getParameter("status");
            String information = request.getParameter("information");
            String description_detail = request.getParameter("description_detail");
            String image1 = request.getParameter("image1");
            String image2 = request.getParameter("image2");
            String image3 = request.getParameter("image3");
            String image4 = request.getParameter("image4");
            String image5 = request.getParameter("image5");
            if (image1.length() > 0) {
                image1 = image1.substring(image1.lastIndexOf('\\') + 1);
            } else {
                image1 = null;
            }
            if (image2.length() > 0) {
                image2 = image2.substring(image2.lastIndexOf('\\') + 1);
            } else {
                image2 = null;
            }
            if (image3.length() > 0) {
                image3 = image3.substring(image3.lastIndexOf('\\') + 1);
            } else {
                image3 = null;
            }
            if (image4.length() > 0) {
                image4 = image4.substring(image4.lastIndexOf('\\') + 1);
            } else {
                image4 = null;
            }
            if (image5.length() > 0) {
                image5 = image5.substring(image5.lastIndexOf('\\') + 1);
            } else {
                image5 = null;
            }
            long date = System.currentTimeMillis();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String last_update = df.format(date);
            new productDAOimpl().Insert(product_id, name, category, price, quantity, description, description_detail, information, status, image1, image2, image3, image4, image5, last_update);
            url = "InsertProduct.jsp";
        } else if (url.equals("/admin/Logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            url = "login.jsp";
        } else if (url.equals("/admin/UpdateOrder")) {
            String command = request.getParameter("command");
            long order_id = Long.parseLong(request.getParameter("order_id"));
            if (command.equals("check")) {
                new OrderDAOimpl().checkOrder(order_id);
            } else {
                new OrderDAOimpl().deleteOrder(order_id);
            }
            url = "UpdateOrder.jsp";
        } else if(url.equals("/admin/DeleteContact")){
            int id = Integer.parseInt(request.getParameter("id"));
            new contactDAO().Delete(id);
            url = "/index.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/admin/Login")) {
            String email_err = "", password_err = "";
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Admin admin = new adminDAO().searchAdminAccount(email);
            if (password.length() == 0) {
                password_err = "Please enter your Password!";
            }
            if (email.length() == 0) {
                email_err = "Please enter your Email!";
            } else {
                if (admin == null) {
                    password_err = "Email or Password is incorrect!";
                } else if (!password.equals(admin.getPassword())) {
                    password_err = "Email or Password is incorrect!";
                }
            }
            if (email_err.length() > 0) {
                request.setAttribute("email_err", email_err);
            }
            if (password_err.length() > 0) {
                request.setAttribute("password_err", password_err);
            }
            if (password_err.length() == 0 && email_err.length() == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                url = "index.jsp";
            } else {
                url = "login.jsp";
            }
        } else if (url.equals("/admin/UpdateAdmin")) {
            int admin_id = Integer.parseInt(request.getParameter("admin_id"));
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String dob = request.getParameter("dob");
            HttpSession session = request.getSession();
            Admin admin = (Admin) session.getAttribute("admin");
            admin.setName(name);
            admin.setDOB(dob);
            admin.setPhone(phone);
            session.setAttribute("admin", admin);
            new adminDAO().updateAdmin(admin);
            url = "AdminProfile.jsp";
        } else if (url.equals("/admin/changePassword")) {
            int admin_id = Integer.parseInt(request.getParameter("admin_id"));
            String newPass = request.getParameter("retype");
            HttpSession session = request.getSession();
            Admin admin = (Admin) session.getAttribute("admin");
            admin.setPassword(newPass);
            session.setAttribute("admin", admin);
            new adminDAO().changePassword(admin_id, newPass);
            url = "index.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
