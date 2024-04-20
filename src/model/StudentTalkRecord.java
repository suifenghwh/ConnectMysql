package model;

public class StudentTalkRecord {//学生谈话记录表
    private int talkId; // 谈话ID
    private int studentId; // 学生学号
    private String talkContent; // 谈话内容
    private String talkTime; // 谈话时间

    public StudentTalkRecord(int talkId, int studentId, String talkContent, String talkTime) {
        this.talkId = talkId;
        this.studentId = studentId;
        this.talkContent = talkContent;
        this.talkTime = talkTime;
    }

    public int getTalkId() {
        return talkId;
    }

    public void setTalkId(int talkId) {
        this.talkId = talkId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }
}
