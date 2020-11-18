package Model;

import java.awt.image.BufferedImage;

/**
 * @author bryanindelicato
 *
 */
public class User {
	
	private boolean adminStatus; 
	private String username, password;
	private BufferedImage picture;
	private HikingHistoryBag hikingHistoryBag;

	public User() {
		this.adminStatus = false;
		this.username = null;
		this.password = null;
		this.picture = null;
		this.hikingHistoryBag = new HikingHistoryBag();
	}
	
	public boolean isAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}

	/**
	 * Creates User Object
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.picture = null;
		this.hikingHistoryBag = new HikingHistoryBag();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public BufferedImage getPicture() {
		return picture;
	}

	public void setPicture(BufferedImage picture) {
		this.picture = picture;
	}
	
	public HikingHistoryBag getHikingHistoryBag() {
		return hikingHistoryBag;
	}

	public void setHikingHistoryBag(HikingHistoryBag hikingHistoryBag) {
		this.hikingHistoryBag = hikingHistoryBag;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	public void addHike(HikingHistory hh) {
		this.hikingHistoryBag.add(hh);
	}

}
