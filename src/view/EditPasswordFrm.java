package view;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.UserDatabase;
import util.Dbutil;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditPasswordFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField OldPasswordtextField;
    private JLabel lblNewLabel_1;
    private JTextField newPasswordtextField;
    private JLabel lblNewLabel_2;
    private JTextField comfirmPasswordtextField;
    private JTextField currentUserLabel;
    private JButton submitButton;
    private JButton resetButton;
    private JFrame parentFrame;
    private String currentUser;

    public EditPasswordFrm(JFrame parentFrame) {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u4FEE\u6539\u5BC6\u7801\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setFont(new Font("΢   ź ", Font.PLAIN, 12));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u539F\u5BC6\u7801:");
        lblNewLabel.setFont(new Font("΢   ź ", Font.PLAIN, 14));

        OldPasswordtextField = new JTextField();
        OldPasswordtextField.setColumns(10);

        lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801:");
        lblNewLabel_1.setFont(new Font("΢   ź ", Font.PLAIN, 14));

        newPasswordtextField = new JTextField();
        newPasswordtextField.setColumns(10);

        lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
        lblNewLabel_2.setFont(new Font("΢   ź ", Font.PLAIN, 14));

        comfirmPasswordtextField = new JTextField();
        comfirmPasswordtextField.setFont(new Font("΢   ź ", Font.PLAIN, 12));
        comfirmPasswordtextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("\u5F53\u524D\u7528\u6237:");
        lblNewLabel_3.setFont(new Font("΢   ź ", Font.PLAIN, 14));

        currentUserLabel = new JTextField();
        currentUserLabel.setColumns(10);

        submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitButtonActionPerformed(e);
            }
        });


        resetButton = new JButton("  \u91CD\u7F6E  ");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(76)
                                                .addComponent(submitButton)
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(resetButton))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(67)
                                                .addComponent(lblNewLabel_3)
                                                .addGap(18)
                                                .addComponent(currentUserLabel))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(71)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(OldPasswordtextField))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(71)
                                                .addComponent(lblNewLabel_1)
                                                .addGap(28)
                                                .addComponent(newPasswordtextField))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(61)
                                                .addComponent(lblNewLabel_2)
                                                .addGap(24)
                                                .addComponent(comfirmPasswordtextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
                                .addGap(103))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_3)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(currentUserLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(14)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(OldPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(newPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(26)
                                                .addComponent(lblNewLabel_2))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(22)
                                                .addComponent(comfirmPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(resetButton)))
        );
        contentPane.setLayout(gl_contentPane);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		 setLocationRelativeTo(null);

    }

    protected void resetButtonActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        OldPasswordtextField.setText("");
        newPasswordtextField.setText("");
        comfirmPasswordtextField.setText("");
    }

    protected void submitButtonActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String oldPassword = OldPasswordtextField.getText();
        String newPassword = newPasswordtextField.getText();
        String confirmPassword = comfirmPasswordtextField.getText();

        if(StringUtil.ifEmpty(oldPassword)) {
            JOptionPane.showMessageDialog(this, "    дԭ    ");
            return;
        }
        if(StringUtil.ifEmpty(newPassword)) {
            JOptionPane.showMessageDialog(this, "    д      ");
            return;
        }
        if(StringUtil.ifEmpty(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "    дȷ      ");
            return;
        }

        //           ȷ       Ƿ ƥ
        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "       ȷ     벻ƥ  ");
            return;

        }

        if(changePassword(oldPassword, newPassword)) {
            JOptionPane.showMessageDialog(this, "        ɹ ");
        }

    }
    private boolean changePassword(String oldPassword, String newPassword) {
        //    赱ǰ û  ѵ ¼   û   Ϊ currentUserLabel.getText()
        String username = currentUserLabel.getText();
        //   ֤       Ƿ   ȷ
        if (!UserDatabase.verifyPassword(username, oldPassword)) {
            JOptionPane.showMessageDialog(this, "ԭ   벻  ȷ");
            return false;
        }

        //  ޸
        if (updatePasswordInDatabase(username, newPassword)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "     ޸ ʧ ܣ    Ժ     ");
            return false;
        }
    }
    private boolean updatePasswordInDatabase(String username, String newPassword) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //   ȡ   ݿ
            conn = Dbutil.getConnection();

            // SQL
            String sql = "UPDATE s_admin SET password = ? WHERE name = ?";

            //      PreparedStatement
            pstmt = conn.prepareStatement(sql);

            //    ò
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);

            // ִ и  ²
            int rowsUpdated = pstmt.executeUpdate();

            //       ³ɹ        true     򷵻  false
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //  ر    ݿ
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}