package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.*;

public class daoqlthuImpl implements daoqlthu {

    public static List<ql_dong_gop> findALL() {
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM `ql_dong_gop`, `nhankhau`, `khoan_thu` WHERE ql_dong_gop.SoCMT = nhankhau.SoCMT AND ql_dong_gop.ID_khoan_thu = khoan_thu.ID_khoan_thu";
        List<ql_dong_gop> list = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    ql_dong_gop Dg = new ql_dong_gop(
                            resultSet.getInt("id"),
                            resultSet.getString("SoCMT"),
                            resultSet.getString("Ho_ten"),
                            resultSet.getInt("ID_khoan_thu"),
                            resultSet.getInt("Sotien"),
                            resultSet.getDate("Ngaynop"),
                            resultSet.getString("ten_khoan_thu")
                            
                    );
                    list.add(Dg);
                }
            }
            conn.close();
        } catch (SQLException e) {
        }
        return list;
    }

  

    public static List<ql_dong_gop> findname(String name) {
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM `ql_dong_gop`, `nhankhau`, `khoan_thu`"
                + " where ql_dong_gop.SoCMT = nhankhau.SoCMT AND "
                + "ql_dong_gop.ID_khoan_thu = khoan_thu.ID_khoan_thu AND `nhankhau`.Ho_ten = ?";
        List<ql_dong_gop> list = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql)) {
                ps.setString(1, name);
                
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    ql_dong_gop kb = new ql_dong_gop(
                            resultSet.getInt("id"),
                            resultSet.getString("SoCMT"),
                            resultSet.getString("Ho_ten"),
                            resultSet.getInt("ID_khoan_thu"),
                            resultSet.getInt("Sotien"),
                            resultSet.getDate("Ngaynop"),
                            resultSet.getString("ten_khoan_thu")
                    );
                    list.add(kb);
                }
            }
            conn.close();
        } catch (SQLException e) {
        }
        return list;
    }
    
    public static List<ql_dong_gop> findcmt(String cmt) {
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM `ql_dong_gop`, `nhankhau`, `khoan_thu`"
                + " where ql_dong_gop.SoCMT = nhankhau.SoCMT"
                + " AND ql_dong_gop.ID_khoan_thu = khoan_thu.ID_khoan_thu AND `nhankhau`.SoCMT = ?";
        List<ql_dong_gop> list = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql)) {
                ps.setString(1, cmt);
                
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    ql_dong_gop kb = new ql_dong_gop(
                             resultSet.getInt("id"),
                            resultSet.getString("SoCMT"),
                            resultSet.getString("Ho_ten"),
                            resultSet.getInt("ID_khoan_thu"),
                            resultSet.getInt("Sotien"),
                            resultSet.getDate("Ngaynop"),
                            resultSet.getString("ten_khoan_thu")
                    );
                    list.add(kb);
                }
            }
            conn.close();
        } catch (SQLException e) {
        }
        return list;
    }
    
    public static List<ql_dong_gop> findThu(String ten_khoan_thu) {
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM `ql_dong_gop`, `nhankhau`, `khoan_thu` "
                + "where ql_dong_gop.SoCMT = nhankhau.SoCMT AND"
                + " ql_dong_gop.ID_khoan_thu = khoan_thu.ID_khoan_thu AND `khoan_thu`.ten_khoan_thu = ?";
        List<ql_dong_gop> list = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql)) {
                ps.setString(1, ten_khoan_thu);
                
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    ql_dong_gop kb = new ql_dong_gop(
                           resultSet.getInt("id"),
                            resultSet.getString("SoCMT"),
                            resultSet.getString("Ho_ten"),
                            resultSet.getInt("ID_khoan_thu"),
                            resultSet.getInt("Sotien"),
                            resultSet.getDate("Ngaynop"),
                            resultSet.getString("ten_khoan_thu")
                    );
                    list.add(kb);
                }
            }
            conn.close();
        } catch (SQLException e) {
        }
        return list;
    }
    
    public static List<ql_dong_gop> findBatbuoc(boolean Batbuoc) {
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM `ql_dong_gop`, `nhankhau`, `khoan_thu` "
                + "where ql_dong_gop.SoCMT = nhankhau.SoCMT AND"
                + " ql_dong_gop.ID_khoan_thu = khoan_thu.ID_khoan_thu AND `khoan_thu`.Batbuoc = ?";
        List<ql_dong_gop> list = new ArrayList<>();
        try {
            try ( PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql)) {
                ps.setBoolean(1, Batbuoc);
                
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    ql_dong_gop kb = new ql_dong_gop(
                           resultSet.getInt("id"),
                            resultSet.getString("SoCMT"),
                            resultSet.getString("Ho_ten"),
                            resultSet.getInt("ID_khoan_thu"),
                            resultSet.getInt("Sotien"),
                            resultSet.getDate("Ngaynop"),
                            resultSet.getString("ten_khoan_thu")
                    );
                    list.add(kb);
                }
            }
            conn.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public static void insert(ql_dong_gop dp) {

        Connection cons = Connect.getConnection();

        String sql = "INSERT INTO `ql_dong_gop`(`SoCMT`, `ID_khoan_thu`, `Ngaynop`) VALUES (?, ?, ?)";

        try {
            try ( PreparedStatement statement = cons.prepareStatement(sql)) {
                statement.setString(1, dp.getSo_CMT());
                statement.setInt(2, dp.getID_khoan_thu());
                statement.setDate(3, dp.getNgaynopDate());
                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }

    }
    
    public static void delete(ql_dong_gop p) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `ql_dong_gop` WHERE `id` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setInt(1, p.getId());

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    
    public static void deletecmt(String cmt) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `ql_dong_gop` WHERE `SoCMT` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setString(1, cmt);
                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    
    public static void deleteIDkt(int ID) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `ql_dong_gop` WHERE `ID_khoan_thu` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setInt(1, ID);

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }

}
