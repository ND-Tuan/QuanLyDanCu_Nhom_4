package DAO;

import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhaibaoDAOImpl implements KhaibaoDAO {

    public static List<Khaibao> findALL() {
        Connection cons = Connect.getConnection();
        String sql = "SELECT * FROM khaibao";
        List<Khaibao> khaibaoList = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Khaibao Kb = new Khaibao(
                            resultSet.getString("SoCMT"),
                            resultSet.getString("da_di_qua"),
                            resultSet.getString("trang_thai_suc_khoe"),
                            resultSet.getDate("ngay_khai_bao")
                    );
                    khaibaoList.add(Kb);
                }
            }
            cons.close();
        } catch (SQLException e) {
        }
        return khaibaoList;
    }

    public static void insert(Khaibao Kb) {
        Connection cons = Connect.getConnection();
        
        String sql = "INSERT INTO `khaibao` (`SoCMT`, `da_di_qua`, `trang_thai_suc_khoe`, `ngay_khai_bao`) VALUES (?, ?, ?, ?)";
        try {
            try (PreparedStatement statement = cons.prepareStatement(sql)) {
                
                statement.setString(1, Kb.getSoCMT());
                statement.setString(2, Kb.getDa_di_qua());
                statement.setString(3, Kb.getTrang_thai_suc_khoe());
                statement.setDate(4, Kb.getNgay_khai_bao());
          
                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    
     public static void update(Khaibao Kb) {
        Connection cons = Connect.getConnection();
        
        String sql = "update khaibao set da_di_qua=?, trang_thai_suc_khoe=? where SoCMT = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setString(1, Kb.getDa_di_qua());
                statement.setString(2, Kb.getTrang_thai_suc_khoe());
                statement.setString(3, Kb.getSoCMT());

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
     
     public static void delete(String id) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `khaibao` WHERE `khaibao`.`SoCMT` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setString(1, id);

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
     
     public static List<Khaibao> find(String id) {
        Connection cons = Connect.getConnection();
        String sql = "SELECT * FROM khaibao where SoCMT = ?";
        List<Khaibao> khaibaoList = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                
                ps.setString(1, id);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Khaibao Kb = new Khaibao(
                            resultSet.getString("SoCMT"),
                            resultSet.getString("da_di_qua"),
                            resultSet.getString("trang_thai_suc_khoe"),
                            resultSet.getDate("ngay_khai_bao")
                    );
                    khaibaoList.add(Kb);
                }
            }
            cons.close();
        } catch (SQLException e) {
        }
        return khaibaoList;
    }
}
