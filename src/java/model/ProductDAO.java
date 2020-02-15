/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Vector;
import model.Product;

/**
 *
 * @author dell
 */
public interface ProductDAO {
    public ArrayList<Product> getAllProducts();
    public ArrayList<Product> getListbyCategory(int category_id, int offset, int recordsperPage);
    public ArrayList<Product> getListHotProduct();
    public ArrayList<Product> getListSaleProduct();
    public Product getProduct(int product_id);
    public ArrayList<Product> searchProduct(String search, int offset, int recordsperPage);
    public void Update(int product_id, String name, int category, float price, int quantity, String description_detail, String information, String status, String last_update, String description);
    public void Delete(int product_id);
    public void Insert(int product_id, String name, int category, float price, int quantity, String description, String description_detail, String information, String status, String image1, String image2, String image3, String image4, String image5,String last_update);
    public int getNewProductID();
    public ArrayList<Vector> StatisticByCategory();
    public ArrayList<Vector> StatisticByStatus();
}
