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
public class Users extends javax.swing.JFrame {
    private final config.config con = new config.config();

     void displayUser(){
        String sql = "SELECT u_id AS ID, u_full_name AS Name, u_email AS Email, u_username AS Username, u_role AS Role, u_approved AS Approved FROM Users";
        con.displayData(sql, UsersTable);
    }

    
   
    public Users() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        displayUser();
        if (Search1 != null && Search1.getDocument() != null) {
            Search1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                public void insertUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void removeUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void changedUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
            });
        }
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
        jPanel17 = new javax.swing.JPanel();
        ADD37 = new javax.swing.JButton();
        ADD38 = new javax.swing.JButton();
        ADD39 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ADD40 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        Search1 = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Approve = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setLayout(null);

        jPanel17.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(null);

        ADD37.setBackground(new java.awt.Color(255, 255, 255));
        ADD37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD37.setText("Profile");
        ADD37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD37ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD37);
        ADD37.setBounds(40, 290, 100, 30);

        ADD38.setBackground(new java.awt.Color(255, 255, 255));
        ADD38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD38.setText("Users");
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
        ADD38.setBounds(40, 170, 100, 30);

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
        ADD39.setBounds(40, 110, 100, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ADMIN PANEL");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel17.add(jLabel4);
        jLabel4.setBounds(20, 20, 140, 40);

        ADD40.setBackground(new java.awt.Color(255, 255, 255));
        ADD40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD40.setText("Review");
        ADD40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD40MouseClicked(evt);
            }
        });
        ADD40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD40ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD40);
        ADD40.setBounds(40, 230, 100, 30);

        jPanel8.add(jPanel17);
        jPanel17.setBounds(20, 20, 180, 430);

        UsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        UsersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UsersTable);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(220, 70, 590, 380);

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
        Search1.setBounds(10, 10, 180, 30);

        Delete.setBackground(new java.awt.Color(255, 255, 255));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel13.add(Delete);
        Delete.setBounds(490, 10, 90, 30);

        Update.setBackground(new java.awt.Color(255, 255, 255));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel13.add(Update);
        Update.setBounds(290, 10, 83, 30);

        Approve.setBackground(new java.awt.Color(255, 255, 255));
        Approve.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Approve.setText("Approve");
        Approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveActionPerformed(evt);
            }
        });
        jPanel13.add(Approve);
        Approve.setBounds(380, 10, 100, 30);

        ADD.setBackground(new java.awt.Color(255, 255, 255));
        ADD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        jPanel13.add(ADD);
        ADD.setBounds(200, 10, 83, 30);

        jPanel8.add(jPanel13);
        jPanel13.setBounds(220, 20, 590, 50);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 30, 830, 480);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 880, 530);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void ADD37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD37ActionPerformed
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD37ActionPerformed

    private void ADD38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD38MouseClicked
        Manage l = new Manage();
        l.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_ADD38MouseClicked

    private void ADD38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD38ActionPerformed
 Users l = new Users();
        l.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_ADD38ActionPerformed

    private void ADD39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD39MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD39MouseClicked

    private void ADD39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD39ActionPerformed
 Admin l = new Admin();
        l.setVisible(true);
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_ADD39ActionPerformed

    private void ADD40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD40MouseClicked

    private void ADD40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD40ActionPerformed
 review l = new review();
        l.setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_ADD40ActionPerformed

    private void UsersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UsersTableMouseClicked

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search1ActionPerformed
        performSearch();
    }//GEN-LAST:event_Search1ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int row = UsersTable.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to delete.");
            return;
        }
        String idStr = String.valueOf(UsersTable.getValueAt(row, 0));
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Delete user id " + idStr + "?", "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) return;
        try {
            int id = Integer.parseInt(idStr);
            con.deleteRecord("DELETE FROM Users WHERE u_id = ?", id);
            javax.swing.JOptionPane.showMessageDialog(this, "User deleted.");
            displayUser();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error deleting user: " + ex.getMessage());
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void Search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search1KeyReleased
        performSearch();
    }//GEN-LAST:event_Search1KeyReleased

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        int row = UsersTable.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to update.");
            return;
        }
        ADDuser uform = new ADDuser();
        String idStr = String.valueOf(UsersTable.getValueAt(row, 0));
        try {
            int id = Integer.parseInt(idStr);
            uform.loadUser(id);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading user: " + ex.getMessage());
            return;
        }
        uform.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                displayUser();
            }
        });
        uform.setVisible(true);
    }//GEN-LAST:event_UpdateActionPerformed

    private void ApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveActionPerformed
        int row = UsersTable.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to approve.");
            return;
        }
        String idStr = String.valueOf(UsersTable.getValueAt(row, 0));
        try {
            int id = Integer.parseInt(idStr);
            // set approved to 1
            con.updateRecord("UPDATE Users SET u_approved = 1 WHERE u_id = ?", id);
            javax.swing.JOptionPane.showMessageDialog(this, "User approved.");
            displayUser();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error approving user: " + ex.getMessage());
        }
    }//GEN-LAST:event_ApproveActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        ADDuser addForm = new ADDuser();
        addForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                displayUser();
            }
        });
        addForm.setVisible(true);
    }//GEN-LAST:event_ADDActionPerformed

    private void performSearch() {
        String searchText = Search1.getText().trim();
        String sql = "SELECT u_id AS ID, u_full_name AS Name, u_email AS Email, u_username AS Username, u_role AS Role, u_approved AS Approved " +
        "FROM Users " +
        "WHERE u_full_name LIKE ? OR u_email LIKE ? OR u_username LIKE ? OR CAST(u_id AS TEXT) LIKE ?";
        String pattern = "%" + searchText + "%";
        con.displayData(sql, UsersTable, pattern, pattern, pattern, pattern);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (config.Session.getInstance().isLoggedIn()) {
                    new Users().setVisible(true);
                } else {
                    new landingPage1().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton ADD37;
    private javax.swing.JButton ADD38;
    private javax.swing.JButton ADD39;
    private javax.swing.JButton ADD40;
    private javax.swing.JButton Approve;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Search1;
    private javax.swing.JButton Update;
    private javax.swing.JTable UsersTable;
    private java.awt.Canvas canvas1;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
