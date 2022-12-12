/*
 * Created by JFormDesigner on Sun Dec 11 14:05:04 EST 2022
 */

package hospital;

import hospital.AdminLogin;
import ui.CDC.CdcLogin;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AdCDCLogin extends JFrame {
    public AdCDCLogin() {
        initComponents();
    }

    private void admin(ActionEvent e) {
        // TODO add your code here
        new AdminLogin().setVisible(true);
    }

    private void CDC(ActionEvent e) {
        // TODO add your code here
        new hospital.CDCLogin().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Hospital/form");
        admin = new JButton();
        CDC = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- admin ----
        admin.setText(bundle.getString("AdCDCLogin.admin.text"));
        admin.addActionListener(e -> admin(e));

        //---- CDC ----
        CDC.setText(bundle.getString("AdCDCLogin.CDC.text"));
        CDC.addActionListener(e -> CDC(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(admin, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                    .addGap(99, 99, 99)
                    .addComponent(CDC, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(CDC, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(136, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton admin;
    private JButton CDC;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
