package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//	班级活动表
public class ClassActivity {
    private int activityId; // 活动ID
    private String activityName; // 活动名称
    private Date activityTime; // 活动时间
    private String location; // 活动地点
    private String organizer; // 主要负责人
    private int teacherId; // 教师编号

    public ClassActivity(int activityId, String activityName, java.sql.Date activityTime, String location, String organizer, int teacherId) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityTime = activityTime;
        this.location = location;
        this.organizer = organizer;
        this.teacherId = teacherId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    // 在 model.ClassActivity 类中添加一个方法来接受 String 类型的日期，并在内部将其转换为 java.sql.Date 类型
    public void setActivityTimeString(String activityTime) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse(activityTime);
            this.activityTime = new java.sql.Date(utilDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
            // 处理日期格式错误的情况，您可以根据需求进行处理
        }
    }

}
