package dishcovery;
import javax.swing.JOptionPane;

public class Users extends javax.swing.JFrame {
    private final config.config con = new config.config();

     void displayUser(){
        con.ensureUsersTable();
        String sql = "SELECT u_id AS ID, u_full_name AS Name, u_email AS Email, u_username AS Username, u_role AS Role, u_approved AS Approved FROM Users";
        con.displayData(sql, UsersTable);
    }

    public Users() {
        config.Session.requireLogin(this);
        if (!config.Session.getInstance().isLoggedIn()) {
            return;
        }
        initComponents();
        con.ensureUsersTable();
        displayUser();
        if (Search1 != null && Search1.getDocument() != null) {
            Search1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                public void insertUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void removeUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
                public void changedUpdate(javax.swing.event.DocumentEvent e) { performSearch(); }
            });
        }
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
        UsersTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        Search1 = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Approve = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel8.setLayout(null);

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

        jPanel21.setBackground(new java.awt.Color(0, 0, 0,60));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setLayout(null);

        ADD55.setBackground(new java.awt.Color(255, 255, 255));
        ADD55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD55.setText("Profile");
        ADD55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD55ActionPerformed(evt);
            }
        });
        jPanel21.add(ADD55);
        ADD55.setBounds(40, 350, 100, 30);

        ADD56.setBackground(new java.awt.Color(255, 255, 255));
        ADD56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        ADD57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
        ADD59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        Logs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 880, 530);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ADD55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD55ActionPerformed
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD55ActionPerformed

    private void ADD56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD56MouseClicked
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD56MouseClicked

    private void ADD56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD56ActionPerformed
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD56ActionPerformed

    private void ADD57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD57MouseClicked
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD57MouseClicked

    private void ADD57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD57ActionPerformed
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD57ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Admin l = new Admin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void ADD59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD59MouseClicked
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD59MouseClicked

    private void ADD59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD59ActionPerformed
        review l = new review();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADD59ActionPerformed

    private void LogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogsActionPerformed
        Logs l = new Logs();
        l.setVisible(true);
        this.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_LogsActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        Users l = new Users();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD37ActionPerformed(java.awt.event.ActionEvent evt) {
        profile l = new profile();
        l.setVisible(true);
        this.dispose();
    }

    private void ADD38MouseClicked(java.awt.event.MouseEvent evt) {
        ADD38ActionPerformed(null);
    }

    private void ADD38ActionPerformed(java.awt.event.ActionEvent evt) {
 Users l = new Users();
        l.setVisible(true);
        this.dispose();         
    }

    private void ADD39MouseClicked(java.awt.event.MouseEvent evt) {
        ADD39ActionPerformed(null);
    }

    private void ADD39ActionPerformed(java.awt.event.ActionEvent evt) {
        homePage2 l = new homePage2();
        l.setVisible(true);
        this.dispose();    
    }

    private void ADD40MouseClicked(java.awt.event.MouseEvent evt) {
        ADD40ActionPerformed(null);
    }

    private void ADD40ActionPerformed(java.awt.event.ActionEvent evt) {
 review l = new review();
        l.setVisible(true);
        this.dispose();         
    }

    private void UsersTableMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {
        performSearch();
    }

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void Search1KeyReleased(java.awt.event.KeyEvent evt) {
        performSearch();
    }

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void ApproveActionPerformed(java.awt.event.ActionEvent evt) {
        int row = UsersTable.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to approve.");
            return;
        }
        String idStr = String.valueOf(UsersTable.getValueAt(row, 0));
        try {
            int id = Integer.parseInt(idStr);
            con.updateRecord("UPDATE Users SET u_approved = 1 WHERE u_id = ?", id);
            javax.swing.JOptionPane.showMessageDialog(this, "User approved.");
            displayUser();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error approving user: " + ex.getMessage());
        }
    }

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {
        ADDuser addForm = new ADDuser();
        addForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                displayUser();
            }
        });
        addForm.setVisible(true);
    }

    private void performSearch() {
        con.ensureUsersTable();
        String searchText = Search1.getText().trim();
        String sql = "SELECT u_id AS ID, u_full_name AS Name, u_email AS Email, u_username AS Username, u_role AS Role, u_approved AS Approved " +
        "FROM Users " +
        "WHERE u_full_name LIKE ? OR u_email LIKE ? OR u_username LIKE ? OR CAST(u_id AS TEXT) LIKE ?";
        String pattern = "%" + searchText + "%";
        con.displayData(sql, UsersTable, pattern, pattern, pattern, pattern);
    }

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
    private javax.swing.JButton ADD55;
    private javax.swing.JButton ADD56;
    private javax.swing.JButton ADD57;
    private javax.swing.JButton ADD59;
    private javax.swing.JButton Approve;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Logs;
    private javax.swing.JTextField Search1;
    private javax.swing.JButton Update;
    private javax.swing.JTable UsersTable;
    private java.awt.Canvas canvas1;
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
