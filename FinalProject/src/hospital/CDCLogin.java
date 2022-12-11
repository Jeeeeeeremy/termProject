/*
 * Created by JFormDesigner on Tue Dec 06 18:11:06 EST 2022
 */

package hospital;

import ui.CDC.DAO;
import ui.CDC.User;
import ui.CDC.adminView;
import ui.CDC.displayRecord;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class CDCLogin extends JFrame {
    DAO dao = new DAO();
    public CDCLogin() {
        initComponents();
    }

    private void login(ActionEvent e) {
        // TODO add your code here

            //if existed
            User user = dao.queryHospitalCDCbyEmail(username.getText(),password.getText());
            if (user==null){
                JOptionPane.showMessageDialog(new JDialog(), ":no such user");
                return;
            }
            new hospitalCDC().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("hospital/form");
        label1 = new JLabel();
        label2 = new JLabel();
        username = new JTextField();
        password = new JPasswordField();
        login = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("CDCLogin.label1.text"));

        //---- label2 ----
        label2.setText(bundle.getString("CDCLogin.label2.text"));

        //---- login ----
        login.setText(bundle.getString("CDCLogin.login.text_2"));
        login.addActionListener(e -> login(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addGap(97, 97, 97)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(login)
                        .addComponent(password, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                        .addComponent(username, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(182, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(74, 74, 74)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(62, 62, 62)
                    .addComponent(login)
                    .addContainerGap(69, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
