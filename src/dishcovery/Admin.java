package dishcovery;
import javax.swing.JOptionPane;

public class Admin extends javax.swing.JFrame {
    private final config.config con = new config.config();

    void displayUser(){
        try {
            int totalUsers = getTotalUsers();
            int pendingApprovals = getPendingApprovals();
            int totalRecipes = getTotalRecipes();
            int sharedRecipes = getTotalSharedRecipes();
            
            TotalUsers.setText(String.valueOf(totalUsers));
            PendingApprovals.setText(String.valueOf(pendingApprovals));
            TotalRecipes.setText(String.valueOf(totalRecipes));
            SharedRecipes.setText(String.valueOf(sharedRecipes));
            
            displayRecentlySharedRecipes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private int getTotalUsers() {
        try {
            String sql = "SELECT COUNT(*) as cnt FROM Users";
            java.util.List<java.util.Map<String, Object>> result = con.fetchRecords(sql);
            if (!result.isEmpty()) {
                return Integer.parseInt(String.valueOf(result.get(0).get("cnt")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private int getPendingApprovals() {
        try {
            String sql = "SELECT COUNT(*) as cnt FROM Users WHERE u_approved = 0";
            java.util.List<java.util.Map<String, Object>> result = con.fetchRecords(sql);
            if (!result.isEmpty()) {
                return Integer.parseInt(String.valueOf(result.get(0).get("cnt")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private int getTotalRecipes() {
        try {
            String sql = "SELECT COUNT(*) as cnt FROM Recipes";
            java.util.List<java.util.Map<String, Object>> result = con.fetchRecords(sql);
            if (!result.isEmpty()) {
                return Integer.parseInt(String.valueOf(result.get(0).get("cnt")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private int getTotalSharedRecipes() {
        try {
            String sql = "SELECT COUNT(*) as cnt FROM Recipes WHERE r_status = 'Approve'";
            java.util.List<java.util.Map<String, Object>> result = con.fetchRecords(sql);
            if (!result.isEmpty()) {
                return Integer.parseInt(String.valueOf(result.get(0).get("cnt")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private void displayRecentlySharedRecipes() {
        try {
            String sql = "SELECT r_title, r_author, r_category, r_date FROM Recipes WHERE r_status = 'Approve' ORDER BY r_date DESC LIMIT 10";
            java.util.List<java.util.Map<String, Object>> recipes = con.fetchRecords(sql);
            
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {"Title", "Author", "Category", "Date"}
            ) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            RecentlyrecipeUploadsTable.setModel(model);

            for (java.util.Map<String, Object> row : recipes) {
                String title = String.valueOf(row.getOrDefault("r_title", ""));
                String author = String.valueOf(row.getOrDefault("r_author", ""));
                String category = String.valueOf(row.getOrDefault("r_category", ""));
                String date = String.valueOf(row.getOrDefault("r_date", ""));
                model.addRow(new Object[]{title, author, category, date});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Admin() {
        config.Session.requireAdmin(this);
        if (!config.Session.getInstance().isLoggedIn() || !"Admin".equalsIgnoreCase(config.Session.getInstance().getRole())) {
            return;
        }
        initComponents();
        displayUser();
        
        RecentlyrecipeUploadsTable.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && RecentlyrecipeUploadsTable.getSelectedRow() != -1) {
                    int selectedRow = RecentlyrecipeUploadsTable.getSelectedRow();
                    String title = (String) RecentlyrecipeUploadsTable.getValueAt(selectedRow, 0);
                    // JOptionPane.showMessageDialog(Admin.this, "Selected: " + title);
                }
            }
        });
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
        jLabel8 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        ADD45 = new javax.swing.JButton();
        ADD46 = new javax.swing.JButton();
        ADD47 = new javax.swing.JButton();
        ADD48 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ADD49 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        ADD35 = new javax.swing.JButton();
        ADD37 = new javax.swing.JButton();
        ADD38 = new javax.swing.JButton();
        ADD39 = new javax.swing.JButton();
        ADD40 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        TotalUsers = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        SharedRecipes = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TotalRecipes = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        PendingApprovals = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RecentlyrecipeUploadsTable = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        ADD55 = new javax.swing.JButton();
        ADD56 = new javax.swing.JButton();
        ADD57 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ADD59 = new javax.swing.JButton();
        Logs = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        ADD50 = new javax.swing.JButton();
        ADD51 = new javax.swing.JButton();
        ADD52 = new javax.swing.JButton();
        ADD53 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ADD54 = new javax.swing.JButton();

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("USERS");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel19.setLayout(null);

        ADD45.setBackground(new java.awt.Color(255, 255, 255));
        ADD45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD45.setText("Approve");
        ADD45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD45ActionPerformed(evt);
            }
        });
        jPanel19.add(ADD45);
        ADD45.setBounds(40, 290, 100, 30);

        ADD46.setBackground(new java.awt.Color(255, 255, 255));
        ADD46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD46.setText("Profile");
        ADD46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD46ActionPerformed(evt);
            }
        });
        jPanel19.add(ADD46);
        ADD46.setBounds(40, 350, 100, 30);

        ADD47.setBackground(new java.awt.Color(255, 255, 255));
        ADD47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD47.setText("Users");
        ADD47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD47MouseClicked(evt);
            }
        });
        ADD47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD47ActionPerformed(evt);
            }
        });
        jPanel19.add(ADD47);
        ADD47.setBounds(40, 170, 100, 30);

        ADD48.setBackground(new java.awt.Color(255, 255, 255));
        ADD48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD48.setText("Home");
        ADD48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD48MouseClicked(evt);
            }
        });
        ADD48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD48ActionPerformed(evt);
            }
        });
        jPanel19.add(ADD48);
        ADD48.setBounds(40, 110, 100, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ADMIN PANEL");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel19.add(jLabel4);
        jLabel4.setBounds(20, 20, 140, 40);

        ADD49.setBackground(new java.awt.Color(255, 255, 255));
        ADD49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD49.setText("Review");
        ADD49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD49MouseClicked(evt);
            }
        });
        ADD49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD49ActionPerformed(evt);
            }
        });
        jPanel19.add(ADD49);
        ADD49.setBounds(40, 230, 100, 30);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

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
        jPanel17.add(ADD35);
        ADD35.setBounds(40, 290, 100, 30);

        ADD37.setBackground(new java.awt.Color(255, 255, 255));
        ADD37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD37.setText("Profile");
        jPanel17.add(ADD37);
        ADD37.setBounds(40, 350, 100, 30);

        ADD38.setBackground(new java.awt.Color(255, 255, 255));
        ADD38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD38.setText("Users");
        jPanel17.add(ADD38);
        ADD38.setBounds(40, 170, 100, 30);

        ADD39.setBackground(new java.awt.Color(255, 255, 255));
        ADD39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD39.setText("Home");
        jPanel17.add(ADD39);
        ADD39.setBounds(40, 110, 100, 30);

        ADD40.setBackground(new java.awt.Color(255, 255, 255));
        ADD40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD40.setText("Review");
        jPanel17.add(ADD40);
        ADD40.setBounds(40, 230, 100, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ADMIN PANEL");
        jPanel17.add(jLabel5);
        jLabel5.setBounds(20, 20, 140, 40);

        jPanel8.add(jPanel17);
        jPanel17.setBounds(20, 20, 180, 430);

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 0, -1, -1));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel10.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255,100));
        jPanel1.setLayout(null);

        TotalUsers.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalUsers.setForeground(new java.awt.Color(255, 255, 255));
        TotalUsers.setText("0");
        jPanel1.add(TotalUsers);
        TotalUsers.setBounds(50, 50, 80, 30);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Total Users");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(30, 20, 110, 30);

        jPanel10.add(jPanel1);
        jPanel1.setBounds(230, 110, 130, 100);

        jPanel11.setBackground(new java.awt.Color(222, 222, 133,100));
        jPanel11.setLayout(null);

        SharedRecipes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SharedRecipes.setForeground(new java.awt.Color(255, 255, 255));
        SharedRecipes.setText("0");
        jPanel11.add(SharedRecipes);
        SharedRecipes.setBounds(50, 50, 80, 30);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Shared Recipes");
        jPanel11.add(jLabel21);
        jLabel21.setBounds(10, 20, 110, 30);

        jPanel10.add(jPanel11);
        jPanel11.setBounds(680, 110, 130, 100);

        jPanel4.setBackground(new java.awt.Color(145, 204, 87,100));
        jPanel4.setLayout(null);

        TotalRecipes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalRecipes.setForeground(new java.awt.Color(255, 255, 255));
        TotalRecipes.setText("0");
        jPanel4.add(TotalRecipes);
        TotalRecipes.setBounds(50, 50, 80, 30);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Total Recipes");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(20, 20, 110, 30);

        jPanel10.add(jPanel4);
        jPanel4.setBounds(530, 110, 130, 100);

        jPanel2.setBackground(new java.awt.Color(255, 109, 109,100));
        jPanel2.setLayout(null);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Pending Approvals");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(0, 20, 130, 30);

        PendingApprovals.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PendingApprovals.setForeground(new java.awt.Color(255, 255, 255));
        PendingApprovals.setText("0");
        jPanel2.add(PendingApprovals);
        PendingApprovals.setBounds(50, 50, 80, 30);

        jPanel10.add(jPanel2);
        jPanel2.setBounds(380, 110, 130, 100);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Users");
        jPanel10.add(jLabel11);
        jLabel11.setBounds(480, 10, 150, 30);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Search,review and manage Users");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(410, 40, 260, 30);

        jPanel22.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Recent Recipe Uploads");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel22.add(jLabel10);
        jLabel10.setBounds(180, 0, 210, 40);

        RecentlyrecipeUploadsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        RecentlyrecipeUploadsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecentlyrecipeUploadsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RecentlyrecipeUploadsTable);

        jPanel22.add(jScrollPane1);
        jScrollPane1.setBounds(0, 40, 580, 190);

        jPanel10.add(jPanel22);
        jPanel22.setBounds(230, 220, 580, 230);

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

        jPanel10.add(jPanel21);
        jPanel21.setBounds(20, 20, 180, 430);

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 830, 480));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        jPanel20.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel20.setLayout(null);

        ADD50.setBackground(new java.awt.Color(255, 255, 255));
        ADD50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD50.setText("Approve");
        ADD50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD50ActionPerformed(evt);
            }
        });
        jPanel20.add(ADD50);
        ADD50.setBounds(40, 290, 100, 30);

        ADD51.setBackground(new java.awt.Color(255, 255, 255));
        ADD51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD51.setText("Profile");
        ADD51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD51ActionPerformed(evt);
            }
        });
        jPanel20.add(ADD51);
        ADD51.setBounds(40, 350, 100, 30);

        ADD52.setBackground(new java.awt.Color(255, 255, 255));
        ADD52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD52.setText("Users");
        ADD52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD52MouseClicked(evt);
            }
        });
        ADD52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD52ActionPerformed(evt);
            }
        });
        jPanel20.add(ADD52);
        ADD52.setBounds(40, 170, 100, 30);

        ADD53.setBackground(new java.awt.Color(255, 255, 255));
        ADD53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD53.setText("Home");
        ADD53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD53MouseClicked(evt);
            }
        });
        ADD53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD53ActionPerformed(evt);
            }
        });
        jPanel20.add(ADD53);
        ADD53.setBounds(40, 110, 100, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ADMIN PANEL");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel20.add(jLabel6);
        jLabel6.setBounds(20, 20, 140, 40);

        ADD54.setBackground(new java.awt.Color(255, 255, 255));
        ADD54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD54.setText("Review");
        ADD54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD54MouseClicked(evt);
            }
        });
        ADD54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD54ActionPerformed(evt);
            }
        });
        jPanel20.add(ADD54);
        ADD54.setBounds(40, 230, 100, 30);

        getContentPane().add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void ADD7ActionPerformed(java.awt.event.ActionEvent evt) {
        deleteSelectedRecipe();
    }

    private void ADD11ActionPerformed(java.awt.event.ActionEvent evt) {
        adding1 a = new adding1();
        a.setVisible(true);
        this.dispose();
    }

    private void ADD12ActionPerformed(java.awt.event.ActionEvent evt) {
        ADD12MouseClicked(null);
    }

    private void ADD35ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD37ActionPerformed(java.awt.event.ActionEvent evt) {
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD38MouseClicked(java.awt.event.MouseEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD38ActionPerformed(java.awt.event.ActionEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();          
    }

    private void ADD39MouseClicked(java.awt.event.MouseEvent evt) {
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD39ActionPerformed(java.awt.event.ActionEvent evt) {
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();        
    }

    private void ADD36ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD41ActionPerformed(java.awt.event.ActionEvent evt) {
        share l = new share();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD42ActionPerformed(java.awt.event.ActionEvent evt) {
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD43MouseClicked(java.awt.event.MouseEvent evt) {
        Manage l = new Manage();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD43ActionPerformed(java.awt.event.ActionEvent evt) {
        Manage l = new Manage();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD44MouseClicked(java.awt.event.MouseEvent evt) {
        homePage2 l = new homePage2();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD44ActionPerformed(java.awt.event.ActionEvent evt) {
        homePage2 l = new homePage2();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD45ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD46ActionPerformed(java.awt.event.ActionEvent evt) {
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD47MouseClicked(java.awt.event.MouseEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD47ActionPerformed(java.awt.event.ActionEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD48MouseClicked(java.awt.event.MouseEvent evt) {
        homePage2 l = new homePage2();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD48ActionPerformed(java.awt.event.ActionEvent evt) {
        homePage2 l = new homePage2();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD49MouseClicked(java.awt.event.MouseEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD49ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD50ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD51ActionPerformed(java.awt.event.ActionEvent evt) {
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD52MouseClicked(java.awt.event.MouseEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD52ActionPerformed(java.awt.event.ActionEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD53MouseClicked(java.awt.event.MouseEvent evt) {
        homePage2 l = new homePage2();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD53ActionPerformed(java.awt.event.ActionEvent evt) {
        homePage2 l = new homePage2();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD54MouseClicked(java.awt.event.MouseEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD54ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }



 



    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }



    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void performSearch() {
        String kw = Search1.getText().trim();
        
        String sql = "SELECT r_title, r_author, r_category, r_date FROM Recipes WHERE r_shared = 1 ";
        java.util.List<Object> params = new java.util.ArrayList<>();
        
        if (!kw.isEmpty() && !"Search recipes by name or ID".equals(kw)) {
            sql += " AND (r_title LIKE ? OR r_author LIKE ?)";
            params.add("%" + kw + "%");
            params.add("%" + kw + "%");
        }
        
        sql += " ORDER BY r_date DESC LIMIT 10";
        
        try {
            java.util.List<java.util.Map<String, Object>> recipes = con.fetchRecords(sql, params.toArray());
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) RecentlyrecipeUploadsTable.getModel();
            model.setRowCount(0);
            for (java.util.Map<String, Object> row : recipes) {
                model.addRow(new Object[]{
                    row.get("r_title"), row.get("r_author"), row.get("r_category"), row.get("r_date")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {
        int row = RecentlyrecipeUploadsTable.getSelectedRow();
        if (row >= 0) {
            String title = String.valueOf(RecentlyrecipeUploadsTable.getValueAt(row, 0));
            String sql = "SELECT r_id FROM Recipes WHERE r_title = ?";
            java.util.List<java.util.Map<String, Object>> results = con.fetchRecords(sql, title);
            if (!results.isEmpty()) {
                String id = String.valueOf(results.get(0).get("r_id"));
                View11.openFrom(this, id, null, null);
            } else {
                JOptionPane.showMessageDialog(this, "Could not find recipe ID for: " + title);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a recipe first.");
        }
    }

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void ADD11MouseEntered(java.awt.event.MouseEvent evt) {
    }

    private void ADD12MouseClicked(java.awt.event.MouseEvent evt) {
        int row = RecentlyrecipeUploadsTable.getSelectedRow();
        if (row >= 0) {
            String title = String.valueOf(RecentlyrecipeUploadsTable.getValueAt(row, 0));
            // Fetch ID based on title since ID might not be in the table model
            String sql = "SELECT r_id FROM Recipes WHERE r_title = ?";
            java.util.List<java.util.Map<String, Object>> results = con.fetchRecords(sql, title);
            if (!results.isEmpty()) {
                String id = String.valueOf(results.get(0).get("r_id"));
                ADD updateFrame = new ADD(id);
                updateFrame.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Could not find recipe ID for: " + title);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a recipe from the table first.");
        }
    }

    private void ADD40MouseClicked(java.awt.event.MouseEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD40ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void displayCategoryPieChart() {
        JOptionPane.showMessageDialog(this, "Displaying Category Analytics...");
    }

    private void deleteSelectedRecipe() {
        int row = RecentlyrecipeUploadsTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a recipe to delete.");
            return;
        }
        
        String title = String.valueOf(RecentlyrecipeUploadsTable.getValueAt(row, 0));
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete the recipe: " + title + "?",
            "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                con.deleteRecord("DELETE FROM Recipes WHERE r_title = ?", title);
                JOptionPane.showMessageDialog(this, "Recipe deleted successfully.");
                displayRecentlySharedRecipes();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error deleting recipe: " + e.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

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
    private javax.swing.JButton ADD45;
    private javax.swing.JButton ADD46;
    private javax.swing.JButton ADD47;
    private javax.swing.JButton ADD48;
    private javax.swing.JButton ADD49;
    private javax.swing.JButton ADD50;
    private javax.swing.JButton ADD51;
    private javax.swing.JButton ADD52;
    private javax.swing.JButton ADD53;
    private javax.swing.JButton ADD54;
    private javax.swing.JButton ADD55;
    private javax.swing.JButton ADD56;
    private javax.swing.JButton ADD57;
    private javax.swing.JButton ADD59;
    private javax.swing.JButton ADD7;
    private javax.swing.JButton Logs;
    private javax.swing.JLabel PendingApprovals;
    private javax.swing.JTable RecentlyrecipeUploadsTable;
    private javax.swing.JTextField Search1;
    private javax.swing.JTextField Search2;
    private javax.swing.JLabel SharedRecipes;
    private javax.swing.JLabel TotalRecipes;
    private javax.swing.JLabel TotalUsers;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<String> category1;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JButton view;
    private javax.swing.JButton view1;
    // End of variables declaration//GEN-END:variables

    // Missing event handler methods - added to fix compilation errors
    private void ADD7MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO: Implement Delete button mouse clicked handler
    }

    private void ADD11MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO: Implement ADD button mouse clicked handler
    }

    private void Search2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Implement Search2 action performed handler
    }

    private void view1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Implement view1 action performed handler
    }

    private void category1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Implement category1 action performed handler
    }

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Implement search1 action performed handler
    }

    private void RecentlyrecipeUploadsTableMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO: Implement table mouse clicked handler
    }

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO: Implement jLabel10 mouse clicked handler
    }
}