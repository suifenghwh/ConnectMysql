package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.DormitoryDao;
import model.Dormitory;

public class DormitoryAddFrm extends JInternalFrame {

    private JTextField textFieldDormitoryId;
    private JTextField textFieldDormitoryNumber;
    private JTextField textFieldStudentId;
    private JTextField textFieldBedCount;

    public DormitoryAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加宿舍信息");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("宿舍ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldDormitoryId = new JTextField();
        textFieldDormitoryId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldDormitoryId);
        textFieldDormitoryId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("宿舍号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldDormitoryNumber = new JTextField();
        textFieldDormitoryNumber.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldDormitoryNumber);
        textFieldDormitoryNumber.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("学生学号:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldStudentId);
        textFieldStudentId.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("床位数:");
        lblNewLabel_3.setBounds(34, 163, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldBedCount = new JTextField();
        textFieldBedCount.setBounds(116, 160, 116, 21);
        contentPane.add(textFieldBedCount);
        textFieldBedCount.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDormitory();
            }
        });
        btnNewButton.setBounds(116, 210, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        btnNewButton_1.setBounds(263, 210, 93, 23);
        contentPane.add(btnNewButton_1);
    }

    private void addDormitory() {
        // 获取输入的宿舍信息
        int dormitoryId = Integer.parseInt(textFieldDormitoryId.getText());
        int dormitoryNumber = Integer.parseInt(textFieldDormitoryNumber.getText());
        int studentId = Integer.parseInt(textFieldStudentId.getText());
        int bedCount = Integer.parseInt(textFieldBedCount.getText());

        // 创建宿舍对象
        Dormitory dormitory = new Dormitory(dormitoryId, dormitoryNumber, studentId, bedCount);

        // 调用添加宿舍信息的方法
        DormitoryDao dormitoryDao = new DormitoryDao();

        boolean success = dormitoryDao.addDormitory(dormitory);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加宿舍信息成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加宿舍信息失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldDormitoryId.setText("");
        textFieldDormitoryNumber.setText("");
        textFieldStudentId.setText("");
        textFieldBedCount.setText("");
    }
}
