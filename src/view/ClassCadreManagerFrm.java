package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Dao.ClassCadreDao;
import model.ClassCadre;
import util.StringUtil;

public class ClassCadreManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByStudentIDTextField;
    private JTable cadreListTable;
    private JTextField editCadreIDTextField;
    private JTextField editStudentIDTextField;
    private JTextField editPositionTextField;
    private JTextField editResponsibilitiesTextField;
    private JTextField editStartDateTextField;
    private JTextField editEndDateTextField;

    public ClassCadreManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("班干部记录管理");
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
                searchCadre(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("干部ID:");

        editCadreIDTextField = new JTextField();
        editCadreIDTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("学生学号:");

        editStudentIDTextField = new JTextField();
        editStudentIDTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("职务:");

        editPositionTextField = new JTextField();
        editPositionTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("职责:");

        editResponsibilitiesTextField = new JTextField();
        editResponsibilitiesTextField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("开始时间:");

        editStartDateTextField = new JTextField();
        editStartDateTextField.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("结束时间:");

        editEndDateTextField = new JTextField();
        editEndDateTextField.setColumns(10);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitCadre(e);
            }
        });

        JButton deleteButton = new JButton("删除干部记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCadre(e);
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
                                                                .addComponent(editCadreIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editPositionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editResponsibilitiesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_5)
                                                                .addGap(18)
                                                                .addComponent(editStartDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_6)
                                                                .addGap(18)
                                                                .addComponent(editEndDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(editCadreIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editStudentIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editPositionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editResponsibilitiesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(editStartDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_6)
                                        .addComponent(editEndDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        cadreListTable = new JTable();
        cadreListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "干部ID", "学生学号", "职务", "职责", "开始时间", "结束时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(cadreListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new ClassCadre(0, 0, "", "", null, null)); // 或者使用默认值

        cadreListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = cadreListTable.rowAtPoint(evt.getPoint());
                editCadreIDTextField.setText(cadreListTable.getValueAt(row, 0).toString());
                editStudentIDTextField.setText(cadreListTable.getValueAt(row, 1).toString());
                editPositionTextField.setText(cadreListTable.getValueAt(row, 2).toString());
                editResponsibilitiesTextField.setText(cadreListTable.getValueAt(row, 3).toString());
                editStartDateTextField.setText(cadreListTable.getValueAt(row, 4).toString());
                editEndDateTextField.setText(cadreListTable.getValueAt(row, 5).toString());
            }
        });
    }

    protected void submitCadre(ActionEvent e) {
        int row = cadreListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的干部记录");
            return;
        }

        ClassCadre cadre = new ClassCadre(0, 0, "", "", null, null);
        cadre.setCadreId(Integer.parseInt(editCadreIDTextField.getText()));
        cadre.setStudentId(Integer.parseInt(editStudentIDTextField.getText()));
        cadre.setPosition(editPositionTextField.getText());
        cadre.setResponsibilities(editResponsibilitiesTextField.getText());

        String startDateStr = editStartDateTextField.getText();
        String endDateStr = editEndDateTextField.getText();

        try {
            java.util.Date utilStartDate = StringUtil.stringToDate(startDateStr);
            java.util.Date utilEndDate = StringUtil.stringToDate(endDateStr);

            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

            cadre.setStartDate(sqlStartDate);
            cadre.setEndDate(sqlEndDate);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "日期格式错误，请输入正确的日期格式（例如：yyyy-MM-dd）");
            return;
        }

        ClassCadreDao cadreDao = new ClassCadreDao();
        if (cadreDao.updateClassCadre(cadre)) {
            JOptionPane.showMessageDialog(this, "干部记录修改成功");
            setTable(new ClassCadre(0, 0, "", "", null, null));
        } else {
            JOptionPane.showMessageDialog(this, "干部记录修改失败");
        }
    }

    protected void deleteCadre(ActionEvent e) {
        int row = cadreListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的干部记录");
            return;
        }

        int cadreId = Integer.parseInt(editCadreIDTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该干部记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            ClassCadreDao cadreDao = new ClassCadreDao();
            if (cadreDao.deleteClassCadre(cadreId)) {
                JOptionPane.showMessageDialog(this, "干部记录删除成功");
                setTable(new ClassCadre(0, 0, "", "", null, null));
            } else {
                JOptionPane.showMessageDialog(this, "干部记录删除失败");
            }
        }
    }

    protected void searchCadre(ActionEvent e) {
        String studentIDText = searchByStudentIDTextField.getText().trim();
        if (StringUtil.ifEmpty(studentIDText)) {
            JOptionPane.showMessageDialog(this, "请输入学生学号进行查询");
            return;
        }

        int studentID = Integer.parseInt(studentIDText);
        ClassCadre searchCriteria = new ClassCadre(0, studentID, "", "", null, null);

        setTable(searchCriteria);
    }

    private void setTable(ClassCadre criteria) {
        DefaultTableModel model = (DefaultTableModel) cadreListTable.getModel();
        model.setRowCount(0);

        ClassCadreDao cadreDao = new ClassCadreDao();
        List<ClassCadre> cadreList = cadreDao.getClassCadreList(criteria);
        for (ClassCadre cadre : cadreList) {
            model.addRow(new Object[] {
                    cadre.getCadreId(),
                    cadre.getStudentId(),
                    cadre.getPosition(),
                    cadre.getResponsibilities(),
                    cadre.getStartDate(),
                    cadre.getEndDate()
            });
        }
    }
}
