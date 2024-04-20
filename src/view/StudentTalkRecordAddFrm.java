package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.StudentTalkRecordDao;
import model.StudentTalkRecord;

public class StudentTalkRecordAddFrm extends JInternalFrame {

    private JTextField textFieldTalkId;
    private JTextField textFieldStudentId;
    private JTextField textFieldTalkContent;
    private JTextField textFieldTalkTime;

    public StudentTalkRecordAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加学生谈话记录");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("谈话ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldTalkId = new JTextField();
        textFieldTalkId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldTalkId);
        textFieldTalkId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentId);
        textFieldStudentId.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("谈话内容:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldTalkContent = new JTextField();
        textFieldTalkContent.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldTalkContent);
        textFieldTalkContent.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("谈话时间:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldTalkTime = new JTextField();
        textFieldTalkTime.setBounds(116, 162, 116, 21);
        contentPane.add(textFieldTalkTime);
        textFieldTalkTime.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentTalkRecord();
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

    private void addStudentTalkRecord() {
        // 获取输入的学生谈话记录信息
        int talkId = Integer.parseInt(textFieldTalkId.getText());
        int studentId = Integer.parseInt(textFieldStudentId.getText());
        String talkContent = textFieldTalkContent.getText();
        String talkTime = textFieldTalkTime.getText();

        // 创建学生谈话记录对象
        StudentTalkRecord talkRecord = new StudentTalkRecord(talkId, studentId, talkContent, talkTime);

        // 调用添加学生谈话记录的方法
        StudentTalkRecordDao talkRecordDao = new StudentTalkRecordDao();
        boolean success = talkRecordDao.addStudentTalkRecord(talkRecord);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加学生谈话记录成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加学生谈话记录失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldTalkId.setText("");
        textFieldStudentId.setText("");
        textFieldTalkContent.setText("");
        textFieldTalkTime.setText("");
    }
}
