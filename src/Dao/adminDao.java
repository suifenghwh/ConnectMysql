package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.admin;
import util.Dbutil;

public class adminDao extends BaseDao {
    //管理员登录
    public  admin login(admin ad) {
        String sql = "SELECT * FROM s_admin WHERE name = ? AND password = ?";
        admin adminRst = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ad.getName());
            pstmt.setString(2, ad.getPassword());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    adminRst = new admin();
                    adminRst.setId(rs.getInt("id"));
                    adminRst.setName(rs.getString("name"));
                    adminRst.setPassword(rs.getString("password"));
//                    adminRst.setCreateDate(rs.getString("createDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adminRst;
    }

}