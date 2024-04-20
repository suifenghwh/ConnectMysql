package model;

public class WorkSummary {//工作总结表
    private int summaryId; // 总结ID
    private String summaryContent; // 总结内容
    private String summaryTime; // 总结时间
    private int teacherId; // 教师编号

    public WorkSummary(int summaryId, String summaryContent, String summaryTime, int teacherId) {
        this.summaryId = summaryId;
        this.summaryContent = summaryContent;
        this.summaryTime = summaryTime;
        this.teacherId = teacherId;
    }

    public int getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(int summaryId) {
        this.summaryId = summaryId;
    }

    public String getSummaryContent() {
        return summaryContent;
    }

    public void setSummaryContent(String summaryContent) {
        this.summaryContent = summaryContent;
    }

    public String getSummaryTime() {
        return summaryTime;
    }

    public void setSummaryTime(String summaryTime) {
        this.summaryTime = summaryTime;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
