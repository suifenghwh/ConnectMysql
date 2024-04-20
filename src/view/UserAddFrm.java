package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.UserDao;
import model.User;

public class UserAddFrm extends JInternalFrame {

    private JTextField textFieldTeacherId;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;

    public UserAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加用户");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("教师编号:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldTeacherId = new JTextField();
        textFieldTeacherId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldTeacherId);
        textFieldTeacherId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("用户名:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldUsername);
        textFieldUsername.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("密码:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setBounds(116, 116, 116, 21);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser();
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

    private void addUser() {
        // 获取输入的用户信息
        int teacherId = Integer.parseInt(textFieldTeacherId.getText());
        String username = textFieldUsername.getText();
        String password = new String(passwordField.getPassword());

        // 创建用户对象
        User user = new User(teacherId, username, password);

        // 调用添加用户的方法
        UserDao userDao = new UserDao();
        boolean success = userDao.addUser(user);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加用户成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加用户失败");
        }
    }

    private void resetFields() {
        // 重置文本框和密码框的内容
        textFieldTeacherId.setText("");
        textFieldUsername.setText("");
        passwordField.setText("");
    }
}
