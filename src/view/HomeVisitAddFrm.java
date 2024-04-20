package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.HomeVisitDao;
import model.HomeVisit;

public class HomeVisitAddFrm extends JInternalFrame {

    private JTextField textFieldhomeVisitID;
    private JTextField textFieldStudentID;
    private JTextField textFieldAddress;
    private JTextArea textAreaContent;
    private JTextField textFieldDate;

    public HomeVisitAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加家访记录");
        setBounds(100, 100, 450, 350);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("家访ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldhomeVisitID = new JTextField();
        textFieldhomeVisitID.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldhomeVisitID);
        textFieldhomeVisitID.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentID = new JTextField();
        textFieldStudentID.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentID);
        textFieldStudentID.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("家访地址:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(116, 116, 250, 21);
        contentPane.add(textFieldAddress);
        textFieldAddress.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("家访内容:");
        lblNewLabel_3.setBounds(34, 163, 72, 15);
        contentPane.add(lblNewLabel_3);

        textAreaContent = new JTextArea();
        textAreaContent.setBounds(116, 161, 250, 50);
        contentPane.add(textAreaContent);

        JLabel lblNewLabel_4 = new JLabel("家访时间:");
        lblNewLabel_4.setBounds(34, 220, 72, 15);
        contentPane.add(lblNewLabel_4);

        textFieldDate = new JTextField();
        textFieldDate.setBounds(116, 217, 116, 21);
        contentPane.add(textFieldDate);
        textFieldDate.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHomeVisit();
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

    private void addHomeVisit() {
        // 获取输入的家访信息
        int homeVisitID = Integer.parseInt(textFieldhomeVisitID.getText());
        int studentID = Integer.parseInt(textFieldStudentID.getText());
        String address = textFieldAddress.getText();
        String content = textAreaContent.getText();
        String dateString = textFieldDate.getText();

        // 解析时间字符串为 Date 对象
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateString);
            date = new Date(parsedDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // 创建家访记录对象
        HomeVisit homeVisit = new HomeVisit(homeVisitID, studentID, address, content, date);

        // 调用添加家访记录的方法
        boolean success = HomeVisitDao.addHomeVisit(homeVisit);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加家访记录成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加家访记录失败");
        }
    }

    private void resetFields() {
        // 重置文本框和文本域的内容
        textFieldhomeVisitID.setText("");
        textFieldStudentID.setText("");
        textFieldAddress.setText("");
        textAreaContent.setText("");
        textFieldDate.setText("");
    }
}


