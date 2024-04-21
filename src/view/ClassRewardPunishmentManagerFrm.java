package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import Dao.ClassRewardPunishmentDao;
import model.ClassRewardPunishment;
import util.StringUtil;

public class ClassRewardPunishmentManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTable rewardPunishmentListTable;
    private JTextField editRecordIDTextField;
    private JTextField editStudentIDTextField;
    private JTextField editContentTextField;
    private JTextField editRecordTimeTextField;
    private JTextField searchRecordIDTextField;

    public ClassRewardPunishmentManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("班级奖惩记录管理");
        setBounds(20, 20, 744, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("奖惩ID:");

        editRecordIDTextField = new JTextField();
        editRecordIDTextField.setColumns(10);
        editRecordIDTextField.setEditable(false);

        JLabel lblNewLabel_2 = new JLabel("学生学号:");

        editStudentIDTextField = new JTextField();
        editStudentIDTextField.setColumns(10);
        editStudentIDTextField.setEditable(false);

        JLabel lblNewLabel_3 = new JLabel("奖惩内容:");

        editContentTextField = new JTextField();
        editContentTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("奖惩时间:");

        editRecordTimeTextField = new JTextField();
        editRecordTimeTextField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("查询奖惩ID:");

        searchRecordIDTextField = new JTextField();
        searchRecordIDTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchRewardPunishment(e);
            }
        });

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitRewardPunishment(e);
            }
        });

        JButton deleteButton = new JButton("删除奖惩记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteRewardPunishment(e);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNewLabel_1)
                                                        .addComponent(lblNewLabel_2)
                                                        .addComponent(lblNewLabel_3)
                                                        .addComponent(lblNewLabel_4)
                                                        .addComponent(lblNewLabel_5))
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(editRecordIDTextField)
                                                        .addComponent(editStudentIDTextField)
                                                        .addComponent(editContentTextField)
                                                        .addComponent(editRecordTimeTextField)
                                                        .addComponent(searchRecordIDTextField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(submitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(searchButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editRecordIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submitButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editRecordTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(searchRecordIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                .addContainerGap())
        );

        rewardPunishmentListTable = new JTable();
        rewardPunishmentListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "奖惩ID", "学生学号", "奖惩内容", "奖惩时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(rewardPunishmentListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new ClassRewardPunishment(0, 0, "", null));

        rewardPunishmentListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = rewardPunishmentListTable.rowAtPoint(evt.getPoint());
                editRecordIDTextField.setText(rewardPunishmentListTable.getValueAt(row, 0).toString());
                editStudentIDTextField.setText(rewardPunishmentListTable.getValueAt(row, 1).toString());
                editContentTextField.setText(rewardPunishmentListTable.getValueAt(row, 2).toString());
                editRecordTimeTextField.setText(rewardPunishmentListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void searchRewardPunishment(ActionEvent e) {
        String recordIDText = searchRecordIDTextField.getText().trim();
        if (StringUtil.ifEmpty(recordIDText)) {
            JOptionPane.showMessageDialog(this, "请输入奖惩ID进行查询");
            return;
        }

        int recordID = Integer.parseInt(recordIDText);
        ClassRewardPunishment searchCriteria = new ClassRewardPunishment(recordID, 0, "", null);

        setTable(searchCriteria);
    }

    protected void submitRewardPunishment(ActionEvent e) {
        int row = rewardPunishmentListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的奖惩记录");
            return;
        }

        ClassRewardPunishment rewardPunishment = new ClassRewardPunishment(0, 0, "", null);
        rewardPunishment.setRecordId(Integer.parseInt(editRecordIDTextField.getText()));
        rewardPunishment.setStudentId(Integer.parseInt(editStudentIDTextField.getText()));
        rewardPunishment.setContent(editContentTextField.getText());
        rewardPunishment.setRecordTime(Date.valueOf(editRecordTimeTextField.getText()));

        ClassRewardPunishmentDao rewardPunishmentDao = new ClassRewardPunishmentDao();
        if (rewardPunishmentDao.updateRewardPunishment(rewardPunishment)) {
            JOptionPane.showMessageDialog(this, "奖惩记录修改成功");
            setTable(new ClassRewardPunishment(0, 0, "", null));
        } else {
            JOptionPane.showMessageDialog(this, "奖惩记录修改失败");
        }
    }

    protected void deleteRewardPunishment(ActionEvent e) {
        int row = rewardPunishmentListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的奖惩记录");
            return;
        }

        int recordId = Integer.parseInt(editRecordIDTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该奖惩记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            ClassRewardPunishmentDao rewardPunishmentDao = new ClassRewardPunishmentDao();
            if (rewardPunishmentDao.deleteRewardPunishment(recordId)) {
                JOptionPane.showMessageDialog(this, "奖惩记录删除成功");
                setTable(new ClassRewardPunishment(0, 0, "", null));
            } else {
                JOptionPane.showMessageDialog(this, "奖惩记录删除失败");
            }
        }
    }

    private void setTable(ClassRewardPunishment criteria) {
        DefaultTableModel model = (DefaultTableModel) rewardPunishmentListTable.getModel();
        model.setRowCount(0);

        ClassRewardPunishmentDao rewardPunishmentDao = new ClassRewardPunishmentDao();
        List<ClassRewardPunishment> rewardPunishmentList = rewardPunishmentDao.getRewardPunishmentList(criteria);
        for (ClassRewardPunishment rewardPunishment : rewardPunishmentList) {
            model.addRow(new Object[] {
                    rewardPunishment.getRecordId(),
                    rewardPunishment.getStudentId(),
                    rewardPunishment.getContent(),
                    rewardPunishment.getRecordTime()
            });
        }
    }
}
