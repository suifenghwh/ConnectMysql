package view;

import Dao.StudentDao;
import model.StudentBaseInfo;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
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
                        int age = student.getAge();
                        String ageKey = "年龄：" + age;
                        if (dataset.getKeys().contains(ageKey)) {
                            dataset.setValue(ageKey, dataset.getValue(ageKey).intValue() + 1);
                        } else {
                            dataset.setValue(ageKey, 1);
                        }
                        break;
                    case "性别":
                        String gender = student.getGender();
                        String genderKey = "性别：" + gender;
                        if (dataset.getKeys().contains(genderKey)) {
                            dataset.setValue(genderKey, dataset.getValue(genderKey).intValue() + 1);
                        } else {
                            dataset.setValue(genderKey, 1);
                        }
                        break;
                    case "民族":
                        String nationality = student.getNationality();
                        String nationalityKey = "民族：" + nationality;
                        if (dataset.getKeys().contains(nationalityKey)) {
                            dataset.setValue(nationalityKey, dataset.getValue(nationalityKey).intValue() + 1);
                        } else {
                            dataset.setValue(nationalityKey, 1);
                        }
                        break;
                    case "政治面貌":
                        String politicalStatus = student.getPoliticalStatus();
                        String politicalStatusKey = "政治面貌：" + politicalStatus;
                        if (dataset.getKeys().contains(politicalStatusKey)) {
                            dataset.setValue(politicalStatusKey, dataset.getValue(politicalStatusKey).intValue() + 1);
                        } else {
                            dataset.setValue(politicalStatusKey, 1);
                        }
                        break;
                    case "职务":
                        String position = student.getPosition();
                        String positionKey = "职务：" + position;
                        if (dataset.getKeys().contains(positionKey)) {
                            dataset.setValue(positionKey, dataset.getValue(positionKey).intValue() + 1);
                        } else {
                            dataset.setValue(positionKey, 1);
                        }
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

            // 获取图例对象
            LegendTitle legend = chart.getLegend();

            // 设置图例项的字体
            legend.setItemFont(new Font("新宋体", Font.PLAIN, 12)); // 设置字体

            // 设置标题字体
            chart.getTitle().setFont(new Font("新宋体", Font.BOLD, 18));

            // 获取绘图区域对象
            PiePlot plot = (PiePlot) chart.getPlot();

            // 设置标签字体
            plot.setLabelFont(new Font("新宋体", Font.PLAIN, 12));

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

