/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Config.Clock;
import Models.Movie;
import Models.Room;
import Models.Schedule;
import Models.Ticket;
import Models.Time;
import Modify.Utility;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HomeJFrame extends javax.swing.JFrame {
    
    //DATA MOVIE SCREEN
    List<Movie> movieListMOVIE;
    JLabel[] component = new JLabel[3];
    JButton[] page = new JButton[3];
    JButton next;
    JButton prev;
    public static int present = 1;
    int pages;
    static String icon;
    static String titleMovie;
    // DATA SCHEDULE
    List<Movie> movieListSCHEDULE;
    List<Time> timeList;
    List<Room> roomList;
    DefaultTableModel tableModel;
    int currentIndex = -1;
    List<Schedule> scheduleList;

    CardLayout cardLayout;

    public HomeJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
       
        screenMenuSplit.setEnabled(false);
        cardLayout = (CardLayout) (pnlCards.getLayout());
        //Panel Movie
        initCLock();
        welcomeLbl.setText(LoginJFrame.getUsers().getFullname());
        movieListMOVIE = Modify.MovieModify.findAll();
        
        
        pages = (int) Paging(3);
        
        createBtn();
        setBtn();
        createLabel();
        setLabel();
        
  
        //Panel Add Schedule
        setDataCB();
        tableModel = (DefaultTableModel) TblSchedule.getModel();
        Reset();
        showSchedule();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        welcomeLbl = new javax.swing.JLabel();
        screenMenuSplit = new javax.swing.JSplitPane();
        pnlCards = new javax.swing.JPanel();
        pnlCard1 = new javax.swing.JPanel();
        btnPanel = new javax.swing.JPanel();
        moviePanel = new javax.swing.JPanel();
        pnlCard2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSchedule = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        movieCB = new javax.swing.JComboBox<>();
        insertBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        timeCB = new javax.swing.JComboBox<>();
        roomCB = new javax.swing.JComboBox<>();
        delBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dateTxt = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        movieBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_home_40px_1.png"))); // NOI18N
        jLabel1.setText("Home Screen");

        timeLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8-Material Sharp-User.png"))); // NOI18N
        jLabel6.setText("WELCOME:");

        welcomeLbl.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        welcomeLbl.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(187, 187, 187)
                .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards.setLayout(new java.awt.CardLayout());

        pnlCard1.setBackground(new java.awt.Color(153, 204, 255));

        btnPanel.setBackground(new java.awt.Color(153, 255, 255));
        btnPanel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        moviePanel.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout moviePanelLayout = new javax.swing.GroupLayout(moviePanel);
        moviePanel.setLayout(moviePanelLayout);
        moviePanelLayout.setHorizontalGroup(
            moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        moviePanelLayout.setVerticalGroup(
            moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCard1Layout = new javax.swing.GroupLayout(pnlCard1);
        pnlCard1.setLayout(pnlCard1Layout);
        pnlCard1Layout.setHorizontalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moviePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCard1Layout.setVerticalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(moviePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCards.add(pnlCard1, "pnlCard1");

        pnlCard2.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane1.setViewportView(TblSchedule);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        movieCB.setBackground(new java.awt.Color(255, 255, 255));
        movieCB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        movieCB.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(movieCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 297, -1));

        insertBtn.setBackground(new java.awt.Color(255, 0, 0));
        insertBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        insertBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_Check_Circle_30px.png"))); // NOI18N
        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });
        jPanel2.add(insertBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Room:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 225, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Title:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 122, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Time:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 176, -1, -1));

        timeCB.setBackground(new java.awt.Color(255, 255, 255));
        timeCB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeCB.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(timeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 128, -1));

        roomCB.setBackground(new java.awt.Color(255, 255, 255));
        roomCB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        roomCB.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(roomCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 100, -1));

        delBtn.setBackground(new java.awt.Color(255, 0, 0));
        delBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delBtn.setForeground(new java.awt.Color(255, 255, 255));
        delBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8-Material Outlined-Reset.png"))); // NOI18N
        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });
        jPanel2.add(delBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Date:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 287, -1, -1));

        dateTxt.setBackground(new java.awt.Color(255, 255, 255));
        dateTxt.setForeground(new java.awt.Color(0, 0, 0));
        dateTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 174, 36));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_movie_30px.png"))); // NOI18N
        jLabel8.setText("Movie Schedule");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(16, 16, 16))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 504, 70));

        javax.swing.GroupLayout pnlCard2Layout = new javax.swing.GroupLayout(pnlCard2);
        pnlCard2.setLayout(pnlCard2Layout);
        pnlCard2Layout.setHorizontalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCard2Layout.setVerticalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pnlCards.add(pnlCard2, "pnlCard2");

        screenMenuSplit.setRightComponent(pnlCards);

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));

        addBtn.setBackground(new java.awt.Color(255, 204, 204));
        addBtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        addBtn.setForeground(new java.awt.Color(0, 0, 0));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_timesheet_30px.png"))); // NOI18N
        addBtn.setText("Add Schedule");
        addBtn.setBorder(null);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        movieBtn.setBackground(new java.awt.Color(255, 204, 204));
        movieBtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        movieBtn.setForeground(new java.awt.Color(0, 0, 0));
        movieBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/icons8_movie_30px.png"))); // NOI18N
        movieBtn.setText("Movie Screen");
        movieBtn.setBorder(null);
        movieBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(255, 51, 51));
        logoutBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-Shutdown.png"))); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(movieBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(movieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        screenMenuSplit.setLeftComponent(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(screenMenuSplit)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenMenuSplit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // CODE FOR MOVIE SCREEN
    //========================================================================================
    private void createBtn() {
        int height = 30;
        int map = btnPanel.getWidth() / 2;
        JButton oldbButton = new JButton();
        oldbButton.setBounds(map - 80, 5, 0, 0);
        
        next = new JButton(">>");
        prev = new JButton("<<");
        next.setHorizontalTextPosition(JButton.CENTER);
        next.setVerticalTextPosition(JButton.BOTTOM);
        next.setBounds(oldbButton.getX() + 115, oldbButton.getY(), 50, height);

        prev.setHorizontalTextPosition(JButton.CENTER);
        prev.setVerticalTextPosition(JButton.BOTTOM);
        prev.setBounds(map -90, oldbButton.getY(), 50, height);
    }
    
    private void setBtn() {
        btnPanel.add(next);
        btnPanel.add(prev);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (present < pages) {
                    present++;
                    Update(present);
                }
                if (present > 1) {
                    prev.setEnabled(true);
                } 
            }
        });
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (present > 1) {
                    present--;
                }
                if (present == 1) {
                    prev.setEnabled(false);
                }
                Update(present);
            }
        });
    }
    
    private void createLabel() {
        int width = 240;
        int height = 340;
        int distance = 100;
        int count = 0;

        JLabel oldbLabel = new JLabel();
        oldbLabel.setBounds(4, 0, 0, 0);
        for (int i = 0; i < 3; i++) {
            titleMovie = movieListMOVIE.get(i).getTitle();  
            icon = movieListMOVIE.get(i).getImg();

            JLabel label = new JLabel();
            label.setText(titleMovie);
            label.setBounds(oldbLabel.getX() + oldbLabel.getWidth(), oldbLabel.getY(), width, height);
            oldbLabel.setBounds(label.getX(), label.getY(), label.getWidth() + distance, label.getHeight() + distance);
            component[count] = label;
            Utility.setImageLabel(component[count], icon);
            
            count++;
        }
    }
    
    private void setLabel() {
        for (JLabel label : component) {
            moviePanel.add(label);
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    close();
                    new DetailJFrame(label.getText()).setVisible(true);
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
    }
    
    private double Paging(double x) {
        return Math.ceil(movieListMOVIE.size() / x);
    }
    
    private void Update(int current) {
        int count = 0;
        int start = 0;
        int end = 0;

        if (current == pages) {
            end = movieListMOVIE.size();
            start = (current - 1) * 3;
            for (int i = (end - start); i < 3; i++) {
                component[i].setIcon(null);
                component[i].setText(null);
            }
        } else {
            end = current * 3;
            start = end - 3;
        }

        for (int i = start; i < end; i++) {
            titleMovie = movieListMOVIE.get(i).getTitle();  
            icon = movieListMOVIE.get(i).getImg();
            component[count].setText(titleMovie);
            Utility.setImageLabel(component[count], icon);
            count++;
        }

    }
    
    private void initCLock() {
        Clock clock = new Clock(timeLbl);
        clock.start();
    }
    
    private void movieBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieBtnActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "pnlCard1");
    }//GEN-LAST:event_movieBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "pnlCard2");
    }//GEN-LAST:event_addBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        close();
        LoginJFrame login = new LoginJFrame();
        login.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    //CODE FOR ADD SCHEDULE
    //=============================================================================================
    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        if (!checkValidate()) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Movie m = (Movie) movieCB.getSelectedItem();
        Time t = (Time) timeCB.getSelectedItem();
        Room r = (Room) roomCB.getSelectedItem();
        String date = sdf.format(dateTxt.getDate());

        Schedule schedule = new Schedule(date);

        schedule.setMovie_id(m);
        schedule.setTime_id(t);
        schedule.setRoom_id(r);

        int r_id = schedule.getRoom_id().getId();
        int t_id = schedule.getTime_id().getId();

        //Check duplicate schedule
        boolean check = Modify.ScheduleModify.checkDuplicate(r_id, t_id, date);
        if (check) {
            Modify.ScheduleModify.insert(schedule);
        } else {
            JOptionPane.showMessageDialog(rootPane, "This schedule has been aired!");
        }
        showSchedule();
        Reset();
    }//GEN-LAST:event_insertBtnActionPerformed
    
    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        currentIndex = TblSchedule.getSelectedRow();
        List<Ticket> ticketList;
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't choose item to delete!");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to delete?");
        if (option == 0 && currentIndex >= 0) {
            ticketList = Modify.TicketModify.getTicketBySchedule_ID(scheduleList.get(currentIndex).getId());
            if (ticketList.isEmpty()) {
                Modify.ScheduleModify.deleteSchedule(scheduleList.get(currentIndex).getId());
            } else {
                JOptionPane.showMessageDialog(rootPane, "This schedule has already aired. Cannot Delete!!");
            }
            currentIndex = -1;
            Modify.ScheduleModify.loadData();
            showSchedule();
        }
    }//GEN-LAST:event_delBtnActionPerformed
    
    private void setDataCB() {
        movieListSCHEDULE = Modify.ScheduleModify.getTitleList();
        for (Movie m : movieListSCHEDULE) {
            movieCB.addItem(m);
        }

        timeList = Modify.ScheduleModify.getTimeList();
        for (Time t : timeList) {
            timeCB.addItem(t);
        }

        roomList = Modify.ScheduleModify.getRoomList();
        for (Room r : roomList) {
            roomCB.addItem(r);
        }
    }
    
    private boolean checkValidate() {
        if (movieCB.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "You haven't choose title");
            return false;
        }
        if (timeCB.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "You haven't choose time");
            return false;
        }
        if (roomCB.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "You haven't choose room");
            return false;
        }
        if (dateTxt.getDate() == null) {
            JOptionPane.showMessageDialog(this, "You haven't choose date");
            return false;
        }
        return true;
    }
    
    private void Reset() {
        movieCB.setSelectedItem(null);
        timeCB.setSelectedItem(null);
        roomCB.setSelectedItem(null);
        dateTxt.setDate(null);
    }

    private void showSchedule() {
        scheduleList = new ArrayList<>();
        scheduleList = Modify.ScheduleModify.loadData();

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
    
    //=============================================================================================
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
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSchedule;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel btnPanel;
    private com.toedter.calendar.JDateChooser dateTxt;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton movieBtn;
    private javax.swing.JComboBox<Movie> movieCB;
    private javax.swing.JPanel moviePanel;
    private javax.swing.JPanel pnlCard1;
    private javax.swing.JPanel pnlCard2;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JComboBox<Room> roomCB;
    private javax.swing.JSplitPane screenMenuSplit;
    private javax.swing.JComboBox<Time> timeCB;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel welcomeLbl;
    // End of variables declaration//GEN-END:variables
}
