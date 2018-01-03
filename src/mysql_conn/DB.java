/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_conn;

/**
 *
 * @author Hp
 */
import java.sql.*;
import javax.swing.*;

public class DB {
    Connection conn=null;
    
    public static Connection connectionDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/itp", "root", "");
            return conn;
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
            
        }
    }
    
}
