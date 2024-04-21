package model;

import java.sql.Date;

public class Attendance {//考勤管理表
    private int attendanceId; // 考勤ID
    private int studentId; // 学生学号
    private String isAbsent; // 是否缺勤
    private String absenceReason; // 缺勤原因
    private String isLeave; // 是否请假
    private String leaveReason; // 请假原因
    private Date attendanceDate; // 考勤时间

    public Attendance(int attendanceId, int studentId, String isAbsent, String absenceReason, String isLeave, String leaveReason, Date attendanceDate) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.isAbsent = isAbsent;
        this.absenceReason = absenceReason;
        this.isLeave = isLeave;
        this.leaveReason = leaveReason;
        this.attendanceDate = attendanceDate;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(String isAbsent) {
        this.isAbsent = isAbsent;
    }

    public String getAbsenceReason() {
        return absenceReason;
    }

    public void setAbsenceReason(String absenceReason) {
        this.absenceReason = absenceReason;
    }

    public String getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(String isLeave) {
        this.isLeave = isLeave;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}
