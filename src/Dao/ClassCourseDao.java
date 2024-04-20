package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassCourse;
import util.StringUtil;

public class ClassCourseDao extends BaseDao {
    // 添加班级课程
    public boolean addCourse(ClassCourse course) {
        String sql = "INSERT INTO 班级课程表 VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, course.getCourseId());
            pstmt.setString(2, course.getCourseName());
            pstmt.setString(3, course.getClassTime());
            pstmt.setString(4, course.getTeacherName());
            pstmt.setInt(5, course.getTeacherId());

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
    public  List<ClassCourse> getCourseList(ClassCourse course) {

        List<ClassCourse> courseList = new ArrayList<>();
        String sql = "SELECT * FROM 班级课程表";
        StringBuffer sqlString = new StringBuffer(sql);

        if(!StringUtil.ifEmpty(course.getCourseName())) {
            sqlString.append(" AND 课程名称 LIKE '%" + course.getCourseName() + "%'");
        }
        if(course.getCourseId() != 0) {
            sqlString.append(" AND 课程编号 LIKE '%" + course.getCourseId() + "%'");
        }
        if (!StringUtil.ifEmpty(course.getTeacherName())) {
            sqlString.append(" AND 教师名字 LIKE '%" + course.getTeacherName() + "%'");
        }
        // 清空表格中的数据
        try {
            PreparedStatement pstmt = conn.prepareStatement(sqlString.toString() .replaceFirst("AND", "WHERE"));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int courseId = rs.getInt("课程编号");
                String courseName = rs.getString("课程名称");
                String classTime = rs.getString("上课时间");
                String teacherName = rs.getString("教师名字");
                int teacherId = rs.getInt("教师编号");

                ClassCourse courseInfo = new ClassCourse(courseId, courseName, classTime, teacherName, teacherId);
                courseList.add(courseInfo);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }
    public boolean deleteCourse(int studentId) {

        String sql = "DELETE FROM 班级课程表 WHERE 课程编号 = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);

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
    public boolean updateCourse(ClassCourse course) {
        String sql = "UPDATE 班级课程表 SET 课程编号=?, 课程名称=?, 上课时间=?, 教师名字=? WHERE 课程编号=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, course.getCourseId());
            pstmt.setString(2, course.getCourseName());
            pstmt.setString(3, course.getClassTime());
            pstmt.setString(4, course.getTeacherName());
            pstmt.setInt(5, course.getCourseId());


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
