package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.ClassDutyMessageDao;
import model.ClassDutyMessage;

public class ClassDutyMessageAddFrm extends JInternalFrame {

    private JTextField textFieldDutyId;
    private JTextField textFieldStudentId;
    private JTextField textFieldDutyLocation;
    private JTextField textFieldDutyTime;

    public ClassDutyMessageAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加班级值日消息");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("值日ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldDutyId = new JTextField();
        textFieldDutyId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldDutyId);
        textFieldDutyId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentId);
        textFieldStudentId.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("值日地点:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldDutyLocation = new JTextField();
        textFieldDutyLocation.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldDutyLocation);
        textFieldDutyLocation.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("值日时间:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldDutyTime = new JTextField();
        textFieldDutyTime.setBounds(116, 162, 116, 21);
        contentPane.add(textFieldDutyTime);
        textFieldDutyTime.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassDutyMessage();
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

    private void addClassDutyMessage() {
        // 获取输入的值日消息信息
        int dutyId = Integer.parseInt(textFieldDutyId.getText());
        int studentId = Integer.parseInt(textFieldStudentId.getText());
        String dutyLocation = textFieldDutyLocation.getText();
        String dutyTime = textFieldDutyTime.getText();

        // 创建班级值日消息对象
        ClassDutyMessage classDutyMessage = new ClassDutyMessage(dutyId, studentId, dutyLocation, dutyTime);

        // 调用添加班级值日消息的方法
        ClassDutyMessageDao dutyMessageDao = new ClassDutyMessageDao();
        boolean success = dutyMessageDao.addDutyMessage(classDutyMessage);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加班级值日消息成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加班级值日消息失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldDutyId.setText("");
        textFieldStudentId.setText("");
        textFieldDutyLocation.setText("");
        textFieldDutyTime.setText("");
    }
}
