package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.CourseDao;
import Dao.ScoreDao;
import model.ClassCourse;
import model.Score;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class StatsScoreFrm extends JInternalFrame {
    private JTextField minScoretextField;
    private JTextField maxScoretextField;
    private JTextField avgScoretextField;
    private JTextField totalScoretextField;
    private JTextField StudentIDtextField;
    private JComboBox CourseNamecomboBox;
    private List<ClassCourse> courseList = new ArrayList<>();
    private List<Score> viewScoreList = new ArrayList<>();

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StatsScoreFrm frame = new StatsScoreFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

    /**
     * Create the frame.
     */
    public StatsScoreFrm() {

        setClosable(true);
        setIconifiable(true);
        setTitle("\u6210\u7EE9\u7EDF\u8BA1\u754C\u9762");
        setBounds(100, 100, 717, 586);

        JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0");

        CourseNamecomboBox = new JComboBox();
        CourseNamecomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//		 		searchCourseStats();
            }
        });

        JButton SearchButton = new JButton("\u67E5\u8BE2");
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStatsAct(e);
            }
        });

        JPanel viewPanel = new JPanel();
        viewPanel.setBorder(new TitledBorder(null, "\u6210\u7EE9\u7EDF\u8BA1\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JLabel lblNewLabel_5 = new JLabel("\u5B66\u751F\u5B66\u53F7");

        StudentIDtextField = new JTextField();
        StudentIDtextField.setColumns(10);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "\u5207\u6362\u663E\u793A\u65B9\u5F0F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(213)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(lblNewLabel))
                                .addGap(57)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(CourseNamecomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(StudentIDtextField, 182, 182, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(SearchButton)
                                .addGap(45))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(168)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                        .addComponent(viewPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
                                .addGap(141))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(37)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(StudentIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(CourseNamecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton))
                                .addGap(29)
                                .addComponent(viewPanel, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                                .addGap(28)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(57, Short.MAX_VALUE))
        );

        JButton defaultViewButton = new JButton("\u9ED8\u8BA4\u663E\u793A");
        defaultViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                defaultViewAct(e);
            }
        });

        JButton barViewButton = new JButton("\u67F1\u72B6\u56FE\u663E\u793A");
        barViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                barViewAct(e);
            }
        });

        JButton pieViewButton = new JButton("\u997C\u72B6\u56FE\u663E\u793A");
        pieViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                peiViewAct(e);
            }
        });
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(27)
                                .addComponent(defaultViewButton)
                                .addGap(26)
                                .addComponent(barViewButton)
                                .addGap(18)
                                .addComponent(pieViewButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(18)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(defaultViewButton)
                                        .addComponent(barViewButton)
                                        .addComponent(pieViewButton))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JLabel lblNewLabel_1 = new JLabel("\u603B\u5206");

        JLabel lblNewLabel_2 = new JLabel("\u5E73\u5747\u5206");

        JLabel lblNewLabel_3 = new JLabel("\u6700\u9AD8\u5206");

        JLabel lblNewLabel_4 = new JLabel("\u6700\u4F4E\u5206");

        minScoretextField = new JTextField();
        minScoretextField.setEditable(false);
        minScoretextField.setColumns(10);

        maxScoretextField = new JTextField();
        maxScoretextField.setEditable(false);
        maxScoretextField.setColumns(10);

        avgScoretextField = new JTextField();
        avgScoretextField.setEditable(false);
        avgScoretextField.setColumns(10);

        totalScoretextField = new JTextField();
        totalScoretextField.setEditable(false);
        totalScoretextField.setColumns(10);
        GroupLayout gl_viewPanel = new GroupLayout(viewPanel);
        gl_viewPanel.setHorizontalGroup(
                gl_viewPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_viewPanel.createSequentialGroup()
                                .addGap(48)
                                .addGroup(gl_viewPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(lblNewLabel_1))
                                .addGap(39)
                                .addGroup(gl_viewPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(totalScoretextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                        .addComponent(avgScoretextField)
                                        .addComponent(maxScoretextField)
                                        .addComponent(minScoretextField))
                                .addContainerGap(114, Short.MAX_VALUE))
        );
        gl_viewPanel.setVerticalGroup(
                gl_viewPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_viewPanel.createSequentialGroup()
                                .addGap(27)
                                .addGroup(gl_viewPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(totalScoretextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(gl_viewPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(avgScoretextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(36)
                                .addGroup(gl_viewPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(maxScoretextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(27)
                                .addGroup(gl_viewPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(minScoretextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        viewPanel.setLayout(gl_viewPanel);
        getContentPane().setLayout(groupLayout);
        setCoureseCombox() ;

    }
    protected void defaultViewAct(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    protected void peiViewAct(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    protected void barViewAct(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    //	private void searchCourseStats() {
//        // 获取选择的课程名称
//        String selectedCourse = (String) CourseNamecomboBox.getSelectedItem();
//        // 查询该课程下的最高分和最低分
//        ScoreDao scoreDao = new ScoreDao();
//        Map<String, Integer> stats = scoreDao.getCourseStats(selectedCourse);
//        // 更新界面显示
//        updateStatsView(stats);
//    }
//	private void updateStatsView(Map<String, Integer> stats) {
//        if (stats != null) {
//            // 更新界面上的最高分和最低分文本框
//            if (stats.containsKey("max_score")) {
//                maxScoretextField.setText(String.valueOf(stats.get("max_score")));
//            }
//            if (stats.containsKey("min_score")) {
//                minScoretextField.setText(String.valueOf(stats.get("min_score")));
//            }
//        }
//	}
    protected void searchStatsAct(ActionEvent e) {
        // TODO Auto-generated method stub
        ScoreDao scoreDao = new ScoreDao();
//		Score score = new Score();

        int StudentID = Integer.parseInt(StudentIDtextField.getText().toString());
        resetText();
//		viewScoreList=scoreDao.getScoreList(score);
        Map<String, String> statsInfo = scoreDao.getStatsInfo(StudentID);
        totalScoretextField.setText(statsInfo.get("total_score"));
        avgScoretextField.setText(statsInfo.get("average_score"));
    }
    private void setCoureseCombox() {
        CourseDao courseDao = new CourseDao();
        courseList = courseDao.getCourseList(new ClassCourse());
        for(ClassCourse course : courseList) {
            CourseNamecomboBox.addItem(course.getCourseName());

        }
    }
    private void resetText() {
        totalScoretextField.setText("");
        avgScoretextField.setText("");
    }

}


