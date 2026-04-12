package dishcovery;

import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ADD extends javax.swing.JFrame {

    private final config.config con = new config.config();
    private String selectedImagePath;
    private String recipeId;

    public ADD() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        setUndecorated(true);
        initComponents();
        setupUI();
    }

    public ADD(String id) {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        setUndecorated(true);
        initComponents();
        setupUI();
        recipeId = id;
        configureForUpdate(id);
    }

    private void setupUI() {
        setLocationRelativeTo(null);
        try {
            SelectPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            SelectPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    handleSelectPhoto();
                }
            });
        } catch (Exception ignored) {
        }
    }

    private void configureForUpdate(String id) {
        ADD8.setText("Update");
        jLabel9.setText("Update Recipe");
        populateFields(id);
    }

    private void populateFields(String id) {
        String sql = "SELECT * FROM Recipes WHERE r_id = ?";
        List<Map<String, Object>> results = con.fetchRecords(sql, id);

        if (results == null || results.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Recipe not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Map<String, Object> row = results.get(0);

        Title2.setText(row.get("r_title") != null ? row.get("r_title").toString() : "");
        Description.setText(row.get("r_description") != null ? row.get("r_description").toString() : "");
        Instruction.setText(row.get("r_instructions") != null ? row.get("r_instructions").toString() : "");
        PrepTime.setText(row.get("r_prep_time") != null ? row.get("r_prep_time").toString() : "");
        CookTime.setText(row.get("r_cook_time") != null ? row.get("r_cook_time").toString() : "");
        Serving.setText(row.get("r_servings") != null ? row.get("r_servings").toString() : "");

        category.setSelectedItem(row.get("r_category") != null ? row.get("r_category").toString() : "");
        PrepCategory.setSelectedItem(row.get("r_prep_category") != null ? row.get("r_prep_category").toString() : "");
        CookTimeCategory.setSelectedItem(row.get("r_cook_time_category") != null ? row.get("r_cook_time_category").toString() : "");

        loadDate(row.get("r_date") != null ? row.get("r_date").toString() : "");
        loadImage(row.get("r_image"));
    }

    private void loadDate(String dateStr) {
        if (dateStr != null && !dateStr.isEmpty()) {
            try {
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                jDateChooser1.setDate(d);
            } catch (Exception e) {
                System.err.println("Date parse error: " + e.getMessage());
            }
        }
    }

    private void loadImage(Object imageValue) {
        if (imageValue == null) {
            return;
        }

        if (imageValue instanceof byte[]) {
            byte[] bytes = (byte[]) imageValue;
            setRecipePhotoIcon(new ImageIcon(bytes));
            return;
        }

        String path = imageValue.toString();
        if (path == null || path.trim().isEmpty()) {
            return;
        }
        selectedImagePath = path;
        File imgFile = new File(path);
        if (imgFile.exists()) {
            setRecipePhotoIcon(new ImageIcon(path));
        }
    }

    private void setRecipePhotoIcon(ImageIcon icon) {
        if (icon == null) {
            RecipePhoto.setIcon(null);
            return;
        }
        int w = RecipePhoto.getWidth();
        int h = RecipePhoto.getHeight();
        if (w <= 0 || h <= 0) {
            RecipePhoto.setIcon(icon);
            return;
        }
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        RecipePhoto.setIcon(new ImageIcon(img));
    }

    private void handleBack() {
        new Manage().setVisible(true);
        dispose();
    }

    private void handleSelectPhoto() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "jpeg", "gif"));
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedImagePath = chooser.getSelectedFile().getAbsolutePath();
            setRecipePhotoIcon(new ImageIcon(selectedImagePath));
        }
    }

    private void handleSubmit() {
        String title = Title2.getText().trim();
        String desc = Description.getText().trim();
        String instr = Instruction.getText().trim();
        String pTime = PrepTime.getText().trim();
        String cTime = CookTime.getText().trim();
        String servings = Serving.getText().trim();
        String date = (jDateChooser1.getDate() != null) ? new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate()) : "";
        
        String cat = category.getSelectedItem().toString();
        String pUnit = PrepCategory.getSelectedItem().toString();
        String cUnit = CookTimeCategory.getSelectedItem().toString();
        String author = config.Session.getInstance().getUsername();

        if (title.isEmpty() || desc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title and Description are mandatory.");
            return;
        }

        try {
            if (recipeId == null) {
                saveNewRecipe(title, desc, author, cat, date, instr, "", pTime, cTime, servings, pUnit, cUnit);
            } else {
                updateExistingRecipe(title, desc, cat, date, instr, pTime, cTime, servings, pUnit, cUnit);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Save error: " + e.getMessage());
        }
    }

    private void saveNewRecipe(String... args) {
        String sql = "INSERT INTO Recipes (r_title, r_description, r_author, r_category, r_date, r_instructions, r_ingredients, r_prep_time, r_cook_time, r_servings, r_prep_category, r_cook_time_category, r_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?, NULL)";
        int id = con.addRecordAndReturnId(sql, (Object[]) args);
        if (id <= 0) {
            JOptionPane.showMessageDialog(this, "Failed to add recipe.");
            return;
        }

        if (selectedImagePath != null && !selectedImagePath.trim().isEmpty()) {
            con.updateRecord("UPDATE Recipes SET r_image = ? WHERE r_id = ?", selectedImagePath, id);
        }

        JOptionPane.showMessageDialog(this, "Recipe added!");
        if (JOptionPane.showConfirmDialog(this, "Add ingredients now?", "Ingredients", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            adding1 ing = new adding1(String.valueOf(id), true);
            try {
                if (args != null && args.length > 0) {
                    ing.setRecipeTitle(String.valueOf(args[0]));
                }
            } catch (Exception ignored) {
            }
            ing.setVisible(true);
            dispose();
        } else {
            handleBack();
        }
    }

    private void updateExistingRecipe(String... args) {
        String sql = "UPDATE Recipes SET r_title=?, r_description=?, r_category=?, r_date=?, r_instructions=?, r_prep_time=?, r_cook_time=?, r_servings=?, r_prep_category=?, r_cook_time_category=? WHERE r_id=?";
        Object[] params = new Object[args.length + 1];
        System.arraycopy(args, 0, params, 0, args.length);
        params[args.length] = recipeId;

        con.updateRecord(sql, params);

        if (selectedImagePath != null && !selectedImagePath.trim().isEmpty()) {
            con.updateRecord("UPDATE Recipes SET r_image = ? WHERE r_id = ?", selectedImagePath, recipeId);
        }

        JOptionPane.showMessageDialog(this, "Recipe updated!");
        handleBack();
    }

    private void handleClear() {
        Title2.setText("");
        Description.setText("");
        Instruction.setText("");
        PrepTime.setText("");
        CookTime.setText("");
        Serving.setText("");
        jDateChooser1.setDate(null);
        category.setSelectedIndex(0);
        PrepCategory.setSelectedIndex(0);
        CookTimeCategory.setSelectedIndex(0);
        RecipePhoto.setIcon(null);
        selectedImagePath = null;
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
        SelectPhoto = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        ADD7 = new javax.swing.JButton();
        category = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Instruction = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextField();
        PrepTime = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        ADD8 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        Title2 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        CookTime = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        Serving = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        CookTimeCategory = new javax.swing.JComboBox<>();
        PrepCategory = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        RecipePhoto = new javax.swing.JLabel();
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
        jLabel34.setText("Prep Time:");
        jPanel18.add(jLabel34);
        jLabel34.setBounds(280, 160, 60, 20);

        SelectPhoto.setForeground(new java.awt.Color(255, 255, 255));
        SelectPhoto.setText("SELECT");
        jPanel18.add(SelectPhoto);
        SelectPhoto.setBounds(120, 290, 70, 20);

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Instruction:");
        jPanel18.add(jLabel36);
        jLabel36.setBounds(540, 200, 70, 20);

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Date:");
        jPanel18.add(jLabel37);
        jLabel37.setBounds(280, 90, 60, 20);

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Category:");
        jPanel18.add(jLabel38);
        jLabel38.setBounds(280, 370, 60, 20);

        ADD7.setBackground(new java.awt.Color(224, 196, 160));
        ADD7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD7.setForeground(new java.awt.Color(255, 165, 31));
        ADD7.setText("ADD");
        jPanel18.add(ADD7);
        ADD7.setBounds(30, 540, 120, 20);

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "appetizers", "salads", "soups", "main dishes", "desserts", "vegetarian", "seasonal" }));
        jPanel18.add(category);
        category.setBounds(350, 370, 180, 30);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Description:");
        jPanel18.add(jLabel14);
        jLabel14.setBounds(540, 20, 70, 20);

        Instruction.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jScrollPane1.setViewportView(Instruction);

        jPanel18.add(jScrollPane1);
        jScrollPane1.setBounds(610, 200, 190, 150);

        Description.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Description.setToolTipText("");
        jScrollPane2.setViewportView(Description);

        jPanel18.add(jScrollPane2);
        jScrollPane2.setBounds(610, 20, 190, 150);

        PrepTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrepTimeActionPerformed(evt);
            }
        });
        jPanel18.add(PrepTime);
        PrepTime.setBounds(350, 160, 80, 30);
        jPanel18.add(jDateChooser1);
        jDateChooser1.setBounds(350, 90, 180, 30);

        ADD8.setBackground(new java.awt.Color(255, 255, 255));
        ADD8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD8.setText("ADD");
        ADD8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD8ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD8);
        ADD8.setBounds(710, 370, 90, 30);

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Title:");
        jPanel18.add(jLabel39);
        jLabel39.setBounds(280, 20, 60, 20);

        Title2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Title2ActionPerformed(evt);
            }
        });
        jPanel18.add(Title2);
        Title2.setBounds(350, 20, 180, 30);

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Cook Time:");
        jPanel18.add(jLabel40);
        jLabel40.setBounds(280, 230, 70, 20);

        CookTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CookTimeActionPerformed(evt);
            }
        });
        jPanel18.add(CookTime);
        CookTime.setBounds(350, 230, 80, 30);

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Servings:");
        jPanel18.add(jLabel41);
        jLabel41.setBounds(280, 300, 60, 20);

        Serving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServingActionPerformed(evt);
            }
        });
        jPanel18.add(Serving);
        Serving.setBounds(350, 300, 180, 30);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Photo:");
        jPanel18.add(jLabel19);
        jLabel19.setBounds(20, 20, 70, 20);

        CookTimeCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Second", "Minutes", "Hours" }));
        CookTimeCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CookTimeCategoryActionPerformed(evt);
            }
        });
        jPanel18.add(CookTimeCategory);
        CookTimeCategory.setBounds(440, 230, 90, 30);

        PrepCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Second", "Minutes", "Hours" }));
        PrepCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrepCategoryActionPerformed(evt);
            }
        });
        jPanel18.add(PrepCategory);
        PrepCategory.setBounds(440, 160, 90, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);
        jPanel3.add(RecipePhoto);
        RecipePhoto.setBounds(0, 0, 240, 220);

        jPanel18.add(jPanel3);
        jPanel3.setBounds(20, 50, 240, 220);

        ADD9.setBackground(new java.awt.Color(255, 255, 255));
        ADD9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD9.setText("CANCEL");
        ADD9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD9ActionPerformed(evt);
            }
        });
        jPanel18.add(ADD9);
        ADD9.setBounds(610, 370, 90, 30);

        jPanel12.add(jPanel18);
        jPanel18.setBounds(20, 20, 820, 420);

        jPanel2.add(jPanel12);
        jPanel12.setBounds(30, 60, 870, 460);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADD Recipe");
        jPanel1.add(jLabel9);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(30, 10, 870, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 930, 540);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void PrepTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrepTimeActionPerformed
    }//GEN-LAST:event_PrepTimeActionPerformed

    private void ADD8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD8ActionPerformed
        handleSubmit();
    }//GEN-LAST:event_ADD8ActionPerformed

    private void Title2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Title2ActionPerformed
    }//GEN-LAST:event_Title2ActionPerformed

    private void CookTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CookTimeActionPerformed
    }//GEN-LAST:event_CookTimeActionPerformed

    private void ServingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServingActionPerformed
    }//GEN-LAST:event_ServingActionPerformed

    private void CookTimeCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CookTimeCategoryActionPerformed
    }//GEN-LAST:event_CookTimeCategoryActionPerformed

    private void PrepCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrepCategoryActionPerformed
    }//GEN-LAST:event_PrepCategoryActionPerformed

    private void ADD9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD9ActionPerformed
        Manage p = new Manage ();
        p.setVisible(true);
        this.dispose();           // TODO add your handling code here:
    }//GEN-LAST:event_ADD9ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ADD().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD7;
    private javax.swing.JButton ADD8;
    private javax.swing.JButton ADD9;
    private javax.swing.JTextField CookTime;
    private javax.swing.JComboBox<String> CookTimeCategory;
    private javax.swing.JTextField Description;
    private javax.swing.JTextField Instruction;
    private javax.swing.JComboBox<String> PrepCategory;
    private javax.swing.JTextField PrepTime;
    private javax.swing.JLabel RecipePhoto;
    private javax.swing.JLabel SelectPhoto;
    private javax.swing.JTextField Serving;
    private javax.swing.JTextField Title2;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> category;
    private java.awt.Choice choice1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField10;
    // End of variables declaration//GEN-END:variables
}
