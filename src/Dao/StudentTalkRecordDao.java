package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StudentTalkRecord;

public class StudentTalkRecordDao extends BaseDao {

    public boolean addStudentTalkRecord(StudentTalkRecord record) {
        String sql = "INSERT INTO 学生谈话记录表 (学生学号, 谈话内容, 谈话时间) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, record.getStudentId());
            pstmt.setString(2, record.getTalkContent());
            pstmt.setString(3, record.getTalkTime());

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<StudentTalkRecord> getTalkRecords(StudentTalkRecord criteria) {
        List<StudentTalkRecord> recordList = new ArrayList<>();
        String sql = "SELECT * FROM 学生谈话记录表 WHERE 1 = 1";

        if (criteria.getStudentId() != 0) {
            sql += " AND 学生学号 = " + criteria.getStudentId();
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int talkId = rs.getInt("谈话ID");
                int studentId = rs.getInt("学生学号");
                String talkContent = rs.getString("谈话内容");
                String talkTime = rs.getString("谈话时间");

                StudentTalkRecord record = new StudentTalkRecord(talkId, studentId, talkContent, talkTime);
                recordList.add(record);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recordList;
    }

    public boolean updateTalkRecord(StudentTalkRecord record) {
        String sql = "UPDATE 学生谈话记录表 SET 谈话内容=?, 谈话时间=? WHERE 谈话ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, record.getTalkContent());
            pstmt.setString(2, record.getTalkTime());
            pstmt.setInt(3, record.getTalkId());

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTalkRecord(int talkId) {
        String sql = "DELETE FROM 学生谈话记录表 WHERE 谈话ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, talkId);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
