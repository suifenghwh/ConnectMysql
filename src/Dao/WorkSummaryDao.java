package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.WorkSummary;

public class WorkSummaryDao extends BaseDao {

    public boolean addWorkSummary(WorkSummary summary) {
        String sql = "INSERT INTO 工作总结表 (总结内容, 总结时间, 教师编号) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, summary.getSummaryContent());
            pstmt.setString(2, summary.getSummaryTime());
            pstmt.setInt(3, summary.getTeacherId());
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<WorkSummary> getWorkSummaryList(WorkSummary criteria) {
        List<WorkSummary> summaryList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM 工作总结表 WHERE 1 = 1");

        if (criteria.getTeacherId() != 0) {
            sql.append(" AND 教师编号 = ").append(criteria.getTeacherId());
        }
        // 添加其他查询条件

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int summaryId = rs.getInt("总结ID");
                String summaryContent = rs.getString("总结内容");
                String summaryTime = rs.getString("总结时间");
                int teacherId = rs.getInt("教师编号");

                WorkSummary summary = new WorkSummary(summaryId, summaryContent, summaryTime, teacherId);
                summaryList.add(summary);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return summaryList;
    }

    public boolean updateWorkSummary(WorkSummary summary) {
        String sql = "UPDATE 工作总结表 SET 总结内容 = ?, 总结时间 = ? WHERE 总结ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, summary.getSummaryContent());
            pstmt.setString(2, summary.getSummaryTime());
            pstmt.setInt(3, summary.getSummaryId());
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteWorkSummary(int summaryId) {
        String sql = "DELETE FROM 工作总结表 WHERE 总结ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, summaryId);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}