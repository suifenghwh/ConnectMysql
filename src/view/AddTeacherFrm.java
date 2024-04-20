package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.TeacherDao;
import model.Teacher;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeacherFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField TeacherIDtextField;
    private JTextField TeacherNametextField;
    private JPasswordField TeacherpasswordField;
    private JPasswordField TeacherAffirmpasswordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddTeacherFrm frame = new AddTeacherFrm();
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
    public AddTeacherFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u6DFB\u52A0\u73ED\u4E3B\u4EFB");
        setBounds(100, 100, 451, 381);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u73ED\u4E3B\u4EFBID:");

        TeacherIDtextField = new JTextField();
        TeacherIDtextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u73ED\u4E3B\u4EFB\u540D\u79F0:");

        TeacherNametextField = new JTextField();
        TeacherNametextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801:");

        TeacherpasswordField = new JPasswordField();

        JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");

        TeacherAffirmpasswordField = new JPasswordField();

        JButton SubmitButton = new JButton("\u786E\u8BA4\u4FE1\u606F");
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddTeacherAct(e);
            }
        });

        JButton ResetButton = new JButton("\u91CD\u7F6E");
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValue(e);
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(75)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(lblNewLabel_1)
                                                        .addComponent(lblNewLabel_2)
                                                        .addComponent(lblNewLabel_3))
                                                .addGap(50)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(TeacherAffirmpasswordField)
                                                        .addComponent(TeacherpasswordField, Alignment.LEADING)
                                                        .addComponent(TeacherNametextField, Alignment.LEADING)
                                                        .addComponent(TeacherIDtextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                                .addContainerGap(140, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(SubmitButton)
                                                .addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                                .addComponent(ResetButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                .addGap(82))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(42)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(TeacherIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(36)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(TeacherNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(42)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(TeacherpasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(35)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(TeacherAffirmpasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(42)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(SubmitButton)
                                        .addComponent(ResetButton))
                                .addGap(30))
        );
        contentPane.setLayout(gl_contentPane);
    }

    protected void resetValue(ActionEvent e) {
        // TODO Auto-generated method stub
        TeacherIDtextField.setText("");
        TeacherNametextField.setText("");
        TeacherpasswordField.setText("");
        TeacherAffirmpasswordField.setText("");
    }

    protected void AddTeacherAct(ActionEvent e) {
        // TODO Auto-generated method stub
//		 int teacherId = Integer.parseInt(TeacherIDtextField.getText());
        String teacherName = TeacherNametextField.getText();
        String teacherPassword = TeacherpasswordField.getText();
        String teacherAffirmPassword = TeacherAffirmpasswordField.getText();
        Teacher teacher = new Teacher();
        if(StringUtil.ifEmpty(TeacherIDtextField.getText().toString())) {
            JOptionPane.showMessageDialog(this, "请输入班主任ID");
            return;
        }
        if(StringUtil.ifEmpty(TeacherNametextField.getText().toString())) {
            JOptionPane.showMessageDialog(this, "请输入班主任姓名");
            return;
        }
        if(StringUtil.ifEmpty(TeacherpasswordField.getText().toString())) {
            JOptionPane.showMessageDialog(this, "请输入密码");
            return;
        }
        if(StringUtil.ifEmpty(TeacherAffirmpasswordField.getText().toString())) {
            JOptionPane.showMessageDialog(this, "请再一次输入密码");
            return;
        }
        if(!teacherPassword.equals(teacherAffirmPassword)) {
            JOptionPane.showMessageDialog(this, "两次密码不一致,请重新输入");
            return;
        }
        teacher.setTeacherId(Integer.parseInt(TeacherIDtextField.getText()));
        teacher.setUsername(teacherName);
        teacher.setPassword(teacherPassword);
        TeacherDao teacherDao = new TeacherDao();
        boolean success = teacherDao.addTeacher(teacher);

        // 根据操作结果提示用户
        if (success) {
            JOptionPane.showMessageDialog(this, "提交成功");
        } else {
            JOptionPane.showMessageDialog(this, "提交失败");
        }
        resetValue(e);

    }
}
