package Test1;

import java.util.Hashtable;
import java.util.LinkedList; 

public class UserBag {
	
	private static Hashtable<String, User> userData = new Hashtable<String, User>();
	private static LinkedList<User> userDataLink =  new LinkedList<User>();
	
	
	public static void addHash(User user) {
		userData.put(user.getUsername(), user);
	}
	
	public static void displayHash() {
		System.out.println(userData.toString());
	}
	
	public static boolean searchHash(String userName) {	
		return userData.containsKey(userName);
	}
	
	public static void addLink(User user) {
		userDataLink.add(user);
	}
	
	public static boolean searchLink(String userName) {
		for(int i = 0; i < userDataLink.size(); i++) {
			if(userDataLink.get(i).getUsername() == userName) {
				return true;
			}
		}
		return false; 
	}
	
}