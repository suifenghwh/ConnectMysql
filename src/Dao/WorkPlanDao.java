package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.WorkPlan;

public class WorkPlanDao extends BaseDao {

    // 添加工作计划记录
    public boolean addWorkPlan(WorkPlan workPlan) {
        String sql = "INSERT INTO 工作计划表 (计划ID, 计划内容, 计划时间, 教师编号) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, workPlan.getPlanId()); // 设置计划ID
            pstmt.setString(2, workPlan.getPlanContent());
            pstmt.setString(3, workPlan.getPlanTime());
            pstmt.setInt(4, workPlan.getTeacherId());

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


    // 获取工作计划列表
    public List<WorkPlan> getWorkPlanList(WorkPlan workPlan) {
        List<WorkPlan> workPlanList = new ArrayList<>();
        String sql = "SELECT * FROM 工作计划表 WHERE 1 = 1";

        // 构建查询语句
        // 可根据传入的 workPlan 对象中的属性值来添加条件

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条工作计划记录的信息
                int planId = rs.getInt("计划ID");
                String planContent = rs.getString("计划内容");
                String planTime = rs.getString("计划时间");
                int teacherId = rs.getInt("教师编号");

                // 创建一个 WorkPlan 对象，并将工作计划记录添加到列表中
                WorkPlan plan = new WorkPlan(planId, planContent, planTime, teacherId);
                workPlanList.add(plan);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workPlanList;
    }

    // 更新工作计划记录
    public boolean updateWorkPlan(WorkPlan workPlan) {
        String sql = "UPDATE 工作计划表 SET 计划内容=?, 计划时间=?, 教师编号=? WHERE 计划ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, workPlan.getPlanContent());
            pstmt.setString(2, workPlan.getPlanTime());
            pstmt.setInt(3, workPlan.getTeacherId());
            pstmt.setInt(4, workPlan.getPlanId());

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

    // 删除工作计划记录
    public boolean deleteWorkPlan(int planId) {
        String sql = "DELETE FROM 工作计划表 WHERE 计划ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, planId);

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
}