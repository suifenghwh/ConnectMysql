package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.StudentDao;
import model.StudentBaseInfo;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAddFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField StudentIDtextField;
    private JTextField StudentNametextField;
    private JTextField StudentAgetextField;
    private JTextField StudentNationalitytextField;
    private JTextField StudentPoliticalStaustextField;
    private JTextField StudentPositiontextField;
    private JTextField teacherIdtextField;
    private JRadioButton manNewRadioButton;
    private JRadioButton womanNewRadioButton;
    private ButtonGroup genderButtonGroup;

    public StudentAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");

        setBounds(100, 100, 383, 481);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u5B66\u751FID:");
        StudentIDtextField = new JTextField();
        StudentIDtextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D:");
        StudentNametextField = new JTextField();
        StudentNametextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u5E74\u9F84:");
        StudentAgetextField = new JTextField();
        StudentAgetextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u6027\u522B:");
        manNewRadioButton = new JRadioButton("\u7537");
        womanNewRadioButton = new JRadioButton("\u5973");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(manNewRadioButton);
        genderButtonGroup.add(womanNewRadioButton);

        JLabel lblNewLabel_4 = new JLabel("\u6C11\u65CF:");
        StudentNationalitytextField = new JTextField();
        StudentNationalitytextField.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("");

        JLabel lblNewLabel_6 = new JLabel("\u653F\u6CBB\u9762\u8C8C:");
        StudentPoliticalStaustextField = new JTextField();
        StudentPoliticalStaustextField.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("\u804C\u52A1:");
        StudentPositiontextField = new JTextField();
        StudentPositiontextField.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("\u6559\u5E08ID:");
        teacherIdtextField = new JTextField();
        teacherIdtextField.setColumns(10);

        JButton submitButton = new JButton("\u786E\u5B9A");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitValue(e);
            }
        });

        JButton resetButton = new JButton("\u91CD\u7F6E");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValue(e);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(58)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel_8)
                                                .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                                .addComponent(submitButton)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                                                .addComponent(resetButton))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addGap(41)
                                                                                .addComponent(manNewRadioButton))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                        .addComponent(lblNewLabel)
                                                                                        .addComponent(lblNewLabel_1)
                                                                                        .addComponent(lblNewLabel_2))
                                                                                .addGap(46)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                        .addComponent(StudentIDtextField, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                                                                        .addComponent(StudentNametextField, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                                                                        .addComponent(StudentAgetextField, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                        .addComponent(lblNewLabel_4)
                                                                                        .addComponent(lblNewLabel_6)
                                                                                        .addComponent(lblNewLabel_7)
                                                                                        .addComponent(lblNewLabel_5))
                                                                                .addGap(48)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                .addComponent(StudentNationalitytextField))
                                                                                        .addComponent(teacherIdtextField, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                                                                        .addComponent(StudentPositiontextField)
                                                                                        .addComponent(StudentPoliticalStaustextField))))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(womanNewRadioButton)))
                                                .addGap(138))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(22)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(StudentIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(StudentNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(StudentAgetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(manNewRadioButton)
                                        .addComponent(womanNewRadioButton))
                                .addGap(24)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(StudentNationalitytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_6)
                                        .addComponent(StudentPoliticalStaustextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_7)
                                        .addComponent(StudentPositiontextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_8)
                                        .addComponent(teacherIdtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(resetButton))
                                .addGap(23)
                                .addComponent(lblNewLabel_5)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }

    protected void submitValue(ActionEvent e) {
        int studentId = Integer.parseInt(StudentIDtextField.getText());
        String name = StudentNametextField.getText();
        int age = Integer.parseInt(StudentAgetextField.getText());
        String gender = manNewRadioButton.isSelected() ? "  " : "Ů";
        String nationality = StudentNationalitytextField.getText();
        String politicalStatus = StudentPoliticalStaustextField.getText();
        String position = StudentPositiontextField.getText();
        int teacherId = Integer.parseInt(teacherIdtextField.getText());
        if (StringUtil.ifEmpty(name) || StringUtil.ifEmpty(nationality) || StringUtil.ifEmpty(politicalStatus) || StringUtil.ifEmpty(position)) {
            JOptionPane.showMessageDialog(this, "         б    ֶ ");
        }
        StudentBaseInfo studentInfo = new StudentBaseInfo(studentId, name, age, gender, nationality, politicalStatus, position, teacherId);
        StudentDao studentDao = new StudentDao();
        boolean success = studentDao.addStudent(studentInfo);
        if (success) {
            JOptionPane.showMessageDialog(this, "插入成功");
        } else {
            JOptionPane.showMessageDialog(this, "插入失败");
        }
    }

    protected void resetValue(ActionEvent e) {
        StudentIDtextField.setText("");
        StudentNametextField.setText("");
        StudentAgetextField.setText("");
        StudentNationalitytextField.setText("");
        StudentPoliticalStaustextField.setText("");
        StudentPositiontextField.setText("");
        teacherIdtextField.setText("");
        manNewRadioButton.setSelected(false);
        womanNewRadioButton.setSelected(false);
    }
}
