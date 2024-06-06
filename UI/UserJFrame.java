/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Models.Ticket;
import Models.Users;
import Modify.UserModify;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xuandien
 */
public class UserJFrame extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    int currentIndex = -1;
    List<Users> userList;
    Users users = null;

    /**
     * Creates new form ManageUserJFrame
     */
    public UserJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblUser.getModel();

        showUser();
        tblUser.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Posion = tblUser.getSelectedRow();
                showRow(Posion);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }
    

    private void showRow(int Posion) {
        int active;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

        this.currentIndex = Posion;
        TxtFullname.setText(userList.get(Posion).getFullname());
        GenderCb.setSelectedItem(userList.get(Posion).getGender());
        Txtemail.setText(userList.get(Posion).getEmail());
        txtPhone.setText(userList.get(Posion).getPhone_number());
        TxtAddress.setText(userList.get(Posion).getAddress());
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(userList.get(currentIndex).getBirthday());
        } catch (ParseException ex) {
            Logger.getLogger(UserJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        BirthdayTxt.setDate(date);
        
        active = userList.get(Posion).getActive();
        if(active == 1){
            rdbactive.setSelected(true);
        } else {
            rdbnonactive.setSelected(true);
        }
    }

    private void showUser() {
        userList = new ArrayList<>();
        userList = UserModify.getListByRole(1);

        tableModel.setRowCount(0);

        for (Users users : userList) {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                users.getFullname(),
                users.getGender(),
                users.getEmail(),
                users.getPhone_number(),
                users.getBirthday(),
                users.getActive()
            });
        }
    }

    private boolean checkValidate() {
        try {

            if (TxtFullname.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập Fullname");
                return false;
            }
            if (Txtemail.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mời nhập Email!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            if (!Txtemail.getText().matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            if (txtPhone.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập Phone");
                return false;
            }
            if (!txtPhone.getText().trim().matches("^\\d{10}$")) {
                JOptionPane.showMessageDialog(null, "Phone gồm 10 số", "Mesage Dialog", JOptionPane.INFORMATION_MESSAGE);
                txtPhone.requestFocus();
                return false;
            }

            if (TxtAddress.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập Address");
                return false;
            }
            
            if (BirthdayTxt.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập Ngày sinh");
                return false;
            }

        } catch (NumberFormatException ex) {
            Logger.getLogger(UserJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtFullname = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        GenderCb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Txtemail = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtAddress = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        BtnSave = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        rdbactive = new javax.swing.JRadioButton();
        rdbnonactive = new javax.swing.JRadioButton();
        BtnFind = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        BirthdayTxt = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-User Groups.png"))); // NOI18N
        jLabel1.setText("Staff Manager");

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 0));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8-Home.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(444, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(299, 299, 299)
                .addComponent(backBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("FullName :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Gender :");

        GenderCb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GenderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email :");

        Txtemail.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Phone :");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Address :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Birthday :");

        BtnSave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-Save.png"))); // NOI18N
        BtnSave.setText("Save");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnReset.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-Reset.png"))); // NOI18N
        BtnReset.setText("Reset");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        BtnDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-Delete Bin.png"))); // NOI18N
        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbactive);
        rdbactive.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbactive.setForeground(new java.awt.Color(0, 0, 0));
        rdbactive.setText("Active");

        buttonGroup1.add(rdbnonactive);
        rdbnonactive.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbnonactive.setForeground(new java.awt.Color(0, 0, 0));
        rdbnonactive.setText("Non - Active");

        BtnFind.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-Find User Male.png"))); // NOI18N
        BtnFind.setText("Find");
        BtnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(GenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(48, 48, 48)
                                        .addComponent(TxtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(rdbactive)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rdbnonactive))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Txtemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TxtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(BirthdayTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(BtnReset)
                                .addGap(39, 39, 39)
                                .addComponent(BtnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(BtnDelete)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(GenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BirthdayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbactive)
                    .addComponent(rdbnonactive))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tblUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FullName", "Gender", "Email", "Phone", "Birthday", "Active"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        currentIndex = tblUser.getSelectedRow();
        List<Ticket> ticketList;
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't choose item to delete!");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to delete this user?");
        if (option == 0 && currentIndex >= 0) {
            
            ticketList = Modify.TicketModify.getTicketByUser_ID(userList.get(currentIndex).getId());
            if (ticketList.isEmpty()){
                Modify.UserModify.delete(userList.get(currentIndex).getId());
            }else{
                JOptionPane.showMessageDialog(rootPane, "This user has sold a ticket. Cannot delete!!");
            }
            currentIndex = -1;
            Modify.UserModify.getUserList();
            showUser();
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
        TxtFullname.setText("");
        GenderCb.setSelectedIndex(0);
        Txtemail.setText("");
        txtPhone.setText("");
        TxtAddress.setText("");
        BirthdayTxt.setCalendar(null);
        buttonGroup4.clearSelection();
    }//GEN-LAST:event_BtnResetActionPerformed

    private void BtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFindActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog("Enter the name you are looking for ?");
        if (input != null && input.length() > 0) {
            userList = UserModify.Findbyfullname(input);

            tableModel.setRowCount(0);

            userList.forEach(users -> {
                tableModel.addRow(new Object[]{
                    tableModel.getRowCount() + 1,
                    users.getFullname(),
                    users.getGender(),
                    users.getEmail(),
                    users.getPhone_number(),
                    users.getBirthday(),
                    users.getActive()
                });
            });
        } else {
            showUser();
        }
    }//GEN-LAST:event_BtnFindActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        if (!checkValidate()) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

        if (currentIndex >= 0) {
            users = userList.get(currentIndex);
            currentIndex = -1;
            users.setFullname(TxtFullname.getText());
            users.setGender(GenderCb.getSelectedItem().toString());
            users.setEmail(Txtemail.getText());
            users.setPhone_number(txtPhone.getText());
            users.setAddress(TxtAddress.getText());
            users.setBirthday(sdf.format(BirthdayTxt.getDate()));
            if (rdbactive.isSelected()) {
                users.setActive(1);
            } else {
                users.setActive(0);
            }

            UserModify.updateStaff(users);
            JOptionPane.showMessageDialog(rootPane, "Bạn đã Update thành công ");
        }
        showUser();
        BtnResetActionPerformed(evt);
    }//GEN-LAST:event_BtnSaveActionPerformed
    
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        close();
        AdminJFrame admin = new AdminJFrame();
        admin.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed
    
    private void ValidateKeyPressed(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhone.setEditable(false);
        } else {
            txtPhone.setEditable(true);
        }
    }
    
    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        // TODO add your handling code here:
        ValidateKeyPressed(evt);
    }//GEN-LAST:event_txtPhoneKeyPressed

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
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser BirthdayTxt;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnFind;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnSave;
    private javax.swing.JComboBox<String> GenderCb;
    private javax.swing.JFormattedTextField TxtAddress;
    private javax.swing.JFormattedTextField TxtFullname;
    private javax.swing.JFormattedTextField Txtemail;
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rdbactive;
    private javax.swing.JRadioButton rdbnonactive;
    private javax.swing.JTable tblUser;
    private javax.swing.JFormattedTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
