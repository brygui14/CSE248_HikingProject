package Test1;

import java.util.Hashtable;

public class UserBag {
	
	private static Hashtable<String, User> userData = new Hashtable<String, User>();
	
	
	public static void addHash(User user) {
		userData.put(user.getUsername(), user);
	}
	
	public static void displayHash() {
		System.out.println(userData.toString());
	}
	
	public static boolean searchHash(String userName) {	
		return userData.containsKey(userName);
	}
	
	
}