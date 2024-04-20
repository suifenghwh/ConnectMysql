package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StudentComment;

public class StudentCommentDao extends BaseDao {
    // 添加学生评语
    public boolean addStudentComment(StudentComment comment) {
        String sql = "INSERT INTO 学生评语表 (评语ID, 学生学号, 评语内容, 评语时间) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment.getCommentId());
            pstmt.setInt(2, comment.getStudentId());
            pstmt.setString(3, comment.getCommentContent());
            pstmt.setDate(4, new java.sql.Date(comment.getCommentDate().getTime())); // 将java.util.Date转换为java.sql.Date

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

    // 获取学生评语列表
    public List<StudentComment> getStudentCommentList(StudentComment comment) {
        List<StudentComment> commentList = new ArrayList<>();
        String sql = "SELECT * FROM 学生评语表";
        StringBuffer sqlString = new StringBuffer(sql);

        if (comment.getStudentId() != 0) {
            sqlString.append(" WHERE 学生学号 = " + comment.getStudentId());
        }

        // 清空表格中的数据
        try {
            PreparedStatement pstmt = conn.prepareStatement(sqlString.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条评语的信息
                int homevisitId = rs.getInt("评语ID");
                int studentId = rs.getInt("学生学号");
                String commentContent = rs.getString("评语内容");
                java.sql.Date commentDate = rs.getDate("评语时间");

                // 创建一个 StudentComment 对象，并将评语添加到列表中
                StudentComment studentComment = new StudentComment(homevisitId, studentId, commentContent, commentDate);
                commentList.add(studentComment);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }

    // 删除学生评语
    public boolean deleteStudentComment(int commentId) {
        String sql = "DELETE FROM 学生评语表 WHERE 评语ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, commentId);

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

    // 更新学生评语
    public boolean updateStudentComment(StudentComment comment) {
        String sql = "UPDATE 学生评语表 SET 评语内容=?, 评语时间=? WHERE 评语ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, comment.getCommentContent());
            pstmt.setDate(2, new java.sql.Date(comment.getCommentDate().getTime())); // 将java.util.Date转换为java.sql.Date
            pstmt.setInt(3, comment.getCommentId());

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
}
