package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.*;


public class CachlyDAOImpl {
    
    public static List<Cachly> findALL() {
        Connection cons = Connect.getConnection();
        String sql = "SELECT * FROM cachly";
        List<Cachly> cachlyList = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Cachly Cal = new Cachly(
                            resultSet.getInt("id"),
                            resultSet.getString("SoCMT"),
                            resultSet.getString("tgian_bat_dau"),
                            resultSet.getString("thoi_gian_test"),
                            resultSet.getString("hinh_thuc_test"),
                            resultSet.getString("Ket_qua_test"),
                            resultSet.getString("muc_do_cach_ly")

                    );
                    cachlyList.add(Cal);
                }
            }
            cons.close();
        } catch (SQLException e) {
        }
        return cachlyList;
    }

    public static void insert(Cachly Cal) {
        Connection cons = Connect.getConnection();
        
        String sql = "INSERT INTO `cachly`(`SoCMT`, `tgian_bat_dau`, `muc_do_cach_ly`, `hinh_thuc_test`, `thoi_gian_test`, `Ket_qua_test`) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement statement = cons.prepareStatement(sql)) {
                statement.setString(1, Cal.getSoCMT());
                statement.setString(2, Cal.getTgian_bat_dau());
                statement.setString(3, Cal.getMuc_do_cach_ly());
                statement.setString(4, Cal.getHinh_thuc_test());
                statement.setString(5, Cal.getThoi_gian_test());
                statement.setString(6, Cal.getKet_qua_test());

                
          
                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    
     public static void update(Cachly Cal) {
        Connection cons = Connect.getConnection();
        
        String sql = "UPDATE `cachly` SET `tgian_bat_dau`= ?,`muc_do_cach_ly`= ?,`hinh_thuc_test`= ?,`thoi_gian_test`= ?,`Ket_qua_test`= ? WHERE ID = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                
                statement.setString(1, Cal.getTgian_bat_dau());
                statement.setString(2, Cal.getMuc_do_cach_ly());
                statement.setString(3, Cal.getHinh_thuc_test());
                statement.setString(4, Cal.getThoi_gian_test());
                statement.setString(5, Cal.getKet_qua_test());
                statement.setInt(6, Cal.getID());

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
     
     public static void delete(int id) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `cachly` WHERE `cachly`.`id` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setInt(1, id);

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
     
      public static void deletecmt(String id) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `cachly` WHERE `cachly`.`SoCMT` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setString(1, id);

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
     
     public static List<Cachly> find(String id) {
        Connection cons = Connect.getConnection();
        String sql = "SELECT * FROM cachly where SoCMT = ?";
        List<Cachly> CachlyList = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                
                ps.setString(1, id);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Cachly Cal = new Cachly(
                            resultSet.getInt("id"),
                            resultSet.getString("SoCMT"),
                            resultSet.getString("tgian_bat_dau"),
                            resultSet.getString("thoi_gian_test"),
                            resultSet.getString("hinh_thuc_test"),
                            resultSet.getString("Ket_qua_test"),
                            resultSet.getString("muc_do_cach_ly")
                    );
                    CachlyList.add(Cal);
                }
            }
            cons.close();
        } catch (SQLException e) {
        }
        return CachlyList;
    }
    
}
