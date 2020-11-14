package Test1;

import java.util.Map;
import java.util.TreeMap;

public class UserBag {
	
	private static TreeMap<String, User> userData = new TreeMap<String, User>();
	
	
	public static void addHash(User user) {
		userData.put(user.getUsername(), user);
	}
	
	public static void displayHash() {
		System.out.println(userData.toString());
	}
	
	public static boolean searchTree(String userName) {	
		for(Map.Entry<String, User> entry : userData.entrySet()) {
			User user = entry.getValue();
			if(user.getUsername() == userName) {
				return true;
			}
		}
		return false;
	}
	
	
}