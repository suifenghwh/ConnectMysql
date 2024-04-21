package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Dao.ClassDutyMessageDao;
import model.ClassDutyMessage;
import util.StringUtil;

public class ClassDutyMessageManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByStudentIDTextField;
    private JTable dutyMessageListTable;
    private JTextField editDutyIDTextField;
    private JTextField editStudentIDTextField;
    private JTextField editDutyLocationTextField;
    private JTextField editDutyTimeTextField;

    public ClassDutyMessageManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("班级值日消息管理");
        setBounds(20, 20, 744, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("学生学号:");

        searchByStudentIDTextField = new JTextField();
        searchByStudentIDTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchDutyMessage(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("值日ID:");

        editDutyIDTextField = new JTextField();
        editDutyIDTextField.setColumns(10);
        editDutyIDTextField.setEditable(false);

        JLabel lblNewLabel_2 = new JLabel("学生学号:");

        editStudentIDTextField = new JTextField();
        editStudentIDTextField.setColumns(10);
        editStudentIDTextField.setEditable(false);

        JLabel lblNewLabel_3 = new JLabel("值日地点:");

        editDutyLocationTextField = new JTextField();
        editDutyLocationTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("值日时间:");

        editDutyTimeTextField = new JTextField();
        editDutyTimeTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitDutyMessage(e);
            }
        });

        JButton deleteButton = new JButton("删除值日消息");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDutyMessage(e);
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
                                                .addComponent(searchByStudentIDTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                                                .addComponent(searchButton))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(132)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1)
                                                                .addGap(18)
                                                                .addComponent(editDutyIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editDutyLocationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editDutyTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(195)
                                                .addComponent(submitButton)
                                                .addGap(39)
                                                .addComponent(deleteButton)))
                                .addContainerGap(251, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(39)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(searchByStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(46)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(37)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editDutyIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editDutyLocationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editDutyTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        dutyMessageListTable = new JTable();
        dutyMessageListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "值日ID", "学生学号", "值日地点", "值日时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(dutyMessageListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new ClassDutyMessage(0, 0, "", "")); // 或者使用默认值

        dutyMessageListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = dutyMessageListTable.rowAtPoint(evt.getPoint());
                editDutyIDTextField.setText(dutyMessageListTable.getValueAt(row, 0).toString());
                editStudentIDTextField.setText(dutyMessageListTable.getValueAt(row, 1).toString());
                editDutyLocationTextField.setText(dutyMessageListTable.getValueAt(row, 2).toString());
                editDutyTimeTextField.setText(dutyMessageListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void submitDutyMessage(ActionEvent e) {
        int row = dutyMessageListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的值日消息");
            return;
        }

        ClassDutyMessage dutyMessage = new ClassDutyMessage(0, 0, "", "");
        dutyMessage.setDutyId(Integer.parseInt(editDutyIDTextField.getText()));
        dutyMessage.setStudentId(Integer.parseInt(editStudentIDTextField.getText()));
        dutyMessage.setDutyLocation(editDutyLocationTextField.getText());
        dutyMessage.setDutyTime(editDutyTimeTextField.getText());

        ClassDutyMessageDao dutyMessageDao = new ClassDutyMessageDao();
        if (dutyMessageDao.updateDutyMessage(dutyMessage)) {
            JOptionPane.showMessageDialog(this, "值日消息修改成功");
            setTable(new ClassDutyMessage(0, 0, "", ""));
        } else {
            JOptionPane.showMessageDialog(this, "值日消息修改失败");
        }
    }

    protected void deleteDutyMessage(ActionEvent e) {
        int row = dutyMessageListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的值日消息");
            return;
        }

        int dutyId = Integer.parseInt(editDutyIDTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该值日消息吗?");
        if (option == JOptionPane.OK_OPTION) {
            ClassDutyMessageDao dutyMessageDao = new ClassDutyMessageDao();
            if (dutyMessageDao.deleteDutyMessage(dutyId)) {
                JOptionPane.showMessageDialog(this, "值日消息删除成功");
                setTable(new ClassDutyMessage(0, 0, "", ""));
            } else {
                JOptionPane.showMessageDialog(this, "值日消息删除失败");
            }
        }
    }

    protected void searchDutyMessage(ActionEvent e) {
        String studentIDText = searchByStudentIDTextField.getText().trim();
        if (StringUtil.ifEmpty(studentIDText)) {
            JOptionPane.showMessageDialog(this, "请输入学生学号进行查询");
            return;
        }

        int studentID = Integer.parseInt(studentIDText);
        ClassDutyMessage searchCriteria = new ClassDutyMessage(0, studentID, "", "");

        setTable(searchCriteria);
    }

    private void setTable(ClassDutyMessage criteria) {
        DefaultTableModel model = (DefaultTableModel) dutyMessageListTable.getModel();
        model.setRowCount(0);

        ClassDutyMessageDao dutyMessageDao = new ClassDutyMessageDao();
        List<ClassDutyMessage> dutyMessageList = dutyMessageDao.getDutyMessageList(criteria);
        for (ClassDutyMessage dutyMessage : dutyMessageList) {
            model.addRow(new Object[] {
                    dutyMessage.getDutyId(),
                    dutyMessage.getStudentId(),
                    dutyMessage.getDutyLocation(),
                    dutyMessage.getDutyTime()
            });
        }
    }
}
