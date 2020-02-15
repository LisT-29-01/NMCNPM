/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Vector;
import model.Customer;
import model.Customer;

/**
 *
 * @author dell
 */
public interface CustomerDAO {
    public void InsertCustomer(Customer cs);
    public Customer SearchNewCustomer();
    public Customer SearchCustomerAccount(String email);
    public Customer SearchCustomerByID(int customer_id);
    public ArrayList<Customer> SearchAllCustomer();
    public void Update(Customer customer);
    public void changePassword(int customer_id, String newpass);
    public void Delete(int customer_id);
    public ArrayList<Vector> StatisticByType();
    public ArrayList<Vector> Top3LoyalCus();
}
