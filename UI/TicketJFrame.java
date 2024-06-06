/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Models.Schedule;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import Models.Ticket;
import Models.Users;
import Modify.TicketModify;
import java.util.ArrayList;
import java.util.List;
import Modify.Utility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class TicketJFrame extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<Ticket> TicketList;
    Ticket ticket;
    int currentIndex = -1;

    /**
     * Creates new form TicketJFrame
     */
    public TicketJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        TicketList = new ArrayList<>();
        tableModel = (DefaultTableModel) TicketTbl.getModel();
        showTicket();
        getDateCB();
    }

    private void showTicket() {

        TicketList = Modify.TicketModify.getAll();
        List<Users> userList;
        List<Schedule> scheList;
        tableModel.setRowCount(0);
        float totalPrice = 0;
        for (Ticket ticket : TicketList) {
            userList = Modify.UserModify.getListNameByID(ticket.getUser_id());
            for (Users u : userList) {
                scheList = Modify.ScheduleModify.getSchedulebyID(ticket.getSchedule_id());
                for (Schedule sc : scheList) {
                    String total = Utility.getPrice(ticket.getTotal());
                    tableModel.addRow(new Object[]{
                        tableModel.getRowCount() + 1,
                        u.getFullname(),
                        sc.getMovie_id().getTitle(),
                        ticket.getSeat_code(),
                        sc.getRoom_id().getRoom(),
                        sc.getTime_id().getTime(),
                        total + " VND",
                        ticket.getCreated_at()
                    });
                }
            }
            totalPrice += ticket.getTotal();
        }
        TotalpriceTxt.setText(Utility.getPrice(totalPrice) + " VND");
    }

    private void getDateCB() {
        List<String> sortList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        TicketList = Modify.TicketModify.getAll();

        for (Ticket t : TicketList) {
            Date date = new Date();
            try {
                date = sdf.parse(t.getCreated_at());

            } catch (ParseException ex) {
                Logger.getLogger(TicketJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!sortList.contains(sdf.format(date))) {
                sortList.add(sdf.format(date));
            }
        }
        for (String s : sortList) {
            dateCB.addItem(s);
        }
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public static void Print(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Save file successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error!!");
            }
        }
    }

    @Override
    public void pack() {
        super.pack(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TicketTbl = new javax.swing.JTable();
        BtnFind = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TotalpriceTxt = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        dateCB = new javax.swing.JComboBox<>();
        sortBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        wipeBtn = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_movie_ticket_60px.png"))); // NOI18N
        jLabel1.setText("Ticket Management");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        TicketTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Staff", "Title", "Seat", "Room", "Time", "Total", "Created_at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TicketTbl);

        BtnFind.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_search_30px_2.png"))); // NOI18N
        BtnFind.setText("Search");
        BtnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFindActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Total Price: ");

        TotalpriceTxt.setEditable(false);
        TotalpriceTxt.setBackground(new java.awt.Color(255, 255, 255));
        TotalpriceTxt.setForeground(new java.awt.Color(0, 0, 0));

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_printer_30px_1.png"))); // NOI18N
        jButton2.setText("Export files");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dateCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dateCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        sortBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sortBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_sort_by_price_30px.png"))); // NOI18N
        sortBtn.setText("Sort");
        sortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBtnActionPerformed(evt);
            }
        });

        delBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-Cloud-Delete Bin.png"))); // NOI18N
        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        wipeBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        wipeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_Close_30px.png"))); // NOI18N
        wipeBtn.setText("Wipe all data");
        wipeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wipeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dateCB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(wipeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalpriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFind)
                    .addComponent(dateCB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortBtn)
                    .addComponent(jButton2)
                    .addComponent(delBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TotalpriceTxt)
                    .addComponent(wipeBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Backbtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_back_arrow_30px_2.png"))); // NOI18N
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(192, 192, 192)
                .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Backbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFindActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog("Enter the name you are looking for ?");
        if (input != null && input.length() > 0) {
            TicketList = Modify.TicketModify.FindByFullname(input);
            List<Users> userList;
            List<Schedule> scheList;
            tableModel.setRowCount(0);
            float totalPrice = 0;
            for (Ticket ticket : TicketList) {
                userList = Modify.UserModify.getListNameByID(ticket.getUser_id());
                for (Users u : userList) {
                    scheList = Modify.ScheduleModify.getSchedulebyID(ticket.getSchedule_id());
                    for (Schedule sc : scheList) {
                        String total = Utility.getPrice(ticket.getTotal());
                        tableModel.addRow(new Object[]{
                            tableModel.getRowCount() + 1,
                            u.getFullname(),
                            sc.getMovie_id().getTitle(),
                            ticket.getSeat_code(),
                            sc.getRoom_id().getRoom(),
                            sc.getTime_id().getTime(),
                            total + " VND",
                            ticket.getCreated_at()
                        });
                    }
                }
                totalPrice += ticket.getTotal();
            }
            TotalpriceTxt.setText(Utility.getPrice(totalPrice) + " VND");
        } else {
            showTicket();
        }
    }//GEN-LAST:event_BtnFindActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Print(TicketTbl);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        // TODO add your handling code here:
        close();
        AdminJFrame adminJFrame = new AdminJFrame();
        adminJFrame.setVisible(true);
    }//GEN-LAST:event_BackbtnActionPerformed

    private void sortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBtnActionPerformed
        // TODO add your handling code here:
        if (dateCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Invalid Date!");
            showTicket();
        } else {
            TicketList = Modify.TicketModify.getDate(dateCB.getSelectedItem().toString());
            List<Users> userList;
            List<Schedule> scheList;
            tableModel.setRowCount(0);
            float totalPrice = 0;
            for (Ticket ticket : TicketList) {
                userList = Modify.UserModify.getListNameByID(ticket.getUser_id());
                for (Users u : userList) {
                    scheList = Modify.ScheduleModify.getSchedulebyID(ticket.getSchedule_id());
                    for (Schedule sc : scheList) {
                        String total = Utility.getPrice(ticket.getTotal());
                        tableModel.addRow(new Object[]{
                            tableModel.getRowCount() + 1,
                            u.getFullname(),
                            sc.getMovie_id().getTitle(),
                            ticket.getSeat_code(),
                            sc.getRoom_id().getRoom(),
                            sc.getTime_id().getTime(),
                            total + " VND",
                            ticket.getCreated_at()
                        });
                    }
                }
                totalPrice += ticket.getTotal();
            }
            TotalpriceTxt.setText(Utility.getPrice(totalPrice) + " VND");
        }
    }//GEN-LAST:event_sortBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        currentIndex = TicketTbl.getSelectedRow();
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't choose anything to delete");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to delete this ticket?");
        if (option == 0 && currentIndex >= 0) {
            Modify.TicketModify.delete(TicketList.get(currentIndex).getId());

            currentIndex = -1;
            TicketModify.getAll();
            sortBtnActionPerformed(evt);
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void wipeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wipeBtnActionPerformed
        // TODO add your handling code here:
        if (dateCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please choose date to wipe all data");
        } else {
            int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to wipe all data?");
            if (option == 0) {
                Modify.TicketModify.deleteAll(dateCB.getSelectedItem().toString());
                TicketModify.getAll();
                showTicket();
            }
        }
        dateCB.setSelectedIndex(0);
    }//GEN-LAST:event_wipeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TicketJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton BtnFind;
    private javax.swing.JTable TicketTbl;
    private javax.swing.JFormattedTextField TotalpriceTxt;
    private javax.swing.JComboBox<String> dateCB;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton sortBtn;
    private javax.swing.JButton wipeBtn;
    // End of variables declaration//GEN-END:variables
}
