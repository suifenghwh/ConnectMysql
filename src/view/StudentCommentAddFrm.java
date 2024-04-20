package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.StudentCommentDao;
import model.StudentComment;

public class StudentCommentAddFrm extends JInternalFrame {

    private JTextField textFieldCommentID;
    private JTextField textFieldStudentID;
    private JTextArea textAreaCommentContent;
    private JTextField textFieldCommentDate;

    public StudentCommentAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加学生评语");
        setBounds(100, 100, 450, 350);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("评语ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldCommentID = new JTextField();
        textFieldCommentID.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldCommentID);
        textFieldCommentID.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentID = new JTextField();
        textFieldStudentID.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentID);
        textFieldStudentID.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("评语内容:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textAreaCommentContent = new JTextArea();
        textAreaCommentContent.setBounds(116, 116, 250, 50);
        contentPane.add(textAreaCommentContent);

        JLabel lblNewLabel_4 = new JLabel("评语时间:");
        lblNewLabel_4.setBounds(34, 220, 72, 15);
        contentPane.add(lblNewLabel_4);

        textFieldCommentDate = new JTextField();
        textFieldCommentDate.setBounds(116, 217, 116, 21);
        contentPane.add(textFieldCommentDate);
        textFieldCommentDate.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentComment();
            }
        });
        btnNewButton.setBounds(116, 250, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        btnNewButton_1.setBounds(263, 250, 93, 23);
        contentPane.add(btnNewButton_1);
    }

    private void addStudentComment() {
        // 获取输入的评语信息
        int commentID = Integer.parseInt(textFieldCommentID.getText());
        int studentID = Integer.parseInt(textFieldStudentID.getText());
        String commentContent = textAreaCommentContent.getText();
        String dateString = textFieldCommentDate.getText();

        // 解析时间字符串为 Date 对象
        Date commentDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateString);
            commentDate = new Date(parsedDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // 创建学生评语对象
        StudentComment studentComment = new StudentComment(commentID, studentID, commentContent, commentDate);

        // 调用添加学生评语的方法
        StudentCommentDao commentDao = new StudentCommentDao();
        boolean success = commentDao.addStudentComment(studentComment);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加学生评语成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加学生评语失败");
        }
    }

    private void resetFields() {
        // 重置文本框和文本域的内容
        textFieldCommentID.setText("");
        textFieldStudentID.setText("");
        textAreaCommentContent.setText("");
        textFieldCommentDate.setText("");
    }
}
