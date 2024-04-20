package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Dao.ScoreDao;
import Dao.StudentDao;
import model.Score;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageScoreFrm extends JInternalFrame {
    private JTextField StudentIDtextField;
    private JTable ScoreListtable;
    private JTextField textField_1;
    List<Score> viewScoreList = new ArrayList<Score>();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageScoreFrm frame = new ManageScoreFrm();
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
    public ManageScoreFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u6210\u7EE9\u7BA1\u7406\u754C\u9762");
        setBounds(100, 100, 835, 589);

        JLabel lblNewLabel = new JLabel("\u5B66\u751F\u5B66\u53F7");

        StudentIDtextField = new JTextField();
        StudentIDtextField.setColumns(10);

        JButton SearchButton = new JButton("\u67E5\u8BE2");
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchScoreValue(e);

            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u6210\u7EE9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(80)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(73)
                                                .addComponent(lblNewLabel)
                                                .addGap(40)
                                                .addComponent(StudentIDtextField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addGap(189)
                                                .addComponent(SearchButton)))
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(39)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(StudentIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(SearchButton))
                                .addGap(41)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(58, Short.MAX_VALUE))
        );

        JLabel lblNewLabel_1 = new JLabel("\u6210\u7EE9");

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        JButton deleteButton = new JButton("\u786E\u8BA4\u5220\u9664");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteScore(e);
            }
        });

        JButton EditSubmitButton = new JButton("\u63D0\u4EA4\u4FEE\u6539");
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(33)
                                .addComponent(lblNewLabel_1)
                                .addGap(37)
                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(143)
                                .addComponent(EditSubmitButton)
                                .addGap(39)
                                .addComponent(deleteButton)
                                .addContainerGap(139, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(31)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton)
                                        .addComponent(EditSubmitButton))
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

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
        setScoreList( new Score() );

    }
    protected void searchScoreValue(ActionEvent e) {
        // TODO Auto-generated method stub
        String studentID = StudentIDtextField.getText().trim();
        if (studentID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入学生学号");
            return;
        }

        // 创建一个 Score 对象，设置学生学号
        Score searchScore = new Score();
        try {
            searchScore.setStudentId(Integer.parseInt(studentID));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入有效的学生学号");
            return;
        }

        // 调用 setScoreList 方法，根据输入的学号刷新成绩信息列表
        setScoreList(searchScore);

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
    protected void deleteScore(ActionEvent e) {
        int row = ScoreListtable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的数据");
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "确定删除该成绩吗?");
        if (option == JOptionPane.OK_OPTION) {
            ScoreDao scoreDao = new ScoreDao();
            if (scoreDao.deleteScore(viewScoreList.get(row))) {
                JOptionPane.showMessageDialog(this, "删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "删除失败");
            }
            setScoreList(new Score());
        }
    }
}
