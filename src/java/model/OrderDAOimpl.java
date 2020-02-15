/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.OrderDAO;
import connect.connectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.orderItem;

/**
 *
 * @author dell
 */
public class OrderDAOimpl implements OrderDAO {

    @Override
    public void InsertOrder(Order order) {
        Connection con = connectDB.getConnection();
        String sql = "insert into customer_order(order_id, amount, date_created, confirmation_number, customer_id, address, complete) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, order.getOrder_id());
            pst.setInt(2, order.getNumberOfItems());
            pst.setString(3, order.getDate_created());
            pst.setInt(4, order.getConfirm_number());
            pst.setInt(5, order.getCustomer_id());
            pst.setString(6, order.getAddress());
            pst.setBoolean(7, false);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void InsertOrderItem(Order order) {
        Connection con = connectDB.getConnection();
        String sql = "insert into ordered_product(order_id, product_id, quantity) values(?,?,?)";
        ArrayList<orderItem> Items = order.getItems();
        for (orderItem item : Items) {
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setLong(1, order.getOrder_id());
                pst.setInt(2, item.getProduct().getProduct_id());
                pst.setInt(3, item.getQuantity());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Order> getOrderByCustomer(int customer_id) {
        Connection con = connectDB.getConnection();
        String sql = "select * from customer_order where customer_id = " + customer_id;
        ArrayList<Order> orderList = new ArrayList<Order>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getLong("order_id"));
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setAddress(rs.getString("address"));
                order.setConfirm_number(rs.getInt("confirmation_number"));
                order.setDate_created(rs.getString("date_created"));
                order.setComplete(rs.getBoolean("complete"));
                ArrayList<orderItem> itemList = getOrderItem(rs.getLong("order_id"));
                for (orderItem item : itemList) {
                    for (int i = 0; i < item.getQuantity(); i++) {
                        order.addItem(item.getProduct());
                    }
                }
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public ArrayList<Order> getAllOrder() {
        Connection con = connectDB.getConnection();
        String sql = "select * from customer_order";
        ArrayList<Order> orderList = new ArrayList<Order>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getLong("order_id"));
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setAddress(rs.getString("address"));
                order.setConfirm_number(rs.getInt("confirmation_number"));
                order.setDate_created(rs.getString("date_created"));
                order.setComplete(rs.getBoolean("complete"));
                ArrayList<orderItem> itemList = getOrderItem(rs.getLong("order_id"));
                for (orderItem item : itemList) {
                    for (int i = 0; i < item.getQuantity(); i++) {
                        order.addItem(item.getProduct());
                    }
                }
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public ArrayList<orderItem> getOrderItem(long order_id) {
        Connection con = connectDB.getConnection();
        String sql = "select * from ordered_product where order_id = " + order_id;
        ArrayList<orderItem> itemList = new ArrayList<orderItem>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                orderItem item = new orderItem(new productDAOimpl().getProduct(rs.getInt("product_id")));
                item.setQuantity((short) rs.getInt("quantity"));
                itemList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public void checkOrder(long order_id) {
        Connection con = connectDB.getConnection();
        String sql = "update customer_order set complete = 'true' where order_id = " + order_id;
        try {
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(long order_id) {
        Connection con = connectDB.getConnection();
        String sql = "delete from customer_order where order_id = " + order_id;
        try {
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Vector> StatisticBySoldlast3month() {
        Connection con = connectDB.getConnection();
        String sql = "select top 3 month(date_created), Sum(op.quantity),SUM(price*op.quantity)\n"
                + "from customer_order co, ordered_product op, product\n"
                + "where co.order_id = op.order_id and op.product_id = product.product_id\n"
                + "and year(date_created) = year(GETDATE()) and month(date_created) <= month(getdate()) \n"
                + "group by month(date_created)\n"
                + "order by month(date_created) desc";
        ArrayList<Vector> list = new ArrayList<Vector>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Vector element = new Vector();
                element.add(rs.getString(1));
                element.add(rs.getInt(2));
                element.add((float)Math.round(rs.getFloat(3)*100)/100);
                list.add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
