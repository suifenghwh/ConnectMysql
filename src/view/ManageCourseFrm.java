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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.CourseDao;
import Dao.StudentDao;
import Dao.TeachersDao;
import model.ClassCourse;
import model.StudentBaseInfo;
import model.Teachers;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class ManageCourseFrm extends JInternalFrame {
    private JTextField SearchCourseNametextField;
    private JTable CourseListTable;
    private JTextField editCourseIDtextField;
    private JTextField editCourseNametextField;
    private JComboBox SearchTeachercomboBox;
    private JComboBox editCourseTeachercomboBox;
    private JComboBox editClassTimecomboBox;
    private JButton submitEditButton;
    List<Teachers> teacherList = new ArrayList<Teachers>();

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManageCourseFrm frame = new ManageCourseFrm();
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
    public ManageCourseFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
        setBounds(100, 100, 583, 596);

        JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0");

        SearchCourseNametextField = new JTextField();
        SearchCourseNametextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u6388\u8BFE\u8001\u5E08");

        SearchTeachercomboBox = new JComboBox();

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u7F16\u8F91\u8BFE\u7A0B\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JButton SearchButton = new JButton("\u67E5\u8BE2");
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCourse(e);
            }
        });
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(61)
                                                .addComponent(lblNewLabel)
                                                .addGap(32)
                                                .addComponent(SearchCourseNametextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addGap(51)
                                                .addComponent(lblNewLabel_1)
                                                .addGap(46)
                                                .addComponent(SearchTeachercomboBox, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                .addGap(36)
                                                .addComponent(SearchButton))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(77)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(49)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(SearchCourseNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(SearchTeachercomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton))
                                .addGap(38)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                                .addGap(29)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        JLabel lblNewLabel_2 = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");

        editCourseIDtextField = new JTextField();
        editCourseIDtextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("\u8BFE\u7A0B\u540D\u79F0");

        editCourseNametextField = new JTextField();
        editCourseNametextField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("\u6388\u8BFE\u8001\u5E08");

        editCourseTeachercomboBox = new JComboBox();

        JLabel lblNewLabel_5 = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");

        editClassTimecomboBox = new JComboBox();
        editClassTimecomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5468\u4E00", "\u5468\u4E8C", "\u5468\u4E09", "\u5468\u56DB", "\u5468\u4E94"}));

        submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
        submitEditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                editCourseSubmit(ae);
            }
        });


        JButton deleteCourseButton = new JButton("\u5220\u9664\u8BFE\u7A0B");
        deleteCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCourse(e);
            }
        });
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(24)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_2)
                                                        .addComponent(lblNewLabel_4))
                                                .addGap(29)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(editCourseTeachercomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(editCourseIDtextField))
                                                .addGap(36)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_3)
                                                        .addComponent(lblNewLabel_5))
                                                .addGap(26)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(editClassTimecomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(editCourseNametextField))
                                                .addContainerGap(38, Short.MAX_VALUE))
                                        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                                .addGap(37)
                                                .addComponent(submitEditButton)
                                                .addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                                .addComponent(deleteCourseButton)
                                                .addGap(68))))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editCourseIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editCourseNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(editCourseTeachercomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(editClassTimecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(deleteCourseButton)
                                        .addComponent(submitEditButton))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        CourseListTable = new JTable();
        CourseListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selecteCourse(e);
            }
        });
        CourseListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u4E0A\u8BFE\u65F6\u95F4", "\u6559\u5E08\u540D\u5B57", "\u6559\u5E08\u7F16\u53F7"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(CourseListTable);
        getContentPane().setLayout(groupLayout);
        setTeacherCombox();
        setCourseTable(new ClassCourse());
    }

    protected void editCourseSubmit(ActionEvent ae) {
        // TODO Auto-generated method stub
        int row = CourseListTable.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(this, "请选中要修改的数据");
            return;
        }
        // 获取编辑框中的课程信息
        int courseId = Integer.parseInt(editCourseIDtextField.getText());
        String courseName = editCourseNametextField.getText();
        String classTime = editClassTimecomboBox.getSelectedItem().toString();
        Teachers teacher = (Teachers) editCourseTeachercomboBox.getSelectedItem();
        int teacherId = teacher.getID();

        // 创建课程对象
        ClassCourse course = new ClassCourse(courseId, courseName, classTime, teacher.getTeacherName(), teacherId);

        // 更新数据库中的课程信息
        CourseDao courseDao = new CourseDao();
        boolean success = courseDao.updateCourse(course);
        if (success) {
            JOptionPane.showMessageDialog(this, "课程信息更新成功");
            setCourseTable(new ClassCourse()); // 刷新课程列表
        } else {
            JOptionPane.showMessageDialog(this, "课程信息更新失败");
        }

        setCourseTable(new ClassCourse());
    }

    protected void selecteCourse(MouseEvent e) {
        // TODO Auto-generated method stub
        int selectedRow = CourseListTable.getSelectedRow();
        if (selectedRow != -1) {
            // 获取选定行的课程信息
            int courseId = Integer.parseInt(CourseListTable.getValueAt(selectedRow, 0).toString());
            String courseName = CourseListTable.getValueAt(selectedRow, 1).toString();
            String classTime = CourseListTable.getValueAt(selectedRow, 2).toString();
            String teacherName = CourseListTable.getValueAt(selectedRow, 3).toString();
            int teacherId = Integer.parseInt(CourseListTable.getValueAt(selectedRow, 4).toString());
            // 将课程信息填充到编辑区域
            editCourseIDtextField.setText(String.valueOf(courseId));
            editCourseNametextField.setText(courseName);
            editClassTimecomboBox.setSelectedItem(classTime);
            // 在编辑区域的教师下拉框中选中对应的教师
            for (Teachers teacher : teacherList) {
                if (teacher.getID() == teacherId) {
                    editCourseTeachercomboBox.setSelectedItem(teacher);
                    break;
                }
            }
        }
    }


    protected void searchCourse(ActionEvent e) {
        // TODO Auto-generated method stub
        String CourseName = SearchCourseNametextField.getText().toString();
        Teachers teachers = (Teachers) SearchTeachercomboBox.getSelectedItem();
        ClassCourse course = new ClassCourse();
        course.setCourseName(CourseName);
        course.setTeacherName(getTeacherNameById(teachers.getID()));
        setCourseTable(course);
    }

    protected void deleteCourse(ActionEvent e) {
        // TODO Auto-generated method stub

        int row = CourseListTable.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的数据");
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "确定删除该课程吗?");
        if (option == JOptionPane.OK_OPTION) {
            CourseDao courseDao = new CourseDao();
            if (courseDao.deleteCourse(Integer.parseInt(CourseListTable.getValueAt(row,0).toString()))) {
                JOptionPane.showMessageDialog(this, "删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "删除失败");
            }
            setCourseTable(new ClassCourse());
        }


    }
    private void setCourseTable(ClassCourse c) {
        DefaultTableModel dft = (DefaultTableModel) CourseListTable.getModel();
        dft.setRowCount(0); // 清空表格
        CourseDao courseDao = new CourseDao();
        List<ClassCourse> courseList = courseDao.getCourseList(c);
        for (ClassCourse course : courseList) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(course.getCourseId());
            rowData.add(course.getCourseName());
            rowData.add(course.getClassTime());
            rowData.add(course.getTeacherName());
            rowData.add(course.getTeacherId());
            dft.addRow(rowData);
        }

    }
    private void setTeacherCombox(){
        TeachersDao teachersDao = new TeachersDao();
        teacherList = teachersDao.getTeacherList(new Teachers());
        for(Teachers teacher : teacherList) {
            editCourseTeachercomboBox.addItem(teacher);
            SearchTeachercomboBox.addItem(teacher);
//		 TeacherIDcomboBox.addItem(teacher.getID());
        }

    }
    private String getTeacherNameById(int teacherId) {
        String retString = "";
        for (Teachers teachers : teacherList) {
            if(teachers.getID() == teacherId) {
                retString += teachers.getTeacherName();
                break;
            }
        }

        return retString;
    }
}
