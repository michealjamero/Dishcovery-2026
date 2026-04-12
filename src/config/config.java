/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER7
 */
public class config {
    private static String DB_URL = "jdbc:sqlite:Dishcovery_System.db";
    private static boolean isDbChecked = false;

    //Connection Method to SQLITE
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Connection Successful");
            
            if (!isDbChecked) {
                isDbChecked = true;
                config c = new config();
                c.ensureUsersTable();
                c.ensureRecipesTable();
                c.ensureCommentsTable();
                c.ensureRatingsTable();
                c.ensureFollowersTable();
                c.ensurePrintLogsTable();
            }
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    public static void setDatabaseFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) return;
        DB_URL = "jdbc:sqlite:" + filename.trim();
    }
    public void initializeNewDatabase(String filename) {
        setDatabaseFile(filename);
        try (Connection conn = connectDB()) {
        } catch (Exception e) {
            System.out.println("Initialization error: " + e.getMessage());
        }
        ensureUsersTable();
        ensureRecipesTable();
    }
    public void ensureRecipesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Recipes (" +
                "r_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "r_title TEXT NOT NULL, " +
                "r_description TEXT NOT NULL, " +
                "r_author TEXT, " +
                "r_category TEXT, " +
                "r_date TEXT, " +
                "r_instructions TEXT, " +
                "r_ingredients TEXT, " +
                "r_prep_time TEXT, " +
                "r_cook_time TEXT, " +
                "r_servings TEXT, " +
                "r_prep_category TEXT, " +
                "r_cook_time_category TEXT, " +
                "r_shared INTEGER DEFAULT 0, " +
                "r_status TEXT, " +
                "r_saved INTEGER DEFAULT 0, " +
                "r_reviewed_by TEXT, " +
                "r_image BLOB, " +
                "r_bg_image BLOB" +
                ")";
        try (Connection conn = connectDB()) {
            if (conn == null) {
                System.out.println("Error ensuring Recipes table: Database connection unavailable");
                return;
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.executeUpdate();
            }

            // Handle migrations for existing tables
            String[] columns = {"r_category", "r_date", "r_instructions", "r_ingredients", "r_prep_time", "r_cook_time", "r_servings", "r_status", "r_image", "r_bg_image", "r_prep_category", "r_cook_time_category", "r_saved", "r_reviewed_by"};
            for (String col : columns) {
                try (PreparedStatement check = conn.prepareStatement("SELECT name FROM pragma_table_info('Recipes') WHERE name=?")) {
                    check.setString(1, col);
                    try (ResultSet rs = check.executeQuery()) {
                        if (!rs.next()) {
                            String type = "TEXT";
                            if (col.equals("r_image") || col.equals("r_bg_image")) type = "BLOB";
                            if (col.equals("r_saved")) type = "INTEGER DEFAULT 0";
                            try (PreparedStatement alter = conn.prepareStatement("ALTER TABLE Recipes ADD COLUMN " + col + " " + type)) {
                                alter.executeUpdate();
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error ensuring Recipes table: " + e.getMessage());
        }
    }
    public boolean existsRecord(String sql, Object... params) {
        Connection conn = connectDB();
        if (conn == null) {
            System.out.println("Error checking record existence: Database connection unavailable");
            return false;
        }
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setPreparedStatementValues(pstmt, params);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error checking record existence: " + e.getMessage());
            return false;
        } finally {
            try { conn.close(); } catch (Exception ignored) {}
        }
    }
    public void ensureUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                "u_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "u_full_name TEXT NOT NULL, " +
                "u_email TEXT NOT NULL UNIQUE, " +
                "u_username TEXT NOT NULL UNIQUE, " +
                "u_pass TEXT NOT NULL, " +
                "u_role TEXT NOT NULL, " +
                "u_approved INTEGER DEFAULT 0, " +
                "u_image BLOB" +
                ")";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ensuring Users table: " + e.getMessage());
        }
    }

    public void ensureCommentsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Comments (" +
                "c_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "c_recipe_id INTEGER NOT NULL, " +
                "c_user_id INTEGER NOT NULL, " +
                "c_comment TEXT NOT NULL, " +
                "c_date TEXT, " +
                "FOREIGN KEY(c_recipe_id) REFERENCES Recipes(r_id), " +
                "FOREIGN KEY(c_user_id) REFERENCES Users(u_id)" +
                ")";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ensuring Comments table: " + e.getMessage());
        }
    }

    public void ensureRatingsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Ratings (" +
                "r_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "r_recipe_id INTEGER NOT NULL, " +
                "r_user_id INTEGER NOT NULL, " +
                "r_rating INTEGER NOT NULL, " +
                "r_date TEXT, " +
                "FOREIGN KEY(r_recipe_id) REFERENCES Recipes(r_id), " +
                "FOREIGN KEY(r_user_id) REFERENCES Users(u_id)" +
                ")";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ensuring Ratings table: " + e.getMessage());
        }
    }

    public void ensureFollowersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Followers (" +
                "f_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "f_follower_id INTEGER NOT NULL, " +
                "f_following_id INTEGER NOT NULL, " +
                "f_date TEXT, " +
                "UNIQUE(f_follower_id, f_following_id), " +
                "FOREIGN KEY(f_follower_id) REFERENCES Users(u_id), " +
                "FOREIGN KEY(f_following_id) REFERENCES Users(u_id)" +
                ")";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ensuring Followers table: " + e.getMessage());
        }
    }

    public void addRecord(String sql, Object... values) {
        try (Connection conn = connectDB(); // Use the connectDB method
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            setPreparedStatementValues(pstmt, values);
    
            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
            throw new RuntimeException(e); // Propagate error to UI
        }
    }
  // Dynamic view method to display records from any table
    public void viewRecords(String sqlQuery, String[] columnHeaders, String[] columnNames) {
        // Check that columnHeaders and columnNames arrays are the same length
        if (columnHeaders.length != columnNames.length) {
            System.out.println("Error: Mismatch between column headers and column names.");
            return;
        }

        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
             ResultSet rs = pstmt.executeQuery()) {

            // Print the headers dynamically
            StringBuilder headerLine = new StringBuilder();
            headerLine.append("--------------------------------------------------------------------------------\n| ");
            for (String header : columnHeaders) {
                headerLine.append(String.format("%-20s | ", header)); // Adjust formatting as needed
            }
            headerLine.append("\n--------------------------------------------------------------------------------");

            System.out.println(headerLine.toString());

            // Print the rows dynamically based on the provided column names
            while (rs.next()) {
                StringBuilder row = new StringBuilder("| ");
                for (String colName : columnNames) {
                    String value = rs.getString(colName);
                    row.append(String.format("%-20s | ", value != null ? value : "")); // Adjust formatting
                }
                System.out.println(row.toString());
            }
            System.out.println("--------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Error retrieving records: " + e.getMessage());
        }
    }
    //-----------------------------------------------
    // UPDATE METHOD
    //-----------------------------------------------
    
    public void updateRecord(String sql, Object... values) {
        try (Connection conn = connectDB(); // Use the connectDB method
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            setPreparedStatementValues(pstmt, values);

            pstmt.executeUpdate();
            System.out.println("Record updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
            throw new RuntimeException(e); // Propagate error to UI
        }
    }

    public java.sql.ResultSet getData(String sql) throws SQLException {
        Connection conn = connectDB();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.executeQuery();
    }
// Add this method in the config class
public void deleteRecord(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        setPreparedStatementValues(pstmt, values);
        pstmt.executeUpdate();
        System.out.println("Record deleted successfully!");
    } catch (SQLException e) {
        System.out.println("Error deleting record: " + e.getMessage());
        throw new RuntimeException(e);
    }
}
//-----------------------------------------------
    // Helper Method for Setting PreparedStatement Values
    //-----------------------------------------------
    private void setPreparedStatementValues(PreparedStatement pstmt, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) values[i]);
            } else if (values[i] instanceof Double) {
                pstmt.setDouble(i + 1, (Double) values[i]);
            } else if (values[i] instanceof Float) {
                pstmt.setFloat(i + 1, (Float) values[i]);
            } else if (values[i] instanceof Long) {
                pstmt.setLong(i + 1, (Long) values[i]);
            } else if (values[i] instanceof Boolean) {
                pstmt.setBoolean(i + 1, (Boolean) values[i]);
            } else if (values[i] instanceof java.util.Date) {
                pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) values[i]).getTime()));
            } else if (values[i] instanceof java.sql.Date) {
                pstmt.setDate(i + 1, (java.sql.Date) values[i]);
            } else if (values[i] instanceof java.sql.Timestamp) {
                pstmt.setTimestamp(i + 1, (java.sql.Timestamp) values[i]);
            } else if (values[i] instanceof byte[]) {
                pstmt.setBytes(i + 1, (byte[]) values[i]);
            } else if (values[i] == null) {
                pstmt.setNull(i + 1, java.sql.Types.NULL);
            } else {
                pstmt.setString(i + 1, values[i].toString());
            }
        }
    }

  //-----------------------------------------------
    // GET SINGLE VALUE METHOD
    //-----------------------------------------------

    public double getSingleValue(String sql, Object... params) {
        double result = 0.0;
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            setPreparedStatementValues(pstmt, params);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getDouble(1);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving single value: " + e.getMessage());
        }
        return result;
    }
    public int addRecordAndReturnId(String query, Object... params) {
        int generatedId = -1;
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            setPreparedStatementValues(pstmt, params);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        }
        return generatedId;
    }
    public java.util.List<java.util.Map<String, Object>> fetchRecords(String sqlQuery, Object... values) {
    java.util.List<java.util.Map<String, Object>> records = new java.util.ArrayList<>();

    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {

        setPreparedStatementValues(pstmt, values);

        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            java.util.Map<String, Object> row = new java.util.TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for (int i = 1; i <= columnCount; i++) {
                row.put(metaData.getColumnLabel(i), rs.getObject(i));
            }
            records.add(row);
        }

    } catch (SQLException e) {
        System.out.println("Error fetching records: " + e.getMessage());
    }

    return records;
}
    // Method to hash passwords using SHA-256
