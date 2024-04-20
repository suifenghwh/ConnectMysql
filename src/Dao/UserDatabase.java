package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Dbutil;
public class UserDatabase {
    public static boolean verifyPassword(String username, String password) {
        // 这里可以写验证用户密码的逻辑
        // 比如查询数据库中的用户密码，然后与用户输入的密码进行比较
        // 如果密码正确，返回true；否则返回false
        // 验证用户密码是否正确
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 获取数据库连接
            conn = Dbutil.getConnection();

            // SQL 查询语句
            String sql = "SELECT password FROM s_admin WHERE name = ?";

            // 创建 PreparedStatement 对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            // 执行查询操作
            rs = pstmt.executeQuery();

            // 如果查询到结果集
            if (rs.next()) {
                // 获取数据库中存储的密码
                String storedPassword = rs.getString("password");

                // 比较数据库中存储的密码与用户输入的密码是否相同
                return storedPassword.equals(password);
            } else {
                // 没有查询到匹配的用户名，返回 false
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭数据库连接
            Dbutil.close(conn, pstmt, rs);
        }

        // 这里假设密码验证通过，实际中需要根据具体逻辑返回相应的结果
    }

}