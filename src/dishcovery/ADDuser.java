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
// Removed import that shadows package name
// import config.config;

public class ADDuser extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private Integer editingUserId = null;
    public ADDuser() {
        initComponents();
    }

    /**
     * Load existing user data into the form and switch to update mode.
     */
    public void loadUser(int id) {
        try {
            config.config con = new config.config();
            java.util.List<java.util.Map<String,Object>> rows = con.fetchRecords(
                "SELECT u_full_name, u_email, u_username, u_role FROM Users WHERE u_id = ? LIMIT 1",
                id
            );
            if (!rows.isEmpty()) {
                java.util.Map<String,Object> row = rows.get(0);
                fullname.setText(String.valueOf(row.get("u_full_name")));
                Email.setText(String.valueOf(row.get("u_email")));
                username.setText(String.valueOf(row.get("u_username")));
                // role selector not present in this form; skip
                editingUserId = id;
                signup.setText("Update");
            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading user: " + ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jpassword = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jButton3.setBackground(new java.awt.Color(224, 196, 160));
        jButton3.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 11)); // NOI18N
        jButton3.setText("Add Recipe");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel8.setText("Welcome Back");

        jToolBar1.setRollover(true);

        jpassword.setBackground(new java.awt.Color(232, 210, 184));
        jpassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpassword.setForeground(new java.awt.Color(232, 210, 184));
        jpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpasswordActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(232, 210, 184));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel3.setForeground(new java.awt.Color(232, 210, 184));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 165, 31));
        jLabel5.setText("Sign up");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(120, 0, 170, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 165, 31));
        jLabel3.setText("Password");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(50, 220, 150, 40);

        Email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel3.add(Email);
        Email.setBounds(40, 190, 260, 30);

        signup.setBackground(new java.awt.Color(224, 196, 160));
        signup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 165, 31));
        signup.setText("Sign up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel3.add(signup);
        signup.setBounds(40, 320, 260, 29);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5);
        jPanel5.setBounds(50, 320, 240, 0);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6);
        jPanel6.setBounds(40, 320, 260, 0);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 165, 31));
        jLabel10.setText("Sign in");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel10);
        jLabel10.setBounds(220, 360, 50, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 165, 31));
        jLabel11.setText("Email");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(50, 160, 150, 40);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 165, 31));
        jLabel13.setText("Already have an account?");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(60, 350, 160, 40);

        username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel3.add(username);
        username.setBounds(40, 70, 260, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 165, 31));
        jLabel12.setText("Username");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(50, 40, 150, 40);

        fullname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameActionPerformed(evt);
            }
        });
        jPanel3.add(fullname);
        fullname.setBounds(40, 130, 260, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 165, 31));
        jLabel14.setText("Full name");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(50, 100, 150, 40);

        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        jPanel3.add(Password);
        Password.setBounds(40, 250, 260, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(380, 20, 340, 410);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel7.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Red and Beige Illustrative Japanase Food Ramen Logo (190 x 160 px) (260 x 230 px).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel7.add(jLabel1);
        jLabel1.setBounds(30, 40, 260, 210);
        jPanel7.add(jLabel15);
        jLabel15.setBounds(130, 220, 0, 0);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 165, 31));
        jLabel7.setText("Discover, create, and share ");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(10, 250, 350, 50);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 165, 31));
        jLabel9.setText("your favotire recipes ");
        jPanel7.add(jLabel9);
        jLabel9.setBounds(40, 290, 310, 50);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(10, 20, 340, 410);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Brown Modern Restaurant Presentation (730 x 450 px).png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 730, 450);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(this, "you clicked the button");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasswordActionPerformed
        
    }//GEN-LAST:event_jpasswordActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
JOptionPane.showMessageDialog(null, "You have click Email button");        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        config.config con = new config.config();
        con.ensureUsersTable();
        String fn = fullname.getText().trim();
        String em = Email.getText().trim();
        String un = username.getText().trim();
        String pass = new String(Password.getPassword()).trim();
        String rl = "User"; // default role for this form
        if (fn.isEmpty()) { javax.swing.JOptionPane.showMessageDialog(null, "Please fill out full name"); return; }
        if (em.isEmpty()) { javax.swing.JOptionPane.showMessageDialog(null, "Please fill out email"); return; }
        if (!em.contains("@") || !em.contains(".")) { javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid email"); return; }
        if (un.isEmpty()) { javax.swing.JOptionPane.showMessageDialog(null, "Please fill out username"); return; }

        try {
            if (editingUserId == null) {
                // create
                if (pass.isEmpty()) { javax.swing.JOptionPane.showMessageDialog(null, "Please fill out password"); return; }
                if (pass.length() < 8) { javax.swing.JOptionPane.showMessageDialog(null, "Password must be at least 8 characters"); return; }
                boolean exists = con.existsRecord("SELECT 1 FROM Users WHERE u_email = ? OR u_username = ?", em, un);
                if (exists) { javax.swing.JOptionPane.showMessageDialog(null, "Email or Username already exists"); return; }
                String hashed = config.config.hashPassword(pass);
                int approved = 0;
                String sql = "INSERT INTO Users (u_full_name, u_email, u_username, u_pass, u_role, u_approved) VALUES (?, ?, ?, ?, ?, ?)";
                con.addRecord(sql, fn, em, un, hashed, rl, approved);
                javax.swing.JOptionPane.showMessageDialog(null, "Account created");
                this.dispose();
            } else {
                // update (password optional)
                if (!pass.isEmpty() && pass.length() < 8) { javax.swing.JOptionPane.showMessageDialog(null, "Password must be at least 8 characters"); return; }
                if (!pass.isEmpty()) {
                    String hashed = config.config.hashPassword(pass);
                    con.updateRecord("UPDATE Users SET u_full_name = ?, u_email = ?, u_username = ?, u_pass = ? WHERE u_id = ?",
                        fn, em, un, hashed, editingUserId);
                } else {
                    con.updateRecord("UPDATE Users SET u_full_name = ?, u_email = ?, u_username = ? WHERE u_id = ?",
                        fn, em, un, editingUserId);
                }
                javax.swing.JOptionPane.showMessageDialog(null, "User updated.");
                this.dispose();
            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error saving user: " + ex.getMessage());
        }
    }//GEN-LAST:event_signupActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        login l = new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameActionPerformed
JOptionPane.showMessageDialog(null, "You have click full name button");
    }//GEN-LAST:event_fullnameActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

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
            java.util.logging.Logger.getLogger(ADDuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADDuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADDuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADDuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADDuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField fullname;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jpassword;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
