/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package dishcovery;
 
 import config.config;
 import javax.swing.JOptionPane;
 
 /**
  *
  * @author user
 */
public class landingPage1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public landingPage1() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jpassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        signup2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white orange modern food dekstop prototype (730 x 450 px).png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundLandingpage.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Red and Beige Illustrative Japanase Food Ramen Logo (190 x 160 px) (260 x 230 px).png"))); // NOI18N

        signup.setBackground(new java.awt.Color(224, 196, 160));
        signup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signup.setText("Get Started");
        signup.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                signupMouseDragged(evt);
            }
        });
        signup.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                signupMouseWheelMoved(evt);
            }
        });
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        jPanel2.setLayout(null);

        signup2.setBackground(new java.awt.Color(0, 0, 0));
        signup2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        signup2.setForeground(new java.awt.Color(255, 165, 31));
        signup2.setText("Get Started");
        signup2.setContentAreaFilled(false);
        signup2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                signup2MouseDragged(evt);
            }
        });
        signup2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                signup2MouseWheelMoved(evt);
            }
        });
        signup2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup2ActionPerformed(evt);
            }
        });
        jPanel2.add(signup2);
        signup2.setBounds(260, 310, 180, 29);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landingpages.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(-50, 280, 280, 220);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landingpage.png"))); // NOI18N
        jLabel11.setText("jLabel6");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(-100, 140, 280, 220);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landingpage.png"))); // NOI18N
        jLabel9.setText("jLabel6");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(470, 260, 280, 220);

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Red and Beige Illustrative Japanase Food Ramen Logo (190 x 160 px) (260 x 230 px).png"))); // NOI18N
        jPanel2.add(jLabel12);
        jLabel12.setBounds(220, 80, 280, 220);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landingpages.png"))); // NOI18N
        jLabel10.setText("jLabel");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(520, 130, 280, 220);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 80, 710, 280);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Brown Modern Restaurant Presentation (730 x 450 px).png"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(0, -6, 710, 460);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(this, "you clicked the button");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasswordActionPerformed
        
    }//GEN-LAST:event_jpasswordActionPerformed

    private void signupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_signupMouseDragged

    private void signupMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_signupMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_signupMouseWheelMoved

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        login l = new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupActionPerformed

    private void signup2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signup2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_signup2MouseDragged

    private void signup2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_signup2MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_signup2MouseWheelMoved

    private void signup2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup2ActionPerformed
        login l = new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signup2ActionPerformed

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
            java.util.logging.Logger.getLogger(landingPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(landingPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(landingPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(landingPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new landingPage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jpassword;
    private javax.swing.JButton signup;
    private javax.swing.JButton signup2;
    // End of variables declaration//GEN-END:variables
}
