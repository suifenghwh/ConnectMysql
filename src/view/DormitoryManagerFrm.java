package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Dao.DormitoryDao;
import model.Dormitory;
import util.StringUtil;

public class DormitoryManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByDormitoryIdTextField;
    private JTable dormitoryListTable;
    private JTextField editDormitoryIdTextField;
    private JTextField editDormitoryNumberTextField;
    private JTextField editStudentIdTextField;
    private JTextField editBedCountTextField;

    public DormitoryManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("宿舍管理");
        setBounds(20, 20, 744, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("宿舍ID:");

        searchByDormitoryIdTextField = new JTextField();
        searchByDormitoryIdTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchDormitory(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("宿舍ID:");
        editDormitoryIdTextField = new JTextField();
        editDormitoryIdTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("宿舍号:");

        editDormitoryNumberTextField = new JTextField();
        editDormitoryNumberTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("学生学号:");

        editStudentIdTextField = new JTextField();
        editStudentIdTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("床位数:");

        editBedCountTextField = new JTextField();
        editBedCountTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitDormitory(e);
            }
        });

        JButton deleteButton = new JButton("删除宿舍");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDormitory(e);
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
                                                .addComponent(searchByDormitoryIdTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
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
                                                                .addComponent(editDormitoryIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editDormitoryNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editStudentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editBedCountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(searchByDormitoryIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(46)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(37)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editDormitoryIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editDormitoryNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editStudentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editBedCountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        dormitoryListTable = new JTable();
        dormitoryListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "宿舍ID", "宿舍号", "学生学号", "床位数"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(dormitoryListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new Dormitory(0, 0, 0, 0)); // 或者使用默认值

        dormitoryListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = dormitoryListTable.rowAtPoint(evt.getPoint());
                editDormitoryIdTextField.setText(dormitoryListTable.getValueAt(row, 0).toString());
                editDormitoryNumberTextField.setText(dormitoryListTable.getValueAt(row, 1).toString());
                editStudentIdTextField.setText(dormitoryListTable.getValueAt(row, 2).toString());
                editBedCountTextField.setText(dormitoryListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void submitDormitory(ActionEvent e) {
        int row = dormitoryListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的宿舍信息");
            return;
        }

        Dormitory dormitory = new Dormitory(0, 0, 0, 0);
        dormitory.setDormitoryId(Integer.parseInt(editDormitoryIdTextField.getText()));
        dormitory.setDormitoryNumber(Integer.parseInt(editDormitoryNumberTextField.getText()));
        dormitory.setStudentId(Integer.parseInt(editStudentIdTextField.getText()));
        dormitory.setBedCount(Integer.parseInt(editBedCountTextField.getText()));

        DormitoryDao dormitoryDao = new DormitoryDao();
        if (dormitoryDao.updateDormitory(dormitory)) {
            JOptionPane.showMessageDialog(this, "宿舍信息修改成功");
            setTable(new Dormitory(0, 0, 0, 0));
        } else {
            JOptionPane.showMessageDialog(this, "宿舍信息修改失败");
        }
    }

    protected void deleteDormitory(ActionEvent e) {
        int row = dormitoryListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的宿舍信息");
            return;
        }

        int dormitoryId = Integer.parseInt(editDormitoryIdTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该宿舍信息吗?");
        if (option == JOptionPane.OK_OPTION) {
            DormitoryDao dormitoryDao = new DormitoryDao();
            if (dormitoryDao.deleteDormitory(dormitoryId)) {
                JOptionPane.showMessageDialog(this, "宿舍信息删除成功");
                setTable(new Dormitory(0, 0, 0, 0));
            } else {
                JOptionPane.showMessageDialog(this, "宿舍信息删除失败");
            }
        }
    }

    protected void searchDormitory(ActionEvent e) {
        String dormitoryIdText = searchByDormitoryIdTextField.getText().trim();
        if (StringUtil.ifEmpty(dormitoryIdText)) {
            JOptionPane.showMessageDialog(this, "请输入宿舍ID进行查询");
            return;
        }

        int dormitoryId = Integer.parseInt(dormitoryIdText);
        Dormitory searchCriteria = new Dormitory(dormitoryId, 0, 0, 0);

        setTable(searchCriteria);
    }

    private void setTable(Dormitory criteria) {
        DefaultTableModel model = (DefaultTableModel) dormitoryListTable.getModel();
        model.setRowCount(0);

        DormitoryDao dormitoryDao = new DormitoryDao();
        List<Dormitory> dormitoryList = dormitoryDao.getDormitoryList(criteria);
        for (Dormitory dormitory : dormitoryList) {
            model.addRow(new Object[] {
                    dormitory.getDormitoryId(),
                    dormitory.getDormitoryNumber(),
                    dormitory.getStudentId(),
                    dormitory.getBedCount()
            });
        }
    }
}
