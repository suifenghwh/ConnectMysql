package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.ClassRewardPunishmentDao;
import model.ClassRewardPunishment;

public class ClassRewardPunishmentAddFrm extends JInternalFrame {

    private JTextField textFieldRecordId;
    private JTextField textFieldStudentId;
    private JTextField textFieldContent;
    private JTextField textFieldRecordTime;

    public ClassRewardPunishmentAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加班级奖惩记录");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("奖惩ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldRecordId = new JTextField();
        textFieldRecordId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldRecordId);
        textFieldRecordId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentId);
        textFieldStudentId.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("奖惩内容:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldContent = new JTextField();
        textFieldContent.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldContent);
        textFieldContent.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("奖惩时间:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldRecordTime = new JTextField();
        textFieldRecordTime.setBounds(116, 162, 116, 21);
        contentPane.add(textFieldRecordTime);
        textFieldRecordTime.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassRewardPunishment();
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

    private void addClassRewardPunishment() {
        // 获取输入的奖惩记录信息
        int recordId = Integer.parseInt(textFieldRecordId.getText());
        int studentId = Integer.parseInt(textFieldStudentId.getText());
        String content = textFieldContent.getText();
        String recordTimeString = textFieldRecordTime.getText();

        // 解析时间字符串为 Date 对象
        Date recordTime = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(recordTimeString);
            recordTime = new Date(parsedDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // 创建奖惩记录对象
        ClassRewardPunishment rewardPunishment = new ClassRewardPunishment(recordId, studentId, content, recordTime);

        // 调用添加奖惩记录的方法
        ClassRewardPunishmentDao rewardPunishmentDao = new ClassRewardPunishmentDao();
        boolean success = rewardPunishmentDao.addClassRewardPunishment(rewardPunishment);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加班级奖惩记录成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加班级奖惩记录失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldRecordId.setText("");
        textFieldStudentId.setText("");
        textFieldContent.setText("");
        textFieldRecordTime.setText("");
    }
}
