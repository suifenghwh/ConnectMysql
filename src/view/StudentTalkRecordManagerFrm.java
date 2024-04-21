package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Dao.StudentTalkRecordDao;
import model.StudentTalkRecord;
import util.StringUtil;

public class StudentTalkRecordManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByStudentIdTextField;
    private JTable talkRecordListTable;
    private JTextField editTalkIdTextField;
    private JTextField editStudentIdTextField;
    private JTextField editTalkContentTextField;
    private JTextField editTalkTimeTextField;

    public StudentTalkRecordManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("学生谈话记录管理");
        setBounds(20, 20, 744, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("学生学号:");

        searchByStudentIdTextField = new JTextField();
        searchByStudentIdTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchTalkRecords(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("谈话ID:");

        editTalkIdTextField = new JTextField();
        editTalkIdTextField.setEditable(false);
        editTalkIdTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("学生学号:");

        editStudentIdTextField = new JTextField();
        editStudentIdTextField.setColumns(10);
        editStudentIdTextField.setEditable(false);

        JLabel lblNewLabel_3 = new JLabel("谈话内容:");

        editTalkContentTextField = new JTextField();
        editTalkContentTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("谈话时间:");

        editTalkTimeTextField = new JTextField();
        editTalkTimeTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitTalkRecord(e);
            }
        });

        JButton deleteButton = new JButton("删除谈话记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTalkRecord(e);
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
                                                .addComponent(searchByStudentIdTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
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
                                                                .addComponent(editTalkIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editStudentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editTalkContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editTalkTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(searchByStudentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(46)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(37)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editTalkIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editStudentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editTalkContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editTalkTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        talkRecordListTable = new JTable();
        talkRecordListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "谈话ID", "学生学号", "谈话内容", "谈话时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(talkRecordListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new StudentTalkRecord(0, 0, "", "")); // 或者使用默认值

        talkRecordListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = talkRecordListTable.rowAtPoint(evt.getPoint());
                editTalkIdTextField.setText(talkRecordListTable.getValueAt(row, 0).toString());
                editStudentIdTextField.setText(talkRecordListTable.getValueAt(row, 1).toString());
                editTalkContentTextField.setText(talkRecordListTable.getValueAt(row, 2).toString());
                editTalkTimeTextField.setText(talkRecordListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void submitTalkRecord(ActionEvent e) {
        int row = talkRecordListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的谈话记录");
            return;
        }

        StudentTalkRecord record = new StudentTalkRecord(0, 0, "", "");
        record.setTalkId(Integer.parseInt(editTalkIdTextField.getText()));
        record.setStudentId(Integer.parseInt(editStudentIdTextField.getText()));
        record.setTalkContent(editTalkContentTextField.getText());
        record.setTalkTime(editTalkTimeTextField.getText());

        StudentTalkRecordDao recordDao = new StudentTalkRecordDao();
        if (recordDao.updateTalkRecord(record)) {
            JOptionPane.showMessageDialog(this, "谈话记录修改成功");
            setTable(new StudentTalkRecord(0, 0, "", ""));
        } else {
            JOptionPane.showMessageDialog(this, "谈话记录修改失败");
        }
    }

    protected void deleteTalkRecord(ActionEvent e) {
        int row = talkRecordListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的谈话记录");
            return;
        }

        int talkId = Integer.parseInt(editTalkIdTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该谈话记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            StudentTalkRecordDao recordDao = new StudentTalkRecordDao();
            if (recordDao.deleteTalkRecord(talkId)) {
                JOptionPane.showMessageDialog(this, "谈话记录删除成功");
                setTable(new StudentTalkRecord(0, 0, "", ""));
            } else {
                JOptionPane.showMessageDialog(this, "谈话记录删除失败");
            }
        }
    }

    protected void searchTalkRecords(ActionEvent e) {
        String studentIdText = searchByStudentIdTextField.getText().trim();
        if (StringUtil.ifEmpty(studentIdText)) {
            JOptionPane.showMessageDialog(this, "请输入学生学号进行查询");
            return;
        }

        int studentId = Integer.parseInt(studentIdText);
        StudentTalkRecord criteria = new StudentTalkRecord(0, studentId, "", "");

        setTable(criteria);
    }

    private void setTable(StudentTalkRecord criteria) {
        DefaultTableModel model = (DefaultTableModel) talkRecordListTable.getModel();
        model.setRowCount(0);

        StudentTalkRecordDao recordDao = new StudentTalkRecordDao();
        List<StudentTalkRecord> recordList = recordDao.getTalkRecords(criteria);
        for (StudentTalkRecord record : recordList) {
            model.addRow(new Object[] {
                    record.getTalkId(),
                    record.getStudentId(),
                    record.getTalkContent(),
                    record.getTalkTime()
            });
        }
    }
}

