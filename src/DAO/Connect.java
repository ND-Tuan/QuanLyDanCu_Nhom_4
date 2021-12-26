package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
        
public class Connect {
    
    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/thu", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
}