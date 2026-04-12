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

    private final config.config con = new config.config();
    private Integer editingUserId = null;
    public ADDuser() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        setupCreateMode();
    }

    public void loadUser(int id) {
        try {
            con.ensureUsersTable();
            java.util.List<java.util.Map<String,Object>> rows = con.fetchRecords(
                "SELECT u_full_name, u_email, u_username, u_role FROM Users WHERE u_id = ? LIMIT 1",
                id
            );
            if (!rows.isEmpty()) {
                java.util.Map<String,Object> row = rows.get(0);
                fullname.setText(row.get("u_full_name") != null ? String.valueOf(row.get("u_full_name")) : "");
                Email.setText(row.get("u_email") != null ? String.valueOf(row.get("u_email")) : "");
                username.setText(row.get("u_username") != null ? String.valueOf(row.get("u_username")) : "");
                Password.setText("");
                editingUserId = id;
                signup.setText("Update");
                jLabel5.setText("Update User");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading user: " + ex.getMessage());
        }
    }

    private void setupCreateMode() {
        try { setLocationRelativeTo(null); } catch (Exception ignored) {}
        editingUserId = null;
        try { signup.setText("ADD"); } catch (Exception ignored) {}
        try { jLabel5.setText("Add User"); } catch (Exception ignored) {}
        try { fullname.setText(""); } catch (Exception ignored) {}
        try { Email.setText(""); } catch (Exception ignored) {}
        try { username.setText(""); } catch (Exception ignored) {}
        try { Password.setText(""); } catch (Exception ignored) {}
    }

    private void handleSave() {
        con.ensureUsersTable();
        String fn = fullname.getText() != null ? fullname.getText().trim() : "";
        String em = Email.getText() != null ? Email.getText().trim() : "";
        String un = username.getText() != null ? username.getText().trim() : "";
        String pass = new String(Password.getPassword()).trim();

        if (fn.isEmpty()) { JOptionPane.showMessageDialog(this, "Please fill out full name"); return; }
        if (em.isEmpty()) { JOptionPane.showMessageDialog(this, "Please fill out email"); return; }
        if (!em.contains("@") || !em.contains(".")) { JOptionPane.showMessageDialog(this, "Please enter a valid email"); return; }
        if (un.isEmpty()) { JOptionPane.showMessageDialog(this, "Please fill out username"); return; }

        try {
            if (editingUserId == null) {
                if (pass.isEmpty()) { JOptionPane.showMessageDialog(this, "Please fill out password"); return; }
                if (pass.length() < 8) { JOptionPane.showMessageDialog(this, "Password must be at least 8 characters"); return; }
                boolean exists = con.existsRecord("SELECT 1 FROM Users WHERE u_email = ? OR u_username = ? LIMIT 1", em, un);
                if (exists) { JOptionPane.showMessageDialog(this, "Email or Username already exists"); return; }

                String hashed = config.config.hashPassword(pass);
                if (hashed == null || hashed.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Failed to hash password.");
                    return;
                }

                int approved = 0;
                String rl = "User";
                String sql = "INSERT INTO Users (u_full_name, u_email, u_username, u_pass, u_role, u_approved) VALUES (?, ?, ?, ?, ?, ?)";
                con.addRecord(sql, fn, em, un, hashed, rl, approved);
                JOptionPane.showMessageDialog(this, "Account created");
                dispose();
            } else {
                boolean existsOther = con.existsRecord(
                        "SELECT 1 FROM Users WHERE (u_email = ? OR u_username = ?) AND u_id <> ? LIMIT 1",
                        em, un, editingUserId
                );
                if (existsOther) { JOptionPane.showMessageDialog(this, "Email or Username already exists"); return; }

                if (!pass.isEmpty() && pass.length() < 8) { JOptionPane.showMessageDialog(this, "Password must be at least 8 characters"); return; }

                if (!pass.isEmpty()) {
                    String hashed = config.config.hashPassword(pass);
                    if (hashed == null || hashed.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Failed to hash password.");
                        return;
                    }
                    con.updateRecord("UPDATE Users SET u_full_name = ?, u_email = ?, u_username = ?, u_pass = ? WHERE u_id = ?",
                            fn, em, un, hashed, editingUserId);
                } else {
                    con.updateRecord("UPDATE Users SET u_full_name = ?, u_email = ?, u_username = ? WHERE u_id = ?",
                            fn, em, un, editingUserId);
                }
                JOptionPane.showMessageDialog(this, "User updated.");
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving user: " + ex.getMessage());
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
        jLabel11 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        signup1 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(232, 210, 184));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel3.setForeground(new java.awt.Color(232, 210, 184));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sign up");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(120, 0, 170, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
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

        signup.setBackground(new java.awt.Color(255, 255, 255));
        signup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signup.setText("ADD");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel3.add(signup);
        signup.setBounds(180, 300, 120, 29);

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(50, 160, 150, 40);

        username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel3.add(username);
        username.setBounds(40, 70, 260, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
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

        signup1.setBackground(new java.awt.Color(255, 255, 255));
        signup1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signup1.setText("CANCEL");
        signup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup1ActionPerformed(evt);
            }
        });
        jPanel3.add(signup1);
        signup1.setBounds(40, 300, 120, 29);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(40, 50, 340, 350);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 430, 450);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasswordActionPerformed
        
    }//GEN-LAST:event_jpasswordActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
    }//GEN-LAST:event_EmailActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        handleSave();
    }//GEN-LAST:event_signupActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
    }//GEN-LAST:event_usernameActionPerformed

    private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameActionPerformed
    }//GEN-LAST:event_fullnameActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
    }//GEN-LAST:event_PasswordActionPerformed

    private void signup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup1ActionPerformed
        if ("Admin".equalsIgnoreCase(config.Session.getInstance().getRole())) {
            new profile().setVisible(true);
        } else {
            new profileadmin().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_signup1ActionPerformed

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jpassword;
    private javax.swing.JButton signup;
    private javax.swing.JButton signup1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
