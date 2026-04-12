package dishcovery;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 * Logs.java - Print History and Management Module
 * 
 * This module displays the history of printed recipes with:
 * - Search functionality by username, recipe name, or date
 * - Category filtering
 * - View button to open recipe details
 * - Modern minimalist design
 */
public class Logs extends javax.swing.JFrame {
    private final config.config con = new config.config();
    private int selectedRecipeId = -1;
    private String selectedRecipeTitle = "";

    /**
     * Displays print logs from the PrintLogs table
     * Shows: Log ID, Username, Recipe Title, Print Date, Print Count
     */
    void displayLogs() {
        con.ensurePrintLogsTable();
        String sql = "SELECT pl.log_id AS 'Log ID', " +
                     "u.u_username AS 'User', " +
                     "r.r_title AS 'Recipe Title', " +
                     "pl.print_timestamp AS 'Print Date', " +
                     "pl.print_count AS 'Count', " +
                     "pl.recipe_id AS 'Recipe ID' " +
                     "FROM PrintLogs pl " +
                     "JOIN Users u ON pl.user_id = u.u_id " +
                     "JOIN Recipes r ON pl.recipe_id = r.r_id " +
                     "ORDER BY pl.print_timestamp DESC";
        con.displayData(sql, PrintedRecipes);
    }

    /**
     * Performs search on print logs based on search text
     * Searches: username, recipe title, date, or log ID
     */
    private void performSearch() {
        con.ensurePrintLogsTable();
        String searchText = Search1.getText().trim();
        
        String sql = "SELECT pl.log_id AS 'Log ID', " +
                     "u.u_username AS 'User', " +
                     "r.r_title AS 'Recipe Title', " +
                     "pl.print_timestamp AS 'Print Date', " +
                     "pl.print_count AS 'Count', " +
                     "pl.recipe_id AS 'Recipe ID' " +
                     "FROM PrintLogs pl " +
                     "JOIN Users u ON pl.user_id = u.u_id " +
                     "JOIN Recipes r ON pl.recipe_id = r.r_id " +
                     "WHERE u.u_username LIKE ? " +
                     "OR r.r_title LIKE ? " +
                     "OR pl.print_timestamp LIKE ? " +
                     "OR CAST(pl.log_id AS TEXT) LIKE ? " +
                     "ORDER BY pl.print_timestamp DESC";
        
        String pattern = "%" + searchText + "%";
        con.displayData(sql, PrintedRecipes, pattern, pattern, pattern, pattern);
    }

    /**
     * Filters print logs by recipe category
     * Uses JOIN with Recipes table to filter by category
     */
    private void filterByCategory() {
        String selectedCategory = String.valueOf(category3.getSelectedItem());
        
        if ("All Category".equals(selectedCategory)) {
            displayLogs();
            return;
        }
        
        con.ensurePrintLogsTable();
        String sql = "SELECT pl.log_id AS 'Log ID', " +
                     "u.u_username AS 'User', " +
                     "r.r_title AS 'Recipe Title', " +
                     "pl.print_timestamp AS 'Print Date', " +
                     "pl.print_count AS 'Count', " +
                     "pl.recipe_id AS 'Recipe ID' " +
                     "FROM PrintLogs pl " +
                     "JOIN Users u ON pl.user_id = u.u_id " +
                     "JOIN Recipes r ON pl.recipe_id = r.r_id " +
                     "WHERE r.r_category = ? " +
                     "ORDER BY pl.print_timestamp DESC";
        
        con.displayData(sql, PrintedRecipes, selectedCategory);
    }

    /**
     * Opens the selected recipe in View11 for detailed viewing
     */
    private void viewSelectedRecipe() {
        int row = PrintedRecipes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a print log entry to view.");
            return;
        }
        
        // Get recipe_id from the hidden column (Recipe ID is at index 5)
        Object recipeIdObj = PrintedRecipes.getValueAt(row, 5);
        if (recipeIdObj == null) {
            JOptionPane.showMessageDialog(this, "Invalid recipe data.");
            return;
        }
        
        try {
            int recipeId = Integer.parseInt(String.valueOf(recipeIdObj));
            // Open View11 with the selected recipe
            View11.openFrom(this, String.valueOf(recipeId), null, null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error opening recipe: " + ex.getMessage());
        }
    }

    /**
     * Captures selected row data when table is clicked
     */
    private void PrintedRecipesMouseClicked(java.awt.event.MouseEvent evt) {
        int row = PrintedRecipes.getSelectedRow();
        if (row >= 0) {
            Object recipeIdObj = PrintedRecipes.getValueAt(row, 5);
            Object recipeTitleObj = PrintedRecipes.getValueAt(row, 2);
            if (recipeIdObj != null) {
                selectedRecipeId = Integer.parseInt(String.valueOf(recipeIdObj));
            }
            if (recipeTitleObj != null) {
                selectedRecipeTitle = String.valueOf(recipeTitleObj);
            }
        }
    }

