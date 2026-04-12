package dishcovery;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class View extends javax.swing.JFrame {

    private final config.config con = new config.config();
    public static String initialSearchText = null;
    public static String initialCategory = null;

    public View() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        setupUI();
        applyInitialFiltersAndDisplay();
    }

    private void setupUI() {
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "All Status", "processing...", "Approve", "Declined", "Saved", "Null"
        }));
        attachSearchListeners();
    }

    private void attachSearchListeners() {
        Search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }
        });
    }

    private void applyInitialFiltersAndDisplay() {
        if (initialSearchText != null) {
            Search.setText(initialSearchText);
        }
        if (initialCategory != null) {
            category4.setSelectedItem(initialCategory);
        }
        initialSearchText = null;
        initialCategory = null;
        performSearch();
    }

    private void performSearch() {
        String searchTxt = Search.getText().trim();
        String categoryFilter = String.valueOf(category4.getSelectedItem());
        String statusFilter = String.valueOf(status.getSelectedItem());
        String sharedFilter = String.valueOf(recipeshared.getSelectedItem());
        displayRecipes(searchTxt, categoryFilter, statusFilter, sharedFilter);
    }

    private void displayRecipes(String searchTxt, String categoryFilter, String statusFilter, String sharedFilter) {
        String currentUser = config.Session.getInstance().getUsername();
        StringBuilder sql = new StringBuilder("SELECT r_id AS ID, r_title AS Title, r_author AS Author, r_category AS Category, r_date AS Date, r_status AS Status, r_saved as Saved FROM Recipes WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if ("My Recipe".equalsIgnoreCase(sharedFilter)) {
            sql.append(" AND r_author = ?");
            params.add(currentUser);
        } else if ("Saved Recipe".equalsIgnoreCase(sharedFilter)) {
            sql.append(" AND r_saved = 1 AND r_author != ?");
            params.add(currentUser);
        }

        if (searchTxt != null && !searchTxt.trim().isEmpty()) {
            sql.append(" AND (r_title LIKE ? OR CAST(r_id AS TEXT) LIKE ? OR r_author LIKE ?)");
            String pattern = "%" + searchTxt.trim() + "%";
            params.add(pattern);
            params.add(pattern);
            params.add(pattern);
        }

        if (categoryFilter != null && !"All Category".equalsIgnoreCase(categoryFilter)) {
            sql.append(" AND r_category = ?");
            params.add(categoryFilter);
        }

        if (statusFilter != null && !"All Status".equalsIgnoreCase(statusFilter)) {
            if ("Null".equalsIgnoreCase(statusFilter)) {
                sql.append(" AND (r_status IS NULL OR TRIM(r_status) = '')");
            } else if ("Saved".equalsIgnoreCase(statusFilter)) {
                sql.append(" AND r_saved = 1");
            } else {
                sql.append(" AND r_status = ?");
                params.add(statusFilter);
            }
        }

        sql.append(" ORDER BY r_id DESC");
        con.displayData(sql.toString(), myrecipes, params.toArray());
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Search = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        recipeshared = new javax.swing.JComboBox<>();
        category4 = new javax.swing.JComboBox<>();
        ADD7 = new javax.swing.JButton();
        Myrecipes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myrecipes = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        ADD36 = new javax.swing.JButton();
        ADD37 = new javax.swing.JButton();
        ADD38 = new javax.swing.JButton();
        ADD39 = new javax.swing.JButton();
        ADD35 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(null);

        Search.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel7.add(Search);
        Search.setBounds(10, 10, 160, 30);

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Status", "processing...", "Approve", "Declined", "Null", " ", " " }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel7.add(status);
        status.setBounds(480, 10, 90, 30);

        recipeshared.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "My Recipe", "Saved Recipe" }));
        recipeshared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recipesharedActionPerformed(evt);
            }
        });
        jPanel7.add(recipeshared);
        recipeshared.setBounds(280, 10, 90, 30);

        category4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Category", "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category4ActionPerformed(evt);
            }
        });
        jPanel7.add(category4);
        category4.setBounds(380, 10, 90, 30);

        ADD7.setBackground(new java.awt.Color(255, 255, 255));
        ADD7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD7.setText("View");
        ADD7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD7ActionPerformed(evt);
            }
        });
        jPanel7.add(ADD7);
        ADD7.setBounds(180, 10, 90, 30);

        jPanel8.add(jPanel7);
        jPanel7.setBounds(230, 20, 590, 50);

        Myrecipes.setBackground(new java.awt.Color(0, 0, 0,60));
        Myrecipes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Myrecipes.setLayout(null);

        myrecipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(myrecipes);

        Myrecipes.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 590, 410);

        jPanel8.add(Myrecipes);
        Myrecipes.setBounds(230, 80, 590, 410);

        jPanel17.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(null);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/small logo.png"))); // NOI18N
        jLabel28.setText("jLabel9");
        jPanel17.add(jLabel28);
        jLabel28.setBounds(10, 10, 140, 120);

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

        ADD35.setBackground(new java.awt.Color(255, 255, 255));
        ADD35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD35.setText("View");
        ADD35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD35ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD35);
        ADD35.setBounds(40, 270, 90, 30);

        jPanel8.add(jPanel17);
        jPanel17.setBounds(20, 20, 180, 470);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 30, 840, 510);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, -10, 880, 590);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ADD7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD7ActionPerformed
        openSelectedRecipe();
    }//GEN-LAST:event_ADD7ActionPerformed

    private void ADD35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD35ActionPerformed
        performSearch();
    }//GEN-LAST:event_ADD35ActionPerformed

    private void openSelectedRecipe() {
        int row = myrecipes.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a recipe from the table to view.");
            return;
        }

        Object idObj = myrecipes.getValueAt(row, 0);
        if (idObj == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a valid recipe.");
            return;
        }

        View11.openFrom(this, String.valueOf(idObj), null, null);
    }

    private void ADD36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD36ActionPerformed
        new share().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD36ActionPerformed

    private void ADD37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD37ActionPerformed
        if ("Admin".equalsIgnoreCase(config.Session.getInstance().getRole())) {
            new profile().setVisible(true);
        } else {
            new profileadmin().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_ADD37ActionPerformed

    private void ADD38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD38ActionPerformed
        new Manage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD38ActionPerformed

    private void ADD39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD39ActionPerformed
        new homePage2().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD39ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        performSearch();
    }//GEN-LAST:event_statusActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        performSearch();
    }//GEN-LAST:event_SearchActionPerformed

    private void ADD38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD38MouseClicked
        ADD38ActionPerformed(null);
    }//GEN-LAST:event_ADD38MouseClicked

    private void ADD39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD39MouseClicked
        ADD39ActionPerformed(null);
    }//GEN-LAST:event_ADD39MouseClicked

    private void recipesharedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recipesharedActionPerformed
        Search.setText("");
        category4.setSelectedIndex(0);
        status.setSelectedIndex(0);
        performSearch();
    }//GEN-LAST:event_recipesharedActionPerformed

    private void category4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category4ActionPerformed
        performSearch();
    }//GEN-LAST:event_category4ActionPerformed

    private void myrecipesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myrecipesMouseClicked
    }//GEN-LAST:event_myrecipesMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            if (config.Session.getInstance().isLoggedIn()) {
                new View().setVisible(true);
            } else {
                new landingPage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD35;
    private javax.swing.JButton ADD36;
    private javax.swing.JButton ADD37;
    private javax.swing.JButton ADD38;
    private javax.swing.JButton ADD39;
    private javax.swing.JButton ADD7;
    private javax.swing.JPanel Myrecipes;
    private javax.swing.JTextField Search;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> category4;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable myrecipes;
    private javax.swing.JComboBox<String> recipeshared;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
