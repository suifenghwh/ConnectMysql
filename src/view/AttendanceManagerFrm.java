package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Dao.AttendanceDao;
import model.Attendance;
import util.StringUtil;

public class AttendanceManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByStudentIDTextField;
    private JTable attendanceListTable;
    private JTextField editAttendanceDateTextField;
    private JTextField editAttendanceIDTextField;
    private JTextField editIsAbsentTextField;
    private JTextField editAbsenceReasonTextField;
    private JTextField editIsLeaveTextField;
    private JTextField editLeaveReasonTextField;

    public AttendanceManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("考勤记录管理");
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
                searchAttendance(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("考勤时间:");

        editAttendanceDateTextField = new JTextField();
        editAttendanceDateTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("考勤ID:");

        editAttendanceIDTextField = new JTextField();
        editAttendanceIDTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("是否缺勤:");

        editIsAbsentTextField = new JTextField();
        editIsAbsentTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("缺勤原因:");

        editAbsenceReasonTextField = new JTextField();
        editAbsenceReasonTextField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("是否请假:");

        editIsLeaveTextField = new JTextField();
        editIsLeaveTextField.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("请假原因:");

        editLeaveReasonTextField = new JTextField();
        editLeaveReasonTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitAttendance(e);
            }
        });

        JButton deleteButton = new JButton("删除考勤记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAttendance(e);
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
                                                                .addComponent(editAttendanceDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editAttendanceIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editIsAbsentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editAbsenceReasonTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_5)
                                                                .addGap(18)
                                                                .addComponent(editIsLeaveTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_6)
                                                                .addGap(18)
                                                                .addComponent(editLeaveReasonTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editAttendanceIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editAttendanceDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editIsAbsentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editAbsenceReasonTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(editIsLeaveTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_6)
                                        .addComponent(editLeaveReasonTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        attendanceListTable = new JTable();
        attendanceListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "考勤ID", "学生学号", "是否缺勤", "缺勤原因", "是否请假", "请假原因", "考勤时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(attendanceListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new Attendance(0, 0, "", "", "", "", null)); // 或者使用默认值

        attendanceListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = attendanceListTable.rowAtPoint(evt.getPoint());
                editAttendanceIDTextField.setText(attendanceListTable.getValueAt(row, 0).toString());
                editAttendanceDateTextField.setText(attendanceListTable.getValueAt(row, 6).toString());
                editIsAbsentTextField.setText(attendanceListTable.getValueAt(row, 2).toString());
                editAbsenceReasonTextField.setText(attendanceListTable.getValueAt(row, 3).toString());
                editIsLeaveTextField.setText(attendanceListTable.getValueAt(row, 4).toString());
                editLeaveReasonTextField.setText(attendanceListTable.getValueAt(row, 5).toString());
            }
        });
    }

    protected void submitAttendance(ActionEvent e) {
        int row = attendanceListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的考勤记录");
            return;
        }

        Attendance attendance = new Attendance(0, 0, "", "", "", "", null);
        attendance.setAttendanceId(Integer.parseInt(editAttendanceIDTextField.getText()));
        attendance.setIsAbsent(editIsAbsentTextField.getText());
        attendance.setAbsenceReason(editAbsenceReasonTextField.getText());
        attendance.setIsLeave(editIsLeaveTextField.getText());
        attendance.setLeaveReason(editLeaveReasonTextField.getText());

        String dateStr = editAttendanceDateTextField.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse(dateStr);

            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            attendance.setAttendanceDate(sqlDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "日期格式错误，请输入正确的日期格式（例如：yyyy-MM-dd）");
            return;
        }

        AttendanceDao attendanceDao = new AttendanceDao();
        if (attendanceDao.updateAttendance(attendance)) {
            JOptionPane.showMessageDialog(this, "考勤记录修改成功");
            setTable(new Attendance(0, 0, "", "", "", "", null));
        } else {
            JOptionPane.showMessageDialog(this, "考勤记录修改失败");
        }
    }

    protected void deleteAttendance(ActionEvent e) {
        int row = attendanceListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的考勤记录");
            return;
        }

        int attendanceId = Integer.parseInt(editAttendanceIDTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该考勤记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            AttendanceDao attendanceDao = new AttendanceDao();
            if (attendanceDao.deleteAttendance(attendanceId)) {
                JOptionPane.showMessageDialog(this, "考勤记录删除成功");
                setTable(new Attendance(0, 0, "", "", "", "", null));
            } else {
                JOptionPane.showMessageDialog(this, "考勤记录删除失败");
            }
        }
    }

    protected void searchAttendance(ActionEvent e) {
        String studentIDText = searchByStudentIDTextField.getText().trim();
        if (StringUtil.ifEmpty(studentIDText)) {
            JOptionPane.showMessageDialog(this, "请输入学生学号进行查询");
            return;
        }

        int studentID = Integer.parseInt(studentIDText);
        Attendance searchCriteria = new Attendance(0, studentID, "", "", "", "", null);

        setTable(searchCriteria);
    }

    private void setTable(Attendance criteria) {
        DefaultTableModel model = (DefaultTableModel) attendanceListTable.getModel();
        model.setRowCount(0);

        AttendanceDao attendanceDao = new AttendanceDao();
        List<Attendance> attendanceList = attendanceDao.getAttendanceList(criteria);
        for (Attendance attendance : attendanceList) {
            model.addRow(new Object[] {
                    attendance.getAttendanceId(),
                    attendance.getStudentId(),
                    attendance.getIsAbsent(),
                    attendance.getAbsenceReason(),
                    attendance.getIsLeave(),
                    attendance.getLeaveReason(),
                    attendance.getAttendanceDate()
            });
        }
    }
}
