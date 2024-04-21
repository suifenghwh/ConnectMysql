package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClassManageFrm extends JInternalFrame {

    private JPanel contentPane;
    private JTextField ClassNametextField;
    private JTable ClassListTable;


    public ClassManageFrm() {
        setClosable(true);
        setIconifiable(true);
        setBounds(100, 100, 571, 495);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0:");

        ClassNametextField = new JTextField();
        ClassNametextField.setColumns(10);

        JButton searchButton = new JButton("\u67E5\u8BE2");

        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(89)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addGap(33)
                                                .addComponent(ClassNametextField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                                .addGap(44)
                                                .addComponent(searchButton)))
                                .addContainerGap(116, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(41)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(ClassNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addGap(60))
        );

        ClassListTable = new JTable();
        ClassListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u73ED\u7EA7ID", "\u73ED\u7EA7\u540D\u79F0", "\u5E74\u7EA7", "\u73ED\u4E3B\u4EFB"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    true, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(ClassListTable);
        contentPane.setLayout(gl_contentPane);
    }
}