public static String hashPassword(String password) {
    try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        
        // Convert byte array to hex string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
        System.out.println("Error hashing password: " + e.getMessage());
        return null;
    }
}
    public static void main(String[] args) {
        String filename = (args != null && args.length > 0) ? args[0] : "Dishcovery_System_New.db";
        config c = new config();
        c.initializeNewDatabase(filename);
        System.out.println("Initialized SQLite database: " + filename);
    }
    public void displayData(String sql, javax.swing.JTable table, Object... params) {
    Connection conn = connectDB();
    if (conn == null) {
        System.out.println("Error displaying data: Database connection unavailable");
        return;
    }
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        setPreparedStatementValues(pstmt, params);
        try (ResultSet rs = pstmt.executeQuery()) {
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            DefaultTableModel model = new DefaultTableModel();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(meta.getColumnName(i));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            table.setModel(model);
        }
    } catch (SQLException e) {
        System.out.println("Error displaying data: " + e.getMessage());
    } finally {
        try { conn.close(); } catch (Exception ignored) {}
    }
}


    // ============================================
    // PRINT MANAGEMENT AND LOGGING SYSTEM
    // ============================================

    /**
     * Ensures the PrintLogs table exists in the database.
     * This table stores the history of all print actions with user and recipe details.
     */
    public void ensurePrintLogsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS PrintLogs (" +
                "log_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id INTEGER NOT NULL, " +
                "recipe_id INTEGER NOT NULL, " +
                "print_timestamp TEXT NOT NULL, " +
                "print_count INTEGER DEFAULT 1, " +
                "FOREIGN KEY(user_id) REFERENCES Users(u_id), " +
                "FOREIGN KEY(recipe_id) REFERENCES Recipes(r_id)" +
                ")";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("PrintLogs table ensured successfully");
        } catch (SQLException e) {
            System.out.println("Error ensuring PrintLogs table: " + e.getMessage());
        }
    }

    /**
     * Logs a print action to the PrintLogs table.
     * Captures user identity, recipe identification, and timestamp.
     * 
     * @param userId The ID of the user who performed the print
     * @param recipeId The ID of the recipe that was printed
     * @return true if log entry was created successfully, false otherwise
     */
    public boolean logPrintAction(int userId, int recipeId) {
        String sql = "INSERT INTO PrintLogs (user_id, recipe_id, print_timestamp, print_count) VALUES (?, ?, datetime('now'), 1)";
        
        try (Connection conn = connectDB()) {
            if (conn == null) {
                System.out.println("Error logging print action: Database connection unavailable");
                return false;
            }
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, userId);
                pstmt.setInt(2, recipeId);
                pstmt.executeUpdate();
                System.out.println("Print action logged successfully");
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error logging print action: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retrieves print logs for a specific user.
     * 
     * @param userId The ID of the user
     * @return List of print log records
     */
    public java.util.List<java.util.Map<String, Object>> getPrintLogsByUser(int userId) {
        String sql = "SELECT pl.*, u.u_username, r.r_title FROM PrintLogs pl JOIN Users u ON pl.user_id = u.u_id JOIN Recipes r ON pl.recipe_id = r.r_id WHERE pl.user_id = ? ORDER BY pl.print_timestamp DESC";
        return fetchRecords(sql, userId);
    }

    /**
     * Retrieves print logs for a specific recipe.
     * 
     * @param recipeId The ID of the recipe
     * @return List of print log records
     */
    public java.util.List<java.util.Map<String, Object>> getPrintLogsByRecipe(int recipeId) {
        String sql = "SELECT pl.*, u.u_username, r.r_title FROM PrintLogs pl JOIN Users u ON pl.user_id = u.u_id JOIN Recipes r ON pl.recipe_id = r.r_id WHERE pl.recipe_id = ? ORDER BY pl.print_timestamp DESC";
        return fetchRecords(sql, recipeId);
    }

    /**
     * Retrieves all print logs.
     * 
     * @return List of all print log records
     */
    public java.util.List<java.util.Map<String, Object>> getAllPrintLogs() {
        String sql = "SELECT pl.*, u.u_username, r.r_title FROM PrintLogs pl JOIN Users u ON pl.user_id = u.u_id JOIN Recipes r ON pl.recipe_id = r.r_id ORDER BY pl.print_timestamp DESC";
        return fetchRecords(sql);
    }

    /**
     * Gets the print status for a specific user and recipe from PrintLogs.
     * 
     * @param userId The ID of the user
     * @param recipeId The ID of the recipe
     * @return Map containing print status information, or null if not found
     */
    public java.util.Map<String, Object> getPrintStatus(int userId, int recipeId) {
        String sql = "SELECT MAX(print_timestamp) as last_printed, COUNT(*) as total_prints FROM PrintLogs WHERE user_id = ? AND recipe_id = ?";
        java.util.List<java.util.Map<String, Object>> results = fetchRecords(sql, userId, recipeId);
        
        if (results.isEmpty() || results.get(0).get("total_prints") == null || (long)results.get(0).get("total_prints") == 0) {
            return null;
        }
        
        java.util.Map<String, Object> status = results.get(0);
        status.put("print_status", "active"); // For compatibility
        return status;
    }

    /**
     * Checks if a print record exists for the given user and recipe in PrintLogs.
     * 
     * @param userId The ID of the user
     * @param recipeId The ID of the recipe
     * @return true if a print record exists, false otherwise
     */
    public boolean printRecordExists(int userId, int recipeId) {
        String sql = "SELECT 1 FROM PrintLogs WHERE user_id = ? AND recipe_id = ? LIMIT 1";
        return existsRecord(sql, userId, recipeId);
    }

    /**
     * Performs a complete print operation by logging the action to PrintLogs.
     * This is the main method to call when a print action occurs.
     * 
     * @param userId The ID of the user performing the print
     * @param recipeId The ID of the recipe being printed
     * @return true if the print operation was successful, false otherwise
     */
    public boolean performPrint(int userId, int recipeId) {
        return logPrintAction(userId, recipeId);
    }
}
