package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Dao.StudentCommentDao;
import model.StudentComment;
import util.StringUtil;

public class StudentCommentManagerFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField SearchCommentByStudentIDtextField;
    private JTable CommentListTable;
    private JTextField editCommentContenttextField;
    private JTextField editCommentDatetextField;
    private JTextField editCommentIDtextField;

    public StudentCommentManagerFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("学生评语管理");
        setBounds(20, 20, 744, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("学生学号:");

        SearchCommentByStudentIDtextField = new JTextField();
        SearchCommentByStudentIDtextField.setColumns(10);

        JButton SearchCommentButton = new JButton("查询");
        SearchCommentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchComment(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("评语内容:");

        editCommentContenttextField = new JTextField();
        editCommentContenttextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("评语时间:");

        editCommentDatetextField = new JTextField();
        editCommentDatetextField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("评语ID:");

        editCommentIDtextField = new JTextField();
        editCommentIDtextField.setColumns(10);
        editCommentIDtextField.setEditable(false);

        JButton submitCommentButton = new JButton("确认修改");
        submitCommentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitCommentAct(e);
            }
        });

        JButton deleteCommentButton = new JButton("删除评语");
        deleteCommentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteComment(e);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(104)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addGap(31)
                                                .addComponent(SearchCommentByStudentIDtextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                                                .addComponent(SearchCommentButton))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(132)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2)
                                                                .addGap(18)
                                                                .addComponent(editCommentDatetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1)
                                                                .addGap(18)
                                                                .addComponent(editCommentContenttextField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addGap(18)
                                                                .addComponent(editCommentIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(195)
                                                .addComponent(submitCommentButton)
                                                .addGap(39)
                                                .addComponent(deleteCommentButton)))
                                .addContainerGap(251, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(39)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(SearchCommentByStudentIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchCommentButton))
                                .addGap(46)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                .addGap(37)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(editCommentIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(editCommentContenttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(editCommentDatetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitCommentButton)
                                        .addComponent(deleteCommentButton))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        CommentListTable = new JTable();
        CommentListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "评语ID", "学生学号", "评语内容", "评语时间"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(CommentListTable);
        contentPane.setLayout(gl_contentPane);
        setTable(new StudentComment(0, 0, "", null)); // 或者使用默认值

        // 添加鼠标点击事件监听器，用于将选中行的数据显示在编辑框中
        CommentListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = CommentListTable.rowAtPoint(evt.getPoint());
                editCommentIDtextField.setText(CommentListTable.getValueAt(row, 0).toString());
                editCommentContenttextField.setText(CommentListTable.getValueAt(row, 2).toString());
                editCommentDatetextField.setText(CommentListTable.getValueAt(row, 3).toString());
            }
        });
    }

    protected void submitCommentAct(ActionEvent e) {
        int row = CommentListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的评语");
            return;
        }

        StudentComment comment = new StudentComment(0, 0, "", null);
        comment.setCommentId(Integer.parseInt(editCommentIDtextField.getText()));
        comment.setStudentId(Integer.parseInt(CommentListTable.getValueAt(row, 1).toString()));
        comment.setCommentContent(editCommentContenttextField.getText());

        // 获取评语时间字符串
        String commentDateString = editCommentDatetextField.getText();

        try {
            // 尝试将评语时间字符串解析为 Date 对象
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date utilDate = dateFormat.parse(commentDateString);

            // 将 utilDate 转换为 sqlDate
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // 设置评语日期
            comment.setCommentDate(sqlDate);
        } catch (ParseException ex) {
            // 如果日期字符串无法解析，则在这里处理异常
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "日期格式错误，请输入正确的日期格式（例如：yyyy-MM-dd）");
            return;
        }

        // 更新数据库中的评语信息
        StudentCommentDao commentDao = new StudentCommentDao();
        if (commentDao.updateStudentComment(comment)) {
            JOptionPane.showMessageDialog(this, "评语修改成功");
            setTable(new StudentComment(0, 0, "", null)); // 更新评语列表显示
        } else {
            JOptionPane.showMessageDialog(this, "评语修改失败");
        }
    }

    protected void deleteComment(ActionEvent e) {
        int row = CommentListTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的评语");
            return;
        }

        int commentID = Integer.parseInt(editCommentIDtextField.getText());
        int option = JOptionPane.showConfirmDialog(this, "确定删除该评语吗?");
        if (option == JOptionPane.OK_OPTION) {
            StudentCommentDao commentDao = new StudentCommentDao();
            if (commentDao.deleteStudentComment(commentID)) {
                JOptionPane.showMessageDialog(this, "评语删除成功");
                setTable(new StudentComment(0, 0, "", null)); // 更新评语列表显示
            } else {
                JOptionPane.showMessageDialog(this, "评语删除失败");
            }
        }
    }

    protected void searchComment(ActionEvent e) {
        String studentIDText = SearchCommentByStudentIDtextField.getText().trim();
        if (StringUtil.ifEmpty(studentIDText)) {
            JOptionPane.showMessageDialog(this, "请输入教师编号进行查询");
            return;
        }

        int studentID = Integer.parseInt(studentIDText);
        StudentComment searchCriteria = new StudentComment(0, 0, "", null);
        searchCriteria.setStudentId(studentID);

        setTable(searchCriteria);
    }

    private void setTable(StudentComment criteria) {
        DefaultTableModel model = (DefaultTableModel) CommentListTable.getModel();
        model.setRowCount(0); // 清空表格数据

        StudentCommentDao commentDao = new StudentCommentDao();
        List<StudentComment> commentList = commentDao.getStudentCommentList(criteria);
        for (StudentComment comment : commentList) {
            model.addRow(new Object[] {
                    comment.getCommentId(),
                    comment.getStudentId(),
                    comment.getCommentContent(),
                    comment.getCommentDate()
            });
        }
    }
}
