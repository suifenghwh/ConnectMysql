package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Dao.WorkPlanDao;
import model.WorkPlan;
import util.StringUtil;

public class WorkPlanManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByTeacherIdTextField;
    private JTable workPlanListTable;
    private JTextField editPlanIdTextField;
    private JTextField editPlanContentTextField;
    private JTextField editPlanTimeTextField;
    private JTextField editTeacherIdTextField;

    public WorkPlanManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("工作计划管理");
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
                searchWorkPlans(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("计划ID:");

        editPlanIdTextField = new JTextField();
        editPlanIdTextField.setEditable(false);
        editPlanIdTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("计划内容:");

        editPlanContentTextField = new JTextField();
        editPlanContentTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("计划时间:");

        editPlanTimeTextField = new JTextField();
        editPlanTimeTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("教师编号:");

        editTeacherIdTextField = new JTextField();
        editTeacherIdTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitWorkPlan(e);
            }
        });

        JButton deleteButton = new JButton("删除计划");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteWorkPlan(e);
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
                                                                .addComponent(editPlanIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editPlanContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editPlanTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(editPlanIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editPlanContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editPlanTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

        workPlanListTable = new JTable();
        workPlanListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "计划ID", "计划内容", "计划时间", "教师编号"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(workPlanListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new WorkPlan(0, "", "", 0)); // 或者使用默认值

        workPlanListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = workPlanListTable.rowAtPoint(evt.getPoint());
                editPlanIdTextField.setText(workPlanListTable.getValueAt(row, 0).toString());
                editPlanContentTextField.setText(workPlanListTable.getValueAt(row, 1).toString());
                editPlanTimeTextField.setText(workPlanListTable.getValueAt(row, 2).toString());
                editTeacherIdTextField.setText(workPlanListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void submitWorkPlan(ActionEvent e) {
        int row = workPlanListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的工作计划");
            return;
        }

        WorkPlan workPlan = new WorkPlan(0, "", "", 0);
        workPlan.setPlanId(Integer.parseInt(editPlanIdTextField.getText()));
        workPlan.setPlanContent(editPlanContentTextField.getText());
        workPlan.setPlanTime(editPlanTimeTextField.getText());
        workPlan.setTeacherId(Integer.parseInt(editTeacherIdTextField.getText()));

        WorkPlanDao workPlanDao = new WorkPlanDao();
        if (workPlanDao.updateWorkPlan(workPlan)) {
            JOptionPane.showMessageDialog(this, "工作计划修改成功");
            setTable(new WorkPlan(0, "", "", 0));
        } else {
            JOptionPane.showMessageDialog(this, "工作计划修改失败");
        }
    }

    protected void deleteWorkPlan(ActionEvent e) {
        int row = workPlanListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的工作计划");
            return;
        }

        int planId = Integer.parseInt(editPlanIdTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该工作计划吗?");
        if (option == JOptionPane.OK_OPTION) {
            WorkPlanDao workPlanDao = new WorkPlanDao();
            if (workPlanDao.deleteWorkPlan(planId)) {
                JOptionPane.showMessageDialog(this, "工作计划删除成功");
                setTable(new WorkPlan(0, "", "", 0));
            } else {
                JOptionPane.showMessageDialog(this, "工作计划删除失败");
            }
        }
    }

    protected void searchWorkPlans(ActionEvent e) {
        String teacherIdText = searchByTeacherIdTextField.getText().trim();
        if (StringUtil.ifEmpty(teacherIdText)) {
            JOptionPane.showMessageDialog(this, "请输入教师编号进行查询");
            return;
        }

        int teacherId = Integer.parseInt(teacherIdText);
        WorkPlan searchCriteria = new WorkPlan(0, "", "", teacherId);

        setTable(searchCriteria);
    }

    private void setTable(WorkPlan criteria) {
        DefaultTableModel model = (DefaultTableModel) workPlanListTable.getModel();
        model.setRowCount(0);

        WorkPlanDao workPlanDao = new WorkPlanDao();
        List<WorkPlan> workPlanList = workPlanDao.getWorkPlanList(criteria);
        for (WorkPlan workPlan : workPlanList) {
            model.addRow(new Object[] {
                    workPlan.getPlanId(),
                    workPlan.getPlanContent(),
                    workPlan.getPlanTime(),
                    workPlan.getTeacherId()
            });
        }
    }
}
