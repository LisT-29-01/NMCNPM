/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class orderItem {
    private Product product;
    private short quantity;
    public orderItem(Product product) {         
        this.product = product;         
        quantity = 1;     
    } 
 
    public Product getProduct() {        
        return product;     
    } 
 
    public short getQuantity() {    
        return quantity;  
    } 
 
    public void setQuantity(short quantity) { 
        this.quantity = quantity;
    } 
 
    public void incrementQuantity() {
        quantity++;
    } 
 
    public void decrementQuantity() { 
        quantity--; 
    } 
 
    public float getTotal(int sale){
        float amount = 0;      
        amount = (100-sale)*(this.getQuantity() * product.getPrice())/100;
        return amount; 
    }
}
