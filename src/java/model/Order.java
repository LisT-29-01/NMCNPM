/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Order {

    private long order_id;
    private float total;
    private int numberOfItems;
    private String date_created;
    private int confirm_number;
    private int customer_id;
    private String address;
    private ArrayList<orderItem> order_list;
    private boolean complete;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getConfirm_number() {
        return confirm_number;
    }

    public void setConfirm_number(int confirm_number) {
        this.confirm_number = confirm_number;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order() {
        order_id = System.currentTimeMillis();
        order_list = new ArrayList<orderItem>();
        numberOfItems = 0;
        total = 0;
    }

    public synchronized void addItem(Product product) {
        boolean newItem = true;
        for (orderItem scItem : order_list) {

            if (scItem.getProduct().getProduct_id() == product.getProduct_id()) {
                newItem = false;
                scItem.incrementQuantity();
            }
        }
        if (newItem) {
            orderItem scItem = new orderItem(product);
            order_list.add(scItem);
        }
    }

    public synchronized void update(Product product, String quantity) {
        short qty = -1;
        // cast quantity as short
        qty = Short.parseShort(quantity);
        if (qty >= 0) {
            orderItem item = null;
            for (orderItem scItem : order_list) {
                if (scItem.getProduct().getProduct_id() == product.getProduct_id()) {
                    if (qty != 0) {
                        // set item quantity to new value                        
                        scItem.setQuantity(qty);
                    } else {
                        // if quantity equals 0, save item and break      
                        item = scItem;
                        break;
                    }
                }
            }

            if (item != null) {
                // remove from cart  
                order_list.remove(item);
            }
        }
    }

    public synchronized ArrayList<orderItem> getItems() {
        return order_list;
    }

    public synchronized int getNumberOfItems() {
        numberOfItems = 0;
        for (orderItem scItem : order_list) {
            numberOfItems += scItem.getQuantity();
        }
        return numberOfItems;
    }

    public synchronized float getSubtotal() {
        float amount = 0;
        for (orderItem scItem : order_list) {
            int sale = 0;
            if (scItem.getProduct().getStatus() != null) {
                if (scItem.getProduct().getStatus().matches("^sale.+")) {
                    sale = Integer.valueOf(scItem.getProduct().getStatus().substring(4, 6));
                }
            }
            amount += scItem.getTotal(sale);
        }
        return amount;
    }
    

    public synchronized void calculateTotal(float surcharge) {
        float amount = 0;
        // cast surcharge as double 
        amount = this.getSubtotal();
        amount += surcharge;
        total = amount;
    }

    public synchronized float getTotal(float surcharge) {
        float amount = 0;
        // cast surcharge as double 
        amount = this.getSubtotal();
        amount += surcharge;
        total = amount;
        return (float) Math.round(total*100)/100;
    }

    public synchronized void clear() {
        order_list.clear();
        numberOfItems = 0;
        total = 0;
    }
}
