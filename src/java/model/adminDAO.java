/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connect.connectDB;
import java.sql.*;
import model.Admin;


/**
 *
 * @author dell
 */
public class adminDAO {
    public Admin searchAdminAccount(String email){
        Connection con = connectDB.getConnection();
        String sql = "select * from admin where email = '"+email+"'";
        Admin admin = new Admin();
        try{
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                admin.setAdmin_id(rs.getInt("admin_id"));
                admin.setEmail(rs.getString("email"));
                admin.setName(rs.getString("name"));
                admin.setDOB(rs.getString("DOB"));
                admin.setPhone(rs.getString("phone"));
                admin.setPosition(rs.getString("position"));
                admin.setPassword(rs.getString("password"));
                admin.setAvatar(rs.getString("avatar"));
            }
            else admin = null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return admin;
    }
    public void updateAdmin(Admin admin){
        Connection con = connectDB.getConnection();
        String sql = "update admin set name = '"+admin.getName()+"', dob = '"+admin.getDOB()+"', phone = '"+admin.getPhone()+"' where admin_id = "+admin.getAdmin_id();
        try{
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
    public void changePassword(int admin_id, String newPass){
        Connection con = connectDB.getConnection();
        String sql = "update admin set password = '"+newPass+"' where admin_id = "+admin_id;
        try{
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
}
