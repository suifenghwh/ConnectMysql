package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.ClassFeeDao;
import model.ClassFee;

public class ClassFeeAddFrm extends JInternalFrame {

    private JTextField textFieldFeeId;
    private JTextField textFieldStudentId;
    private JTextField textFieldPaymentAmount;
    private JTextField textFieldPaymentTime;

    public ClassFeeAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加班费记录");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("班费ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldFeeId = new JTextField();
        textFieldFeeId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldFeeId);
        textFieldFeeId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentId);
        textFieldStudentId.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("缴费金额:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldPaymentAmount = new JTextField();
        textFieldPaymentAmount.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldPaymentAmount);
        textFieldPaymentAmount.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("缴费时间:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldPaymentTime = new JTextField();
        textFieldPaymentTime.setBounds(116, 162, 116, 21);
        contentPane.add(textFieldPaymentTime);
        textFieldPaymentTime.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassFee();
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

    private void addClassFee() {
        // 获取输入的班费记录信息
        int feeId = Integer.parseInt(textFieldFeeId.getText());
        int studentId = Integer.parseInt(textFieldStudentId.getText());
        int paymentAmount = Integer.parseInt(textFieldPaymentAmount.getText());
        String paymentTimeString = textFieldPaymentTime.getText();

        // 解析时间字符串为 Date 对象
        Date paymentTime = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(paymentTimeString);
            paymentTime = new Date(parsedDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // 创建班费记录对象
        ClassFee classFee = new ClassFee(feeId, studentId, paymentAmount, paymentTime);

        // 调用添加班费记录的方法
        ClassFeeDao feeDao = new ClassFeeDao();
        boolean success = feeDao.addClassFee(classFee);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加班费记录成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加班费记录失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldFeeId.setText("");
        textFieldStudentId.setText("");
        textFieldPaymentAmount.setText("");
        textFieldPaymentTime.setText("");
    }
}
