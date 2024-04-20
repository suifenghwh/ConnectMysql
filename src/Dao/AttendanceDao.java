package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Attendance;
import util.StringUtil;

public class AttendanceDao extends BaseDao {
    public boolean addAttendance(Attendance attendance) {
        String sql = "INSERT INTO 考勤管理表 (学生学号, 是否缺勤, 缺勤原因, 是否请假, 请假原因, 考勤时间) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attendance.getStudentId());
            pstmt.setString(2, attendance.getIsAbsent());
            pstmt.setString(3, attendance.getAbsenceReason());
            pstmt.setString(4, attendance.getIsLeave());
            pstmt.setString(5, attendance.getLeaveReason());
            pstmt.setDate(6, new java.sql.Date(attendance.getAttendanceDate().getTime()));

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

    public List<Attendance> getAttendanceList(Attendance attendance) {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM 考勤管理表 WHERE 1 = 1";

        // 构建查询语句
        if (attendance.getStudentId() != 0) {
            sql += " AND 学生学号 = " + attendance.getStudentId();
        }
        // 添加其他查询条件，比如日期等

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条考勤记录的信息
                int attendanceId = rs.getInt("考勤ID");
                int studentId = rs.getInt("学生学号");
                String isAbsent = rs.getString("是否缺勤");
                String absenceReason = rs.getString("缺勤原因");
                String isLeave = rs.getString("是否请假");
                String leaveReason = rs.getString("请假原因");
                Date attendanceDate = rs.getDate("考勤时间");

                // 创建一个 Attendance 对象，并将考勤记录添加到列表中
                Attendance attendanceInfo = new Attendance(attendanceId, studentId, isAbsent, absenceReason, isLeave, leaveReason, attendanceDate);
                attendanceList.add(attendanceInfo);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }


    public boolean deleteAttendance(int attendanceId) {

        String sql = "DELETE FROM 考勤管理表 WHERE 考勤ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attendanceId);

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

    public boolean updateAttendance(Attendance attendance) {
        String sql = "UPDATE 考勤管理表 SET 是否缺勤=?, 缺勤原因=?, 是否请假=?, 请假原因=?, 考勤时间=? WHERE 考勤ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, attendance.getIsAbsent());
            pstmt.setString(2, attendance.getAbsenceReason());
            pstmt.setString(3, attendance.getIsLeave());
            pstmt.setString(4, attendance.getLeaveReason());
            pstmt.setDate(5, new java.sql.Date(attendance.getAttendanceDate().getTime()));
            pstmt.setInt(6, attendance.getAttendanceId());

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
