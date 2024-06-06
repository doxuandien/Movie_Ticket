package UI;

import Config.Clock;
import Models.Constan;
import Models.Schedule;
import Models.Ticket;
import Models.Users;
import Modify.Utility;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class BookSeatJFrame extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    JButton[] ghe = new JButton[Constan.soNgang * Constan.soDoc];
    private ImageIcon icon1 = new ImageIcon(getClass().getResource("../Img/Icon/chair.jpg"));
    private ImageIcon icon2 = new ImageIcon(getClass().getResource("../Img/Icon/booked.jpg"));
    List<String> chairList = new ArrayList<>();
    List<Schedule> scheduleList;
    List<Ticket> ticketList;
    Users user;
    Schedule schedule;
    String chair = "";

    int money = 0;
    static String imageTitle;
    static String shift = null;
    int currentIndex = -1;

    /**
     * Creates new form THJFrame
     */
    public BookSeatJFrame() {
        initComponents();
    }

    public BookSeatJFrame(String title, String img) {
        initComponents();
        this.setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) TblSchedule.getModel();
        createLabel();
        loadLabel();
        initCLock();
        Utility.setImageLabel(imageLbl, img);
        imageTitle = img;
        imageLbl.setText(title);
        showSchedule();
        setup();
        checkBtn.setVisible(false);
        resetBtn.setVisible(false);
    }

    private void createLabel() {
        int count = 1;
        int TypeChair = 1;
        String s = "A";
        JButton oldbButton = new JButton();
        oldbButton.setBounds(0, 0, 0, 0);
        for (int i = 0; i < Constan.soDoc; i++) {
            for (int j = 0; j < Constan.soNgang; j++) {
                if (i == 1 && j == 0) {
                    TypeChair = 1;
                    s = "B";

                } else if (i == 2 && j == 0) {
                    TypeChair = 1;
                    s = "C";

                } else if (i == 3 && j == 0) {
                    TypeChair = 1;
                    s = "D";

                } else if (i == 4 && j == 0) {
                    TypeChair = 1;
                    s = "E";

                }
                JButton button = new JButton(s + TypeChair, icon1);
                button.setHorizontalTextPosition(JButton.CENTER);
                button.setVerticalTextPosition(JButton.BOTTOM);

                button.setBounds(oldbButton.getX() + oldbButton.getWidth(), oldbButton.getY(), Constan.Button_width, Constan.Button_height);
                oldbButton.setBounds(button.getX(), button.getY(), button.getWidth() + Constan.distance, button.getHeight() + Constan.distance);
                ghe[count - 1] = button;
                count++;
                TypeChair++;
            }
            oldbButton.setBounds(0, oldbButton.getY() + oldbButton.getHeight(), 0, 0);
        }
    }

    private void loadLabel() {

        for (JButton jButton : ghe) {
            String name = jButton.getText();
            pnl.add(jButton);
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chairList.add(name);
                    chair = "";
                    for (String element : chairList) {
                        chair += element + ",";
                    };
                    money++;
                    chairTxt.setText(chair);
                    moneyTxt.setText(Float.parseFloat(money * 70000 + "") + "");
                    for (JButton btn : ghe) {
                        if (btn.getText().equals(name)) {
                            btn.setIcon(icon2);
                            btn.setEnabled(false);
                        }
                    }
                }
            });
        }
    }

    private void showSchedule() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date_now = sdf.format(date);
        scheduleList = Modify.ScheduleModify.listMovieByTitle_Date(imageLbl.getText(),date_now);
        tableModel.setRowCount(0);

        for (Schedule sch : scheduleList) {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                sch.getMovie_id().getTitle(),
                sch.getTime_id().getTime(),
                sch.getRoom_id().getRoom(),
                sch.getDate_schedule()
            });
        }
    }

    private void showRow(int position) {
        this.currentIndex = position;
        idTxt.setText(scheduleList.get(position).getId() + "");
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");

        String tn = sdf.format(date);
        String dn = sdf_date.format(date);

        try {
            Date date_sch = sdf_date.parse(scheduleList.get(position).getDate_schedule());
            Date date_now = sdf_date.parse(dn);

            Date time_sch = sdf.parse(scheduleList.get(position).getTime_id().getTime());
            Date time_now = sdf.parse(tn);

            if (date_sch.equals(date_now)) {
                if (time_sch.after(time_now)) {
                    setup();
                    checkBtn.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "This schedule has already aired!");
                    setup();
                }
            } else {
                setup();
                checkBtn.setVisible(true);    
            }
        } catch (ParseException ex) {
            Logger.getLogger(BookSeatJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectedChair() {
        ticketList = Modify.TicketModify.loadTickets();
        for (Ticket t : ticketList) {
            for (JButton jb : ghe) {
                String code = t.getSeat_code();
                if (jb.getText().equals(code) && idTxt.getText().equals(t.getSchedule_id() + "")) {
                    jb.setIcon(icon2);
                    jb.setEnabled(false);
                }
            }
        }
    }

    private void initCLock() {
        Clock clock = new Clock(timeLbl);
        clock.start();
    }

    private void setup() {
        for (JButton jb : ghe) {
            jb.setIcon(icon2);
            jb.setEnabled(false);
            resetBtn.setVisible(false);
            checkBtn.setVisible(false);
            confirmBtn.setVisible(false);
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

        jLabel1 = new javax.swing.JLabel();
        period = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnl = new javax.swing.JPanel();
        imageLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        moneyTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chairTxt = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        timeLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSchedule = new javax.swing.JTable();
        idTxt = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkBtn = new javax.swing.JButton();
        moneyTxt1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SCREEN");

        pnl.setBackground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(188, 188, 188))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        imageLbl.setForeground(new java.awt.Color(0, 0, 0));
        imageLbl.setText("imageLabel");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Seat Code:");

        moneyTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        moneyTxt.setForeground(new java.awt.Color(255, 0, 0));
        moneyTxt.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Total:");

        chairTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chairTxt.setForeground(new java.awt.Color(255, 0, 0));

        confirmBtn.setBackground(new java.awt.Color(255, 255, 255));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(0, 0, 0));
        confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_Check_Circle_30px.png"))); // NOI18N
        confirmBtn.setText("CONFIRM");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        resetBtn.setBackground(new java.awt.Color(255, 255, 255));
        resetBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(0, 0, 0));
        resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8-Material Outlined-Reset.png"))); // NOI18N
        resetBtn.setText("RESET");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        timeLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(0, 0, 0));
        timeLbl.setText("time");

        TblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Time", "Room", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblScheduleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblSchedule);

        idTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idTxt.setForeground(new java.awt.Color(255, 0, 0));
        idTxt.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ID:");

        checkBtn.setBackground(new java.awt.Color(255, 255, 255));
        checkBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        checkBtn.setForeground(new java.awt.Color(0, 0, 0));
        checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_living_room_30px.png"))); // NOI18N
        checkBtn.setText("CHECK AVALIBLE");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        moneyTxt1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        moneyTxt1.setForeground(new java.awt.Color(255, 0, 0));
        moneyTxt1.setText("VNÐ");

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 0));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_go_30px_2.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(moneyTxt)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(moneyTxt1))
                                                .addComponent(checkBtn))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(resetBtn))
                                        .addComponent(chairTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(confirmBtn))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idTxt)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeLbl)
                        .addGap(75, 75, 75))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chairTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(moneyTxt)
                                    .addComponent(jLabel5)
                                    .addComponent(moneyTxt1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(resetBtn)
                                    .addComponent(checkBtn))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(confirmBtn))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(idTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(timeLbl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        reset();
        selectedChair();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void reset() {
        for (JButton btn : ghe) {
            btn.setEnabled(true);
            btn.setIcon(icon1);
            chairTxt.setText("");
            chairList = new ArrayList<>();
            money = 0;
            moneyTxt.setText(money + "");
        }
    }

    private boolean checkValidate() {
        if (chairList.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "You haven't choose your seat");
            return false;
        }

        return true;
    }
    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        close();
        if (!checkValidate()) {
            return;
        }
        int id = Integer.parseInt(idTxt.getText());
        float money = Float.parseFloat(moneyTxt.getText());
        new OrderJFrame(id, chairList, money, imageTitle).setVisible(true);
        setup();
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void TblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblScheduleMouseClicked
        // TODO add your handling code here:
        int position = TblSchedule.getSelectedRow();
        showRow(position);
    }//GEN-LAST:event_TblScheduleMouseClicked

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        // TODO add your handling code here:
        reset();
        selectedChair();
        confirmBtn.setVisible(true);
        resetBtn.setVisible(true);
    }//GEN-LAST:event_checkBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        close();
        HomeJFrame home = new HomeJFrame();
        home.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
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
            java.util.logging.Logger.getLogger(BookSeatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookSeatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookSeatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookSeatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookSeatJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSchedule;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel chairTxt;
    private javax.swing.JButton checkBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel idTxt;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyTxt;
    private javax.swing.JLabel moneyTxt1;
    private javax.swing.ButtonGroup period;
    private javax.swing.JPanel pnl;
    private javax.swing.JButton resetBtn;
    private javax.swing.JLabel timeLbl;
    // End of variables declaration//GEN-END:variables
}
