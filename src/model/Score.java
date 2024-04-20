package model;

public class Score {
    private int gradeId; // 成绩ID
    private int studentId; // 学生学号
    private int chinese; // 语文成绩
    private int math; // 数学成绩
    private int english; // 英语成绩
    private int history; // 历史成绩
    private int physics; // 物理成绩
    private int biology; // 生物成绩
    private int chemistry; // 化学成绩
    private int geography; // 地理成绩

    public Score(int studentId, int chinese, int math, int english, int history, int physics, int biology, int chemistry, int geography) {
//        this.gradeId = gradeId;
        this.studentId = studentId;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.history = history;
        this.physics = physics;
        this.biology = biology;
        this.chemistry = chemistry;
        this.geography = geography;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getGeography() {
        return geography;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }
    public Score() {

    }
}
