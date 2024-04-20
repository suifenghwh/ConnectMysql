package model;

import java.sql.Date;

public class ClassFee {//班费管理表
    private int feeId; // 班费ID
    private int studentId; // 学生学号
    private int paymentAmount; // 缴费金额
    private Date paymentTime; // 缴费时间

    public ClassFee(int feeId, int studentId, int paymentAmount, Date paymentTime) {
        this.feeId = feeId;
        this.studentId = studentId;
        this.paymentAmount = paymentAmount;
        this.paymentTime = paymentTime;
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}
