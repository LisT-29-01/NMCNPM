/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.CustomerDAOimpl;
import model.productDAOimpl;
import model.contactDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Order;
import model.Product;
import model.orderItem;

/**
 *
 * @author dell
 */
@WebServlet(name = "ControlServlet", urlPatterns = {
    "/addItem", "/updateItem", "/confirmCheck", "/cancel", "/removeItem", "/loginToCheckOut",
    "/login", "/register", "/searchProduct", "/viewProduct", "/viewDetail", "/logout", "/UpdateAccount", "/changePassword", "/contact"})
public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/viewProduct")) {
            int page = 1;
            int recordsPerPage = 9;
            int category_id = Integer.parseInt(request.getParameter("category_id"));
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                productDAOimpl dao = new productDAOimpl();
                ArrayList<Product> list = dao.getListbyCategory(category_id, (page - 1) * recordsPerPage, recordsPerPage);
                int noOfRecords = dao.getNoOfRecords();
                int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
                request.setAttribute("productList", list);
                request.setAttribute("noOfPages", noOfPages);
                request.setAttribute("currentPage", page);
                request.setAttribute("category_id", category_id);
                url = "/view_products.jsp";
            }
        } else if (url.equals("/viewDetail")) {
            if (request.getParameter("product_id") != null) {
                int prodID = Integer.parseInt(request.getParameter("product_id"));
                Product prod = new productDAOimpl().getProduct(prodID);
                request.setAttribute("prod", prod);
                url = "product_details.jsp";
            }
        } else if (url.equals("/addItem")) {
            Product newProd = new productDAOimpl().getProduct(Integer.valueOf(request.getParameter("productId")));
            if (newProd != null) {
                HttpSession session = request.getSession();
                Order order = (Order) session.getAttribute("order");
                if (order != null) {
                    order.addItem(newProd);
                    session.setAttribute("order", order);
                } else {
                    order = new Order();
                    order.addItem(newProd);
                    session.setAttribute("order", order);
                }
            }
            url = "/cart.jsp";
        } else if (url.equals("/updateItem")) {
            Product updProd = new productDAOimpl().getProduct(Integer.valueOf(request.getParameter("productId")));
            if (updProd != null) {
                HttpSession session = request.getSession();
                Order order = (Order) session.getAttribute("order");
                if (order != null) {
                    order.update(updProd, request.getParameter("quantity"));
                    session.setAttribute("order", order);
                }
            }
            url = "/cart.jsp";
        } else if (url.equals("/removeItem")) {
            Product updProd = new productDAOimpl().getProduct(Integer.valueOf(request.getParameter("productId")));
            if (updProd != null) {
                HttpSession session = request.getSession();
                Order order = (Order) session.getAttribute("order");
                if (order != null) {
                    order.update(updProd, "0");
                    session.setAttribute("order", order);
                }
            }
            url = "/cart.jsp";
        } else if (url.equals("/cancel")) {
            HttpSession session = request.getSession();
            session.removeAttribute("order");
            url = "index.jsp";
        } else if (url.equals("/logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            url = "index.jsp";
        } else if (url.equals("/searchProduct")) {
            int page = 1;
            int recordsPerPage = 9;
            String search = request.getParameter("search");
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                productDAOimpl dao = new productDAOimpl();
                ArrayList<Product> list = dao.searchProduct(search, (page - 1) * recordsPerPage, recordsPerPage);
                int noOfRecords = dao.getNoOfRecords();
                int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
                request.setAttribute("productList", list);
                request.setAttribute("noOfPages", noOfPages);
                request.setAttribute("currentPage", page);
                request.setAttribute("search", search);
                url = "/view_products.jsp";
            }
        } else if(url.equals("/contact")){
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String subject = request.getParameter("subject");
            String message = request.getParameter("message");
            new contactDAO().contact(name, email, subject, message);
            url = "/index.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        if (url.equals("/confirmCheck")) {
            String email_err = "", phone_err = "", address_err = "", name_err = "";
            String email = request.getParameter("Email");
            String phone = request.getParameter("Phone");
            String name = request.getParameter("Name");
            String address = request.getParameter("Address");
            String region = request.getParameter("Region");
            if (name.length() == 0) {
                name_err = "Please enter your Name!";
            }
            if (email.length() == 0) {
                email_err = "Please enter your Email!";
            }
            if (phone.length() == 0) {
                phone_err = "Please enter your Phone number!";
            }
            if (address.length() == 0) {
                address_err = "Please enter your Address!";
            }
            if (email_err.length() > 0) {
                request.setAttribute("cfemail_err", email_err);
            }
            if (name_err.length() > 0) {
                request.setAttribute("cfname_err", name_err);
            }
            if (phone_err.length() > 0) {
                request.setAttribute("cfphone_err", phone_err);
            }
            if (address_err.length() > 0) {
                request.setAttribute("cfaddress_err", address_err);
            }
            if (name_err.length() == 0 && email_err.length() == 0 && phone_err.length() == 0 && address_err.length() == 0) {
                HttpSession session = request.getSession();
                Customer customer = (Customer) session.getAttribute("customer");
                Order order = (Order) session.getAttribute("order");
                if (customer == null) {
                    order = new OrderManager().placeOrderGuest(name, email, phone, address, region, order);
                    customer = new Customer();
                    customer.setName(name);
                    customer.setEmail(email);
                    customer.setAddress(address);
                    customer.setPhone(phone);
                    customer.setRegion(region);
                    customer.setType("Guest");
                    session.setAttribute("customer", customer);
                } else {
                    order = new OrderManager().placeOrderMember(customer, order, address);
                }
                session.setAttribute("order", order);
                url = "/confirmation.jsp";
            } else {
                url = "/checkout.jsp";
            }
        } else if (url.equals("/loginToCheckOut")) {
            String email_err = "", password_err = "";
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Customer cus = new CustomerDAOimpl().SearchCustomerAccount(email);
            if (password.length() == 0) {
                password_err = "Please enter your Email!";
            }
            if (email.length() == 0) {
                email_err = "Please enter your Password!";
            } else {
                if (cus == null) {
                    password_err = "Email or Password is incorrect!";
                } else if (!password.equals(cus.getPassword())) {
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
                session.setAttribute("customer", cus);
            }
            url = "/checkout.jsp";
        } else if (url.equals("/login")) {
            String email_err = "", password_err = "";
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Customer cus = new CustomerDAOimpl().SearchCustomerAccount(email);
//            if (password.length() == 0) {
//                password_err = "Please enter your Password!";
//            }
//            if (email.length() == 0) {
//                email_err = "Please enter your Email!";
//            } else {
            if (cus == null) {
                password_err = "Email or Password is incorrect!";
            } else if (!password.equals(cus.getPassword())) {
                password_err = "Email or Password is incorrect!";
            }
//            }
            if (email_err.length() > 0) {
                request.setAttribute("email_err", email_err);
            }
            if (password_err.length() > 0) {
                request.setAttribute("password_err", password_err);
            }
            if (password_err.length() == 0 && email_err.length() == 0) {
                HttpSession session = request.getSession();
                //session.removeAttribute("order");
                session.setAttribute("customer", cus);
                url = "/index.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (url.equals("/register")) {
            String email_err = "", password_err = "", name_err = "", phone_err = "";
            String cus_email = request.getParameter("cus_email");
            String cus_phone = request.getParameter("cus_phone");
            String cus_pass = request.getParameter("cus_pass");
            String cus_name = request.getParameter("cus_name");
            Customer customer = new CustomerDAOimpl().SearchCustomerAccount(cus_email);
            if (customer != null) {
                email_err = "Email is already existing!";
            }
//            if (cus_name.length() == 0) {
//                name_err = "Please enter your Name!";
//            }
//            if (cus_pass.length() == 0) {
//                password_err = "Please enter your Password!";
//            }
//            if (cus_phone.length() == 0) {
//                phone_err = "Please enter your Phone number!";
//            }
//            if (cus_email.length() == 0) {
//                email_err = "Please enter your Email!";
//            }
//            if (name_err.length() > 0) {
//                request.setAttribute("rsname_err", name_err);
//            }
//            if (email_err.length() > 0) {
//                request.setAttribute("rsemail_err", email_err);
//            }
//            if (phone_err.length() > 0) {
//                request.setAttribute("rsphone_err", phone_err);
//            }
//            if (password_err.length() > 0) {
//                request.setAttribute("rspassword_err", password_err);
//            }
//            if (password_err.length() == 0 && email_err.length() == 0 && name_err.length() == 0) {
            customer = new Customer();
            customer.setName(cus_name);
            customer.setEmail(cus_email);
            customer.setPassword(cus_pass);
            customer.setPhone(request.getParameter("cus_phone"));
            customer.setAddress(request.getParameter("cus_address"));
            customer.setRegion(request.getParameter("cus_region"));
            customer.setType("Member");
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            new CustomerDAOimpl().InsertCustomer(customer);
            url = "/index.jsp";
//            } else {
//                url = "/login.jsp";
//            }

        } else if(url.equals("/UpdateAccount")){
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            String name = request.getParameter("name");           
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");          
            String region = request.getParameter("region");           
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            customer.setName(name);
            customer.setPhone(phone);
            customer.setAddress(address);
            customer.setRegion(region);
            new CustomerDAOimpl().Update(customer);
            session.setAttribute("customer",customer);
            url = "/account.jsp";
        } else if(url.equals("/changePassword")){
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            String newPass = request.getParameter("retype");
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            customer.setPassword(newPass);
            session.setAttribute("customer", customer);
            new CustomerDAOimpl().changePassword(customer_id, newPass);
            url = "index.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
