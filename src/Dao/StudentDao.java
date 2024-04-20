package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.StudentBaseInfo;
import util.StringUtil;

public class StudentDao extends BaseDao {
    public boolean addStudent(StudentBaseInfo sbf) {
        String sql = "INSERT INTO 学生基本档案表 (学生学号, 学生姓名, 年龄, 性别, 民族, 政治面貌, 职务, 教师编号) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sbf.getStudentId());
            pstmt.setString(2, sbf.getName());
            pstmt.setInt(3, sbf.getAge());
            pstmt.setString(4, sbf.getGender());
            pstmt.setString(5, sbf.getNationality());
            pstmt.setString(6, sbf.getPoliticalStatus());
            pstmt.setString(7, sbf.getPosition());
            pstmt.setInt(8, sbf.getTeacherId());

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
    public  List<StudentBaseInfo> getStudentList(StudentBaseInfo student) {

        List<StudentBaseInfo> studentList = new ArrayList<>();
        String sql = "SELECT * FROM 学生基本档案表";
        StringBuffer sqlString = new StringBuffer(sql);

        if(!StringUtil.ifEmpty(student.getName())) {
            sqlString.append(" AND 学生姓名 LIKE '%" + student.getName() + "%'");
        }
        if(student.getStudentId() != 0) {
            sqlString.append(" AND 学生学号 LIKE '%" + student.getStudentId() + "%'");
        }
        // 清空表格中的数据
        try {
            PreparedStatement pstmt = conn.prepareStatement(sqlString.toString() .replaceFirst("AND", "WHERE"));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每个学生的信息
                int studentId = rs.getInt("学生学号");
                String name = rs.getString("学生姓名");
                int age = rs.getInt("年龄");
                String gender = rs.getString("性别");
                String nationality = rs.getString("民族");
                String politicalStatus = rs.getString("政治面貌");
                String position = rs.getString("职务");
                int teacherId = rs.getInt("教师编号");

                // 创建一个 StudentBaseInfo 对象，并将学生信息添加到列表中
                StudentBaseInfo Student = new StudentBaseInfo(studentId, name, age, gender, nationality, politicalStatus, position, teacherId);
                studentList.add(Student);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    public boolean deleteStudent(int studentId) {

        String sql = "DELETE FROM 学生基本档案表 WHERE 学生学号 = ?";
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
    public boolean updateStudent(StudentBaseInfo student) {
        String sql = "UPDATE 学生基本档案表 SET 学生姓名=?, 性别=?, 民族=?, 政治面貌=?, 职务=? WHERE 学生学号=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGender());
            pstmt.setString(3, student.getNationality());
            pstmt.setString(4, student.getPoliticalStatus());
            pstmt.setString(5, student.getPosition());
            pstmt.setInt(6, student.getStudentId());

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
    public String getStudentNameById(int studentId) {
        String studentName = null;
        String sql = "SELECT 学生姓名 FROM 学生基本档案表 WHERE 学生学号 = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                studentName = rs.getString("学生姓名");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentName;
    }

}