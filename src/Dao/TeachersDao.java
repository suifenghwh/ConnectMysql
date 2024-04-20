package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teachers;

public class TeachersDao extends BaseDao{

    public List<Teachers> getTeacherList(Teachers t) {
        List<Teachers> teacherList = new ArrayList<>();
        String sql = "SELECT * FROM 教师表";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每个教师的信息
                Teachers teacher = new Teachers();
                teacher.setID(rs.getInt("教师编号"));
                teacher.setTeacherName(rs.getString("教师姓名"));
                teacher.setSex(rs.getString("教师性别"));
                teacher.setAge(rs.getInt("教师年龄"));

                // 将每个教师对象添加到列表中
                teacherList.add(teacher);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherList;
    }
}