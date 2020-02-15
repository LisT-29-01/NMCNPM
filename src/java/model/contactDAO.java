/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connect.connectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author dell
 */
public class contactDAO {
    public void contact(String name, String email, String subject, String message){
        Connection con = connectDB.getConnection();
        String sql = "insert into contact (name, email, subject, message, reply) values (?,?,?,?,?)";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, subject);
            pst.setString(4, message);
            pst.setBoolean(5, false);
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Vector> contactList(){
        Connection con = connectDB.getConnection();
        String sql = "select * from contact";
        ArrayList<Vector> list = new ArrayList<Vector>();
        try{
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Vector element = new Vector();
                element.add(rs.getString(1));
                element.add(rs.getString(2));
                element.add(rs.getString(3));
                element.add(rs.getString(4));
                element.add(rs.getString(5));
                element.add(rs.getBoolean(6));
                list.add(element);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void Delete(int id){
        Connection con = connectDB.getConnection();
        String sql = "delete from contact where contact_id = "+id;
        try{
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
