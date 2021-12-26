package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.*;


public class daokhoanthuImpl  implements daokhoanthu{
    public static List<khoan_thu> findALL() {
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM `khoan_thu`";
        List<khoan_thu> list = new ArrayList<>();
        try {
            try (PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    khoan_thu kb = new khoan_thu(
                            resultSet.getInt("ID_khoan_thu"),
                            resultSet.getString("ten_khoan_thu"),
                            resultSet.getInt("Sotien"),
                            resultSet.getBoolean("Batbuoc")
                            );
                    list.add(kb);
                }
            }
            conn.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public static void insert( khoan_thu dp) {

        Connection cons = Connect.getConnection();

        String sql = "INSERT INTO `khoan_thu`(`ten_khoan_thu`, `Sotien`, `Batbuoc`) VALUES (?, ?, ?)";

        try {
            try (PreparedStatement statement = cons.prepareStatement(sql)) {
                statement.setString(1,dp.getTen_khoan_thu());
                statement.setInt(2, dp.getSotien());
                statement.setBoolean(3, dp.isBatbuoc());
                
                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    public static void update(khoan_thu dp) {
        Connection cons = Connect.getConnection();
        String sql = "update `khoan_thu` set  `ten_khoan_thu`=?, `Sotien`=?, `Batbuoc`=? where `ID_khoan_thu`= ? ";
        try {
            try (PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setString(1, dp.getTen_khoan_thu());
                statement.setInt(2, dp.getSotien());
                statement.setBoolean(3, dp.isBatbuoc());
                statement.setInt(4, dp.getID());
                
                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    public static void delete(khoan_thu id) {
        Connection cons = Connect.getConnection();
        String sql = "DELETE FROM `khoan_thu` WHERE `ID_khoan_thu` = ?";
        try {
            try ( PreparedStatement statement = (PreparedStatement) cons.prepareStatement(sql)) {
                statement.setInt(1, id.getID());

                statement.execute();
            }
            cons.close();
        } catch (SQLException e) {
        }
    }
    


}
