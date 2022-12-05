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
    
   
    public displayRecord() {
        initComponents();
    }

    private void prepareTable(){
        colunms = new String[]{"ID","hospital","physician","symptom","treatment","body temperature","blood pressure","patient name","date"};
        int size = 0;
//        for (String key:
//                doctors.keySet()){
//            size+=doctors.get(key).size();
//        }
        data = new String[size][colunms.length];
        int index = 0;
//        for (String hospital:
//                hospitals) {
//            if (doctors.containsKey(hospital)&&doctors.get(hospital).size()>0){
//                for (Doctor doctor:
//                        doctors.get(hospital)) {
//                    data[index][0] = curAdmin.getCurCom();
//                    data[index][1] = hospital;
//                    data[index][2] = doctor.getName();
//                    index++;
//                }
//            }
//        }
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
        String userID =(String)tempmodel.getValueAt(selected_row,1);
        dao.updateAgreement(1);
    }

    private void ignore(ActionEvent e) {
        // TODO add your code here
//        int selected_row = table1.getSelectedRow();
//        if (selected_row<0){
//            JOptionPane.showMessageDialog(new JDialog(), ":please select one row to view");
//            return;
//        }
//        TableModel tempmodel = table1.getModel();
//        String userID =(String)tempmodel.getValueAt(selected_row,1);
        dao.updateIgnore(1);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("ui/cdc/form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        agree = new JButton();
        ignore = new JButton();

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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(134, 134, 134)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(ignore)
                                .addComponent(agree))))
                    .addContainerGap(92, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
                    .addGap(61, 61, 61)
                    .addComponent(agree)
                    .addGap(58, 58, 58)
                    .addComponent(ignore)
                    .addContainerGap(119, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
