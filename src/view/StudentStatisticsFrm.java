package view;

import Dao.StudentDao;
import model.StudentBaseInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Enumeration;
import java.util.List;

public class StudentStatisticsFrm extends JInternalFrame {
    private final StudentDao studentDao;
    private final ButtonGroup radioButtonGroup;

    public StudentStatisticsFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("学生基本档案统计");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        studentDao = new StudentDao();

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        // 添加表格到面板
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 创建单选按钮组
        radioButtonGroup = new ButtonGroup();
        JPanel radioPanel = new JPanel(new FlowLayout());

        // 添加单选按钮到面板
        JRadioButton ageRadioButton = new JRadioButton("年龄");
        JRadioButton genderRadioButton = new JRadioButton("性别");
        JRadioButton nationalityRadioButton = new JRadioButton("民族");
        JRadioButton politicalStatusRadioButton = new JRadioButton("政治面貌");
        JRadioButton positionRadioButton = new JRadioButton("职务");

        // 添加单选按钮到按钮组和面板
        radioButtonGroup.add(ageRadioButton);
        radioButtonGroup.add(genderRadioButton);
        radioButtonGroup.add(nationalityRadioButton);
        radioButtonGroup.add(politicalStatusRadioButton);
        radioButtonGroup.add(positionRadioButton);
        radioPanel.add(ageRadioButton);
        radioPanel.add(genderRadioButton);
        radioPanel.add(nationalityRadioButton);
        radioPanel.add(politicalStatusRadioButton);
        radioPanel.add(positionRadioButton);
        panel.add(radioPanel, BorderLayout.NORTH);

        // 添加统计按钮
        JButton btnStatistics = new JButton("统计");
        btnStatistics.addActionListener(e -> {
            // 获取选择的统计方式
            String selectedOption = getSelectedRadioButtonText();

            // 获取统计数据
            List<StudentBaseInfo> studentList = studentDao.getStudentList(new StudentBaseInfo());

            // 清空表格
            tableModel.setRowCount(0);

            // 统计并添加数据到表格
            int count = 0;
            for (StudentBaseInfo student : studentList) {
                switch (selectedOption) {
                    case "年龄":
                        tableModel.addRow(new Object[]{"年龄：" + student.getAge(), ""});
                        count++;
                        break;
                    case "性别":
                        tableModel.addRow(new Object[]{"性别：" + student.getGender(), ""});
                        count++;
                        break;
                    case "民族":
                        tableModel.addRow(new Object[]{"民族：" + student.getNationality(), ""});
                        count++;
                        break;
                    case "政治面貌":
                        tableModel.addRow(new Object[]{"政治面貌：" + student.getPoliticalStatus(), ""});
                        count++;
                        break;
                    case "职务":
                        tableModel.addRow(new Object[]{"职务：" + student.getPosition(), ""});
                        count++;
                        break;
                }
            }
            tableModel.addRow(new Object[]{"总人数", count});
            tableModel.addRow(new Object[]{"", ""});
        });

        // 添加按钮到面板
        panel.add(btnStatistics, BorderLayout.SOUTH);

        // 设置窗口可见
        setVisible(true);
    }

    private String getSelectedRadioButtonText() {
        for (Enumeration<AbstractButton> buttons = radioButtonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }
}

