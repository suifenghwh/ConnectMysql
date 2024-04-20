package model;

public class Teacher {
    private int teacherId; // 教师编号
    private String teacherName; // 用户名
    private String password; // 密码

    public Teacher(int teacherId, String teacherName, String password) {
        this.teacherId = teacherId;
        this.teacherName =teacherName;
        this.password = password;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getteacherName() {
        return teacherName;
    }

    public void setUsername(String username) {
        this.teacherName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Teacher() {

    }
}
