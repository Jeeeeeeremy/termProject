/*
 * Created by JFormDesigner on Mon Dec 05 16:38:54 EST 2022
 */

package ui.CDC;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.time.LocalDate;
/**
 * @author unknown
 */
public class adminView extends JFrame {
    DAO dao = new DAO();

    public adminView() {
        initComponents();
        prepareTable();
        prepareTable2();
    }
    private void prepareTable(){
        String[] colunms;
        String[][] data;
        colunms = new String[]{"ID","hospital","physician","diagnosis","treatment","body temperature","blood pressure","patient name","date"};
        List<Record> records = dao.queryReportedRecords();
        int size = records.size();
        data = new String[size][colunms.length];
        int index = 0;
        for (Record r:
                records) {
            data[index][0] = r.getId();
            data[index][1] = r.getHospital();
            data[index][2] = r.getPhysician();
            data[index][3] = r.getDiagnosis();
            data[index][4] = r.getTreatment();
            data[index][5] = r.getTemperature();
            data[index][6] = r.getBlood_pressure();
            data[index][7] = r.getUser_name();
            data[index][8] = r.getRecorddate();
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(data,colunms);
        table1 = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane1.setViewportView(table1);
    }

    private void prepareTable2(){
        String[] colunms;
        String[][] data;
        colunms = new String[]{"disease","amount"};
        List<Stats> stats = dao.queryStats();
        int size = stats.size();
        data = new String[size][colunms.length];
        int index = 0;
        for (Stats s:
                stats) {
            data[index][0] = s.getName();
            data[index][1] = s.getCount();
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(data,colunms);
        table2 = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane2.setViewportView(table2);
    }

    private void report(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String ID =(String)tempmodel.getValueAt(selected_row,0);
        dao.updateAgreementAdmin(Integer.valueOf(ID));
        prepareTable();
    }

    private void ignore(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String ID =(String)tempmodel.getValueAt(selected_row,0);
        dao.updateIgnoreAdmin(Integer.valueOf(ID));
        prepareTable();
    }

    private void warning(ActionEvent e) {
        // TODO add your code here
        int selected_row = table2.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table2.getModel();
        String disease =(String)tempmodel.getValueAt(selected_row,0);
        Date d = new Date();
        String date = null;
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        date = sdf.format(d);

        String number =(String)tempmodel.getValueAt(selected_row,1);
        warningBoard.setText("<html><body> " +
                "<br>Date: " +date+
                "<br>Disease: " +disease+
                "<br>case count: " +number+
                "<body></html>"
        );
        //report to government
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        report = new JButton();
        ignore = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label1 = new JLabel();
        warning = new JButton();
        label2 = new JLabel();
        warningBoard = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- report ----
        report.setText(bundle.getString("adminView.report.text"));
        report.addActionListener(e -> report(e));

        //---- ignore ----
        ignore.setText(bundle.getString("adminView.ignore.text"));
        ignore.addActionListener(e -> ignore(e));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }

        //---- label1 ----
        label1.setText(bundle.getString("adminView.label1.text"));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 15f));

        //---- warning ----
        warning.setText(bundle.getString("adminView.warning.text"));
        warning.addActionListener(e -> warning(e));

        //---- label2 ----
        label2.setText(bundle.getString("adminView.label2.text"));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 13f));

        //---- warningBoard ----
        warningBoard.setFont(warningBoard.getFont().deriveFont(warningBoard.getFont().getSize() + 10f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(report)
                    .addGap(32, 32, 32)
                    .addComponent(ignore, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(183, 183, 183))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1425, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(warningBoard, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                            .addComponent(warning)
                            .addGap(36, 36, 36))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(209, 209, 209)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 501, Short.MAX_VALUE)))
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(113, 113, 113))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(report)
                                .addComponent(ignore))
                            .addGap(84, 84, 84)
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(warningBoard, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(label1)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(160, 160, 160)
                                    .addComponent(warning)))))
                    .addContainerGap(70, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton report;
    private JButton ignore;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label1;
    private JButton warning;
    private JLabel label2;
    private JLabel warningBoard;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
