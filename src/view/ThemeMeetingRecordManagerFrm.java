package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Dao.ThemeMeetingRecordDao;
import model.ThemeMeetingRecord;
import util.StringUtil;

public class ThemeMeetingRecordManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByTeacherIdTextField;
    private JTable meetingRecordListTable;
    private JTextField editMeetingIdTextField;
    private JTextField editMeetingThemeTextField;
    private JTextField editMeetingTimeTextField;
    private JTextField editTeacherIdTextField;

    public ThemeMeetingRecordManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("主题班会记录管理");
        setBounds(20, 20, 744, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("教师编号:");

        searchByTeacherIdTextField = new JTextField();
        searchByTeacherIdTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchMeetingRecords(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("班会ID:");

        editMeetingIdTextField = new JTextField();
        editMeetingIdTextField.setEditable(false);
        editMeetingIdTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("会议主题:");

        editMeetingThemeTextField = new JTextField();
        editMeetingThemeTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("会议时间:");

        editMeetingTimeTextField = new JTextField();
        editMeetingTimeTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("教师编号:");

        editTeacherIdTextField = new JTextField();
        editTeacherIdTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitMeetingRecord(e);
            }
        });

        JButton deleteButton = new JButton("删除记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteMeetingRecord(e);
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
                                                .addComponent(searchByTeacherIdTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
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
                                                                .addComponent(editMeetingIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editMeetingThemeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editMeetingTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editTeacherIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(searchByTeacherIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(46)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(37)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editMeetingIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editMeetingThemeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editMeetingTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editTeacherIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        meetingRecordListTable = new JTable();
        meetingRecordListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "班会ID", "会议主题", "会议时间", "教师编号"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(meetingRecordListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new ThemeMeetingRecord(0, "", "", 0)); // 或者使用默认值

        meetingRecordListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = meetingRecordListTable.rowAtPoint(evt.getPoint());
                editMeetingIdTextField.setText(meetingRecordListTable.getValueAt(row, 0).toString());
                editMeetingThemeTextField.setText(meetingRecordListTable.getValueAt(row, 1).toString());
                editMeetingTimeTextField.setText(meetingRecordListTable.getValueAt(row, 2).toString());
                editTeacherIdTextField.setText(meetingRecordListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void submitMeetingRecord(ActionEvent e) {
        int row = meetingRecordListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的会议记录");
            return;
        }

        ThemeMeetingRecord record = new ThemeMeetingRecord(0, "", "", 0);
        record.setMeetingId(Integer.parseInt(editMeetingIdTextField.getText()));
        record.setMeetingTheme(editMeetingThemeTextField.getText());
        record.setMeetingTime(editMeetingTimeTextField.getText());
        record.setTeacherId(Integer.parseInt(editTeacherIdTextField.getText()));

        ThemeMeetingRecordDao recordDao = new ThemeMeetingRecordDao();
        if (recordDao.updateMeetingRecord(record)) {
            JOptionPane.showMessageDialog(this, "会议记录修改成功");
            setTable(new ThemeMeetingRecord(0, "", "", 0));
        } else {
            JOptionPane.showMessageDialog(this, "会议记录修改失败");
        }
    }

    protected void deleteMeetingRecord(ActionEvent e) {
        int row = meetingRecordListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的会议记录");
            return;
        }

        int meetingId = Integer.parseInt(editMeetingIdTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该会议记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            ThemeMeetingRecordDao recordDao = new ThemeMeetingRecordDao();
            if (recordDao.deleteMeetingRecord(meetingId)) {
                JOptionPane.showMessageDialog(this, "会议记录删除成功");
                setTable(new ThemeMeetingRecord(0, "", "", 0));
            } else {
                JOptionPane.showMessageDialog(this, "会议记录删除失败");
            }
        }
    }

    protected void searchMeetingRecords(ActionEvent e) {
        String teacherIdText = searchByTeacherIdTextField.getText().trim();
        if (StringUtil.ifEmpty(teacherIdText)) {
            JOptionPane.showMessageDialog(this, "请输入教师编号进行查询");
            return;
        }

        int teacherId = Integer.parseInt(teacherIdText);
        ThemeMeetingRecord searchCriteria = new ThemeMeetingRecord(0, "", "", teacherId);

        setTable(searchCriteria);
    }

    private void setTable(ThemeMeetingRecord criteria) {
        DefaultTableModel model = (DefaultTableModel) meetingRecordListTable.getModel();
        model.setRowCount(0);

        ThemeMeetingRecordDao recordDao = new ThemeMeetingRecordDao();
        List<ThemeMeetingRecord> recordList = recordDao.getMeetingRecords(criteria);
        for (ThemeMeetingRecord record : recordList) {
            model.addRow(new Object[] {
                    record.getMeetingId(),
                    record.getMeetingTheme(),
                    record.getMeetingTime(),
                    record.getTeacherId()
            });
        }
    }
}
