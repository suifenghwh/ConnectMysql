package model;

public class StudentBaseInfo {
    private int studentId;
    private String name;
    private int age;
    private String gender;
    private String nationality;
    private String politicalStatus;
    private String position;
    private int teacherId;
    // 构造函数
    public StudentBaseInfo(int studentId, String name, int age, String gender, String nationality, String politicalStatus, String position, int teacherId) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.politicalStatus = politicalStatus;
        this.position = position;
        this.teacherId = teacherId;
    }
    public StudentBaseInfo() {

    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPoliticalStatus() {
        return politicalStatus;
    }
    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

}
