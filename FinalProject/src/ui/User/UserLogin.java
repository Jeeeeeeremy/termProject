/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.User;
import Admin.MainJFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import utils.JDBCUtil;
/**
 *
 * @author judy
 */
public class UserLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public UserLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jpwpass = new javax.swing.JPasswordField();
        lblName = new javax.swing.JLabel();
        lblEmployeeId = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblEmployeeId1 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("UserLogin");
        lblTitle.setToolTipText("");

        jpwpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpwpassActionPerformed(evt);
            }
        });

        lblName.setText("Email Address:");

        lblEmployeeId.setText("Password");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "User", "Admin", " " }));

        lblEmployeeId1.setText("type");

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmployeeId)
                            .addComponent(jpwpass, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmployeeId1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BackBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                        .addGap(0, 239, Short.MAX_VALUE))
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmployeeId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpwpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmployeeId1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpwpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpwpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpwpassActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String email = txtEmail.getText().toString();
        String password = jpwpass.getText().toString();
        String option = jComboBox1.getSelectedItem().toString();
        
        if(email.equals("")||password.equals("")||option.equals("Select")){
            JOptionPane.showMessageDialog(this, "Error");
        }else{
            
            try {
//                con = DriverManager.getConnection("")
                con = JDBCUtil.getConnection();
                pst = con.prepareStatement("SELECT * FROM `population` where email=? AND password =?");
                pst.setString(1,email);
                pst.setString(2, password);
                rs = pst.executeQuery();

                if(rs.next()){
                    String s1 = rs.getString("type");
                    String em = rs.getString("email");       
                    String name = rs.getString("name");       
                    String userid = rs.getString("id");
                    if(option.equalsIgnoreCase("Admin")&&s1.equalsIgnoreCase("Admin")){
                        UserAdminPage ad = new UserAdminPage(name);
                        ad.setVisible(true);
                        this.setVisible(false);
                        
                    } else if (option.equalsIgnoreCase("User")&&s1.equalsIgnoreCase("User")){
                        UserPage up = new UserPage(userid);
                        up.setVisible(true);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong Password");
                    }
                
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Information");
                }
//                con.close();
            }
            catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                txtEmail.setText("");
                jpwpass.setText("");
            }
            
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        MainJFrame mjf = new MainJFrame();
        mjf.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPasswordField jpwpass;
    private javax.swing.JLabel lblEmployeeId;
    private javax.swing.JLabel lblEmployeeId1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
