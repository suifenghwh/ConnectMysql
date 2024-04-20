package model;

import java.sql.Date;

public class ClassRewardPunishment {//班级奖惩记录表
    private int recordId; // 奖惩ID
    private int studentId; // 学生学号
    private String content; // 奖惩内容
    private Date recordTime; // 奖惩时间

    public ClassRewardPunishment(int recordId, int studentId, String content, Date recordTime) {
        this.recordId = recordId;
        this.studentId = studentId;
        this.content = content;
        this.recordTime = recordTime;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}
