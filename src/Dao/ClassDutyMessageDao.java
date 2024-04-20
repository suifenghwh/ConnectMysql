package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClassDutyMessage;
import util.StringUtil;

public class ClassDutyMessageDao extends BaseDao {
    // 添加班级值日消息
    public boolean addDutyMessage(ClassDutyMessage dutyMessage) {
        String sql = "INSERT INTO 班级值日消息表 (值日ID, 学生学号, 值日地点, 值日时间) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dutyMessage.getDutyId());
            pstmt.setInt(2, dutyMessage.getStudentId());
            pstmt.setString(3, dutyMessage.getDutyLocation());
            pstmt.setString(4, dutyMessage.getDutyTime());

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

    // 获取班级值日消息列表
    public List<ClassDutyMessage> getDutyMessageList(ClassDutyMessage dutyMessage) {
        List<ClassDutyMessage> dutyMessageList = new ArrayList<>();
        String sql = "SELECT * FROM 班级值日消息表 WHERE 1 = 1";

        // 构建查询语句
        if (dutyMessage.getStudentId() != 0) {
            sql += " AND 学生学号 = " + dutyMessage.getStudentId();
        }
        // 添加其他查询条件，比如日期等

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条值日消息记录的信息
                int dutyId = rs.getInt("值日ID");
                int studentId = rs.getInt("学生学号");
                String dutyLocation = rs.getString("值日地点");
                String dutyTime = rs.getString("值日时间");

                // 创建一个 ClassDutyMessage 对象，并将值日消息记录添加到列表中
                ClassDutyMessage dutyMsg = new ClassDutyMessage(dutyId, studentId, dutyLocation, dutyTime);
                dutyMessageList.add(dutyMsg);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dutyMessageList;
    }

    // 删除班级值日消息
    public boolean deleteDutyMessage(int dutyId) {
        String sql = "DELETE FROM 班级值日消息表 WHERE 值日ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dutyId);

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

    // 更新班级值日消息
    public boolean updateDutyMessage(ClassDutyMessage dutyMessage) {
        String sql = "UPDATE 班级值日消息表 SET 学生学号=?, 值日地点=?, 值日时间=? WHERE 值日ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dutyMessage.getStudentId());
            pstmt.setString(2, dutyMessage.getDutyLocation());
            pstmt.setString(3, dutyMessage.getDutyTime());
            pstmt.setInt(4, dutyMessage.getDutyId());

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
