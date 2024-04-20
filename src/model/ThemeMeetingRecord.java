package model;

public class ThemeMeetingRecord {//主题班会记录表
    private int meetingId; // 班会ID
    private String meetingTheme; // 会议主题
    private String meetingTime; // 会议时间
    private int teacherId; // 教师编号

    public ThemeMeetingRecord(int meetingId, String meetingTheme, String meetingTime, int teacherId) {
        this.meetingId = meetingId;
        this.meetingTheme = meetingTheme;
        this.meetingTime = meetingTime;
        this.teacherId = teacherId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingTheme() {
        return meetingTheme;
    }

    public void setMeetingTheme(String meetingTheme) {
        this.meetingTheme = meetingTheme;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
