/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.ProductDAO;
import connect.connectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;


/**
 *
 * @author dell
 */
public class productDAOimpl implements ProductDAO {

    private int NoOfRecords;
    @Override
    public ArrayList<Product> getAllProducts(){
        Connection con = connectDB.getConnection();
        String sql = "SELECT * FROM product, product_detail WHERE product_id = product_detail_id ";
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Product prod = new Product();
                prod.setProduct_id(rs.getInt("product_id"));
                prod.setName(rs.getString("name"));
                prod.setCategory_id(rs.getInt("category_id"));
                prod.setPrice(rs.getFloat("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
                prod.setDescription_detail(rs.getString("description_detail"));
                prod.setImage(rs.getString("image"));
                prod.setThumb_image(rs.getString("thumb_image"));
                prod.setLast_update(rs.getDate("last_update"));
                prod.setStatus(rs.getString("status"));
                prod.setImage1(rs.getString("image1"));
                prod.setImage1(rs.getString("image2"));
                prod.setImage1(rs.getString("image3"));
                prod.setImage1(rs.getString("image4"));
                prod.setImage1(rs.getString("image5"));
                prod.setInformation(rs.getString("information"));
                prod.setAccessories(rs.getString("accessories"));
                productList.add(prod);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public ArrayList<Product> getListbyCategory(int category_id, int offset, int recordsperPage) {
        Connection con = connectDB.getConnection();
        String sql = "SELECT * FROM product, product_detail WHERE product_id = product_detail_id and category_id = " + category_id + " order by product_id offset " + offset + " rows fetch next " + recordsperPage + " rows only";
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Product prod = new Product();
                prod.setProduct_id(rs.getInt("product_id"));
                prod.setName(rs.getString("name"));
                prod.setPrice(rs.getFloat("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
                prod.setDescription_detail(rs.getString("description_detail"));
                prod.setImage(rs.getString("image"));
                prod.setThumb_image(rs.getString("thumb_image"));
                prod.setLast_update(rs.getDate("last_update"));
                prod.setStatus(rs.getString("status"));
                prod.setImage1(rs.getString("image1"));
                prod.setImage1(rs.getString("image2"));
                prod.setImage1(rs.getString("image3"));
                prod.setImage1(rs.getString("image4"));
                prod.setImage1(rs.getString("image5"));
                prod.setInformation(rs.getString("information"));
                prod.setAccessories(rs.getString("accessories"));
                productList.add(prod);
            }
            rs.close();
            rs = s.executeQuery("SELECT count(*) from Product where category_id = "+category_id);
            if(rs.next())
                this.NoOfRecords = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public ArrayList<Product> getListHotProduct() {
        Connection con = connectDB.getConnection();
        String sql = "SELECT TOP 6 * FROM product, product_detail WHERE product_id = product_detail_id and status like 'Hot' order by last_update desc";
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Product prod = new Product();
                prod.setProduct_id(rs.getInt("product_id"));
                prod.setName(rs.getString("name"));
                prod.setPrice(rs.getFloat("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
                prod.setDescription_detail(rs.getString("description_detail"));
                prod.setImage(rs.getString("image"));
                prod.setThumb_image(rs.getString("thumb_image"));
                prod.setLast_update(rs.getDate("last_update"));
                prod.setStatus(rs.getString("status"));
                prod.setImage1(rs.getString("image1"));
                prod.setImage1(rs.getString("image2"));
                prod.setImage1(rs.getString("image3"));
                prod.setImage1(rs.getString("image4"));
                prod.setImage1(rs.getString("image5"));
                prod.setInformation(rs.getString("information"));
                prod.setAccessories(rs.getString("accessories"));
                productList.add(prod);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public ArrayList<Product> getListSaleProduct() {
        Connection con = connectDB.getConnection();
        String sql = "SELECT TOP 9 * FROM product, product_detail WHERE product_id = product_detail_id and status like 'sale%' order by status desc, last_update desc";
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Product prod = new Product();
                prod.setProduct_id(rs.getInt("product_id"));
                prod.setName(rs.getString("name"));
                prod.setPrice(rs.getFloat("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
                prod.setDescription_detail(rs.getString("description_detail"));
                prod.setImage(rs.getString("image"));
                prod.setThumb_image(rs.getString("thumb_image"));
                prod.setLast_update(rs.getDate("last_update"));
                prod.setStatus(rs.getString("status"));
                prod.setImage1(rs.getString("image1"));
                prod.setImage1(rs.getString("image2"));
                prod.setImage1(rs.getString("image3"));
                prod.setImage1(rs.getString("image4"));
                prod.setImage1(rs.getString("image5"));
                prod.setInformation(rs.getString("information"));
                prod.setAccessories(rs.getString("accessories"));
                productList.add(prod);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public Product getProduct(int product_id){
        Connection con = connectDB.getConnection();
        String sql = "SELECT * FROM product, product_detail WHERE product_id = product_detail_id and product_id ="+product_id;
        Product prod = new Product();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);  
            if(rs.next()) {
                prod.setProduct_id(rs.getInt("product_id"));
                prod.setName(rs.getString("name"));
                prod.setPrice(rs.getFloat("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
                prod.setDescription_detail(rs.getString("description_detail"));
                prod.setImage(rs.getString("image"));
                prod.setThumb_image(rs.getString("thumb_image"));
                prod.setLast_update(rs.getDate("last_update"));
                prod.setStatus(rs.getString("status"));
                prod.setImage1(rs.getString("image1"));
                prod.setImage2(rs.getString("image2"));
                prod.setImage3(rs.getString("image3"));
                prod.setImage4(rs.getString("image4"));
                prod.setImage5(rs.getString("image5"));
                prod.setInformation(rs.getString("information"));
                prod.setAccessories(rs.getString("accessories"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prod;
    }
    @Override
    public ArrayList<Product> searchProduct(String search, int offset, int recordsperPage) {
        Connection con = connectDB.getConnection();
        String sql = "SELECT * FROM product, product_detail WHERE product_id = product_detail_id and (name LIKE '%"+search+"%' or description LIKE '%"+search+"%' or description_detail like '%"+search+"%' or  information like '%"+search+"%') order by product_id offset " + offset + " rows fetch next " + recordsperPage + " rows only";
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Product prod = new Product();
                prod.setProduct_id(rs.getInt("product_id"));
                prod.setName(rs.getString("name"));
                prod.setPrice(rs.getFloat("price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setDescription(rs.getString("description"));
                prod.setDescription_detail(rs.getString("description_detail"));
                prod.setImage(rs.getString("image"));
                prod.setThumb_image(rs.getString("thumb_image"));
                prod.setLast_update(rs.getDate("last_update"));
                prod.setStatus(rs.getString("status"));
                prod.setImage1(rs.getString("image1"));
                prod.setImage1(rs.getString("image2"));
                prod.setImage1(rs.getString("image3"));
                prod.setImage1(rs.getString("image4"));
                prod.setImage1(rs.getString("image5"));
                prod.setInformation(rs.getString("information"));
                prod.setAccessories(rs.getString("accessories"));
                productList.add(prod);
            }
            rs.close();
            rs = s.executeQuery("select count(*) from product, product_detail WHERE product_id = product_detail_id and (name LIKE '%"+search+"%' or description LIKE '%"+search+"%' or description_detail like '%"+search+"%' or  information like '%"+search+"%')");
            if(rs.next())
                this.NoOfRecords = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    
    public int getNoOfRecords() {
        return NoOfRecords;
    }
    @Override
    public void Update(int product_id, String name, int category, float price, int quantity, String description_detail, String information, String status, String last_update, String description){
        Connection con = connectDB.getConnection();
        String sql = "update Product set name = ?, category_id = ? ,price = ?, quantity = ?,description_detail = ?, information = ? , status = ?, last_update = ?, description = ? where product_id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setInt(2,category);
            pst.setFloat(3,price);
            pst.setInt(4,quantity);
            pst.setString(5,description_detail);
            pst.setString(6,information);
            pst.setString(7,status);
            pst.setString(8,last_update);
            pst.setString(9,description);
            pst.setInt(10,product_id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Delete(int product_id){
        Connection con = connectDB.getConnection();
        String sql = "delete from product where product_id = "+product_id;
        try {
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Insert(int product_id, String name, int category, float price, int quantity, String description, String description_detail, String information, String status, String image1, String image2, String image3, String image4, String image5,String last_update){
        Connection con = connectDB.getConnection();
        String sql1 = "insert into product (product_id, name, category_id, price, quantity, description, description_detail, status, image, thumb_image, information, last_update) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "insert into product_detail (product_detail_id, image1, image2, image3, image4, image5) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst1 = con.prepareStatement(sql1);
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst1.setInt(1, product_id);
            pst1.setString(2, name);
            pst1.setInt(3, category);
            pst1.setFloat(4, price);
            pst1.setInt(5, quantity);
            pst1.setString(6, description);
            pst1.setString(7, description_detail);
            pst1.setString(8, status);
            pst1.setString(9, image1);
            pst1.setString(10, image2);
            pst1.setString(11, information);
            pst1.setString(12, last_update);
            pst2.setInt(1, product_id);
            pst2.setString(2, image1);
            pst2.setString(3, image2);
            pst2.setString(4, image3);
            pst2.setString(5, image4);
            pst2.setString(6, image5);
            pst1.executeUpdate();
            pst2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getNewProductID(){
        Connection con = connectDB.getConnection();
        String sql = "select Top 1 product_id from product order by product_id desc";
        int newID = 0; 
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next())
                newID = rs.getInt(1)+1;               
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newID;
    }
    @Override
    public ArrayList<Vector> StatisticByCategory(){
        Connection con = connectDB.getConnection();
        String sql = "select category.name, count(product_id) from category, product where product.category_id = category.category_id group by category.category_id, category.name";
        ArrayList<Vector> list = new ArrayList<Vector>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Vector element = new Vector();
                element.add(rs.getString(1));
                element.add(rs.getInt(2));
                list.add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public ArrayList<Vector> StatisticByStatus(){
        Connection con = connectDB.getConnection();
        String sql = "select status, count(product_id) from product where status is not null and status != '' group by status";
        ArrayList<Vector> list = new ArrayList<Vector>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Vector element = new Vector();
                element.add(rs.getString(1));
                element.add(rs.getInt(2));
                list.add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
