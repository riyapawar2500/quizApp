/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DBConnection {

    private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver Loaded");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-D8PA23N7:1521/xe","onlineexam","student");
            //ps = conn.prepareStatement("Insert into employee values(?,?,?)");
            //System.out.println("Driver ");
            JOptionPane.showMessageDialog(null, "Connected Successfully To The DataBase!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot Connect To The DataBase!");
            e.printStackTrace();
            System.exit(1);
        }   
        
    }
    
    public static Connection getConnection(){
        return conn;
    }
    
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "DisConnect successfully To The DataBase!");
           
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Cannot DisConnect To The DataBase!");
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
