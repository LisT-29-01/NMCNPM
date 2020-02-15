/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connect.connectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author dell
 */
public class CustomerDAOimpl implements CustomerDAO {

    @Override
    public void InsertCustomer(Customer cs) {
        Connection con = connectDB.getConnection();
        String sql = "insert into customer(name, email, phone, address, city_region, password, type) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cs.getName());
            pst.setString(2, cs.getEmail());
            pst.setString(3, cs.getPhone());
            pst.setString(4, cs.getAddress());
            pst.setString(5, cs.getRegion());
            pst.setString(6, cs.getPassword());
            pst.setString(7, cs.getType());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer SearchNewCustomer() {
        Connection con = connectDB.getConnection();
        String sql = "select top 1 * from customer order by customer_id desc";
        Customer cus = new Customer();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                cus.setCustomer_id(rs.getInt("customer_id"));
                cus.setName(rs.getString("name"));
                cus.setEmail(rs.getString("email"));
                cus.setPhone(rs.getString("phone"));
                cus.setAddress(rs.getString("address"));
                cus.setRegion(rs.getString("city_region"));
                cus.setPassword(rs.getString("password"));
                cus.setType(rs.getString("type"));
            } else {
                cus = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cus;
    }

    @Override
    public Customer SearchCustomerAccount(String email) {
        Connection con = connectDB.getConnection();
        String sql = "select * from customer where email = '" + email + "' and password is not null";
        Customer cus = new Customer();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                cus.setCustomer_id(rs.getInt("customer_id"));
                cus.setName(rs.getString("name"));
                cus.setEmail(rs.getString("email"));
                cus.setPhone(rs.getString("phone"));
                cus.setAddress(rs.getString("address"));
                cus.setRegion(rs.getString("city_region"));
                cus.setPassword(rs.getString("password"));
                cus.setType(rs.getString("type"));
            } else {
                cus = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cus;
    }

    @Override
    public Customer SearchCustomerByID(int customer_id) {
        Connection con = connectDB.getConnection();
        String sql = "select * from customer where customer_id = " + customer_id;
        Customer cus = new Customer();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                cus.setCustomer_id(rs.getInt("customer_id"));
                cus.setName(rs.getString("name"));
                cus.setEmail(rs.getString("email"));
                cus.setPhone(rs.getString("phone"));
                cus.setAddress(rs.getString("address"));
                cus.setRegion(rs.getString("city_region"));
                cus.setType(rs.getString("type"));
            } else {
                cus = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cus;
    }

    @Override
    public ArrayList<Customer> SearchAllCustomer() {
        Connection con = connectDB.getConnection();
        String sql = "select * from customer";
        ArrayList<Customer> CusList = new ArrayList<Customer>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Customer cus = new Customer();
                cus.setCustomer_id(rs.getInt("customer_id"));
                cus.setName(rs.getString("name"));
                cus.setEmail(rs.getString("email"));
                cus.setPhone(rs.getString("phone"));
                cus.setAddress(rs.getString("address"));
                cus.setRegion(rs.getString("city_region"));
                cus.setPassword(rs.getString("password"));
                cus.setType(rs.getString("type"));
                CusList.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CusList;
    }

    @Override
    public void Update(Customer customer) {
        Connection con = connectDB.getConnection();
        String sql = "update customer set phone = ?, name = ?, address = ?, city_region = ? where customer_id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getPhone());
            pst.setString(2, customer.getName());
            pst.setString(3, customer.getAddress());
            pst.setString(4, customer.getRegion());
            pst.setInt(5, customer.getCustomer_id());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int customer_id) {
        Connection con = connectDB.getConnection();
        String sql = "delete from customer where customer_id = " + customer_id;
        try {
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changePassword(int customer_id, String newpass) {
        Connection con = connectDB.getConnection();
        String sql = "update customer set password = '" + newpass + "' where customer_id = " + customer_id;
        try {
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Vector> StatisticByType() {
        Connection con = connectDB.getConnection();
        String sql = "select type, count(customer_id) from customer group by type";
        ArrayList<Vector> list = new ArrayList<Vector>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Vector element = new Vector();
                element.add(rs.getString(1));
                element.add(rs.getString(2));
                list.add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Vector> Top3LoyalCus() {
        Connection con = connectDB.getConnection();
        String sql = "select top 3 customer.customer_id, customer.name, count(customer.customer_id)\n"
                + "from customer, customer_order\n"
                + "where customer.customer_id = customer_order.customer_id and year(date_created) = year(getdate())\n"
                + "group by customer.customer_id, customer.name\n"
                + "order by count(customer.customer_id) desc";
        ArrayList<Vector> list = new ArrayList<Vector>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Vector element = new Vector();
                element.add(rs.getString(1));
                element.add(rs.getString(2));
                element.add(rs.getString(3));
                list.add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
