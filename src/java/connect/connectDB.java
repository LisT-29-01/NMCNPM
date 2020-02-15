/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.*;


/**
 *
 * @author dell
 */
public class connectDB {
    public static Connection getConnection(){
        final String SQL_Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String user = "sa";
        final String password = "nkim1999";
        final String url = "jdbc:sqlserver://localhost:1433;databaseName= WEBTMDT";
        try{
            Connection con = null;
            Class.forName(SQL_Driver);
            con = DriverManager.getConnection(url,user,password);
            return con;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
