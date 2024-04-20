package model;

public class Teachers {
    private int ID;
    private String teacherName;
    private String sex;
    private int age;
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Teachers(int ID, String teacherName, String sex, int age) {
        super();
        this.ID = ID;
        this.teacherName = teacherName;
        this.sex = sex;
        this.age = age;
    }
    public Teachers() {

    }
    @Override
    public String toString() {
        return teacherName;
    }


}