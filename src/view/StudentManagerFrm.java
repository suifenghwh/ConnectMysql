package view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Dao.StudentDao;
import model.StudentBaseInfo;
import util.StringUtil;

public class StudentManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField SearchStudentByIDtextField;
    private JTable StudentListTable;
    private JTextField editStudentNametextField;
    private JTextField editStudentIDtextField;
    private JTextField editStudentnationalitytextField;
    private JTextField editStudentPoliticalStaustextField;
    private JTextField editStudentPositiontextField;
    private JTextField SearchStudentByNametextField;
    private JRadioButton editStudentSexManRadioButton;
    private JRadioButton editStudentSexWomanRadioButton;
    private ButtonGroup genderButtonGroup;

    public StudentManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
        setBounds(100, 100, 744, 631);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D:");

        JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u5B66\u53F7:");

        SearchStudentByIDtextField = new JTextField();
        SearchStudentByIDtextField.setColumns(10);

        JButton SearchButton = new JButton("\u67E5\u8BE2");
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStudent(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u59D3\u540D:");

        editStudentNametextField = new JTextField();
        editStudentNametextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u6027\u522B:");

        editStudentSexManRadioButton = new JRadioButton("\u7537");

        editStudentSexWomanRadioButton = new JRadioButton("\u5973");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(editStudentSexManRadioButton);
        genderButtonGroup.add(editStudentSexWomanRadioButton);

        JLabel lblNewLabel_4 = new JLabel("\u5B66\u751F\u5B66\u53F7");

        editStudentIDtextField = new JTextField();
        editStudentIDtextField.setColumns(10);

        JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
        submitEditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitEditAct(e);
            }
        });

        JButton DeleteStudentButton = new JButton("\u5220\u9664\u5B66\u751F");
        DeleteStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent(e);
            }
        });

        JLabel lblNewLabel_5 = new JLabel("\u6C11\u65CF:");

        editStudentnationalitytextField = new JTextField();
        editStudentnationalitytextField.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("\u653F\u6CBB\u9762\u8C8C:");

        JLabel lblNewLabel_7 = new JLabel("\u804C\u52A1:");

        editStudentPoliticalStaustextField = new JTextField();
        editStudentPoliticalStaustextField.setColumns(10);

        editStudentPositiontextField = new JTextField();
        editStudentPositiontextField.setColumns(10);

        SearchStudentByNametextField = new JTextField();
        SearchStudentByNametextField.setColumns(10);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(104)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel_4)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap())
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblNewLabel)
                                                                        .addGap(31)
                                                                        .addComponent(SearchStudentByNametextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(88)
                                                                        .addComponent(lblNewLabel_1)
                                                                        .addGap(39)
                                                                        .addComponent(SearchStudentByIDtextField, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                                        .addComponent(SearchButton))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(lblNewLabel_6))
                                                                        .addGap(45)
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(editStudentNametextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(editStudentIDtextField, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                                                                .addComponent(editStudentPoliticalStaustextField, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                                                        .addGap(113)
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_5)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addComponent(lblNewLabel_7))
                                                                        .addGap(18)
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(editStudentPositiontextField)
                                                                                .addComponent(editStudentnationalitytextField)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                        .addComponent(editStudentSexManRadioButton)
                                                                                        .addGap(39)
                                                                                        .addComponent(editStudentSexWomanRadioButton)))
                                                                        .addGap(40)
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(submitEditButton)
                                                                                .addComponent(DeleteStudentButton))))
                                                        .addGap(66)))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(39)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(SearchStudentByIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton)
                                        .addComponent(SearchStudentByNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(46)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(43)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(lblNewLabel_3)
                                                                        .addComponent(editStudentSexManRadioButton)
                                                                        .addComponent(editStudentSexWomanRadioButton)))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(34)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(lblNewLabel_2)
                                                                        .addComponent(editStudentNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_4)
                                                        .addComponent(editStudentIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_5)
                                                        .addComponent(editStudentnationalitytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(submitEditButton)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lblNewLabel_7)
                                                .addComponent(editStudentPositiontextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_6)
                                                .addComponent(editStudentPoliticalStaustextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(DeleteStudentButton))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StudentListTable = new JTable();
        StudentListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedTableRow(e);
            }
        });
        StudentListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u5B66\u751F\u5B66\u53F7", "\u5B66\u751F\u59D3\u540D", "\u5E74\u9F84", "\u6027\u522B", "\u6C11\u65CF", "\u653F\u6CBB\u9762\u8C8C", "\u804C\u52A1", "\u6559\u5E08\u7F16\u53F7"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    true, true, true, true, true, true, true, true
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(StudentListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new StudentBaseInfo());
    }

    protected void submitEditAct(ActionEvent e) {
        int row = StudentListTable.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的行");
            return;
        }
        StudentBaseInfo student = new StudentBaseInfo();
        String studentName = editStudentNametextField.getText().toString();
        if(editStudentSexManRadioButton.isSelected()) {
            student.setGender(editStudentSexManRadioButton.getText().toString());
        }
        if(editStudentSexWomanRadioButton.isSelected()) {
            student.setGender(editStudentSexWomanRadioButton.getText().toString());
        }
        String studentNationality = editStudentnationalitytextField.getText().toString();
        String studentPoliticalStaus = editStudentPoliticalStaustextField.getText().toString();
        String studentPosition = editStudentPositiontextField.getText().toString();
        student.setStudentId(Integer.parseInt(StudentListTable.getValueAt(row,0).toString()));
        student.setName(studentName);
        student.setPoliticalStatus(studentPoliticalStaus);
        student.setPosition(studentPosition);
        student.setNationality(studentNationality);
        StudentDao studentDao = new StudentDao();
        if(studentDao.updateStudent(student)) {
            JOptionPane.showMessageDialog(this, "修改成功");
        }else {
            JOptionPane.showMessageDialog(this, "修改失败");
        }
        setTable(new StudentBaseInfo());
    }

    protected void selectedTableRow(MouseEvent e) {
        DefaultTableModel dfs = (DefaultTableModel) StudentListTable.getModel();
        editStudentIDtextField.setText(dfs.getValueAt(StudentListTable.getSelectedRow(), 0).toString());
        editStudentNametextField.setText(dfs.getValueAt(StudentListTable.getSelectedRow(), 1).toString());
        editStudentnationalitytextField.setText(dfs.getValueAt(StudentListTable.getSelectedRow(), 4).toString());
        editStudentPoliticalStaustextField.setText(dfs.getValueAt(StudentListTable.getSelectedRow(), 5).toString());
        editStudentPositiontextField.setText(dfs.getValueAt(StudentListTable.getSelectedRow(), 6).toString());
        String gender = dfs.getValueAt(StudentListTable.getSelectedRow(), 3).toString();
        if (gender.equals("  ")) {
            editStudentSexManRadioButton.setSelected(true);
        } else if (gender.equals(editStudentSexWomanRadioButton.getText())) {
            editStudentSexWomanRadioButton.setSelected(true);
        }
    }

    protected void deleteStudent(ActionEvent e) {
        int row = StudentListTable.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的数据");
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "确定删除该学生吗?");
        if (option == JOptionPane.OK_OPTION) {
            StudentDao studentDao = new StudentDao();
            if (studentDao.deleteStudent(Integer.parseInt(StudentListTable.getValueAt(row,0).toString()))) {
                JOptionPane.showMessageDialog(this, "删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "删除失败");
            }
            setTable(new StudentBaseInfo());
        }
    }

    protected void searchStudent(ActionEvent e) {
        String name = SearchStudentByNametextField.getText().toString();
        String studentIDText = SearchStudentByIDtextField.getText().toString();
        StudentBaseInfo student = new StudentBaseInfo();
        student.setName(name);
        int studentID;
        if(StringUtil.ifEmpty(studentIDText)) {
            studentID = 0;
        }
        else {
            studentID = Integer.parseInt(studentIDText);
        }
        student.setStudentId(studentID);
        setTable(student);
    }

    private void setTable(StudentBaseInfo S) {
        DefaultTableModel dft = (DefaultTableModel) StudentListTable.getModel();
        dft.setRowCount(0);
        StudentDao studentDao = new StudentDao();
        List<StudentBaseInfo> studentList = studentDao.getStudentList(S);
        for (StudentBaseInfo student : studentList) {
            Vector v = new Vector();
            v.add(student.getStudentId());
            v.add(student.getName());
            v.add(student.getAge());
            v.add(student.getGender());
            v.add(student.getNationality());
            v.add(student.getPoliticalStatus());
            v.add(student.getPosition());
            v.add(student.getTeacherId());
            dft.addRow(v);
        }
    }
}
