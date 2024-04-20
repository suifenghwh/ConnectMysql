package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StudentBaseInfo;
import model.Teacher;
import util.StringUtil;

public class TeacherDao extends BaseDao {
    public boolean addTeacher(Teacher teacher) {
        String sql = "INSERT INTO 班主任表  VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, teacher.getTeacherId());
            pstmt.setString(2, teacher.getteacherName());
            pstmt.setString(3, teacher.getPassword());

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
    public Teacher  login(Teacher ad) {
        String sql = "SELECT * FROM 班主任表 WHERE name = ? AND password = ?";
        Teacher teacherRst = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ad.getteacherName());
            pstmt.setString(2, ad.getPassword());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    teacherRst = new Teacher();
                    teacherRst.setTeacherId(rs.getInt("id"));
                    teacherRst.setUsername(rs.getString("name"));
                    teacherRst.setPassword(rs.getString("password"));
//	                    adminRst.setCreateDate(rs.getString("createDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherRst;
    }

}
