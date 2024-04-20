package model;

import java.sql.Date;

public class ClassCadre {//班干部管理表
    private int cadreId; // 干部ID
    private int studentId; // 学生学号
    private String position; // 职务
    private String responsibilities; // 职责
    private Date startDate; // 开始时间
    private Date endDate; // 结束时间

    public ClassCadre(int cadreId, int studentId, String position, String responsibilities, Date startDate, Date endDate) {
        this.cadreId = cadreId;
        this.studentId = studentId;
        this.position = position;
        this.responsibilities = responsibilities;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getCadreId() {
        return cadreId;
    }

    public void setCadreId(int cadreId) {
        this.cadreId = cadreId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
