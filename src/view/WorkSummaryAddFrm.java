package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.WorkSummaryDao;
import model.WorkSummary;

public class WorkSummaryAddFrm extends JInternalFrame {

    private JTextField textFieldSummaryId;
    private JTextField textFieldSummaryContent;
    private JTextField textFieldSummaryTime;
    private JTextField textFieldTeacherId;

    public WorkSummaryAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加工作总结");
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("总结ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldSummaryId = new JTextField();
        textFieldSummaryId.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldSummaryId);
        textFieldSummaryId.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("总结内容:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldSummaryContent = new JTextField();
        textFieldSummaryContent.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldSummaryContent);
        textFieldSummaryContent.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("总结时间:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldSummaryTime = new JTextField();
        textFieldSummaryTime.setBounds(116, 116, 116, 21);
        contentPane.add(textFieldSummaryTime);
        textFieldSummaryTime.setColumns(10);

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
                addWorkSummary();
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

    private void addWorkSummary() {
        // 获取输入的工作总结信息
        int summaryId = Integer.parseInt(textFieldSummaryId.getText());
        String summaryContent = textFieldSummaryContent.getText();
        String summaryTime = textFieldSummaryTime.getText();
        int teacherId = Integer.parseInt(textFieldTeacherId.getText());

        // 创建工作总结对象
        WorkSummary workSummary = new WorkSummary(summaryId, summaryContent, summaryTime, teacherId);

        // 调用添加工作总结的方法
        WorkSummaryDao workSummaryDao = new WorkSummaryDao();
        boolean success = workSummaryDao.addWorkSummary(workSummary);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加工作总结成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加工作总结失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldSummaryId.setText("");
        textFieldSummaryContent.setText("");
        textFieldSummaryTime.setText("");
        textFieldTeacherId.setText("");
    }
}
