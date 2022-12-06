/*
 * Created by JFormDesigner on Mon Dec 05 16:38:54 EST 2022
 */

package ui.CDC;

import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

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
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("ui/CDC/form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label1 = new JLabel();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText(bundle.getString("adminView.button1.text"));

        //---- button2 ----
        button2.setText(bundle.getString("adminView.button2.text"));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }

        //---- label1 ----
        label1.setText(bundle.getString("adminView.label1.text"));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 15f));

        //---- button3 ----
        button3.setText(bundle.getString("adminView.button3.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1425, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(337, 337, 337)
                    .addComponent(button3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(113, 113, 113))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(button1)
                    .addGap(32, 32, 32)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 459, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(183, 183, 183))
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
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(232, 232, 232)
                            .addComponent(button3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(label1)
                            .addGap(28, 28, 28)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(70, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
