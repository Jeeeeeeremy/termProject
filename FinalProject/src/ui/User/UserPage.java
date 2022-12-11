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
public class UserPage extends javax.swing.JFrame {

    /**
     * Creates new form UserPage
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q ,i ,id;
    public UserPage() {
        initComponents();
        upDateDB();
        t2DateDB();
    }
    
    public UserPage(String em) {
        initComponents();
        jLabel1.setText(em);
        upDateDB();
        t2DateDB();
    }
    
    public void upDateDB(){
        
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("SELECT * FROM `population` where type='Doctor'");
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();
            q= stData.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel) tblDoctor.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Vector cdata = new Vector();
                
                for (i=1;i<=q;i++){
                    cdata.add(rs.getString("city"));
                    cdata.add(rs.getString("hospital"));
                    cdata.add(rs.getString("specialty"));
                    cdata.add(rs.getString("id"));
                    cdata.add(rs.getString("name"));
                    cdata.add(rs.getString("email"));
                    cdata.add(rs.getString("gender"));
                    
                    
                    
                }
                model.addRow(cdata);
                
            }
             
        }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
    }
    
    public void t2DateDB(){
        
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("SELECT t2.city,t2.hospital,t2.specialty,t2.name,t2.email,t2.gender,t1.recorddate,t1.diagnosis"
                    + " FROM hospital t1 join population t2 on t1.physician_ID=t2.id  where t1.user_id=? ORDER BY t1.recorddate ");
            pst.setString(1, jLabel1.getText());
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();
            q= stData.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel) tblt2.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Vector cdata = new Vector();
                
                for (i=1;i<=q;i++){
                    cdata.add(rs.getString("city"));
                    cdata.add(rs.getString("hospital"));
                    cdata.add(rs.getString("specialty"));
                    cdata.add(rs.getString("name"));
                    cdata.add(rs.getString("email"));
                    cdata.add(rs.getString("gender"));
                    cdata.add(rs.getString("recorddate"));
                    cdata.add(rs.getString("diagnosis"));
                    
                }
                model.addRow(cdata);
                
            }
             
        }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
    }
    
    
    public void search (String str){
        DefaultTableModel model = (DefaultTableModel) tblDoctor.getModel();
        model = (DefaultTableModel) tblDoctor.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tblDoctor.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str,cmbsearch.getSelectedIndex()));
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
        tblDoctor = new javax.swing.JTable();
        cmbsearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbtRecordDate = new javax.swing.JButton();
        txtRecordDate = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblt2 = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        tblDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "City", "Hospital", "Specialty", "Doctor_no", "Doctor_Name", "Email", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoctorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDoctor);

        cmbsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "City", "Hospital", "Specialty", "Doctor_Name", "Email", "Gender", " ", " " }));
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

        jbtRecordDate.setText("RecordDate");
        jbtRecordDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRecordDateActionPerformed(evt);
            }
        });

        txtRecordDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecordDateActionPerformed(evt);
            }
        });

        tblt2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "City", "Hospital", "Specialty", "Doctor_Name", "Email", "Gender", "Recorddate", "Diagnosis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblt2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblt2);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297)
                        .addComponent(BackBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtRecordDate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtRecordDate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtRecordDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRecordDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoctorMouseClicked
        
    }//GEN-LAST:event_tblDoctorMouseClicked

    private void cmbsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbsearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String ss = txtSearch.getText();
        search(ss);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jbtRecordDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRecordDateActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model=(DefaultTableModel) tblDoctor.getModel();
        int row = tblDoctor.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this,"Please check doctor document");
                return;
            }
        String hospital = model.getValueAt(row, 1).toString();
        String physician = model.getValueAt(row, 4).toString();
        String physician_ID = model.getValueAt(row, 3).toString();
        String specialty = model.getValueAt(row, 2).toString();
        String physician_email = model.getValueAt(row, 5).toString();
            
        try{
            
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("insert into hospital(user_id,hospital,physician,physician_ID,status,specialty,recorddate,physician_email)value(?,?,?,?,?,?,?,?)");
            pst.setString(1,jLabel1.getText());
            pst.setString(2,hospital);
            pst.setString(3,physician);
            pst.setString(4,physician_ID);
            pst.setString(5,"1"); // guahao
            pst.setString(6,specialty);
            pst.setString(7,txtRecordDate.getText());
            pst.setString(8,physician_email);
            pst.executeUpdate();
            t2DateDB();

            }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
    }//GEN-LAST:event_jbtRecordDateActionPerformed

    private void txtRecordDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecordDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecordDateActionPerformed

    private void tblt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblt2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblt2MouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        Login mjf = new Login();
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JComboBox<String> cmbsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtRecordDate;
    private javax.swing.JTable tblDoctor;
    private javax.swing.JTable tblt2;
    private javax.swing.JTextField txtRecordDate;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
