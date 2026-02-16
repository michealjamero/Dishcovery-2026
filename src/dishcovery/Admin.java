/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dishcovery;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Admin extends javax.swing.JFrame {
    private final config.config con = new config.config();

     void displayUser(){
        String sql = "SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date FROM Recipes";
        con.displayData(sql, recipeTable);
    }

    
   
    public Admin() {
        config.Session.requireLogin(this);
        initComponents();
        displayUser();
    }
    
  


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jDialog1 = new javax.swing.JDialog();
        choice1 = new java.awt.Choice();
        canvas1 = new java.awt.Canvas();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        ADD7 = new javax.swing.JButton();
        ADD11 = new javax.swing.JButton();
        ADD12 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        ADD36 = new javax.swing.JButton();
        ADD41 = new javax.swing.JButton();
        ADD42 = new javax.swing.JButton();
        ADD43 = new javax.swing.JButton();
        ADD44 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        Search1 = new javax.swing.JTextField();
        view = new javax.swing.JButton();
        category = new javax.swing.JComboBox<>();
        search = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        Search2 = new javax.swing.JTextField();
        view1 = new javax.swing.JButton();
        category1 = new javax.swing.JComboBox<>();
        search1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        ADD35 = new javax.swing.JButton();
        ADD37 = new javax.swing.JButton();
        ADD38 = new javax.swing.JButton();
        ADD39 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ADD40 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        Search3 = new javax.swing.JTextField();
        view2 = new javax.swing.JButton();
        category2 = new javax.swing.JComboBox<>();
        search2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jFrame1.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel3.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0,100));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(null);

        ADD7.setBackground(new java.awt.Color(255, 255, 255));
        ADD7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD7.setText("Delete");
        ADD7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD7MouseClicked(evt);
            }
        });
        ADD7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD7ActionPerformed(evt);
            }
        });
        jPanel9.add(ADD7);
        ADD7.setBounds(400, 10, 130, 30);

        ADD11.setBackground(new java.awt.Color(255, 255, 255));
        ADD11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD11.setText("ADD");
        ADD11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ADD11MouseEntered(evt);
            }
        });
        ADD11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD11ActionPerformed(evt);
            }
        });
        jPanel9.add(ADD11);
        ADD11.setBounds(40, 10, 130, 30);

        ADD12.setBackground(new java.awt.Color(255, 255, 255));
        ADD12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD12.setText("Update");
        ADD12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD12MouseClicked(evt);
            }
        });
        ADD12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD12ActionPerformed(evt);
            }
        });
        jPanel9.add(ADD12);
        ADD12.setBounds(220, 10, 130, 30);

        jPanel12.add(jPanel9);
        jPanel9.setBounds(220, 20, 590, 50);

        jPanel18.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setLayout(null);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/small logo.png"))); // NOI18N
        jLabel28.setText("jLabel9");
        jPanel18.add(jLabel28);
        jLabel28.setBounds(10, 10, 140, 120);

        ADD36.setBackground(new java.awt.Color(255, 255, 255));
        ADD36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD36.setText("View");
        ADD36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD36ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD36);
        ADD36.setBounds(40, 270, 90, 30);

        ADD41.setBackground(new java.awt.Color(255, 255, 255));
        ADD41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD41.setText("Share");
        ADD41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD41ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD41);
        ADD41.setBounds(40, 320, 90, 30);

        ADD42.setBackground(new java.awt.Color(255, 255, 255));
        ADD42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD42.setText("Profile");
        ADD42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD42ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD42);
        ADD42.setBounds(40, 370, 90, 30);

        ADD43.setBackground(new java.awt.Color(255, 255, 255));
        ADD43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD43.setText("Manage");
        ADD43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD43MouseClicked(evt);
            }
        });
        ADD43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD43ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD43);
        ADD43.setBounds(40, 220, 90, 30);

        ADD44.setBackground(new java.awt.Color(255, 255, 255));
        ADD44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD44.setText("Home");
        ADD44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD44MouseClicked(evt);
            }
        });
        ADD44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD44ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD44);
        ADD44.setBounds(40, 170, 90, 30);

        jPanel12.add(jPanel18);
        jPanel18.setBounds(20, 20, 180, 470);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(null);
        jPanel14.add(jPanel5);
        jPanel5.setBounds(0, 0, 590, 360);

        jPanel12.add(jPanel14);
        jPanel14.setBounds(220, 130, 590, 360);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(null);

        Search1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search1.setText("Search recipes by name or ID");
        Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search1ActionPerformed(evt);
            }
        });
        Search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Search1KeyReleased(evt);
            }
        });
        Search1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Search1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Search1FocusLost(evt);
            }
        });
        jPanel13.add(Search1);
        Search1.setBounds(10, 10, 270, 30);

        view.setBackground(new java.awt.Color(255, 255, 255));
        view.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        jPanel13.add(view);
        view.setBounds(390, 10, 83, 30);

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        jPanel13.add(category);
        category.setBounds(490, 10, 90, 30);

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel13.add(search);
        search.setBounds(290, 10, 80, 30);

        jPanel12.add(jPanel13);
        jPanel13.setBounds(220, 80, 590, 50);

        jPanel3.add(jPanel12);
        jPanel12.setBounds(20, 40, 840, 510);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel24.setText("jLabel12");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(0, 10, 880, 570);

        jFrame1.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 880, 580));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(null);
        jFrame1.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setLayout(null);

        Search2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search2.setText("Search recipes by name or ID");
        Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search2ActionPerformed(evt);
            }
        });
        jPanel15.add(Search2);
        Search2.setBounds(10, 10, 270, 30);

        view1.setBackground(new java.awt.Color(255, 255, 255));
        view1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view1.setText("View");
        view1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view1ActionPerformed(evt);
            }
        });
        jPanel15.add(view1);
        view1.setBounds(390, 10, 83, 30);

        category1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category1ActionPerformed(evt);
            }
        });
        jPanel15.add(category1);
        category1.setBounds(490, 10, 90, 30);

        search1.setBackground(new java.awt.Color(255, 255, 255));
        search1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search1.setText("Search");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        jPanel15.add(search1);
        search1.setBounds(290, 10, 80, 30);

        jFrame1.getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("View Recipes");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(450, 20, 150, 30);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Search,review and manage recipes");
        jPanel8.add(jLabel15);
        jLabel15.setBounds(410, 50, 260, 30);

        jPanel17.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(null);

        ADD35.setBackground(new java.awt.Color(255, 255, 255));
        ADD35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD35.setText("Approve");
        ADD35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD35ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD35);
        ADD35.setBounds(40, 290, 100, 30);

        ADD37.setBackground(new java.awt.Color(255, 255, 255));
        ADD37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD37.setText("Profile");
        ADD37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD37ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD37);
        ADD37.setBounds(40, 350, 100, 30);

        ADD38.setBackground(new java.awt.Color(255, 255, 255));
        ADD38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD38.setText("Users");
        ADD38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD38MouseClicked(evt);
            }
        });
        ADD38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD38ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD38);
        ADD38.setBounds(40, 170, 100, 30);

        ADD39.setBackground(new java.awt.Color(255, 255, 255));
        ADD39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD39.setText("Home");
        ADD39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD39MouseClicked(evt);
            }
        });
        ADD39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD39ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD39);
        ADD39.setBounds(40, 110, 100, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ADMIN PANEL");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel17.add(jLabel4);
        jLabel4.setBounds(20, 20, 140, 40);

        ADD40.setBackground(new java.awt.Color(255, 255, 255));
        ADD40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD40.setText("Review");
        ADD40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD40MouseClicked(evt);
            }
        });
        ADD40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD40ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD40);
        ADD40.setBounds(40, 230, 100, 30);

        jPanel8.add(jPanel17);
        jPanel17.setBounds(20, 20, 180, 430);

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        recipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // placeholder
            }
        });
        jScrollPane1.setViewportView(recipeTable);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(220, 130, 590, 320);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(null);
        jPanel8.add(jPanel10);
        jPanel10.setBounds(210, 130, 590, 320);

        jPanel16.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(null);

        Search3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search3.setText("Search recipes by name or ID");
        Search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search3ActionPerformed(evt);
            }
        });
        jPanel16.add(Search3);
        Search3.setBounds(10, 10, 270, 30);

        view2.setBackground(new java.awt.Color(255, 255, 255));
        view2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view2.setText("View");
        view2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view2ActionPerformed(evt);
            }
        });
        jPanel16.add(view2);
        view2.setBounds(390, 10, 83, 30);

        category2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category2ActionPerformed(evt);
            }
        });
        jPanel16.add(category2);
        category2.setBounds(490, 10, 90, 30);

        search2.setBackground(new java.awt.Color(255, 255, 255));
        search2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search2.setText("Search");
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        jPanel16.add(search2);
        search2.setBounds(290, 10, 80, 30);

        jPanel8.add(jPanel16);
        jPanel16.setBounds(210, 80, 590, 50);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 30, 830, 480);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 880, 530);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void ADD35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD35ActionPerformed

    private void ADD37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD37ActionPerformed
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD37ActionPerformed

    private void ADD38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD38MouseClicked
      // TODO add your handling code here:
    }//GEN-LAST:event_ADD38MouseClicked

    private void ADD38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD38ActionPerformed
  Users l = new Users();
        l.setVisible(true);
        this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_ADD38ActionPerformed

    private void ADD39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD39MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD39MouseClicked

    private void ADD39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD39ActionPerformed
