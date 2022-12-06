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
    public hospitalCDC() {
        initComponents();
        prepareTable();
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
            if (res.equals("0"))
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

    private void button1(ActionEvent e) {
        // TODO add your code here
        int selected_row = table1.getSelectedRow();
        if (selected_row<0){
            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
            return;
        }
        TableModel tempmodel = table1.getModel();
        String ID =(String)tempmodel.getValueAt(selected_row,0);
        String status = (String)tempmodel.getValueAt(selected_row,9);
        if (!status.equals("waiting for decision")){
            JOptionPane.showMessageDialog(new JDialog(), ":case has been processed");
            return;
        }
        dao.updateReport(Integer.valueOf(ID));
        prepareTable();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("hospital/form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText(bundle.getString("CDCLogin.button1.text"));
        button1.addActionListener(e -> button1(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(button1)
                    .addContainerGap(1277, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1472, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addComponent(button1)
                    .addContainerGap(253, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
