/*
 * Created by JFormDesigner on Sun Dec 11 13:21:00 EST 2022
 */

package government;

import ui.CDC.DAO;
import ui.CDC.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class GovLogin extends JFrame {
    DAO dao = new DAO();
    public GovLogin() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        if (!admin.isSelected()&&!present.isSelected()){
            JOptionPane.showMessageDialog(new JDialog(), ":select your role");
            return;
        }
        if (admin.isSelected()){
            // TODO add your code here
            if (userName.getText().length()==0||
                    password.getPassword().toString().length()==0){
                JOptionPane.showMessageDialog(new JDialog(), ":enter your username and password");
                return;
            }
            User user = dao.queryGov(userName.getText(),password.getText());
            if (user==null){
                JOptionPane.showMessageDialog(new JDialog(), "no such user");
                return;
            }
            new display().setVisible(true);
        }else if (present.isSelected()){
            if (userName.getText().length()==0||
                    password.getPassword().toString().length()==0){
                JOptionPane.showMessageDialog(new JDialog(), ":enter your username and password");
                return;
            }
            User user = dao.queryGovPre(userName.getText(),password.getText());
            if (user==null){
                JOptionPane.showMessageDialog(new JDialog(), "no such user");
                return;
            }
            new Govpresent().setVisible(true);
            //present
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("government/form");
        label1 = new JLabel();
        label2 = new JLabel();
        userName = new JTextField();
        password = new JPasswordField();
        button1 = new JButton();
        label3 = new JLabel();
        admin = new JRadioButton();
        present = new JRadioButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("GovLogin.label1.text"));

        //---- label2 ----
        label2.setText(bundle.getString("GovLogin.label2.text"));

        //---- button1 ----
        button1.setText(bundle.getString("GovLogin.button1.text"));
        button1.addActionListener(e -> button1(e));

        //---- label3 ----
        label3.setText(bundle.getString("GovLogin.label3.text"));

        //---- admin ----
        admin.setText(bundle.getString("GovLogin.admin.text"));

        //---- present ----
        present.setText(bundle.getString("GovLogin.present.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2))
                            .addGap(83, 83, 83)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(userName, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(password, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(223, 223, 223)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(172, 172, 172)
                            .addComponent(label3)
                            .addGap(46, 46, 46)
                            .addComponent(admin)
                            .addGap(36, 36, 36)
                            .addComponent(present)))
                    .addContainerGap(143, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(admin)
                        .addComponent(present))
                    .addGap(52, 52, 52)
                    .addComponent(button1)
                    .addGap(73, 73, 73))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(admin);
        buttonGroup1.add(present);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField userName;
    private JPasswordField password;
    private JButton button1;
    private JLabel label3;
    private JRadioButton admin;
    private JRadioButton present;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
