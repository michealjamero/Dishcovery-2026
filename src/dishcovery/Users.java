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
        con.displayData(sql, recipeTable);
    }

    
   
    public Users() {
        config.Session.requireLogin(this);
        initComponents();
        displayUser();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        ADD35 = new javax.swing.JButton();
        ADD37 = new javax.swing.JButton();
        ADD38 = new javax.swing.JButton();
        ADD39 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ADD40 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        Search1 = new javax.swing.JTextField();
        view = new javax.swing.JButton();
        view1 = new javax.swing.JButton();
        view2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,80));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("View Recipes");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(450, 20, 150, 30);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Search,review and manage recipes");
        jPanel8.add(jLabel15);
        jLabel15.setBounds(410, 50, 260, 30);

        jPanel17.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(null);

        ADD35.setBackground(new java.awt.Color(255, 255, 255));
        ADD35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD35.setText("Approve");
        ADD35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD35ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD35);
        ADD35.setBounds(40, 290, 100, 30);

        ADD37.setBackground(new java.awt.Color(255, 255, 255));
        ADD37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD37.setText("Profile");
        ADD37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD37ActionPerformed(evt);
            }
        });
        jPanel17.add(ADD37);
        ADD37.setBounds(40, 350, 100, 30);

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

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(220, 130, 590, 320);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(null);

        Search1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search1ActionPerformed(evt);
            }
        });
        Search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Search1KeyReleased(evt);
            }
        });
        jPanel13.add(Search1);
        Search1.setBounds(10, 10, 270, 30);

        view.setBackground(new java.awt.Color(255, 255, 255));
        view.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view.setText("Delete");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        jPanel13.add(view);
        view.setBounds(400, 10, 90, 30);

        view1.setBackground(new java.awt.Color(255, 255, 255));
        view1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view1.setText("Add");
        view1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view1ActionPerformed(evt);
            }
        });
        jPanel13.add(view1);
        view1.setBounds(500, 10, 83, 30);

        view2.setBackground(new java.awt.Color(255, 255, 255));
        view2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view2.setText("Approve");
        view2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view2ActionPerformed(evt);
            }
        });
        jPanel13.add(view2);
        view2.setBounds(290, 10, 100, 30);

        jPanel8.add(jPanel13);
        jPanel13.setBounds(220, 80, 590, 50);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(20, 30, 830, 480);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 880, 530);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void ADD35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD35ActionPerformed

    private void ADD37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD37ActionPerformed
        Users l = new Users();
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
Users l = new Users();
        l.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_ADD39ActionPerformed

    private void ADD40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD40MouseClicked

    private void ADD40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADD40ActionPerformed

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_recipeTableMouseClicked

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search1ActionPerformed
        performSearch();
    }//GEN-LAST:event_Search1ActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        int row = recipeTable.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to delete.");
            return;
        }
        String idStr = String.valueOf(recipeTable.getValueAt(row, 0));
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
    }//GEN-LAST:event_viewActionPerformed

    private void Search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search1KeyReleased
        performSearch();
    }//GEN-LAST:event_Search1KeyReleased

    private void view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view1ActionPerformed
        ADDuser uform = new ADDuser();
        int row = recipeTable.getSelectedRow();
        if (row >= 0) {
            String idStr = String.valueOf(recipeTable.getValueAt(row, 0));
            try {
                int id = Integer.parseInt(idStr);
                uform.loadUser(id);
            } catch (Exception ex) { }
        }
        uform.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                displayUser();
            }
        });
        uform.setVisible(true);
    }//GEN-LAST:event_view1ActionPerformed

    private void view2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view2ActionPerformed
        int row = recipeTable.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to approve.");
            return;
        }
        String idStr = String.valueOf(recipeTable.getValueAt(row, 0));
        try {
            int id = Integer.parseInt(idStr);
            // set approved to 1
            con.updateRecord("UPDATE Users SET u_approved = 1 WHERE u_id = ?", id);
            javax.swing.JOptionPane.showMessageDialog(this, "User approved.");
            displayUser();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error approving user: " + ex.getMessage());
        }
    }//GEN-LAST:event_view2ActionPerformed

    private void performSearch() {
        String searchText = Search1.getText().trim();
        String sql = "SELECT u_id AS ID, u_full_name AS Name, u_email AS Email, u_username AS Username, u_role AS Role, u_approved AS Approved " +
        "FROM Users " +
        "WHERE u_full_name LIKE ? OR u_email LIKE ? OR u_username LIKE ? OR CAST(u_id AS TEXT) LIKE ?";
        String pattern = "%" + searchText + "%";
        con.displayData(sql, recipeTable, pattern, pattern, pattern, pattern);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD35;
    private javax.swing.JButton ADD37;
    private javax.swing.JButton ADD38;
    private javax.swing.JButton ADD39;
    private javax.swing.JButton ADD40;
    private javax.swing.JTextField Search1;
    private java.awt.Canvas canvas1;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable recipeTable;
    private javax.swing.JButton view;
    private javax.swing.JButton view1;
    private javax.swing.JButton view2;
    // End of variables declaration//GEN-END:variables
}
