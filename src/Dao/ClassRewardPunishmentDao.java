package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClassRewardPunishment;

public class ClassRewardPunishmentDao extends BaseDao {
    // 添加班级奖惩记录
    public boolean addClassRewardPunishment(ClassRewardPunishment rewardPunishment) {
        String sql = "INSERT INTO 班级奖惩记录表 (奖惩ID, 学生学号, 奖惩内容, 奖惩时间) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rewardPunishment.getRecordId());
            pstmt.setInt(2, rewardPunishment.getStudentId());
            pstmt.setString(3, rewardPunishment.getContent());
            pstmt.setDate(4, rewardPunishment.getRecordTime());

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

    // 获取班级奖惩记录列表
    public List<ClassRewardPunishment> getRewardPunishmentList(ClassRewardPunishment rewardPunishment) {
        List<ClassRewardPunishment> rewardPunishmentList = new ArrayList<>();
        String sql = "SELECT * FROM 班级奖惩记录表 WHERE 1 = 1";

        // 构建查询语句
        // 这里可以根据需要添加其他查询条件

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条班级奖惩记录的信息
                int recordId = rs.getInt("奖惩ID");
                int studentId = rs.getInt("学生学号");
                String content = rs.getString("奖惩内容");
                java.sql.Date recordTime = rs.getDate("奖惩时间");

                // 创建一个 ClassRewardPunishment 对象，并将班级奖惩记录添加到列表中
                ClassRewardPunishment rewardPunishmentInfo = new ClassRewardPunishment(recordId, studentId, content, recordTime);
                rewardPunishmentList.add(rewardPunishmentInfo);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rewardPunishmentList;
    }

    // 删除班级奖惩记录
    public boolean deleteRewardPunishment(int recordId) {
        String sql = "DELETE FROM 班级奖惩记录表 WHERE 奖惩ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, recordId);

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

    // 更新班级奖惩记录
    public boolean updateRewardPunishment(ClassRewardPunishment rewardPunishment) {
        String sql = "UPDATE 班级奖惩记录表 SET 学生学号=?, 奖惩内容=?, 奖惩时间=? WHERE 奖惩ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rewardPunishment.getStudentId());
            pstmt.setString(2, rewardPunishment.getContent());
            pstmt.setDate(3, rewardPunishment.getRecordTime());
            pstmt.setInt(4, rewardPunishment.getRecordId());

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
