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
public class review extends javax.swing.JFrame {
    private final config.config con = new config.config();

     void displayUser(){
        String sql = "SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date, r_status AS Status FROM Recipes";
        con.displayData(sql, SharedRecipe);
    }

    
   
    public review() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        displayUser();
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
        try {
            // Align review search UX with View.java behavior
            if (Search4 != null) {
                if (Search4.getText() == null || Search4.getText().trim().isEmpty()) {
                    Search4.setText("Search recipes by name or ID");
                }
                Search4.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) { performSearch(); }
                });
                Search4.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        if ("Search recipes by name or ID".equals(Search4.getText())) {
                            Search4.setText("");
                        }
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        if (Search4.getText().trim().isEmpty()) {
                            Search4.setText("Search recipes by name or ID");
                        }
                    }
                });
            }
        } catch (Exception ignore) {}
        try {
            if (status != null) {
                status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
                        "All Status", "processing...", "Approve", "Declined", "Null"
                }));
            }
        } catch (Exception ignore) {}
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
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SharedRecipe = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        Search4 = new javax.swing.JTextField();
        category3 = new javax.swing.JComboBox<>();
        status = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        view5 = new javax.swing.JButton();
        view6 = new javax.swing.JButton();
        view4 = new javax.swing.JButton();
        view7 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        ADD55 = new javax.swing.JButton();
        ADD56 = new javax.swing.JButton();
        ADD57 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ADD59 = new javax.swing.JButton();
        Logs = new javax.swing.JButton();
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

        jPanel11.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(null);

        SharedRecipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(SharedRecipe);

        jPanel11.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 590, 320);

        jPanel8.add(jPanel11);
        jPanel11.setBounds(220, 130, 590, 320);

        jPanel19.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel19.setLayout(null);

        Search4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search4ActionPerformed(evt);
            }
        });
        jPanel19.add(Search4);
        Search4.setBounds(10, 10, 360, 30);

        category3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Category", "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category3ActionPerformed(evt);
            }
        });
        jPanel19.add(category3);
        category3.setBounds(380, 10, 90, 30);

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Status", "processing...", "Approve", "Declined", "Null" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel19.add(status);
        status.setBounds(480, 10, 90, 30);

        jPanel8.add(jPanel19);
        jPanel19.setBounds(220, 80, 590, 50);

        jPanel20.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel20.setLayout(null);

        view5.setBackground(new java.awt.Color(255, 255, 255));
        view5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view5.setText("View");
        view5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view5ActionPerformed(evt);
            }
        });
        jPanel20.add(view5);
        view5.setBounds(30, 10, 100, 30);

        view6.setBackground(new java.awt.Color(255, 255, 255));
        view6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view6.setText("Approve");
        view6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view6ActionPerformed(evt);
            }
        });
        jPanel20.add(view6);
        view6.setBounds(160, 10, 120, 30);

        view4.setBackground(new java.awt.Color(255, 255, 255));
        view4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view4.setText("Unshare");
        view4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view4ActionPerformed(evt);
            }
        });
        jPanel20.add(view4);
        view4.setBounds(450, 10, 110, 30);

        view7.setBackground(new java.awt.Color(255, 255, 255));
        view7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view7.setText("Declined");
        view7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view7ActionPerformed(evt);
            }
        });
        jPanel20.add(view7);
        view7.setBounds(310, 10, 110, 30);

        jPanel8.add(jPanel20);
        jPanel20.setBounds(220, 20, 590, 50);

        jPanel21.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setLayout(null);

        ADD55.setBackground(new java.awt.Color(255, 255, 255));
        ADD55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD55.setText("Profile");
        ADD55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD55ActionPerformed(evt);
            }
        });
        jPanel21.add(ADD55);
        ADD55.setBounds(40, 350, 100, 30);

        ADD56.setBackground(new java.awt.Color(255, 255, 255));
        ADD56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD56.setText("Users");
        ADD56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD56MouseClicked(evt);
            }
        });
        ADD56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD56ActionPerformed(evt);
            }
        });
        jPanel21.add(ADD56);
        ADD56.setBounds(40, 170, 100, 30);

        ADD57.setBackground(new java.awt.Color(255, 255, 255));
        ADD57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD57.setText("Home");
        ADD57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD57MouseClicked(evt);
            }
        });
        ADD57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD57ActionPerformed(evt);
            }
        });
        jPanel21.add(ADD57);
        ADD57.setBounds(40, 110, 100, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADMIN PANEL");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel21.add(jLabel7);
        jLabel7.setBounds(20, 20, 140, 40);

        ADD59.setBackground(new java.awt.Color(255, 255, 255));
        ADD59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD59.setText("Review");
        ADD59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD59MouseClicked(evt);
            }
        });
        ADD59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD59ActionPerformed(evt);
            }
        });
        jPanel21.add(ADD59);
        ADD59.setBounds(40, 230, 100, 30);

        Logs.setBackground(new java.awt.Color(255, 255, 255));
        Logs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logs.setText("Logs");
        Logs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogsActionPerformed(evt);
            }
        });
        jPanel21.add(Logs);
        Logs.setBounds(40, 290, 100, 30);

        jPanel8.add(jPanel21);
        jPanel21.setBounds(20, 20, 180, 430);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 30, 830, 480);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 880, 530);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        int row = SharedRecipe.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a recipe to update.");
            return;
        }

        try {
            String id = SharedRecipe.getValueAt(row, 0).toString();
            ADD a = new ADD(id);
            a.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    displayRecipes();
                }
            });
            a.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error opening recipe editor: " + ex.getMessage());
        }
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
        try { Search1.setText(""); } catch (Exception ignore) {}
        try { if (category != null && category.getItemCount() > 0) category.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (category1 != null && category1.getItemCount() > 0) category1.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (category3 != null && category3.getItemCount() > 0) category3.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (status != null && status.getItemCount() > 0) status.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (Search4 != null) Search4.setText(""); } catch (Exception ignore) {}
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
        try { Search1.setText(""); } catch (Exception ignore) {}
        try { if (category != null && category.getItemCount() > 0) category.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (category1 != null && category1.getItemCount() > 0) category1.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (category3 != null && category3.getItemCount() > 0) category3.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (status != null && status.getItemCount() > 0) status.setSelectedIndex(0); } catch (Exception ignore) {}
        try { if (Search4 != null) Search4.setText(""); } catch (Exception ignore) {}
        displayRecipes();
    }//GEN-LAST:event_view1ActionPerformed

    private void category1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category1ActionPerformed
        performSearch();
    }//GEN-LAST:event_category1ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        performSearch();
    }//GEN-LAST:event_search1ActionPerformed

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

    private void Search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search4ActionPerformed
        performSearch();
    }//GEN-LAST:event_Search4ActionPerformed

    private void category3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category3ActionPerformed
        performSearch();
    }//GEN-LAST:event_category3ActionPerformed

    private void view4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view4ActionPerformed
        updateSelectedRecipeStatusIf("Approve", null, "Unshare is only allowed when status is Approve.");
    }//GEN-LAST:event_view4ActionPerformed

    private void view5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view5ActionPerformed
        int row = SharedRecipe.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a recipe to view.");
            return;
        }
        String idStr = String.valueOf(SharedRecipe.getValueAt(row, 0));
        View11.openFrom(this, idStr, null, null);
    }//GEN-LAST:event_view5ActionPerformed

    private void view6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view6ActionPerformed
        updateSelectedRecipeStatusIf("processing...", "Approve", "Approve is only allowed when status is processing...");
    }//GEN-LAST:event_view6ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        performSearch();
    }//GEN-LAST:event_statusActionPerformed

    private void view7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view7ActionPerformed
        updateSelectedRecipeStatusIf("processing...", "Declined", "Declined is only allowed when status is processing...");
    }//GEN-LAST:event_view7ActionPerformed

    private void ADD55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD55ActionPerformed
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD55ActionPerformed

    private void ADD56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD56MouseClicked
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD56MouseClicked

    private void ADD56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD56ActionPerformed
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD56ActionPerformed

    private void ADD57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD57MouseClicked
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD57MouseClicked

    private void ADD57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD57ActionPerformed
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD57ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void ADD59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD59MouseClicked
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD59MouseClicked

    private void ADD59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD59ActionPerformed
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD59ActionPerformed

    private void LogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogsActionPerformed
        Logs l = new Logs();
        l.setVisible(true);
        this.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_LogsActionPerformed

    private void displayRecipes() {
        try { con.ensureRecipesTable(); } catch (Exception ignore) {}
        String sql = "SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date, r_status AS Status, r_reviewed_by as \"Reviewed By\" FROM Recipes";
        con.displayData(sql, SharedRecipe);
    }

    private void performSearch() {
        // Text input: prefer Search4 (review panel), fallback to Search1/Search2
        String txt = "";
        try { txt = Search4.getText(); } catch (Exception ignore) {}
        if (txt == null || txt.trim().isEmpty() || "Search recipes by name or ID".equals(txt)) {
            try { txt = Search1.getText(); } catch (Exception ignore) {}
        }
        if (txt == null || "Search recipes by name or ID".equals(txt)) txt = "";
        txt = txt.trim();

        // Category: align to category3 like View.java; ignore "All Category"
        String cat = "";
        try { cat = String.valueOf(category3.getSelectedItem()); } catch (Exception ignore) {}
        if (cat == null) cat = "";

        // Status
        String selStatus = "";
        try { selStatus = String.valueOf(status.getSelectedItem()); } catch (Exception ignore) {}
        if (selStatus == null) selStatus = "";

        StringBuilder sql = new StringBuilder("SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date, r_status AS Status, r_reviewed_by as \"Reviewed By\" FROM Recipes WHERE 1=1");
        java.util.List<Object> params = new java.util.ArrayList<>();

        if (!txt.isEmpty()) {
            sql.append(" AND (r_title LIKE ? OR CAST(r_id AS TEXT) LIKE ? OR r_author LIKE ?)");
            String pattern = "%" + txt + "%";
            params.add(pattern);
            params.add(pattern);
            params.add(pattern);
        }

        if (!cat.isEmpty() && !"All Category".equalsIgnoreCase(cat)) {
            sql.append(" AND r_category = ?");
            params.add(cat);
        }

        String st = selStatus.trim();
        if (!st.isEmpty() && !"All Status".equalsIgnoreCase(st)) {
            if ("Null".equalsIgnoreCase(st)) {
                sql.append(" AND (r_status IS NULL OR TRIM(r_status) = '')");
            } else {
                sql.append(" AND r_status = ?");
                params.add(st);
            }
        }

        sql.append(" ORDER BY r_id DESC");

        con.displayData(sql.toString(), SharedRecipe, params.toArray());
    }

    private void deleteSelectedRecipe() {
        int row = SharedRecipe.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a recipe to delete.");
            return;
        }

        String idStr = String.valueOf(SharedRecipe.getValueAt(row, 0));
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

    private void updateSelectedRecipeStatus(String status) {
        int row = SharedRecipe.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a recipe first.");
            return;
        }
        String idStr = String.valueOf(SharedRecipe.getValueAt(row, 0));
        String adminUsername = config.Session.getInstance().getUsername();
        try {
            int id = Integer.parseInt(idStr);
            if (status == null) {
                con.updateRecord("UPDATE Recipes SET r_status = NULL, r_reviewed_by = ? WHERE r_id = ?", adminUsername, id);
            } else {
                con.updateRecord("UPDATE Recipes SET r_status = ?, r_reviewed_by = ? WHERE r_id = ?", status, adminUsername, id);
            }
            JOptionPane.showMessageDialog(this, "Status updated to " + status + ".");
            displayRecipes();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid recipe ID: " + idStr);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to update status: " + ex.getMessage());
        }
    }

    private void updateSelectedRecipeStatusIf(String requiredCurrent, String newStatus, String failMessage) {
        int row = SharedRecipe.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a recipe first.");
            return;
        }
        int statusCol = -1;
        try {
            for (int i = 0; i < SharedRecipe.getColumnCount(); i++) {
                String name = SharedRecipe.getColumnName(i);
                if (name != null && name.equalsIgnoreCase("Status")) {
                    statusCol = i;
                    break;
                }
            }
        } catch (Exception ignore) {}
        String current = "";
        if (statusCol >= 0) {
            Object val = SharedRecipe.getValueAt(row, statusCol);
            current = val == null ? "" : String.valueOf(val).trim();
        }
        String req = requiredCurrent == null ? "" : requiredCurrent.trim();
        boolean ok = current.equalsIgnoreCase(req);
        if (!ok) {
            JOptionPane.showMessageDialog(this, failMessage);
            return;
        }
        if (newStatus == null) {
            updateSelectedRecipeStatus(null);
        } else {
            updateSelectedRecipeStatus(newStatus);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (config.Session.getInstance().isLoggedIn()) {
                    new review().setVisible(true);
                } else {
                    new landingPage1().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD11;
    private javax.swing.JButton ADD12;
    private javax.swing.JButton ADD36;
    private javax.swing.JButton ADD41;
    private javax.swing.JButton ADD42;
    private javax.swing.JButton ADD43;
    private javax.swing.JButton ADD44;
    private javax.swing.JButton ADD55;
    private javax.swing.JButton ADD56;
    private javax.swing.JButton ADD57;
    private javax.swing.JButton ADD59;
    private javax.swing.JButton ADD7;
    private javax.swing.JButton Logs;
    private javax.swing.JTextField Search1;
    private javax.swing.JTextField Search2;
    private javax.swing.JTextField Search4;
    private javax.swing.JTable SharedRecipe;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<String> category1;
    private javax.swing.JComboBox<String> category3;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton search;
    private javax.swing.JButton search1;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JButton view;
    private javax.swing.JButton view1;
    private javax.swing.JButton view4;
    private javax.swing.JButton view5;
    private javax.swing.JButton view6;
    private javax.swing.JButton view7;
    // End of variables declaration//GEN-END:variables
}
