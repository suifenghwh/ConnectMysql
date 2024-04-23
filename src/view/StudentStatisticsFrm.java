package view;

import Dao.StudentDao;
import model.StudentBaseInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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

        // 创建饼图面板
        JPanel chartPanel = new JPanel(new BorderLayout());

        // 添加饼图面板到主面板
        panel.add(chartPanel, BorderLayout.CENTER);

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

            // 创建饼图数据集
            DefaultPieDataset dataset = new DefaultPieDataset();

            // 统计数据
            for (StudentBaseInfo student : studentList) {
                switch (selectedOption) {
                    case "年龄":
                        dataset.setValue("年龄：" + student.getAge(), 1);
                        break;
                    case "性别":
                        dataset.setValue("性别：" + student.getGender(), 1);
                        break;
                    case "民族":
                        dataset.setValue("民族：" + student.getNationality(), 1);
                        break;
                    case "政治面貌":
                        dataset.setValue("政治面貌：" + student.getPoliticalStatus(), 1);
                        break;
                    case "职务":
                        dataset.setValue("职务：" + student.getPosition(), 1);
                        break;
                }
            }

            // 创建饼图
            JFreeChart chart = ChartFactory.createPieChart(
                    selectedOption + "统计图", // 饼图标题
                    dataset, // 数据集
                    true, // 是否显示图例
                    true, // 是否生成工具提示
                    false // 是否生成URL链接
            );

            // 创建饼图面板并添加到主面板
            ChartPanel chartPanel1 = new ChartPanel(chart);
            chartPanel.removeAll();
            chartPanel.add(chartPanel1, BorderLayout.CENTER);
            chartPanel.validate();
        });

        // 添加按钮到面板
        panel.add(btnStatistics, BorderLayout.SOUTH);

        // 设置窗口可见
        setVisible(true);
    }

    private String getSelectedRadioButtonText() {
        for (Enumeration<AbstractButton> buttons = radioButtonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }
}
