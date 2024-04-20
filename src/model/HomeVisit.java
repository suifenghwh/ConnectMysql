package model;

import java.sql.Date;

public class HomeVisit {//家访记录表
    private int homeVisitID;//家访记录ID
    private int studentID;//学生学号
    private String address;//家访地址
    private String content;//家访内容
    private Date date;//家访时间

    public HomeVisit(int homeVisitId, int studentId, String address, String content, Date visitDate) {
        this.homeVisitID = homeVisitId;
        this.studentID = studentId;
        this.address = address;
        this.content = content;
        this.date = visitDate;
    }



    public int getHomeVisitID() {
        return homeVisitID;
    }

    public void setHomeVisitID(int homeVisitID) {
        this.homeVisitID = homeVisitID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
