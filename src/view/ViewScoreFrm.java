package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import Dao.CourseDao;
import Dao.ScoreDao;
import Dao.StudentDao;
import model.ClassCourse;
import model.Score;
import model.Teachers;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewScoreFrm extends JInternalFrame {
    private JTable ScoreListtable;
    private JTextField textField;
    List<Score> viewScoreList = new ArrayList<Score>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewScoreFrm frame = new ViewScoreFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewScoreFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u5B66\u751F\u6210\u7EE9\u67E5\u770B");
        setBounds(100, 100, 602, 563);

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel = new JLabel("\u5B66\u751F\u5B66\u53F7");

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearChScore(e);
            }
        });
        textField.setColumns(10);

        JButton btnNewButton = new JButton("\u67E5\u8BE2");
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(122)
                                                .addComponent(lblNewLabel)
                                                .addGap(54)
                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(52)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(246)
                                                .addComponent(btnNewButton)))
                                .addContainerGap(63, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(50)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                                .addGap(37)
                                .addComponent(btnNewButton)
                                .addGap(45))
        );

        ScoreListtable = new JTable();
        ScoreListtable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u5B66\u53F7", "\u59D3\u540D", "\u8BED\u6587", "\u6570\u5B66", "\u82F1\u8BED", "\u5386\u53F2", "\u7269\u7406", "\u751F\u7269", "\u5316\u5B66", "\u5730\u7406"
                }
        ));
        scrollPane.setViewportView(ScoreListtable);
        getContentPane().setLayout(groupLayout);
        setScoreList(new Score());
    }
    protected void SearChScore(ActionEvent e) {
        // TODO Auto-generated method stub


    }

    private void setScoreList(Score sc) {
        DefaultTableModel dft = (DefaultTableModel) ScoreListtable.getModel();
        dft.setRowCount(0); // 清空表格
        ScoreDao scoreDao = new ScoreDao();
        viewScoreList =  scoreDao.getScoreList(sc);
        StudentDao studentDao = new StudentDao();
        for (Score score : viewScoreList) {
            Vector<Object> rowData1 = new Vector<>();
            String studentName = studentDao.getStudentNameById(score.getStudentId()); // 根据学生ID获取学生姓名
            // 添加学生姓名
            rowData1.add(score.getStudentId());
            rowData1.add(studentName);
            rowData1.add(score.getChinese());
            rowData1.add(score.getMath());
            rowData1.add(score.getEnglish());
            rowData1.add(score.getHistory());
            rowData1.add(score.getPhysics());
            rowData1.add(score.getBiology());
            rowData1.add(score.getChemistry());
            rowData1.add(score.getGeography());
            dft.addRow(rowData1);
        }

    }

}
