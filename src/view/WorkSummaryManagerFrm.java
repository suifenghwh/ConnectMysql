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
    private JTextField searchByContentTextField;
    private JTable workSummaryListTable;
    private JTextField editSummaryContentTextField;
    private JTextField editSummaryTimeTextField;

    public WorkSummaryManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("工作总结管理");
        setBounds(100, 100, 744, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("总结内容:");

        searchByContentTextField = new JTextField();
        searchByContentTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchWorkSummary(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_2 = new JLabel("总结内容:");

        editSummaryContentTextField = new JTextField();
        editSummaryContentTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("总结时间:");

        editSummaryTimeTextField = new JTextField();
        editSummaryTimeTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitWorkSummary(e);
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
                                                .addGap(18)
                                                .addComponent(searchByContentTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                                .addComponent(searchButton))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(132)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel_3)
                                                .addGap(18)
                                                .addComponent(editSummaryTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel_2)
                                                .addGap(18)
                                                .addComponent(editSummaryContentTextField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(195)
                                                .addComponent(submitButton)))
                                .addContainerGap(251, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(39)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(searchByContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(46)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editSummaryContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editSummaryTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton))
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

        // 添加鼠标点击事件监听器，用于将选中行的数据显示在编辑框中
        workSummaryListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = workSummaryListTable.rowAtPoint(evt.getPoint());
                editSummaryContentTextField.setText(workSummaryListTable.getValueAt(row, 1).toString());
                editSummaryTimeTextField.setText(workSummaryListTable.getValueAt(row, 2).toString());
            }
        });
    }

    protected void submitWorkSummary(ActionEvent e) {
        int row = workSummaryListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的工作总结记录");
            return;
        }

        WorkSummary workSummary = new WorkSummary(0, "", "", 0);
        workSummary.setSummaryId(Integer.parseInt(workSummaryListTable.getValueAt(row, 0).toString()));
        workSummary.setSummaryContent(editSummaryContentTextField.getText());
        workSummary.setSummaryTime(editSummaryTimeTextField.getText());

        // 更新数据库中的工作总结信息
        WorkSummaryDao workSummaryDao = new WorkSummaryDao();
        if (workSummaryDao.updateWorkSummary(workSummary)) {
            JOptionPane.showMessageDialog(this, "工作总结记录修改成功");
            setTable(new WorkSummary(0, "", "", 0)); // 更新工作总结记录列表显示
        } else {
            JOptionPane.showMessageDialog(this, "工作总结记录修改失败");
        }
    }

    protected void searchWorkSummary(ActionEvent e) {
        String content = searchByContentTextField.getText().trim();
        if (StringUtil.ifEmpty(content)) {
            JOptionPane.showMessageDialog(this, "请输入总结内容进行查询");
            return;
        }

        WorkSummary searchCriteria = new WorkSummary(0, content, "", 0);

        setTable(searchCriteria);
    }

    private void setTable(WorkSummary criteria) {
        DefaultTableModel model = (DefaultTableModel) workSummaryListTable.getModel();
        model.setRowCount(0); // 清空表格数据

        WorkSummaryDao workSummaryDao = new WorkSummaryDao();
        List<WorkSummary> workSummaryList = workSummaryDao.getWorkSummaryList(criteria);
        for (WorkSummary workSummary : workSummaryList) {
            model.addRow(new Object[] {
                    workSummary.getSummaryId(),
                    workSummary.getSummaryContent(),
                    workSummary.getSummaryTime(),
                    workSummary.getTeacherId()
            });
        }
    }
}
