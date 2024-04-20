package model;

import java.sql.Date;

public class StudentComment {//学生评语表
    private int commentId;  //评语ID
    private int studentId;  //学生学号
    private String commentContent;  //评语内容
    private Date commentDate;   //评语时间

    public StudentComment(int commentId, int studentId, String commentContent, Date commentDate) {
        this.commentId = commentId;
        this.studentId = studentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}

