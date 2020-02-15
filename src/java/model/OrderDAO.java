/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Vector;
import model.Order;
import model.orderItem;
import model.orderItem;

/**
 *
 * @author dell
 */
public interface OrderDAO {
    public void InsertOrder(Order order);
    public void InsertOrderItem(Order order);
    public ArrayList<Order> getAllOrder();
    public ArrayList<Order> getOrderByCustomer(int customer_id);
    public ArrayList<orderItem> getOrderItem(long order_id);
    public void checkOrder(long order_id);
    public void deleteOrder(long order_id);
    public ArrayList<Vector> StatisticBySoldlast3month();
}
