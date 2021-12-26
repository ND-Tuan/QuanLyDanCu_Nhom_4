
package DAO;

import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class NhankhauDAOImpl implements NhankhauDAO {
    
    public static List<Nhankhau> findALL() {
        Connection cons = Connect.getConnection();
        String sql = "SELECT * FROM nhankhau";
        List<Nhankhau> NhankhauList = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Nhankhau nhankhau = new Nhankhau(
                            resultSet.getString("SoCMT"),
                            resultSet.getString("Ho_ten"),
                            resultSet.getString("namSinh"),
                            resultSet.getString("gioiTinh"),
                            resultSet.getString("noiSinh"),
                            resultSet.getString("nguyenQuan"),
                            resultSet.getString("danToc"),
                            resultSet.getString("quocTich"),
                            resultSet.getString("noiThuongTru"),
                            resultSet.getString("diaChiHienNay"),
                            resultSet.getString("SDT")
                    );
                    NhankhauList.add(nhankhau);
                }
            }
            cons.close();
        } catch (SQLException e) {
        }
        return NhankhauList;
    }
    
     public static void insert(Nhankhau Nk) {
        Connection cons = Connect.getConnection();
        
        String sql = "INSERT INTO `nhankhau`(`SoCMT`, `Ho_ten`, `namSinh`, `gioiTinh`, `noiSinh`, `danToc`, `quocTich`, `diaChiHienNay`, `SDT`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement statement = cons.prepareStatement(sql)) {  
                statement.setString(1, Nk.getSoCMT());
                statement.setString(2, Nk.getHo_ten());
                statement.setString(3, Nk.getNamSinh());
                statement.setString(4, Nk.getGioiTinh());
                statement.setString(5, Nk.getNoiSinh());
                statement.setString(6, Nk.getDanToc());
                statement.setString(7, Nk.getQuocTich());
                statement.setString(8, Nk.getDiaChiHienNay());
                statement.setString(9, Nk.getSDT());
          
                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    
     public static void update(Nhankhau Nk) {
        Connection cons = Connect.getConnection();
        String sql = "UPDATE nhankhau SET SoCMT = ?, Ho_ten = ?, namSinh = ?, gioiTinh = ?, noiSinh = ?, danToc = ?, quocTich = ?, diaChiHienNay=?, SDT = ? WHERE SoCMT = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setString(1, Nk.getSoCMT());
                statement.setString(2, Nk.getHo_ten());
                statement.setString(3, Nk.getNamSinh());
                statement.setString(4, Nk.getGioiTinh());
                statement.setString(5, Nk.getNoiSinh());
                statement.setString(6, Nk.getDanToc());
                statement.setString(7, Nk.getQuocTich());
                statement.setString(8, Nk.getDiaChiHienNay());
                statement.setString(9, Nk.getSDT());
                statement.setString(10, Nk.getSoCMT());

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
     
     public static void delete(Nhankhau Nk) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `nhankhau` WHERE `nhankhau`.`SoCMT` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setString(1, Nk.getSoCMT());

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
     
     public static List<Nhankhau> find(String id, int input) {
         Connection cons = Connect.getConnection();
         String sql;
         if (input == 0) {
             sql = "SELECT * FROM nhankhau where SoCMT = ?";
         } else {
             sql = "SELECT * FROM nhankhau where Ho_ten = ?";
         }
        List<Nhankhau> NhankhauList = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                
                ps.setString(1, id);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    Nhankhau Nk = new Nhankhau(
                            resultSet.getString("SoCMT"),
                            resultSet.getString("Ho_ten"),
                            resultSet.getString("namSinh"),
                            resultSet.getString("gioiTinh"),
                            resultSet.getString("noiSinh"),
                            resultSet.getString("danToc"),
                            resultSet.getString("quocTich"),
                            resultSet.getString("diaChiHienNay"),
                            resultSet.getString("SDT")
                    );
                    NhankhauList.add(Nk);
                }
            }
            cons.close();
        } catch (SQLException e) {
        }
        return NhankhauList;
    }
    
    
}
