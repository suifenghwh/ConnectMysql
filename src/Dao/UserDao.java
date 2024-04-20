package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.StringUtil;

public class UserDao extends BaseDao {

    public boolean addUser(User user) {
        String sql = "INSERT INTO 用户表 (教师编号, 用户名, 密码) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getTeacherId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // 如果影响的行数大于0，则表示插入成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 插入失败
            return false;
        }
    }

    public List<User> getAllUsers(User user) {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM 用户表 WHERE 1 = 1";

        if (!StringUtil.ifEmpty(user.getUsername())) {
            sql += " AND 用户名 LIKE '%" + user.getUsername() + "%'";
        }
        if (user.getTeacherId() != 0) {
            sql += " AND 教师编号 = " + user.getTeacherId();
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每个用户的信息
                int teacherId = rs.getInt("教师编号");
                String username = rs.getString("用户名");
                String password = rs.getString("密码");

                // 创建一个User对象，并将用户添加到列表中
                User u = new User(teacherId, username, password);
                userList.add(u);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public boolean deleteUser(int teacherId) {
        String sql = "DELETE FROM 用户表 WHERE 教师编号 = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, teacherId);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // 如果影响的行数大于0，则表示删除成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 删除失败
            return false;
        }
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE 用户表 SET 用户名=?, 密码=? WHERE 教师编号=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getTeacherId());

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // 如果影响的行数大于0，则表示更新成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 更新失败
            return false;
        }
    }
}
