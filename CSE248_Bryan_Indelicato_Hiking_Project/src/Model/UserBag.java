package Model;

import java.util.Map;
import java.util.TreeMap;

public class UserBag {
	
	private static TreeMap<String, User> userData = new TreeMap<String, User>();
	
	
	public static boolean addUser(User user) {
		userData.put(user.getUsername(), user);
		return true;
	}
	
	public static void displayUserBag() {
		System.out.println(userData.toString());
	}
	
	/**
	 * Searches for User by username string
	 * @param userName
	 * @return
	 */
	public static User searchUser(String userName) {	
		for(Map.Entry<String, User> entry : userData.entrySet()) {
			User user = entry.getValue();
			if(user.getUsername() == userName) {
				return user;
			}
		}
		return null;
	}
	
	
	/**
	 * Validates that the User has entered the right username and password 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean checkUserLogin(String username, String password) {
		if(userData.containsKey(username)) {
			User temp = userData.get(username);
			if(temp.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static User setUser(String username) {
		return userData.get(username);
	}
	
	public static TreeMap<String, User> getUserBag() {
		return userData;
	}
	
	public static boolean remove(User user) {
		userData.remove(user.getUsername());
		return true;
	}
	
}