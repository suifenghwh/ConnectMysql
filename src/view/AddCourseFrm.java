package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.List;

import Dao.CourseDao;
import Dao.TeacherDao;
import Dao.TeachersDao;
import model.ClassCourse;
import model.Teacher;
import model.Teachers;
import util.StringUtil;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AddCourseFrm extends JInternalFrame {
    private JTextField CourseNametextField;
    private JComboBox TeacherListcomboBox;
    private JTextField CourseIDtextField;
    private JComboBox DatecomboBox;
    private JTextField TeacherIDtextField;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddCourseFrm frame = new AddCourseFrm();
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
    public AddCourseFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
        setBounds(100, 100, 484, 452);

        JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");

        CourseNametextField = new JTextField();
        CourseNametextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u6388\u8BFE\u8001\u5E08:");

        TeacherListcomboBox = new JComboBox();

        JButton addCourseButton = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddCourseAct(e);
            }
        });

        JButton resetButton = new JButton("\u91CD\u7F6E");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValue(e);
            }
        });

        JLabel lblNewLabel_3 = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");

        CourseIDtextField = new JTextField();
        CourseIDtextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("\u6559\u5E08\u7F16\u53F7");

        JLabel lblNewLabel_2 = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");

        DatecomboBox = new JComboBox();
        DatecomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5468\u4E00", "\u5468\u4E8C", "\u5468\u4E09", "\u5468\u56DB", "\u5468\u4E94", ""}));

        TeacherIDtextField = new JTextField();
        TeacherIDtextField.setColumns(10);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(101)
                                .addComponent(addCourseButton)
                                .addGap(90)
                                .addComponent(resetButton)
                                .addContainerGap(145, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(110)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_3)
                                                        .addComponent(lblNewLabel))
                                                .addGap(61))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_1)
                                                        .addComponent(lblNewLabel_2)
                                                        .addComponent(lblNewLabel_4))
                                                .addGap(59)))
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(CourseNametextField, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(CourseIDtextField, 129, 184, Short.MAX_VALUE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(TeacherListcomboBox, Alignment.LEADING, 0, 184, Short.MAX_VALUE)
                                                        .addComponent(DatecomboBox, Alignment.LEADING, 0, 184, Short.MAX_VALUE)
                                                        .addComponent(TeacherIDtextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGap(65))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(46)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(CourseIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_3))
                                .addGap(27)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(CourseNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(TeacherListcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(TeacherIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(33)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(DatecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(87)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(addCourseButton)
                                        .addComponent(resetButton))
                                .addGap(54))
        );
        getContentPane().setLayout(groupLayout);
        setTeacherCombox();

    }

    protected void resetValue(ActionEvent e) {
        // TODO Auto-generated method stub
        CourseNametextField.setText("");
        CourseIDtextField.setText("");
        TeacherListcomboBox.setSelectedIndex(0);
        DatecomboBox.setSelectedIndex(0);
        CourseIDtextField.setText("");
    }

    protected void AddCourseAct(ActionEvent e) {
        // TODO Auto-generated method stub
        String courseName = CourseNametextField.getText();
//		 int courseID = Integer.parseInt(CourseIDtextField.getText());
//		 int teacherId = Integer.parseInt(TeacherIDtextField.getText());
//		 String courseID = CourseIDtextField.getText();
//		 String TeacherID = TeacherIDtextField.getText();
        // 获取选择的授课老师姓名
        String selectedTeacherName = (String) TeacherListcomboBox.getSelectedItem().toString();

        // 检查输入是否为空
        if(StringUtil.ifEmpty(CourseIDtextField.getText().toString())) {
            JOptionPane.showMessageDialog(this, "请输入课程ID");
            return;
        }
        if(StringUtil.ifEmpty(CourseNametextField.getText().toString())) {
            JOptionPane.showMessageDialog(this, "请输入课程名称");
            return;
        }
        if(StringUtil.ifEmpty(TeacherIDtextField.getText().toString())) {
            JOptionPane.showMessageDialog(this, "请输入课程ID");
            return;
        }
        // 创建课程对象
        ClassCourse course = new ClassCourse();
        course.setCourseName(courseName);
        course.setCourseId(Integer.parseInt(CourseIDtextField.getText()));
        course.setTeacherId(Integer.parseInt(TeacherIDtextField.getText()));
        course.setClassTime((String) DatecomboBox.getSelectedItem());
        course.setTeacherName(selectedTeacherName);

        // 将课程添加到数据库
        CourseDao courseDao = new CourseDao();
        boolean success = courseDao.addCourse(course);
        if (success) {
            JOptionPane.showMessageDialog(this, "课程添加成功");
            // 清空输入框
            resetValue(e);
        } else {
            JOptionPane.showMessageDialog(this, "课程添加失败，请重试");
        }
    }
    private void setTeacherCombox(){
        TeachersDao teachersDao = new TeachersDao();
        List<Teachers> teacherList = teachersDao.getTeacherList(new Teachers());
        for(Teachers teacher : teacherList) {
            TeacherListcomboBox.addItem(teacher);
//		 TeacherIDcomboBox.addItem(teacher.getID());
        }

    }
}
