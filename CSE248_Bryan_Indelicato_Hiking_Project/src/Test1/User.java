package Test1;

import java.awt.image.BufferedImage;

public class User {
	

	private String username, password;
	private BufferedImage picture;
	private HikingHistoryBag hikingHistoryBag;

	public User() {
		this.username = null;
		this.password = null;
		this.picture = null;
		this.hikingHistoryBag = new HikingHistoryBag();
	}
	
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
	
	
	

}
