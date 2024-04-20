package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClassActivity;

public class ClassActivityDao extends BaseDao {
    // 添加班级活动记录
    public boolean addClassActivity(ClassActivity activity) {
        String sql = "INSERT INTO 班级活动表 (活动ID, 活动名称, 活动时间, 活动地点, 主要负责人, 教师编号) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activity.getActivityId());
            pstmt.setString(2, activity.getActivityName());
            pstmt.setDate(3, activity.getActivityTime());
            pstmt.setString(4, activity.getLocation());
            pstmt.setString(5, activity.getOrganizer());
            pstmt.setInt(6, activity.getTeacherId());

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

    // 获取班级活动记录列表
    public List<ClassActivity> getActivityList(ClassActivity activity) {
        List<ClassActivity> activityList = new ArrayList<>();
        String sql = "SELECT * FROM 班级活动表 WHERE 1 = 1";

        // 构建查询语句

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条班级活动记录的信息
                int activityId = rs.getInt("活动ID");
                String activityName = rs.getString("活动名称");
                java.sql.Date activityTime = rs.getDate("活动时间");
                String location = rs.getString("活动地点");
                String organizer = rs.getString("主要负责人");
                int teacherId = rs.getInt("教师编号");

                // 创建一个 ClassActivity 对象，并将班级活动记录添加到列表中
                ClassActivity activityInfo = new ClassActivity(activityId, activityName, activityTime, location, organizer, teacherId);
                activityList.add(activityInfo);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activityList;
    }

    // 删除班级活动记录
    public boolean deleteActivity(int activityId) {
        String sql = "DELETE FROM 班级活动表 WHERE 活动ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activityId);

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

    // 更新班级活动记录
    public boolean updateActivity(ClassActivity activity) {
        String sql = "UPDATE 班级活动表 SET 活动名称=?, 活动时间=?, 活动地点=?, 主要负责人=?, 教师编号=? WHERE 活动ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, activity.getActivityName());
            pstmt.setDate(2, activity.getActivityTime());
            pstmt.setString(3, activity.getLocation());
            pstmt.setString(4, activity.getOrganizer());
            pstmt.setInt(5, activity.getTeacherId());
            pstmt.setInt(6, activity.getActivityId());

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
