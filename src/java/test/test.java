/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.CustomerDAOimpl;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Customer;

/**
 *
 * @author dell
 */
public class test {
    public static void main(String argvs[]){
        long date = System.currentTimeMillis();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String last_update = df.format(date);
            String url = "C\\Users\\dell\\Documents\\NetBeansProjects\\anchor_keychain1.jpg";
        System.out.print(url.substring(url.lastIndexOf('\\')+1));
    }
}
