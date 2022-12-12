/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package government;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import utils.JDBCUtil;

/**
 *
 * @author judy
 */
public class Govpresent extends javax.swing.JFrame {

    /**
     * Creates new form Govpresent
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q ,i ,id;
    public Govpresent() {
        initComponents();
        upDateDB();
        piechart();
        barchart();
    }
    
    public void barchart(){
        
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("select \n" +
"sum(case when disease like '%covid%' then case_number else 0 end) as covid \n" +
",sum(case when disease like '%dead%' or disease like '%death%'  then case_number else 0 end) as death\n" +
",sum(case when disease not REGEXP 'covid|dead|death' then case_number else 0 end) as other\n" +
"from warning\n" +
"");
            rs = pst.executeQuery();
            
            while(rs.next()){
                int a = rs.getInt("covid");
                int b = rs.getInt("death");
                int c = rs.getInt("other");
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
                dataset.addValue(a, "Number", "covid");
                dataset.addValue(b, "Number", "death");
                dataset.addValue(c, "Number", "other");


                JFreeChart chart = ChartFactory.createBarChart("Number", "disease", "num", dataset, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);

                CategoryPlot barPlot =chart.getCategoryPlot();
                
                
                //4、水平底部列表
		CategoryAxis axis = barPlot.getDomainAxis();
		axis.setLabelFont(new Font("黑体", Font.BOLD, 14));			//水平底部标题
		axis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));		//垂直标题
		
		//5、获取柱状
		ValueAxis rangeAxis = barPlot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));
                

                barPlot.setBackgroundPaint(Color.white);

                ChartPanel cp = new ChartPanel(chart);

                jPbar.removeAll();
                jPbar.add(cp,BorderLayout.CENTER);
                jPbar.validate();
            }
            
        }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
    }
    
    public void piechart(){
        
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("select \n" +
"sum(case when disease like '%covid%' then case_number else 0 end) as covid \n" +
",sum(case when disease like '%dead%' or disease like '%death%'  then case_number else 0 end) as death\n" +
",sum(case when disease not REGEXP 'covid|dead|death' then case_number else 0 end) as other\n" +
"from warning\n" +
"");
            rs = pst.executeQuery();
            
            while(rs.next()){
                int a = rs.getInt("covid");
                int b = rs.getInt("death");
                int c = rs.getInt("other");
                DefaultPieDataset piedataset = new DefaultPieDataset();
            
                piedataset.setValue("covid", a);
                piedataset.setValue("death", b);
                piedataset.setValue("other", c);


                JFreeChart pieChart = ChartFactory.createPieChart("Number", piedataset, true,true,true);

                PiePlot piePlot =(PiePlot) pieChart.getPlot();

//                piePlot.setSectionPaint(1, Color.);
//                piePlot.setSectionPaint(2, Color.RED);
//                piePlot.setSectionPaint(3, Color.GREEN);

                piePlot.setBackgroundPaint(Color.white);

                ChartPanel cp = new ChartPanel(pieChart);

                jPpie.removeAll();
                jPpie.add(cp,BorderLayout.CENTER);
                jPpie.validate();
            }
            
        }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
    }
    
    public void upDateDB(){
        
        try{
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement("select \n" +
"disease as a ,case_number as b\n" +
"from warning");
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();
            q= stData.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel) tblGov.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Vector cdata = new Vector();
                
                for (i=1;i<=q;i++){
                    
                    cdata.add(rs.getString("a"));
                    cdata.add(rs.getString("b"));
                }
                model.addRow(cdata);
                
            }
             
        }catch(Exception e ){
                JOptionPane.showMessageDialog(this, e.getMessage());
                
            }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblGov = new javax.swing.JTable();
        jPpie = new javax.swing.JPanel();
        jPbar = new javax.swing.JPanel();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblGov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "disease   ", "Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGovMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGov);

        jPpie.setLayout(new java.awt.BorderLayout());

        jPbar.setLayout(new java.awt.BorderLayout());

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jPpie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(jPbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPpie, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(jPbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGovMouseClicked
        // TODO add your handling code here:
        //鼠标点击选中表格中一行信息可像是在文本字段中。
        
    }//GEN-LAST:event_tblGovMouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        GovLogin mjf = new GovLogin();
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
            java.util.logging.Logger.getLogger(Govpresent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Govpresent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Govpresent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Govpresent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Govpresent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JPanel jPbar;
    private javax.swing.JPanel jPpie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGov;
    // End of variables declaration//GEN-END:variables
}
