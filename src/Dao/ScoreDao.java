package Dao;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.Score;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ScoreDao extends BaseDao {
    // 查询学生成绩信息的视图名称
//    private static final String STUDENT_SCORES_VIEW = "StudentScoresView";

    // 查询学生某门课程的成绩
//    public List<StudentScore> getStudentScoresByCourse(int courseId) {
//        List<StudentScore> scores = new ArrayList<>();
//        String sql = "SELECT * FROM " + STUDENT_SCORES_VIEW + " WHERE  ScoreID = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//          ]]  pstmt.setInt(1, courseId);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                int studentId = rs.getInt("StudentID");
//                String studentName = rs.getString("StudentName");
//                // 获取其他成绩信息...
//                // 这里假设 StudentScore 是一个自定义的类，用于封装学生的成绩信息
//                StudentScore score = new StudentScore(studentId, studentName, ...);
//                scores.add(score);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return scores;
//    }
    // 插入成绩记录的 SQL 语句
//    private static final

    // 插入成绩记录
    // 插入成绩记录
    public boolean addScore(Score score) {
        String INSERT_SCORE_SQL = "INSERT INTO 成绩表 (学生学号, 语文, 数学, 英语, 历史, 物理, 生物, 化学, 地理) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_SCORE_SQL);
            // 设置 SQL 语句参数
            pstmt.setInt(1, score.getStudentId());
            pstmt.setInt(2, score.getChinese());
            pstmt.setInt(3, score.getMath());
            pstmt.setInt(4, score.getEnglish());
            pstmt.setInt(5, score.getHistory());
            pstmt.setInt(6, score.getPhysics());
            pstmt.setInt(7, score.getBiology());
            pstmt.setInt(8, score.getChemistry());
            pstmt.setInt(9, score.getGeography());

            // 执行 SQL 插入操作
            int rowsAffected = pstmt.executeUpdate();

            // 返回插入操作是否成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 插入操作失败
            return false;
        }
    }

    // 获取成绩列表
    public List<Score> getScoreList(Score sc) {
        List<Score> scoreList = new ArrayList<>();
        String SELECT_SCORE_SQL = "SELECT * FROM 成绩表";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SELECT_SCORE_SQL);
            ResultSet rs = pstmt.executeQuery();

            // 遍历结果集，将成绩信息添加到列表中
            while (rs.next()) {
                int studentId = rs.getInt("学生学号");
                int chinese = rs.getInt("语文");
                int math = rs.getInt("数学");
                int english = rs.getInt("英语");
                int history = rs.getInt("历史");
                int physics = rs.getInt("物理");
                int biology = rs.getInt("生物");
                int chemistry = rs.getInt("化学");
                int geography = rs.getInt("地理");

                Score score = new Score(studentId, chinese, math, english, history, physics, biology, chemistry, geography);
                scoreList.add(score);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scoreList;
    }

    public boolean isScoreAdded(Score score) {
        String SELECT_SCORE_SQL = "SELECT * FROM 成绩表 WHERE 学生学号 = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SELECT_SCORE_SQL);
            pstmt.setInt(1, score.getStudentId());
            ResultSet rs = pstmt.executeQuery();

            // 如果结果集中有数据，则表示成绩已经添加
            boolean scoreAdded = rs.next();

            rs.close();
            pstmt.close();

            return scoreAdded;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//         public void getStatsInfo() {
//       	 SELECT 学生学号,AVG( 语文+ 数学 + 英语 + 历史 +物理 + 生物+ 化学+ 地理) AS average_score,SUM(语文+ 数学 + 英语 + 历史 +物理 + 生物+ 化学+ 地理 ) AS total_score
//        	FROM
//        	    成绩表
//        	GROUP BY
//        	    学生学号;


    //         }
    public Map<String,String> getStatsInfo(int studentID) {
        Map<String, String> ret = new HashMap<>();
        String sql = "SELECT SUM(语文 + 数学 + 英语 + 历史 + 物理 + 生物 + 化学 + 地理)/8.0 AS average_score, "
                + "SUM(语文 + 数学 + 英语 + 历史 + 物理 + 生物 + 化学 + 地理) AS total_score "
                + "FROM 成绩表 WHERE 学生学号 = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentID);
            ResultSet rs = pstmt.executeQuery();

            // 如果查询到结果，则将平均分和总分添加到返回的 Map 中
            if (rs.next()) {
                double averageScore = rs.getDouble("average_score");
                int totalScore = rs.getInt("total_score");

                ret.put("average_score", String.valueOf(averageScore));
                ret.put("total_score", String.valueOf(totalScore));
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;


    }
    // 查询课程的最高分和最低分
    public Map<String, Integer> getCourseStats(String courseName) {
        Map<String, Integer> stats = new HashMap<>();
        String sql = "SELECT MAX(总分) AS max_score, MIN(总分) AS min_score FROM 成绩表 WHERE 课程名称 = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 获取最高分和最低分并添加到结果集中
                int maxScore = rs.getInt("max_score");
                int minScore = rs.getInt("min_score");
                stats.put("max_score", maxScore);
                stats.put("min_score", minScore);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }
    public boolean deleteScore(Score score) {
        String DELETE_SCORE_SQL = "DELETE FROM 成绩表 WHERE 学生学号 = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(DELETE_SCORE_SQL);
            // 设置 SQL 语句参数
            pstmt.setInt(1, score.getStudentId());

            // 执行 SQL 删除操作
            int rowsAffected = pstmt.executeUpdate();

            // 返回删除操作是否成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 删除操作失败
            return false;
        }
    }


}
