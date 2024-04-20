package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.WorkPlanDao;
import model.WorkPlan;

public class WorkPlanAddFrm extends JInternalFrame {

    private JTextField textFieldPlanId;
    private JTextField textFieldPlanContent;
    private JTextField textFieldPlanTime;
    private JTextField textFieldTeacherId;

    public WorkPlanAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加工作计划");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("计划ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldPlanId = new JTextField();
        textFieldPlanId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldPlanId);
        textFieldPlanId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("计划内容:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldPlanContent = new JTextField();
        textFieldPlanContent.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldPlanContent);
        textFieldPlanContent.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("计划时间:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldPlanTime = new JTextField();
        textFieldPlanTime.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldPlanTime);
        textFieldPlanTime.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("教师编号:");
        lblNewLabel_3.setBounds(34, 165, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldTeacherId = new JTextField();
        textFieldTeacherId.setBounds(116, 162, 116, 21);
        contentPane.add(textFieldTeacherId);
        textFieldTeacherId.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addWorkPlan();
            }
        });
        btnNewButton.setBounds(116, 200, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        btnNewButton_1.setBounds(263, 200, 93, 23);
        contentPane.add(btnNewButton_1);
    }

    private void addWorkPlan() {
        // 获取输入的工作计划信息
        int planId = Integer.parseInt(textFieldPlanId.getText());
        String planContent = textFieldPlanContent.getText();
        String planTime = textFieldPlanTime.getText();
        int teacherId = Integer.parseInt(textFieldTeacherId.getText());

        // 创建工作计划对象
        WorkPlan workPlan = new WorkPlan(planId, planContent, planTime, teacherId);

        // 调用添加工作计划的方法
        WorkPlanDao workPlanDao = new WorkPlanDao();
        boolean success = workPlanDao.addWorkPlan(workPlan);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加工作计划成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加工作计划失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldPlanId.setText("");
        textFieldPlanContent.setText("");
        textFieldPlanTime.setText("");
        textFieldTeacherId.setText("");
    }
}
