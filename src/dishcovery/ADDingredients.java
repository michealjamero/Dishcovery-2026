package dishcovery;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;

public class ADDingredients extends javax.swing.JFrame {
    private final config.config con = new config.config();
    private Integer recipeId = null;

    public ADDingredients() {
        config.Session.requireLogin(this);
        initComponents();
    }

    public ADDingredients(Integer recipeId) {
        config.Session.requireLogin(this);
        initComponents();
        this.recipeId = recipeId;
        if (recipeId != null) {
            loadRecipeTitle();
            loadIngredientsTable();
        }
    }

    @SuppressWarnings("unchecked")
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
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ADD3 = new javax.swing.JButton();
        ADD8 = new javax.swing.JButton();
        Unit = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        INGREDIENTSTABLE = new javax.swing.JPanel();
        Quantity = new javax.swing.JTextField();
        TITLE = new javax.swing.JLabel();
        ADD9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(0, 0, 0, 80));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jPanel2.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0, 50));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0, 80));
        jPanel3.setLayout(null);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Name:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(10, 70, 60, 20);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantity:");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(10, 130, 60, 20);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Unit");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(10, 190, 60, 20);

        ADD3.setBackground(new java.awt.Color(224, 196, 160));
        ADD3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        ADD3.setForeground(new java.awt.Color(255, 165, 31));
        ADD3.setText("ADD");
        ADD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD3ActionPerformed(evt);
            }
        });
        jPanel3.add(ADD3);
        ADD3.setBounds(30, 540, 120, 20);

        ADD8.setBackground(new java.awt.Color(255, 255, 255));
        ADD8.setFont(new java.awt.Font("Segoe UI", 1, 14));
        ADD8.setText("ADD");
        ADD8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD8ActionPerformed(evt);
            }
        });
        jPanel3.add(ADD8);
        ADD8.setBounds(190, 250, 80, 30);

        jPanel3.add(Unit);
        Unit.setBounds(90, 190, 180, 30);

        jPanel3.add(Name);
        Name.setBounds(90, 70, 180, 30);

        jPanel3.add(INGREDIENTSTABLE);
        INGREDIENTSTABLE.setBounds(310, 70, 340, 210);

        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });
        jPanel3.add(Quantity);
        Quantity.setBounds(90, 130, 180, 30);

        TITLE.setFont(new java.awt.Font("Segoe UI", 1, 24));
        TITLE.setForeground(new java.awt.Color(255, 255, 255));
        TITLE.setText("TITLE");
        TITLE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(TITLE);
        TITLE.setBounds(240, 10, 360, 32);

        ADD9.setBackground(new java.awt.Color(255, 255, 255));
        ADD9.setFont(new java.awt.Font("Segoe UI", 1, 14));
        ADD9.setText("ADD");
        ADD9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD9ActionPerformed(evt);
            }
        });
        jPanel3.add(ADD9);
        ADD9.setBounds(90, 250, 80, 30);

        jPanel12.add(jPanel3);
        jPanel3.setBounds(20, 20, 670, 300);

        jPanel2.add(jPanel12);
        jPanel12.setBounds(30, 60, 710, 350);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADD INGREDIENTS");
        jPanel1.add(jLabel9);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(30, 10, 710, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new back.png")));
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 770, 440);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 440));

        pack();
        setLocationRelativeTo(null);
    }

    private void loadRecipeTitle() {
        try {
            if (recipeId == null) {
                TITLE.setText("ADD INGREDIENTS");
                return;
            }
            List<Map<String, Object>> rows = con.fetchRecords("SELECT r_title FROM Recipes WHERE r_id = ?", recipeId);
            if (!rows.isEmpty()) {
                Object t = rows.get(0).get("r_title");
                if (t == null) t = rows.get(0).get("R_TITLE");
                TITLE.setText(t != null ? String.valueOf(t) : "ADD INGREDIENTS");
            }
        } catch (Exception ex) {
            System.out.println("Error loading recipe title: " + ex.getMessage());
        }
    }

    private void loadIngredientsTable() {
        if (recipeId == null) return;
        try {
            List<Map<String, Object>> rows = con.fetchRecords(
                "SELECT i_id, i_name, i_qty, i_unit, i_created_by, i_created_at FROM Ingredients WHERE i_recipe_id = ?", 
                recipeId
            );
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Qty");
            model.addColumn("Unit");
            model.addColumn("By");
            model.addColumn("Created At");
            for (Map<String, Object> r : rows) {
                Object id = r.getOrDefault("i_id", r.get("I_ID"));
                Object name = r.getOrDefault("i_name", r.get("I_NAME"));
                Object qty = r.getOrDefault("i_qty", r.get("I_QTY"));
                Object unit = r.getOrDefault("i_unit", r.get("I_UNIT"));
                Object by = r.getOrDefault("i_created_by", r.get("I_CREATED_BY"));
                Object at = r.getOrDefault("i_created_at", r.get("I_CREATED_AT"));
                model.addRow(new Object[]{id, name, qty, unit, by, at});
            }
            JTable table = new JTable(model);
            INGREDIENTSTABLE.removeAll();
            INGREDIENTSTABLE.add(new JScrollPane(table));
            INGREDIENTSTABLE.revalidate();
            INGREDIENTSTABLE.repaint();
        } catch (Exception ex) {
            System.out.println("Error loading ingredients: " + ex.getMessage());
        }
    }

    private void ADD8ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = Name.getText().trim();
        String qty = Quantity.getText().trim();
        String unit = Unit.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingredient name is required");
            return;
        }
        con.ensureRecipesTable();
        String createSql = "CREATE TABLE IF NOT EXISTS Ingredients (" +
                "i_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "i_recipe_id INTEGER, " +
                "i_name TEXT NOT NULL, " +
                "i_qty TEXT, " +
                "i_unit TEXT, " +
                "i_created_by TEXT, " +
                "i_created_at TEXT" +
                ")";
        try (java.sql.Connection conn = con.connectDB();
             java.sql.PreparedStatement ps = conn.prepareStatement(createSql)) {
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error ensuring Ingredients table: " + ex.getMessage());
        }

        String author = config.Session.getInstance() != null && config.Session.getInstance().getUsername() != null
                ? config.Session.getInstance().getUsername() : "Anonymous";
        String now = java.time.LocalDate.now().toString();
        try {
            String insertSql = "INSERT INTO Ingredients (i_recipe_id, i_name, i_qty, i_unit, i_created_by, i_created_at) VALUES (?, ?, ?, ?, ?, ?)";
            con.addRecord(insertSql, recipeId, name, qty, unit, author, now);
            JOptionPane.showMessageDialog(this, "Ingredient saved: " + name);
            Name.setText("");
            Quantity.setText("");
            Unit.setText("");
            loadIngredientsTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving ingredient: " + ex.getMessage());
        }
    }

    private void ADD3ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ADD9ActionPerformed(java.awt.event.ActionEvent evt) {
        if (recipeId != null) {
            Manage m = new Manage();
            m.setVisible(true);
        } else {
            ADD a = new ADD();
            a.setVisible(true);
        }
        this.dispose();
    }

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(ADDingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADDingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADDingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADDingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADDingredients().setVisible(true);
            }
        });
    }

    private javax.swing.JButton ADD3;
    private javax.swing.JButton ADD8;
    private javax.swing.JButton ADD9;
    private javax.swing.JPanel INGREDIENTSTABLE;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Quantity;
    private javax.swing.JLabel TITLE;
    private javax.swing.JTextField Unit;
    private java.awt.Canvas canvas1;
    private java.awt.Choice choice1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField10;
}