Admin l = new Admin();
        l.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_ADD39ActionPerformed

    private void ADD40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD40MouseClicked

    private void ADD40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD40ActionPerformed

    private void ADD7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD7MouseClicked
        deleteSelectedRecipe();
    }//GEN-LAST:event_ADD7MouseClicked

    private void ADD7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD7ActionPerformed
        deleteSelectedRecipe();
    }//GEN-LAST:event_ADD7ActionPerformed

    private void ADD11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD11MouseClicked
        ADD a = new ADD();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD11MouseClicked

    private void ADD11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD11MouseEntered

    private void ADD11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD11ActionPerformed
        ADD a = new ADD();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD11ActionPerformed

    private void ADD12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD12MouseClicked
        ADD12ActionPerformed(null);
    }//GEN-LAST:event_ADD12MouseClicked

    private void ADD12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD12ActionPerformed
        int row = recipeTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a recipe to update.");
            return;
        }

        String id = recipeTable.getValueAt(row, 0).toString();
        ADD a = new ADD(id);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD12ActionPerformed

    private void ADD36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD36ActionPerformed
        View v = new View();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD36ActionPerformed

    private void ADD41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD41ActionPerformed

    private void ADD42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD42ActionPerformed
        profile p = new profile();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD42ActionPerformed

    private void ADD43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD43MouseClicked
        displayRecipes();
    }//GEN-LAST:event_ADD43MouseClicked

    private void ADD43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD43ActionPerformed

    private void ADD44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD44MouseClicked
        homePage2 h = new homePage2();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD44MouseClicked

    private void ADD44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD44ActionPerformed

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search1ActionPerformed
        performSearch();
    }//GEN-LAST:event_Search1ActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        Search1.setText("");
        if (category.getItemCount() > 0) {
            category.setSelectedIndex(0);
        }
        displayRecipes();
    }//GEN-LAST:event_viewActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        performSearch();
    }//GEN-LAST:event_categoryActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        performSearch();
    }//GEN-LAST:event_searchActionPerformed

    private void Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search2ActionPerformed
        performSearch();
    }//GEN-LAST:event_Search2ActionPerformed

    private void view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view1ActionPerformed
        Search1.setText("");
        if (category.getItemCount() > 0) {
            category.setSelectedIndex(0);
        }
        displayRecipes();
    }//GEN-LAST:event_view1ActionPerformed

    private void category1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category1ActionPerformed
        performSearch();
    }//GEN-LAST:event_category1ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        performSearch();
    }//GEN-LAST:event_search1ActionPerformed

    private void Search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search3ActionPerformed
        performSearch();
    }//GEN-LAST:event_Search3ActionPerformed

    private void view2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view2ActionPerformed
        Search1.setText("");
        if (category.getItemCount() > 0) {
            category.setSelectedIndex(0);
        }
        displayRecipes();
    }//GEN-LAST:event_view2ActionPerformed

    private void category2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category2ActionPerformed
        performSearch();
    }//GEN-LAST:event_category2ActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        performSearch();
    }//GEN-LAST:event_search2ActionPerformed

    private void Search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search1KeyReleased
        performSearch();
    }//GEN-LAST:event_Search1KeyReleased

    private void Search1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Search1FocusGained
        if (Search1.getText().equals("Search recipes by name or ID")) {
            Search1.setText("");
        }
    }//GEN-LAST:event_Search1FocusGained

    private void Search1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Search1FocusLost
        if (Search1.getText().isEmpty()) {
            Search1.setText("Search recipes by name or ID");
        }
    }//GEN-LAST:event_Search1FocusLost

    private void displayRecipes() {
        String sql = "SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date FROM Recipes";
        con.displayData(sql, recipeTable);
    }

    private void performSearch() {
        String txt = Search1.getText() != null ? Search1.getText().trim() : "";
        if ("Search recipes by name or ID".equals(txt)) txt = "";
        String cat = category.getSelectedItem() != null ? category.getSelectedItem().toString() : "";

        StringBuilder sql = new StringBuilder("SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_date AS Date FROM Recipes WHERE 1=1");
        java.util.List<Object> params = new java.util.ArrayList<>();

        if (!txt.isEmpty()) {
            sql.append(" AND (r_title LIKE ? OR CAST(r_id AS TEXT) LIKE ? OR r_author LIKE ?)");
            params.add("%" + txt + "%");
            params.add("%" + txt + "%");
            params.add("%" + txt + "%");
        }

        if (!cat.isEmpty()) {
            sql.append(" AND r_category = ?");
            params.add(cat);
        }

        con.displayData(sql.toString(), recipeTable, params.toArray());
    }

    private void deleteSelectedRecipe() {
        int row = recipeTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a recipe to delete.");
            return;
        }

        String idStr = String.valueOf(recipeTable.getValueAt(row, 0));
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete recipe ID " + idStr + "?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            con.deleteRecord("DELETE FROM Recipes WHERE r_id = ?", id);
            JOptionPane.showMessageDialog(this, "Recipe deleted successfully.");
            displayRecipes();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid recipe ID: " + idStr);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to delete recipe: " + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD11;
    private javax.swing.JButton ADD12;
    private javax.swing.JButton ADD35;
    private javax.swing.JButton ADD36;
    private javax.swing.JButton ADD37;
    private javax.swing.JButton ADD38;
    private javax.swing.JButton ADD39;
    private javax.swing.JButton ADD40;
    private javax.swing.JButton ADD41;
    private javax.swing.JButton ADD42;
    private javax.swing.JButton ADD43;
    private javax.swing.JButton ADD44;
    private javax.swing.JButton ADD7;
    private javax.swing.JTextField Search1;
    private javax.swing.JTextField Search2;
    private javax.swing.JTextField Search3;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<String> category1;
    private javax.swing.JComboBox<String> category2;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable recipeTable;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton search;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JButton view;
    private javax.swing.JButton view1;
    private javax.swing.JButton view2;
    // End of variables declaration//GEN-END:variables
}
