package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Dao.HomeVisitDao;
import model.HomeVisit;
import util.StringUtil;

public class HomeVisitManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField searchByStudentIDTextField;
    private JTable homeVisitListTable;
    private JTextField editAddressTextField;
    private JTextField editContentTextField;
    private JTextField editDateTextField;
    private JTextField editHomeVisitIDTextField;

    public HomeVisitManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("家访记录管理");
        setBounds(20, 20, 744, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("学生学号:");

        searchByStudentIDTextField = new JTextField();
        searchByStudentIDTextField.setColumns(10);

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchHomeVisit(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("家访地址:");

        editAddressTextField = new JTextField();
        editAddressTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("家访内容:");

        editContentTextField = new JTextField();
        editContentTextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("家访时间:");

        editDateTextField = new JTextField();
        editDateTextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("家访ID:");

        editHomeVisitIDTextField = new JTextField();
        editHomeVisitIDTextField.setColumns(10);
        editHomeVisitIDTextField.setEditable(false);

        JButton submitButton = new JButton("确认修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitHomeVisit(e);
            }
        });

        JButton deleteButton = new JButton("删除家访记录");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteHomeVisit(e);
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
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editContentTextField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addGap(18)
                                                                .addComponent(editHomeVisitIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1)
                                                                .addGap(18)
                                                                .addComponent(editAddressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editHomeVisitIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editAddressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editContentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        homeVisitListTable = new JTable();
        homeVisitListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "家访ID", "学生学号", "家访地址", "家访内容", "家访时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(homeVisitListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new HomeVisit(0, 0, "", "", null)); // 或者使用默认值

        // 添加鼠标点击事件监听器，用于将选中行的数据显示在编辑框中
        homeVisitListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = homeVisitListTable.rowAtPoint(evt.getPoint());
                editHomeVisitIDTextField.setText(homeVisitListTable.getValueAt(row, 0).toString());
                editAddressTextField.setText(homeVisitListTable.getValueAt(row, 2).toString());
                editContentTextField.setText(homeVisitListTable.getValueAt(row, 3).toString());
                editDateTextField.setText(homeVisitListTable.getValueAt(row, 4).toString());
            }
        });
    }

    protected void submitHomeVisit(ActionEvent e) {
        int row = homeVisitListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的家访记录");
            return;
        }

        HomeVisit homeVisit = new HomeVisit(0, 0, "", "", null);
        homeVisit.setHomeVisitID(Integer.parseInt(editHomeVisitIDTextField.getText()));
        homeVisit.setStudentID(Integer.parseInt(homeVisitListTable.getValueAt(row, 1).toString()));
        homeVisit.setAddress(editAddressTextField.getText());
        homeVisit.setContent(editContentTextField.getText());

        // 获取家访时间字符串
        String dateStr = editDateTextField.getText();

        try {
            // 尝试将家访时间字符串解析为 Date 对象
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date utilDate = dateFormat.parse(dateStr);

            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            // 设置家访日期
            homeVisit.setDate(sqlDate);
        } catch (ParseException ex) {
            // 如果日期字符串无法解析，则在这里处理异常
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "日期格式错误，请输入正确的日期格式（例如：yyyy-MM-dd）");
            return;
        }

        // 更新数据库中的家访信息
        HomeVisitDao homeVisitDao = new HomeVisitDao();
        if (homeVisitDao.updateHomeVisit(homeVisit)) {
            JOptionPane.showMessageDialog(this, "家访记录修改成功");
            setTable(new HomeVisit(0, 0, "", "", null)); // 更新家访记录列表显示
        } else {
            JOptionPane.showMessageDialog(this, "家访记录修改失败");
        }
    }

    protected void deleteHomeVisit(ActionEvent e) {
        int row = homeVisitListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的家访记录");
            return;
        }

        int homeVisitID = Integer.parseInt(editHomeVisitIDTextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该家访记录吗?");
        if (option == JOptionPane.OK_OPTION) {
            HomeVisitDao homeVisitDao = new HomeVisitDao();
            if (homeVisitDao.deleteHomeVisit(homeVisitID)) {
                JOptionPane.showMessageDialog(this, "家访记录删除成功");
                setTable(new HomeVisit(0, 0, "", "", null)); // 更新家访记录列表显示
            } else {
                JOptionPane.showMessageDialog(this, "家访记录删除失败");
            }
        }
    }

    protected void searchHomeVisit(ActionEvent e) {
        String studentIDText = searchByStudentIDTextField.getText().trim();
        if (StringUtil.ifEmpty(studentIDText)) {
            JOptionPane.showMessageDialog(this, "请输入学生学号进行查询");
            return;
        }

        int studentID = Integer.parseInt(studentIDText);
        HomeVisit searchCriteria = new HomeVisit(0, 0, "", "", null);
        searchCriteria.setStudentID(studentID);

        setTable(searchCriteria);
    }

    private void setTable(HomeVisit criteria) {
        DefaultTableModel model = (DefaultTableModel) homeVisitListTable.getModel();
        model.setRowCount(0); // 清空表格数据

        HomeVisitDao homeVisitDao = new HomeVisitDao();
        List<HomeVisit> homeVisitList = homeVisitDao.getHomeVisitList(criteria);
        for (HomeVisit homeVisit : homeVisitList) {
            model.addRow(new Object[] {
                    homeVisit.getHomeVisitID(),
                    homeVisit.getStudentID(),
                    homeVisit.getAddress(),
                    homeVisit.getContent(),
                    homeVisit.getDate()
            });
        }
    }
}
