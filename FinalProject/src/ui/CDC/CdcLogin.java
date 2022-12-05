/*
 * Created by JFormDesigner on Fri Dec 02 21:28:07 EST 2022
 */

package ui.CDC;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class CdcLogin extends JFrame {
    public CdcLogin() {
        initComponents();
    }

    private void login(ActionEvent e) {
        // TODO add your code here
        if (!admin.isSelected()&&!staff.isSelected()){
            JOptionPane.showMessageDialog(new JDialog(), ":please specify your role");
            return;
        }
        if (admin.isSelected()){
            //admin login
        }else {
            //if existed
            new displayRecord().setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("ui/cdc/form");
        login = new JButton();
        label1 = new JLabel();
        userName = new JTextField();
        label2 = new JLabel();
        passWord = new JTextField();
        label3 = new JLabel();
        admin = new JRadioButton();
        staff = new JRadioButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- login ----
        login.setText(bundle.getString("CdcLogin.login.text"));
        login.addActionListener(e -> login(e));

        //---- label1 ----
        label1.setText(bundle.getString("CdcLogin.label1.text"));

        //---- label2 ----
        label2.setText(bundle.getString("CdcLogin.label2.text"));

        //---- label3 ----
        label3.setText(bundle.getString("CdcLogin.label3.text"));

        //---- admin ----
        admin.setText(bundle.getString("CdcLogin.admin.text"));

        //---- staff ----
        staff.setText(bundle.getString("CdcLogin.staff.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userName, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                        .addComponent(passWord, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(admin)
                                    .addGap(26, 26, 26)
                                    .addComponent(staff))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(232, 232, 232)
                            .addComponent(login)))
                    .addContainerGap(119, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(passWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(staff)
                        .addComponent(admin))
                    .addGap(15, 15, 15)
                    .addComponent(login)
                    .addContainerGap(132, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- role ----
        var role = new ButtonGroup();
        role.add(admin);
        role.add(staff);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton login;
    private JLabel label1;
    private JTextField userName;
    private JLabel label2;
    private JTextField passWord;
    private JLabel label3;
    private JRadioButton admin;
    private JRadioButton staff;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