    public Logs() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        con.ensurePrintLogsTable();
        displayLogs();
        setupSearchListener();
        applyModernDesign();
    }

    /**
     * Sets up the search field document listener
     */
    private void setupSearchListener() {
        if (Search1 != null && Search1.getDocument() != null) {
            Search1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                public void insertUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void removeUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void changedUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
            });
        }
    }

    /**
     * Applies modern minimalist design to the UI components
     */
    private void applyModernDesign() {
        // Modern typography for table
        PrintedRecipes.setFont(new java.awt.Font("Segoe UI", 0, 12));
        PrintedRecipes.setRowHeight(28);
        PrintedRecipes.setGridColor(new java.awt.Color(230, 230, 230));
        PrintedRecipes.setSelectionBackground(new java.awt.Color(100, 149, 237));
        PrintedRecipes.setSelectionForeground(java.awt.Color.WHITE);
        PrintedRecipes.setShowGrid(true);
        PrintedRecipes.setIntercellSpacing(new java.awt.Dimension(8, 4));
        
        // Modern search field
        Search1.setFont(new java.awt.Font("Segoe UI", 0, 13));
        Search1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        // Modern View button with hover effect
        ADD7.setFont(new java.awt.Font("Segoe UI", 1, 13));
        ADD7.setBackground(new java.awt.Color(255, 255, 255));
        ADD7.setForeground(new java.awt.Color(50, 50, 50));
        ADD7.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)),
            javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        ADD7.setFocusPainted(false);
        ADD7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        // Modern category dropdown
        category3.setFont(new java.awt.Font("Segoe UI", 0, 12));
        category3.setBackground(new java.awt.Color(255, 255, 255));
        
        // Panel styling
        jPanel13.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanel8.setBackground(new java.awt.Color(0, 0, 0, 50));
    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        PrintedRecipes = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        Search1 = new javax.swing.JTextField();
        ADD7 = new javax.swing.JButton();
        category3 = new javax.swing.JComboBox<>();
        jPanel21 = new javax.swing.JPanel();
        ADD55 = new javax.swing.JButton();
        ADD56 = new javax.swing.JButton();
        ADD57 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ADD59 = new javax.swing.JButton();
        Logs = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Print History - Dishcovery");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setLayout(null);

        PrintedRecipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        PrintedRecipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintedRecipesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PrintedRecipes);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(220, 70, 590, 380);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(null);

        Search1.setFont(new java.awt.Font("Segoe UI", 0, 11));
        Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search1ActionPerformed(evt);
            }
        });
        jPanel13.add(Search1);
        Search1.setBounds(10, 10, 350, 30);

        ADD7.setBackground(new java.awt.Color(255, 255, 255));
        ADD7.setFont(new java.awt.Font("Segoe UI", 1, 14));
        ADD7.setText("View");
        ADD7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD7ActionPerformed(evt);
            }
        });
        jPanel13.add(ADD7);
        ADD7.setBounds(370, 10, 90, 30);

        category3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Category", "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        category3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category3ActionPerformed(evt);
            }
        });
        jPanel13.add(category3);
        category3.setBounds(470, 10, 100, 30);

        jPanel8.add(jPanel13);
        jPanel13.setBounds(220, 20, 590, 50);

        jPanel21.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setLayout(null);

        ADD55.setBackground(new java.awt.Color(255, 255, 255));
        ADD55.setFont(new java.awt.Font("Segoe UI", 1, 14));
        ADD55.setText("Profile");
        ADD55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD55ActionPerformed(evt);
            }
        });
        jPanel21.add(ADD55);
        ADD55.setBounds(40, 350, 100, 30);

        ADD56.setBackground(new java.awt.Color(255, 255, 255));
        ADD56.setFont(new java.awt.Font("Segoe UI", 1, 14));
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
        ADD57.setFont(new java.awt.Font("Segoe UI", 1, 14));
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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18));
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
        ADD59.setFont(new java.awt.Font("Segoe UI", 1, 14));
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
        Logs.setFont(new java.awt.Font("Segoe UI", 1, 14));
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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png")));
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 880, 530);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ADD55ActionPerformed(java.awt.event.ActionEvent evt) {
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD56MouseClicked(java.awt.event.MouseEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD56ActionPerformed(java.awt.event.ActionEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD57MouseClicked(java.awt.event.MouseEvent evt) {
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD57ActionPerformed(java.awt.event.ActionEvent evt) {
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD59MouseClicked(java.awt.event.MouseEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD59ActionPerformed(java.awt.event.ActionEvent evt) {
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD7ActionPerformed(java.awt.event.ActionEvent evt) {
        viewSelectedRecipe();
    }

    private void category3ActionPerformed(java.awt.event.ActionEvent evt) {
        filterByCategory();
    }

    private void LogsActionPerformed(java.awt.event.ActionEvent evt) {
        Logs l = new Logs();
        l.setVisible(true);
        this.dispose();
    }

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (config.Session.getInstance().isLoggedIn()) {
                    new Logs().setVisible(true);
                } else {
                    new landingPage1().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD55;
    private javax.swing.JButton ADD56;
    private javax.swing.JButton ADD57;
    private javax.swing.JButton ADD59;
    private javax.swing.JButton ADD7;
    private javax.swing.JButton Logs;
    private javax.swing.JTable PrintedRecipes;
    private javax.swing.JTextField Search1;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> category3;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
