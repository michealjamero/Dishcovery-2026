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
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try { new dishcovery.landingPage1().setVisible(true); } catch (Throwable t) { }
				}
			});
			if (caller != null) {
				try { caller.dispose(); } catch (Throwable t) { }
			}
		}
	}
}

