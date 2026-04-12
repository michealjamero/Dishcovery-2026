package config;

/**
 * Singleton session container for the currently logged-in user.
 */
public class Session {

	private static Session instance;

	private int id;
	private String fname;
	private String lname;
	private String email;
	private String username;
	private String role;
	private String status;

	private Session() { }

	public static synchronized Session getInstance() {
		if (instance == null) instance = new Session();
		return instance;
	}

	public boolean isLoggedIn() {
		return username != null && !username.trim().isEmpty();
	}

	public void clear() {
		id = 0;
		fname = lname = email = username = role = status = null;
		instance = null;
	}

	public static void logout(final javax.swing.JFrame caller) {
		if (instance != null) {
			instance.clear();
		}
		
		// Close all open windows to ensure a clean logout and avoid duplicates
		for (java.awt.Window window : java.awt.Window.getWindows()) {
			window.dispose();
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new dishcovery.landingPage1().setVisible(true);
			}
		});
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getFname() { return fname; }
	public void setFname(String fname) { this.fname = fname; }

	public String getLname() { return lname; }
	public void setLname(String lname) { this.lname = lname; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }

	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

	public static void requireLogin(final javax.swing.JFrame caller) {
		Session s = instance;
		boolean logged = (s != null && s.isLoggedIn());
		if (!logged) {
			if (caller != null && !(caller instanceof dishcovery.landingPage1) && !(caller instanceof dishcovery.login)) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try { 
							// Check if a landing page is already visible to avoid duplicates
							for (java.awt.Window window : java.awt.Window.getWindows()) {
								if (window instanceof dishcovery.landingPage1 && window.isVisible()) {
									return;
								}
							}
							new dishcovery.landingPage1().setVisible(true); 
						} catch (Throwable t) { }
					}
				});
				try { caller.dispose(); } catch (Throwable t) { }
			}
		}
	}

	public static void requireAdmin(final javax.swing.JFrame caller) {
		requireLogin(caller);
		Session s = instance;
		if (s != null && s.isLoggedIn() && !"Admin".equalsIgnoreCase(s.getRole())) {
			javax.swing.JOptionPane.showMessageDialog(caller, "Access Denied: Admin role required.");
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new dishcovery.homePage2().setVisible(true);
				}
			});
			try { caller.dispose(); } catch (Throwable t) { }
		}
	}
}

