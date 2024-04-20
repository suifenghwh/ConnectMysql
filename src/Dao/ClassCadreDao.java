package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassCadre;
import util.StringUtil;

public class ClassCadreDao extends BaseDao {
    public boolean addClassCadre(ClassCadre classCadre) {
        String sql = "INSERT INTO 班干部管理表 (学生学号, 职务, 职责, 开始时间, 结束时间) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, classCadre.getStudentId());
            pstmt.setString(2, classCadre.getPosition());
            pstmt.setString(3, classCadre.getResponsibilities());
            pstmt.setDate(4, new java.sql.Date(classCadre.getStartDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(classCadre.getEndDate().getTime()));

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

    public List<ClassCadre> getClassCadreList(ClassCadre classCadre) {
        List<ClassCadre> classCadreList = new ArrayList<>();
        String sql = "SELECT * FROM 班干部管理表 WHERE 1 = 1";

        // 构建查询语句
        if (classCadre.getStudentId() != 0) {
            sql += " AND 学生学号 = " + classCadre.getStudentId();
        }
        // 添加其他查询条件，比如日期等

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条干部记录的信息
                int cadreId = rs.getInt("干部ID");
                int studentId = rs.getInt("学生学号");
                String position = rs.getString("职务");
                String responsibilities = rs.getString("职责");
                Date startDate = rs.getDate("开始时间");
                Date endDate = rs.getDate("结束时间");

                // 创建一个 ClassCadre 对象，并将干部记录添加到列表中
                ClassCadre cadreInfo = new ClassCadre(cadreId, studentId, position, responsibilities, startDate, endDate);
                classCadreList.add(cadreInfo);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classCadreList;
    }


    public boolean deleteClassCadre(int cadreId) {

        String sql = "DELETE FROM 班干部管理表 WHERE 干部ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cadreId);

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

    public boolean updateClassCadre(ClassCadre classCadre) {
        String sql = "UPDATE 班干部管理表 SET 学生学号=?, 职务=?, 职责=?, 开始时间=?, 结束时间=? WHERE 干部ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, classCadre.getStudentId());
            pstmt.setString(2, classCadre.getPosition());
            pstmt.setString(3, classCadre.getResponsibilities());
            pstmt.setDate(4, new java.sql.Date(classCadre.getStartDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(classCadre.getEndDate().getTime()));
            pstmt.setInt(6, classCadre.getCadreId());

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
