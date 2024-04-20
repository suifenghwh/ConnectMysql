package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.UserDao;
import model.User;
import util.StringUtil;

public class UserManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchUsernameTextField;
    private JTable userListTable;
    private JTextField editTeacherIdTextField;
    private JTextField editUsernameTextField;
    private JPasswordField editPasswordField;

    public UserManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("用户管理");
        setBounds(20, 20, 744, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("用户名:");

        searchUsernameTextField = new JTextField();
        searchUsernameTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchUsers(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("教师编号:");
        JLabel lblNewLabel_2 = new JLabel("用户名:");
        JLabel lblNewLabel_3 = new JLabel("密码:");

        editTeacherIdTextField = new JTextField();
        editTeacherIdTextField.setColumns(10);
        editUsernameTextField = new JTextField();
        editUsernameTextField.setColumns(10);
        editPasswordField = new JPasswordField();

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitUser(e);
            }
        });

        JButton deleteButton = new JButton("删除用户");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteUser(e);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(104)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addGap(31)
                                                .addComponent(searchUsernameTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                                                .addComponent(searchButton))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1)
                                                                .addGap(18)
                                                                .addComponent(editTeacherIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editUsernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editPasswordField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(170)
                                .addComponent(submitButton)
                                .addGap(39)
                                .addComponent(deleteButton)
                                .addContainerGap(331, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(39)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(searchUsernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(46)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editTeacherIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editUsernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        userListTable = new JTable();
        userListTable.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "教师编号", "用户名", "密码" }
        ) {
            boolean[] columnEditables = new boolean[] { false, false, false };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(userListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new User(0, "", "")); // 或者使用默认值

        userListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = userListTable.rowAtPoint(evt.getPoint());
                editTeacherIdTextField.setText(userListTable.getValueAt(row, 0).toString());
                editUsernameTextField.setText(userListTable.getValueAt(row, 1).toString());
                editPasswordField.setText(userListTable.getValueAt(row, 2).toString());
            }
        });
    }

    protected void searchUsers(ActionEvent e) {
        String username = searchUsernameTextField.getText().trim();
        if (StringUtil.ifEmpty(username)) {
            JOptionPane.showMessageDialog(this, "请输入用户名进行查询");
            return;
        }

        User searchCriteria = new User(0, username, "");

        setTable(searchCriteria);
    }

    private void setTable(User criteria) {
        DefaultTableModel model = (DefaultTableModel) userListTable.getModel();
        model.setRowCount(0); // 清空表格数据

        UserDao userDao = new UserDao();
        java.util.List<User> userList = userDao.getAllUsers(criteria);
        for (User user : userList) {
            model.addRow(new Object[] { user.getTeacherId(), user.getUsername(), user.getPassword() });
        }
    }

    protected void submitUser(ActionEvent e) {
        int row = userListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的用户");
            return;
        }

        User user = new User();
        user.setTeacherId(Integer.parseInt(editTeacherIdTextField.getText()));
        user.setUsername(editUsernameTextField.getText());
        user.setPassword(new String(editPasswordField.getPassword()));

        UserDao userDao = new UserDao();
        if (userDao.updateUser(user)) {
            JOptionPane.showMessageDialog(this, "用户修改成功");
            setTable(new User(0, "", "")); // 更新用户列表显示
        } else {
            JOptionPane.showMessageDialog(this, "用户修改失败");
        }
    }

    protected void deleteUser(ActionEvent e) {
        int row = userListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的用户");
            return;
        }

        int teacherId = Integer.parseInt(editTeacherIdTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该用户吗?");
        if (option == JOptionPane.OK_OPTION) {
            UserDao userDao = new UserDao();
            if (userDao.deleteUser(teacherId)) {
                JOptionPane.showMessageDialog(this, "用户删除成功");
                setTable(new User(0, "", "")); // 更新用户列表显示
            } else {
                JOptionPane.showMessageDialog(this, "用户删除失败");
            }
        }
    }
}
