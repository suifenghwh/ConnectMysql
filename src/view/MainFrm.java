package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import model.UserType;

public class MainFrm extends JFrame {

    private JPanel contentPane;
    public static UserType userType;
    public static Object userObject;
    private JDesktopPane desktopPane;


    private JMenuItem miAddStudent;
    private JMenuItem miaddDormitory;
    private JMenuItem miAddcourse;
    private JMenuItem miaddUser;
    private JMenuItem miUserManager;

    public MainFrm(UserType userType, Object userObject) {
        this.userType = userType;
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/班主任.png")));
        setTitle("班主任工作管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 874, 719);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnSystemSetting = new JMenu("系统设置");
        menuBar.add(mnSystemSetting);

        JMenuItem miChangePassword = new JMenuItem("修改密码");
        miChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                editPassword(ae);
            }
        });
        mnSystemSetting.add(miChangePassword);

        JMenuItem miExitSystem = new JMenuItem("退出系统");
        miExitSystem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(MainFrm.this, "确定退出系统吗") == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
        mnSystemSetting.add(miExitSystem);

        JMenu mnStudentManagement = new JMenu("学生管理");
        menuBar.add(mnStudentManagement);

        miAddStudent = new JMenuItem("添加学生基本档案");
        miAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addStudent(ae);
            }
        });
        mnStudentManagement.add(miAddStudent);

        JMenuItem miStudentList = new JMenuItem("学生基本档案管理");
        miStudentList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentList(e);
            }
        });
        mnStudentManagement.add(miStudentList);

        JMenuItem miStatistics = new JMenuItem("学生统计");
        miStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Statistics(e);
            }
        });
        mnStudentManagement.add(miStatistics);

        JMenuItem miAddComment = new JMenuItem("添加评语");
        miAddComment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addComment(e);
            }
        });
        mnStudentManagement.add(miAddComment);

        JMenuItem miCommentList = new JMenuItem("评语管理");
        miCommentList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                commentList(e);
            }
        });
        mnStudentManagement.add(miCommentList);

        JMenuItem miAddHomeVisit = new JMenuItem("添加家访记录"); // 添加家访添加页面菜单项
        miAddHomeVisit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHomeVisit(e);
            }
        });
        mnStudentManagement.add(miAddHomeVisit);

        JMenuItem miHomeVisitRecord = new JMenuItem("家访记录管理");
        miHomeVisitRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeVisitRecord(e);
            }
        });
        mnStudentManagement.add(miHomeVisitRecord);

        JMenu mnClassManagement = new JMenu("班级管理");
        menuBar.add(mnClassManagement);

        /*JMenuItem miClassList = new JMenuItem("班级列表");
        miClassList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classList(e);
            }
        });
        mnClassManagement.add(miClassList);*/

        JMenuItem miaddClassCadre = new JMenuItem("添加班干部");
        miaddClassCadre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassCadre(e);
            }
        });
        mnClassManagement.add(miaddClassCadre);

        JMenuItem miclassCadreManager = new JMenuItem("班干部管理");
        miclassCadreManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classCadreManager(e);
            }
        });
        mnClassManagement.add(miclassCadreManager);

        miaddDormitory = new JMenuItem("添加宿舍记录");
        miaddDormitory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDormitory(e);
            }
        });
        mnClassManagement.add(miaddDormitory);

        JMenuItem midormitoryManager = new JMenuItem("宿舍记录管理");
        midormitoryManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dormitoryManager(e);
            }
        });
        mnClassManagement.add(midormitoryManager);

        miAddcourse = new JMenuItem("添加课程");
        miAddcourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Addcourse(e);
            }
        });
        mnClassManagement.add(miAddcourse);

        JMenuItem miCourseList = new JMenuItem("课程管理");
        miCourseList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseList(e);
            }
        });
        mnClassManagement.add(miCourseList);

        JMenuItem miaddAttendance = new JMenuItem("添加考勤");
        miaddAttendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAttendance(e);
            }
        });
        mnClassManagement.add(miaddAttendance);

        JMenuItem miAttendanceManager = new JMenuItem("考勤管理");
        miAttendanceManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AttendanceManager(e);
            }
        });
        mnClassManagement.add(miAttendanceManager);

        JMenuItem miaddClassActivity = new JMenuItem("添加班级活动");
        miaddClassActivity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassActivity(e);
            }
        });
        mnClassManagement.add(miaddClassActivity);

        JMenuItem miclassActivityManager = new JMenuItem("班级活动管理");
        miclassActivityManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClassActivityManager(e);
            }
        });
        mnClassManagement.add(miclassActivityManager);

        JMenuItem miaddClassRewardPunishment = new JMenuItem("添加班级奖惩记录");
        miaddClassRewardPunishment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassRewardPunishment(e);
            }
        });
        mnClassManagement.add(miaddClassRewardPunishment);

        JMenuItem miclassRewardPunishmentManagerFrm = new JMenuItem("班级奖惩记录管理");
        miclassRewardPunishmentManagerFrm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classRewardPunishmentManager(e);
            }
        });
        mnClassManagement.add(miclassRewardPunishmentManagerFrm);

        //addClassFee
        JMenuItem miaddClassFee = new JMenuItem("添加班费记录");
        miaddClassFee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassFee(e);
            }
        });
        mnClassManagement.add(miaddClassFee);

        //ClassFeeManager
        JMenuItem miclassFeeManager = new JMenuItem("班费记录管理");
        miclassFeeManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClassFeeManager(e);
            }
        });
        mnClassManagement.add(miclassFeeManager);

        JMenuItem miaddClassDutyMessage = new JMenuItem("添加班级值日消息");
        miaddClassDutyMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassDutyMessage(e);
            }
        });
        mnClassManagement.add(miaddClassDutyMessage);

        JMenuItem miclassDutyMessageManager = new JMenuItem("班级值日消息管理");
        miclassDutyMessageManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClassDutyMessageManager(e);
            }
        });
        mnClassManagement.add(miclassDutyMessageManager);

        JMenu mnAchievementManagement = new JMenu("成绩管理");
        menuBar.add(mnAchievementManagement);

        JMenuItem miaddScore = new JMenuItem("成绩录入");
        miaddScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addScore(e);
            }
        });
        mnAchievementManagement.add(miaddScore);

        JMenuItem miScoreList = new JMenuItem("成绩列表");
        miScoreList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScoreList(e);
            }
        });
        mnAchievementManagement.add(miScoreList);

        JMenuItem mimanageScore = new JMenuItem("成绩管理");
        mimanageScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manageScore(e);
            }
        });
        mnAchievementManagement.add(mimanageScore);

        JMenuItem miStatsScore = new JMenuItem("成绩统计");
        miStatsScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StatsScore(e);
            }
        });
        mnAchievementManagement.add(miStatsScore);

        JMenu mnClassWorkManagement = new JMenu("班级工作管理");
        menuBar.add(mnClassWorkManagement);

        JMenuItem miaddWorkPlan = new JMenuItem("添加工作计划");
        miaddWorkPlan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addWorkPlan(e);
            }
        });
        mnClassWorkManagement.add(miaddWorkPlan);

        JMenuItem miWorkPlanManager = new JMenuItem("工作计划管理");
        miWorkPlanManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                workPlanManager(e);
            }
        });
        mnClassWorkManagement.add(miWorkPlanManager);

        JMenuItem miaddWorkSummary = new JMenuItem("添加工作总结");
        miaddWorkSummary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addWorkSummary(e);
            }
        });
        mnClassWorkManagement.add(miaddWorkSummary);

        JMenuItem miworkSummaryManager = new JMenuItem("工作总结管理");
        miworkSummaryManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                workSummaryManager(e);
            }
        });
        mnClassWorkManagement.add(miworkSummaryManager);

        JMenuItem miaddThemeMeetingRecord = new JMenuItem("添加主题班会记录");
        miaddThemeMeetingRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addThemeMeetingRecord(e);
            }
        });
        mnClassWorkManagement.add(miaddThemeMeetingRecord);

        JMenuItem miThemeMeetingRecordManager = new JMenuItem("主题班会记录管理");
        miThemeMeetingRecordManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                themeMeetingRecordManager(e);
            }
        });
        mnClassWorkManagement.add(miThemeMeetingRecordManager);

        JMenuItem miaddStudentTalkRecord = new JMenuItem("添加学生谈话记录");
        miaddStudentTalkRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentTalkRecord(e);
            }
        });
        mnClassWorkManagement.add(miaddStudentTalkRecord);

        JMenuItem miStudentTalkRecordManager = new JMenuItem("学生谈话记录管理");
        miStudentTalkRecordManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentTalkRecordManager(e);
            }
        });
        mnClassWorkManagement.add(miStudentTalkRecordManager);

        JMenu mnSystemManagement = new JMenu("系统管理");
        menuBar.add(mnSystemManagement);

        miaddUser = new JMenuItem("添加用户");
        miaddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser(e);
            }
        });
        mnSystemManagement.add(miaddUser);

        miUserManager = new JMenuItem("用户管理");
        miUserManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserManager(e);
            }
        });
        mnSystemManagement.add(miUserManager);

        JMenu mnHelp = new JMenu("帮助");
        menuBar.add(mnHelp);

        JMenuItem miAboutUs = new JMenuItem("关于我们");
        miAboutUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutUs(e);
            }
        });
        mnHelp.add(miAboutUs);

        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(0, 128, 128));
        contentPane.add(desktopPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setTeacherAuthority();
    }

    protected void StudentList(ActionEvent e) {
        StudentManagerFrm studentList = new StudentManagerFrm();
        desktopPane.add(studentList);
        studentList.setVisible(true);
    }

    protected void Statistics(ActionEvent e) {
        StudentStatisticsFrm statistics = new StudentStatisticsFrm();
        desktopPane.add(statistics);
        statistics.setVisible(true);
    }

    protected void addStudent(ActionEvent ae) {
        StudentAddFrm studentAdd = new StudentAddFrm();
        desktopPane.add(studentAdd);
        studentAdd.setVisible(true);
    }

    protected void classList(ActionEvent e) {
        ClassManageFrm classList = new ClassManageFrm();
        desktopPane.add(classList);
        classList.setVisible(true);
    }

    protected void addClassCadre(ActionEvent e) {
        ClassCadreAddFrm addclasscadre = new ClassCadreAddFrm();
        desktopPane.add(addclasscadre);
        addclasscadre.setVisible(true);
    }

    protected void classCadreManager(ActionEvent e) {
        ClassCadreManagerFrm classCadremanager = new ClassCadreManagerFrm();
        desktopPane.add(classCadremanager);
        classCadremanager.setVisible(true);
    }

    protected void manageScore(ActionEvent e) {
        // TODO Auto-generated method stub
        ManageScoreFrm scoreList = new ManageScoreFrm();
        desktopPane.add(scoreList);
        scoreList.setVisible(true);
    }

    protected void ScoreList(ActionEvent e) {
        // TODO Auto-generated method stub
        ViewScoreFrm scoreList = new ViewScoreFrm();
        desktopPane.add(scoreList);
        scoreList.setVisible(true);

    }

    protected void addScore(ActionEvent e) {
        // TODO Auto-generated method stub
        AddScoreFrm addScore = new AddScoreFrm();
        desktopPane.add(addScore);
        addScore.setVisible(true);

    }

    protected void CourseList(ActionEvent e) {
        // TODO Auto-generated method stub
        ManageCourseFrm courseList = new ManageCourseFrm();
        desktopPane.add(courseList);
        courseList.setVisible(true);
    }

    //miStatsScore

    protected void StatsScore(ActionEvent e) {
        // TODO Auto-generated method stub
        StatsScoreFrm statsScore = new StatsScoreFrm();
        desktopPane.add(statsScore);
        statsScore.setVisible(true);
    }

    protected void addTeacher(ActionEvent e) {
        // TODO Auto-generated method stub
        AddTeacherFrm teacherAdd = new AddTeacherFrm();
        desktopPane.add(teacherAdd);
        teacherAdd.setVisible(true);
    }

    protected void Addcourse(ActionEvent e) {
        // TODO Auto-generated method stub
        AddCourseFrm courseAdd = new AddCourseFrm();
        desktopPane.add(courseAdd);
        courseAdd.setVisible(true);

    }

    protected void addDormitory(ActionEvent e) {
        DormitoryAddFrm adddormitory = new DormitoryAddFrm();
        desktopPane.add(adddormitory);
        adddormitory.setVisible(true);
    }

    protected void dormitoryManager(ActionEvent e) {
        DormitoryManagerFrm dormitorymanagerFrm = new DormitoryManagerFrm();
        desktopPane.add(dormitorymanagerFrm);
        dormitorymanagerFrm.setVisible(true);
    }

    protected void commentList(ActionEvent e) {
        StudentCommentManagerFrm commentList = new StudentCommentManagerFrm();
        desktopPane.add(commentList);
        commentList.setVisible(true);
    }

    protected void addComment(ActionEvent e) {
        StudentCommentAddFrm commentAdd = new StudentCommentAddFrm();
        desktopPane.add(commentAdd);
        commentAdd.setVisible(true);
    }

    protected void homeVisitRecord(ActionEvent e) {
        HomeVisitManagerFrm homeVisitRecord = new HomeVisitManagerFrm();
        desktopPane.add(homeVisitRecord);
        homeVisitRecord.setVisible(true);
    }

    protected void addHomeVisit(ActionEvent e) {
        HomeVisitAddFrm homeVisitAddFrm = new HomeVisitAddFrm(); // 创建家访添加页面实例
        desktopPane.add(homeVisitAddFrm); // 将家访添加页面添加到桌面面板
        homeVisitAddFrm.setVisible(true); // 显示家访添加页面
    }

    protected void addAttendance(ActionEvent e) {
        AttendanceAddFrm addattendance = new AttendanceAddFrm();
        desktopPane.add(addattendance);
        addattendance.setVisible(true);
    }

    protected void AttendanceManager(ActionEvent e) {
        AttendanceManagerFrm attendancemanager = new AttendanceManagerFrm();
        desktopPane.add(attendancemanager);
        attendancemanager.setVisible(true);
    }

    protected void addClassActivity(ActionEvent e) {
        ClassActivityAddFrm addclassactivity = new ClassActivityAddFrm();
        desktopPane.add(addclassactivity);
        addclassactivity.setVisible(true);
    }

    protected void ClassActivityManager(ActionEvent e) {
        ClassActivityManagerFrm classactivitymanager = new ClassActivityManagerFrm();
        desktopPane.add(classactivitymanager);
        classactivitymanager.setVisible(true);
    }

    protected void addClassRewardPunishment(ActionEvent e) {
        ClassRewardPunishmentAddFrm addclassrewardpunishment = new ClassRewardPunishmentAddFrm();
        desktopPane.add(addclassrewardpunishment);
        addclassrewardpunishment.setVisible(true);
    }

    protected void classRewardPunishmentManager(ActionEvent e) {
        ClassRewardPunishmentManagerFrm classrewardpunishmentmanager = new ClassRewardPunishmentManagerFrm();
        desktopPane.add(classrewardpunishmentmanager);
        classrewardpunishmentmanager.setVisible(true);
    }

    protected void addClassFee(ActionEvent e) {
        ClassFeeAddFrm addclassfee = new ClassFeeAddFrm();
        desktopPane.add(addclassfee);
        addclassfee.setVisible(true);
    }

    protected void ClassFeeManager(ActionEvent e) {
        ClassFeeManagerFrm classfeemanager = new ClassFeeManagerFrm();
        desktopPane.add(classfeemanager);
        classfeemanager.setVisible(true);
    }

    protected void addClassDutyMessage(ActionEvent e) {
        ClassDutyMessageAddFrm addclassdutymessage = new ClassDutyMessageAddFrm();
        desktopPane.add(addclassdutymessage);
        addclassdutymessage.setVisible(true);
    }

    protected void ClassDutyMessageManager(ActionEvent e) {
        ClassDutyMessageManagerFrm classdutymessagemanager = new ClassDutyMessageManagerFrm();
        desktopPane.add(classdutymessagemanager);
        classdutymessagemanager.setVisible(true);
    }

    protected void addWorkPlan(ActionEvent e) {
        WorkPlanAddFrm addworkplan = new WorkPlanAddFrm();
        desktopPane.add(addworkplan);
        addworkplan.setVisible(true);
    }

    protected void workPlanManager(ActionEvent e) {
        WorkPlanManagerFrm workPlanmanager = new WorkPlanManagerFrm();
        desktopPane.add(workPlanmanager);
        workPlanmanager.setVisible(true);
    }

    protected void addWorkSummary(ActionEvent e) {
        WorkSummaryAddFrm addworksummary = new WorkSummaryAddFrm();
        desktopPane.add(addworksummary);
        addworksummary.setVisible(true);
    }

    protected void workSummaryManager(ActionEvent e) {
        WorkSummaryManagerFrm worksummarymanager = new WorkSummaryManagerFrm();
        desktopPane.add(worksummarymanager);
        worksummarymanager.setVisible(true);
    }

    protected void addThemeMeetingRecord(ActionEvent e) {
        ThemeMeetingRecordAddFrm addthememeetingrecord = new ThemeMeetingRecordAddFrm();
        desktopPane.add(addthememeetingrecord);
        addthememeetingrecord.setVisible(true);
    }

    protected void themeMeetingRecordManager(ActionEvent e) {
        ThemeMeetingRecordManagerFrm thememeetingmecordmanager = new ThemeMeetingRecordManagerFrm();
        desktopPane.add(thememeetingmecordmanager);
        thememeetingmecordmanager.setVisible(true);
    }

    protected void addStudentTalkRecord(ActionEvent e) {
        StudentTalkRecordAddFrm addstudenttalkrecord = new StudentTalkRecordAddFrm();
        desktopPane.add(addstudenttalkrecord);
        addstudenttalkrecord.setVisible(true);
    }

    protected void studentTalkRecordManager(ActionEvent e) {
        StudentTalkRecordManagerFrm studenttalkrecordmanager = new StudentTalkRecordManagerFrm();
        desktopPane.add(studenttalkrecordmanager);
        studenttalkrecordmanager.setVisible(true);
    }

    protected void addUser(ActionEvent e) {
        UserAddFrm adduser = new UserAddFrm();
        desktopPane.add(adduser);
        adduser.setVisible(true);
    }

    protected void UserManager(ActionEvent e) {
        UserManagerFrm userlist = new UserManagerFrm();
        desktopPane.add(userlist);
        userlist.setVisible(true);
    }

    protected void editPassword(ActionEvent ae) {
        EditPasswordFrm editPassword = new EditPasswordFrm(MainFrm.this);
        desktopPane.add(editPassword);
        editPassword.setVisible(true);
    }



    protected void aboutUs(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "关于我们！");
    }

    private void setTeacherAuthority() {
        System.out.println(userType.getName());
        if ("班主任".equals(userType.getName())) {
            miAddStudent.setEnabled(false);
            miaddDormitory.setEnabled(false);
            miAddcourse.setEnabled(false);
            miUserManager.setEnabled(false);
            miaddUser.setEnabled(false);
        }
    }
}
