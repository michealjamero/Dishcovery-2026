package dishcovery;
import dishcovery.ADD;
import dishcovery.View;
import dishcovery.homePage2;
import dishcovery.login;
import dishcovery.profile;
import dishcovery.share;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Manage extends javax.swing.JFrame {
    private final config.config con = new config.config();

    public Manage() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        try {
            if (status != null) {
                status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
                        "All Status", "processing...", "Approve", "Declined", "Null"
                }));
            }
        } catch (Exception ignore) {}
        attachSearchListeners();
        displayRecipes();
    }

    private void displayRecipes() {
        try {
            con.ensureRecipesTable();
            String sql = "SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date, r_status AS Status " +
                         "FROM Recipes WHERE LOWER(r_author) = LOWER(?) ORDER BY r_id DESC";
            String user = config.Session.getInstance().getUsername();
            con.displayData(sql, recipeTable, user);
        } catch (Exception e) {
            System.out.println("Error loading recipes: " + e.getMessage());
        }
    }

    private void attachSearchListeners() {
        try {
            javax.swing.event.DocumentListener dl = new javax.swing.event.DocumentListener() {
                public void insertUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void removeUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void changedUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
            };
            if (Search1 != null && Search1.getDocument() != null) {
                Search1.getDocument().addDocumentListener(dl);
            }
            if (Search != null && Search.getDocument() != null) {
                Search.getDocument().addDocumentListener(dl);
            }
        } catch (Exception ignore) {}
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jDialog1 = new javax.swing.JDialog();
        choice1 = new java.awt.Choice();
        canvas1 = new java.awt.Canvas();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Search = new javax.swing.JTextField();
        ADD13 = new javax.swing.JButton();
        category1 = new javax.swing.JComboBox<>();
        ADD14 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ADD15 = new javax.swing.JButton();
        ADD16 = new javax.swing.JButton();
        ADD17 = new javax.swing.JButton();
        ADD18 = new javax.swing.JButton();
        ADD19 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        ADD7 = new javax.swing.JButton();
        ADD11 = new javax.swing.JButton();
        ADD12 = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        Search1 = new javax.swing.JTextField();
        view = new javax.swing.JButton();
        category3 = new javax.swing.JComboBox<>();
        status = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        Vewphp = new javax.swing.JButton();
        ADD36 = new javax.swing.JButton();
        ADD37 = new javax.swing.JButton();
        ADD38 = new javax.swing.JButton();
        ADD39 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel23.setText("jLabel12");

        jPanel9.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(null);

        Search.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search.setText("Search recipes by name or ID");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel7.add(Search);
        Search.setBounds(10, 10, 270, 30);

        ADD13.setBackground(new java.awt.Color(255, 255, 255));
        ADD13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD13.setText("Refresh");
        ADD13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD13ActionPerformed(evt);
            }
        });
        jPanel7.add(ADD13);
        ADD13.setBounds(390, 10, 100, 30);

        category1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category1ActionPerformed(evt);
            }
        });
        jPanel7.add(category1);
        category1.setBounds(500, 10, 80, 20);

        ADD14.setBackground(new java.awt.Color(255, 255, 255));
        ADD14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD14.setText("Search");
        ADD14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD14ActionPerformed(evt);
            }
        });
        jPanel7.add(ADD14);
        ADD14.setBounds(290, 10, 90, 30);

        jPanel9.add(jPanel7);
        jPanel7.setBounds(230, 20, 590, 50);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(null);
        jPanel9.add(jPanel10);
        jPanel10.setBounds(230, 70, 590, 390);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(null);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/small logo.png"))); // NOI18N
        jLabel10.setText("jLabel9");
        jPanel11.add(jLabel10);
        jLabel10.setBounds(10, 20, 140, 120);

        ADD15.setBackground(new java.awt.Color(255, 255, 255));
        ADD15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD15.setText("Logout");
        ADD15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD15ActionPerformed(evt);
            }
        });
        jPanel11.add(ADD15);
        ADD15.setBounds(40, 350, 90, 30);

        ADD16.setBackground(new java.awt.Color(255, 255, 255));
        ADD16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD16.setText("Manage");
        ADD16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD16ActionPerformed(evt);
            }
        });
        jPanel11.add(ADD16);
        ADD16.setBounds(40, 150, 90, 30);

        ADD17.setBackground(new java.awt.Color(255, 255, 255));
        ADD17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD17.setText("View");
        ADD17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD17ActionPerformed(evt);
            }
        });
        jPanel11.add(ADD17);
        ADD17.setBounds(40, 200, 90, 30);

        ADD18.setBackground(new java.awt.Color(255, 255, 255));
        ADD18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD18.setText("Share");
        ADD18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD18ActionPerformed(evt);
            }
        });
        jPanel11.add(ADD18);
        ADD18.setBounds(40, 250, 90, 30);

        ADD19.setBackground(new java.awt.Color(255, 255, 255));
        ADD19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD19.setText("Profile");
        ADD19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD19ActionPerformed(evt);
            }
        });
        jPanel11.add(ADD19);
        ADD19.setBounds(40, 300, 90, 30);

        jPanel9.add(jPanel11);
        jPanel11.setBounds(20, 20, 180, 440);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0,100));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(null);

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
        jPanel8.add(ADD7);
        ADD7.setBounds(460, 10, 110, 30);

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
        jPanel8.add(ADD11);
        ADD11.setBounds(20, 10, 110, 30);

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
        jPanel8.add(ADD12);
        ADD12.setBounds(170, 10, 110, 30);

        print.setBackground(new java.awt.Color(255, 255, 255));
        print.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        print.setText("Print");
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel8.add(print);
        print.setBounds(320, 10, 110, 30);

        jPanel12.add(jPanel8);
        jPanel8.setBounds(220, 20, 590, 50);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(null);

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        recipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(recipeTable);

        jPanel14.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 590, 360);

        jPanel12.add(jPanel14);
        jPanel14.setBounds(220, 130, 590, 360);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(null);

        Search1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search1ActionPerformed(evt);
            }
        });
        jPanel13.add(Search1);
        Search1.setBounds(10, 10, 250, 30);

        view.setBackground(new java.awt.Color(255, 255, 255));
        view.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        jPanel13.add(view);
        view.setBounds(270, 10, 83, 30);

        category3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Category", "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category3ActionPerformed(evt);
            }
        });
        jPanel13.add(category3);
        category3.setBounds(370, 10, 100, 30);

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Status", "processing...", "Approve", "Declined", "Null" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel13.add(status);
        status.setBounds(480, 10, 90, 30);

        jPanel12.add(jPanel13);
        jPanel13.setBounds(220, 80, 590, 50);

        jPanel17.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(null);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/small logo.png"))); // NOI18N
        jLabel28.setText("jLabel9");
        jPanel17.add(jLabel28);
        jLabel28.setBounds(10, 10, 140, 120);

        Vewphp.setBackground(new java.awt.Color(255, 255, 255));
        Vewphp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Vewphp.setText("View");
        Vewphp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VewphpActionPerformed(evt);
            }
        });
        jPanel17.add(Vewphp);
        Vewphp.setBounds(40, 270, 90, 30);

        ADD36.setBackground(new java.awt.Color(255, 255, 255));
        ADD36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD36.setText("Share");
        ADD36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD36ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD36);
        ADD36.setBounds(40, 320, 90, 30);

        ADD37.setBackground(new java.awt.Color(255, 255, 255));
        ADD37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD37.setText("Profile");
        ADD37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD37ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD37);
        ADD37.setBounds(40, 370, 90, 30);

        ADD38.setBackground(new java.awt.Color(255, 255, 255));
        ADD38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD38.setText("Manage");
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
        ADD38.setBounds(40, 220, 90, 30);

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
        ADD39.setBounds(40, 170, 90, 30);

        jPanel12.add(jPanel17);
        jPanel17.setBounds(20, 20, 180, 470);

        jPanel2.add(jPanel12);
        jPanel12.setBounds(20, 40, 840, 510);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel24.setText("jLabel12");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(0, 10, 880, 570);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 880, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VewphpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VewphpActionPerformed
        View l = new View();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VewphpActionPerformed

    private void ADD36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD36ActionPerformed
        share p = new share();
        p.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_ADD36ActionPerformed

    private void ADD37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD37ActionPerformed
        if ("Admin".equalsIgnoreCase(config.Session.getInstance().getRole())) {
            new profile().setVisible(true);
        } else {
            new profileadmin().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_ADD37ActionPerformed

    private void ADD38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD38MouseClicked
        displayRecipes();
    }//GEN-LAST:event_ADD38MouseClicked

    private void ADD38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD38ActionPerformed
        displayRecipes();
    }//GEN-LAST:event_ADD38ActionPerformed

    private void ADD39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD39MouseClicked
        homePage2 h = new homePage2();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD39MouseClicked

    private void ADD39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD39ActionPerformed
  homePage2 h = new homePage2();
        h.setVisible(true);
        this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_ADD39ActionPerformed

    private void printMouseClicked(java.awt.event.MouseEvent evt) {
        handlePrint();
    }

    private void printActionPerformed(java.awt.event.ActionEvent evt) {
        handlePrint();
    }

    private void handlePrint() {
        int row = recipeTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a recipe from the table to print.");
            return;
        }
        
        Object idObj = recipeTable.getValueAt(row, 0);
        String recipeId = String.valueOf(idObj);
        
        // Fetch full recipe details
        String sql = "SELECT * FROM Recipes WHERE r_id = ?";
        List<java.util.Map<String, Object>> records = con.fetchRecords(sql, recipeId);
        
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Could not find recipe details in database.");
            return;
        }
        
        java.util.Map<String, Object> recipe = records.get(0);
        String title = recipe.get("r_title") != null ? String.valueOf(recipe.get("r_title")).toUpperCase() : "UNTITLED RECIPE";
        String author = recipe.get("r_author") != null ? String.valueOf(recipe.get("r_author")) : "Unknown";
        String category = recipe.get("r_category") != null ? String.valueOf(recipe.get("r_category")) : "Uncategorized";
        String prepTime = recipe.get("r_prep_time") != null ? String.valueOf(recipe.get("r_prep_time")) : "0";
        String cookTime = recipe.get("r_cook_time") != null ? String.valueOf(recipe.get("r_cook_time")) : "0";
        String servings = recipe.get("r_servings") != null ? String.valueOf(recipe.get("r_servings")) : "0";
        String ingredients = recipe.get("r_ingredients") != null ? String.valueOf(recipe.get("r_ingredients")).replace("\n", "<br>") : "None";
        String instructions = recipe.get("r_instructions") != null ? String.valueOf(recipe.get("r_instructions")).replace("\n", "<br>") : "None";
        
        int rIdInt = -1;
        try {
            rIdInt = Integer.parseInt(recipeId);
        } catch (Exception ignore) {}
        
        // Construct HTML for proper layout
        String htmlContent = "<html>" +
                "<body style='font-family: serif; padding: 40px; color: #333;'>" +
                "<div style='text-align: center; border-bottom: 2px solid #2c3e50; padding-bottom: 10px;'>" +
                "<h1 style='margin: 0; color: #2c3e50;'>DISHCOVERY</h1>" +
                "<p style='margin: 5px 0; font-style: italic;'>Your Digital Recipe Companion</p>" +
                "</div>" +
                
                "<div style='margin-top: 30px;'>" +
                "<h2 style='color: #e67e22; margin-bottom: 5px;'>" + title + "</h2>" +
                "<p style='margin: 0; font-size: 12pt;'><b>By:</b> " + author + " | <b>Category:</b> " + category + "</p>" +
                "</div>" +
                
                "<div style='margin-top: 20px; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #e67e22;'>" +
                "<table style='width: 100%; font-size: 11pt;'>" +
                "<tr>" +
                "<td><b>Prep Time:</b> " + prepTime + " mins</td>" +
                "<td><b>Cook Time:</b> " + cookTime + " mins</td>" +
                "<td><b>Servings:</b> " + servings + "</td>" +
                "</tr>" +
                "</table>" +
                "</div>" +
                
                "<div style='margin-top: 30px;'>" +
                "<h3 style='border-bottom: 1px solid #bdc3c7; padding-bottom: 5px; color: #2c3e50;'>INGREDIENTS</h3>" +
                "<div style='padding-left: 20px; line-height: 1.6;'>" + ingredients + "</div>" +
                "</div>" +
                
                "<div style='margin-top: 30px;'>" +
                "<h3 style='border-bottom: 1px solid #bdc3c7; padding-bottom: 5px; color: #2c3e50;'>INSTRUCTIONS</h3>" +
                "<div style='padding-left: 20px; line-height: 1.6; text-align: justify;'>" + instructions + "</div>" +
                "</div>" +
                
                "<div style='margin-top: 50px; text-align: center; font-size: 9pt; color: #7f8c8d; border-top: 1px solid #eee; padding-top: 10px;'>" +
                "Printed via Dishcovery App &copy; " + new java.util.Date().toString().substring(24) +
                "</div>" +
                "</body></html>";

        showPrintPreview(title, htmlContent, rIdInt, String.valueOf(recipe.get("r_title")));
    }

    private void showPrintPreview(final String title, String htmlContent, final int rId, final String rTitle) {
        final javax.swing.JDialog dialog = new javax.swing.JDialog(this, "Print Preview", true);
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.getContentPane().setLayout(new java.awt.BorderLayout());

        final javax.swing.JEditorPane printPane = new javax.swing.JEditorPane();
        printPane.setContentType("text/html");
        printPane.setText(htmlContent);
        printPane.setEditable(false);
        try {
            printPane.setCaretPosition(0);
        } catch (Exception ignored) {
        }

        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(printPane);
        dialog.getContentPane().add(scroll, java.awt.BorderLayout.CENTER);

        javax.swing.JPanel buttons = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        javax.swing.JButton cancelBtn = new javax.swing.JButton("Cancel");
        javax.swing.JButton printBtn = new javax.swing.JButton("Print");
        buttons.add(cancelBtn);
        buttons.add(printBtn);
        dialog.getContentPane().add(buttons, java.awt.BorderLayout.SOUTH);

        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dialog.dispose();
            }
        });

        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    boolean complete = printPane.print(
                            new java.text.MessageFormat(title),
                            new java.text.MessageFormat("Page {0}"),
                            true, null, null, true
                    );
                    if (complete) {
                        // Log the print action
                        int uId = config.Session.getInstance().getId();
                        con.performPrint(uId, rId);
                        
                        JOptionPane.showMessageDialog(dialog, "Recipe successfully sent to printer.", "Print Job Complete", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (java.awt.print.PrinterException ex) {
                    JOptionPane.showMessageDialog(dialog, "Printer Error: " + ex.getMessage(), "Printing Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dialog.setSize(700, 800);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void ADD7ActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] options = {"Delete Recipe", "Delete Ingredients", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this,
                "Choose deletion target:",
                "Delete",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            deleteSelectedRecipe();
        } else if (choice == 1) {
            int row = recipeTable.getSelectedRow();
            if (row >= 0) {
                Object idObj = recipeTable.getValueAt(row, 0);
                String idStr = String.valueOf(idObj);
                if (!idStr.isEmpty()) {
                    new adding1(idStr, "delete").setVisible(true);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a recipe from the table first.");
            }
        }
    }

    private void ADD11ActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] options = {"Add Recipe", "Add Ingredients", "Cancel"};
        int choice = javax.swing.JOptionPane.showOptionDialog(this,
                "Choose action:",
                "Add",
                javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            ADD a = new ADD();
            a.setVisible(true);
            this.dispose();
        } else if (choice == 1) {
            int row = recipeTable.getSelectedRow();
            if (row >= 0) {
                Object idObj = recipeTable.getValueAt(row, 0);
                String idStr = String.valueOf(idObj);
                if (!idStr.isEmpty()) {
                    new adding1(idStr, true).setVisible(true);
                    this.dispose();
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a recipe from the table first to add ingredients to it.");
            }
        }
    }

    private void ADD12ActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] options = {"Update Recipe", "Update Ingredients", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this,
                "Choose update target:",
                "Update",
                javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) { 
            int row = recipeTable.getSelectedRow();
            if (row >= 0) {
                Object idObj = recipeTable.getValueAt(row, 0);
                String idStr = String.valueOf(idObj);
                if (!idStr.isEmpty()) {
                    new ADD(idStr).setVisible(true);
                    this.dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Please select a recipe to update.");
        } else if (choice == 1) { 
            int row = recipeTable.getSelectedRow();
            if (row >= 0) {
                Object idObj = recipeTable.getValueAt(row, 0);
                Integer id = null;
                try {
                    id = Integer.parseInt(String.valueOf(idObj));
                } catch (Exception ex) {
                }
                if (id != null) {
                    new adding1(String.valueOf(id)).setVisible(true);
                    this.dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Please select a recipe to update its ingredients.");
        }
    }

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {
        SearchActionPerformed(null);
    }

    private void ADD13ActionPerformed(java.awt.event.ActionEvent evt) {
        Search.setText("");
        Search1.setText("");
        if (category1.getItemCount() > 0) category1.setSelectedIndex(0);
        if (category3.getItemCount() > 0) category3.setSelectedIndex(0);
        if (status.getItemCount() > 0) status.setSelectedIndex(0);
        displayRecipes();
    }

    private void category1ActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void ADD14ActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void ADD15ActionPerformed(java.awt.event.ActionEvent evt) {
        config.Session.logout(this);
    }

    private void ADD16ActionPerformed(java.awt.event.ActionEvent evt) {
               View l = new View();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD17ActionPerformed(java.awt.event.ActionEvent evt) {
        ADD35ActionPerformed(evt);
    }

    private void ADD18ActionPerformed(java.awt.event.ActionEvent evt) {
        handlePrint();
    }

    private void ADD19ActionPerformed(java.awt.event.ActionEvent evt) {
        ADD37ActionPerformed(evt);
    }

    private void ADD11MouseEntered(java.awt.event.MouseEvent evt) {
    }

    private void ADD11MouseClicked(java.awt.event.MouseEvent evt) {
        adding1 a = new adding1();
        a.setVisible(true);
        this.dispose();
    }

    private void ADD12MouseClicked(java.awt.event.MouseEvent evt) {
        ADD12ActionPerformed(null);
    }

    private void ADD7MouseClicked(java.awt.event.MouseEvent evt) {
        deleteSelectedRecipe();
    }

    private void ADD35ActionPerformed(java.awt.event.ActionEvent evt) {
        int row = recipeTable.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a recipe from the table to view.");
            return;
        }
        Object idObj = recipeTable.getValueAt(row, 0); // ID column
        if (idObj == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a valid recipe.");
            return;
        }

        View11.openFrom(this, String.valueOf(idObj), null, null);
    }

    private void ADD32ActionPerformed(java.awt.event.ActionEvent evt) {
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD33MouseClicked(java.awt.event.MouseEvent evt) {
        Manage l = new Manage();
        l.setVisible(true);
        this.dispose();         
    }

    private void ADD33ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ADD34MouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void ADD34ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {
        ADD35ActionPerformed(evt);
    }

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {
        // Redirection removed as per request
    }

    private void category3ActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void Search1KeyReleased(java.awt.event.KeyEvent evt) {
        Search1ActionPerformed(null);
    }

    private void Search1FocusGained(java.awt.event.FocusEvent evt) {
        if (Search1.getText().equals("Search recipes by name or ID")) {
            Search1.setText("");
        }
    }

    private void Search1FocusLost(java.awt.event.FocusEvent evt) {
        if (Search1.getText().isEmpty()) {
            Search1.setText("Search recipes by name or ID");
        }
    }

    private void performSearch() {
        try {
            con.ensureRecipesTable();
            String base = "SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date, r_status AS Status FROM Recipes WHERE LOWER(r_author) = LOWER(?)";
            List<Object> params = new ArrayList<>();
            String currentUser = config.Session.getInstance().getUsername();
            params.add(currentUser);

            String kw = Search1.getText().trim();
            if (!kw.isEmpty() && !"Search recipes by name or ID".equals(kw)) {
                base += " AND (r_title LIKE ? OR CAST(r_id AS TEXT) LIKE ? OR r_category LIKE ?)";
                String pattern = "%" + kw + "%";
                params.add(pattern);
                params.add(pattern);
                params.add(pattern);
            }

            // Category filter
            String cat = String.valueOf(category3.getSelectedItem());
            if (cat != null && !cat.isEmpty() && !"All Category".equalsIgnoreCase(cat)) {
                base += " AND r_category = ?";
                params.add(cat);
            }

            // Status filter
            String st = String.valueOf(status.getSelectedItem());
            if (st != null && !st.isEmpty() && !"All Status".equalsIgnoreCase(st)) {
                if ("Null".equalsIgnoreCase(st)) {
                    base += " AND (r_status IS NULL OR TRIM(r_status) = '')";
                } else {
                    base += " AND r_status = ?";
                    params.add(st);
                }
            }

            base += " ORDER BY r_id DESC";
            con.displayData(base, recipeTable, params.toArray());
        } catch (Exception e) {
            System.out.println("Error performing search: " + e.getMessage());
        }
    }

    private void deleteSelectedRecipe() {
        int row = recipeTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a recipe to delete.");
            return;
        }
        
        Object idObj = recipeTable.getValueAt(row, 0);
        String recipeId = String.valueOf(idObj);
        String title = String.valueOf(recipeTable.getValueAt(row, 1));
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete the recipe: " + title + "?",
            "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                con.deleteRecord("DELETE FROM Recipes WHERE r_id = ?", recipeId);
                JOptionPane.showMessageDialog(this, "Recipe deleted successfully.");
                displayRecipes();
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (config.Session.getInstance().isLoggedIn()) {
                    new Manage().setVisible(true);
                } else {
                    new landingPage1().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD11;
    private javax.swing.JButton ADD12;
    private javax.swing.JButton ADD13;
    private javax.swing.JButton ADD14;
    private javax.swing.JButton ADD15;
    private javax.swing.JButton ADD16;
    private javax.swing.JButton ADD17;
    private javax.swing.JButton ADD18;
    private javax.swing.JButton ADD19;
    private javax.swing.JButton ADD36;
    private javax.swing.JButton ADD37;
    private javax.swing.JButton ADD38;
    private javax.swing.JButton ADD39;
    private javax.swing.JButton ADD7;
    private javax.swing.JTextField Search;
    private javax.swing.JTextField Search1;
    private javax.swing.JButton Vewphp;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> category1;
    private javax.swing.JComboBox<String> category3;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton print;
    private javax.swing.JTable recipeTable;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
