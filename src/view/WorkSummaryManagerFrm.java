package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Dao.WorkSummaryDao;
import model.WorkSummary;
import util.StringUtil;

public class WorkSummaryManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByTeacherIdTextField;
    private JTable workSummaryListTable;
    private JTextField editSummaryIdTextField;
    private JTextField editSummaryContentTextField;
    private JTextField editSummaryTimeTextField;
    private JTextField editTeacherIdTextField;

    public WorkSummaryManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("工作总结管理");
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
                searchWorkSummary(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("总结ID:");

        editSummaryIdTextField = new JTextField();
        editSummaryIdTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("总结内容:");

        editSummaryContentTextField = new JTextField();
        editSummaryContentTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("总结时间:");

        editSummaryTimeTextField = new JTextField();
        editSummaryTimeTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("教师编号:");

        editTeacherIdTextField = new JTextField();
        editTeacherIdTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitWorkSummary(e);
            }
        });

        JButton deleteButton = new JButton("删除工作总结");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteWorkSummary(e);
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
                                                                .addComponent(editSummaryIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editSummaryContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editSummaryTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(editSummaryIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editSummaryContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editSummaryTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

        workSummaryListTable = new JTable();
        workSummaryListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "总结ID", "总结内容", "总结时间", "教师编号"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(workSummaryListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new WorkSummary(0, "", "", 0)); // 或者使用默认值
    }

    protected void submitWorkSummary(ActionEvent e) {
        int row = workSummaryListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的工作总结");
            return;
        }

        WorkSummary summary = new WorkSummary(0, "", "", 0);
        summary.setSummaryId(Integer.parseInt(editSummaryIdTextField.getText()));
        summary.setSummaryContent(editSummaryContentTextField.getText());
        summary.setSummaryTime(editSummaryTimeTextField.getText());
        summary.setTeacherId(Integer.parseInt(editTeacherIdTextField.getText()));

        WorkSummaryDao summaryDao = new WorkSummaryDao();
        if (summaryDao.updateWorkSummary(summary)) {
            JOptionPane.showMessageDialog(this, "工作总结修改成功");
            setTable(new WorkSummary(0, "", "", 0));
        } else {
            JOptionPane.showMessageDialog(this, "工作总结修改失败");
        }
    }

    protected void deleteWorkSummary(ActionEvent e) {
        int row = workSummaryListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的工作总结");
            return;
        }

        int summaryId = Integer.parseInt(editSummaryIdTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该工作总结吗?");
        if (option == JOptionPane.OK_OPTION) {
            WorkSummaryDao summaryDao = new WorkSummaryDao();
            if (summaryDao.deleteWorkSummary(summaryId)) {
                JOptionPane.showMessageDialog(this, "工作总结删除成功");
                setTable(new WorkSummary(0, "", "", 0));
            } else {
                JOptionPane.showMessageDialog(this, "工作总结删除失败");
            }
        }
    }

    protected void searchWorkSummary(ActionEvent e) {
        String teacherIdText = searchByTeacherIdTextField.getText().trim();
        if (StringUtil.ifEmpty(teacherIdText)) {
            JOptionPane.showMessageDialog(this, "请输入教师编号进行查询");
            return;
        }

        int teacherId = Integer.parseInt(teacherIdText);
        WorkSummary searchCriteria = new WorkSummary(0, "", "", teacherId);

        setTable(searchCriteria);
    }

    private void setTable(WorkSummary criteria) {
        DefaultTableModel model = (DefaultTableModel) workSummaryListTable.getModel();
        model.setRowCount(0);

        WorkSummaryDao summaryDao = new WorkSummaryDao();
        List<WorkSummary> summaryList = summaryDao.getWorkSummaryList(criteria);
        for (WorkSummary summary : summaryList) {
            model.addRow(new Object[] {
                    summary.getSummaryId(),
                    summary.getSummaryContent(),
                    summary.getSummaryTime(),
                    summary.getTeacherId()
            });
        }
    }
}
