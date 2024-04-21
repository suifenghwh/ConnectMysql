package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThemeMeetingRecord;

public class ThemeMeetingRecordDao extends BaseDao {
    public boolean addThemeMeetingRecord(ThemeMeetingRecord record) {
        String sql = "INSERT INTO 主题班会记录表 (班会ID, 会议主题, 会议时间, 教师编号) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, record.getMeetingId()); // 设置班会ID
            pstmt.setString(2, record.getMeetingTheme());
            pstmt.setString(3, record.getMeetingTime());
            pstmt.setInt(4, record.getTeacherId());

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


    public List<ThemeMeetingRecord> getMeetingRecords(ThemeMeetingRecord searchCriteria) {
        List<ThemeMeetingRecord> recordList = new ArrayList<>();
        String sql = "SELECT * FROM 主题班会记录表 WHERE 1 = 1";

        // 构建查询语句
        if (searchCriteria.getTeacherId() != 0) {
            sql += " AND 教师编号 = " + searchCriteria.getTeacherId();
        }
        // 添加其他查询条件，比如会议时间等

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条记录的信息
                int meetingId = rs.getInt("班会ID");
                String meetingTheme = rs.getString("会议主题");
                String meetingTime = rs.getString("会议时间");
                int teacherId = rs.getInt("教师编号");

                // 创建一个 ThemeMeetingRecord 对象，并将记录添加到列表中
                ThemeMeetingRecord record = new ThemeMeetingRecord(meetingId, meetingTheme, meetingTime, teacherId);
                recordList.add(record);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recordList;
    }

    public boolean updateMeetingRecord(ThemeMeetingRecord record) {
        String sql = "UPDATE 主题班会记录表 SET 会议主题=?, 会议时间=?, 教师编号=? WHERE 班会ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, record.getMeetingTheme());
            pstmt.setString(2, record.getMeetingTime());
            pstmt.setInt(3, record.getTeacherId());
            pstmt.setInt(4, record.getMeetingId());

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

    public boolean deleteMeetingRecord(int meetingId) {
        String sql = "DELETE FROM 主题班会记录表 WHERE 班会ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, meetingId);

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
}