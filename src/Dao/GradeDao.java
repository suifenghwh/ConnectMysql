package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grade;

public class GradeDao extends BaseDao {
    // 添加成绩
    public boolean addGrade(Grade grade) {
        String sql = "INSERT INTO 成绩表 (成绩ID, 学生学号, 语文成绩, 数学成绩, 英语成绩, 历史成绩, 物理成绩, 生物成绩, 化学成绩, 地理成绩) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, grade.getGradeId());
            pstmt.setInt(2, grade.getStudentId());
            pstmt.setInt(3, grade.getChinese());
            pstmt.setInt(4, grade.getMath());
            pstmt.setInt(5, grade.getEnglish());
            pstmt.setInt(6, grade.getHistory());
            pstmt.setInt(7, grade.getPhysics());
            pstmt.setInt(8, grade.getBiology());
            pstmt.setInt(9, grade.getChemistry());
            pstmt.setInt(10, grade.getGeography());

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // 如果影响的行数大于0，表示插入成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 插入失败
            return false;
        }
    }

    // 获取所有成绩
    public List<Grade> getAllGrades() {
        List<Grade> gradeList = new ArrayList<>();
        String sql = "SELECT * FROM 成绩表";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每个成绩的信息
                int gradeId = rs.getInt("成绩ID");
                int studentId = rs.getInt("学生学号");
                int chinese = rs.getInt("语文");
                int math = rs.getInt("数学");
                int english = rs.getInt("英语");
                int history = rs.getInt("历史");
                int physics = rs.getInt("物理");
                int biology = rs.getInt("生物");
                int chemistry = rs.getInt("化学");
                int geography = rs.getInt("地理");

                // 创建一个Grade对象，并将成绩添加到列表中
                Grade grade = new Grade(gradeId, studentId, chinese, math, english, history, physics, biology, chemistry, geography);
                gradeList.add(grade);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeList;
    }

    // 根据成绩ID获取成绩
    public Grade getGradeById(int gradeId) {
        String sql = "SELECT * FROM 成绩表 WHERE 成绩ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gradeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 从结果集中获取成绩的信息
                int studentId = rs.getInt("学生学号");
                int chinese = rs.getInt("语文");
                int math = rs.getInt("数学");
                int english = rs.getInt("英语");
                int history = rs.getInt("历史");
                int physics = rs.getInt("物理");
                int biology = rs.getInt("生物");
                int chemistry = rs.getInt("化学");
                int geography = rs.getInt("地理");

                // 创建并返回一个Grade对象
                return new Grade(gradeId, studentId, chinese, math, english, history, physics, biology, chemistry, geography);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 更新成绩
    public boolean updateGrade(Grade grade) {
        String sql = "UPDATE 成绩表 SET 学生学号=?, 语文=?, 数学=?, 英语=?, 历史=?, 物理=?, 生物=?, 化学=?, 地理=? WHERE 成绩ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, grade.getStudentId());
            pstmt.setInt(2, grade.getChinese());
            pstmt.setInt(3, grade.getMath());
            pstmt.setInt(4, grade.getEnglish());
            pstmt.setInt(5, grade.getHistory());
            pstmt.setInt(6, grade.getPhysics());
            pstmt.setInt(7, grade.getBiology());
            pstmt.setInt(8, grade.getChemistry());
            pstmt.setInt(9, grade.getGeography());
            pstmt.setInt(10, grade.getGradeId());

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // 如果影响的行数大于0，表示更新成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 更新失败
            return false;
        }
    }

    // 删除成绩
    public boolean deleteGrade(int gradeId) {
        String sql = "DELETE FROM 成绩表 WHERE 成绩ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gradeId);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // 如果影响的行数大于0，表示删除成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 删除失败
            return false;
        }
    }
}
