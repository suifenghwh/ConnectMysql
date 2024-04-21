package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import Dao.ClassActivityDao;
import model.ClassActivity;
import util.StringUtil;

public class ClassActivityManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTable activityListTable;
    private JTextField editActivityIDTextField;
    private JTextField editActivityNameTextField;
    private JTextField editActivityTimeTextField;
    private JTextField editLocationTextField;
    private JTextField editOrganizerTextField;
    private JTextField editTeacherIDTextField;

    public ClassActivityManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("班级活动管理");
        setBounds(20, 20, 744, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("活动ID:");

        editActivityIDTextField = new JTextField();
        editActivityIDTextField.setColumns(10);
        editActivityIDTextField.setEditable(false);

        JLabel lblNewLabel_2 = new JLabel("活动名称:");

        editActivityNameTextField = new JTextField();
        editActivityNameTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("活动时间:");

        editActivityTimeTextField = new JTextField();
        editActivityTimeTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("活动地点:");

        editLocationTextField = new JTextField();
        editLocationTextField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("主要负责人:");

        editOrganizerTextField = new JTextField();
        editOrganizerTextField.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("教师编号:");

        editTeacherIDTextField = new JTextField();
        editTeacherIDTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitActivity(e);
            }
        });

        JButton deleteButton = new JButton("删除活动记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteActivity(e);
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
                                                        .addComponent(lblNewLabel_5)
                                                        .addComponent(lblNewLabel_6))
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(editActivityIDTextField)
                                                        .addComponent(editActivityNameTextField)
                                                        .addComponent(editActivityTimeTextField)
                                                        .addComponent(editLocationTextField)
                                                        .addComponent(editOrganizerTextField)
                                                        .addComponent(editTeacherIDTextField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(submitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editActivityIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submitButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editActivityNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editActivityTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editLocationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(editOrganizerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_6)
                                        .addComponent(editTeacherIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                                .addContainerGap())
        );

        activityListTable = new JTable();
        activityListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "活动ID", "活动名称", "活动时间", "活动地点", "主要负责人", "教师编号"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(activityListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new ClassActivity(0, "", null, "", "", 0));

        activityListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = activityListTable.rowAtPoint(evt.getPoint());
                editActivityIDTextField.setText(activityListTable.getValueAt(row, 0).toString());
                editActivityNameTextField.setText(activityListTable.getValueAt(row, 1).toString());
                editActivityTimeTextField.setText(activityListTable.getValueAt(row, 2).toString());
                editLocationTextField.setText(activityListTable.getValueAt(row, 3).toString());
                editOrganizerTextField.setText(activityListTable.getValueAt(row, 4).toString());
                editTeacherIDTextField.setText(activityListTable.getValueAt(row, 5).toString());
            }
        });
    }

    protected void submitActivity(ActionEvent e) {
        int row = activityListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的活动记录");
            return;
        }

        ClassActivity activity = new ClassActivity(0, "", null, "", "", 0);
        activity.setActivityId(Integer.parseInt(editActivityIDTextField.getText()));
        activity.setActivityName(editActivityNameTextField.getText());
        activity.setActivityTime(Date.valueOf(editActivityTimeTextField.getText()));
        activity.setLocation(editLocationTextField.getText());
        activity.setOrganizer(editOrganizerTextField.getText());
        activity.setTeacherId(Integer.parseInt(editTeacherIDTextField.getText()));

        ClassActivityDao activityDao = new ClassActivityDao();
        if (activityDao.updateActivity(activity)) {
            JOptionPane.showMessageDialog(this, "活动记录修改成功");
            setTable(new ClassActivity(0, "", null, "", "", 0));
        } else {
            JOptionPane.showMessageDialog(this, "活动记录修改失败");
        }
    }

    protected void deleteActivity(ActionEvent e) {
        int row = activityListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的活动记录");
            return;
        }

        int activityId = Integer.parseInt(editActivityIDTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该活动记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            ClassActivityDao activityDao = new ClassActivityDao();
            if (activityDao.deleteActivity(activityId)) {
                JOptionPane.showMessageDialog(this, "活动记录删除成功");
                setTable(new ClassActivity(0, "", null, "", "", 0));
            } else {
                JOptionPane.showMessageDialog(this, "活动记录删除失败");
            }
        }
    }

    private void setTable(ClassActivity criteria) {
        DefaultTableModel model = (DefaultTableModel) activityListTable.getModel();
        model.setRowCount(0);

        ClassActivityDao activityDao = new ClassActivityDao();
        List<ClassActivity> activityList = activityDao.getActivityList(criteria);
        for (ClassActivity activity : activityList) {
            model.addRow(new Object[] {
                    activity.getActivityId(),
                    activity.getActivityName(),
                    activity.getActivityTime(),
                    activity.getLocation(),
                    activity.getOrganizer(),
                    activity.getTeacherId()
            });
        }
    }
}
