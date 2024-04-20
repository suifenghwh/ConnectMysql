package model;

public class User {//用户表
    private int teacherId; // 教师编号
    private String username; // 用户名
    private String password; // 密码

    public User(int teacherId, String username, String password) {
        this.teacherId = teacherId;
        this.username = username;
        this.password = password;
    }

    public User() {
        // 默认构造函数
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
