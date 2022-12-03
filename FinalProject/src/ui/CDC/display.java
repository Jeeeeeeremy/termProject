/*
 * Created by JFormDesigner on Fri Dec 02 21:30:55 EST 2022
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
public class display extends JFrame {
    private String[] colunms;
    private String[][] data;
    private DAO dao = new DAO();
    public display() {
        initComponents();
        prepareTable();
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
        ResourceBundle bundle = ResourceBundle.getBundle("ui/CDC/form");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText(bundle.getString("display.button1.text"));
        button1.addActionListener(e -> agree(e));

        //---- button2 ----
        button2.setText(bundle.getString("display.button2.text"));
        button2.addActionListener(e -> ignore(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button2)
                                .addComponent(button1))))
                    .addContainerGap(75, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(button1)
                    .addGap(38, 38, 38)
                    .addComponent(button2)
                    .addContainerGap(168, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
