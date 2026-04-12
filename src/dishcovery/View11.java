/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dishcovery;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class View11 extends javax.swing.JFrame {
    private final config.config con = new config.config();
    public static String initialSearchText = null;
    public static String initialCategory = null;
    public static String authorFilter = null;
    public static String returnToScreenClassName = null;
    public static String returnToArg1 = null;
    public static java.awt.Window returnToWindow = null;
    private int currentRecipeId = -1;
    private StarRating interactiveStarRating;
    private javax.swing.JPanel commentsContainer;

    /**
     * Creates new form homePage2
     */
    public View11() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        setupStarRating();
        setupComments();
        setupNavigation();
        con.ensureCommentsTable();
        con.ensureRatingsTable();
        applyInitialFiltersAndDisplay();
    }

    public static void openFrom(javax.swing.JFrame caller, String recipeIdOrTitle, String authorFilterValue, String returnArg1) {
        initialSearchText = recipeIdOrTitle;
        authorFilter = authorFilterValue;
        
        // Only update return info if caller is NOT authorsprofile
        // This ensures Case 3: Back button returns to where we first clicked "View"
        if (caller != null && !(caller instanceof authorsprofile)) {
            returnToScreenClassName = caller.getClass().getName();
            returnToArg1 = returnArg1;
            returnToWindow = caller;
        }
        
        View11 v = new View11();
        v.setVisible(true);
        if (caller != null) {
            try { caller.setVisible(false); } catch (Exception ignore) {}
        }
    }

    private void setupNavigation() {
        Nextrecipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NextrecipeMouseClicked(evt);
            }
        });
        Nextrecipe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        Backrecipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackrecipeMouseClicked(evt);
            }
        });
        Backrecipe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    private void setupComments() {
        commentsContainer = new javax.swing.JPanel();
        commentsContainer.setLayout(new javax.swing.BoxLayout(commentsContainer, javax.swing.BoxLayout.Y_AXIS));
        commentsContainer.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane5.setViewportView(commentsContainer);
        jScrollPane5.getViewport().setBackground(new java.awt.Color(51, 51, 51));
    }

    private void setupStarRating() {
        interactiveStarRating = new StarRating();
        jPanel3.remove(StarRating); // Remove the placeholder label
        jPanel3.add(interactiveStarRating);
        interactiveStarRating.setBounds(10, 0, 150, 30);
        
        interactiveStarRating.addEventStarRating(new EventStarRating() {
            @Override
            public void selected(int star) {
                submitRating(star);
            }
        });
    }

    private void submitRating(int rating) {
        if (currentRecipeId == -1) return;
        
        int userId = config.Session.getInstance().getId();
        if (userId <= 0) return;

        try {
            // Check if user already rated
            List<Map<String, Object>> existing = con.fetchRecords(
                "SELECT r_id FROM Ratings WHERE r_recipe_id = ? AND r_user_id = ?", 
                currentRecipeId, userId);
            
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            if (existing.isEmpty()) {
                con.addRecord("INSERT INTO Ratings (r_recipe_id, r_user_id, r_rating, r_date) VALUES (?, ?, ?, ?)",
                    currentRecipeId, userId, rating, date);
            } else {
                con.updateRecord("UPDATE Ratings SET r_rating = ?, r_date = ? WHERE r_recipe_id = ? AND r_user_id = ?",
                    rating, date, currentRecipeId, userId);
            }
            fetchRating();
            javax.swing.JOptionPane.showMessageDialog(this, "Thank you for rating " + rating + " stars!");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error submitting rating: " + e.getMessage());
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

        jSpinner1 = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jDialog1 = new javax.swing.JDialog();
        choice1 = new java.awt.Choice();
        canvas1 = new java.awt.Canvas();
        jDialog2 = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        StarRating = new javax.swing.JLabel();
        StarRating1 = new javax.swing.JLabel();
        CommentText = new javax.swing.JTextField();
        Send = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        description = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        IngredientsList = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RecipePhoto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PrepTime = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CookTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ServingNumber = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Instruction = new javax.swing.JLabel();
        AuthorsProfile = new javax.swing.JLabel();
        AuthorsName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Nextrecipe = new javax.swing.JLabel();
        Backrecipe = new javax.swing.JLabel();
        Saverecipe = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        NameAndComments = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        StarRating.setBackground(new java.awt.Color(0, 0, 0));
        StarRating.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel3.add(StarRating);
        StarRating.setBounds(0, 0, 120, 30);

        StarRating1.setBackground(new java.awt.Color(255, 237, 194));
        StarRating1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        StarRating1.setText("Rating");
        jPanel3.add(StarRating1);
        StarRating1.setBounds(170, 0, 110, 30);

        CommentText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommentTextActionPerformed(evt);
            }
        });
        jPanel3.add(CommentText);
        CommentText.setBounds(10, 40, 220, 30);

        Send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Brown and Pink Minimal Icons Icon Set (2) (1).png"))); // NOI18N
        Send.setText("jLabel8");
        Send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SendMouseClicked(evt);
            }
        });
        jPanel3.add(Send);
        Send.setBounds(240, 40, 30, 30);

        jPanel8.add(jPanel3);
        jPanel3.setBounds(540, 410, 280, 80);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        description.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        description.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(description);
        description.setBounds(240, 340, 210, 440);

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel6.setText("Description");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(240, 320, 150, 20);

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel7.setText("Instruction");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 320, 130, 20);

        IngredientsList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IngredientsList.setToolTipText("");
        IngredientsList.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(IngredientsList);
        IngredientsList.setBounds(240, 170, 210, 140);

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel4.setText("Ingredients");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 150, 180, 20);
        jPanel1.add(RecipePhoto);
        RecipePhoto.setBounds(40, 150, 170, 150);

        jLabel2.setText("_____________________________________________________________");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 120, 410, 20);

        PrepTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PrepTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PrepTime.setText("time");
        jPanel1.add(PrepTime);
        PrepTime.setBounds(40, 110, 70, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Prep Time:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(40, 90, 100, 20);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Cook Time:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(140, 90, 110, 20);

        CookTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CookTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CookTime.setText("time");
        jPanel1.add(CookTime);
        CookTime.setBounds(140, 110, 80, 25);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Category");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(370, 90, 100, 20);

        ServingNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ServingNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ServingNumber.setText("number");
        jPanel1.add(ServingNumber);
        ServingNumber.setBounds(250, 110, 80, 20);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("recipe Name");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 40, 420, 40);

        jLabel3.setText("_____________________________________________________________");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 70, 410, 20);

        Instruction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Instruction.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(Instruction);
        Instruction.setBounds(40, 340, 180, 440);
        jPanel1.add(AuthorsProfile);
        AuthorsProfile.setBounds(10, 10, 30, 30);
        jPanel1.add(AuthorsName);
        AuthorsName.setBounds(50, 10, 150, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Servings:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(260, 90, 100, 20);

        Category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Category.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Category.setText("Category");
        jPanel1.add(Category);
        Category.setBounds(340, 110, 120, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Brown and Pink Minimal Icons Icon Set (3).png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1, 0, 490, 470);

        jPanel8.add(jPanel1);
        jPanel1.setBounds(30, 20, 490, 470);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        Nextrecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/19.png"))); // NOI18N
        Nextrecipe.setText("jLabel10");
        jPanel4.add(Nextrecipe);
        Nextrecipe.setBounds(250, 0, 30, 40);

        Backrecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/18.png"))); // NOI18N
        Backrecipe.setText("jLabel10");
        jPanel4.add(Backrecipe);
        Backrecipe.setBounds(0, 0, 30, 40);

        Saverecipe.setText("Save");
        Saverecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaverecipeActionPerformed(evt);
            }
        });
        jPanel4.add(Saverecipe);
        Saverecipe.setBounds(150, 10, 73, 20);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(60, 10, 70, 20);

        jPanel8.add(jPanel4);
        jPanel4.setBounds(540, 20, 280, 40);

        jScrollPane5.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane5.setBorder(null);

        NameAndComments.setBackground(new java.awt.Color(51, 51, 51));
        NameAndComments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NameAndComments.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane5.setViewportView(NameAndComments);

        jPanel8.add(jScrollPane5);
        jScrollPane5.setBounds(540, 100, 280, 310);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Comments");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(70, 0, 140, 30);

        jPanel8.add(jPanel5);
        jPanel5.setBounds(540, 70, 280, 30);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 30, 840, 510);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/big background.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, -10, 880, 590);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SaverecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaverecipeActionPerformed
        if (currentRecipeId == -1) return;
        String currentUser = config.Session.getInstance().getUsername();
        if (currentUser == null) return;
        
        // Fetch current recipe data
        List<Map<String, Object>> results = con.fetchRecords("SELECT * FROM Recipes WHERE r_id = ?", currentRecipeId);
        if (results.isEmpty()) return;
        Map<String, Object> recipe = results.get(0);
        
        String title = String.valueOf(recipe.get("r_title"));
        
        // Check if user already has a recipe with this title
        boolean exists = con.existsRecord("SELECT r_id FROM Recipes WHERE r_title = ? AND r_author = ?", title, currentUser);
        if (exists) {
            javax.swing.JOptionPane.showMessageDialog(this, "you already saved the recipe");
            return;
        }
        
        // Save as a copy for the user
        try {
            con.addRecord("INSERT INTO Recipes (r_title, r_description, r_author, r_category, r_date, r_instructions, r_ingredients, r_prep_time, r_cook_time, r_servings, r_prep_category, r_cook_time_category, r_shared, r_status, r_saved, r_image, r_bg_image) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                recipe.get("r_title"),
                recipe.get("r_description"),
                currentUser,
                recipe.get("r_category"),
                new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()),
                recipe.get("r_instructions"),
                recipe.get("r_ingredients"),
                recipe.get("r_prep_time"),
                recipe.get("r_cook_time"),
                recipe.get("r_servings"),
                recipe.get("r_prep_category"),
                recipe.get("r_cook_time_category"),
                0, // r_shared (this is a personal save, not shared yet)
                null, // r_status (initially null for new additions)
                1, // r_saved = 1
                recipe.get("r_image"),
                recipe.get("r_bg_image")
            );
            javax.swing.JOptionPane.showMessageDialog(this, "Recipe saved to your collection!");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving recipe: " + e.getMessage());
        }
    }//GEN-LAST:event_SaverecipeActionPerformed

    private void NextrecipeMouseClicked(java.awt.event.MouseEvent evt) {
        if (currentRecipeId == -1) return;
        String sql = "SELECT r_id FROM Recipes WHERE r_status = 'Approve' AND r_id > ? ";
        if (authorFilter != null) {
            sql += "AND r_author = ? ";
        }
        sql += "ORDER BY r_id ASC LIMIT 1";
        
        List<Map<String, Object>> results;
        if (authorFilter != null) {
            results = con.fetchRecords(sql, currentRecipeId, authorFilter);
        } else {
            results = con.fetchRecords(sql, currentRecipeId);
        }

        if (!results.isEmpty()) {
            displayRecipeDetails(String.valueOf(results.get(0).get("r_id")));
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "This is the last approved recipe.");
        }
    }

    private void BackrecipeMouseClicked(java.awt.event.MouseEvent evt) {
        if (currentRecipeId == -1) return;
        String sql = "SELECT r_id FROM Recipes WHERE r_status = 'Approve' AND r_id < ? ";
        if (authorFilter != null) {
            sql += "AND r_author = ? ";
        }
        sql += "ORDER BY r_id DESC LIMIT 1";
        
        List<Map<String, Object>> results;
        if (authorFilter != null) {
            results = con.fetchRecords(sql, currentRecipeId, authorFilter);
        } else {
            results = con.fetchRecords(sql, currentRecipeId);
        }

        if (!results.isEmpty()) {
            displayRecipeDetails(String.valueOf(results.get(0).get("r_id")));
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "This is the first approved recipe.");
        }
    }

    private void StarRatingMouseClicked(java.awt.event.MouseEvent evt) {
        // Handled by interactiveStarRating component
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        navigateBack();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendMouseClicked
        String comment = CommentText.getText().trim();
        if (comment.isEmpty()) return;

        String username = config.Session.getInstance().getUsername();
        if (username == null || currentRecipeId == -1) return;

        // Get user ID
        int userId = -1;
        try {
            List<Map<String, Object>> users = con.fetchRecords("SELECT u_id FROM Users WHERE u_username = ?", username);
            if (!users.isEmpty()) {
                userId = (Integer) users.get(0).get("u_id");
            }
        } catch (Exception ignore) {}

        if (userId != -1) {
            try {
                con.addRecord("INSERT INTO Comments (c_recipe_id, c_user_id, c_comment, c_date) VALUES (?, ?, ?, ?)",
                    currentRecipeId, userId, comment, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
                CommentText.setText("");
                fetchComments();
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error adding comment: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_SendMouseClicked

    private void CommentTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommentTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CommentTextActionPerformed

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {
        navigateBack();
    }

    private void navigateBack() {
        if (returnToWindow != null) {
            try {
                returnToWindow.setVisible(true);
                this.dispose();
                return;
            } catch (Exception ignore) {}
        }

        String target = returnToScreenClassName;
        String arg1 = returnToArg1;
        returnToScreenClassName = null;
        returnToArg1 = null;

        if (target == null || target.trim().isEmpty()) {
            homePage2 h = new homePage2();
            h.setVisible(true);
            this.dispose();
            return;
        }

        try {
            Class<?> cls = Class.forName(target);
            Object obj;
            if (arg1 != null) {
                try {
                    obj = cls.getDeclaredConstructor(String.class).newInstance(arg1);
                } catch (NoSuchMethodException nsme) {
                    obj = cls.getDeclaredConstructor().newInstance();
                }
            } else {
                obj = cls.getDeclaredConstructor().newInstance();
            }
            if (obj instanceof javax.swing.JFrame) {
                ((javax.swing.JFrame) obj).setVisible(true);
            }
            this.dispose();
        } catch (Throwable t) {
            homePage2 h = new homePage2();
            h.setVisible(true);
            this.dispose();
        }
    }

    private void applyInitialFiltersAndDisplay() {
        String txt = initialSearchText;
        initialSearchText = null;
        initialCategory = null;
        if (txt != null && !txt.isEmpty()) {
            displayRecipeDetails(txt);
        }
    }

    private void displayRecipeDetails(String titleOrId) {
        String sql;
        List<Map<String, Object>> results;

        // Try to fetch by ID first if titleOrId is numeric
        if (titleOrId.matches("\\d+")) {
            sql = "SELECT r.*, u.u_full_name, u.u_image as author_image FROM Recipes r " +
                  "LEFT JOIN Users u ON r.r_author = u.u_username " +
                  "WHERE r.r_id = ?";
            results = con.fetchRecords(sql, Integer.parseInt(titleOrId));
        } else {
            sql = "SELECT r.*, u.u_full_name, u.u_image as author_image FROM Recipes r " +
                  "LEFT JOIN Users u ON r.r_author = u.u_username " +
                  "WHERE r.r_title = ?";
            results = con.fetchRecords(sql, titleOrId);
        }
        
        if (results.isEmpty()) {
            // Fallback for cases where ID might be passed as a string but not strictly numeric
            sql = "SELECT r.*, u.u_full_name, u.u_image as author_image FROM Recipes r " +
                  "LEFT JOIN Users u ON r.r_author = u.u_username " +
                  "WHERE r.r_title = ? OR CAST(r.r_id AS TEXT) = ?";
            results = con.fetchRecords(sql, titleOrId, titleOrId);
        }

        if (results.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Recipe not found.");
            return;
        }
        
        Map<String, Object> recipe = results.get(0);
        try {
            Object idObj = recipe.get("r_id");
            if (idObj instanceof Number) {
                currentRecipeId = ((Number) idObj).intValue();
            } else if (idObj != null) {
                currentRecipeId = Integer.parseInt(idObj.toString());
            } else {
                currentRecipeId = -1;
            }
        } catch (Exception e) {
            currentRecipeId = -1;
        }
        final String authorUsername = String.valueOf(recipe.get("r_author"));
        
        jLabel1.setText(String.valueOf(recipe.get("r_title")));
        description.setText("<html>" + String.valueOf(recipe.get("r_description")).replace("\n", "<br>") + "</html>");
        IngredientsList.setText("<html>" + String.valueOf(recipe.get("r_ingredients")).replace("\n", "<br>") + "</html>");
        Instruction.setText("<html>" + String.valueOf(recipe.get("r_instructions")).replace("\n", "<br>") + "</html>");
        PrepTime.setText(recipe.get("r_prep_time") != null ? String.valueOf(recipe.get("r_prep_time")) : "0");
        CookTime.setText(recipe.get("r_cook_time") != null ? String.valueOf(recipe.get("r_cook_time")) : "0");
        ServingNumber.setText(recipe.get("r_servings") != null ? String.valueOf(recipe.get("r_servings")) : "0");
        Category.setText(recipe.get("r_category") != null ? String.valueOf(recipe.get("r_category")) : "Uncategorized");

        // Display author info
        String authorName = String.valueOf(recipe.get("u_full_name"));
        if (authorName == null || authorName.equals("null") || authorName.isEmpty()) {
            authorName = authorUsername;
        }
        AuthorsName.setText(authorName);
        
        // Remove existing mouse listeners to avoid duplicate calls
        for (java.awt.event.MouseListener ml : AuthorsName.getMouseListeners()) {
            AuthorsName.removeMouseListener(ml);
        }
        for (java.awt.event.MouseListener ml : AuthorsProfile.getMouseListeners()) {
            AuthorsProfile.removeMouseListener(ml);
        }

        java.awt.event.MouseAdapter authorClick = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorsprofile ap = new authorsprofile(authorUsername, String.valueOf(currentRecipeId));
                ap.setVisible(true);
                View11.this.dispose();
            }
        };
        AuthorsProfile.addMouseListener(authorClick);
        AuthorsProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Display author profile image
        AuthorsProfile.setIcon(null);
        Object authorImgObj = recipe.get("author_image");
        displayImageOnLabel(AuthorsProfile, authorImgObj, false);
        
        // Display recipe image
        RecipePhoto.setIcon(null);
        Object recipeImgObj = recipe.get("r_image");
        displayImageOnLabel(RecipePhoto, recipeImgObj, true);
        
        fetchComments();
        fetchRating();
    }

    private void displayImageOnLabel(javax.swing.JLabel label, Object imageSource, boolean useDefault) {
        if (imageSource == null) {
            if (useDefault) setDefaultImage();
            return;
        }

        try {
            BufferedImage img = null;
            if (imageSource instanceof byte[]) {
                byte[] data = (byte[]) imageSource;
                if (data.length > 0) {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                }
            } else if (imageSource instanceof String) {
                String path = ((String) imageSource).trim();
                if (!path.isEmpty()) {
                    // Try loading from classpath first (for bundled images)
                    java.net.URL imageUrl = getClass().getResource(path);
                    if (imageUrl != null) {
                        img = ImageIO.read(imageUrl);
                    } else {
                        // Fallback for absolute file paths on the filesystem.
                        java.io.File file = new java.io.File(path);
                        if (file.exists()) {
                            img = ImageIO.read(file);
                        }
                    }
                }
            }

            if (img != null) {
                int w = label.getWidth();
                int h = label.getHeight();
                if (w > 0 && h > 0) {
                    Image scaled = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(scaled));
                } else {
                    label.setIcon(new ImageIcon(img));
                }
            } else if (useDefault) {
                setDefaultImage();
            }
        } catch (Exception e) {
            if (useDefault) setDefaultImage();
            else label.setIcon(null);
        }
    }

    private void setDefaultImage() {
        try {
            // Try to load a placeholder image
            java.net.URL imgUrl = getClass().getResource("/images/small logo.png");
            if (imgUrl != null) {
                ImageIcon icon = new ImageIcon(imgUrl);
                Image scaled = icon.getImage().getScaledInstance(RecipePhoto.getWidth(), RecipePhoto.getHeight(), Image.SCALE_SMOOTH);
                RecipePhoto.setIcon(new ImageIcon(scaled));
            } else {
                RecipePhoto.setText("No Image");
                RecipePhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
        } catch (Exception ignore) {}
    }

    private void fetchComments() {
        if (commentsContainer == null) return;
        
        String sql = "SELECT c.c_comment, u.u_full_name, c.c_date, u.u_image FROM Comments c " +
                     "JOIN Users u ON c.c_user_id = u.u_id " +
                     "WHERE c.c_recipe_id = ? ORDER BY c.c_date DESC";
        List<Map<String, Object>> comments = con.fetchRecords(sql, currentRecipeId);
        
        commentsContainer.removeAll();
        
        for (Map<String, Object> c : comments) {
            String userName = String.valueOf(c.get("u_full_name"));
            String date = String.valueOf(c.get("c_date"));
            String commentText = String.valueOf(c.get("c_comment"));
            
            byte[] userImage = null;
            Object imgObj = c.get("u_image");
            if (imgObj instanceof byte[]) {
                userImage = (byte[]) imgObj;
            }
            
            javax.swing.JPanel row = new javax.swing.JPanel();
            row.setLayout(new java.awt.BorderLayout(10, 0));
            row.setBackground(new java.awt.Color(51, 51, 51));
            row.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
            row.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 80));
            
            // Image Label
            javax.swing.JLabel imgLabel = new javax.swing.JLabel();
            imgLabel.setPreferredSize(new java.awt.Dimension(40, 40));
            imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            
            if (userImage != null && userImage.length > 0) {
                try {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(userImage));
                    if (img != null) {
                        Image scaled = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        imgLabel.setIcon(new ImageIcon(scaled));
                    } else {
                        setDefaultProfileIcon(imgLabel);
                    }
                } catch (Exception e) {
                    setDefaultProfileIcon(imgLabel);
                }
            } else {
                setDefaultProfileIcon(imgLabel);
            }
            
            // Text Area
            javax.swing.JLabel textLabel = new javax.swing.JLabel();
            textLabel.setForeground(java.awt.Color.WHITE);
            String htmlText = "<html><b>" + userName + "</b> <span style='font-size: 0.8em; color: gray;'>(" + date + ")</span><br>" +
                              "<div style='margin-top: 5px; width: 180px;'>" + commentText + "</div></html>";
            textLabel.setText(htmlText);
            
            row.add(imgLabel, java.awt.BorderLayout.WEST);
            row.add(textLabel, java.awt.BorderLayout.CENTER);
            
            commentsContainer.add(row);
            commentsContainer.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
        }
        
        commentsContainer.revalidate();
        commentsContainer.repaint();
    }

    private void setDefaultProfileIcon(javax.swing.JLabel label) {
        label.setIcon(null);
        label.setBackground(java.awt.Color.GRAY);
        label.setOpaque(true);
        label.setPreferredSize(new java.awt.Dimension(40, 40));
        label.setText("?");
        label.setForeground(java.awt.Color.WHITE);
    }

    private void fetchRating() {
        if (currentRecipeId == -1) return;
        
        int userId = config.Session.getInstance().getId();
        
        // 1. Fetch average rating and total count
        String sql = "SELECT AVG(r_rating) as avg_rating, COUNT(*) as total_reviews FROM Ratings WHERE r_recipe_id = ?";
        List<Map<String, Object>> results = con.fetchRecords(sql, currentRecipeId);
        
        double avgRating = 0;
        int totalCount = 0;
        
        if (!results.isEmpty()) {
            Map<String, Object> row = results.get(0);
            Object avgObj = row.get("avg_rating");
            Object countObj = row.get("total_reviews");
            
            if (avgObj != null) {
                try {
                    avgRating = Double.parseDouble(avgObj.toString());
                } catch (Exception ignore) {}
            }
            if (countObj != null) {
                try {
                    totalCount = Integer.parseInt(countObj.toString());
                } catch (Exception ignore) {}
            }
        }
        
        // 2. Fetch current user's rating
        int userRating = 0;
        if (userId > 0) {
            String userSql = "SELECT r_rating FROM Ratings WHERE r_recipe_id = ? AND r_user_id = ?";
            List<Map<String, Object>> userResults = con.fetchRecords(userSql, currentRecipeId, userId);
            if (!userResults.isEmpty()) {
                Object ratingObj = userResults.get(0).get("r_rating");
                if (ratingObj != null) {
                    try {
                        userRating = Integer.parseInt(ratingObj.toString());
                    } catch (Exception ignore) {}
                }
            }
        }
        
        // 3. Update UI
        if (totalCount > 0) {
            StarRating1.setText(String.format("%.1f/5 (%d)", avgRating, totalCount));
        } else {
            StarRating1.setText("No Ratings");
        }
        
        if (interactiveStarRating != null) {
            interactiveStarRating.setStar(userRating);
        }
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
            java.util.logging.Logger.getLogger(View11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (config.Session.getInstance().isLoggedIn()) {
                    new View11().setVisible(true);
                } else {
                    new landingPage1().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuthorsName;
    private javax.swing.JLabel AuthorsProfile;
    private javax.swing.JLabel Backrecipe;
    private javax.swing.JLabel Category;
    private javax.swing.JTextField CommentText;
    private javax.swing.JLabel CookTime;
    private javax.swing.JLabel IngredientsList;
    private javax.swing.JLabel Instruction;
    private javax.swing.JLabel NameAndComments;
    private javax.swing.JLabel Nextrecipe;
    private javax.swing.JLabel PrepTime;
    private javax.swing.JLabel RecipePhoto;
    private javax.swing.JButton Saverecipe;
    private javax.swing.JLabel Send;
    private javax.swing.JLabel ServingNumber;
    private javax.swing.JLabel StarRating;
    private javax.swing.JLabel StarRating1;
    private java.awt.Canvas canvas1;
    private java.awt.Choice choice1;
    private javax.swing.JLabel description;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
