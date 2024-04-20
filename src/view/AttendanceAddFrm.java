package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.AttendanceDao;
import model.Attendance;

public class AttendanceAddFrm extends JInternalFrame {

    private JTextField textFieldAttendanceID;
    private JTextField textFieldStudentID;
    private JRadioButton radioButtonAbsentYes;
    private JRadioButton radioButtonAbsentNo;
    private JTextField textFieldAbsenceReason;
    private JRadioButton radioButtonLeaveYes;
    private JRadioButton radioButtonLeaveNo;
    private JTextField textFieldLeaveReason;
    private JTextField textFieldAttendanceDate;

    public AttendanceAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加考勤记录");
        setBounds(100, 100, 450, 450);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("考勤记录ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldAttendanceID = new JTextField();
        textFieldAttendanceID.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldAttendanceID);
        textFieldAttendanceID.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentID = new JTextField();
        textFieldStudentID.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentID);
        textFieldStudentID.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("是否缺勤:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        radioButtonAbsentYes = new JRadioButton("是");
        radioButtonAbsentYes.setBounds(116, 115, 50, 23);
        contentPane.add(radioButtonAbsentYes);

        radioButtonAbsentNo = new JRadioButton("否");
        radioButtonAbsentNo.setBounds(180, 115, 50, 23);
        contentPane.add(radioButtonAbsentNo);

        ButtonGroup absentGroup = new ButtonGroup();
        absentGroup.add(radioButtonAbsentYes);
        absentGroup.add(radioButtonAbsentNo);

        JLabel lblNewLabel_3 = new JLabel("缺勤原因:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldAbsenceReason = new JTextField();
        textFieldAbsenceReason.setBounds(116, 162, 250, 21);
        contentPane.add(textFieldAbsenceReason);
        textFieldAbsenceReason.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("是否请假:");
        lblNewLabel_4.setBounds(34, 220, 72, 15);
        contentPane.add(lblNewLabel_4);

        radioButtonLeaveYes = new JRadioButton("是");
        radioButtonLeaveYes.setBounds(116, 216, 50, 23);
        contentPane.add(radioButtonLeaveYes);

        radioButtonLeaveNo = new JRadioButton("否");
        radioButtonLeaveNo.setBounds(180, 216, 50, 23);
        contentPane.add(radioButtonLeaveNo);

        ButtonGroup leaveGroup = new ButtonGroup();
        leaveGroup.add(radioButtonLeaveYes);
        leaveGroup.add(radioButtonLeaveNo);

        JLabel lblNewLabel_5 = new JLabel("请假原因:");
        lblNewLabel_5.setBounds(34, 270, 72, 15);
        contentPane.add(lblNewLabel_5);

        textFieldLeaveReason = new JTextField();
        textFieldLeaveReason.setBounds(116, 267, 250, 21);
        contentPane.add(textFieldLeaveReason);
        textFieldLeaveReason.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("考勤时间:");
        lblNewLabel_6.setBounds(34, 320, 72, 15);
        contentPane.add(lblNewLabel_6);

        textFieldAttendanceDate = new JTextField();
        textFieldAttendanceDate.setBounds(116, 317, 116, 21);
        contentPane.add(textFieldAttendanceDate);
        textFieldAttendanceDate.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAttendance();
            }
        });
        btnNewButton.setBounds(116, 370, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        btnNewButton_1.setBounds(263, 370, 93, 23);
        contentPane.add(btnNewButton_1);
    }

    private void addAttendance() {
        // 获取输入的考勤信息
        int attendanceID = Integer.parseInt(textFieldAttendanceID.getText());
        int studentID = Integer.parseInt(textFieldStudentID.getText());
        String isAbsent = radioButtonAbsentYes.isSelected() ? "是" : "否";
        String absenceReason = textFieldAbsenceReason.getText();
        String isLeave = radioButtonLeaveYes.isSelected() ? "是" : "否";
        String leaveReason = textFieldLeaveReason.getText();
        String dateString = textFieldAttendanceDate.getText();

        // 解析时间字符串为 Date 对象
        Date attendanceDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateString);
            attendanceDate = new Date(parsedDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // 创建考勤对象
        Attendance attendance = new Attendance(attendanceID, studentID, isAbsent, absenceReason, isLeave, leaveReason, attendanceDate);

        // 调用添加考勤记录的方法
        AttendanceDao attendanceDao = new AttendanceDao();
        boolean success = attendanceDao.addAttendance(attendance);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加考勤记录成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加考勤记录失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldAttendanceID.setText("");
        textFieldStudentID.setText("");
        radioButtonAbsentYes.setSelected(false);
        radioButtonAbsentNo.setSelected(false);
        textFieldAbsenceReason.setText("");
        radioButtonLeaveYes.setSelected(false);
        radioButtonLeaveNo.setSelected(false);
        textFieldLeaveReason.setText("");
        textFieldAttendanceDate.setText("");
    }
}
