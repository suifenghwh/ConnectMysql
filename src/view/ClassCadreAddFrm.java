package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.ClassCadreDao;
import model.ClassCadre;

public class ClassCadreAddFrm extends JInternalFrame {

    private JTextField textFieldCadreID;
    private JTextField textFieldStudentID;
    private JTextField textFieldPosition;
    private JTextField textFieldResponsibilities;
    private JTextField textFieldStartDate;
    private JTextField textFieldEndDate;

    public ClassCadreAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("添加班干部信息");
        setBounds(100, 100, 450, 400);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("干部ID:");
        lblNewLabel.setBounds(34, 34, 72, 15);
        contentPane.add(lblNewLabel);

        textFieldCadreID = new JTextField();
        textFieldCadreID.setBounds(116, 31, 116, 21);
        contentPane.add(textFieldCadreID);
        textFieldCadreID.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("学生学号:");
        lblNewLabel_1.setBounds(34, 75, 72, 15);
        contentPane.add(lblNewLabel_1);

        textFieldStudentID = new JTextField();
        textFieldStudentID.setBounds(116, 72, 116, 21);
        contentPane.add(textFieldStudentID);
        textFieldStudentID.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("职务:");
        lblNewLabel_2.setBounds(34, 119, 72, 15);
        contentPane.add(lblNewLabel_2);

        textFieldPosition = new JTextField();
        textFieldPosition.setBounds(116, 116, 250, 21);
        contentPane.add(textFieldPosition);
        textFieldPosition.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("职责:");
        lblNewLabel_3.setBounds(34, 163, 72, 15);
        contentPane.add(lblNewLabel_3);

        textFieldResponsibilities = new JTextField();
        textFieldResponsibilities.setBounds(116, 160, 250, 21);
        contentPane.add(textFieldResponsibilities);
        textFieldResponsibilities.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("开始时间:");
        lblNewLabel_4.setBounds(34, 220, 72, 15);
        contentPane.add(lblNewLabel_4);

        textFieldStartDate = new JTextField();
        textFieldStartDate.setBounds(116, 217, 116, 21);
        contentPane.add(textFieldStartDate);
        textFieldStartDate.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("结束时间:");
        lblNewLabel_5.setBounds(34, 263, 72, 15);
        contentPane.add(lblNewLabel_5);

        textFieldEndDate = new JTextField();
        textFieldEndDate.setBounds(116, 260, 116, 21);
        contentPane.add(textFieldEndDate);
        textFieldEndDate.setColumns(10);

        JButton btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClassCadre();
            }
        });
        btnNewButton.setBounds(116, 310, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        btnNewButton_1.setBounds(263, 310, 93, 23);
        contentPane.add(btnNewButton_1);
    }

    private void addClassCadre() {
        // 获取输入的班干部信息
        int cadreID = Integer.parseInt(textFieldCadreID.getText());
        int studentID = Integer.parseInt(textFieldStudentID.getText());
        String position = textFieldPosition.getText();
        String responsibilities = textFieldResponsibilities.getText();
        String startDateString = textFieldStartDate.getText();
        String endDateString = textFieldEndDate.getText();

        // 解析时间字符串为 Date 对象
        Date startDate = null;
        Date endDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedStartDate = dateFormat.parse(startDateString);
            startDate = new Date(parsedStartDate.getTime());

            java.util.Date parsedEndDate = dateFormat.parse(endDateString);
            endDate = new Date(parsedEndDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // 创建班干部对象
        ClassCadre classCadre = new ClassCadre(cadreID, studentID, position, responsibilities, startDate, endDate);

        // 调用添加班干部信息的方法
        ClassCadreDao cadreDao = new ClassCadreDao();
        boolean success = cadreDao.addClassCadre(classCadre);

        if (success) {
            JOptionPane.showMessageDialog(this, "添加班干部信息成功");
        } else {
            JOptionPane.showMessageDialog(this, "添加班干部信息失败");
        }
    }

    private void resetFields() {
        // 重置文本框的内容
        textFieldCadreID.setText("");
        textFieldStudentID.setText("");
        textFieldPosition.setText("");
        textFieldResponsibilities.setText("");
        textFieldStartDate.setText("");
        textFieldEndDate.setText("");
    }
}
