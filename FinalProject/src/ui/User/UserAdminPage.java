/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.User;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.JDBCUtil;

/**
 *
 * @author judy
 */
public class UserAdminPage extends javax.swing.JFrame {

    /**
     * Creates new form UserAdminPage
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q ,i ,id;
    
    public UserAdminPage() {
        initComponents();
        upDateDB();
        
    }
    public UserAdminPage(String em) {
        initComponents();
        jLabel1.setText(em);
        upDateDB();
    }
    public void upDateDB(){
        
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("SELECT * FROM `population`");
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();
            q= stData.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Vector cdata = new Vector();
                
                for (i=1;i<=q;i++){
                    cdata.add(rs.getString("id"));
                    cdata.add(rs.getString("name"));
                    cdata.add(rs.getString("type"));
                    cdata.add(rs.getString("email"));
                    cdata.add(rs.getString("gender"));
                }
                model.addRow(cdata);
                
            }
             
        }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
        
    }
    
    public void search (String str){
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model = (DefaultTableModel) tblUser.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tblUser.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str,cmbsearch.getSelectedIndex()+1));
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        cmbsearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbtAdd = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jbtUpdate = new javax.swing.JButton();
        jbtDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComType = new javax.swing.JComboBox<>();
        jComGender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Type", "Email", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        cmbsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Type", "Email", "Gender" }));
        cmbsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbsearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel2.setText("search");

        jbtAdd.setText("Add New User");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jbtUpdate.setText("Update User");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });

        jbtDelete.setText("Delete User");
        jbtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("id");

        jLabel4.setText("name");

        jLabel5.setText("Type");

        jLabel6.setText("Email");

        jLabel7.setText("Gender");

        jComType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin", "Doctor" }));

        jComGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Not to say" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComType, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(79, 79, 79)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbtAdd)
                                            .addComponent(jbtUpdate)
                                            .addComponent(jbtDelete))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jComType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbtAdd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbtUpdate)
                            .addGap(33, 33, 33))
                        .addComponent(jbtDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        //鼠标点击选中表格中一行信息可像是在文本字段中。
                DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
        //        //定义变量row为鼠标点击的行数。
                int row=tblUser.getSelectedRow();
        //函数getValueAt返回要查询的行和列处单元格的属性值
                  txtID.setText(model.getValueAt(row, 0).toString());
                  txtname.setText(model.getValueAt(row, 1).toString());
                  jComType.setSelectedItem(model.getValueAt(row, 2).toString());
                  txtemail.setText(model.getValueAt(row, 3).toString());
                  jComGender.setSelectedItem(model.getValueAt(row, 4).toString());

    }//GEN-LAST:event_tblUserMouseClicked

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        // TODO add your handling code here:
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("insert into population(id,name,type,email,gender)value(?,?,?,?,?)");
            pst.setString(1,txtID.getText());
            pst.setString(2,txtname.getText());
            pst.setString(3,jComType.getSelectedItem().toString());
            pst.setString(4,txtemail.getText());
            pst.setString(5,jComGender.getSelectedItem().toString());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Add Successfully");
            upDateDB();
                    
            }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
        

        
    }//GEN-LAST:event_jbtAddActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
        // TODO add your handling code here:
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("update population set name=? , type=? , email=? , gender=?  where id=?");
            pst.setString(1,txtname.getText());
            pst.setString(2,jComType.getSelectedItem().toString());
            pst.setString(3,txtemail.getText());
            pst.setString(4,jComGender.getSelectedItem().toString());
            pst.setString(5,txtID.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Update Successfully");
            upDateDB();
                    
            }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
        int row=tblUser.getSelectedRow();
        try{
                id = Integer.parseInt(model.getValueAt(row, 0).toString());
                int deleteItem = JOptionPane.showConfirmDialog(this, "Confirm if you want to delete item"
                    ,"Warning",JOptionPane.YES_NO_OPTION);
                if (deleteItem == JOptionPane.YES_OPTION){
                    con = JDBCUtil.getConnection();
                    pst = con.prepareStatement("delete from population where id=? ");
                    pst.setInt(1,id);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Delete Successfully");
                    upDateDB();
                }
            
            
            }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
    }//GEN-LAST:event_jbtDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String ss = txtSearch.getText();
        search(ss);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmbsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbsearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbsearch;
    private javax.swing.JComboBox<String> jComGender;
    private javax.swing.JComboBox<String> jComType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
