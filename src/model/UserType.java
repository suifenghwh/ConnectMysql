package model;

public enum UserType {
    ADMIN("用户管理员",0),
    TEACHER("班主任",1);

    private String name;
    private int index;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    private UserType(String name, int index) {
        this.name = name;
        this.index = index;
    }
    private UserType() {

    }
    public String toString() {
        return name;
    }

}