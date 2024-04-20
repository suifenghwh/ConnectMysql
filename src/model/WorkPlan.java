package model;

public class WorkPlan {//工作计划表
    private int planId; // 计划ID
    private String planContent; // 计划内容
    private String planTime; // 计划时间
    private int teacherId; // 教师编号

    public WorkPlan(int planId, String planContent, String planTime, int teacherId) {
        this.planId = planId;
        this.planContent = planContent;
        this.planTime = planTime;
        this.teacherId = teacherId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
