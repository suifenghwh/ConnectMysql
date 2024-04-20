package model;

public class Dormitory {//宿舍管理表
    private int dormitoryId; // 宿舍ID
    private int dormitoryNumber; // 宿舍号
    private int studentId; // 学生学号
    private int bedCount; // 床位数

    public Dormitory(int dormitoryId, int dormitoryNumber, int studentId, int bedCount) {
        this.dormitoryId = dormitoryId;
        this.dormitoryNumber = dormitoryNumber;
        this.studentId = studentId;
        this.bedCount = bedCount;
    }

    public int getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(int dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(int dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }
}
