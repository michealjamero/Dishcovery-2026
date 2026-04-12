package dishcovery;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class adding1 extends javax.swing.JFrame {
    private final config.config con = new config.config();
    private String recipeId = null;
    private boolean addMode = false;
    private boolean deleteMode = false;
    private int selectedIngredientRow = -1;

    public adding1() {
        String username = config.Session.getInstance().getUsername();
        if (username == null || username.trim().isEmpty()) {
            landingPage1 lp = new landingPage1();
            lp.setVisible(true);
            this.dispose();
            return;
        }
        initComponents();
        this.addMode = true;
        this.deleteMode = false;
        try { jLabel9.setText("ADD INGREDIENTS"); } catch (Exception ignore) {}
        try { ADD9.setText("ADD"); } catch (Exception ignore) {}
        setupTableModel();
        ADD7.setVisible(false); // Remove delete button
    }

    public adding1(String id) {
        String username = config.Session.getInstance().getUsername();
        if (username == null || username.trim().isEmpty()) {
            landingPage1 lp = new landingPage1();
            lp.setVisible(true);
            this.dispose();
            return;
        }
        initComponents();
        this.recipeId = id;
        this.addMode = false;
        this.deleteMode = false;
        jLabel9.setText("Update Ingredients");
        try { ADD9.setText("Update"); } catch (Exception ignore) {}
        setupTableModel();
        populateFields(id);
        refreshIngredientTable();
        ADD7.setVisible(false); // Remove delete button
    }

    public adding1(String id, boolean addMode) {
        String username = config.Session.getInstance().getUsername();
        if (username == null || username.trim().isEmpty()) {
            landingPage1 lp = new landingPage1();
            lp.setVisible(true);
            this.dispose();
            return;
        }
        initComponents();
        this.recipeId = id;
        this.addMode = addMode;
        this.deleteMode = false;
        if (addMode) {
            try { jLabel9.setText("ADD INGREDIENTS"); } catch (Exception ignore) {}
            try { ADD9.setText("ADD"); } catch (Exception ignore) {}
        } else {
            try { jLabel9.setText("Update Ingredients"); } catch (Exception ignore) {}
            try { ADD9.setText("Update"); } catch (Exception ignore) {}
        }
        setupTableModel();
        populateFields(id);
        refreshIngredientTable();
        ADD7.setVisible(false); // Remove delete button
    }

    public adding1(String id, String mode) {
        String username = config.Session.getInstance().getUsername();
        if (username == null || username.trim().isEmpty()) {
            landingPage1 lp = new landingPage1();
            lp.setVisible(true);
            this.dispose();
            return;
        }
        initComponents();
        this.recipeId = id;
        setupTableModel();
        populateFields(id);
        refreshIngredientTable();
        ADD7.setVisible(false); // Remove delete button

        if ("delete".equalsIgnoreCase(mode)) {
            this.deleteMode = true;
            this.addMode = false;
            try { jLabel9.setText("DELETE INGREDIENTS"); } catch (Exception ignore) {}
            try { ADD9.setText("DELETE"); } catch (Exception ignore) {}
        }
    }

    private void populateFields(String id) {
        String sql = "SELECT r_title FROM Recipes WHERE r_id = ?";
        try (java.sql.Connection conn = con.connectDB();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String title = rs.getString("r_title");
                    if (title != null) {
                        Name.setText("Recipe: " + title);
                    }
                }
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error populating fields: " + e.getMessage());
        }
    }

    public void setRecipeTitle(String title) {
        if (title == null) {
            title = "";
        }
        title = title.trim();
        if (title.isEmpty()) {
            return;
        }
        Name.setText("Recipe: " + title);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jDialog1 = new javax.swing.JDialog();
        choice1 = new java.awt.Choice();
        canvas1 = new java.awt.Canvas();
        jDialog2 = new javax.swing.JDialog();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        ADD7 = new javax.swing.JButton();
        DONE = new javax.swing.JButton();
        Unit = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        Quantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredientsTable = new javax.swing.JTable();
        Name = new javax.swing.JLabel();
        ADD9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(null);

        jPanel18.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel18.setLayout(null);

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("name:");
        jPanel18.add(jLabel34);
        jLabel34.setBounds(20, 70, 60, 20);

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Quantity:");
        jPanel18.add(jLabel37);
        jLabel37.setBounds(20, 130, 60, 20);

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Unit:");
        jPanel18.add(jLabel38);
        jLabel38.setBounds(20, 190, 60, 20);

        ADD7.setBackground(new java.awt.Color(224, 196, 160));
        ADD7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD7.setForeground(new java.awt.Color(255, 165, 31));
        ADD7.setText("ADD");
        jPanel18.add(ADD7);
        ADD7.setBounds(30, 540, 120, 20);

        DONE.setBackground(new java.awt.Color(255, 255, 255));
        DONE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DONE.setText("DONE");
        DONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DONEActionPerformed(evt);
            }
        });
        jPanel18.add(DONE);
        DONE.setBounds(90, 240, 90, 30);

        Unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitActionPerformed(evt);
            }
        });
        jPanel18.add(Unit);
        Unit.setBounds(90, 190, 190, 30);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel18.add(name);
        name.setBounds(90, 70, 190, 30);

        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });
        jPanel18.add(Quantity);
        Quantity.setBounds(90, 130, 190, 30);

        ingredientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ingredientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingredientsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ingredientsTable);

        jPanel18.add(jScrollPane1);
        jScrollPane1.setBounds(300, 70, 360, 200);

        Name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setText("Name");
        jPanel18.add(Name);
        Name.setBounds(260, 10, 390, 32);

        ADD9.setBackground(new java.awt.Color(255, 255, 255));
        ADD9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD9.setText("ADD");
        ADD9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD9ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD9);
        ADD9.setBounds(190, 240, 90, 30);

        jPanel12.add(jPanel18);
        jPanel18.setBounds(20, 20, 670, 300);

        jPanel2.add(jPanel12);
        jPanel12.setBounds(30, 60, 710, 340);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADD INGREDIENTS");
        jPanel1.add(jLabel9);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(30, 10, 710, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 770, 420);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ADD7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (recipeId == null || recipeId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No recipe selected.");
            return;
        }

        if (selectedIngredientRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an ingredient from the table to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this ingredient?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Get existing ingredients
            String existingStr = "";
            String sqlSel = "SELECT r_ingredients FROM Recipes WHERE r_id = ?";
            try (java.sql.Connection conn = con.connectDB();
                 java.sql.PreparedStatement ps = conn.prepareStatement(sqlSel)) {
                ps.setString(1, recipeId);
                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        existingStr = rs.getString("r_ingredients");
                    }
                }
            }

            java.util.List<String> ingredientList = new java.util.ArrayList<>();
            if (existingStr != null && !existingStr.trim().isEmpty()) {
                String[] lines = existingStr.split("\\r?\\n");
                for (String line : lines) {
                    if (!line.trim().isEmpty()) {
                        ingredientList.add(line.trim());
                    }
                }
            }

            if (selectedIngredientRow >= 0 && selectedIngredientRow < ingredientList.size()) {
                ingredientList.remove(selectedIngredientRow);
                String finalValue = String.join("\n", ingredientList);
                String sqlUpd = "UPDATE Recipes SET r_ingredients = ? WHERE r_id = ?";
                con.updateRecord(sqlUpd, finalValue, recipeId);

                JOptionPane.showMessageDialog(this, "Ingredient deleted!");
                refreshIngredientTable();
                
                // Reset state
                name.setText("");
                Quantity.setText("");
                Unit.setText("");
                selectedIngredientRow = -1;
                ADD9.setText("ADD");
                this.addMode = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting: " + e.getMessage());
        }
    }

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void ADD9ActionPerformed(java.awt.event.ActionEvent evt) {
        String ingName = name.getText().trim();
        String qty = Quantity.getText().trim();
        String unit = Unit.getText().trim();

        if (recipeId == null || recipeId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No recipe selected.");
            return;
        }

        if (ingName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingredient name is required");
            return;
        }

        if (!qty.isEmpty() && !qty.matches("^\\d+(\\.\\d+)?$")) {
            JOptionPane.showMessageDialog(this, "Quantity must be a number");
            return;
        }

        con.ensureRecipesTable();

        try {
            if (deleteMode) {
                if (selectedIngredientRow < 0) {
                    JOptionPane.showMessageDialog(this, "Please select an ingredient from the table to delete.");
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(this, "Delete this ingredient?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) return;
            }

            // Format new ingredient
            String formatted = ingName;
            if (!qty.isEmpty() || !unit.isEmpty()) {
                String details = qty + (unit.isEmpty() ? "" : " " + unit);
                formatted = ingName + " (" + details.trim() + ")";
            }

            // Get existing ingredients
            String existingStr = "";
            String sqlSel = "SELECT r_ingredients FROM Recipes WHERE r_id = ?";
            try (java.sql.Connection conn = con.connectDB();
                 java.sql.PreparedStatement ps = conn.prepareStatement(sqlSel)) {
                ps.setString(1, recipeId);
                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        existingStr = rs.getString("r_ingredients");
                    }
                }
            }

            java.util.List<String> ingredientList = new java.util.ArrayList<>();
            if (existingStr != null && !existingStr.trim().isEmpty()) {
                String[] lines = existingStr.split("\\r?\\n");
                for (String line : lines) {
                    if (!line.trim().isEmpty()) {
                        ingredientList.add(line.trim());
                    }
                }
            }

            if (deleteMode) {
                if (selectedIngredientRow >= 0 && selectedIngredientRow < ingredientList.size()) {
                    ingredientList.remove(selectedIngredientRow);
                    JOptionPane.showMessageDialog(this, "Ingredient deleted!");
                }
            } else if (selectedIngredientRow >= 0 && selectedIngredientRow < ingredientList.size()) {
                // Update specific row
                ingredientList.set(selectedIngredientRow, formatted);
                JOptionPane.showMessageDialog(this, "Ingredient updated!");
            } else {
                // Add new row
                ingredientList.add(formatted);
                JOptionPane.showMessageDialog(this, "Ingredient added!");
            }

            // Re-join list with newlines
            String finalValue = String.join("\n", ingredientList);

            String sqlUpd = "UPDATE Recipes SET r_ingredients = ? WHERE r_id = ?";
            con.updateRecord(sqlUpd, finalValue, recipeId);

            // Reset state
            refreshIngredientTable();
            name.setText("");
            Quantity.setText("");
            Unit.setText("");
            selectedIngredientRow = -1;
            
            if (deleteMode) {
                ADD9.setText("DELETE");
            } else {
                ADD9.setText("ADD");
                this.addMode = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void ingredientsTableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = ingredientsTable.getSelectedRow();
        if (row >= 0) {
            this.selectedIngredientRow = row;
            String ingName = String.valueOf(ingredientsTable.getValueAt(row, 0));
            String qty = String.valueOf(ingredientsTable.getValueAt(row, 1));
            String unit = String.valueOf(ingredientsTable.getValueAt(row, 2));
            
            name.setText(ingName);
            Quantity.setText(qty);
            Unit.setText(unit);
            
            if (deleteMode) {
                ADD9.setText("DELETE");
            } else {
                ADD9.setText("Update");
                this.addMode = false;
            }
        }
    }

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void UnitActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void DONEActionPerformed(java.awt.event.ActionEvent evt) {
        Manage p = new Manage();
        p.setVisible(true);
        this.dispose();  
    }
    private void ADD3ActionPerformed(java.awt.event.ActionEvent evt) {
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
            DONE.doClick();
        } else if (choice == 1) {
            new adding1().setVisible(true);
            this.dispose();
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
            java.util.logging.Logger.getLogger(adding1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adding1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adding1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adding1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (config.Session.getInstance().isLoggedIn()) {
                    new adding1().setVisible(true);
                } else {
                    new landingPage1().setVisible(true);
                }
            }
        });
    }

    public void setIngredientFields(String name, String qty, String unit) {
        if (name == null) name = "";
        if (qty == null) qty = "";
        if (unit == null) unit = "";
        this.name.setText(name);
        this.Quantity.setText(qty);
        this.Unit.setText(unit);
    }

    private void setupTableModel() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Quantity", "Unit"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ingredientsTable.setModel(model);
    }

    private void refreshIngredientTable() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) ingredientsTable.getModel();
        model.setRowCount(0);
        if (recipeId == null || recipeId.trim().isEmpty()) {
            return;
        }
        String sql = "SELECT r_ingredients FROM Recipes WHERE r_id = ?";
        try (java.sql.Connection conn = con.connectDB();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recipeId);
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String ingredients = rs.getString("r_ingredients");
                    if (ingredients != null && !ingredients.trim().isEmpty()) {
                        String[] items = ingredients.split("\\r?\\n|;\\s*");
                        for (String item : items) {
                            if (item == null) continue;
                            String it = item.trim();
                            if (it.isEmpty()) continue;
                            String nm = it;
                            String q = "";
                            String u = "";
                            if (it.contains("(") && it.contains(")")) {
                                String namePart = it.substring(0, it.indexOf("(")).trim();
                                String rest = it.substring(it.indexOf("(") + 1, it.indexOf(")")).trim();
                                nm = namePart;
                                String[] parts = rest.split("\\s+", 2);
                                if (parts.length >= 1) q = parts[0];
                                if (parts.length >= 2) u = parts[1];
                            }
                            model.addRow(new Object[]{nm, q, u});
                        }
                    }
                }
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error loading ingredients: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD7;
    private javax.swing.JButton ADD9;
    private javax.swing.JButton DONE;
    private javax.swing.JLabel Name;
    private javax.swing.JTextField Quantity;
    private javax.swing.JTextField Unit;
    private java.awt.Canvas canvas1;
    private java.awt.Choice choice1;
    private javax.swing.JTable ingredientsTable;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
