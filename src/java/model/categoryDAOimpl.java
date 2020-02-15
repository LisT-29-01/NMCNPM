/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.categoryDAO;
import connect.connectDB;
import java.sql.*;
import java.util.ArrayList;
import model.Category;

/**
 *
 * @author dell
 */
public class categoryDAOimpl implements categoryDAO {

    @Override
    public ArrayList<Category> getParentcate() {
        Connection con = connectDB.getConnection();
        String sql = "SELECT * FROM category WHERE parent_category IS NULL OR parent_category = -1";
        ArrayList<Category> cateList = new ArrayList<Category>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Category cate = new Category();
                cate.setCategory_id(rs.getInt("category_id"));
                cate.setName(rs.getString("name"));
                cate.setParent_cate(rs.getInt("parent_category"));
                cateList.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cateList;
    }

    @Override
    public ArrayList<Category> getChildrencate(int parent) {
        Connection con = connectDB.getConnection();
        String sql = "SELECT * FROM category WHERE parent_category =" + parent;
        ArrayList<Category> cateList = new ArrayList<Category>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Category cate = new Category();
                cate.setCategory_id(rs.getInt("category_id"));
                cate.setName(rs.getString("name"));
                cate.setParent_cate(parent);
                cateList.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cateList;
    }

    @Override
    public ArrayList<Category> getAllChildcate() {
        Connection con = connectDB.getConnection();
        String sql = "SELECT * FROM category WHERE parent_category is not null";
        ArrayList<Category> cateList = new ArrayList<Category>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Category cate = new Category();
                cate.setCategory_id(rs.getInt("category_id"));
                cate.setName(rs.getString("name"));
                cate.setParent_cate(rs.getInt("parent_category"));
                cateList.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cateList;
    }
}
