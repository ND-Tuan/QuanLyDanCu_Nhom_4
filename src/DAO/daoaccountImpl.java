package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.*;

public class daoaccountImpl implements daoaccount {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public account login(String username, String password) {
        String query = "SELECT * FROM `userss`\n"
                + "WHERE username = ?\n"
                + "AND password = ?\n";
        try {
            new Connect();
            conn = Connect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);  
            rs = ps.executeQuery();
            while (rs.next()) {
                return new account(rs.getString("username"),
                        rs.getString("password")
                        );
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;

    }
  
}
