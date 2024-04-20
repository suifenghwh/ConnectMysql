package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClassFee;
import util.StringUtil;

public class ClassFeeDao extends BaseDao {
    // 添加班费记录
    public boolean addClassFee(ClassFee fee) {
        String sql = "INSERT INTO 班费管理表 (班费ID, 学生学号, 缴费金额, 缴费时间) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, fee.getFeeId());
            pstmt.setInt(2, fee.getStudentId());
            pstmt.setInt(3, fee.getPaymentAmount());
            pstmt.setDate(4, fee.getPaymentTime());

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

    // 获取班费记录列表
    public List<ClassFee> getFeeList(ClassFee fee) {
        List<ClassFee> feeList = new ArrayList<>();
        String sql = "SELECT * FROM 班费管理表 WHERE 1 = 1";

        // 构建查询语句
        if (fee.getStudentId() != 0) {
            sql += " AND 学生学号 = " + fee.getStudentId();
        }
        // 添加其他查询条件，比如日期等

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条班费记录的信息
                int feeId = rs.getInt("班费ID");
                int studentId = rs.getInt("学生学号");
                int paymentAmount = rs.getInt("缴费金额");
                java.sql.Date paymentTime = rs.getDate("缴费时间");

                // 创建一个 ClassFee 对象，并将班费记录添加到列表中
                ClassFee feeInfo = new ClassFee(feeId, studentId, paymentAmount, paymentTime);
                feeList.add(feeInfo);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feeList;
    }

    // 删除班费记录
    public boolean deleteFee(int feeId) {
        String sql = "DELETE FROM 班费管理表 WHERE 班费ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, feeId);

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

    // 更新班费记录
    public boolean updateFee(ClassFee fee) {
        String sql = "UPDATE 班费管理表 SET 学生学号=?, 缴费金额=?, 缴费时间=? WHERE 班费ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, fee.getStudentId());
            pstmt.setInt(2, fee.getPaymentAmount());
            pstmt.setDate(3, fee.getPaymentTime());
            pstmt.setInt(4, fee.getFeeId());

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
