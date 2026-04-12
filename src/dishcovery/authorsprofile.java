/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dishcovery;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class authorsprofile extends javax.swing.JFrame {
    private final config.config con = new config.config();
    private String authorUsername;
    private int authorId = -1;
    private String previousRecipeId;
    private javax.swing.JPanel commentsContainer;

    /**
     * Creates new form homePage2
     */
    public authorsprofile() {
        this(null, null);
    }

    public authorsprofile(String username) {
        this(username, null);
    }

    public authorsprofile(String username, String previousRecipeId) {
        this.authorUsername = username;
        this.previousRecipeId = previousRecipeId;
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        
        // Fetch author ID
        if (authorUsername != null) {
            try {
                java.util.List<java.util.Map<String, Object>> users = con.fetchRecords("SELECT u_id FROM Users WHERE u_username = ?", authorUsername);
                if (!users.isEmpty()) {
                    this.authorId = (Integer) users.get(0).get("u_id");
                }
            } catch (Exception ignore) {}
        }
        
        initComponents();
        setupComments();
        con.ensureFollowersTable();
        if (authorUsername != null && authorId != -1) {
            displayAuthorDetails();
            checkFollowStatus();
            updateFollowerCount();
        }
        displayRecipes();
    }

    private void setupComments() {
        commentsContainer = new javax.swing.JPanel();
        commentsContainer.setLayout(new javax.swing.BoxLayout(commentsContainer, javax.swing.BoxLayout.Y_AXIS));
        commentsContainer.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane5.setViewportView(commentsContainer);
        jScrollPane5.getViewport().setBackground(new java.awt.Color(51, 51, 51));
    }

    private void fetchComments() {
        // Feature removed as requested
        if (commentsContainer != null) {
            commentsContainer.removeAll();
            commentsContainer.revalidate();
            commentsContainer.repaint();
        }
    }

    private void setDefaultProfileIcon(javax.swing.JLabel label) {
        label.setIcon(null);
        label.setBackground(java.awt.Color.GRAY);
        label.setOpaque(true);
        label.setPreferredSize(new java.awt.Dimension(40, 40));
        label.setText("?");
        label.setForeground(java.awt.Color.WHITE);
    }

    private void checkFollowStatus() {
        int currentUserId = config.Session.getInstance().getId();
        if (currentUserId == -1 || authorId == -1) return;
        
        boolean isFollowing = con.existsRecord("SELECT 1 FROM Followers WHERE f_follower_id = ? AND f_following_id = ?", currentUserId, authorId);
        EditProfile.setText(isFollowing ? "Unfollow" : "Follow");
    }

    private void updateFollowerCount() {
        if (authorId == -1) return;
        double count = con.getSingleValue("SELECT COUNT(*) FROM Followers WHERE f_following_id = ?", authorId);
        profileemail1.setText(String.valueOf((int)count));
        
        double followingCount = con.getSingleValue("SELECT COUNT(*) FROM Followers WHERE f_follower_id = ?", authorId);
        profilerole.setText(String.valueOf((int)followingCount));
    }

    private void displayAuthorDetails() {
        String sql = "SELECT * FROM Users WHERE u_username = ?";
        java.util.List<java.util.Map<String, Object>> users = con.fetchRecords(sql, authorUsername);
        if (!users.isEmpty()) {
            java.util.Map<String, Object> user = users.get(0);
            jLabel3.setText(String.valueOf(user.get("u_username")));
            profilename1.setText(String.valueOf(user.get("u_full_name")));
            
            // Display profile image
            byte[] imageData = null;
            Object imgObj = user.get("u_image");
            if (imgObj instanceof byte[]) {
                imageData = (byte[]) imgObj;
            }
            
            if (imageData != null && imageData.length > 0) {
                try {
                    java.awt.image.BufferedImage img = javax.imageio.ImageIO.read(new java.io.ByteArrayInputStream(imageData));
                    if (img != null) {
                        java.awt.Image scaled = img.getScaledInstance(profile.getWidth(), profile.getHeight(), java.awt.Image.SCALE_SMOOTH);
                        profile.setIcon(new javax.swing.ImageIcon(scaled));
                    }
                } catch (Exception e) {
                    System.out.println("Error displaying profile image: " + e.getMessage());
                }
            }
            
            // Count recipes
            String countSql = "SELECT COUNT(*) FROM Recipes WHERE r_author = ? AND r_status = 'Approve'";
            double count = con.getSingleValue(countSql, authorUsername);
            NoRecipes.setText(String.valueOf((int)count));
        }
    }

    private void displayRecipes() {
        ensureRatingsTable();
        String base =
            "SELECT r.r_id AS ID, " +
            "       CASE WHEN u.u_full_name IS NULL OR TRIM(u.u_full_name) = '' THEN r.r_author ELSE u.u_full_name END AS Author, " +
            "       r.r_title AS Title, " +
            "       r.r_description AS Description, " +
            "       IFNULL(ROUND(AVG(rt.r_rating), 1), 0) AS Rating " +
            "FROM Recipes r " +
            "LEFT JOIN Users u ON u.u_username = r.r_author " +
            "LEFT JOIN Ratings rt ON rt.r_recipe_id = r.r_id " +
            "WHERE TRIM(r.r_status) = 'Approve' ";
        
        java.util.List<Object> params = new java.util.ArrayList<>();
        
        if (authorUsername != null) {
            base += "AND r.r_author = ? ";
            params.add(authorUsername);
        }
        
        // Use a safe way to check for Search1
        String kw = null;
        try {
            // Check if Search1 is initialized and accessible
            java.lang.reflect.Field searchField = this.getClass().getDeclaredField("Search1");
            searchField.setAccessible(true);
            javax.swing.JTextField search1 = (javax.swing.JTextField) searchField.get(this);
            if (search1 != null) {
                kw = search1.getText();
            }
        } catch (Exception ignore) {}

        if (kw != null) kw = kw.trim();
        if (kw != null && !kw.isEmpty() && !"Search recipes by name or ID".equals(kw)) {
            base += "AND (r.r_title LIKE ? OR r.r_description LIKE ? OR r.r_author LIKE ? OR CAST(r.r_id AS TEXT) LIKE ?) ";
            String pattern = "%" + kw + "%";
            params.add(pattern);
            params.add(pattern);
            params.add(pattern);
            params.add(pattern);
        }
        // Category filter removed to avoid hiding approved recipes by default
        base += "GROUP BY r.r_id, Author, Title, Description ORDER BY r.r_id DESC";
        con.displayData(base, authorssharedrecipe, params.toArray());
    }
    private void applyTranslucency() {
        try { ((javax.swing.JComponent)getContentPane()).setOpaque(false); } catch (Exception ignore) {}
        try { setBackground(new java.awt.Color(0,0,0,0)); } catch (Exception ignore) {}
        try { jPanel2.setOpaque(false); } catch (Exception ignore) {}
        try { jPanel6.setOpaque(false); } catch (Exception ignore) {}
        try { jPanel8.setOpaque(false); } catch (Exception ignore) {}
    
        try { jScrollPane1.setOpaque(false); jScrollPane1.getViewport().setOpaque(false); } catch (Exception ignore) {}
        try { jScrollPane3.setOpaque(false); jScrollPane3.getViewport().setOpaque(false); } catch (Exception ignore) {}
        try { revalidate(); repaint(); } catch (Exception ignore) {}
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        profilerole = new javax.swing.JLabel();
        folowers = new javax.swing.JLabel();
        NoRecipes = new javax.swing.JLabel();
        profilename1 = new javax.swing.JLabel();
        profileemail1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        authorssharedrecipe = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        EditProfile = new javax.swing.JButton();
        back = new javax.swing.JButton();
        EditProfile1 = new javax.swing.JButton();
        NameAndComments = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("following:");
        jPanel9.add(jLabel2);
        jLabel2.setBounds(170, 110, 70, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name");
        jPanel9.add(jLabel3);
        jLabel3.setBounds(170, 20, 320, 30);

        profilerole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profilerole.setForeground(new java.awt.Color(255, 255, 255));
        profilerole.setText("following");
        jPanel9.add(profilerole);
        profilerole.setBounds(250, 110, 100, 30);

        folowers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        folowers.setForeground(new java.awt.Color(255, 255, 255));
        folowers.setText("followers:");
        jPanel9.add(folowers);
        folowers.setBounds(170, 80, 70, 30);

        NoRecipes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NoRecipes.setForeground(new java.awt.Color(255, 255, 255));
        NoRecipes.setText("0");
        jPanel9.add(NoRecipes);
        NoRecipes.setBounds(200, 170, 100, 30);

        profilename1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profilename1.setForeground(new java.awt.Color(255, 255, 255));
        profilename1.setText("Name");
        jPanel9.add(profilename1);
        profilename1.setBounds(250, 50, 320, 30);

        profileemail1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileemail1.setForeground(new java.awt.Color(255, 255, 255));
        profileemail1.setText("followers");
        jPanel9.add(profileemail1);
        profileemail1.setBounds(250, 80, 90, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name:");
        jPanel9.add(jLabel7);
        jLabel7.setBounds(170, 50, 60, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No. of Recipe's:");
        jPanel9.add(jLabel8);
        jLabel8.setBounds(20, 170, 170, 30);
        jPanel9.add(profile);
        profile.setBounds(20, 20, 130, 130);

        jPanel8.add(jPanel9);
        jPanel9.setBounds(30, 20, 500, 210);

        jPanel1.setLayout(null);

        authorssharedrecipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(authorssharedrecipe);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 500, 190);

        jPanel8.add(jPanel1);
        jPanel1.setBounds(30, 230, 500, 190);

        jPanel18.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setLayout(null);

        EditProfile.setBackground(new java.awt.Color(255, 255, 255));
        EditProfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditProfile.setText("Follow");
        EditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditProfileMouseClicked(evt);
            }
        });
        EditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfileActionPerformed(evt);
            }
        });
        jPanel18.add(EditProfile);
        EditProfile.setBounds(20, 10, 120, 30);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel18.add(back);
        back.setBounds(360, 10, 120, 30);

        EditProfile1.setBackground(new java.awt.Color(255, 255, 255));
        EditProfile1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditProfile1.setText("View");
        EditProfile1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditProfile1MouseClicked(evt);
            }
        });
        EditProfile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfile1ActionPerformed(evt);
            }
        });
        jPanel18.add(EditProfile1);
        EditProfile1.setBounds(190, 10, 120, 30);

        jPanel8.add(jPanel18);
        jPanel18.setBounds(30, 440, 500, 50);

        NameAndComments.setBackground(new java.awt.Color(51, 51, 51));
        NameAndComments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NameAndComments.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel8.add(NameAndComments);
        NameAndComments.setBounds(10, 10, 0, 0);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 30, 560, 510);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, -10, 610, 590);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search1KeyReleased
        performSearch();
    }//GEN-LAST:event_Search1KeyReleased

    private void Search1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Search1FocusGained

    }//GEN-LAST:event_Search1FocusGained

    private void Search1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Search1FocusLost

    }//GEN-LAST:event_Search1FocusLost

    private void EditProfileMouseClicked(java.awt.event.MouseEvent evt) {
        int currentUserId = config.Session.getInstance().getId();
        if (currentUserId == -1 || authorId == -1) return;
        if (currentUserId == authorId) {
            javax.swing.JOptionPane.showMessageDialog(this, "You cannot follow yourself!");
            return;
        }

        boolean isFollowing = con.existsRecord("SELECT 1 FROM Followers WHERE f_follower_id = ? AND f_following_id = ?", currentUserId, authorId);
        if (isFollowing) {
            con.deleteRecord("DELETE FROM Followers WHERE f_follower_id = ? AND f_following_id = ?", currentUserId, authorId);
        } else {
            con.addRecord("INSERT INTO Followers (f_follower_id, f_following_id, f_date) VALUES (?, ?, ?)",
                currentUserId, authorId, new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        }
        checkFollowStatus();
        updateFollowerCount();
    }

    private void EditProfileActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        if (previousRecipeId != null && !previousRecipeId.isEmpty()) {
            View11.openFrom(this, previousRecipeId, authorUsername, null);
            this.dispose(); // Ensure Case 2 disposes correctly
        } else {
            homePage2 hp = new homePage2();
            hp.setVisible(true);
            this.dispose();
        }
    }

    private void EditProfile1MouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void EditProfile1ActionPerformed(java.awt.event.ActionEvent evt) {
        openSelectedRecipe();
    }

    private void CommentTextActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void SendMouseClicked(java.awt.event.MouseEvent evt) {
        // Feature removed as requested
        javax.swing.JOptionPane.showMessageDialog(this, "Profile comments are no longer supported.");
    }

    private void performSearch() {
        displayRecipes();
    }

    private void openSelectedRecipe() {
        int row = authorssharedrecipe.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a recipe from the table to view.");
            return;
        }
        Object idObj = authorssharedrecipe.getValueAt(row, 0); // ID column
        if (idObj == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a valid recipe.");
            return;
        }
        View11.openFrom(this, String.valueOf(idObj), authorUsername, authorUsername);
    }

    private void ensureRatingsTable() {
        try {
            java.sql.Connection conn = config.config.connectDB();
            if (conn == null) return;
            try (java.sql.PreparedStatement ps = conn.prepareStatement(
                "CREATE TABLE IF NOT EXISTS Ratings (" +
                "r_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "r_recipe_id INTEGER NOT NULL, " +
                "r_user_id INTEGER NOT NULL, " +
                "r_rating INTEGER NOT NULL, " +
                "r_date TEXT, " +
                "FOREIGN KEY(r_recipe_id) REFERENCES Recipes(r_id), " +
                "FOREIGN KEY(r_user_id) REFERENCES Users(u_id)" +
                ")"
            )) {
                ps.executeUpdate();
            } finally {
                try { conn.close(); } catch (Exception ignore) {}
            }
        } catch (Exception ignore) {}
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
            java.util.logging.Logger.getLogger(authorsprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(authorsprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(authorsprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(authorsprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (config.Session.getInstance().isLoggedIn()) {
                    new authorsprofile().setVisible(true);
                } else {
                    new landingPage1().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditProfile;
    private javax.swing.JButton EditProfile1;
    private javax.swing.JLabel NameAndComments;
    private javax.swing.JLabel NoRecipes;
    private javax.swing.JTable authorssharedrecipe;
    private javax.swing.JButton back;
    private java.awt.Canvas canvas1;
    private java.awt.Choice choice1;
    private javax.swing.JLabel folowers;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel profileemail1;
    private javax.swing.JLabel profilename1;
    private javax.swing.JLabel profilerole;
    // End of variables declaration//GEN-END:variables
}

