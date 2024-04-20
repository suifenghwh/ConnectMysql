package Dao;

import model.Dormitory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DormitoryDao extends BaseDao {

    public boolean addDormitory(Dormitory dormitory) {
        String sql = "INSERT INTO 宿舍管理表 (宿舍ID, 宿舍号, 学生学号, 床位数) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dormitory.getDormitoryId());
            pstmt.setInt(2, dormitory.getDormitoryNumber());
            pstmt.setInt(3, dormitory.getStudentId());
            pstmt.setInt(4, dormitory.getBedCount());

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


    // 获取宿舍列表
    // 在 DormitoryDao 类中修改 getDormitoryList 方法的签名
    public List<Dormitory> getDormitoryList(Dormitory dormitory) {
        List<Dormitory> dormitoryList = new ArrayList<>();
        String sql = "SELECT * FROM 宿舍管理表 WHERE 1 = 1";

        // 构建查询语句
        if (dormitory.getDormitoryId() != 0) {
            sql += " AND 宿舍ID = " + dormitory.getDormitoryId();
        }
        // 添加其他查询条件，比如宿舍号等

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条宿舍记录的信息
                int dormitoryId = rs.getInt("宿舍ID");
                int dormitoryNumber = rs.getInt("宿舍号");
                int studentId = rs.getInt("学生学号");
                int bedCount = rs.getInt("床位数");

                // 创建一个 Dormitory 对象，并将宿舍记录添加到列表中
                Dormitory dormitoryInfo = new Dormitory(dormitoryId, dormitoryNumber, studentId, bedCount);
                dormitoryList.add(dormitoryInfo);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dormitoryList;
    }


    // 删除宿舍信息
    public boolean deleteDormitory(int dormitoryId) {
        String sql = "DELETE FROM 宿舍管理表 WHERE 宿舍ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dormitoryId);

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

    // 更新宿舍信息
    public boolean updateDormitory(Dormitory dormitory) {
        String sql = "UPDATE 宿舍管理表 SET 宿舍号=?, 学生学号=?, 床位数=? WHERE 宿舍ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dormitory.getDormitoryNumber());
            pstmt.setInt(2, dormitory.getStudentId());
            pstmt.setInt(3, dormitory.getBedCount());
            pstmt.setInt(4, dormitory.getDormitoryId());

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
