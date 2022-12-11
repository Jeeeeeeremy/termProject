/*
 * Created by JFormDesigner on Tue Dec 06 14:24:23 EST 2022
 */

package hospital;

import java.awt.event.*;
import ui.CDC.DAO;
import ui.CDC.Record;

import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author unknown
 */
public class hospitalCDC extends JFrame {
    private String[] colunms;
    private String[][] data;
    private DAO dao = new DAO();
    boolean status = false;
    public hospitalCDC() {
        initComponents();
        prepareTable();
        statusFilter.addItem("");
        statusFilter.setSelectedItem("");
        statusFilter.addItem("waiting for decision");
        statusFilter.addItem("case processing by CDC");
        statusFilter.addItem("CDC disagrees");
        statusFilter.addItem("CDC consents");
        statusFilter.addItem("government notified");
    }

    private void prepareTable(){
        colunms = new String[]{"ID","hospital","physician","diagnosis","treatment","body temperature","blood pressure","patient name","date","CDC response"};
        List<Record> records = dao.queryRawRecords();
        int size = records.size();
        data = new String[size][colunms.length];
        int index = 0;

        for (Record r:
                records) {
            String res = r.getReportToCDC();
            if (res.equals("0")&&r.getCDCResponse()==null)
                res = "waiting for decision";
            if (res.equals("1")&&r.getCDCResponse()==null)
                res = "case processing by CDC";
            if (res.equals("0")&&r.getCDCResponse().equals("0"))
                res = "CDC disagrees";
            if (res.equals("1")&&r.getCDCResponse().equals("1"))
                res = "CDC consents";
            if (res.equals("1")&&r.getCDCResponse().equals("2"))
                res = "government notified";
            data[index][0] = r.getId();
            data[index][1] = r.getHospital();
            data[index][2] = r.getPhysician();
            data[index][3] = r.getDiagnosis();
            data[index][4] = r.getTreatment();
            data[index][5] = r.getTemperature();
            data[index][6] = r.getBlood_pressure();
            data[index][7] = r.getUser_name();
            data[index][8] = r.getRecorddate();
            data[index][9] = res;
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

    private void prepareTable(String value){
        colunms = new String[]{"ID","hospital","physician","diagnosis","treatment","body temperature","blood pressure","patient name","date"};
        List<Record> records = null;
        if (value.equals("waiting for decision"))
            records = dao.queryRecordsByStatus("0");
        if (value.equals("case processing by CDC"))
            records = dao.queryRecordsByStatus("1");
        if (value.equals("CDC disagrees"))
            records = dao.queryRecordsByStatus("0","0");
        if (value.equals("CDC consents"))
            records = dao.queryRecordsByStatus("1","1");
        if (value.equals("government notified"))
            records = dao.queryRecordsByStatus("1","2");

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

    private void button1(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String ID =(String)tempmodel.getValueAt(selected_row,0);
        if (tempmodel.getColumnCount()>=10){
            String status = (String)tempmodel.getValueAt(selected_row,9);
            if (!status.equals("waiting for decision")){
                JOptionPane.showMessageDialog(new JDialog(), ":case has been processed");
                return;
            }
        }else {
            if (status&&!statusFilter.getSelectedItem().toString().equals("waiting for decision")){
                JOptionPane.showMessageDialog(new JDialog(), ":case has been processed");
                return;
            }
        }
        dao.updateReport(Integer.valueOf(ID));
        if (status){
            prepareTable(statusFilter.getSelectedItem().toString());
            return;
        }
        prepareTable();
    }

    private void apply(ActionEvent e) {
        // TODO add your code here
        status = true;
        prepareTable(statusFilter.getSelectedItem().toString());
    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        prepareTable();
        statusFilter.setSelectedItem("");
        status = false;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("hospital/form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        label1 = new JLabel();
        statusFilter = new JComboBox();
        apply = new JButton();
        reset = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText(bundle.getString("CDCLogin.button1.text"));
        button1.addActionListener(e -> button1(e));

        //---- label1 ----
        label1.setText(bundle.getString("CDCLogin.label1.text_2"));

        //---- apply ----
        apply.setText(bundle.getString("CDCLogin.apply.text"));
        apply.addActionListener(e -> apply(e));

        //---- reset ----
        reset.setText(bundle.getString("CDCLogin.reset.text"));
        reset.addActionListener(e -> reset(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1478, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(label1)
                            .addGap(27, 27, 27)
                            .addComponent(statusFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(apply)
                            .addGap(63, 63, 63)
                            .addComponent(reset)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(statusFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(apply)
                        .addComponent(reset))
                    .addGap(30, 30, 30)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(91, 91, 91))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    private JComboBox statusFilter;
    private JButton apply;
    private JButton reset;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
