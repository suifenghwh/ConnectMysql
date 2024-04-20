package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Dao.ClassFeeDao;
import model.ClassFee;
import util.StringUtil;

public class ClassFeeManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByStudentIDTextField;
    private JTable feeListTable;
    private JTextField editFeeIDTextField;
    private JTextField editStudentIDTextField;
    private JTextField editPaymentAmountTextField;
    private JTextField editPaymentTimeTextField;

    public ClassFeeManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("班费管理");
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
                searchFee(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("班费ID:");

        editFeeIDTextField = new JTextField();
        editFeeIDTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("学生学号:");

        editStudentIDTextField = new JTextField();
        editStudentIDTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("缴费金额:");

        editPaymentAmountTextField = new JTextField();
        editPaymentAmountTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("缴费时间:");

        editPaymentTimeTextField = new JTextField();
        editPaymentTimeTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitFee(e);
            }
        });

        JButton deleteButton = new JButton("删除班费记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFee(e);
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
                                                                .addComponent(editFeeIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editPaymentAmountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editPaymentTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(editFeeIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editPaymentAmountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editPaymentTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        feeListTable = new JTable();
        feeListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "班费ID", "学生学号", "缴费金额", "缴费时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(feeListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new ClassFee(0, 0, 0, null)); // 或者使用默认值

        feeListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = feeListTable.rowAtPoint(evt.getPoint());
                editFeeIDTextField.setText(feeListTable.getValueAt(row, 0).toString());
                editStudentIDTextField.setText(feeListTable.getValueAt(row, 1).toString());
                editPaymentAmountTextField.setText(feeListTable.getValueAt(row, 2).toString());
                editPaymentTimeTextField.setText(feeListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void submitFee(ActionEvent e) {
        int row = feeListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的班费记录");
            return;
        }

        ClassFee fee = new ClassFee(0, 0, 0, null);
        fee.setFeeId(Integer.parseInt(editFeeIDTextField.getText()));
        fee.setStudentId(Integer.parseInt(editStudentIDTextField.getText()));
        fee.setPaymentAmount(Integer.parseInt(editPaymentAmountTextField.getText()));

        String dateStr = editPaymentTimeTextField.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse(dateStr);

            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            fee.setPaymentTime(sqlDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "日期格式错误，请输入正确的日期格式（例如：yyyy-MM-dd）");
            return;
        }

        ClassFeeDao feeDao = new ClassFeeDao();
        if (feeDao.updateFee(fee)) {
            JOptionPane.showMessageDialog(this, "班费记录修改成功");
            setTable(new ClassFee(0, 0, 0, null));
        } else {
            JOptionPane.showMessageDialog(this, "班费记录修改失败");
        }
    }

    protected void deleteFee(ActionEvent e) {
        int row = feeListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的班费记录");
            return;
        }

        int feeId = Integer.parseInt(editFeeIDTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该班费记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            ClassFeeDao feeDao = new ClassFeeDao();
            if (feeDao.deleteFee(feeId)) {
                JOptionPane.showMessageDialog(this, "班费记录删除成功");
                setTable(new ClassFee(0, 0, 0, null));
            } else {
                JOptionPane.showMessageDialog(this, "班费记录删除失败");
            }
        }
    }

    protected void searchFee(ActionEvent e) {
        String studentIDText = searchByStudentIDTextField.getText().trim();
        if (StringUtil.ifEmpty(studentIDText)) {
            JOptionPane.showMessageDialog(this, "请输入学生学号进行查询");
            return;
        }

        int studentID = Integer.parseInt(studentIDText);
        ClassFee searchCriteria = new ClassFee(0, studentID, 0, null);

        setTable(searchCriteria);
    }

    private void setTable(ClassFee criteria) {
        DefaultTableModel model = (DefaultTableModel) feeListTable.getModel();
        model.setRowCount(0);

        ClassFeeDao feeDao = new ClassFeeDao();
        List<ClassFee> feeList = feeDao.getFeeList(criteria);
        for (ClassFee fee : feeList) {
            model.addRow(new Object[] {
                    fee.getFeeId(),
                    fee.getStudentId(),
                    fee.getPaymentAmount(),
                    fee.getPaymentTime()
            });
        }
    }
}
