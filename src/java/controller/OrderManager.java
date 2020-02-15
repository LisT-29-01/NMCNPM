/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.CustomerDAOimpl;
import model.OrderDAOimpl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import model.Customer;
import model.Order;


/**
 *
 * @author dell
 */
public class OrderManager {
    public Order placeOrderMember(Customer customer, Order order, String address){
        order = addOrder(customer,order,address);
        addOrderItem(order);
        return order;
    }
    public Order placeOrderGuest(String name, String email, String phone, String address, String cityRegion, Order order){
        Customer customer = addCustomer(name, email, phone, cityRegion,address,"Guest");
        customer = new CustomerDAOimpl().SearchNewCustomer();
        order = addOrder(customer,order,address);
        addOrderItem(order);
        return order;
    }
    private Customer addCustomer(String name, String email, String phone, String cityRegion, String address, String type){
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setRegion(cityRegion);
        customer.setType(type);
        new CustomerDAOimpl().InsertCustomer(customer);
        return customer;
    }
    private Order addOrder(Customer cus, Order order, String address){
        order.setAddress(address);
        order.setCustomer_id(cus.getCustomer_id());
        Random random = new Random();        
        int i = random.nextInt(999999999);   
        order.setConfirm_number(i); 
        long date = System.currentTimeMillis();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        order.setDate_created(df.format(date).toString());
        new OrderDAOimpl().InsertOrder(order);
        return order;
    }
    private void addOrderItem(Order order){
        new OrderDAOimpl().InsertOrderItem(order);
    }
}
