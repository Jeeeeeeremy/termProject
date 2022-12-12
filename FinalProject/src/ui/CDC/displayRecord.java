/*
 * Created by JFormDesigner on Sun Dec 04 21:31:13 EST 2022
 */

package ui.CDC;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author unknown
 */
public class displayRecord extends JFrame {


    private String[] colunms;
    private String[][] data;
    private DAO dao = new DAO();
    
    private User user;
    public displayRecord(User user) {
        initComponents();
        this.user = user;
        prepareTable();
        filterItem.addItem("");
        filterItem.addItem("diagnosis");
        filterItem.addItem("hospital");
        filterItem.addItem("treatment");
        filterItem.setSelectedItem("");
    }

    private void prepareTable(){
        colunms = new String[]{"ID","hospital","physician","diagnosis","treatment","body temperature","blood pressure","patient name","date"};
        List<Record> records = dao.queryRecords();
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

    private void prepareTable(String item, String value){
        colunms = new String[]{"ID","hospital","physician","diagnosis","treatment","body temperature","blood pressure","patient name","date"};
        List<Record> records = dao.queryRecordsWithFilter(item, value);
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

    private void agree(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String ID =(String)tempmodel.getValueAt(selected_row,0);
        dao.updateAgreement(Integer.valueOf(ID));
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
        dao.updateIgnore(Integer.valueOf(ID));
        prepareTable();
    }

    private void apply(ActionEvent e) {
        prepareTable(filterItem.getSelectedItem().toString(),value.getText());
    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        prepareTable();
        value.setText("");

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        agree = new JButton();
        ignore = new JButton();
        label1 = new JLabel();
        filterItem = new JComboBox();
        value = new JTextField();
        label2 = new JLabel();
        apply = new JButton();
        reset = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- agree ----
        agree.setText(bundle.getString("displayRecord.agree.text"));
        agree.addActionListener(e -> agree(e));

        //---- ignore ----
        ignore.setText(bundle.getString("displayRecord.ignore.text"));
        ignore.addActionListener(e -> ignore(e));

        //---- label1 ----
        label1.setText(bundle.getString("displayRecord.label1.text"));

        //---- label2 ----
        label2.setText(bundle.getString("displayRecord.label2.text"));

        //---- apply ----
        apply.setText(bundle.getString("displayRecord.apply.text"));
        apply.addActionListener(e -> apply(e));

        //---- reset ----
        reset.setText(bundle.getString("displayRecord.reset.text"));
        reset.addActionListener(e -> reset(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(92, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(ignore)
                        .addComponent(agree)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1196, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(51, 51, 51)
                            .addComponent(filterItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(value, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(apply)
                            .addGap(52, 52, 52)
                            .addComponent(reset)))
                    .addGap(40, 40, 40))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(filterItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(apply)
                        .addComponent(reset))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
                    .addGap(81, 81, 81)
                    .addComponent(agree)
                    .addGap(45, 45, 45)
                    .addComponent(ignore)
                    .addGap(52, 52, 52))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton agree;
    private JButton ignore;
    private JLabel label1;
    private JComboBox filterItem;
    private JTextField value;
    private JLabel label2;
    private JButton apply;
    private JButton reset;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
