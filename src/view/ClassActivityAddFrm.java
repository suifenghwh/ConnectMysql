package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.ClassActivityDao;
import model.ClassActivity;

public class ClassActivityAddFrm extends JInternalFrame {

    private JTextField textFieldActivityID;
    private JTextField textFieldActivityName;
    private JTextField textFieldActivityTime;
    private JTextField textFieldLocation;
    private JTextField textFieldOrganizer;
    private JTextField textFieldTeacherID;

    public ClassActivityAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加班级活动");
        setBounds(100, 100, 450, 350);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("活动ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldActivityID = new JTextField();
        textFieldActivityID.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldActivityID);
        textFieldActivityID.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("活动名称:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldActivityName = new JTextField();
        textFieldActivityName.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldActivityName);
        textFieldActivityName.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("活动时间:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldActivityTime = new JTextField();
        textFieldActivityTime.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldActivityTime);
        textFieldActivityTime.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("活动地点:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldLocation = new JTextField();
        textFieldLocation.setBounds(116, 162, 116, 21);
        contentPane.add(textFieldLocation);
        textFieldLocation.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("主要负责人:");
        lblNewLabel_4.setBounds(34, 210, 72, 15);
        contentPane.add(lblNewLabel_4);

        textFieldOrganizer = new JTextField();
        textFieldOrganizer.setBounds(116, 207, 116, 21);
        contentPane.add(textFieldOrganizer);
        textFieldOrganizer.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("教师编号:");
        lblNewLabel_5.setBounds(34, 255, 72, 15);
        contentPane.add(lblNewLabel_5);

        textFieldTeacherID = new JTextField();
        textFieldTeacherID.setBounds(116, 252, 116, 21);
        contentPane.add(textFieldTeacherID);
        textFieldTeacherID.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassActivity();
            }
        });
        btnNewButton.setBounds(116, 290, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        btnNewButton_1.setBounds(263, 290, 93, 23);
        contentPane.add(btnNewButton_1);
    }

    private void addClassActivity() {
        // 获取输入的活动信息
        int activityID = Integer.parseInt(textFieldActivityID.getText());
        String activityName = textFieldActivityName.getText();
        String activityTimeString = textFieldActivityTime.getText();
        String location = textFieldLocation.getText();
        String organizer = textFieldOrganizer.getText();
        int teacherID = Integer.parseInt(textFieldTeacherID.getText());

        // 解析时间字符串为 Date 对象
        Date activityTime = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(activityTimeString);
            activityTime = new Date(parsedDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // 创建班级活动对象
        ClassActivity classActivity = new ClassActivity(activityID, activityName, activityTime, location, organizer, teacherID);

        // 调用添加班级活动的方法
        ClassActivityDao activityDao = new ClassActivityDao();
        boolean success = activityDao.addClassActivity(classActivity);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加班级活动成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加班级活动失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldActivityID.setText("");
        textFieldActivityName.setText("");
        textFieldActivityTime.setText("");
        textFieldLocation.setText("");
        textFieldOrganizer.setText("");
        textFieldTeacherID.setText("");
    }
}
