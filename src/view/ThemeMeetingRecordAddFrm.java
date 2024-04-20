package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.ThemeMeetingRecordDao;
import model.ThemeMeetingRecord;

public class ThemeMeetingRecordAddFrm extends JInternalFrame {

    private JTextField textFieldMeetingId;
    private JTextField textFieldMeetingTheme;
    private JTextField textFieldMeetingTime;
    private JTextField textFieldTeacherId;

    public ThemeMeetingRecordAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加主题班会记录");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("班会ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldMeetingId = new JTextField();
        textFieldMeetingId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldMeetingId);
        textFieldMeetingId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("会议主题:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldMeetingTheme = new JTextField();
        textFieldMeetingTheme.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldMeetingTheme);
        textFieldMeetingTheme.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("会议时间:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldMeetingTime = new JTextField();
        textFieldMeetingTime.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldMeetingTime);
        textFieldMeetingTime.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("教师编号:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldTeacherId = new JTextField();
        textFieldTeacherId.setBounds(116, 162, 116, 21);
        contentPane.add(textFieldTeacherId);
        textFieldTeacherId.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addThemeMeetingRecord();
            }
        });
        btnNewButton.setBounds(116, 200, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        btnNewButton_1.setBounds(263, 200, 93, 23);
        contentPane.add(btnNewButton_1);
    }

    private void addThemeMeetingRecord() {
        // 获取输入的主题班会记录信息
        int meetingId = Integer.parseInt(textFieldMeetingId.getText());
        String meetingTheme = textFieldMeetingTheme.getText();
        String meetingTime = textFieldMeetingTime.getText();
        int teacherId = Integer.parseInt(textFieldTeacherId.getText());

        // 创建主题班会记录对象
        ThemeMeetingRecord meetingRecord = new ThemeMeetingRecord(meetingId, meetingTheme, meetingTime, teacherId);

        // 调用添加主题班会记录的方法
        ThemeMeetingRecordDao meetingRecordDao = new ThemeMeetingRecordDao();
        boolean success = meetingRecordDao.addThemeMeetingRecord(meetingRecord);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加主题班会记录成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加主题班会记录失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldMeetingId.setText("");
        textFieldMeetingTheme.setText("");
        textFieldMeetingTime.setText("");
        textFieldTeacherId.setText("");
    }
}
