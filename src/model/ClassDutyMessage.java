package model;

public class ClassDutyMessage {//班级值日消息表
    private int dutyId; // 值日ID
    private int studentId; // 学生学号
    private String dutyLocation; // 值日地点
    private String dutyTime; // 值日时间

    public ClassDutyMessage(int dutyId, int studentId, String dutyLocation, String dutyTime) {
        this.dutyId = dutyId;
        this.studentId = studentId;
        this.dutyLocation = dutyLocation;
        this.dutyTime = dutyTime;
    }

    public int getDutyId() {
        return dutyId;
    }

    public void setDutyId(int dutyId) {
        this.dutyId = dutyId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDutyLocation() {
        return dutyLocation;
    }

    public void setDutyLocation(String dutyLocation) {
        this.dutyLocation = dutyLocation;
    }

    public String getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(String dutyTime) {
        this.dutyTime = dutyTime;
    }
}
